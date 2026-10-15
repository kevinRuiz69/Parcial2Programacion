import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Venta {
    private String codigo;
    private LocalDate fecha;
    private Cliente cliente;
    private Empleado vendedor;
    private Sucursal sucursal;
    private List<DetalleVenta> listaDetalles;
    private boolean confirmada;

    public Venta(String codigo, LocalDate fecha, Cliente cliente,
                 Empleado vendedor, Sucursal sucursal) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.sucursal = sucursal;
        this.listaDetalles = new ArrayList<>();
        this.confirmada = false;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getVendedor() {
        return vendedor;
    }

    public void setVendedor(Empleado vendedor) {
        this.vendedor = vendedor;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public List<DetalleVenta> getListaDetalles() {
        return listaDetalles;
    }

    public void setListaDetalles(List<DetalleVenta> listaDetalles) {
        this.listaDetalles = listaDetalles;
    }

    public boolean isConfirmada() {
        return confirmada;
    }

    // Métodos de lógica

    public boolean agregarDetalle(DetalleVenta detalle) {
        if (confirmada || detalle == null) {
            return false;
        }

        listaDetalles.add(detalle);
        return true;
    }

    public boolean agregarDetalle(RegistroInventario inventario, int cantidad) {
        if (confirmada || cliente == null || inventario == null
                || inventario.getPrenda() == null || cantidad <= 0) {
            return false;
        }

        double precioUnitarioConRecargo = inventario.getPrenda().calcularPrecioConRecargo();
        double subtotal = cantidad * precioUnitarioConRecargo;
        DetalleVenta detalle = new DetalleVenta(
                inventario, cantidad, precioUnitarioConRecargo, subtotal);
        return agregarDetalle(detalle);
    }

    public boolean verificarDisponibilidadTotal() {
        if (listaDetalles.size() == 0 || sucursal == null) {
            return false;
        }

        for (int i = 0; i < listaDetalles.size(); i++) {
            if (listaDetalles.get(i) == null) {
                return false;
            }

            RegistroInventario inventario = listaDetalles.get(i).getInventario();
            if (inventario == null || listaDetalles.get(i).getCantidadComprada() <= 0) {
                return false;
            }

            if (inventario.getSucursal() != sucursal) {
                return false;
            }

            int cantidadTotal = calcularCantidadSolicitada(inventario);
            if (!inventario.tieneStockSuficiente(cantidadTotal)) {
                return false;
            }
        }

        return true;
    }

    public boolean confirmarVenta() {
        if (confirmada || !verificarDisponibilidadTotal()) {
            return false;
        }

        for (int i = 0; i < listaDetalles.size(); i++) {
            DetalleVenta detalle = listaDetalles.get(i);
            detalle.getInventario().descontarExistencias(detalle.getCantidadComprada());
            detalle.getInventario().registrarDetalleVendido(detalle);
        }

        if (sucursal.getListaVentas() == null) {
            sucursal.setListaVentas(new ArrayList<>());
        }
        sucursal.getListaVentas().add(this);
        confirmada = true;
        return true;
    }

    public double calcularValorTotal() {
        double total = 0;
        for (DetalleVenta detalle : listaDetalles) {
            total += detalle.calcularSubtotal();
        }
        return total-(total*cliente.obtenerDescuento());
    }

    private int calcularCantidadSolicitada(RegistroInventario inventario) {
        int cantidadTotal = 0;

        for (int i = 0; i < listaDetalles.size(); i++) {
            if (listaDetalles.get(i).getInventario() == inventario) {
                cantidadTotal = cantidadTotal
                        + listaDetalles.get(i).getCantidadComprada();
            }
        }

        return cantidadTotal;
    }
}

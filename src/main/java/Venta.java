import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Venta {
    private String codigo;
    private LocalDate fecha;
    private Cliente cliente;
    private Empleado empleado;
    private Sucursal sucursal;
    private List<DetalleVenta> listaDetalles;

    public Venta(String codigo, LocalDate fecha, Cliente cliente, Empleado empleado, Sucursal sucursal) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.cliente = cliente;
        this.empleado = empleado;
        this.sucursal = sucursal;
        this.listaDetalles = new ArrayList<>();
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

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
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

    // Métodos pendientes

    public void agregarDetalle(DetalleVenta detalle) {
    }

    public boolean verificarDisponibilidadTotal() {
        return false;
    }

    public boolean confirmarVenta() {
        return false;
    }

    public double calcularValorTotal() {
        return 0;
    }
}
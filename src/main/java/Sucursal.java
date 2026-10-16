import java.util.ArrayList;
import java.util.List;

public class Sucursal {
    private String codigo;
    private String nombre;
    private String direccion;
    private String ciudad;
    //Relaciones
    private List<RegistroInventario> listaInventario;
    private List<Venta> listaVentas;
    private List<Empleado> listaEmpleados;

    public Sucursal(String codigo, String nombre, String direccion, String ciudad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.listaInventario = new ArrayList<>();
        this.listaVentas = new ArrayList<>();
        this.listaEmpleados = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public List<RegistroInventario> getListaInventario() {
        return listaInventario;
    }

    public void setListaInventario(List<RegistroInventario> listaInventario) {
        if (listaInventario == null) {
            this.listaInventario = new ArrayList<>();
        } else {
            this.listaInventario = listaInventario;
        }
    }

    public List<Venta> getListaVentas() {
        return listaVentas;
    }

    public void setListaVentas(List<Venta> listaVentas) {
        if (listaVentas == null) {
            this.listaVentas = new ArrayList<>();
        } else {
            this.listaVentas = listaVentas;
        }
    }

    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(List<Empleado> listaEmpleados) {
        if (listaEmpleados == null) {
            this.listaEmpleados = new ArrayList<>();
        } else {
            this.listaEmpleados = listaEmpleados;
        }
    }

    //METODO REGISTRAR EXISTENCIA
    public boolean registrarExistencia(Prenda prenda, String talla,
                                       String color, int cantidad){
        if (prenda == null || talla == null || talla.length() == 0
                || color == null || color.length() == 0 || cantidad <= 0) {
            return false;
        }

        if (verificarExistencia(prenda, talla, color)) {
            return false;
        }

        if (prenda.getListaInventario() == null) {
            prenda.setListaInventario(new ArrayList<>());
        }

        RegistroInventario nuevoInventario = new RegistroInventario(
                color, cantidad, prenda, this, talla);
        listaInventario.add(nuevoInventario);
        prenda.getListaInventario().add(nuevoInventario);
        return true;
    }

    public boolean verificarExistencia(Prenda prenda, String talla, String color) {
        for (RegistroInventario inventario : listaInventario) {
            if (inventario.getPrenda().getCodigo().equalsIgnoreCase(prenda.getCodigo())
                    && inventario.getTalla().equalsIgnoreCase(talla)
                    && inventario.getColor().equalsIgnoreCase(color)) {
                return true;
            }
        }
        return false;
    }

    //METODO PRENDAS DISPONIBLES
    public List<RegistroInventario> consultarPrendasDisponibles(){
        List<RegistroInventario> listaDisponibles = new ArrayList<>();

        for (RegistroInventario inventario : listaInventario) {
            if (inventario.getCantidadDisponible() > 0) {
                listaDisponibles.add(inventario);
            }
        }

        return listaDisponibles;
    }

    //METODO REGISTRAR VENTAS
    public boolean registrarVenta(Venta venta){
        if (venta == null || venta.getSucursal() != this || !venta.isConfirmada()
                || verificarVenta(venta.getCodigo())) {
            return false;
        }
        listaVentas.add(venta);
        return true;
    }

    public boolean verificarVenta(String codigo) {
        for (Venta venta : listaVentas) {
            if (venta.getCodigo().equalsIgnoreCase(codigo)) {
                return true;
            }
        }
        return false;
    }

    //METODO CALCULAR INGRESO
    public double calcularIngresosTotales(){
        double total = 0;
        for (Venta venta : listaVentas) {
            if (venta != null && venta.isConfirmada()) {
                total = total + venta.calcularValorTotal();
            }
        }
        return total;
    }

    @Override
    public String toString() {
        return "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", listaInventario=" + listaInventario +
                ", listaVentas=" + listaVentas +
                ", listaEmpleados=" + listaEmpleados;
    }
}

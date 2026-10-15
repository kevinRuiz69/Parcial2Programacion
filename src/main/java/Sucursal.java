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

    public Sucursal(String codigo, String nombre, String direccion, String ciudad, List<RegistroInventario> listaInventario, List<Venta> listaVentas, List<Empleado> listaEmpleados) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.listaInventario = listaInventario;
        this.listaVentas = listaVentas;
        this.listaEmpleados = listaEmpleados;
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
        this.listaInventario = listaInventario;
    }

    public List<Venta> getListaVentas() {
        return listaVentas;
    }

    public void setListaVentas(List<Venta> listaVentas) {
        this.listaVentas = listaVentas;
    }

    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    //METODO EXISTENCIA
    public boolean registarExistencia (Prenda prenda,String talla,String color,int cantidad){
    return false;
    }

    //METODO PRENDAS DISPONIBLES
    public int consultarPrendasDisponibles(){

    }

    //METODO REGISTRAR VENTAS
    public boolean registrarVenta(Venta venta){
        return false;
    }

    //METODO CALCULAR INGRESO
    public double calcularIngresosTotales(){

    }

    @Override
    public String toString() {
        return codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", listaInventario=" + listaInventario +
                ", listaVentas=" + listaVentas +
                ", listaEmpleados=" + listaEmpleados;
    }
}

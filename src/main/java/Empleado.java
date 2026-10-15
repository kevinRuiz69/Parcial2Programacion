import java.util.Date;
import java.util.List;

public class Empleado extends PersonaVinculada {

    private String codigoEmpleado;
    private Date fechaContratacion;
    private double salarioBasico;

//RELACIONES

    private Sucursal sucursal;
    private List<Venta>  listaVentas;


    public Empleado(String documento, String nombreCompleto, String correo, String telefono,
                    String codigoEmpleado, Date fechaContratacion, double salarioBasico, Sucursal sucursal, List<Venta> listaVentas) {
        super(documento, nombreCompleto, correo, telefono);
        this.codigoEmpleado = codigoEmpleado;
        this.fechaContratacion = fechaContratacion;
        this.salarioBasico = salarioBasico;
        this.sucursal = sucursal;
        this.listaVentas = listaVentas;
    }

    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(String codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public Date getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(Date fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public double getSalarioBasico() {
        return salarioBasico;
    }

    public void setSalarioBasico(double salarioBasico) {
        this.salarioBasico = salarioBasico;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public List<Venta> getListaVentas() {
        return listaVentas;
    }

    public void setListaVentas(List<Venta> listaVentas) {
        this.listaVentas = listaVentas;
    }

    @Override
    public String toString() {
        return "codigoEmpleado='" + codigoEmpleado + '\'' +
                ", fechaContratacion=" + fechaContratacion +
                ", salarioBasico=" + salarioBasico +
                ", sucursal=" + sucursal +
                ", listaVentas=" + listaVentas;
    }
}

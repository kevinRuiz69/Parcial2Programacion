public class Cliente  extends PersonaVinculada{
    private String codigoAfiliacion;

    //RELACION
    private categoria CategoriaCliente;

    public Cliente(String documento, String nombreCompleto, String correo, String telefono, String codigoAfiliacion,CategoriaCliente categoria) {
        super(documento, nombreCompleto, correo, telefono);
        this.codigoAfiliacion = codigoAfiliacion;
        this.categoria= CategoriaCliente;
    }

    public String getCodigoAfiliacion() {
        return codigoAfiliacion;
    }

    public void setCodigoAfiliacion(String codigoAfiliacion) {
        this.codigoAfiliacion = codigoAfiliacion;
    }

    public categoria getCategoriaCliente() {
        return CategoriaCliente;
    }

    public void setCategoriaCliente(categoria categoriaCliente) {
        CategoriaCliente = categoriaCliente;
    }

    public double obtenerDescuento(){

    }
}

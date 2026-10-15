public class Cliente  extends PersonaVinculada{
    private String codigoAfiliacion;

    //RELACION
    private CategoriaCliente CategoriaCliente;

    public Cliente(String documento, String nombreCompleto, String correo, String telefono, String codigoAfiliacion,CategoriaCliente categoria) {
        super(documento, nombreCompleto, correo, telefono);
        this.codigoAfiliacion = codigoAfiliacion;
        this.CategoriaCliente= CategoriaCliente;
    }

    public String getCodigoAfiliacion() {
        return codigoAfiliacion;
    }

    public void setCodigoAfiliacion(String codigoAfiliacion) {
        this.codigoAfiliacion = codigoAfiliacion;
    }

    public CategoriaCliente getCategoriaCliente() {
        return CategoriaCliente;
    }

    public void setCategoriaCliente(CategoriaCliente categoriaCliente) {
        CategoriaCliente = categoriaCliente;
    }

    public double obtenerDescuento(){
        return 0;
    }
}

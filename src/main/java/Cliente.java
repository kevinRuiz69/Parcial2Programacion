public class Cliente  extends PersonaVinculada{
    private String codigoAfiliacion;

    //RELACION
    private CategoriaCliente categoriaCliente;

    public Cliente(String documento, String nombreCompleto, String correo, String telefono, String codigoAfiliacion,CategoriaCliente categoria) {
        super(documento, nombreCompleto, correo, telefono);
        this.codigoAfiliacion = codigoAfiliacion;
        this.categoriaCliente = categoria;
    }

    public String getCodigoAfiliacion() {
        return codigoAfiliacion;
    }

    public void setCodigoAfiliacion(String codigoAfiliacion) {
        this.codigoAfiliacion = codigoAfiliacion;
    }

    public CategoriaCliente getCategoriaCliente() {
        return categoriaCliente;
    }

    public void setCategoriaCliente(CategoriaCliente categoriaCliente) {
        this.categoriaCliente = categoriaCliente;
    }

    public double obtenerDescuento(){
        if (categoriaCliente == null) {
            return 0;
        }
        return categoriaCliente.getDescuento();
    }
}

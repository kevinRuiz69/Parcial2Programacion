import java.util.ArrayList;
import java.util.List;

public class Cliente  extends PersonaVinculada{
    private String codigoAfiliacion;

    //RELACION
    private CategoriaCliente categoriaCliente;
    private List<Venta> listaCompras;

    public Cliente(String documento, String nombreCompleto, String correo, String telefono, String codigoAfiliacion,CategoriaCliente categoria) {
        super(documento, nombreCompleto, correo, telefono);
        this.codigoAfiliacion = codigoAfiliacion;
        this.categoriaCliente = categoria;
        this.listaCompras = new ArrayList<>();
    }

    public String getCodigoAfiliacion() {
        return codigoAfiliacion;
    }

    public void setCodigoAfiliacion(String codigoAfiliacion) {
        this.codigoAfiliacion = codigoAfiliacion;
    }

    public CategoriaCliente getCategoria() {
        return categoriaCliente;
    }

    public void setCategoria(CategoriaCliente categoriaCliente) {
        this.categoriaCliente = categoriaCliente;
    }

    public List<Venta> getListaCompras() {
        return listaCompras;
    }

    public void setListaCompras(List<Venta> listaCompras) {
        if (listaCompras == null) {
            this.listaCompras = new ArrayList<>();
        } else {
            this.listaCompras = listaCompras;
        }
    }

    public double obtenerDescuento(){
        if (categoriaCliente == null) {
            return 0;
        }
        return categoriaCliente.getDescuento();
    }

}

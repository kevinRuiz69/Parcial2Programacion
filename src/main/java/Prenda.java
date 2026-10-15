import java.util.ArrayList;
import java.util.List;

public class Prenda {
    private String codigo;
    private String nombre;
    private String marca;
    private double precioBase;
    //Relaciones
    private CategoriaPrenda categoria;
    private List<registroInventario> listaInventario;

    public Prenda(String codigo, String nombre, String marca, double precioBase, CategoriaPrenda categoria) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.marca = marca;
        this.precioBase = precioBase;
        this.categoria = categoria;
        this.listaInventario = new ArrayList<>();
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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public CategoriaPrenda getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaPrenda categoria) {
        this.categoria = categoria;
    }

    public List<registroInventario> getListaInventario() {
        return listaInventario;
    }

    public void setListaInventario(List<registroInventario> listaInventario) {
        this.listaInventario = listaInventario;
    }

    //METODO CALCULAR PRECIO CON RECARGO
    public double calcularPrecioRecargo(){

    }

    //METODO UNIDADES VENDIDAS
    public int calcularTotalUnidadesVendidas(){

    }

    @Override
    public String toString() {
        return "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", marca='" + marca + '\'' +
                ", precioBase=" + precioBase +
                ", categoria=" + categoria +
                ", listaInventario=" + listaInventario;
    }
}




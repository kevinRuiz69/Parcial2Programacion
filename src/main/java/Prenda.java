import java.util.ArrayList;
import java.util.List;

public class Prenda {
    private String codigo;
    private String nombre;
    private String marca;
    private double precioBase;
    //Relaciones
    private CategoriaPrenda categoria;
    private List<RegistroInventario> listaInventario;

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

    public List<RegistroInventario> getListaInventario() {
        return listaInventario;
    }

    public void setListaInventario(List<RegistroInventario> listaInventario) {
        this.listaInventario = listaInventario;
    }
}

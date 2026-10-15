import java.util.ArrayList;
import java.util.List;

public class RegistroInventario {
    private String color;
    private int cantidadDisponible;

    //RELACONES
    public Prenda prenda;
    private Sucursal sucursal;
    private TallaPrenda tallaPrenda;
    private List<DetalleVenta> listaDetallesVendidos;

    public RegistroInventario(String color, int cantidadDisponible, Prenda prenda, Sucursal sucursal, TallaPrenda tallaPrenda) {
        this.color = color;
        this.cantidadDisponible = cantidadDisponible;
        this.prenda = prenda;
        this.sucursal = sucursal;
        this.tallaPrenda = tallaPrenda;
        this.listaDetallesVendidos = new ArrayList<>();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public Prenda getPrenda() {
        return prenda;
    }

    public void setPrenda(Prenda prenda) {
        this.prenda = prenda;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public TallaPrenda getTallaPrenda() {
        return tallaPrenda;
    }

    public void setTallaPrenda(TallaPrenda tallaPrenda) {
        this.tallaPrenda = tallaPrenda;
    }

    public List<DetalleVenta> getListaDetallesVendidos() {
        return listaDetallesVendidos;
    }

    public void setListaDetallesVendidos(List<DetalleVenta> listaDetallesVendidos) {
        this.listaDetallesVendidos = listaDetallesVendidos;
    }

    // METODO STOCK SUFICIENTE
    public boolean tieneStockSuficiente(int cantidad){
        return cantidad > 0 && cantidadDisponible >= cantidad;
    }

    //METODO DESCONTAR EXISTENCIA
    public void descontarExistencias(int cantidad){
        if (tieneStockSuficiente(cantidad)) {
            cantidadDisponible = cantidadDisponible - cantidad;
        }
    }

    public void registrarDetalleVendido(DetalleVenta detalle) {
        listaDetallesVendidos.add(detalle);
    }

    @Override
    public String toString() {
        return "color='" + color + '\'' +
                ", cantidadDisponible=" + cantidadDisponible +
                ", prenda=" + prenda +
                ", Sucursal=" + sucursal +
                ", tallaPrenda=" + tallaPrenda;
    }
}

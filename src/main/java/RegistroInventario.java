import java.util.ArrayList;
import java.util.List;

public class RegistroInventario {
    private String color;
    private int cantidadDisponible;

    //RELACONES
    private Prenda prenda;
    private Sucursal sucursal;
    private String talla;
    private List<DetalleVenta> listaDetallesVendidos;

    public RegistroInventario(String color, int cantidadDisponible, Prenda prenda, Sucursal sucursal, String talla) {
        this.color = color;
        this.cantidadDisponible = cantidadDisponible;
        this.prenda = prenda;
        this.sucursal = sucursal;
        this.talla = talla;
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

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public List<DetalleVenta> getListaDetallesVendidos() {
        return listaDetallesVendidos;
    }

    public void setListaDetallesVendidos(List<DetalleVenta> listaDetallesVendidos) {
        if (listaDetallesVendidos == null) {
            this.listaDetallesVendidos = new ArrayList<>();
        } else {
            this.listaDetallesVendidos = listaDetallesVendidos;
        }
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
        if (detalle != null) {
            if (listaDetallesVendidos == null) {
                listaDetallesVendidos = new ArrayList<>();
            }
            listaDetallesVendidos.add(detalle);
        }
    }

    @Override
    public String toString() {
        return "Prenda: " + prenda.getNombre() +
                ", codigo: " + prenda.getCodigo() +
                ", talla: " + talla +
                ", color: " + color +
                ", disponibles: " + cantidadDisponible +
                ", sucursal: " + sucursal.getNombre();
    }
}

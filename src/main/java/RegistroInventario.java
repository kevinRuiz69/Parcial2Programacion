public class RegistroInventario {
    private String color;
    private int cantidadDisponible;

    //RELACONES
    public Prenda prenda;
    public Sucursal Sucursal;
    private TallaPrenda tallaPrenda;

    public RegistroInventario(String color, int cantidadDisponible, Prenda prenda, Sucursal sucursal, TallaPrenda tallaPrenda) {
        this.color = color;
        this.cantidadDisponible = cantidadDisponible;
        this.prenda = prenda;
        this.Sucursal = sucursal;
        this.tallaPrenda = tallaPrenda;
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
        return Sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        Sucursal = sucursal;
    }

    public TallaPrenda getTallaPrenda() {
        return tallaPrenda;
    }

    public void setTallaPrenda(TallaPrenda tallaPrenda) {
        this.tallaPrenda = tallaPrenda;
    }

    // METODO STOCK SUFICIENTE
    public boolean tieneStockSuficiente(int cantidad){
        return false;
    }

    //METODO DESCONTAR EXISTENCIA
    public void descontarExistencia( int cantidad){

    }

    @Override
    public String toString() {
        return "color='" + color + '\'' +
                ", cantidadDisponible=" + cantidadDisponible +
                ", prenda=" + prenda +
                ", Sucursal=" + Sucursal +
                ", tallaPrenda=" + tallaPrenda;
    }
}

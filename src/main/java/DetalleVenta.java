public class DetalleVenta {
    private RegistroInventario inventario;
    private int cantidadComprada;
    private double precioUnitarioFinal;
    private double subtotal;

    public DetalleVenta(RegistroInventario inventario, int cantidadComprada,
                        double precioUnitarioFinal, double subtotal) {
        this.inventario = inventario;
        this.cantidadComprada = cantidadComprada;
        this.precioUnitarioFinal = precioUnitarioFinal;
        this.subtotal = subtotal;
    }

    public RegistroInventario getInventario() {
        return inventario;
    }

    public void setInventario(RegistroInventario inventario) {
        this.inventario = inventario;
    }

    public int getCantidadComprada() {
        return cantidadComprada;
    }

    public void setCantidadComprada(int cantidadComprada) {
        this.cantidadComprada = cantidadComprada;
        this.subtotal = cantidadComprada * precioUnitarioFinal;
    }

    public double getPrecioUnitarioFinal() {
        return precioUnitarioFinal;
    }

    public void setPrecioUnitarioFinal(double precioUnitarioFinal) {
        this.precioUnitarioFinal = precioUnitarioFinal;
        this.subtotal = cantidadComprada * precioUnitarioFinal;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    // Métodos de lógica
    public double calcularSubtotal() {
        return cantidadComprada * precioUnitarioFinal;
    }
}

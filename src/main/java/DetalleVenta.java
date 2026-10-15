public class DetalleVenta {
    private RegistroInventario inventario;
    private int cantidadComprada;
    private double precioUnitarioConRecargo;
    private double subtotal;

    public DetalleVenta(RegistroInventario inventario, int cantidadComprada,
                        double precioUnitarioConRecargo, double subtotal) {
        this.inventario = inventario;
        this.cantidadComprada = cantidadComprada;
        this.precioUnitarioConRecargo = precioUnitarioConRecargo;
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
        this.subtotal = cantidadComprada * precioUnitarioConRecargo;
    }

    public double getPrecioUnitarioConRecargo() {
        return precioUnitarioConRecargo;
    }

    public void setPrecioUnitarioConRecargo(double precioUnitarioConRecargo) {
        this.precioUnitarioConRecargo = precioUnitarioConRecargo;
        this.subtotal = cantidadComprada * precioUnitarioConRecargo;
    }

    public double getSubtotal() {
        return subtotal;
    }

    // Métodos de lógica
    public double calcularSubtotal() {
        return cantidadComprada * precioUnitarioConRecargo;
    }
}

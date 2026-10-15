public enum CategoriaPrenda {
    CAMISETA(0),
    PANTALON(0),
    VESTIDO(0.1),
    CHAQUETAS(0.15),
    CALZADO(0.05);
    private final double recargo;
    CategoriaPrenda (double recargo){
        this.recargo=recargo;
    }

    public double getRecargo() {
        return recargo;
    }
}

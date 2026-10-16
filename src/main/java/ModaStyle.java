import java.util.ArrayList;
import java.util.List;

public class ModaStyle {
    private String nombreComercial;
    private String nit;
    private String direccionPrincipal;

    //RELACIONES

    private List<Sucursal>  listaSucursales;
    private List<Prenda>  listaPrendas;
    private List<PersonaVinculada>  listaPersonas;

    public ModaStyle(String nombreComercial, String nit, String direccionPrincipal) {
        this.nombreComercial = nombreComercial;
        this.nit = nit;
        this.direccionPrincipal = direccionPrincipal;
        this.listaSucursales= new ArrayList<>();
        this.listaPrendas= new ArrayList<>();
        this.listaPersonas=new ArrayList<>();
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDireccionPrincipal() {
        return direccionPrincipal;
    }

    public void setDireccionPrincipal(String direccionPrincipal) {
        this.direccionPrincipal = direccionPrincipal;
    }

    public List<Sucursal> getListaSucursales() {
        return listaSucursales;
    }

    public void setListaSucursales(List<Sucursal> listaSucursales) {
        this.listaSucursales = listaSucursales;
    }

    public List<Prenda> getListaPrendas() {
        return listaPrendas;
    }

    public void setListaPrendas(List<Prenda> listaPrendas) {
        this.listaPrendas = listaPrendas;
    }

    public List<PersonaVinculada> getListaPersonas() {
        return listaPersonas;
    }

    public void setListaPersonas(List<PersonaVinculada> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }

    //METODO REGISTRAR SUCURSAL

    public boolean registrarSucursal(Sucursal sucursal){
        if (buscarSucursal(sucursal.getCodigo()) == null) {
            listaSucursales.add(sucursal);
            return true;
        }
        return false;
    }

    //METODO REGISTRAR PRENDA
    public boolean registrarPrenda(Prenda prenda){
        if (buscarPrenda(prenda.getCodigo()) == null) {
            listaPrendas.add(prenda);
            return true;
        }
        return false;
    }

    //METODO BUSCAR SUCURSAL
    public Sucursal buscarSucursal(String codigo){
        for (Sucursal sucursal : listaSucursales) {
            if (codigo.equalsIgnoreCase(sucursal.getCodigo())) {
                return sucursal;
            }
        }
        return null;
    }

    //METODO BUSCAR PRENDA
    public Prenda buscarPrenda(String codigo){
        for (Prenda prenda : listaPrendas) {
            if (codigo.equalsIgnoreCase(prenda.getCodigo())) {
                return prenda;
            }
        }
        return null;
    }

    //METODO REGISTRAR PERSONA
    public boolean registrarPersona(PersonaVinculada persona){
        if (buscarPersona(persona.getDocumento()) == null) {
            listaPersonas.add(persona);
            return true;
        }
        return false;
    }
    //METODO BUSCAR PERSONA
    public PersonaVinculada buscarPersona (String documento){
        for (PersonaVinculada persona: listaPersonas){
            if (documento.equalsIgnoreCase(persona.getDocumento())){
                return persona;
            }
        }
        return null;
    }
    //METODO PRENDAS AGOTADAS
    public List<RegistroInventario> consultarPrendasAgotadas(){
        List<RegistroInventario> listaAgotadas = new ArrayList<>();

        for (Sucursal sucursal : listaSucursales) {
            if (sucursal.getListaInventario() != null) {
                for (RegistroInventario inventario : sucursal.getListaInventario()) {
                    if (inventario.getCantidadDisponible() == 0) {
                        listaAgotadas.add(inventario);
                    }
                }
            }
        }

        return listaAgotadas;
    }

    //METODO PRENDA MAS VENDIDAD
    public Prenda obtenerPrendaMasVendida(){
        if (listaPrendas.size() == 0) {
            return null;
        }

        Prenda prendaMasVendida = listaPrendas.get(0);

        for (int i = 1; i < listaPrendas.size(); i++) {
            if (listaPrendas.get(i).calcularTotalUnidadesVendidas()
                    > prendaMasVendida.calcularTotalUnidadesVendidas()) {
                prendaMasVendida = listaPrendas.get(i);
            }
        }

        return prendaMasVendida;
    }

    @Override
    public String toString() {
        return "nombreComercial='" + nombreComercial + '\'' +
                ", nit='" + nit + '\'' +
                ", direccionPrincipal='" + direccionPrincipal + '\'' +
                ", listaSucursales=" + listaSucursales +
                ", listaPrendas=" + listaPrendas +
                ", listaPersonas=" + listaPersonas;
    }
}

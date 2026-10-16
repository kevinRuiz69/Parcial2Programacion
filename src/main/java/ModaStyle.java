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
    private List<RegistroInventario>  listainventarios;


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

    public boolean registrarSucursal( Sucursal sucursal){
     return  false;
    }

    //METODO REGISTRAR PRENDA
    public boolean registrarPrenda( Prenda prenda){
      return false;
    }

    //METODO REGISTRAR PERSONA
    public boolean registrarPersona(PersonaVinculada persona){
      return false;
    }

    //METODO PRENDAS AGOTADAS
    public boolean consultarPrendasAgotadas(){
        boolean agotadas= false;
        for(RegistroInventario i:listainventarios){
            if(i.getCantidadDisponible()==0){
                System.out.println(i.getPrenda().getNombre());
                agotadas=true;
            }
        }
        return agotadas;
    }

    //METODO PRENDA MAS VENDIDAD
    public Prenda obtenerPrendaMasVendida() {
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

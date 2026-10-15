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

    public boolean registrarSucursal( Sucursal sucursal){
     return  false;
    }

    //METODO REGISTRAR PRENDA
    public boolean registrarPrenda( Prenda prenda){
      return false;
    }

    //METODO REGISTRAR PERSONA
    public boolean registrarPersona(PersonaVinculada persona){
        if (buscarPersona(persona.getDocumento()) == null) {
            listaPersonas.add(persona);
            return true;
        }
        return false;
    }
    //METODO VERIFICAR PERSONA
    public PersonaVinculada buscarPersona (String documento){
        for (PersonaVinculada persona: listaPersonas){
            if (documento.equalsIgnoreCase(persona.getDocumento())){
                return persona;
            }
        }
        return null;
    }
    //METODO PRENDAS AGOTADAS
    public boolean consultarPrendasAgotadas(){
        for (Prenda prenda: listaPrendas){
            for (Sucursal sucursal: listaSucursales){
                for(RegistroInventario inventario: sucursal.getListaInventario()){
                    if(prenda.getCodigo().equalsIgnoreCase(inventario.getPrenda(prenda.getCodigo()))){

                    }
                }
            }
        }
        return false;
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

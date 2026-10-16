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
        if (listaSucursales == null) {
            this.listaSucursales = new ArrayList<>();
        } else {
            this.listaSucursales = listaSucursales;
        }
    }

    public List<Prenda> getListaPrendas() {
        return listaPrendas;
    }

    public void setListaPrendas(List<Prenda> listaPrendas) {
        if (listaPrendas == null) {
            this.listaPrendas = new ArrayList<>();
        } else {
            this.listaPrendas = listaPrendas;
        }
    }

    public List<PersonaVinculada> getListaPersonas() {
        return listaPersonas;
    }

    public void setListaPersonas(List<PersonaVinculada> listaPersonas) {
        if (listaPersonas == null) {
            this.listaPersonas = new ArrayList<>();
        } else {
            this.listaPersonas = listaPersonas;
        }
    }

    //METODO REGISTRAR SUCURSAL

    public boolean registrarSucursal(Sucursal sucursal){
        if (sucursal == null || verificarSucursal(sucursal.getCodigo())) {
            return false;
        }
        listaSucursales.add(sucursal);
        return true;
    }

    //METODO REGISTRAR PRENDA
    public boolean registrarPrenda(Prenda prenda){
        if (prenda == null || verificarPrenda(prenda.getCodigo())) {
            return false;
        }
        listaPrendas.add(prenda);
        return true;
    }

    public boolean verificarSucursal(String codigo) {
        for (Sucursal sucursal : listaSucursales) {
            if (sucursal.getCodigo().equalsIgnoreCase(codigo)) {
                return true;
            }
        }
        return false;
    }

    public boolean verificarPrenda(String codigo) {
        for (Prenda prenda : listaPrendas) {
            if (prenda.getCodigo().equalsIgnoreCase(codigo)) {
                return true;
            }
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

    //METODO REGISTRAR CLIENTE
    public boolean registrarCliente(Cliente cliente){
        if (cliente == null || verificarPersona(cliente.getDocumento())) {
            return false;
        }
        listaPersonas.add(cliente);
        return true;
    }

    //METODO REGISTRAR EMPLEADO
    public boolean registrarEmpleado(Empleado empleado){
        if (empleado == null || verificarPersona(empleado.getDocumento())
                || empleado.getSucursal() == null) {
            return false;
        }

        Sucursal sucursal = buscarSucursal(empleado.getSucursal().getCodigo());
        if (sucursal != empleado.getSucursal()) {
            return false;
        }

        listaPersonas.add(empleado);
        sucursal.getListaEmpleados().add(empleado);
        return true;
    }

    public boolean verificarPersona(String documento) {
        for (PersonaVinculada persona : listaPersonas) {
            if (persona.getDocumento().equalsIgnoreCase(documento)) {
                return true;
            }
        }
        return false;
    }

    //METODO BUSCAR PERSONA POR DOCUMENTO
    public PersonaVinculada buscarPersona (String documento){
        for (PersonaVinculada persona: listaPersonas){
            if (documento.equalsIgnoreCase(persona.getDocumento())){
                return persona;
            }
        }
        return null;
    }

    public Cliente buscarCliente(String documento){
        for (PersonaVinculada persona : listaPersonas) {
            if (persona instanceof Cliente
                    && documento.equalsIgnoreCase(persona.getDocumento())) {
                return (Cliente) persona;
            }
        }
        return null;
    }

    public Empleado buscarEmpleado(String documento){
        for (PersonaVinculada persona : listaPersonas) {
            if (persona instanceof Empleado
                    && documento.equalsIgnoreCase(persona.getDocumento())) {
                return (Empleado) persona;
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
        Prenda prendaMasVendida = null;
        int mayorCantidad = 0;

        for (Prenda prenda : listaPrendas) {
            int unidadesVendidas = prenda.calcularTotalUnidadesVendidas();
            if (unidadesVendidas > mayorCantidad) {
                mayorCantidad = unidadesVendidas;
                prendaMasVendida = prenda;
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

import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Main {
    private static ModaStyle empresa = new ModaStyle(
            "ModaStyle", "900000000-1", "Armenia, Quindio");
    private static int contadorVentas = 1;

    public static void main(String[] args) {
        Cliente Kevin = new Cliente("1092", "Kevin Ruiz", "kevina.ruizc@uqvirtual.edu.co", "321", "1", CategoriaCliente.ORO);
        Sucursal sucursal1 = new Sucursal("1", "sucursal1", "armenia", "Armenia");
        Sucursal sucursal2 = new Sucursal("2", "sucursal2", "centro", "Armenia");
        Prenda camiseta = new Prenda("P1", "Camiseta", "ModaStyle", 40000,
                CategoriaPrenda.CAMISETA);
        Prenda pantalon = new Prenda("P2", "Pantalon", "ModaStyle", 80000,
                CategoriaPrenda.PANTALON);
        Prenda zapatos = new Prenda("P3", "Zapatos", "ModaStyle", 120000,
                CategoriaPrenda.CALZADO);
        Empleado mariana = new Empleado("10", "Mariana", "mari", "310",
                "EMP1", new Date(), 10000, sucursal1);
        Empleado empleado2 = new Empleado("11", "Carlos", "carlos", "311",
                "EMP2", new Date(), 10000, sucursal2);

        empresa.registrarSucursal(sucursal1);
        empresa.registrarSucursal(sucursal2);
        empresa.registrarPrenda(camiseta);
        empresa.registrarPrenda(pantalon);
        empresa.registrarPrenda(zapatos);
        empresa.registrarCliente(Kevin);
        empresa.registrarEmpleado(mariana);
        empresa.registrarEmpleado(empleado2);

        sucursal1.registrarExistencia(camiseta, "M", "Negro", 10);
        sucursal1.registrarExistencia(pantalon, "32", "Azul", 5);
        sucursal2.registrarExistencia(camiseta, "S", "Blanco", 8);
        sucursal2.registrarExistencia(zapatos, "40", "Cafe", 4);
        int opcion = -1;
        
        while (opcion != 0) {
            String menu = "===== MODASTYLE =====\n" +
                    "1. Registrar sucursal\n" +
                    "2. Registrar prenda\n" +
                    "3. Registrar cliente\n" +
                    "4. Registrar empleado\n" +
                    "5. Registrar existencias\n" +
                    "6. Consultar prendas disponibles\n" +
                    "7. Registrar venta\n" +
                    "8. Consultar prendas agotadas\n" +
                    "9. Consultar ventas de un empleado\n" +
                    "10. Consultar compras de un cliente\n" +
                    "11. Consultar ingresos de una sucursal\n" +
                    "12. Consultar prenda mas vendida\n" +
                    "0. Salir\n\n" +
                    "Ingrese una opcion:";

            String entrada = JOptionPane.showInputDialog(menu);
            if (entrada == null) {
                break;
            }

            opcion = Integer.parseInt(entrada);

            switch (opcion) {
                case 1: registrarSucursal(); break;
                case 2: registrarPrenda(); break;
                case 3: registrarCliente(); break;
                case 4: registrarEmpleado(); break;
                case 5: registrarExistencia(); break;
                case 6: consultarDisponibles(); break;
                case 7: registrarVenta(); break;
                case 8: consultarAgotadas(); break;
                case 9: consultarHistorial(true); break;
                case 10: consultarHistorial(false); break;
                case 11: consultarIngresosSucursal(); break;
                case 12: consultarPrendaMasVendida(); break;
                case 0: JOptionPane.showMessageDialog(null, "Programa terminado."); break;
                default: JOptionPane.showMessageDialog(null, "Opcion no valida."); break;
            }
        }
    }

    private static void registrarSucursal() {
        String codigo = JOptionPane.showInputDialog("Codigo de la sucursal:");
        String nombre = JOptionPane.showInputDialog("Nombre:");
        String direccion = JOptionPane.showInputDialog("Direccion:");
        String ciudad = JOptionPane.showInputDialog("Ciudad:");
        if (codigo == null || nombre == null || direccion == null || ciudad == null) return;

        Sucursal sucursal = new Sucursal(codigo, nombre, direccion, ciudad);
        if (empresa.registrarSucursal(sucursal)) {
            JOptionPane.showMessageDialog(null, "Sucursal registrada.");
        } else {
            JOptionPane.showMessageDialog(null, "Ya existe ese codigo de sucursal.");
        }
    }

    private static void registrarPrenda() {
        String codigo = JOptionPane.showInputDialog("Codigo de la prenda:");
        String nombre = JOptionPane.showInputDialog("Nombre:");
        String marca = JOptionPane.showInputDialog("Marca:");
        if (codigo == null || nombre == null || marca == null) return;
        String entradaPrecio = JOptionPane.showInputDialog("Precio base:");
        String entradaCategoria = JOptionPane.showInputDialog(
                "Categoria:\n1. CAMISETA\n2. PANTALON\n3. VESTIDO\n4. CHAQUETA\n5. CALZADO");
        if (entradaPrecio == null || entradaCategoria == null) return;
        double precio = Double.parseDouble(entradaPrecio);
        int numeroCategoria = Integer.parseInt(entradaCategoria);

        if (numeroCategoria < 1 || numeroCategoria > 5) {
            JOptionPane.showMessageDialog(null, "Categoria no valida.");
            return;
        }

        CategoriaPrenda categoria = CategoriaPrenda.values()[numeroCategoria - 1];
        Prenda prenda = new Prenda(codigo, nombre, marca, precio, categoria);
        if (empresa.registrarPrenda(prenda)) {
            JOptionPane.showMessageDialog(null, "Prenda registrada.");
        } else {
            JOptionPane.showMessageDialog(null, "Ya existe ese codigo de prenda.");
        }
    }

    private static void registrarCliente() {
        String documento = JOptionPane.showInputDialog("Documento:");
        String nombre = JOptionPane.showInputDialog("Nombre completo:");
        String correo = JOptionPane.showInputDialog("Correo:");
        String telefono = JOptionPane.showInputDialog("Telefono:");
        String afiliacion = JOptionPane.showInputDialog("Codigo de afiliacion:");
        String entradaCategoria = JOptionPane.showInputDialog(
                "Categoria del cliente:\n1. BRONCE\n2. PLATA\n3. ORO");
        if (documento == null || nombre == null || correo == null || telefono == null
                || afiliacion == null || entradaCategoria == null) return;
        int numeroCategoria = Integer.parseInt(entradaCategoria);

        if (numeroCategoria < 1 || numeroCategoria > 3) {
            JOptionPane.showMessageDialog(null, "Categoria no valida.");
            return;
        }

        CategoriaCliente categoria = CategoriaCliente.values()[numeroCategoria - 1];
        Cliente cliente = new Cliente(documento, nombre, correo, telefono,
                afiliacion, categoria);
        if (empresa.registrarCliente(cliente)) {
            JOptionPane.showMessageDialog(null, "Cliente registrado.");
        } else {
            JOptionPane.showMessageDialog(null, "Ya existe ese documento.");
        }
    }

    private static void registrarEmpleado() {
        String codigoSucursal = JOptionPane.showInputDialog("Codigo de la sucursal:");
        if (codigoSucursal == null) return;
        Sucursal sucursal = empresa.buscarSucursal(codigoSucursal);
        if (sucursal == null) {
            JOptionPane.showMessageDialog(null, "Sucursal no encontrada.");
            return;
        }

        String documento = JOptionPane.showInputDialog("Documento:");
        String nombre = JOptionPane.showInputDialog("Nombre completo:");
        String correo = JOptionPane.showInputDialog("Correo:");
        String telefono = JOptionPane.showInputDialog("Telefono:");
        String codigoEmpleado = JOptionPane.showInputDialog("Codigo del empleado:");
        String entradaSalario = JOptionPane.showInputDialog("Salario basico:");
        if (documento == null || nombre == null || correo == null || telefono == null
                || codigoEmpleado == null || entradaSalario == null) return;
        double salario = Double.parseDouble(entradaSalario);

        Empleado empleado = new Empleado(documento, nombre, correo, telefono,
                codigoEmpleado, new Date(), salario, sucursal);
        if (empresa.registrarEmpleado(empleado)) {
            JOptionPane.showMessageDialog(null, "Empleado registrado.");
        } else {
            JOptionPane.showMessageDialog(null, "Ya existe ese documento.");
        }
    }

    private static void registrarExistencia() {
        String codigoSucursal = JOptionPane.showInputDialog("Codigo de la sucursal:");
        if (codigoSucursal == null) return;
        Sucursal sucursal = empresa.buscarSucursal(codigoSucursal);
        String codigoPrenda = JOptionPane.showInputDialog("Codigo de la prenda:");
        if (codigoPrenda == null) return;
        Prenda prenda = empresa.buscarPrenda(codigoPrenda);

        if (sucursal == null || prenda == null) {
            JOptionPane.showMessageDialog(null, "Sucursal o prenda no encontrada.");
            return;
        }

        String talla = JOptionPane.showInputDialog("Talla (XS, S, M, L, XL o numero 35 a 44):");
        String color = JOptionPane.showInputDialog("Color:");
        String entradaCantidad = JOptionPane.showInputDialog("Cantidad:");
        if (talla == null || color == null || entradaCantidad == null) return;
        int cantidad = Integer.parseInt(entradaCantidad);

        if (sucursal.registrarExistencia(prenda, talla, color, cantidad)) {
            JOptionPane.showMessageDialog(null, "Existencias registradas.");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo registrar esa existencia.");
        }
    }

    private static void consultarDisponibles() {
        String codigo = JOptionPane.showInputDialog("Codigo de la sucursal:");
        if (codigo == null) return;
        Sucursal sucursal = empresa.buscarSucursal(codigo);
        if (sucursal == null) {
            JOptionPane.showMessageDialog(null, "Sucursal no encontrada.");
            return;
        }

        mostrarListaInventario(sucursal.consultarPrendasDisponibles(),
                "No hay prendas disponibles.");
    }

    private static void registrarVenta() {
        String codigoSucursal = JOptionPane.showInputDialog(
                "Codigo de la sucursal");
        if (codigoSucursal == null) return;
        Sucursal sucursal = empresa.buscarSucursal(codigoSucursal);
        if (sucursal == null) {
            JOptionPane.showMessageDialog(null, "No se encontro esa sucursal.");
            return;
        }

        String documentoCliente = JOptionPane.showInputDialog(
                "Documento del cliente:");
        if (documentoCliente == null) return;
        Cliente cliente = empresa.buscarCliente(documentoCliente);
        if (cliente == null) {
            JOptionPane.showMessageDialog(null, "No se encontro ese cliente.");
            return;
        }

        String documentoEmpleado = JOptionPane.showInputDialog(
                "Documento del empleado");
        if (documentoEmpleado == null) return;
        Empleado empleado = empresa.buscarEmpleado(documentoEmpleado);
        if (empleado == null) {
            JOptionPane.showMessageDialog(null, "No se encontro ese empleado.");
            return;
        }

        if (empleado.getSucursal() != sucursal) {
            JOptionPane.showMessageDialog(null,
                    "Ese empleado no trabaja en la sucursal seleccionada.");
            return;
        }

        Venta venta = new Venta("V" + contadorVentas, LocalDate.now(),
                cliente, empleado, sucursal);
        contadorVentas++;
        if (!agregarDetalles(venta, sucursal)) {
            JOptionPane.showMessageDialog(null, "Venta cancelada.");
            return;
        }

        if (venta.confirmarVenta()) {
            JOptionPane.showMessageDialog(null, "Venta confirmada. Total: "
                    + venta.calcularValorTotal());
        } else {
            JOptionPane.showMessageDialog(null,
                    "No se confirmo. Agrega una prenda y revisa las cantidades disponibles.");
        }
    }

    private static boolean agregarDetalles(Venta venta, Sucursal sucursal) {
        boolean agregarOtra = true;
        while (agregarOtra) {
            List<RegistroInventario> disponibles = sucursal.consultarPrendasDisponibles();
            if (disponibles.size() == 0) {
                JOptionPane.showMessageDialog(null, "No hay existencias disponibles.");
                break;
            }

            String mensaje = "Seleccione el numero de la prenda:\n"
                    + mostrarInventario(disponibles);
            String entrada = JOptionPane.showInputDialog(mensaje);
            if (entrada == null) return false;
            int opcion = Integer.parseInt(entrada);
            if (opcion > 0 && opcion <= disponibles.size()) {
                String entradaCantidad = JOptionPane.showInputDialog("Cantidad:");
                if (entradaCantidad == null) return false;
                int cantidad = Integer.parseInt(entradaCantidad);
                if (!venta.agregarDetalle(disponibles.get(opcion - 1), cantidad)) {
                    JOptionPane.showMessageDialog(null, "No se pudo agregar el detalle.");
                } else {
                    int respuesta = JOptionPane.showConfirmDialog(null,
                            "¿Desea agregar otra prenda?", "Registrar venta",
                            JOptionPane.YES_NO_OPTION);
                    if (respuesta == JOptionPane.YES_OPTION) {
                        agregarOtra = true;
                    } else if (respuesta == JOptionPane.NO_OPTION) {
                        agregarOtra = false;
                    } else {
                        return false;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Opcion no valida.");
            }
        }
        return venta.getListaDetalles().size() > 0;
    }

    private static void consultarAgotadas() {
        mostrarListaInventario(empresa.consultarPrendasAgotadas(),
                "No hay prendas agotadas.");
    }

    private static void consultarHistorial(boolean esEmpleado) {
        String tipo = esEmpleado ? "empleado" : "cliente";
        String documento = JOptionPane.showInputDialog("Documento del " + tipo + ":");
        if (documento == null) return;
        if (esEmpleado) {
            Empleado empleado = empresa.buscarEmpleado(documento);
            if (empleado == null) {
                JOptionPane.showMessageDialog(null, "Empleado no encontrado.");
                return;
            }
            mostrarVentas(empleado.getListaVentas(), "Ventas de " + empleado.getNombreCompleto());
        } else {
            Cliente cliente = empresa.buscarCliente(documento);
            if (cliente == null) {
                JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
                return;
            }
            mostrarVentas(cliente.getListaCompras(), "Compras de " + cliente.getNombreCompleto());
        }
    }

    private static void consultarIngresosSucursal() {
        String codigo = JOptionPane.showInputDialog("Codigo de la sucursal:");
        if (codigo == null) return;
        Sucursal sucursal = empresa.buscarSucursal(codigo);
        if (sucursal == null) {
            JOptionPane.showMessageDialog(null, "Sucursal no encontrada.");
        } else {
            JOptionPane.showMessageDialog(null,
                    "Ingresos: " + sucursal.calcularIngresosTotales());
        }
    }

    private static void consultarPrendaMasVendida() {
        Prenda prenda = empresa.obtenerPrendaMasVendida();
        if (prenda == null) {
            JOptionPane.showMessageDialog(null, "No hay ventas registradas.");
        } else {
            JOptionPane.showMessageDialog(null, "Prenda mas vendida: "
                    + prenda.getNombre() + " - Unidades: "
                    + prenda.calcularTotalUnidadesVendidas());
        }
    }

    private static String mostrarInventario(List<RegistroInventario> inventario) {
        String texto = "";
        for (int i = 0; i < inventario.size(); i++) {
            texto += (i + 1) + ". " + inventario.get(i) + "\n";
        }
        return texto;
    }

    private static void mostrarListaInventario(List<RegistroInventario> inventario,
                                               String mensajeVacio) {
        if (inventario.size() == 0) {
            JOptionPane.showMessageDialog(null, mensajeVacio);
        } else {
            JOptionPane.showMessageDialog(null, mostrarInventario(inventario));
        }
    }

    private static void mostrarVentas(List<Venta> ventas, String titulo) {
        String texto = titulo + ":\n";
        for (Venta venta : ventas) {
            texto += "Venta " + venta.getCodigo() + " - Total: "
                    + venta.calcularValorTotal() + "\n";
        }
        JOptionPane.showMessageDialog(null, texto);
    }
}

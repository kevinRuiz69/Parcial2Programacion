import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Main {
    private static ModaStyle empresa = new ModaStyle(
            "ModaStyle", "900000000-1", "Armenia, Quindio");
    private static int contadorVentas = 1;

    public static void main(String[] args) {
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
                case 1:
                    registrarSucursal();
                    break;
                case 2:
                    registrarPrenda();
                    break;
                case 3:
                    registrarCliente();
                    break;
                case 4:
                    registrarEmpleado();
                    break;
                case 5:
                    registrarExistencia();
                    break;
                case 6:
                    consultarDisponibles();
                    break;
                case 7:
                    registrarVenta();
                    break;
                case 8:
                    consultarAgotadas();
                    break;
                case 9:
                    consultarVentasEmpleado();
                    break;
                case 10:
                    consultarComprasCliente();
                    break;
                case 11:
                    consultarIngresosSucursal();
                    break;
                case 12:
                    consultarPrendaMasVendida();
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Programa terminado.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion no valida.");
                    break;
            }
        }
    }

    private static void registrarSucursal() {
        String codigo = JOptionPane.showInputDialog("Codigo de la sucursal:");
        if (codigo == null) return;
        String nombre = JOptionPane.showInputDialog("Nombre:");
        if (nombre == null) return;
        String direccion = JOptionPane.showInputDialog("Direccion:");
        if (direccion == null) return;
        String ciudad = JOptionPane.showInputDialog("Ciudad:");
        if (ciudad == null) return;

        Sucursal sucursal = new Sucursal(codigo, nombre, direccion, ciudad);
        if (empresa.registrarSucursal(sucursal)) {
            JOptionPane.showMessageDialog(null, "Sucursal registrada.");
        } else {
            JOptionPane.showMessageDialog(null, "Ya existe ese codigo de sucursal.");
        }
    }

    private static void registrarPrenda() {
        String codigo = JOptionPane.showInputDialog("Codigo de la prenda:");
        if (codigo == null) return;
        String nombre = JOptionPane.showInputDialog("Nombre:");
        if (nombre == null) return;
        String marca = JOptionPane.showInputDialog("Marca:");
        if (marca == null) return;
        String entradaPrecio = JOptionPane.showInputDialog("Precio base:");
        if (entradaPrecio == null) return;
        double precio = Double.parseDouble(entradaPrecio);
        String entradaCategoria = JOptionPane.showInputDialog(
                "Categoria:\n1. CAMISETA\n2. PANTALON\n3. VESTIDO\n4. CHAQUETA\n5. CALZADO");
        if (entradaCategoria == null) return;
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
        if (documento == null) return;
        String nombre = JOptionPane.showInputDialog("Nombre completo:");
        if (nombre == null) return;
        String correo = JOptionPane.showInputDialog("Correo:");
        if (correo == null) return;
        String telefono = JOptionPane.showInputDialog("Telefono:");
        if (telefono == null) return;
        String afiliacion = JOptionPane.showInputDialog("Codigo de afiliacion:");
        if (afiliacion == null) return;
        String entradaCategoria = JOptionPane.showInputDialog(
                "Categoria del cliente:\n1. BRONCE\n2. PLATA\n3. ORO");
        if (entradaCategoria == null) return;
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
        if (documento == null) return;
        String nombre = JOptionPane.showInputDialog("Nombre completo:");
        if (nombre == null) return;
        String correo = JOptionPane.showInputDialog("Correo:");
        if (correo == null) return;
        String telefono = JOptionPane.showInputDialog("Telefono:");
        if (telefono == null) return;
        String codigoEmpleado = JOptionPane.showInputDialog("Codigo del empleado:");
        if (codigoEmpleado == null) return;
        String entradaSalario = JOptionPane.showInputDialog("Salario basico:");
        if (entradaSalario == null) return;
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
        if (talla == null) return;
        String color = JOptionPane.showInputDialog("Color:");
        if (color == null) return;
        String entradaCantidad = JOptionPane.showInputDialog("Cantidad:");
        if (entradaCantidad == null) return;
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

        List<RegistroInventario> disponibles = sucursal.consultarPrendasDisponibles();
        if (disponibles.size() == 0) {
            JOptionPane.showMessageDialog(null, "No hay prendas disponibles.");
            return;
        }
        JOptionPane.showMessageDialog(null, mostrarInventario(disponibles));
    }

    private static void registrarVenta() {
        String codigoSucursal = JOptionPane.showInputDialog("Codigo de la sucursal:");
        if (codigoSucursal == null) return;
        Sucursal sucursal = empresa.buscarSucursal(codigoSucursal);
        String documentoCliente = JOptionPane.showInputDialog("Documento del cliente:");
        if (documentoCliente == null) return;
        Cliente cliente = empresa.buscarCliente(documentoCliente);
        String documentoEmpleado = JOptionPane.showInputDialog("Documento del empleado:");
        if (documentoEmpleado == null) return;
        Empleado empleado = empresa.buscarEmpleado(documentoEmpleado);

        if (sucursal == null || cliente == null || empleado == null
                || empleado.getSucursal() != sucursal) {
            JOptionPane.showMessageDialog(null, "Revisa la sucursal, el cliente y el empleado.");
            return;
        }

        Venta venta = new Venta("V" + contadorVentas, LocalDate.now(),
                cliente, empleado, sucursal);
        contadorVentas++;
        agregarDetalles(venta, sucursal);

        if (venta.confirmarVenta()) {
            JOptionPane.showMessageDialog(null, "Venta confirmada. Total: "
                    + venta.calcularValorTotal());
        } else {
            JOptionPane.showMessageDialog(null,
                    "No se confirmo la venta. Revisa las cantidades disponibles.");
        }
    }

    private static void agregarDetalles(Venta venta, Sucursal sucursal) {
        int opcion = -1;
        while (opcion != 0) {
            List<RegistroInventario> disponibles = sucursal.consultarPrendasDisponibles();
            if (disponibles.size() == 0) {
                JOptionPane.showMessageDialog(null, "No hay existencias disponibles.");
                break;
            }

            String mensaje = "Seleccione la prenda (0 para terminar):\n"
                    + mostrarInventario(disponibles);
            String entrada = JOptionPane.showInputDialog(mensaje);
            if (entrada == null) break;
            opcion = Integer.parseInt(entrada);
            if (opcion > 0 && opcion <= disponibles.size()) {
                String entradaCantidad = JOptionPane.showInputDialog("Cantidad:");
                if (entradaCantidad == null) break;
                int cantidad = Integer.parseInt(entradaCantidad);
                if (!venta.agregarDetalle(disponibles.get(opcion - 1), cantidad)) {
                    JOptionPane.showMessageDialog(null, "No se pudo agregar el detalle.");
                }
            } else if (opcion != 0) {
                JOptionPane.showMessageDialog(null, "Opcion no valida.");
            }
        }
    }

    private static void consultarAgotadas() {
        List<RegistroInventario> agotadas = empresa.consultarPrendasAgotadas();
        if (agotadas.size() == 0) {
            JOptionPane.showMessageDialog(null, "No hay prendas agotadas.");
        } else {
            JOptionPane.showMessageDialog(null, mostrarInventario(agotadas));
        }
    }

    private static void consultarVentasEmpleado() {
        String documento = JOptionPane.showInputDialog("Documento del empleado:");
        if (documento == null) return;
        Empleado empleado = empresa.buscarEmpleado(documento);
        if (empleado == null) {
            JOptionPane.showMessageDialog(null, "Empleado no encontrado.");
            return;
        }

        String texto = "Ventas de " + empleado.getNombreCompleto() + ":\n";
        for (Venta venta : empleado.getListaVentas()) {
            texto += "Venta " + venta.getCodigo() + " - Total: "
                    + venta.calcularValorTotal() + "\n";
        }
        JOptionPane.showMessageDialog(null, texto);
    }

    private static void consultarComprasCliente() {
        String documento = JOptionPane.showInputDialog("Documento del cliente:");
        if (documento == null) return;
        Cliente cliente = empresa.buscarCliente(documento);
        if (cliente == null) {
            JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
            return;
        }

        String texto = "Compras de " + cliente.getNombreCompleto() + ":\n";
        for (Venta venta : cliente.getListaCompras()) {
            texto += "Venta " + venta.getCodigo() + " - Total: "
                    + venta.calcularValorTotal() + "\n";
        }
        JOptionPane.showMessageDialog(null, texto);
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
}

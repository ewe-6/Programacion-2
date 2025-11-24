import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<ProductoporPartes> listaProductoporPartes = new ArrayList<>();
    private static List<Productoensamblado> listaProductoensamblado = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int opcion;
        double saldo;
        int espacioAlmacen;

        System.out.print("Ingresar el saldo actual de la empresa: ");
        saldo = sc.nextDouble();
        System.out.print("Ingresar el espacio en el almacén (representado por la cantidad de cajas que alcanzan): ");
        espacioAlmacen = sc.nextInt();

        do{
            mostrarMenu();
            if(sc.hasNextInt()){
                opcion=sc.nextInt();
                sc.nextLine();

                switch(opcion){
                    case 1:
                        ingresarProductoporPartes(espacioAlmacen);
                    case 2:
                        ingresarProductoensamblado(espacioAlmacen);
                    case 3:
                        System.out.print("Ingresar la cantidad a depositar: ");
                        saldo += sc.nextDouble();
                    case 4:
                        System.out.print("Ingresar el espacio a aumentar: ");
                        espacioAlmacen += sc.nextInt();
                    case 7:
                        mostrarProductos();
                    case 8:
                        System.out.println("Saliendo de la aplicación");
                        break;
                    default:
                        System.out.println("Se ingresó un número no válido");
                }
            }
        } while (opcion!=8);
    }

    private static void mostrarMenu(){
        System.out.println("\n------------------ MENU ------------------");
        System.out.println("1. Ingresar un nuevo producto por partes");
        System.out.println("2. Ingresar un nuevo producto ensamblado");
        System.out.println("3. Aumentar el saldo de la empresa");
        System.out.println("4. Aumentar el espacio en el almacén");
        System.out.println("5. Venta de un producto");
        System.out.println("6. Reabastecimiento de un producto");
        System.out.println("7. Mostrar todos los productos");
        System.out.println("8. Salir");
    }

    private static void ingresarProductoporPartes(int espacioAl){
        System.out.println("----------- Ingreso de Producto por Partes -----------");
        System.out.print("Producto: ");
        String nombre = sc.nextLine();
        System.out.print("Costo: ");
        double costo = sc.nextDouble();
        System.out.print("Precio: ");
        double precio = sc.nextDouble();
        System.out.print("Cantidad: ");
        int cantidad = sc.nextInt();
        System.out.print("Espacio que ocupa: ");
        int espacioOcupa = sc.nextInt();
        System.out.print("Espacio extra: ");
        int espacioExtra = sc.nextInt();

        int espacioTot = espacioExtra+espacioOcupa;
        if ((espacioTot*cantidad)>espacioAl){
            System.out.println("La cantidad que intentó ingresar supera el espacio disponible en almacén");
            System.out.println("Saliendo...");
            return;
        }
        ProductoporPartes nuevoProducto = new ProductoporPartes(nombre, costo, precio, cantidad, espacioOcupa, espacioExtra);
        listaProductoporPartes.add(nuevoProducto);
        System.out.println("\nSe ha agregado con éxito el producto por partes");
    }

    private static void ingresarProductoensamblado(int espacioAl){
        System.out.println("----------- Ingreso de Producto Ensamblado -----------");
        System.out.print("Producto: ");
        String nombre = sc.nextLine();
        System.out.print("Costo: ");
        double costo = sc.nextDouble();
        System.out.print("Precio: ");
        double precio = sc.nextDouble();
        System.out.print("Cantidad: ");
        int cantidad = sc.nextInt();
        System.out.print("Espacio que ocupa: ");
        int espacioOcupa = sc.nextInt();
        System.out.print("Tipo de ensamblaje: ");
        String tipoEnsamblaje = sc.nextLine();

        if ((espacioOcupa*cantidad)>espacioAl){
            System.out.println("La cantidad que intentó ingresar supera el espacio disponible en almacén");
            System.out.println("Saliendo...");
            return;
        }

        Productoensamblado nuevoProducto = new Productoensamblado(nombre, costo, precio, cantidad, espacioOcupa, tipoEnsamblaje);
        listaProductoensamblado.add(nuevoProducto);
        System.out.println("\nSe ha agregado con éxito el producto ensamblado");
    }

    private static void eliminarProductopartes(){
        if(listaProductoporPartes.isEmpty()){
            System.out.println("No hay productos por partes para eliminar");
            return;
        }

        System.out.print("Ingrese el nombre del producto a eliminar: ");
        String productoEliminar = sc.nextLine();

        boolean encontrado = false;
        for (int i = 0; i < listaProductoporPartes.size(); i++) {
            if (listaProductoporPartes.get(i).getNombre() == productoEliminar) {
                listaProductoporPartes.remove(i);
                encontrado = true;
                System.out.println("\nEl producto " + productoEliminar + " fue eliminado con éxito");
                break;
            }
        }

        if (!encontrado) {
            System.out.println("\n No se encontró el producto " + productoEliminar);
        }
    }

    private static void eliminarProductoensamblado(){
        if(listaProductoensamblado.isEmpty()){
            System.out.println("No hay productos por partes para eliminar");
            return;
        }

        System.out.print("Ingrese el nombre del producto a eliminar: ");
        String productoEliminar = sc.nextLine();

        boolean encontrado = false;
        for (int i = 0; i < listaProductoensamblado.size(); i++) {
            if (listaProductoensamblado.get(i).getNombre() == productoEliminar) {
                listaProductoensamblado.remove(i);
                encontrado = true;
                System.out.println("\nEl producto " + productoEliminar + " fue eliminado con éxito");
                break;
            }
        }

        if (!encontrado) {
            System.out.println("\n No se encontró el producto " + productoEliminar);
        }
    }

    private static void mostrarProductos(){
        System.out.println("\n-------------------- PRODUCTOS --------------------");

        if(listaProductoensamblado.isEmpty() && listaProductoporPartes.isEmpty()){
            System.out.println("\nNo hay ningún producto por mostrar");
            return;
        }

        System.out.println("\nPRODUCTOS POR PARTES");
        if(listaProductoporPartes.isEmpty()){
            System.out.println("No hay productos por partes");
        } else{
            for(ProductoporPartes p : listaProductoporPartes){
                p.mostrarInfo();
            }
        }

        System.out.println("\nPRODUCTOS ENSAMBLADOS");
        if(listaProductoensamblado.isEmpty()){
            System.out.println("No hay productos ensamblados");
        } else{
            for(Productoensamblado p : listaProductoensamblado){
                p.mostrarInfo();
            }
        }
    }

    private static void aumentarProductopartes(){
        if(listaProductoporPartes.isEmpty()){
            System.out.println("No hay productos por partes para reabastecer");
            return;
        }

        System.out.print("Ingrese el nombre del producto a reabastecer: ");
        String productoEliminar = sc.nextLine();

        boolean encontrado = false;
        for (int i = 0; i < listaProductoporPartes.size(); i++) {
            if (listaProductoporPartes.get(i).getNombre() == productoEliminar) {
                System.out.print("Ingrese la cantidad a aumentar: ");
                int cant=sc.nextInt();
                listaProductoporPartes.set(i, listaProductoporPartes.get(i).getCantidad()+cant);
                encontrado = true;
                System.out.println("\nEl producto " + productoEliminar + " fue eliminado con éxito");
                break;
            }
        }

        if (!encontrado) {
            System.out.println("\n No se encontró el producto " + productoEliminar);
        }
    }
}
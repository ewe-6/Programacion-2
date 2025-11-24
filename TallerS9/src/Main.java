import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
                        ingresarProductoporPartes(espacioAlmacen, saldo);
                        if(!listaProductoporPartes.isEmpty()) {
                            espacioAlmacen -= (listaProductoporPartes.getLast().getEspacioOcupa() * listaProductoporPartes.getLast().getCantidad());
                            saldo -= (listaProductoporPartes.getLast().getCosto() * listaProductoporPartes.getLast().getCantidad());
                        }
                        break;
                    case 2:
                        ingresarProductoensamblado(espacioAlmacen, saldo);
                        if(!listaProductoensamblado.isEmpty()) {
                            espacioAlmacen -= (listaProductoensamblado.getLast().getEspacioOcupa() * listaProductoensamblado.getLast().getCantidad());
                            saldo -= (listaProductoensamblado.getLast().getCosto() * listaProductoensamblado.getLast().getCantidad());
                        }
                        break;
                    case 3:
                        System.out.print("Ingresar la cantidad a depositar: ");
                        saldo += sc.nextDouble();
                        break;
                    case 4:
                        System.out.print("Ingresar el espacio a aumentar: ");
                        espacioAlmacen += sc.nextInt();
                        break;
                    case 5:
                        venderProductopartes();
                        break;
                    case 6:
                        venderProductoensamblado();
                        break;
                    case 7:
                        aumentarProductopartes(espacioAlmacen, saldo);
                        break;
                    case 8:
                        aumentarProductoensamblado(espacioAlmacen, saldo);
                        break;
                    case 9:
                        eliminarProductopartes();
                        break;
                    case 10:
                        eliminarProductoensamblado();
                        break;
                    case 11:
                        mostrarProductos();
                        break;
                    case 12:
                        System.out.println("\n------------ DATOS DE LA EMPRESA ------------");
                        System.out.println("Saldo: " + saldo);
                        System.out.println("Espacio en almacén: " + espacioAlmacen);
                    case 13:
                        System.out.println("Saliendo de la aplicación");
                        break;
                    default:
                        System.out.println("Se ingresó un número no válido");
                        break;
                }
            }else {
                System.out.println("\nEntrada no válida. Por favor, ingrese un número.");
                sc.nextLine(); // Consumir la entrada no válida
                opcion = 0; // Para que el bucle continúe
            }
        } while (opcion!=13);
    }

    private static void mostrarMenu(){
        System.out.println("\n------------------ MENU ------------------");
        System.out.println("1. Ingresar un nuevo producto por partes");
        System.out.println("2. Ingresar un nuevo producto ensamblado");
        System.out.println("3. Aumentar el saldo de la empresa");
        System.out.println("4. Aumentar el espacio en el almacén");
        System.out.println("5. Venta de un producto por partes");
        System.out.println("6. Venta de un producto ensamblado");
        System.out.println("7. Reabastecimiento de un producto por partes");
        System.out.println("8. Reabastecimiento de un producto ensamblado");
        System.out.println("9. Eliminar un producto por partes");
        System.out.println("10. Eliminar un producto ensamblado");
        System.out.println("11. Mostrar todos los productos");
        System.out.println("12. Mostrar el saldo de la empresa y espacio en almacén");
        System.out.println("13. Salir");
        System.out.print("Ingresar la operación a realizar: ");
    }

    private static void ingresarProductoporPartes(int espacioAl, double saldo){
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
        sc.nextLine();

        int espacioTot = espacioExtra+espacioOcupa;
        if ((espacioTot*cantidad)>espacioAl){
            System.out.println("La cantidad que intentó ingresar supera el espacio disponible en almacén");
            System.out.println("Saliendo...");
            return;
        } else if ((cantidad*costo)>saldo){
            System.out.println("La cantidad que intentó ingresar supera el saldo disponible");
            System.out.println("Saliendo...");
            return;
        } else {
            ProductoporPartes nuevoProducto = new ProductoporPartes(nombre, costo, precio, cantidad, espacioOcupa, espacioExtra);
            listaProductoporPartes.add(nuevoProducto);
            System.out.println("\nSe ha agregado con éxito el producto por partes");
        }
    }

    private static void ingresarProductoensamblado(int espacioAl, double saldo){
        System.out.println("----------- Ingreso de Producto Ensamblado -----------");
        System.out.print("Producto: ");
        String nombre = sc.nextLine();
        System.out.print("Costo: ");
        double costo = sc.nextDouble();
        System.out.print("Precio: ");
        double precio = sc.nextDouble();
        System.out.print("Cantidad: ");
        int cantidad = sc.nextInt();
        sc.nextLine();
        System.out.print("Tipo de ensamblaje: ");
        String tipoEnsamblaje = sc.nextLine();
        System.out.print("Espacio que ocupa: ");
        int espacioOcupa = sc.nextInt();
        sc.nextLine();

        if ((espacioOcupa*cantidad)>espacioAl){
            System.out.println("La cantidad que intentó ingresar supera el espacio disponible en almacén");
            System.out.println("Saliendo...");
            return;
        } else if ((cantidad*costo)>saldo){
            System.out.println("La cantidad que intentó ingresar supera el saldo disponible");
            System.out.println("Saliendo...");
            return;
        } else {
            Productoensamblado nuevoProducto = new Productoensamblado(nombre, costo, precio, cantidad, espacioOcupa, tipoEnsamblaje);
            listaProductoensamblado.add(nuevoProducto);
            System.out.println("\nSe ha agregado con éxito el producto ensamblado");
        }
    }

    private static void eliminarProductopartes(){
        if(listaProductoporPartes.isEmpty()){
            System.out.println("No hay productos por partes para eliminar");
            return;
        }

        System.out.print("Ingrese el nombre del producto a eliminar: ");
        String productoEliminar = sc.nextLine();
        sc.nextLine();

        boolean encontrado = false;
        for (int i = 0; i < listaProductoporPartes.size(); i++) {
            if (Objects.equals(listaProductoporPartes.get(i).getNombre(), productoEliminar)) {
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
        sc.nextLine();

        boolean encontrado = false;
        for (int i = 0; i < listaProductoensamblado.size(); i++) {
            if (Objects.equals(listaProductoensamblado.get(i).getNombre(), productoEliminar)) {
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

    private static void aumentarProductopartes(int espacioAl, double saldo){
        if(listaProductoporPartes.isEmpty()){
            System.out.println("No hay productos por partes para reabastecer");
            return;
        }

        System.out.print("Ingrese el nombre del producto a reabastecer: ");
        String productoAumentar = sc.nextLine();
        sc.nextLine();

        boolean encontrado = false;
        for (int i = 0; i < listaProductoporPartes.size(); i++) {
            if (Objects.equals(listaProductoporPartes.get(i).getNombre(), productoAumentar)) {
                System.out.print("Ingrese la cantidad a aumentar: ");
                int cant=sc.nextInt();

                if ((listaProductoporPartes.get(i).getEspacioOcupa()*cant)>espacioAl){
                    System.out.println("La cantidad que intentó ingresar supera el espacio disponible en almacén");
                    System.out.println("Saliendo...");
                    return;
                } else if ((listaProductoporPartes.get(i).getCosto()*cant)>saldo) {
                    System.out.println("La cantidad que intentó ingresar supera el saldo disponible");
                    System.out.println("Saliendo...");
                    return;
                }else {
                    listaProductoporPartes.get(i).setCantidad(listaProductoporPartes.get(i).getCantidad() + cant);
                    encontrado = true;
                    System.out.println("\nEl producto " + productoAumentar + " fue actualizado con éxito");
                }
                break;
            }
        }

        if (!encontrado) {
            System.out.println("\n No se encontró el producto " + productoAumentar);
        }
    }
    private static void aumentarProductoensamblado(int espacioAl, double saldo){
        if(listaProductoensamblado.isEmpty()){
            System.out.println("No hay productos ensamblados para reabastecer");
            return;
        }

        System.out.print("Ingrese el nombre del producto a reabastecer: ");
        String productoAumentar = sc.nextLine();
        sc.nextLine();

        boolean encontrado = false;
        for (int i = 0; i < listaProductoensamblado.size(); i++) {
            if (Objects.equals(listaProductoensamblado.get(i).getNombre(), productoAumentar)) {
                System.out.print("Ingrese la cantidad a aumentar: ");
                int cant=sc.nextInt();
                if ((listaProductoensamblado.get(i).getEspacioOcupa()*cant)>espacioAl){
                    System.out.println("La cantidad que intentó ingresar supera el espacio disponible en almacén");
                    System.out.println("Saliendo...");
                    return;
                } else if ((listaProductoensamblado.get(i).getCosto()*cant)>saldo) {
                    System.out.println("La cantidad que intentó ingresar supera el saldo disponible");
                    System.out.println("Saliendo...");
                    return;
                }else {
                    listaProductoensamblado.get(i).setCantidad(listaProductoensamblado.get(i).getCantidad() + cant);
                    encontrado = true;
                    System.out.println("\nEl producto " + productoAumentar + " fue actualizado con éxito");
                }
                break;
            }
        }

        if (!encontrado) {
            System.out.println("\n No se encontró el producto " + productoAumentar);
        }
    }

    private static void venderProductopartes(){
        if(listaProductoporPartes.isEmpty()){
            System.out.println("No hay productos por partes para vender");
            return;
        }

        System.out.print("Ingrese el nombre del producto a vender: ");
        String productoVender = sc.nextLine();
        sc.nextLine();

        boolean encontrado = false;
        for (int i = 0; i < listaProductoporPartes.size(); i++) {
            if (Objects.equals(listaProductoporPartes.get(i).getNombre(), productoVender)) {
                System.out.print("Ingrese la cantidad a vender: ");
                int cant=sc.nextInt();
                if(cant>listaProductoporPartes.get(i).getCantidad()){
                    System.out.println("Se está intentando vender una cantidad mayor a la que se tiene en inventario");
                    System.out.println("Saliendo...");
                    return;
                }else {
                    listaProductoporPartes.get(i).setCantidad(listaProductoporPartes.get(i).getCantidad() - cant);
                    encontrado = true;
                    System.out.println("\nEl producto " + productoVender + " fue vendido con éxito");
                    break;
                }
            }
        }

        if (!encontrado) {
            System.out.println("\n No se encontró el producto " + productoVender);
        }
    }

    private static void venderProductoensamblado(){
        if(listaProductoensamblado.isEmpty()){
            System.out.println("No hay productos ensamblados para vender");
            return;
        }

        System.out.print("Ingrese el nombre del producto a vender: ");
        String productoVender = sc.nextLine();
        sc.nextLine();

        boolean encontrado = false;
        for (int i = 0; i < listaProductoensamblado.size(); i++) {
            if (Objects.equals(listaProductoensamblado.get(i).getNombre(), productoVender)) {
                System.out.print("Ingrese la cantidad a vender: ");
                int cant=sc.nextInt();
                if(cant>listaProductoensamblado.get(i).getCantidad()){
                    System.out.println("Se está intentando vender una cantidad mayor a la que se tiene en inventario");
                    System.out.println("Saliendo...");
                    return;
                }else {
                    listaProductoensamblado.get(i).setCantidad(listaProductoensamblado.get(i).getCantidad() - cant);
                    encontrado = true;
                    System.out.println("\nEl producto " + productoVender + " fue vendido con éxito");
                    break;
                }
            }
        }

        if (!encontrado) {
            System.out.println("\n No se encontró el producto " + productoVender);
        }
    }
}
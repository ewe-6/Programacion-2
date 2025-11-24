public class Producto {
    private String nombre;
    private double costo;
    private double precio;
    private int cantidad;
    private int espacioOcupa;

    public Producto(String nombre, double costo, double precio, int cantidad, int espacioOcupa) {
        this.nombre = nombre;
        this.costo = costo;
        this.precio = precio;
        this.cantidad = cantidad;
        this.espacioOcupa = espacioOcupa;
    }

    public String getNombre() {
        return nombre;
    }

    public double getCosto() {
        return costo;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getEspacioOcupa() {
        return espacioOcupa;
    }

    public void mostrarInfo(){
        System.out.println("Producto: " + nombre);
        System.out.println("Costo del producto: " + costo);
        System.out.println("Precio del producto: " + precio);
        System.out.println("Cantidad de producto disponible: " + cantidad);
        System.out.println("Espacio que ocupa el producto: " + espacioOcupa);
    }
}

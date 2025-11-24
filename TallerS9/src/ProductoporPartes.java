public class ProductoporPartes extends Producto{
    private int espacioExtra;

    public ProductoporPartes(String nombre, double costo, double precio, int cantidad, int espacioOcupa, int espacioExtra) {
        super(nombre, costo, precio, cantidad, espacioOcupa);
        this.espacioExtra = espacioExtra;
    }

    public void mostrarInfo(){
        System.out.println("\n------------ Información del producto (" + getNombre() + ") ------------");
        super.mostrarInfo();
        System.out.println("Cantidad de espacio extra del producto: " + espacioExtra);
    }
}

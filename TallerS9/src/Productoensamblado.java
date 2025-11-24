public class Productoensamblado extends Producto{
    private String tipoEnsamblaje;

    public Productoensamblado(String nombre, double costo, double precio, int cantidad, int espacioOcupa, String tipoEnsamblaje) {
        super(nombre, costo, precio, cantidad, espacioOcupa);
        this.tipoEnsamblaje = tipoEnsamblaje;
    }

    public void mostrarInfo() {
        System.out.println("\n------------ Información del producto (" + getNombre() + ") ------------");
        super.mostrarInfo();
        System.out.println("Tipo de producto ensamblado: " + tipoEnsamblaje);
    }
}

import javax.swing.*;

public class PruebaFactura {
    public static void main(String[] args) {
        Factura f1=new Factura("", "", 0, 0.0);

        f1.setNumeroPieza(JOptionPane.showInputDialog("Colocar el numero de pieza "));
        f1.setDescripcionPieza(JOptionPane.showInputDialog("Colocar la descripcion de la pieza "));
        f1.setCantidadComprar(Integer.parseInt(JOptionPane.showInputDialog("Colocar la cantidad de piezas que se desea comprar ")));
        f1.setPrecioPieza(Double.parseDouble(JOptionPane.showInputDialog("Colocar el precio por pieza ")));

        JOptionPane.showMessageDialog(null, "Numero de pieza: " + f1.getNumeroPieza() + "\n"
        + "Descripción de pieza: " + f1.getDescripcionPieza() + "\n"
        + "Cantidad de piezas a comprar: " + f1.getCantidadComprar() + "\n"
        + "Precio por pieza: " + f1.getPrecioPieza() + "\n"
        + "Monto de factura: " + f1.obtenerMontoFactura());
    }
}
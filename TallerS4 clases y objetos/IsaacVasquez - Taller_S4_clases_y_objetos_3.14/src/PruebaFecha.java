import javax.swing.*;

public class PruebaFecha {
    public static void main(String[] args) {
        Fecha f1 = new Fecha(0, 0, 0);

        f1.setMes(Integer.parseInt(JOptionPane.showInputDialog("Coloque el mes ")));
        f1.setDia(Integer.parseInt(JOptionPane.showInputDialog("Coloque el dia ")));
        f1.setAnio(Integer.parseInt(JOptionPane.showInputDialog("Coloque el anio ")));

        f1.mostrarFecha();
    }
}
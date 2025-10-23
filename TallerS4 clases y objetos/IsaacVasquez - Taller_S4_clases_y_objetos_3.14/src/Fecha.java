import javax.swing.*;

public class Fecha {
    private int mes;
    private int dia;
    private int anio;

    public Fecha(int mes, int dia, int anio) {
        this.mes = mes;
        this.dia = dia;
        this.anio = anio;
    }

    public int getMes() {
        return mes;
    }
    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getDia() {
        return dia;
    }
    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getAnio() {
        return anio;
    }
    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void mostrarFecha(){
        JOptionPane.showMessageDialog(null, "Fecha: " + getMes() + "/" + getDia() + "/" + getAnio());
    }
}

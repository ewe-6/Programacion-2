import javax.swing.*;

public class PruebaEmpleado {
    public static void main(String[] args) {
        Empleado e1 = new Empleado("", "", 0.0);
        Empleado e2 = new Empleado("", "", 0.0);

        JOptionPane.showMessageDialog(null, "EMPLEADO 1");
        e1.setPrimerNombre(JOptionPane.showInputDialog("Colocar el primer nombre "));
        e1.setApellidoPaterno(JOptionPane.showInputDialog("Colocar el apellido paterno "));
        e1.setSalarioMensual(Double.parseDouble(JOptionPane.showInputDialog("Colocar el salario mensual ")));

        JOptionPane.showMessageDialog(null, "EMPLEADO 2");
        e2.setPrimerNombre(JOptionPane.showInputDialog("Colocar el primer nombre "));
        e2.setApellidoPaterno(JOptionPane.showInputDialog("Colocar el apellido paterno "));
        e2.setSalarioMensual(Double.parseDouble(JOptionPane.showInputDialog("Colocar el salario mensual ")));

        JOptionPane.showMessageDialog(null, "Salario anual de los empleados:" + "\n"
                + "Empleado 1: " + e1.Salarioanual() + "\n"
                + "Empleado 2: " + e2.Salarioanual());

        JOptionPane.showMessageDialog(null, "Salario anual de los empleados con un aumento del 10%:" + "\n"
                + "Empleado 1: " + (1.1 * e1.Salarioanual()) + "\n"
                + "Empleado 2: " + (1.1 * e2.Salarioanual()));
    }
}
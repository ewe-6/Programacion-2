import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PerfilMedico p1 = new PerfilMedico("", "", "", 0, 0, 0, 0.0, 0.0);
        Scanner sc = new Scanner(System.in);
        int fCm;
        System.out.println("------------------ Paciente 1 ------------------");
        System.out.print("Colocar su primer nombre: ");
        p1.setPrimerNombre(sc.nextLine());
        System.out.print("Colocar su apellido: ");
        p1.setApellido(sc.nextLine());
        System.out.print("Colocar su sexo: ");
        p1.setSexo(sc.nextLine());
        System.out.print("Colocar el dia de su nacimiento: ");
        p1.setDia(Integer.parseInt(sc.nextLine()));
        System.out.print("Colocar el mes de su nacimiento: ");
        p1.setMes(Integer.parseInt(sc.nextLine()));
        System.out.print("Colocar el año de su nacimiento: ");
        p1.setAnio(Integer.parseInt(sc.nextLine()));
        System.out.print("Colocar su altura en cm: ");
        p1.setAltura(Double.parseDouble(sc.nextLine()));
        System.out.print("Colocar su peso en kg: ");
        p1.setPeso(Double.parseDouble(sc.nextLine()));
        System.out.println();
        System.out.println("Datos del paciente:");
        System.out.println("Primer nombre: " + p1.getPrimerNombre());
        System.out.println("Apellido: " + p1.getApellido());
        System.out.println("Sexo: " + p1.getSexo());
        System.out.println("Fecha de nacimiento (dd/mm/aaaa): " + p1.getDia() + "/" + p1.getMes() + "/" + p1.getAnio());
        System.out.println("Altura (cm): " + p1.getAltura());
        System.out.println("Peso (kg): " + p1.getPeso());
        System.out.println("Edad: " + p1.Edad());
        System.out.println("BMI: " + p1.Bm(p1.getAltura(), p1.getPeso()));
        fCm = p1.FrecuenciacardiacaMaxima(p1.Edad());
        System.out.println("Frecuencia cardiaca máxima: " + fCm);
        System.out.println("Rango de frecuencia cardiaca esperada: " + p1.RangominimoFc(fCm) + " - " + p1.RangomaximoFc(fCm));
        System.out.println();
        System.out.println("Tabla de valores de BMI:\n" +
                "Bajo peso: menos de 18.5\n" +
                "Normal: entre 18.5 y 24.9\n" +
                "Sobrepeso: entre 25 y 29.9\n" +
                "Obeso: 30 o más");
    }
}
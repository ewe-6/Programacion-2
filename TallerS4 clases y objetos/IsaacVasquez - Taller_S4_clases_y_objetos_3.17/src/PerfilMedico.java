import java.time.LocalDate;

public class PerfilMedico {
    public static final int constFcM = 220;

    private String primerNombre;
    private String apellido;
    private String sexo;
    private int dia;
    private int mes;
    private int anio;
    private double altura;
    private double peso;

    public PerfilMedico(String primerNombre, String apellido, String sexo, int dia, int mes, int anio, double altura, double peso) {
        this.primerNombre = primerNombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
        this.altura = altura;
        this.peso = peso;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }
    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getDia() {
        return dia;
    }
    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }
    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }
    public void setAnio(int anio) {
        this.anio = anio;
    }

    public double getAltura() {
        return altura;
    }
    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int Edad(){
        LocalDate hoy = LocalDate.now();
        int edad = hoy.getYear() - getAnio();
        if (hoy.getMonthValue() < getMes() ||
                (hoy.getMonthValue() == getMes() && hoy.getDayOfMonth() < getDia())) {
            edad--;
        }
        return edad;
    }

    public int FrecuenciacardiacaMaxima(int edad){
        int fCm;
        fCm = constFcM-edad;
        return fCm;
    }

    public Double RangominimoFc(int fCm){
        double ranMin;
        ranMin=fCm*0.5;
        return ranMin;
    }

    public Double RangomaximoFc(int fCm){
        double ranMax;
        ranMax=fCm*0.85;
        return ranMax;
    }

    public Double Bm (Double altura, Double peso){
        double ImC;
        ImC=peso/(Math.pow((altura/100), 2));
        return ImC;
    }
}

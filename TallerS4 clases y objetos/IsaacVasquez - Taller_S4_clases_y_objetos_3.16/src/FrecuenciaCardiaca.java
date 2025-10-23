import java.time.LocalDate;

public class FrecuenciaCardiaca {
    private String nombre;
    private String apellido;
    private int dia;
    private int mes;
    private int anio;

    public FrecuenciaCardiaca(String nombre, String apellido, int dia, int mes, int anio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
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

    public int calculoEdad(){
        LocalDate hoy = LocalDate.now();
        int edad = hoy.getYear() - anio;
        if (hoy.getMonthValue() < mes ||
                (hoy.getMonthValue() == mes && hoy.getDayOfMonth() < dia)) {
            edad--;
        }
        return edad;
    }

    public int frecuenciaCardiacamaxima(){
        return 220-calculoEdad();
    }

    public String frecuenciaEsperada(){
        double frecuencia = frecuenciaCardiacamaxima();
        double max;
        double min;
        max= frecuencia*0.85;
        min= frecuencia*0.5;
        return "Entre " + Double.toString(min) + " a " + Double.toString(max) + " pulsaciones por minuto";
    }

    public String mostrarDatos(int e, String fe) {
        String resultado;
        resultado = "Nombre: " + getNombre() + "\n" +
                "Apellido: " + getApellido() + "\n" +
                "Dia: " + Integer.toString(getDia()) + " Mes: " + Integer.toString(getMes()) + " Año: " + Integer.toString(getAnio()) + "\n" +
                "Edad: " + Integer.toString(e) + "\n" +
                "Frecuencia maxima: " + frecuenciaCardiacamaxima() + "\n" +
                "Rango de frecuencia: " + frecuenciaEsperada();
        return resultado;
    }
}

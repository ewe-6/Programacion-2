public class Factura {
    private String numeroPieza;
    private String descripcionPieza;
    private int cantidadComprar;
    private double precioPieza;

    public Factura(String numeroPieza, String descripcionPieza, int cantidadComprar, double precioPieza) {
        this.numeroPieza = numeroPieza;
        this.descripcionPieza = descripcionPieza;
        this.cantidadComprar = cantidadComprar;
        this.precioPieza = precioPieza;
    }

    public String getNumeroPieza() {
        return numeroPieza;
    }
    public void setNumeroPieza(String numeroPieza) {
        this.numeroPieza = numeroPieza;
    }

    public String getDescripcionPieza() {
        return descripcionPieza;
    }
    public void setDescripcionPieza(String descripcionPieza) {
        this.descripcionPieza = descripcionPieza;
    }

    public int getCantidadComprar() {
        return cantidadComprar;
    }
    public void setCantidadComprar(int cantidadComprar) {
        if (cantidadComprar<=0){
            cantidadComprar=0;
        }
        this.cantidadComprar = cantidadComprar;
    }

    public double getPrecioPieza() {
        return precioPieza;
    }
    public void setPrecioPieza(double precioPieza) {
        if (precioPieza<=0.0){
            precioPieza=0.0;
        }
        this.precioPieza = precioPieza;
    }

    public Double obtenerMontoFactura(){
        double precioTot;
        precioTot=getCantidadComprar()*getPrecioPieza();
        return precioTot;
    }
}

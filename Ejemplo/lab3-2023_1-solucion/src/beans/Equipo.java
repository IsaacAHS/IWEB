package beans;

public class Equipo {
    private String marca;
    private String tipo;
    private String cantidadDePuertos;
    private String numeroDeSerie;
    private float costo;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCantidadDePuertos() {
        return cantidadDePuertos;
    }

    public void setCantidadDePuertos(String cantidadDePuertos) {
        this.cantidadDePuertos = cantidadDePuertos;
    }

    public String getNumeroDeSerie() {
        return numeroDeSerie;
    }

    public void setNumeroDeSerie(String numeroDeSerie) {
        this.numeroDeSerie = numeroDeSerie;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }
}

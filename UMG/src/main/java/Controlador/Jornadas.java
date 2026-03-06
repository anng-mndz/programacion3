package Controlador;

public class Jornadas {

    private int Jor_codigo;
    private String Jor_nombre;

    public Jornadas() {
    }

    public Jornadas(int Jor_codigo, String Jor_nombre) {
        this.Jor_codigo = Jor_codigo;
        this.Jor_nombre = Jor_nombre;
    }

    public int getJor_codigo() {
        return Jor_codigo;
    }

    public void setJor_codigo(int Jor_codigo) {
        this.Jor_codigo = Jor_codigo;
    }

    public String getJor_nombre() {
        return Jor_nombre;
    }

    public void setJor_nombre(String Jor_nombre) {
        this.Jor_nombre = Jor_nombre;
    }

    @Override
    public String toString() {
        return "Jornadas{" +
                "Jor_codigo=" + Jor_codigo +
                ", Jor_nombre=" + Jor_nombre +
                '}';
    }
}
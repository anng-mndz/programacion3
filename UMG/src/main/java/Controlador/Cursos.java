package Controlador;

public class Cursos {

    private int curCodigo;
    private String curNombre;
    private String curEstatus;

    public Cursos() {
    }

    public Cursos(int curCodigo, String curNombre, String curEstatus) {
        this.curCodigo = curCodigo;
        this.curNombre = curNombre;
        this.curEstatus = curEstatus;
    }

    public int getCurCodigo() {
        return curCodigo;
    }

    public void setCurCodigo(int curCodigo) {
        this.curCodigo = curCodigo;
    }

    public String getCurNombre() {
        return curNombre;
    }

    public void setCurNombre(String curNombre) {
        this.curNombre = curNombre;
    }

    public String getCurEstatus() {
        return curEstatus;
    }

    public void setCurEstatus(String curEstatus) {
        this.curEstatus = curEstatus;
    }

    @Override
    public String toString() {
        return "Cursos{" +
                "curCodigo=" + curCodigo +
                ", curNombre=" + curNombre +
                ", curEstatus=" + curEstatus +
                '}';
    }
}
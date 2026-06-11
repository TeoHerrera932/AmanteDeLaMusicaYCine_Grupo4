package control;
import objetosNegocio.Cancion;

import java.util.ArrayList;

public class Tabla {
    private String titulo;
    private ArrayList nombresColumnas;
    private ArrayList celdas;

    public Tabla(){
    }

    public Tabla(String titulo, ArrayList nombresColumnas, ArrayList celdas){
        this.titulo = titulo;
        this.nombresColumnas = nombresColumnas;
        this.celdas = celdas;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public ArrayList getNombresColumnas() {
        return nombresColumnas;
    }
    public void setNombresColumnas(ArrayList nombresColumnas) {
        this.nombresColumnas = nombresColumnas;
    }
    public ArrayList getCeldas() {
        return celdas;
    }

    public void setCeldas(ArrayList celdas) {
        this.celdas = celdas;
    }
}

package objetosNegocio;

import java.util.Objects;

public class Genero {
    private String cveGenero;
    private String nombre;
    private char tipoMedio;

    public Genero() {}
    public Genero(String cveGenero, String nombre, char tipoMedio) {
        this.cveGenero = cveGenero;
        this.nombre = nombre;
        this.tipoMedio = tipoMedio;
    }
    public Genero(String cveGenero) {
        this(cveGenero, null, ' ');
    }

    public String getCveGenero() {
        return cveGenero;
    }
    public void setCveGenero(String cveGenero) {
        this.cveGenero = cveGenero;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public char getTipoMedio() {
        return tipoMedio;
    }

    public void setTipoMedio(char tipoMedio) {
        this.tipoMedio = tipoMedio;
    }
    //Corrección de sintaxis
    @Override
    public boolean equals(Object obj) {
        // Si el parámetro es nulo regresa falso
        if (obj == null) {
            return false;
        }

        // Si no es de la clase Genero regresa falso
        if (getClass() != obj.getClass()) {
            return false;
        }

        final Genero other = (Genero) obj;

        // Compara las claves (maneja nulls correctamente)
        if (!Objects.equals(this.cveGenero, other.cveGenero)) {
            return false;
        }

        return true;
    }
    @Override
    public int hashCode() {
        int hash = 7;
        //Calcula el c;odigo hash para este genero en función del codigo hash de la clave
        hash = 71 * hash + (this.cveGenero != null ? this.cveGenero.hashCode() : 0);
        return hash;
    }
    @Override
    public String toString() {
        return cveGenero + ", "+nombre+", "+tipoMedio;
    }
}
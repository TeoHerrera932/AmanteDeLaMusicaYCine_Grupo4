package objetosNegocio;
import objetosServicio.Fecha;

public class Medio {
    protected String clave;
    protected String titulo;
    protected Genero genero;
    protected int duracion;
    protected Fecha fecha;

    public Medio() {
    }
    public Medio (String clave, String titulo, Genero genero, int duracion, Fecha fecha){
        this.clave = clave;
        this.titulo = titulo;
        this.genero = genero;
        this.duracion = duracion;
        this.fecha = fecha;
    }
    public String getClave() {
        return clave;
    }
    public void setClave(String clave) {
        this.clave = clave;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Genero getGenero() {
            return genero;
    }
    public void setGenero(Genero genero){
        this.genero = genero;
    }
    public int getDuracion() {
        return duracion;
    }
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }
    @Override
    public boolean equals(Object obj) {
        //Si el parametro es nulo regresa falso
        if (obj == null){
            return false;
        }
        //Si el parametro no es de la clase medio regresa falso
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Medio other = (Medio) obj;
        if ((this.clave == null) ? (other.clave != null) : !this.clave.equals(other.clave){
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash +(this.clave != null ? this.clave.hashCode() : 0);
        return hash;
    }
    @Override
    public String toString() {
        return clave+", "+titulo+", "+genero+", "+duracion+", "+fecha;
    }
}
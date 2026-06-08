package objetosNegocio;
import objetosServicio.Fecha;

public class Cancion extends Medio{
    private String interprete;
    private String autor;
    private String album;
    public Cancion() {
        super();
    }
    public Cancion(String clave, String titulo, Genero genero, String interprete,
                   String autor, String album, int duracion, Fecha fecha) {
        super(clave, titulo,genero, duracion, fecha);
        this.interprete = interprete;
        this.autor = autor;
        this.album = album;
    }
    public Cancion(String clave) {
        this(clave, null, null, null, null, 0,null);
    }
    public String getInterprete() {
        return interprete;
    }
    public void setInterprete(String interprete) {
        this.interprete = interprete;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public String getAlbum() {
        return album;
    }
    public void setAlbum(String album) {
        this.album = album;
    }
    @Override
    public String toString() {
        return super.toString() + ", "+ interprete + ", " + autoLetra + ", "+
                autorMusica + ", "+ album +", "+ disquera;
    }
}
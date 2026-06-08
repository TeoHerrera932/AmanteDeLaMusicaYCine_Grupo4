package fachadas;

import java.util.ArrayList;

import excepciones.FachadaException;
import excepciones.PersistenciaException;
import interfaces.IFachada;
import objetosNegocio.Cancion;
import objetosNegocio.Genero;
import objetosNegocio.Pelicula;
import objetosServicio.Periodo;
import persistencia.Canciones;
import persistencia.Generos;
import persistencia.Peliculas;

public class FachadaArchivos implements IFachada {
    private Canciones catalogoCanciones;
    private Peliculas catalogoPeliculas;
    private Generos catalogoGeneros;

    public FachadaArchivos() {
        catalogoCanciones = new Canciones("canciones.dat");
        catalogoPeliculas = new Peliculas("peliculas.dat");
        catalogoGeneros = new Generos("generos.dat");
    }

    public Cancion obten(Cancion cancion) throws FachadaException {
        try {
            Cancion cancionBuscada = catalogoCanciones.obten(cancion);
            if (cancionBuscada != null) {
                Genero genero = catalogoGeneros.obten(cancionBuscada.getGenero());
                cancionBuscada.setGenero(genero);
            }
            return cancionBuscada;
        } catch (PersistenciaException pe) {
            throw new FachadaException("No se puede obtener la canción", pe);
        }
    }

    public void agrega(Cancion cancion) throws FachadaException {
        try {
            Cancion cancionBuscada = catalogoCanciones.obten(cancion);
            if (cancionBuscada != null) {
                throw new FachadaException("Canción repetida");
            }
        } catch (PersistenciaException pe) {
            // Si el archivo no existe no se hace nada
        }
        try {
            catalogoCanciones.agrega(cancion);
        } catch (PersistenciaException pe) {
            throw new FachadaException("No se puede agregar la canción", pe);
        }
    }

    public void actualiza(Cancion cancion) throws FachadaException {
        try {
            catalogoCanciones.actualiza(cancion);
        } catch (PersistenciaException pe) {
            throw new FachadaException("No se puede actualizar la canción", pe);
        }
    }

    public void elimina(Cancion cancion) throws FachadaException {
        try {
            catalogoCanciones.elimina(cancion);
        } catch (PersistenciaException pe) {
            throw new FachadaException("No se puede eliminar la canción", pe);
        }
    }

    public Pelicula obten(Pelicula pelicula) throws FachadaException {
        try {
            Pelicula peliculaBuscada = catalogoPeliculas.obten(pelicula);
            if (peliculaBuscada != null) {
                Genero genero = catalogoGeneros.obten(peliculaBuscada.getGenero());
                peliculaBuscada.setGenero(genero);
            }
            return peliculaBuscada;
        } catch (PersistenciaException pe) {
            throw new FachadaException("No se puede obtener la película", pe);
        }
    }

    public void agrega(Pelicula pelicula) throws FachadaException {
        try {
            Pelicula peliculaBuscada = catalogoPeliculas.obten(pelicula);
            if (peliculaBuscada != null) {
                throw new FachadaException("Película repetida");
            }
        } catch (PersistenciaException pe) {
            // Si el archivo no existe no se hace nada
        }
        try {
            catalogoPeliculas.agrega(pelicula);
        } catch (PersistenciaException pe) {
            throw new FachadaException("No se puede agregar la película", pe);
        }
    }

    public void actualiza(Pelicula pelicula) throws FachadaException {
        try {
            catalogoPeliculas.actualiza(pelicula);
        } catch (PersistenciaException pe) {
            throw new FachadaException("No se puede actualizar la película", pe);
        }
    }

    public void elimina(Pelicula pelicula) throws FachadaException {
        try {
            catalogoPeliculas.elimina(pelicula);
        } catch (PersistenciaException pe) {
            throw new FachadaException("No se puede eliminar la película", pe);
        }
    }

    public Genero obten(Genero genero) throws FachadaException {
        try {
            return catalogoGeneros.obten(genero);
        } catch (PersistenciaException pe) {
            throw new FachadaException("No se puede obtener el género", pe);
        }
    }

    public void agrega(Genero genero) throws FachadaException {
        try {
            Genero generoBuscado = catalogoGeneros.obten(genero);
            if (generoBuscado != null) {
                throw new FachadaException("Género repetido");
            }
        } catch (PersistenciaException pe) {
            // Si el archivo no existe no se hace nada
        }
        try {
            catalogoGeneros.agrega(genero);
        } catch (PersistenciaException pe) {
            throw new FachadaException("No se puede agregar el género", pe);
        }
    }

    public void actualiza(Genero genero) throws FachadaException {
        try {
            catalogoGeneros.actualiza(genero);
        } catch (PersistenciaException pe) {
            throw new FachadaException("No se puede actualizar el género", pe);
        }
    }

    public void elimina(Genero genero) throws FachadaException {
        try {
            catalogoGeneros.elimina(genero);
        } catch (PersistenciaException pe) {
            throw new FachadaException("No se puede eliminar el género", pe);
        }
    }

    private ArrayList agregaGeneroCanciones(ArrayList listaCanciones) throws FachadaException {
        try {
            for (int i = 0; i < listaCanciones.size(); i++) {
                Cancion cancion = (Cancion) listaCanciones.get(i);
                Genero genero = catalogoGeneros.obten(cancion.getGenero());
                cancion.setGenero(genero);
                listaCanciones.set(i, cancion);
            }
            return listaCanciones;
        } catch (PersistenciaException pe) {
            throw new FachadaException("No se puede obtener la lista de canciones", pe);
        }
    }

    private ArrayList agregaGeneroPeliculas(ArrayList listaPeliculas) throws FachadaException {
        try {
            for (int i = 0; i < listaPeliculas.size(); i++) {
                Pelicula pelicula = (Pelicula) listaPeliculas.get(i);
                Genero genero = catalogoGeneros.obten(pelicula.getGenero());
                pelicula.setGenero(genero);
                listaPeliculas.set(i, pelicula);
            }
            return listaPeliculas;
        } catch (PersistenciaException pe) {
            throw new FachadaException("No se puede obtener la lista de películas", pe);
        }
    }

    public ArrayList consultaCanciones() throws FachadaException {
        try {
            return agregaGeneroCanciones(new ArrayList(catalogoCanciones.lista()));
        } catch (PersistenciaException pe) {
            throw new FachadaException("No se puede obtener la lista de canciones", pe);
        }
    }

    public ArrayList consultaCancionesTitulo() throws FachadaException {
        return consultaCanciones();
    }

    public ArrayList consultaCancionesInterprete() throws FachadaException {
        return consultaCanciones();
    }

    public ArrayList consultaCancionesAutor() throws FachadaException {
        return consultaCanciones();
    }

    public ArrayList consultaCancionesGenero() throws FachadaException {
        return consultaCanciones();
    }

    public ArrayList consultaCancionesAlbum() throws FachadaException {
        return consultaCanciones();
    }

    public ArrayList consultaCancionesPeriodo() throws FachadaException {
        return consultaCanciones();
    }

    public ArrayList consultaCancionesTitulo(String titulo) throws FachadaException {
        try {
            return agregaGeneroCanciones(new ArrayList(catalogoCanciones.listaTitulo(titulo)));
        } catch (PersistenciaException pe) {
            throw new FachadaException("No se puede obtener la lista de canciones", pe);
        }
    }

    public ArrayList consultaCancionesInterprete(String interprete) throws FachadaException {
        try {
            return agregaGeneroCanciones(new ArrayList(catalogoCanciones.listaInterprete(interprete)));
        } catch (PersistenciaException pe) {
            throw new FachadaException("No se puede obtener la lista de canciones", pe);
        }
    }

    public ArrayList consultaCancionesAutor(String autor) throws FachadaException {
        try {
            return agregaGeneroCanciones(new ArrayList(catalogoCanciones.listaAutor(autor)));
        } catch (PersistenciaException pe) {
            throw new FachadaException("No se puede obtener la lista de canciones", pe);
        }
    }

    public ArrayList consultaCancionesGenero(String cveGenero) throws FachadaException {
        try {
            return agregaGeneroCanciones(new ArrayList(catalogoCanciones.listaGenero(cveGenero)));
        } catch (PersistenciaException pe) {
            throw new FachadaException("No se puede obtener la lista de canciones", pe);
        }
    }

    public ArrayList consultaCancionesAlbum(String album) throws FachadaException {
        try {
            return agregaGeneroCanciones(new ArrayList(catalogoCanciones.listaAlbum(album)));
        } catch (PersistenciaException pe) {
            throw new FachadaException("No se puede obtener la lista de canciones", pe);
        }
    }

    public ArrayList consultaCancionesPeriodo(Periodo periodo) throws FachadaException {
        try {
            return agregaGeneroCanciones(new ArrayList(catalogoCanciones.listaPeriodo(periodo)));
        } catch (PersistenciaException pe) {
            throw new FachadaException("No se puede obtener la lista de canciones", pe);
        }
    }

    public ArrayList consultaPeliculas() throws FachadaException {
        try {
            return agregaGeneroPeliculas(new ArrayList(catalogoPeliculas.lista()));
        } catch (PersistenciaException pe) {
            throw new FachadaException("No se puede obtener la lista de películas", pe);
        }
    }

    public ArrayList consultaPeliculasTitulo() throws FachadaException {
        return consultaPeliculas();
    }

    public ArrayList consultaPeliculasActor() throws FachadaException {
        return consultaPeliculas();
    }

    public ArrayList consultaPeliculasDirector() throws FachadaException {
        return consultaPeliculas();
    }

    public ArrayList consultaPeliculasGenero() throws FachadaException {
        return consultaPeliculas();
    }

    public ArrayList consultaPeliculasPeriodo() throws FachadaException {
        return consultaPeliculas();
    }

    public ArrayList consultaPeliculasTitulo(String titulo) throws FachadaException {
        try {
            return agregaGeneroPeliculas(new ArrayList(catalogoPeliculas.listaTitulo(titulo)));
        } catch (PersistenciaException pe) {
            throw new FachadaException("No se puede obtener la lista de películas", pe);
        }
    }

    public ArrayList consultaPeliculasActor(String actor) throws FachadaException {
        try {
            return agregaGeneroPeliculas(new ArrayList(catalogoPeliculas.listaActor(actor)));
        } catch (PersistenciaException pe) {
            throw new FachadaException("No se puede obtener la lista de películas", pe);
        }
    }

    public ArrayList consultaPeliculasDirector(String director) throws FachadaException {
        try {
            return agregaGeneroPeliculas(new ArrayList(catalogoPeliculas.listaDirector(director)));
        } catch (PersistenciaException pe) {
            throw new FachadaException("No se puede obtener la lista de películas", pe);
        }
    }

    public ArrayList consultaPeliculasGenero(String cveGenero) throws FachadaException {
        try {
            return agregaGeneroPeliculas(new ArrayList(catalogoPeliculas.listaGenero(cveGenero)));
        } catch (PersistenciaException pe) {
            throw new FachadaException("No se puede obtener la lista de películas", pe);
        }
    }

    public ArrayList consultaPeliculasPeriodo(Periodo periodo) throws FachadaException {
        try {
            return agregaGeneroPeliculas(new ArrayList(catalogoPeliculas.listaPeriodo(periodo)));
        } catch (PersistenciaException pe) {
            throw new FachadaException("No se puede obtener la lista de películas", pe);
        }
    }

    public ArrayList consultaGeneros() throws FachadaException {
        try {
            return new ArrayList(catalogoGeneros.lista());
        } catch (PersistenciaException pe) {
            throw new FachadaException("No se puede obtener la lista de géneros", pe);
        }
    }

    public ArrayList consultaGenerosCanciones() throws FachadaException {
        try {
            return new ArrayList(catalogoGeneros.listaMedio('C'));
        } catch (PersistenciaException pe) {
            throw new FachadaException("No se puede obtener la lista de géneros", pe);
        }
    }

    public ArrayList consultaGenerosPeliculas() throws FachadaException {
        try {
            return new ArrayList(catalogoGeneros.listaMedio('P'));
        } catch (PersistenciaException pe) {
            throw new FachadaException("No se puede obtener la lista de géneros", pe);
        }
    }
}

/*package fachadas;

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

public class FachadaArreglos implements IFachada {

    private Generos catalogoGeneros;
    private Canciones catalogoCanciones;
    private Peliculas catalogoPeliculas;

    public FachadaArreglos() {
        catalogoGeneros = new Generos("generos.dat");
        catalogoCanciones = new Canciones("canciones.dat");
        catalogoPeliculas = new Peliculas("peliculas.dat");
    }

    // ====================== CANCIONES ======================
    @Override
    public Cancion obten(Cancion cancion) throws FachadaException {
        try {
            return catalogoCanciones.obten(cancion);
        } catch (PersistenciaException pe) {
            throw new FachadaException("No se puede obtener la cancion", pe);
        }
    }

    @Override
    public void agrega(Cancion cancion) throws FachadaException {
        try {
            Cancion cancionBuscada = catalogoCanciones.obten(cancion);
            if (cancionBuscada != null) {
                throw new FachadaException("Cancion repetida");
            }
        } catch (PersistenciaException pe) {
            // Si el archivo no existe no se hace nada
        }
        try {
            catalogoCanciones.agrega(cancion);
        } catch (PersistenciaException pe) {
            throw new FachadaException("No se puede agregar la cancion", pe);
        }
    }

    @Override
    public void actualiza(Cancion cancion) throws FachadaException {
        try {
            catalogoCanciones.actualiza(cancion);
        } catch (PersistenciaException pe) {
            throw new FachadaException("No se puede actualizar la cancion", pe);
        }
    }

    @Override
    public void elimina(Cancion cancion) throws FachadaException {
        try {
            catalogoCanciones.elimina(cancion);
        } catch (PersistenciaException pe) {
            throw new FachadaException("No se puede eliminar la cancion", pe);
        }
    }

    // ====================== PELICULAS ======================
    @Override
    public Pelicula obten(Pelicula pelicula) throws FachadaException {
        try {
            return catalogoPeliculas.obten(pelicula);
        } catch (PersistenciaException pe) {
            throw new FachadaException("No se puede obtener la pelicula", pe);
        }
    }

    @Override
    public void agrega(Pelicula pelicula) throws FachadaException {
        try {
            Pelicula peliculaBuscada = catalogoPeliculas.obten(pelicula);
            if (peliculaBuscada != null) {
                throw new FachadaException("Pelicula repetida");
            }
        } catch (PersistenciaException pe) {
            // Si el archivo no existe no se hace nada
        }
        try {
            catalogoPeliculas.agrega(pelicula);
        } catch (PersistenciaException pe) {
            throw new FachadaException("No se puede agregar la pelicula", pe);
        }
    }

    @Override
    public void actualiza(Pelicula pelicula) throws FachadaException {
        try {
            catalogoPeliculas.actualiza(pelicula);
        } catch (PersistenciaException pe) {
            throw new FachadaException("No se puede actualizar la pelicula", pe);
        }
    }

    @Override
    public void elimina(Pelicula pelicula) throws FachadaException {
        try {
            catalogoPeliculas.elimina(pelicula);
        } catch (PersistenciaException pe) {
            throw new FachadaException("No se puede eliminar la pelicula", pe);
        }
    }

    // ====================== GENEROS ======================
    @Override
    public Genero obten(Genero genero) throws FachadaException {
        try {
            return catalogoGeneros.obten(genero);
        } catch (PersistenciaException pe) {
            throw new FachadaException("No se puede obtener el genero", pe);
        }
    }

    @Override
    public void agrega(Genero genero) throws FachadaException {
        try {
            Genero generoBuscado = catalogoGeneros.obten(genero);
            if (generoBuscado != null) {
                throw new FachadaException("Genero repetido");
            }
        } catch (PersistenciaException pae) {
            // Si el archivo no existe no se hace nada
        }
        try {
            catalogoGeneros.agrega(genero);
        } catch (PersistenciaException pae) {
            throw new FachadaException("No se puede agregar el genero", pae);
        }
    }

    @Override
    public void actualiza(Genero genero) throws FachadaException {
        try {
            catalogoGeneros.actualiza(genero);
        } catch (PersistenciaException pae) {
            throw new FachadaException("No se puede actualizar el genero", pae);
        }
    }

    @Override
    public void elimina(Genero genero) throws FachadaException {
        try {
            catalogoGeneros.elimina(genero);
        } catch (PersistenciaException pae) {
            throw new FachadaException("No se puede eliminar el genero", pae);
        }
    }

    // ====================== CONSULTAS CANCIONES ======================
    @Override
    public ArrayList consultaCanciones() {
        return catalogoCanciones.lista();
    }

    @Override
    public ArrayList consultaCancionesTitulo() {
        return consultaCanciones();
    }

    @Override
    public ArrayList consultaCancionesInterprete() {
        return consultaCanciones();
    }

    @Override
    public ArrayList consultaCancionesAutor() {
        return consultaCanciones();
    }

    @Override
    public ArrayList consultaCancionesGenero() {
        return consultaCanciones();
    }

    @Override
    public ArrayList consultaCancionesAlbum() {
        return consultaCanciones();
    }

    @Override
    public ArrayList consultaCancionesPeriodo() {
        return consultaCanciones();
    }

    @Override
    public ArrayList consultaCancionesTitulo(String titulo) {
        return catalogoCanciones.listaTitulo(titulo);
    }

    @Override
    public ArrayList consultaCancionesInterprete(String interprete) {
        return catalogoCanciones.listaInterprete(interprete);
    }

    @Override
    public ArrayList consultaCancionesAutor(String autor) {
        return catalogoCanciones.listaAutor(autor);
    }

    @Override
    public ArrayList consultaCancionesGenero(String cveGenero) {
        return catalogoCanciones.listaGenero(cveGenero);
    }

    @Override
    public ArrayList consultaCancionesAlbum(String album) {
        return catalogoCanciones.listaAlbum(album);
    }

    @Override
    public ArrayList consultaCancionesPeriodo(Periodo periodo) {
        return catalogoCanciones.listaPeriodo(periodo);
    }

    // ====================== CONSULTAS PELICULAS ======================
    @Override
    public ArrayList consultaPeliculas() {
        return catalogoPeliculas.lista();
    }

    @Override
    public ArrayList consultaPeliculasTitulo() {
        return consultaPeliculas();
    }

    @Override
    public ArrayList consultaPeliculasActor() {
        return consultaPeliculas();
    }

    @Override
    public ArrayList consultaPeliculasDirector() {
        return consultaPeliculas();
    }

    @Override
    public ArrayList consultaPeliculasGenero() {
        return consultaPeliculas();
    }

    @Override
    public ArrayList consultaPeliculasTitulo(String titulo) {
        return catalogoPeliculas.listaTitulo(titulo);
    }

    @Override
    public ArrayList consultaPeliculasActor(String actor) {
        return catalogoPeliculas.listaActor(actor);
    }

    @Override
    public ArrayList consultaPeliculasDirector(String director) {
        return catalogoPeliculas.listaDirector(director);
    }

    @Override
    public ArrayList consultaPeliculasGenero(String cveGenero) {
        return catalogoPeliculas.listaGenero(cveGenero);
    }

    @Override
    public ArrayList consultaPeliculasPeriodo() {          // ← Método que faltaba
        return catalogoPeliculas.lista();
    }

    public ArrayList consultaPeliculasPeriodo(Periodo periodo) {
        return catalogoPeliculas.listaPeriodo(periodo);
    }

    // ====================== CONSULTAS GENEROS ======================
    @Override
    public ArrayList consultaGeneros() {
        return catalogoGeneros.lista();
    }

    @Override
    public ArrayList consultaGenerosCanciones() {
        return catalogoGeneros.listaMedio('C');
    }

    @Override
    public ArrayList consultaGenerosPeliculas() {
        return catalogoGeneros.listaMedio('P');
    }
}*/
package interfaces;

import java.util.ArrayList;

import excepciones.PersistenciaException;
import objetosServicio.*;
import objetosNegocio.*;
import excepciones.FachadaException;

public interface IFachada {
    public Cancion obten(Cancion cancion) throws FachadaException;
    public void agrega(Cancion cancion) throws FachadaException;
    public void actualiza(Cancion cancion) throws FachadaException;
    public void elimina(Cancion cancion) throws FachadaException;
    public Pelicula obten(Pelicula pelicula) throws FachadaException;
    public void agrega (Pelicula pelicula) throws FachadaException;
    public void actualiza (Pelicula pelicula) throws FachadaException;
    public void elimina (Pelicula pelicula) throws FachadaException;
    public Genero obten(Genero genero) throws FachadaException;
    public void agrega (Genero genero) throws FachadaException;
    public void actualiza (Genero genero) throws FachadaException;
    public void elimina (Genero genero) throws FachadaException;
    public ArrayList consultaCanciones() throws FachadaException;
    public ArrayList consultaCancionesTitulo() throws FachadaException;
    public ArrayList consultaCancionesTitulo(String titulo) throws FachadaException;
    public ArrayList consultaCancionesInterprete() throws FachadaException;
    public ArrayList consultaCancionesInterprete(String interprete) throws FachadaException;
    public ArrayList consultaCancionesAutor() throws FachadaException;
    public ArrayList consultaCancionesAutor(String autor) throws FachadaException;
    public ArrayList consultaCancionesGenero() throws FachadaException;
    public ArrayList consultaCancionesGenero(String cveGenero) throws FachadaException;
    public ArrayList consultaCancionesAlbum() throws FachadaException;
    public ArrayList consultaCancionesAlbum(String album) throws FachadaException;
    public ArrayList consultaCancionesPeriodo() throws FachadaException;
    public ArrayList consultaCancionesPeriodo(Periodo periodo) throws FachadaException;
    public ArrayList consultaPeliculas() throws FachadaException;
    public ArrayList consultaPeliculasTitulo() throws FachadaException;
    public ArrayList consultaPeliculasTitulo(String titulo) throws FachadaException;
    public ArrayList consultaPeliculasActor() throws FachadaException;
    public ArrayList consultaPeliculasActor(String actor) throws FachadaException;
    public ArrayList consultaPeliculasDirector() throws FachadaException;
    public ArrayList consultaPeliculasDirector(String director) throws FachadaException;
    public ArrayList consultaPeliculasGenero() throws FachadaException;
    public ArrayList consultaPeliculasGenero(String cveGenero) throws FachadaException;
    public ArrayList consultaPeliculasPeriodo() throws FachadaException;
    public ArrayList consultaPeliculasPeriodo(Periodo periodo) throws FachadaException;
    public ArrayList consultaGeneros() throws FachadaException;
    public ArrayList consultaGenerosCanciones() throws FachadaException;
    public ArrayList consultaGenerosPeliculas() throws FachadaException;
}

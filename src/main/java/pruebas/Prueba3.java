package pruebas;

import java.util.ArrayList;

import objetosServicio.*;
import objetosNegocio.*;
import excepciones.FachadaException;
import interfaces.IFachada;
import fachadas.FachadaArchivos;

public class Prueba3 {
    public static void main(String[] args) {
        Prueba3 prueba3 = new Prueba3();

        IFachada fachada = new FachadaArchivos();
        ArrayList lista = null;
        Genero genero;
        Cancion cancion = null;

        Genero genero1 = new Genero("GC001","Balada",'C');
        Genero genero2 = new Genero("GC002","Bossanova",'C');
        Genero genero3 = new Genero("GC003","Rock",'C');

        try{
            fachada.agrega(genero1);
            System.out.println("Se agrego el genero 1 al catálogo de géneros");
        }
        catch(FachadaException fe){
            System.out.println("ERROR: "+fe.getMessage()+"1");
        }
        try{
            fachada.agrega(genero2);
            System.out.println("Se agrego el género 2 al catálogo de géneros");
        }
        catch (FachadaException fe){
            System.out.println("ERROR: "+fe.getMessage()+"2");
        }
        try{
            fachada.agrega(genero3);
            System.out.println("Se agregó el género 3 al catálogo de géneros");
        }
        catch (FachadaException fe){
            System.out.println("ERROR: "+fe.getMessage()+"3");
        }
        try{
            fachada.agrega(genero1);
            System.out.println("Se agregó el género 1 al catálogo de géneros");
        }
        catch (FachadaException fe){
            System.out.println("ERROR: "+fe.getMessage()+"1");
        }
        //Se crean 3 generos de peliculas
        Genero genero4 = new Genero("GP001","Drama",'P');
        Genero genero5 = new Genero("GP002","Ciencia Ficcion",'P');
        Genero genero6 = new Genero("GP003","Comedia",'P');
        //Se agregan al catalogo
        try{
            fachada.agrega(genero4);
            System.out.println("Se agrego el género 4 al catálogo de géneros");
        }catch(FachadaException fe){
            System.out.println("ERROR: "+fe.getMessage()+"4");
        }
        try{
            fachada.agrega(genero5);
            System.out.println("Se agrego el género 5 al catálogo de géneros");
        }catch(FachadaException fe){
            System.out.println("ERROR: "+fe.getMessage()+"5");
        }
        try{
            fachada.agrega(genero6);
            System.out.println("Se agrego el género 6 al catálogo de géneros");
        }catch(FachadaException fe){
            System.out.println("ERROR: "+fe.getMessage()+"6");
        }
        //Despliega el contenido del catalogo
        System.out.println("Lista de géneros");
        try {
            System.out.println(fachada.consultaGeneros());
        }catch(FachadaException fe){
            System.out.println("ERROR: "+fe.getMessage());
        }
        //Se modifica el genero de clave GC002 a Samba
        try{
            genero = fachada.obten(new Genero("GC002"));
            genero.setNombre("Samba");
            fachada.actualiza(genero);
            System.out.println("Se actualizó el genero de clave GC002");
        }catch(FachadaException fe){
            System.out.println("ERROR: "+fe.getMessage()+"GC002");
        }
        //Se elimina el género "GP003" del catalogo de generos
        try{
            fachada.elimina(new Genero("GP003"));
            System.out.println("Se elimino el genero de clave GP003");
        }catch(FachadaException fe){
            System.out.println("ERROR: "+fe.getMessage()+"GP003");
        }
        //Se elimina el genero "GP004 inexistente"
        try{
            fachada.elimina(new Genero("GP004"));
            System.out.println("Se elimino el genero de clave GP004");
        }catch(FachadaException fe){
            System.out.println("ERROR: "+fe.getMessage()+"GP004");
        }
        //Despliega el contenido del catalogo
        System.out.println("Lista de géneros");
        try {
            System.out.println(fachada.consultaGeneros());
        }catch(FachadaException fe){
            System.out.println("ERROR: "+fe.getMessage());
        }
        //Despliega el contenido de catalogo de canciones
        try {
            System.out.println(fachada.consultaGenerosCanciones());
        }catch(FachadaException fe){
            System.out.println("ERROR: "+fe.getMessage());
        }
        //Ahora de peliculas
        try {
            System.out.println(fachada.consultaGenerosPeliculas());
        }catch(FachadaException fe){
            System.out.println("ERROR: "+fe.getMessage());
        }
        //Se crean 3 canciones
        Cancion cancion1 = new Cancion("C0001", "The long and winding road", genero1, "The Beatles",
                "Jhon Lennon", "Let it be", 3, new Fecha(24, 3, 1970));
        Cancion cancion2 = new Cancion("C0002", "Garota de Ipanema",genero2, "Los Indios Tabajaras",
                "Antonio Carlos Jobim", "Bossanova Jazz Vol. 1", 3, new Fecha(1, 12, 1970));
        Cancion cancion3 = new Cancion("C0003", "Desafinado", genero2, "Joao Gilberto", "Joao Gilberto",
                "Bossanova Jazz Vol. 1", 3, new Fecha(3, 12, 1980));
        //Se agrega la cancion 1 al catalogo
        try{
            fachada.agrega(cancion1);
            System.out.println("Se agregó la canción 1");
        }catch(FachadaException fe){
            System.out.println("ERROR: "+fe.getMessage()+"1");
        }
        //Se agrega la cancion 1 al catalogo denuevo
        try{
            fachada.agrega(cancion1);
            System.out.println("Se agregó la canción 1");
        }catch(FachadaException fe){
            System.out.println("ERROR: "+fe.getMessage()+"1");
        }
        //Se agrega la cancion 2 al catalogo
        try{
            fachada.agrega(cancion2);
            System.out.println("Se agregó la canción 2");
        }catch(FachadaException fe){
            System.out.println("ERROR: "+fe.getMessage()+"2");
        }
        //Se agrega la cancion 3 al catalogo
        try{
            fachada.agrega(cancion3);
            System.out.println("Se agregó la canción 3");
        }catch(FachadaException fe){
            System.out.println("ERROR: "+fe.getMessage()+"3");
        }
        //Se lista el catálogo de canciones
        System.out.println("Lista de canciones");
        try{
            lista= fachada.consultaCanciones();
            System.out.println(lista);
        }catch(FachadaException fe){
            System.out.println("ERROR: "+fe.getMessage());
        }
        //Se actualiza la cancion de clave "C0001" al genero GC003
        try{
            genero = fachada.obten(new Genero("GC003"));
            if(genero != null){
                if (cancion != null){
                    //Se actualiza la cancion 1
                    cancion.setGenero(genero);
                    fachada.actualiza(cancion);
                    System.out.println("Se actualizo la canción de clave C0001 al genero GC003");
                }else System.out.println("No existe la cancion C0001");
            }else System.out.println("No exixte el genero GC003");
        }catch(FachadaException fe){
            //Mensaje de error
            System.out.println("ERROR: "+fe.getMessage());
        }
        //Se elimina la cancion de clave C0003
        try{
            fachada.elimina(new Cancion("C0003"));
            System.out.println("Se elimina la cancion de clave C0003");
        }catch(FachadaException fe){
            System.out.println("ERROR: "+fe.getMessage());
        }
        //Se lista el catalogo de canciones
        System.out.println("Lista de canciones");
        try{
            lista = fachada.consultaCanciones();
            System.out.println(lista);
        }catch(FachadaException fe){
            System.out.println("ERROR: "+fe.getMessage());
        }
        //Se lista las canciones con el interprete "The Beatles"
        System.out.println("Lista de canciones de The Beatles");
        try{
            lista = fachada.consultaCancionesInterprete("The Beatles");
            System.out.println(lista);
        }catch(FachadaException fe){
            //Muestra el mensaje de error amistoso
            System.out.println("ERROR: "+fe.getMessage());
        }
        //Se lista las canciones de samba, "GC002"
        System.out.println("Lista de canciones de Samba: ");
        try{
            lista = fachada.consultaCancionesGenero("GC002");
            System.out.println(lista);
        }catch (FachadaException fe){
            System.out.println("ERROR: "+fe.getMessage());
        }

        //Se crean dos peliculas
        Pelicula pelicula1 = new Pelicula("P000001","Casa Blanca", genero4,
                "Humphrey Bogart", "Ingrid Bergman", "Michael Curtiz",
                1002, new Fecha( 1, 1, 1942));
        Pelicula pelicula2 = new Pelicula("P000002", "2001 Space Odyssey", genero5,
                "Keir Dullea", "Gary Lockwood", "Stanley Kubrik",
                141, new Fecha( 1, 1, 1968));
        // Se agrega la pelicula 1 al catalogo de peliculas
        try{
            fachada.agrega(pelicula1);
            System.out.println("Se agrego la pelicula1");
        }catch(FachadaException fe){
            System.out.println("ERROR: "+fe.getMessage() + " 1");
        }

        //Se agrega la pelicula 2 al catalogo de peliculas
        try{
            fachada.agrega(pelicula2);
            System.out.println("Se agrego la pelicula2");
        }catch(FachadaException fe){
            System.out.println("ERROR: "+fe.getMessage() + " 2");
        }

        //Se lista el catalogo de peliculas
        System.out.println("Lista de peliculas: ");
        try{
            lista = fachada.consultaPeliculas();
            System.out.println(lista);
        }catch (FachadaException fe){
            System.out.println("ERROR: "+fe.getMessage());
        }
        //Se lista las peliculas de Ingrid Bergman
        System.out.println("Lista de peliculas de Ingrid Bergman: ");
        try{
            lista = fachada.consultaPeliculasActor("Ingrid Bergman");
            System.out.println(lista);
        }catch (FachadaException fe){
            System.out.println("ERROR: "+fe.getMessage());
        }
        //Lista de peliculas en el periodo: 1/03/1970 a 1/05/1970
        Periodo periodo = new Periodo(new Fecha(1, 1, 1960),
                new Fecha (1, 1, 1970));
        System.out.println("Lista de peliculas en el periodo: " + periodo);
        try{
            lista = fachada.consultaPeliculasPeriodo(periodo);
            System.out.println(lista);
        } catch (FachadaException fe){
            System.out.println("ERROR: "+fe.getMessage());
        }
    }
}
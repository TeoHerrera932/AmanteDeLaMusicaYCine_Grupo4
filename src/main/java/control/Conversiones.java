package control;
import java.lang.reflect.Array;
import java.util.ArrayList;
import objetosNegocio.*;

public class Conversiones {
    public ArrayList listaTablaCanciones(ArrayList listaCanciones){
        ArrayList tabla = new ArrayList();

        if(listaCanciones != null){
            for(int i = 0; i < listaCanciones.size(); i++){
                //Obte una cancion de la lista de canciones
                Cancion cancion = (Cancion) listaCanciones.get(i);
                //Almacena sus atributos en un array
                ArrayList renglon = toArrayList(cancion);//Era to vector pero quiero que sea el equivalente en arraylist
                //Almacena el vector con los atributos de la cancion en un array
                tabla.add(renglon);
            }
        }
        return tabla;
    }
    public ArrayList toArrayList(Cancion cancion){
        ArrayList arrayList = new ArrayList();
        //Agrega al vector los atributos de la clase
        arrayList.add(cancion.getClave());
        arrayList.add(cancion.getTitulo());
        arrayList.add(cancion.getInterprete());
        arrayList.add(cancion.getAutor());
        arrayList.add(cancion.getGenero().getNombre());
        arrayList.add(cancion.getAlbum());
        arrayList.add(new Integer(cancion.getDuracion()));
        arrayList.add(cancion.getFecha());
        return arrayList;
    }
    public ArrayList listaTablaPeliculas(ArrayList listaPeliculas){
        ArrayList tabla = new ArrayList();
        if(listaPeliculas != null){
            for(int i = 0; i < listaPeliculas.size(); i++){
                //Obten una pelicula de la lista de peliculas
                Pelicula pelicula = (Pelicula)listaPeliculas.get(i);
                //Almacena sus atributos en un array
                ArrayList renglon = toArrayList(pelicula);
                //Almacena el arraylist con los atributos de la pelicula en un arraylist
                tabla.add(renglon);
            }
        }
        return tabla;
    }
    public ArrayList toArrayList(Pelicula pelicula){
        ArrayList arrayList = new ArrayList();

        //Agrega al array los atributos de la clase
        arrayList.add(pelicula.getClave());
        arrayList.add(pelicula.getTitulo());
        arrayList.add(pelicula.getActor1());
        arrayList.add(pelicula.getActor2());
        arrayList.add(pelicula.getDirector());
        arrayList.add(pelicula.getGenero().getNombre());
        arrayList.add(new Integer(pelicula.getDuracion()));
        arrayList.add(pelicula.getFecha());
        return arrayList;
    }
    public ArrayList listaTablaGeneros(ArrayList listaGeneros){
        ArrayList tabla = new ArrayList();
        if(listaGeneros != null){
            for(int i = 0; i < listaGeneros.size(); i++){
                //Obten un genero de la lista de generos
                Genero genero = (Genero) listaGeneros.get(i);
                //Almacena sus atributos en un Arraylist
                ArrayList renglon = toArrayList(genero);
                //Almacena el vector con los atributos del genero en un array
                tabla.add(renglon);
            }
        }
        return tabla;
    }
    public ArrayList toArrayList(Genero genero){
        ArrayList arrayList = new ArrayList();
        //Agrega al array los atributos de la clase
        arrayList.add(genero.getCveGenero());
        arrayList.add(genero.getNombre());
        arrayList.add(genero.getTipoMedio());
        return arrayList;
    }
}

package pruebas;
import objetosServicio.Fecha;
import objetosNegocio.*;

public class Prueba1 {
    public static void main(String[] args) {
        //Genero de cancion
        Genero genero1 = new Genero("GC001","Balada",'C');
        Genero genero2 = new Genero("GC002","Bossanova",'C');
        Genero genero3 = new Genero("GC003","Rock",'C');
        //Genero de pelicula
        Genero genero4 = new Genero("GP001","Drama",'P');
        Genero genero5 = new Genero("GP002","Ciencia Ficción",'P');
        Genero genero6 = new Genero("GP003","Comedia",'P');
        //Se despliegan los datos del género 1
        System.out.println("Género 1:"+genero1);
        //genero 2
        System.out.println("Género 2:"+genero2);
        //genero3
        System.out.println("Género 3:"+genero3);
        System.out.println("Género 4:"+genero4);
        System.out.println("Género 5:"+genero5);
        System.out.println("Género 6:"+genero6);

        //Se crean 3 canciones
        Cancion cancion1 = new Cancion("C0001", "The long and winding road", genero1, "The Beatles",
                "Jhon Lennon", "Let it be", 3, new Fecha(24, 3, 1970));
        Cancion cancion2 = new Cancion("C0002", "Garota de Ipanema",genero2, "Los Indios Tabajaras",
                "Antonio Carlos Jobim", "Bossanova Jazz Vol. 1", 3, new Fecha(1, 12, 1970));
        Cancion cancion3 = new Cancion("C0003", "Desafinado", genero2, "Joao Gilberto", "Joao Gilberto",
                "Bossanova Jazz Vol. 1", 3, new Fecha(3, 12, 1980));
        //Se despliegan los datos por cancion
        //Cancion 1
        System.out.println("Cancion 1:"+cancion1);
        System.out.println("Cancion 2:"+cancion2);
        System.out.println("Cancion 3:"+cancion3);
        //Despliegue de titulo, fecha de cancion
        System.out.println("Título de la canción 1: "+cancion1.getTitulo());
        System.out.println("Fecha de la canción 2: "+cancion2.getFecha());
        //Se cambia el autor de la cancion 3
        cancion3.setAutor("Antonio Carlos Jobim");
        //Se despliega dato de la concion 3
        System.out.println("Cancion 3:"+cancion3);

        //Se crean dos películas
        Pelicula pelicula1 = new Pelicula("P0001", "Casa Blanca", genero3,"Humphrey Bogart","Ingrid Bergman",
                "Michael Curtiz", 102, new Fecha(1, 1, 1942));
        Pelicula pelicula2 = new Pelicula("P0002", "2001 Space Odyssey", genero4, "Keir Dullea", "Gary Lockwood",
                "Stanley Kubrick", 141, new Fecha(1, 1, 1968));

        //Se despliegan los datos de la película 1
        System.out.println("Pelicula 1:"+pelicula1);
        System.out.println("Pelicula 2:"+pelicula2);

        //Se despliega el genero de la pelicula 2
        System.out.println("Titulo de la película 1:"+pelicula1.getTitulo());
        System.out.println("Género de la película 2:"+pelicula2.getTitulo());
    }
}

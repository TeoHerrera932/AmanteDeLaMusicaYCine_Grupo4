package control;

import javax.swing.*;
import java.util.ArrayList;

import objetosServicio.*;
import objetosNegocio.*;
import interfaces.IFachada;
import fachadas.FachadaArchivos;
import InterfazUsuario.*;

public class Control {
    //Acceso a los objetos del negocio
    IFachada fachada;

    Conversiones conversiones;

    //Vectores con los nombres de las columnas de las tablas
    ArrayList nombresColumnasTablaCanciones = new ArrayList();
    ArrayList nombresColumnasTablaPeliculas = new ArrayList();
    ArrayList nombresColumnasTablaGeneros = new ArrayList();

    public Control(){
        //Crea un objeto tipo fachada
        fachada = new FachadaArchivos();

        conversiones = new Conversiones();
        //Llena el arraylist con los nombre de las columnas de las tablas de canciones
        nombresColumnasTablaCanciones.add("Clave");
        nombresColumnasTablaCanciones.add("Titulo");
        nombresColumnasTablaCanciones.add("Interprete");
        nombresColumnasTablaCanciones.add("Autor");
        nombresColumnasTablaCanciones.add("Genero");
        nombresColumnasTablaCanciones.add("Album");
        nombresColumnasTablaCanciones.add("Duración");
        nombresColumnasTablaCanciones.add("Fecha");

        //Llena el array con los nombres de las columnas de las tablas de peliculas
        nombresColumnasTablaPeliculas.add("Clave");
        nombresColumnasTablaPeliculas.add("Titulo");
        nombresColumnasTablaPeliculas.add("Actor1");
        nombresColumnasTablaPeliculas.add("Actor2");
        nombresColumnasTablaPeliculas.add("Director");
        nombresColumnasTablaPeliculas.add("Genero");
        nombresColumnasTablaPeliculas.add("Productora");
        nombresColumnasTablaPeliculas.add("Duración");
        nombresColumnasTablaPeliculas.add("Fecha");

        //Llena el array co los nombres de las columnas de las tablas de canciones
        nombresColumnasTablaGeneros.add("Clave");
        nombresColumnasTablaGeneros.add("Nombre");
        nombresColumnasTablaGeneros.add("Tipo");
    }

    public void agregaCancion(JFrame frame){
        Cancion cancion, bCancion = null;
        StringBuffer respuesta = new  StringBuffer("");
        DlgCancion dlgCancion;
        ArrayList listaGeneros = null;

        //Captura la clave de la cancion
        String clave = JOptionPane.showInputDialog(frame,"Clave de la canción:",
                "Agregar canción", JOptionPane.QUESTION_MESSAGE);
        //Si el usuario presionó el botón Cancelar
        if (clave == null) return;

        //Crea un objeto Cancion con solo la clave
        cancion = new Cancion(clave);
        try{
            //Obten la canción del catálogo de canciones
            bCancion = fachada.obten(cancion);
        }catch(Exception e){
            //Mensaje de error
            JOptionPane.showMessageDialog(frame,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        //Si la cancion existe, despliega sus datos
        if (bCancion != null){
            dlgCancion = new DlgCancion(frame,"La canción ya está en el catálogo",
                    true, bCancion, listaGeneros, UtileriasGUI.DESPLEGAR, respuesta);
            return;
        }
        //Si la canción no existe captura los datos de la nueva cancion
        dlgCancion = new DlgCancion (frame, "Captura Datos Canción", true, cancion,
                listaGeneros, UtileriasGUI.AGREGAR, respuesta);
        //Si el usuario presiono el boton Cancelar
        if (respuesta.substring(0).equals(UtileriasGUI.CANCELAR)) return;
        //Agrega la nueva canción al catálogo de canciones
        try{
            fachada.agrega(cancion);
        }catch (Exception e){
            JOptionPane.showMessageDialog(frame,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    public void actualizaCancion(JFrame frame){
    Cancion cancion;
    StringBuffer respuesta = new  StringBuffer("");
    DlgCancion dlgCancion;
    ArrayList listaGeneros = null;

    //Captura la clave de la canción
        String clave = JOptionPane.showInputDialog(frame, "Clave de la cancion: ",
                "Actualizar canción",  JOptionPane.QUESTION_MESSAGE);
        if (clave == null) return;
        cancion = new Cancion(clave);
        try{
            cancion=fachada.obten(cancion);
        }catch(Exception e){
            JOptionPane.showMessageDialog(frame,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (cancion == null){
            JOptionPane.showMessageDialog(frame,"La canción no existe","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        try{
            listaGeneros = fachada.consultaGenerosCanciones();
        }catch(Exception e){
            JOptionPane.showMessageDialog(frame,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        dlgCancion = new DlgCancion(frame,"Edita Datos Cancion", true, cancion,
                listaGeneros, UtileriasGUI.ACTUALIZAR,respuesta);
        if (respuesta.substring(0).equals(UtileriasGUI.CANCELAR))return;
        try{
            fachada.actualiza(cancion);
        }catch(Exception e){
            JOptionPane.showMessageDialog(frame,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    public void eliminaCancion(JFrame frame){
        Cancion cancion;
        StringBuffer respuesta = new  StringBuffer();
        DlgCancion dlgCancion;
        ArrayList listaGeneros = null;

        //Captura la clave de la cancion
        String clave = JOptionPane.showInputDialog(frame, "Clave de la canción",
                "Eliminar canción", JOptionPane.QUESTION_MESSAGE);
        //Si el usuario presionó el boton Cancelar
        if (clave == null) return;
        //Cra un objeto Cancion con solo la clave
        cancion = new Cancion(clave);
        try{
            //Obten la canción del catálogo de canciones
            cancion = fachada.obten(cancion);
        }catch(Exception e){
            JOptionPane.showMessageDialog(frame,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        //Si la canción no existe en el catálogo de canciones
        if (cancion == null){
            JOptionPane.showMessageDialog(frame,"La cancion no existe","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        try{
            //Obtiene el array con la lista de géneros de canciones
            listaGeneros = fachada.consultaGenerosCanciones();
        }catch(Exception e){
            JOptionPane.showMessageDialog(frame,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        //Si existe la cancion, despliega los datos de la cancion
        dlgCancion = new DlgCancion(frame, "Cacnión a borrar", true, cancion,
                listaGeneros, UtileriasGUI.ELIMINAR, respuesta);
        //Si el usuario presionó el botón Cancelar
        if  (respuesta.substring(0).equals(UtileriasGUI.CANCELAR)) return;
        try{
            //Elimina la canción del catálogo de canciones
            fachada.elimina(cancion);
        }catch(Exception e){
            //Si ocurrió un error al borrar del catálogo de canciones, despliega mensaje de error
            JOptionPane.showMessageDialog(frame,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    public Tabla getTablaCanciones(JFrame frame){
        ArrayList listaCanciones = null;
        try{
            listaCanciones = fachada.consultaCanciones();
        }catch (Exception e){
            JOptionPane.showMessageDialog(frame,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        //Regresa la tabla de canciones
        return new Tabla("Canciones", nombresColumnasTablaCanciones,
                conversiones.listaTablaCanciones(listaCanciones));
    }
}

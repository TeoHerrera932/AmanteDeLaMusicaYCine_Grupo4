/*
 * Generos.java
 *
 * Creada el 15 de septiembre de 2007, 12:21 PM
 */
package persistencia;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

import excepciones.PersistenciaException;
import objetosNegocio.Genero;
/**
 * Esta clase permite agregar, actualizar, eliminar y consultar géneros de
 * generos o películas del programa AmanteMusica en su versión que usa
 * archivos.
 *
 * @author mdomitsu
 */
public class Generos extends AccesoAleatorio {

    // Tamaño de un registro (datos de una género)
    // cveGenero 7 caracteres 14 bytes
    // nombre 20 caracteres 40 bytes
    // tipoMedio Char 2 bytes
    // Total 56 bytes
    public Generos(String nomArchivo) {
        super(nomArchivo, 56);
    }
    /**
     * Lee un género de un archivo
     * @return El género leído
     * @throws IOException Si hay un error de entrada / salida.
     */
    private Genero leeGenero() throws IOException {
        Genero genero = new Genero();
        // Lee del archivo cada uno de los atributos del género
        genero.setCveGenero(leeString(7));
        genero.setNombre(leeString(20));
        genero.setTipoMedio(archivo.readChar());
        return genero;
    }
    /**
     * Escribe un género a un archivo
     * @param genero Género a escribir
     * @throws IOException Si hay un error de entrada / salida.
     */
    private void escribeGenero(Genero genero) throws IOException {
        escribeString(genero.getCveGenero(), 7);
        escribeString(genero.getNombre(), 20);
        archivo.writeChar(genero.getTipoMedio());
    }
    /**
     * Regresa el genero del archivo que coincida con el genero del parametro.
     * Las claves de los generos del archivo y del parametro deben coincidir
     * @param genero Objeto de tipo Genero con la clave del género a buscar
     * @return El Genero si lo encuentra. null en caso contrario.
     * @throws PersistenciaException Si hay un error de entrada / salida
     * o el archivo no existe.
     */
    public Genero obten(Genero genero) throws PersistenciaException {
        Genero generoLeido;
        // Abre el archivo de sólo lectura
        try {
            archivo = new RandomAccessFile(nomArchivo, "r");
        }
        catch(FileNotFoundException fnfe) {
            throw new PersistenciaException("Archivo inexistente");
        }
        try {
            // Mientras haya generos en el archivo
            while(true) {
                // Lee un género
                generoLeido = leeGenero();
                // Si es el género buscado, regrésalo
                if(genero.equals(generoLeido)) {
                    return generoLeido;
                }
            }
        }
        // Si se llegó al final del archivo sin encontrar el género
        catch (EOFException eofe) {
            return null;
        }
        // Si ocurrió un error de entrada salida
        catch (IOException eofe) {
            throw new PersistenciaException("Error al acceder al archivo");
        }
        finally {
            try {
                // Cierra el archivo
                archivo.close();
            }
            // Si ocurrió un error de entrada salida
            catch (IOException eofe) {
                throw new PersistenciaException("Error al cerrar el archivo");
            }
        }
    }
    /**
     * Este método permite agregar un género a un archivo.
     * @param genero Género a agregar en el archivo géneros
     * @throws PersistenciaException Si hay un error de entrada / salida,
     * el archivo no existe.
     */
    public void agrega(Genero genero) throws PersistenciaException {
        // Abre el archivo de escritura/lectura
        try {
            archivo = new RandomAccessFile(nomArchivo, "rw");
        }
        catch(FileNotFoundException fnfe) {
            throw new PersistenciaException("Archivo inexistente");
        }
        try {
            // Se posiciona al final del archivo
            archivo.seek(archivo.length());
            // Escribe el género
            escribeGenero(genero);
        }
        // Si ocurrió un error de entrada salida
        catch (IOException eofe) {
            throw new PersistenciaException("Error al acceder al archivo");
        }
        finally {
            try {
                // Cierra el archivo
                archivo.close();
            }
            // Si ocurrió un error de entrada salida
            catch (IOException eofe) {
                throw new PersistenciaException("Error al cerrar el archivo");
            }
        }
    }
    /**
     * Actualiza el genero del archivo que coincida con el genero del parametro.
     * Las claves de los generos del archivo y del parametro deben coincidir
     * @param genero El género a modificar
     * @throws PersistenciaException Si hay un error de entrada / salida,
     * el archivo no existe o no se puede actualizar el género.
     */
    public void actualiza(Genero genero) throws PersistenciaException {
        Genero generoLeido;
        // Abre el archivo de escritura/lectura
        try {
            archivo = new RandomAccessFile(nomArchivo, "rw");
        }
        catch(FileNotFoundException fnfe) {
            throw new PersistenciaException("Archivo inexistente");
        }
        try {
            // Mientras haya géneros en el archivo
            while(true) {
                // Lee una género
                generoLeido = leeGenero();
                // Si es el género buscado
                if(genero.getCveGenero().equals(generoLeido.getCveGenero())) {
                    // Se posiciona al principio del registro
                    archivo.seek(archivo.getFilePointer() - tamRegistro);
                    // Escribe el género modificado
                    escribeGenero(genero);
                    // Termina la búsqueda
                    break;
                }
            }
        }
        // Si se llegó al final del archivo
        catch (EOFException eofe) {
            throw new PersistenciaException("El género no existe");
        }
        // Si ocurrió un error de entrada salida
        catch (IOException eofe) {
            throw new PersistenciaException("Error al acceder al archivo");
        }
        finally {
            try {
                // Cierra el archivo
                archivo.close();
            }
            // Si ocurrió un error de entrada salida
            catch (IOException eofe) {
                throw new PersistenciaException("Error al cerrar el archivo");
            }
        }
    }
    /**
     * Elimina el genero del archivo que coincida con el genero del parametro.
     * Las claves de los generos archivo y del parametro deben coincidir
     * @param genero Genero a borrar
     * @throws PersistenciaException Si hay un error de entrada / salida,
     * el archivo no existe o no se puede eliminar el género.
     */
    public void elimina(Genero genero) throws PersistenciaException {
        Genero generoLeido;
        // Abre el archivo de escritura/lectura
        try {
            archivo = new RandomAccessFile(nomArchivo, "rw");
        }
        catch(FileNotFoundException fnfe) {
            throw new PersistenciaException("Archivo inexistente");
        }
        try {
            // Mientras haya generos en el archivo
            while(true) {
                // Lee un género
                generoLeido = leeGenero();
                // Si es el género buscado
                if(genero.getCveGenero().equals(generoLeido.getCveGenero())) {
                    // Se posiciona al principio del registro
                    archivo.seek(archivo.getFilePointer() - tamRegistro);
                    // Escribe un registro en blanco y empaca
                    borraRegistro();
                    empaca();
                    // Termina la búsqueda
                    break;
                }
            }
        }
        // Si se llegó al final del archivo
        catch (EOFException eofe) {
            throw new PersistenciaException("El género no existe");
        }
        // Si ocurrió un error de entrada salida
        catch (IOException eofe) {
            throw new PersistenciaException("Error al acceder al archivo");
        }
        finally {
            try {
                // Cierra el archivo
                archivo.close();
            }
            // Si ocurrió un error de entrada salida
            catch (IOException eofe) {
                throw new PersistenciaException("Error al cerrar el archivo");
            }
        }
    }
    /**
     * Este método permite consultar los géneros del archivo generos.
     * @return Un ArrayList con la lista de los objetos del tipo Genero del
     * archivo generos
     * @throws PersistenciaException Si hay un error de entrada / salida o
     * el archivo no existe.
     */
    public ArrayList lista() throws PersistenciaException {
        ArrayList lista = new ArrayList();
        Genero genero;
        // Abre el archivo de sólo lectura
        try {
            archivo = new RandomAccessFile(nomArchivo, "r");
        }
        catch(FileNotFoundException fnfe) {
            throw new PersistenciaException("Archivo inexistente");
        }
        try {
            // Mientras haya generos en el archivo
            while (true) {
                // Lee un género
                genero = leeGenero();
                // Agrega el género al ArrayList de géneros
                lista.add(genero);
            }
        }
        // Si se llegó al final del archivo
        catch (EOFException eofe) {
            // Regresa la lista de generos
            return lista;
        }
        // Si ocurrió un error de entrada salida
        catch (IOException eofe) {
            throw new PersistenciaException("Error al acceder al archivo");
        }
        finally {
            try {
                // Cierra el archivo
                archivo.close();
            }
            // Si ocurrió un error de entrada salida
            catch (IOException eofe) {
                throw new PersistenciaException("Error al cerrar el archivo");
            }
        }
    }
    /**
     * Este método permite consultar los géneros del archivo generos
     * que tienen el mismo tipo de medio.
     * @param tipoMedio Tipo de medio a buscar
     * @return Un ArrayList con la lista de géneros del archivo generos que
     * tienen el mismo tipo de medio.
     * @throws PersistenciaException Si hay un error de entrada / salida o
     * el archivo no existe.
     */
    public ArrayList listaMedio(char tipoMedio) throws PersistenciaException {
        ArrayList lista = new ArrayList();
        Genero genero;
        // Abre el archivo de sólo lectura
        try {
            archivo = new RandomAccessFile(nomArchivo, "r");
        }
        catch(FileNotFoundException fnfe) {
            throw new PersistenciaException("Archivo inexistente");
        }
        try {
            // Mientras haya generos en el archivo
            while(true) {
                // Lee un género
                genero = leeGenero();
                // Si es el género buscado
                if(tipoMedio == genero.getTipoMedio()) {
                    // Agrega el género al ArrayList de generos
                    lista.add(genero);
                }
            }
        }
        // Si se llegó al final del archivo
        catch (EOFException eofe) {
            // Regresa la lista de generos
            return lista;
        }
        // Si ocurrió un error de entrada salida
        catch (IOException eofe) {
            throw new PersistenciaException("Error al acceder al archivo");
        }
        finally {
            try {
                // Cierra el archivo
                archivo.close();
            }
            // Si ocurrió un error de entrada salida
            catch (IOException eofe) {
                throw new PersistenciaException("Error al cerrar el archivo");
            }
        }
    }
}

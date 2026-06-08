package persistencia;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import objetosServicio.Periodo;
import objetosServicio.Fecha;
import objetosNegocio.Cancion;
import objetosNegocio.Genero;
import excepciones.PersistenciaException;

public class Canciones extends AccesoAleatorio {

    public Canciones(String nomArchivo) {
        super(nomArchivo, 324);
    }

    private Cancion leeCancion() throws IOException {
        Cancion cancion = new Cancion();
        cancion.setClave(leeString(7));
        cancion.setTitulo(leeString(35));
        Genero genero = new Genero(leeString(7));
        cancion.setGenero(genero);
        cancion.setInterprete(leeString(35));
        cancion.setAutor(leeString(35));
        cancion.setAlbum(leeString(35));
        cancion.setDuracion(archivo.readInt());
        cancion.setFecha(leeFecha());
        return cancion;
    }

    private void escribeCancion(Cancion cancion) throws IOException {
        escribeString(cancion.getClave(), 7);
        escribeString(cancion.getTitulo(), 35);
        escribeString(cancion.getGenero().getCveGenero(), 7);
        escribeString(cancion.getInterprete(), 35);
        escribeString(cancion.getAutor(), 35);
        escribeString(cancion.getAlbum(), 35);
        archivo.writeInt(cancion.getDuracion());
        escribeFecha(cancion.getFecha());
    }

    public Cancion obten(Cancion cancion) throws PersistenciaException {
        Cancion cancionLeida;
        try {
            archivo = new RandomAccessFile(nomArchivo, "r");
        } catch (FileNotFoundException fnfe) {
            throw new PersistenciaException("Archivo inexistente");
        }
        try {
            while (true) {
                cancionLeida = leeCancion();
                if (cancion.equals(cancionLeida)) {
                    return cancionLeida;
                }
            }
        } catch (EOFException eofe) {
            return null;
        } catch (IOException ioe) {
            throw new PersistenciaException("Error al acceder al archivo");
        } finally {
            try {
                archivo.close();
            } catch (IOException ioe) {
                throw new PersistenciaException("Error al cerrar el archivo");
            }
        }
    }

    public void agrega(Cancion cancion) throws PersistenciaException {
        try {
            archivo = new RandomAccessFile(nomArchivo, "rw");
            archivo.seek(archivo.length());
            escribeCancion(cancion);
        } catch (FileNotFoundException fnfe) {
            throw new PersistenciaException("Archivo inexistente");
        } catch (IOException ioe) {
            throw new PersistenciaException("Error al acceder al archivo");
        } finally {
            try {
                if (archivo != null) {
                    archivo.close();
                }
            } catch (IOException ioe) {
                throw new PersistenciaException("Error al cerrar el archivo");
            }
        }
    }

    public void actualiza(Cancion cancion) throws PersistenciaException {
        Cancion cancionLeida;
        try {
            archivo = new RandomAccessFile(nomArchivo, "rw");
        } catch (FileNotFoundException fnfe) {
            throw new PersistenciaException("Archivo inexistente");
        }
        try {
            while (true) {
                cancionLeida = leeCancion();
                if (cancion.equals(cancionLeida)) {
                    archivo.seek(archivo.getFilePointer() - tamRegistro);
                    escribeCancion(cancion);
                    break;
                }
            }
        } catch (EOFException eofe) {
            throw new PersistenciaException("La canción no existe");
        } catch (IOException ioe) {
            throw new PersistenciaException("Error al acceder al archivo");
        } finally {
            try {
                archivo.close();
            } catch (IOException ioe) {
                throw new PersistenciaException("Error al cerrar el archivo");
            }
        }
    }

    public void elimina(Cancion cancion) throws PersistenciaException {
        Cancion cancionLeida;
        try {
            archivo = new RandomAccessFile(nomArchivo, "rw");
        } catch (FileNotFoundException fnfe) {
            throw new PersistenciaException("Archivo inexistente");
        }
        try {
            while (true) {
                cancionLeida = leeCancion();
                if (cancion.equals(cancionLeida)) {
                    archivo.seek(archivo.getFilePointer() - tamRegistro);
                    borraRegistro();
                    empaca();
                    break;
                }
            }
        } catch (EOFException eofe) {
            throw new PersistenciaException("La canción no existe");
        } catch (IOException ioe) {
            throw new PersistenciaException("Error al acceder al archivo");
        } finally {
            try {
                archivo.close();
            } catch (IOException ioe) {
                throw new PersistenciaException("Error al cerrar el archivo");
            }
        }
    }

    public ArrayList lista() throws PersistenciaException {
        ArrayList lista = new ArrayList();
        Cancion cancion;
        try {
            archivo = new RandomAccessFile(nomArchivo, "r");
        } catch (FileNotFoundException fnfe) {
            throw new PersistenciaException("Archivo inexistente");
        }
        try {
            while (true) {
                cancion = leeCancion();
                lista.add(cancion);
            }
        } catch (EOFException eofe) {
            return lista;
        } catch (IOException ioe) {
            throw new PersistenciaException("Error al acceder al archivo");
        } finally {
            try {
                archivo.close();
            } catch (IOException ioe) {
                throw new PersistenciaException("Error al cerrar el archivo");
            }
        }
    }

    public ArrayList listaTitulo(String titulo) throws PersistenciaException {
        ArrayList lista = new ArrayList();
        Cancion cancion;
        try {
            archivo = new RandomAccessFile(nomArchivo, "r");
        } catch (FileNotFoundException fnfe) {
            throw new PersistenciaException("Archivo inexistente");
        }
        try {
            while (true) {
                cancion = leeCancion();
                if (titulo.equals(cancion.getTitulo())) {
                    lista.add(cancion);
                }
            }
        } catch (EOFException eofe) {
            return lista;
        } catch (IOException ioe) {
            throw new PersistenciaException("Error al acceder al archivo");
        } finally {
            try {
                archivo.close();
            } catch (IOException ioe) {
                throw new PersistenciaException("Error al cerrar el archivo");
            }
        }
    }

    public ArrayList listaInterprete(String interprete) throws PersistenciaException {
        ArrayList lista = new ArrayList();
        Cancion cancion;
        try {
            archivo = new RandomAccessFile(nomArchivo, "r");
        } catch (FileNotFoundException fnfe) {
            throw new PersistenciaException("Archivo inexistente");
        }
        try {
            while (true) {
                cancion = leeCancion();
                if (interprete.equals(cancion.getInterprete())) {
                    lista.add(cancion);
                }
            }
        } catch (EOFException eofe) {
            return lista;
        } catch (IOException ioe) {
            throw new PersistenciaException("Error al acceder al archivo");
        } finally {
            try {
                archivo.close();
            } catch (IOException ioe) {
                throw new PersistenciaException("Error al cerrar el archivo");
            }
        }
    }

    public ArrayList listaAutor(String autor) throws PersistenciaException {
        ArrayList lista = new ArrayList();
        Cancion cancion;
        try {
            archivo = new RandomAccessFile(nomArchivo, "r");
        } catch (FileNotFoundException fnfe) {
            throw new PersistenciaException("Archivo inexistente");
        }
        try {
            while (true) {
                cancion = leeCancion();
                if (autor.equals(cancion.getAutor())) {
                    lista.add(cancion);
                }
            }
        } catch (EOFException eofe) {
            return lista;
        } catch (IOException ioe) {
            throw new PersistenciaException("Error al acceder al archivo");
        } finally {
            try {
                archivo.close();
            } catch (IOException ioe) {
                throw new PersistenciaException("Error al cerrar el archivo");
            }
        }
    }

    public ArrayList listaAlbum(String album) throws PersistenciaException {
        ArrayList lista = new ArrayList();
        Cancion cancion;
        try {
            archivo = new RandomAccessFile(nomArchivo, "r");
        } catch (FileNotFoundException fnfe) {
            throw new PersistenciaException("Archivo inexistente");
        }
        try {
            while (true) {
                cancion = leeCancion();
                if (album.equals(cancion.getAlbum())) {
                    lista.add(cancion);
                }
            }
        } catch (EOFException eofe) {
            return lista;
        } catch (IOException ioe) {
            throw new PersistenciaException("Error al acceder al archivo");
        } finally {
            try {
                archivo.close();
            } catch (IOException ioe) {
                throw new PersistenciaException("Error al cerrar el archivo");
            }
        }
    }

    public ArrayList listaGenero(String cveGenero) throws PersistenciaException {
        ArrayList lista = new ArrayList();
        Cancion cancion;
        try {
            archivo = new RandomAccessFile(nomArchivo, "r");
        } catch (FileNotFoundException fnfe) {
            throw new PersistenciaException("Archivo inexistente");
        }
        try {
            while (true) {
                cancion = leeCancion();
                if (cveGenero.equals(cancion.getGenero().getCveGenero())) {
                    lista.add(cancion);
                }
            }
        } catch (EOFException eofe) {
            return lista;
        } catch (IOException ioe) {
            throw new PersistenciaException("Error al acceder al archivo");
        } finally {
            try {
                archivo.close();
            } catch (IOException ioe) {
                throw new PersistenciaException("Error al cerrar el archivo");
            }
        }
    }

    public ArrayList listaPeriodo(Periodo periodo) throws PersistenciaException {
        ArrayList lista = new ArrayList();
        Cancion cancion;
        try {
            archivo = new RandomAccessFile(nomArchivo, "r");
        } catch (FileNotFoundException fnfe) {
            throw new PersistenciaException("Archivo inexistente");
        }
        try {
            while (true) {
                cancion = leeCancion();
                if (periodo.contiene(cancion.getFecha())) {
                    lista.add(cancion);
                }
            }
        } catch (EOFException eofe) {
            return lista;
        } catch (IOException ioe) {
            throw new PersistenciaException("Error al acceder al archivo");
        } finally {
            try {
                archivo.close();
            } catch (IOException ioe) {
                throw new PersistenciaException("Error al cerrar el archivo");
            }
        }
    }
}

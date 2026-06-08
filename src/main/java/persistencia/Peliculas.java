package persistencia;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import objetosServicio.Periodo;
import objetosServicio.Fecha;
import objetosNegocio.Genero;
import objetosNegocio.Pelicula;
import excepciones.PersistenciaException;

public class Peliculas extends AccesoAleatorio {

    public Peliculas(String nomArchivo) {
        super(nomArchivo, 324);
    }

    private Pelicula leePelicula() throws IOException {
        Pelicula pelicula = new Pelicula();
        pelicula.setClave(leeString(7));
        pelicula.setTitulo(leeString(35));
        pelicula.setGenero(new Genero(leeString(7)));
        pelicula.setActor1(leeString(35));
        pelicula.setActor2(leeString(35));
        pelicula.setDirector(leeString(35));
        pelicula.setDuracion(archivo.readInt());
        pelicula.setFecha(leeFecha());
        return pelicula;
    }

    private void escribePelicula(Pelicula pelicula) throws IOException {
        escribeString(pelicula.getClave(), 7);
        escribeString(pelicula.getTitulo(), 35);
        escribeString(pelicula.getGenero().getCveGenero(), 7);
        escribeString(pelicula.getActor1(), 35);
        escribeString(pelicula.getActor2(), 35);
        escribeString(pelicula.getDirector(), 35);
        archivo.writeInt(pelicula.getDuracion());
        escribeFecha(pelicula.getFecha());
    }

    public Pelicula obten(Pelicula pelicula) throws PersistenciaException {
        Pelicula peliculaLeida;
        try {
            archivo = new RandomAccessFile(nomArchivo, "r");
        } catch (FileNotFoundException fnfe) {
            throw new PersistenciaException("Archivo inexistente");
        }
        try {
            while (true) {
                peliculaLeida = leePelicula();
                if (pelicula.equals(peliculaLeida)) {
                    return peliculaLeida;
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

    public void agrega(Pelicula pelicula) throws PersistenciaException {
        try {
            archivo = new RandomAccessFile(nomArchivo, "rw");
            archivo.seek(archivo.length());
            escribePelicula(pelicula);
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

    public void actualiza(Pelicula pelicula) throws PersistenciaException {
        Pelicula peliculaLeida;
        try {
            archivo = new RandomAccessFile(nomArchivo, "rw");
        } catch (FileNotFoundException fnfe) {
            throw new PersistenciaException("Archivo inexistente");
        }
        try {
            while (true) {
                peliculaLeida = leePelicula();
                if (pelicula.equals(peliculaLeida)) {
                    archivo.seek(archivo.getFilePointer() - tamRegistro);
                    escribePelicula(pelicula);
                    break;
                }
            }
        } catch (EOFException eofe) {
            throw new PersistenciaException("La película no existe");
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

    public void elimina(Pelicula pelicula) throws PersistenciaException {
        Pelicula peliculaLeida;
        try {
            archivo = new RandomAccessFile(nomArchivo, "rw");
        } catch (FileNotFoundException fnfe) {
            throw new PersistenciaException("Archivo inexistente");
        }
        try {
            while (true) {
                peliculaLeida = leePelicula();
                if (pelicula.equals(peliculaLeida)) {
                    archivo.seek(archivo.getFilePointer() - tamRegistro);
                    borraRegistro();
                    empaca();
                    break;
                }
            }
        } catch (EOFException eofe) {
            throw new PersistenciaException("La película no existe");
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
        Pelicula pelicula;
        try {
            archivo = new RandomAccessFile(nomArchivo, "r");
        } catch (FileNotFoundException fnfe) {
            throw new PersistenciaException("Archivo inexistente");
        }
        try {
            while (true) {
                pelicula = leePelicula();
                lista.add(pelicula);
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
        Pelicula pelicula;
        try {
            archivo = new RandomAccessFile(nomArchivo, "r");
        } catch (FileNotFoundException fnfe) {
            throw new PersistenciaException("Archivo inexistente");
        }
        try {
            while (true) {
                pelicula = leePelicula();
                if (titulo.equals(pelicula.getTitulo())) {
                    lista.add(pelicula);
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

    public ArrayList listaActor(String actor) throws PersistenciaException {
        ArrayList lista = new ArrayList();
        Pelicula pelicula;
        try {
            archivo = new RandomAccessFile(nomArchivo, "r");
        } catch (FileNotFoundException fnfe) {
            throw new PersistenciaException("Archivo inexistente");
        }
        try {
            while (true) {
                pelicula = leePelicula();
                if (actor.equals(pelicula.getActor1()) || actor.equals(pelicula.getActor2())) {
                    lista.add(pelicula);
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

    public ArrayList listaDirector(String director) throws PersistenciaException {
        ArrayList lista = new ArrayList();
        Pelicula pelicula;
        try {
            archivo = new RandomAccessFile(nomArchivo, "r");
        } catch (FileNotFoundException fnfe) {
            throw new PersistenciaException("Archivo inexistente");
        }
        try {
            while (true) {
                pelicula = leePelicula();
                if (director.equals(pelicula.getDirector())) {
                    lista.add(pelicula);
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
        Pelicula pelicula;
        try {
            archivo = new RandomAccessFile(nomArchivo, "r");
        } catch (FileNotFoundException fnfe) {
            throw new PersistenciaException("Archivo inexistente");
        }
        try {
            while (true) {
                pelicula = leePelicula();
                if (cveGenero.equals(pelicula.getGenero().getCveGenero())) {
                    lista.add(pelicula);
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
        Pelicula pelicula;
        try {
            archivo = new RandomAccessFile(nomArchivo, "r");
        } catch (FileNotFoundException fnfe) {
            throw new PersistenciaException("Archivo inexistente");
        }
        try {
            while (true) {
                pelicula = leePelicula();
                if (periodo.contiene(pelicula.getFecha())) {
                    lista.add(pelicula);
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

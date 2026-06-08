package persistencia;

import java.io.IOException;
import java.io.RandomAccessFile;
import objetosServicio.Fecha;

public class AccesoAleatorio {
    protected RandomAccessFile archivo;
    protected String nomArchivo;
    protected int tamRegistro;
    protected byte blancos[];

    public AccesoAleatorio(String nomArchivo, int tamRegistro) {
        this.nomArchivo = nomArchivo;
        this.tamRegistro = tamRegistro;
        blancos = new byte[tamRegistro];
        for (int i = 0; i < tamRegistro; i++) {
            blancos[i] = 0;
        }
    }

    public String leeString(int tam) throws IOException {
        char cadena[] = new char[tam];
        for (int i = 0; i < tam; i++) {
            cadena[i] = archivo.readChar();
        }
        String sCadena = new String(cadena);
        return sCadena.replace('\u0000', ' ').trim();
    }

    public void escribeString(String sCadena, int tam) throws IOException {
        StringBuffer cadena;
        if (sCadena != null) {
            cadena = new StringBuffer(sCadena);
        } else {
            cadena = new StringBuffer(tam);
        }
        cadena.setLength(tam);
        archivo.writeChars(cadena.toString());
    }

    public Fecha leeFecha() throws IOException {
        int dia = archivo.readInt();
        int mes = archivo.readInt();
        int anho = archivo.readInt();
        return new Fecha(dia, mes, anho);
    }

    public void escribeFecha(Fecha fecha) throws IOException {
        if (fecha != null) {
            archivo.writeInt(fecha.getDia());
            archivo.writeInt(fecha.getMes());
            archivo.writeInt(fecha.getAnio());
        } else {
            archivo.writeInt(0);
            archivo.writeInt(0);
            archivo.writeInt(0);
        }
    }

    public void borraRegistro() throws IOException {
        archivo.write(blancos);
    }

    public boolean estaRegistroBorrado(byte registro[]) {
        for (int i = 0; i < tamRegistro; i++) {
            if (registro[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public void empaca() throws IOException {
        byte registro[] = new byte[tamRegistro];
        int registrosBorrados = 0;
        int numRegistros = (int) archivo.length() / tamRegistro;
        for (int i = 0; i < numRegistros; i++) {
            archivo.seek(i * tamRegistro);
            archivo.read(registro);
            if (estaRegistroBorrado(registro)) {
                for (int j = i; j < numRegistros - 1; j++) {
                    archivo.seek((j + 1) * tamRegistro);
                    archivo.read(registro);
                    archivo.seek(j * tamRegistro);
                    archivo.write(registro);
                }
                numRegistros--;
                registrosBorrados++;
                i--;
            }
        }
        archivo.setLength(archivo.length() - registrosBorrados * tamRegistro);
    }
}

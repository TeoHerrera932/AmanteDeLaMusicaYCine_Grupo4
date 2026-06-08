package AmanteMusica;

import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import objetosNegocio.Cancion;

public class TablaCanciones extends JFrame {
    private final JTable jTable1;

    public TablaCanciones() {
        super("Tabla de Canciones");
        this.jTable1 = new JTable();
        this.add(new JScrollPane(jTable1));
        setSize(800, 400);
        setLocationRelativeTo(null);
    }

    public TablaCanciones(List<Cancion> listaCancion) {
        super("Tabla de Canciones");
        String[] columns = {"Clave", "Titulo", "Interprete", "Autor Letra", "Autor Musica", "Genero", "Album", "Disquera", "Duracion", "Fecha"};
        Object[][] data = obtenerArregloTabla(listaCancion);
        DefaultTableModel model = new DefaultTableModel(data, columns);
        this.jTable1 = new JTable(model);
        this.add(new JScrollPane(jTable1));
        setSize(800, 400);
        setLocationRelativeTo(null);
    }

    private Object[][] obtenerArregloTabla(List<Cancion> listaCancion) {
        Object[][] listaObjetos = new Object[listaCancion.size()][10];
        int i = 0;
        for (Cancion cancion : listaCancion) {
            listaObjetos[i][0] = cancion.getClave();
            listaObjetos[i][1] = cancion.getTitulo();
            listaObjetos[i][2] = cancion.getInterprete();
            listaObjetos[i][3] = cancion.getAutorLetra();
            listaObjetos[i][4] = cancion.getAutorMusica();
            listaObjetos[i][5] = cancion.getGenero();
            listaObjetos[i][6] = cancion.getAlbum();
            listaObjetos[i][7] = cancion.getDisquera();
            listaObjetos[i][8] = cancion.getDuracion();
            listaObjetos[i][9] = cancion.getFecha();
            i++;
        }
        return listaObjetos;
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new TablaCanciones().setVisible(true));
    }
}

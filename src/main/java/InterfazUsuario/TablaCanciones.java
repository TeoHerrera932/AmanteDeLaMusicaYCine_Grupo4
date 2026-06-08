/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package InterfazUsuario;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import objetosNegocio.Cancion;

/**
 *
 * @author User
 */
public class TablaCanciones extends javax.swing.JFrame {

    /**
     * Creates new form TablaCanciones
     */
    public TablaCanciones() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public TablaCanciones(List<Cancion> listaCancion) {
        initComponents();
        cargarDatosEnTabla(listaCancion);
        setLocationRelativeTo(null);
    }

    private void cargarDatosEnTabla(List<Cancion> listaCancion) {
        String[] columns = {"Clave", "Titulo", "Interprete", "Autor Letra", "Autor Musica",
                "Genero", "Album", "Disquera", "Duracion", "Fecha"};

        Object[][] data = obtenerArregloTabla(listaCancion);
        DefaultTableModel model = new DefaultTableModel(data, columns);
        jTable1.setModel(model);
    }

    private Object[][] obtenerArregloTabla(List<Cancion> lista) {
        if (lista == null || lista.isEmpty()) {
            return new Object[0][10];
        }

        Object[][] data = new Object[lista.size()][10];

        for (int i = 0; i < lista.size(); i++) {
            Cancion c = lista.get(i);
            data[i][0] = c.getClave();
            data[i][1] = c.getTitulo();
            data[i][2] = c.getInterprete();
            data[i][3] = c.getAutor();
            data[i][4] = (c.getGenero() != null) ? c.getGenero().getNombre() : "";
            data[i][5] = c.getAlbum();
            data[i][6] = c.getDuracion();
            data[i][7] = (c.getFecha() != null) ? c.getFecha().toString() : "";
        }
        return data;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tabla de Canciones");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {},
                new String [] {
                        "Clave", "Titulo", "Interprete", "Autor Letra", "Autor Musica",
                        "Genero", "Album", "Disquera", "Duracion", "Fecha"
                }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 950, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>

    // Variables declaration - do not modify
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration
}
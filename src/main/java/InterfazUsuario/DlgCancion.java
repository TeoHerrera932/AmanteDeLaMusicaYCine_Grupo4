/*
 * Diálogo para Agregar, Actualizar, Eliminar y Desplegar Canciones
 */
package InterfazUsuario;

import control.UtileriasGUI;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import objetosNegocio.Cancion;
import objetosNegocio.Genero;
import objetosServicio.Fecha;

/**
 *
 * @author User
 */
public class DlgCancion extends JDialog {

    private Cancion cancion;
    private StringBuffer respuesta;
    private int tipoOperacion; // 1=AGREGAR, 2=ACTUALIZAR, 3=ELIMINAR, 4=DESPLEGAR

    // Componentes del formulario (generados por NetBeans o manualmente)
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField txtClave;
    private javax.swing.JTextField txtTitulo;
    private javax.swing.JTextField txtInterprete;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextField txtGenero;
    private javax.swing.JTextField txtAlbum;
    private javax.swing.JTextField txtDuracion;
    private javax.swing.JTextField txtFecha;

    /**
     * Constructor del diálogo
     */
    public DlgCancion(Frame parent, String title, boolean modal,
                      Cancion cancion, ArrayList<Genero> listaGeneros,
                      String operacion, StringBuffer respuesta) {

        super(parent, title, modal);
        this.cancion = cancion;
        this.respuesta = respuesta;

        initComponents();
        setLocationRelativeTo(parent);

        // Determinar tipo de operación
        switch (operacion) {
            case UtileriasGUI.AGREGAR:
                tipoOperacion = 1;
                break;
            case UtileriasGUI.ACTUALIZAR:
                tipoOperacion = 2;
                break;
            case UtileriasGUI.ELIMINAR:
                tipoOperacion = 3;
                break;
            case UtileriasGUI.DESPLEGAR:
                tipoOperacion = 4;
                break;
        }

        cargarDatosEnFormulario();
        configurarSegunOperacion();
    }

    private void cargarDatosEnFormulario() {
        if (cancion == null) return;

        txtClave.setText(cancion.getClave());
        txtTitulo.setText(cancion.getTitulo());
        txtInterprete.setText(cancion.getInterprete());
        txtAutor.setText(cancion.getAutor() != null ? cancion.getAutor() : "");
        txtGenero.setText(cancion.getGenero() != null ? cancion.getGenero().getCveGenero() : "");
        txtAlbum.setText(cancion.getAlbum());
        txtDuracion.setText(String.valueOf(cancion.getDuracion()));

        if (cancion.getFecha() != null) {
            txtFecha.setText(cancion.getFecha().toString());
        }
    }

    private void configurarSegunOperacion() {
        boolean editable = tipoOperacion == 1 || tipoOperacion == 2; // Agregar o Actualizar

        txtClave.setEditable(editable && tipoOperacion == 1); // Clave solo editable al agregar
        txtTitulo.setEditable(editable);
        txtInterprete.setEditable(editable);
        txtAutor.setEditable(editable);
        txtGenero.setEditable(editable);
        txtAlbum.setEditable(editable);
        txtDuracion.setEditable(editable);
        txtFecha.setEditable(editable);

        btnAceptar.setText(tipoOperacion == 3 ? "Eliminar" : "Aceptar");

        if (tipoOperacion == 4) { // Solo Desplegar
            btnAceptar.setVisible(false);
        }
    }

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            // Guardar datos en el objeto cancion
            cancion.setClave(txtClave.getText().trim());
            cancion.setTitulo(txtTitulo.getText().trim());
            cancion.setInterprete(txtInterprete.getText().trim());
            cancion.setAutor(txtAutor.getText().trim());
            cancion.setAlbum(txtAlbum.getText().trim());

            if (!txtDuracion.getText().trim().isEmpty()) {
                cancion.setDuracion(Integer.parseInt(txtDuracion.getText().trim()));
            }

            // Género
            if (!txtGenero.getText().trim().isEmpty()) {
                Genero genero = new Genero(txtGenero.getText().trim().toUpperCase());
                cancion.setGenero(genero);
            }

            // Fecha (simple)
            if (!txtFecha.getText().trim().isEmpty()) {
                // Aquí puedes mejorar el parsing de fecha según tu clase Fecha
            }

            respuesta.replace(0, respuesta.length(),
                    tipoOperacion == 3 ? UtileriasGUI.ELIMINAR : UtileriasGUI.AGREGAR);

            dispose();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar los datos: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {
        respuesta.replace(0, respuesta.length(), UtileriasGUI.CANCELAR);
        dispose();
    }

    /**
     * Inicializa los componentes (puedes generarlo con NetBeans)
     */
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        txtClave = new javax.swing.JTextField();
        txtTitulo = new javax.swing.JTextField();
        txtInterprete = new javax.swing.JTextField();
        txtAutor = new javax.swing.JTextField();
        txtGenero = new javax.swing.JTextField();
        txtAlbum = new javax.swing.JTextField();
        txtDuracion = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();

        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Canción");

        // Configuración de labels y layout (simplificada)
        jLabel1.setText("Clave:");
        jLabel2.setText("Título:");
        jLabel3.setText("Intérprete:");
        jLabel4.setText("Autor Letra:");
        jLabel5.setText("Autor Música:");
        jLabel6.setText("Género (Clave):");
        jLabel7.setText("Álbum:");
        jLabel8.setText("Duración (seg):");

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(this::btnAceptarActionPerformed);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(this::btnCancelarActionPerformed);

        // Aquí deberías poner el GroupLayout completo generado por NetBeans
        // Por brevedad lo omito, pero puedes generarlo fácilmente en NetBeans

        pack();
    }

}
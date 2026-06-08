package AmanteMusica;
import excepciones.FachadaException;
import fachadas.FachadaArchivos;
import java.util.Date;
import objetosServicio.Fecha;

import javax.swing.*;
/**
 * <p>Title: AmanteMusica</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: ITSON</p>
 * @author Manuel Domitsu Kono
 * @version 1.0
 */
/**
 * Esta clase crea un cuadro de diálogo para capturar, editar y desplegar los
 * datos de una canción
 */
public class CapturaCancion extends javax.swing.JDialog {
    Date date =new Date();
    private final FachadaArchivos fachadaCancion;
    /** Creates new form NewJDialog */
    public CapturaCancion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        fachadaCancion = new FachadaArchivos();
    }
    public class CapturaCancion extends JDialog {
// Declaraciones de los componentes del cuadro de diálogo: Etiquetas,
// campos de texto, botones, etc
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTxtClave = new javax.swing.JTextField();
        jTxtTitulo = new javax.swing.JTextField();
        jTxtInterprete = new javax.swing.JTextField();
        jTxtAutorMusica = new javax.swing.JTextField();
        jTxtAutorLetra = new javax.swing.JTextField();
        jTxtGenero = new javax.swing.JTextField();
        jTxtAlbum = new javax.swing.JTextField();
        jTxtDisquera = new javax.swing.JTextField();
        // metodos que muestra los eventos de los botones guarder, limpiar y
        cancelar.
        private void GuardarActionPerformed(java.awt.event.ActionEvent evt)
        {
            try{
                objetosNegocio.Cancion cancion= new objetosNegocio.Cancion();
                if (this.jTxtClave.getText().trim().length()==0) {
                } else if (this.jTxtTitulo.getText().trim().length()==0) {
                } else if
                (this.jTxtInterprete.getText().trim().length()==0) {
                } else if
                (this.jTxtAutorLetra.getText().trim().length()==0) {
                } else if
                (this.jTxtAutorMusica.getText().trim().length()==0) {
                } else if (this.jTxtGenero.getText().trim().length()==0) {
                } else if (this.jTxtAlbum.getText().trim().length()==0) {
                } else if
                (this.jTxtDisquera.getText().trim().length()==0){
                } else if (this.jTxtDuracion.getText().trim().length()==0)
                {
                } else if (this.jTxtFecha.getText().trim().length()==0){
                } else {
                    cancion.setClave(this.jTxtClave.getText());
                    cancion.setTitulo(this.jTxtTitulo.getText());
                    cancion.setInterprete(this.jTxtInterprete.getText());
                    cancion.setAutorLetra(jTxtAutorLetra.getText());

                    cancion.setAutorMusica(this.jTxtAutorMusica.getText());
                    cancion.setGenero(this.jTxtGenero.getText());
                    cancion.setAlbum(this.jTxtAlbum.getText());
                    cancion.setDisquera(this.jTxtDisquera.getText());

                    cancion.setDuracion(Integer.parseInt(jTxtDuracion.getText()));
                    cancion.setFecha(new Fecha(12,02,1986));
                    fachadaCancion.agrega(cancion);
                }
            }catch (FachadaException fex) {
                fex.printStackTrace();
            }catch(Exception ex){
                ex.printStackTrace();
            }
            this.hide();
        }
        private void jButton2ActionPerformed(java.awt.event.ActionEvent
                                                     evt) {
            this.jTxtClave.setText("");
            this.jTxtTitulo.setText("");
            this.jTxtInterprete.setText("");
            this.jTxtAutorLetra.setText("");
            this.jTxtAutorMusica.setText("");
            this.jTxtGenero.setText("");
            this.jTxtAlbum.setText("");
            this.jTxtDisquera.setText("");
            this.jTxtDuracion.setText("");
            this.jTxtFecha.setText("");
        }
        private void jButton3ActionPerformed(java.awt.event.ActionEvent
                                                     evt) {
            this.dispose();
        }}}*/
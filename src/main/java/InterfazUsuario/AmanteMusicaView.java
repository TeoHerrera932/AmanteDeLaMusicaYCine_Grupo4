package InterfazUsuario;

import control.Tabla;
import control.Control;

import javax.swing.*;


//Ventana principal de la aplicacion
//Como FrameView es obsoleto al igual que import org.jdesktop.application.FrameView;
//Es necesrio reemplazar a una version mas actual es decir, JFrame por Frame view
//Y getFrame por this
public class AmanteMusicaView extends JFrame{
    private void opcionMenuAgregarCancionActionPerformed(java.awt.event.ActionEvent evt) {
        //Agrega la nueva canción
        control.agregaCancion(this);
        //Obtiene la lista de canciones
        Tabla tablaCanciones = control.getTablaCanciones(this);
        //Despliega la lista de canciones
        despliegaTabla(tablaCanciones);
    }
    private javax.swing.JTable jtabla;
    Control control = new Control();
    private void opcionMenuActualizarCancionActionPerformed(java.awt.event.ActionEvent evt) {
        //Actualiza la cancion
        control.actualizaCancion(this);
        //Obtiene la lista de canciones
        Tabla tablaCanciones = control.getTablaCanciones(this);
        //Despliega la lista de canciones
        despliegaTabla(tablaCanciones);
    }
    private void opcionMenuEliminarCancionActionPerformed(java.awt.event.ActionEvent evt) {
        //Elimina la cancion
        control.eliminaCancion(this);
        //Obtiene la lista de canciones
        Tabla tablaCanciones = control.getTablaCanciones(this);
        //Despliega la lista de canciones
        despliegaTabla(tablaCanciones);
    }
    private void opcionMenuConsultasCancionesTodasActionPerformed(java.awt.event.ActionEvent evt) {
        //Obtiene la lista de canciones
        Tabla tablaCanciones = control.getTablaCanciones(this);
        //Despliega la lista de canciones
        despliegaTabla(tablaCanciones);
    }
    private void despliegaTabla(Tabla tabla) {
        if (tabla == null || tabla.getCeldas() == null) {
            JOptionPane.showMessageDialog(this, "No hay datos para mostrar");
            return;
        }

        TablaCanciones tablaGUI = new TablaCanciones(tabla.getCeldas()); // Ajusta según tu clase
        tablaGUI.setTitle(tabla.getTitulo());
        tablaGUI.setVisible(true);
    }
}

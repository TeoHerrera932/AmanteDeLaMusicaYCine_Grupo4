package AmanteMusica;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class FrmAmanteMusica extends JFrame {
    public FrmAmanteMusica() {
        super("Amante de la Música");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FrmAmanteMusica().setVisible(true));
    }
}

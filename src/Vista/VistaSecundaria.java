/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Daw1
 */
public class VistaSecundaria {

    public JButton close;
    public JDialog ventanaSecundaria;
    public Vista v;

    public VistaSecundaria(Vista v_) {
        v = v_;
        close = new JButton("OK");
        ventanaSecundaria = new JDialog(v.j, "Ventana secundaria");
        ventanaSecundaria.setSize(600, 300);

        JTextArea texto = new JTextArea();
        texto.setEditable(false);
        texto.setLineWrap(true);

        /**
         * v.items[0].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
         * ActionEvent.CTRL_MASK));
         * v.items[1].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
         * ActionEvent.CTRL_MASK));
         * v.items[2].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
         * ActionEvent.CTRL_MASK));
         * v.items[3].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,
         * ActionEvent.CTRL_MASK));
         * v.items[10].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,
         * ActionEvent.CTRL_MASK));
         * v.items[13].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,
         * ActionEvent.CTRL_MASK));
         * v.items[16].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,
         * ActionEvent.CTRL_MASK));
         */
        texto.setText("Usa la caja de texto para escribir, en el menu archivo encontrarás todo lo relacionado con el archivo, en la parte de editar encontraras todo lo relacionado con el texto, en formato, todo lo relacionado con en diseño y en ayuda tendras la ayuda"
                + "atajos: CTRL+N -> nuevo \n"
                + "CTRL+O -> abrir \n"
                + "CTRL+S -> guardar \n"
                + "CTRL+G -> guardar como \n"
                + "CTRL + F -> buscar \n"
                + "CTRL+E -> seleccionar todo \n"
                + "CTRL + W -> Ayuda");

        JPanel panel = (JPanel) ventanaSecundaria.getContentPane();

        panel.setLayout(new BoxLayout(panel,2));
        JPanel panel2 = new JPanel();
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.PAGE_AXIS));

        panel.add(texto);
        panel.add(panel2);
        panel2.add(close);
    }
}

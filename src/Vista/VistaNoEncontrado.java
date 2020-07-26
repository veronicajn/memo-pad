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

/**
 *
 * @author Javier Cuevas García
 */
public class VistaNoEncontrado {

    public JButton close;
    public JDialog ventanaSecundaria;
    public Vista v;

    public VistaNoEncontrado(Vista v_) {
        v = v_;
        close = new JButton("OK");
        ventanaSecundaria = new JDialog(v.j, "Ventana secundaria");
        ventanaSecundaria.setSize(400, 200);
        JPanel panel = (JPanel) ventanaSecundaria.getContentPane();

     
        panel.setLayout(new GridLayout(2, 1));
        JPanel panel2 = new JPanel();
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.PAGE_AXIS));

        JLabel error = new JLabel("No se encuentra la palabra en el texto");
        panel.add(error);
        panel.add(panel2);
        panel2.add(close);

    }

}

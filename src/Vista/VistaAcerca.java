/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Daw1
 */
public class VistaAcerca {

    public JButton close;
    public JDialog ventanaSecundaria;
    public Vista v;

    public VistaAcerca(Vista v_) {
        v = v_;
        close = new JButton("OK");
        ventanaSecundaria = new JDialog(v.j, "Ventana secundaria");
        ventanaSecundaria.setSize(400, 200);
        JPanel panel = (JPanel) ventanaSecundaria.getContentPane();
        JPanel panelSecundario = new JPanel();
        ventanaSecundaria.add(panelSecundario);
        panelSecundario.setLayout(new GridLayout(2, 1));
        JLabel error = new JLabel("Created by Javier Cuevas García");
        panelSecundario.add(error);
        panelSecundario.add(close);

    }

}

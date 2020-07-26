/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Daw1
 */
public class ControladorSecundario {

    VistaSecundaria v;

    public ControladorSecundario(VistaSecundaria v) {
        this.v = v;
        ActionListener errorL = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                v.ventanaSecundaria.setVisible(false);
            }
        };
        v.close.addActionListener(errorL);
       
    }

    

}

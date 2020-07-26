/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.Vista;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Javier Cuevas García
 */
public class Controlador extends MouseAdapter {

    Vista v;

    public Controlador(Vista v) {
        this.v = v;
        cMl(v);

//       && cMouseAdapter();
    }

    private void cMl(Vista v) {
        v.caja.addMouseListener(this);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.isPopupTrigger()) {
            doPop(e);

        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.isPopupTrigger()) {
            doPop(e);
        }
    }

    private void doPop(MouseEvent e) {

        v.popup.show(v.j, e.getX(), e.getY());

    }
}

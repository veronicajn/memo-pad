/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blocdenotas;

import Controlador.*;

import Vista.*;

/**
 *
 * @author Javier Cuevas García
 */
public class BlocDeNotas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Vista v = new Vista();
        VistaNoEncontrado vE = new VistaNoEncontrado(v);
        VistaSecundaria vs = new VistaSecundaria(v);
        VistaAcerca vA = new VistaAcerca(v);

        ControladorAcerca cA = new ControladorAcerca(vA);
        ControladorSecundario cS = new ControladorSecundario(vs);

        Controlador c = new Controlador(v);
        ControladorListeners cl = new ControladorListeners(v, vE,vs,vA);
        ControladorVistaNoEncontrado cNE = new ControladorVistaNoEncontrado(vE);
        ControladorAction cAc = new ControladorAction(v);

    }

}

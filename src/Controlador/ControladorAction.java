/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.Vista;
import java.awt.Component;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;
import javax.swing.text.DefaultEditorKit;

/**
 *
 * @author Javier Cuevas García
 */
public class ControladorAction {

    Vista v;

    public ControladorAction(Vista v) {
        this.v = v;
        crearAction();
    }

    private void crearAction() {

        //Cojes un mapa con todas las accciones que puedes hacer dentro de un textArea;
        ActionMap ax = v.caja.getActionMap();

        //te creas la acción de copiar, buscando en el mapa creado anteriormente la accion de "copiar", 
        Action copiar = ax.get(DefaultEditorKit.copyAction); //Default blah blah blah es simplemente para indicar al mapa, que tipo de accion quieres que te dé
        copiar.putValue(Action.NAME, "Copiar"); //putValue añade a esa acción un nombre
        copiar.putValue(Action.SMALL_ICON, new ImageIcon(getClass().getResource("/resources/copy.png")));

        copiar.putValue(Action.ACCELERATOR_KEY, KeyStroke.getAWTKeyStroke('C', Event.CTRL_MASK)); //dependiendo de lo que tenga dentro putValue, también puede añadir un atajo, como ctrl+c para copiar
        v.editar.add(copiar); //lo añadimos al menú de editar, y, como hemos creado antes la accion con el nombre de Copiar y hemos puesto que sea esa su funcionalidad, se añadirá al menú con el nombre de "Copiar"
        v.popup.add(copiar);
        v.barraH.add(copiar);

//AND repeat para el restro
        Action pegar = ax.get(DefaultEditorKit.pasteAction);
        pegar.putValue(Action.NAME, "Pegar");
        pegar.putValue(Action.ACCELERATOR_KEY, KeyStroke.getAWTKeyStroke('V', Event.CTRL_MASK));
        pegar.putValue(Action.SMALL_ICON, new ImageIcon(getClass().getResource("/resources/paste.png")));
        v.editar.add(pegar);
        v.barraH.add(pegar);

        Action cut = ax.get(DefaultEditorKit.cutAction);
        cut.putValue(Action.NAME, "Cortar");
        cut.putValue(Action.ACCELERATOR_KEY, KeyStroke.getAWTKeyStroke('X', Event.CTRL_MASK));
        cut.putValue(Action.SMALL_ICON, new ImageIcon(getClass().getResource("/resources/cut.png")));

        v.editar.add(cut);
        v.barraH.add(cut);
        v.popup.add(cut);

        Action select = ax.get(DefaultEditorKit.selectAllAction);
        select.putValue(Action.NAME, "Seleccionar todo");
        select.putValue(Action.ACCELERATOR_KEY, KeyStroke.getAWTKeyStroke('E', Event.CTRL_MASK));
        select.putValue(Action.SMALL_ICON, new ImageIcon(getClass().getResource("/resources/select.png")));

        v.editar.add(select);
        v.popup.add(select);

        /**
         * items[0].setText("Nuevo"); items[1].setText("Abrir");
         * items[2].setText("Guardar"); items[3].setText("Guardar como");
         * items[4].setText("Salir"); //Editar items[5].setText("Deshacer");
         * items[6].setText("Rehacer"); items[7].setText("Cortar");
         * items[8].setText("Pegar"); items[9].setText("Eliminar");
         * items[10].setText("Buscar"); items[11].setText("Reemplazar");
         * items[12].setText("Ir a"); items[13].setText("Seleccionar todo");
         * //Formato items[14].setText("Ajustes de Linea");
         * items[15].setText("Fuente.."); Formato.add(items[14]);
         * Formato.add(items[15]); //Ayuda items[16].setText("Ver la ayuda");
         * items[17].setText("Acerca de");
         *
         */
        v.items[0].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        v.items[1].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        v.items[2].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        v.items[3].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));
        v.items[10].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
        v.items[13].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        v.items[16].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));

    }

}

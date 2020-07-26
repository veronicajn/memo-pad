/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import library.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;

/**
 *
 * @author Javier Cuevas García
 */
public class ControladorListeners {

    boolean creado;
    File archivo;

    Vista v;
    VistaNoEncontrado vNE;
    Clipboard clpbrd;
    VistaSecundaria vs;
    VistaAcerca va;

    public ControladorListeners(Vista v, VistaNoEncontrado vNE, VistaSecundaria vs, VistaAcerca va) {
        this.vNE = vNE;
        this.vs = vs;
        this.va = va;
        this.v = v;
        creado = false;
        clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
        cListeners();
    }

    private void cListeners() {
        ActionListener ALguardar = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                String x = v.caja.getText();
                if (x.equals("")) {
                    v.caja.setText("");
                } else {

                    archivo = guardarArch();
                    creado = true;
                }

            }
        };
        v.items[3].addActionListener(ALguardar);

        ActionListener ALabrir = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                String x = v.caja.getText();
                if (x.equals(" ") || x.equals("")) {
                    abrirArch();
                } else {

                    archivo = guardarArch();
                    creado = true;
                }

            }
        };
        v.items[1].addActionListener(ALabrir);

        ActionListener ALNuevo = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                String x = v.caja.getText();
                if (x.equals(" ") || x.equals("")) {
                    v.caja.setText("");
                    creado = false;
                } else {

                    archivo = guardarArch();
                    creado = true;
                    v.caja.setText("");
                }

            }
        };

        v.items[0].addActionListener(ALNuevo);

        ActionListener ALSalir = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                String x = v.caja.getText();
                if (x.equals(" ") || x.equals("")) {
                    System.exit(0);
                } else {

                    archivo = guardarArch();
                    creado = true;
                    v.caja.setText("");
                    System.exit(0);
                }

            }
        };
        v.items[4].addActionListener(ALSalir);

        ActionListener ALSave = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                String x = v.caja.getText();

                archivo = save();
                creado = true;

            }

        };

        v.items[2].addActionListener(ALSave);

        ActionListener ALBuscar = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                buscar();

            }

        };

        v.items[10].addActionListener(ALBuscar);

        ActionListener AlHelp = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                vs.ventanaSecundaria.setVisible(true);
            }
        };

        ActionListener AlAcerca = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                va.ventanaSecundaria.setVisible(true);

            }
        };

        v.items[16].addActionListener(AlHelp);
        v.items[17].addActionListener(AlAcerca);

   
    }

    //METODOS
    //Funciona
    private void abrirArch() {
        JFileChooser fileChooser = new JFileChooser();
        int seleccion = fileChooser.showOpenDialog(v.caja);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File fichero = fileChooser.getSelectedFile();
            String test = Archivo.Leer(fichero);
            v.caja.setText(test);
        }

    }

    //Funciona
    private File guardarArch() {
        File fichero = null;
        JFileChooser fileChooser = new JFileChooser();
        int seleccion = fileChooser.showSaveDialog(v.caja);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            fichero = fileChooser.getSelectedFile();
            PrintWriter writer = null;
            try {
                writer = new PrintWriter(fichero);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ControladorListeners.class.getName()).log(Level.SEVERE, null, ex);
            }
            writer.print(v.caja.getText());
            writer.close();
        }
        return fichero;

    }
//Funciona

    private File save() {
        File fichero = null;
        if (creado) {
            Archivo.Editar(archivo, v.caja.getText());
        } else {
            fichero = guardarArch();

        }
        return fichero;

    }
    ///Funciona

    private void buscar() {

        String textCaja = v.caja.getSelectedText();
        Highlighter highlighter = v.caja.getHighlighter();
        HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.pink);
        highlighter.removeAllHighlights();

        String textoABuscar = JOptionPane.showInputDialog(v.caja, "Texto a buscar", textCaja);
        int pos = v.caja.getText().indexOf(textoABuscar);
        if (pos == -1) {
            vNE.ventanaSecundaria.setVisible(true);
        } else {

            int p1 = pos + textoABuscar.length();
            try {

                highlighter.addHighlight(pos, p1, painter);
            } catch (BadLocationException ex) {
                Logger.getLogger(ControladorListeners.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}

//    private void copy() {
//
//        StringSelection stringSelection = new StringSelection(v.caja.getText());
//
//        clpbrd.setContents(stringSelection, null);
//
//    }
//
//    private void pegar() {
//
//        Transferable t = clpbrd.getContents(this);
//        if (t == null) {
//            System.out.println("here");
//            return;
//
//        }
//        try {
//            v.caja.setText((String) t.getTransferData(DataFlavor.stringFlavor));
//        } catch (UnsupportedFlavorException | IOException e) {
//
//        }//
//    }


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Javier Cuevas García
 */
public class Vista {

    int w;
    int h;
    public JFrame j;

    public JTextArea caja;
    public JPanel pPrincipal;

    //Menu
    public JMenuBar bMenu;
    public JMenu archivo;
    public JMenu editar;
    public JMenu Formato;
    public JMenu ayuda;
    public JMenuItem[] items;
//EndMenu

    public JPopupMenu popup;
    public JMenuItem[] popI;
    public JToolBar barraH;

    public Vista() {
        w = 900;
        h = 600;
        initFrame();

        initPanelPrinc();
        toolbar();

        initiTextField();
        jmenu();
        popUP();

        j.setVisible(true);
    }

    private void initFrame() {
        j = new JFrame();

        j.setTitle("Bloc de notas");
        j.setSize(w, h);
        j.setLocationRelativeTo(null);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void initPanelPrinc() {

        pPrincipal = (JPanel) j.getContentPane();

        pPrincipal.setLayout(new BoxLayout(pPrincipal, BoxLayout.PAGE_AXIS));

        j.setContentPane(pPrincipal);

    }

    private void initiTextField() {

        TitledBorder tB = new TitledBorder(BorderFactory.createLineBorder(Color.black), "Bloc de Notas");
        caja = new JTextArea(" ");
        caja.setBorder(tB);
        caja.setPreferredSize(new Dimension(w, h));
        caja.setLineWrap(true);

        //caja.set //caja.setBounds(w, h-10, w, h);
        Box box = Box.createVerticalBox();
        box.add(Box.createVerticalGlue());
        box.add(caja);
        box.add(Box.createVerticalGlue());
        //caja.setAlignmentY(TOP_ALIGNMENT);
        pPrincipal.add(box);

    }

    private void jmenu() {
        bMenu = new JMenuBar();
        archivo = new JMenu("Archivo");
        editar = new JMenu("Editar");
        Formato = new JMenu("Formato");
        ayuda = new JMenu("Ayuda");

        bMenu.add(archivo);
        bMenu.add(editar);
        bMenu.add(Formato);
        bMenu.add(ayuda);
        j.setJMenuBar(bMenu);
        items = new JMenuItem[18];

        for (int i = 0; i < items.length; i++) {
            items[i] = new JMenuItem();
        }
        /*
         archivo -> 0-4
         editar ->5-13
         Formato -> 14-15
         ayuda ->16-17       
         */

        //Archivo
        items[0].setText("Nuevo");
        items[1].setText("Abrir");
        items[2].setText("Guardar");
        items[3].setText("Guardar como");
        items[4].setText("Salir");

        for (int i = 0; i < 5; i++) {
            archivo.add(items[i]);
            if (i == 0 || i == 3) {
                archivo.addSeparator();
            }
        }

//        //Editar
//        items[5].setText("Deshacer");
//        items[6].setText("Rehacer");
//        items[7].setText("Copiar");
//        items[8].setText("Pegar");
//        items[9].setText("Eliminar");
        items[10].setText("Buscar");
        items[10].setIcon(new ImageIcon(getClass().getResource("/resources/search.png")));
        editar.add(items[10]);
//        items[11].setText("Reemplazar");
//        items[12].setText("Ir a");
//        items[13].setText("Seleccionar todo");
//        for (int i = 5; i < 14; i++) {
//            editar.add(items[i]);
//            switch (i) {
//                case 6:
//                    editar.addSeparator();
//                    break;
//                case 9:
//                    editar.addSeparator();
//                    break;
//                case 12:
//                    editar.addSeparator();
//                    break;
//
//            }

//        }
        //Formato
        items[14].setText("Ajustes de Linea");
        items[15].setText("Fuente..");
        Formato.add(items[14]);
        Formato.add(items[15]);

        //Ayuda
        items[16].setText("Ver la ayuda");
        items[17].setText("Acerca de");

        ayuda.add(items[16]);
        ayuda.addSeparator();
        ayuda.add(items[17]);

    }

    private void popUP() {

        // definimos un 'adaptador' para manejar los eventos del ratón
        popup = new JPopupMenu(); //creamos el menú saliente

        popI = new JMenuItem[3];

    }

    private void toolbar() {

        barraH = new JToolBar();
        barraH.setRollover(true);
        barraH.setFloatable(false);

        pPrincipal.add(barraH);
    }

}

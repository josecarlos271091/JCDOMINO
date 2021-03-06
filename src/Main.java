
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
/**
 *@author Jose Carlos Soto
 */
class Main extends JFrame {

    static String nombreU = "",  parejaSel = "";
    static int punt;
    private Media media = new Media();
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu juego;
    private javax.swing.JMenu ayuda;
    private javax.swing.JSeparator sep;
    static javax.swing.JMenuItem aDeDom;
    private javax.swing.JMenuItem salir;
    static javax.swing.JMenuItem verP;
    static javax.swing.JMenuItem nuevoJ;
    static javax.swing.JMenuItem sucesos;
    private javax.swing.JButton continuar;
    static javax.swing.JButton jugDN;
    static javax.swing.JButton salida;
    static javax.swing.JButton OK;
    private javax.swing.JTextField nombre;
    private javax.swing.JSpinner pM;
    static javax.swing.JComboBox pareja;
    private static javax.swing.JTable tabla;
    private static javax.swing.JDialog dialog;
    static Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
    static int w = (int) (pantalla.getWidth());
    static int h = (int) (pantalla.getHeight());
    private Animadora f;

    public Main() {

        diseno();
        animacion();
    }

    private void animacion() {
        f = new Animadora();
        this.add(f);
        f.setBounds(-2, -29, 800, 600);
        DibujaInicio t = new DibujaInicio();
        t.start();
        MuestraConfig t1 = new MuestraConfig();
        t1.start();
        setVisible(true);
    }

    public void diseno() {

        
        dialog = new javax.swing.JDialog();
        dialog.setModal(true);
        tabla = new javax.swing.JTable();
        tabla.setShowHorizontalLines(false);
        nombre = new javax.swing.JTextField();
        nombre.setFont(new java.awt.Font("Arial Black", 0, 32));
        nombre.setText("Usuario");
        nombre.setOpaque(false);
        nombre.selectAll();
        nombre.setVisible(false);
        pM = new javax.swing.JSpinner();
        pM.setFont(new java.awt.Font("Arial Black", 0, 40));
        pM.setModel(new javax.swing.SpinnerNumberModel(100, 10, 250, 10));
        pM.setVisible(false);
        pareja = new javax.swing.JComboBox();
        pareja.addItem("Botagorda");
        pareja.addItem("Aliado");
        pareja.addItem("Dominador");
        pareja.setForeground(new java.awt.Color(0, 0, 0));
        pareja.setFont(new java.awt.Font("Arial Black", 0, 20));
        pareja.setVisible(false);
        continuar = new javax.swing.JButton();
        continuar.setOpaque(false);
        jugDN = new javax.swing.JButton("Jugar de nuevo");
        salida = new javax.swing.JButton("Cancelar");
        OK = new javax.swing.JButton("OK");
        OK.setVisible(false);
        sep = new javax.swing.JSeparator();
        jMenuBar1 = new javax.swing.JMenuBar();
        juego = new javax.swing.JMenu();
        ayuda = new javax.swing.JMenu();
        aDeDom = new javax.swing.JMenuItem();
        nuevoJ = new javax.swing.JMenuItem();
        verP = new javax.swing.JMenuItem();
        sucesos = new javax.swing.JMenuItem();
        salir = new javax.swing.JMenuItem();
        tabla.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null}, {null, null}, {null, null}, {null, null},
                    {null, null}, {null, null}, {null, null}, {null, null},
                    {null, null}, {null, null}, {null, null}, {null, null},
                    {null, null}, {null, null}, {null, null}, {null, null}
                },
                new String[]{
                    "", ""
                }) {

            boolean[] canEdit = new boolean[]{
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });

        dialog.setLayout(null);
        dialog.add(OK);
        OK.setBounds(95, 250, 60, 25);
        dialog.add(jugDN);
        jugDN.setBounds(5, 250, 120, 25);
        dialog.add(salida);
        salida.setBounds(128, 250, 90, 25);
        dialog.add(tabla);
        tabla.setBounds(0, 0, 250, 320);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setSize(800, 624);
        this.setLocation((w - 800) / 2, (h - 624) / 2);
        this.setResizable(false);
        this.setIconImage(media.cIcon("fichas/wit.png").getImage());
        this.setCursor(new Cursor(12));
        sucesos.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clicked8(evt);
            }
        });
        salida.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clicked5(evt);
            }
        });
        OK.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clicked5(evt);
            }
        });
        jugDN.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clicked12(evt);
            }
        });
        nuevoJ.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clicked1(evt);
            }
        });
        continuar.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clicked2(evt);
            }
        });
        salir.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clicked3(evt);
            }
        });
        verP.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clicked4(evt);
            }
        });
        aDeDom.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clicked6(evt);
            }
        });
        sucesos.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                enterM(evt);
            }
        });
        nuevoJ.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                enterM(evt);
            }
        });
        verP.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                enterM(evt);
            }
        });
        salir.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                enterM(evt);
            }
        });
        continuar.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                enterM(evt);
            }
        });
        aDeDom.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                enterM(evt);
            }
        });
        aDeDom.setText("Acerca de...");
        sucesos.setText("Sucesos");
        sucesos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        sucesos.setIcon(media.cIcon("botones/edit-find-replace.png"));
        sucesos.setEnabled(false);
        verP.setText("Ver puntuacion");
        verP.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        verP.setIcon(media.cIcon("botones/edit-find-replace.png"));
        verP.setEnabled(false);
        salir.setText("Salir");
        salir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.ALT_MASK));
        salir.setIcon(media.cIcon("botones/salir.png"));
        nuevoJ.setText("Nuevo juego");
        nuevoJ.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        nuevoJ.setIcon(media.cIcon("botones/reini.png"));
        aDeDom.setIcon(media.cIcon("fichas/wit.png"));
        juego.setText("Juego");
        ayuda.setText("Ayuda");
        juego.setIcon(media.cIcon("botones/system-run.png"));
        this.setTitle("DOMINÓ");
        jMenuBar1.add(juego);
        jMenuBar1.add(ayuda);
        ayuda.add(aDeDom);
        juego.add(nuevoJ);
        juego.add(verP);
        juego.add(sucesos);
        juego.add(sep);
        juego.add(salir);

        this.setLayout(null);
        this.add(nombre);
        nombre.setBounds(416, 177, 150, 50);
        this.add(pM);
        pM.setBounds(416, 266, 150, 50);
        this.add(pareja);
        pareja.setBounds(416, 229, 150, 35);
        this.add(continuar);
        continuar.setVisible(false);
        continuar.setBackground(Color.RED);
        continuar.setBorder(null);
        continuar.setBorderPainted(false);
        continuar.setRolloverIcon(media.cIcon("botones/continuar1a.png"));
        continuar.setIcon(media.cIcon("botones/continuar1.png"));
        continuar.setBounds(328, 321, 140, 48);
        setJMenuBar(jMenuBar1);

    }


    class MuestraConfig extends Thread {

        public void run() {

            f.muestraConfig();
            continuar.setVisible(true);
            nombre.setVisible(true);
            pM.setVisible(true);
            pM.setValue(100);
            pareja.setVisible(true);

        }
    }

    class DibujaInicio extends Thread {

        public void run() {


            f.dibujaInicio();

        }
    }

    public void clicked12(java.awt.event.ActionEvent evt) {
        dialog.setVisible(false);

        f.Carga(1);

        DibujaInicio t = new DibujaInicio();
        t.start();
        MuestraConfig t1 = new MuestraConfig();
        t1.start();
        pareja.setSelectedIndex(0);

    }

    public void clicked1(java.awt.event.ActionEvent evt) {
        int r = JOptionPane.showConfirmDialog(this, "¿Seguro que desea abandonar esta partida?", "Atención", JOptionPane.YES_NO_OPTION);
        if (r == JOptionPane.YES_OPTION) {

            f.Carga(1);
            DibujaInicio t = new DibujaInicio();
            t.start();
            MuestraConfig t1 = new MuestraConfig();
            t1.start();
            pareja.setSelectedIndex(0);
        }
    }

    class OcultaConfig extends Thread {

        public void run() {
            continuar.setVisible(false);
            nombre.setVisible(false);
            pM.setVisible(false);
            pareja.setVisible(false);
            f.ocultaConfig();
        }
    }

    class DibujaMesa extends Thread {

        public void run() {

            f.dibujaMesa(0);

        }
    }

    public static void abilita(int i) {
        nuevoJ.setEnabled(true);
        verP.setEnabled(true);
        aDeDom.setEnabled(true);
        sucesos.setEnabled(true);

    }

    public static void desabilita() {
        nuevoJ.setEnabled(false);
        verP.setEnabled(false);
        aDeDom.setEnabled(false);
        sucesos.setEnabled(false);

    }

    public static void muestraPunt(int tipo, int v1, int v2, int fil) {

        dialog.setLocation((w - 250) / 2, (h - 320) / 2);
        dialog.setResizable(false);
        dialog.setSize(250, 320);
        tabla.setValueAt(nombreU + "/" + parejaSel, 0, 0);
        tabla.setValueAt("Maquina-1/Maquina-2", 0, 1);
        if (tipo == 1) {
            jugDN.setVisible(false);
            salida.setVisible(false);
            OK.setVisible(true);
            dialog.setTitle("Puntuacion");
            tabla.setValueAt(v1, fil, 0);
            tabla.setValueAt(v2, fil, 1);
            dialog.setVisible(true);
        } else {
            if (tipo == 2) {

                jugDN.setVisible(true);
                salida.setVisible(true);
                OK.setVisible(false);
                dialog.setTitle("Juego terminado");
                tabla.setValueAt(v1, fil, 0);
                tabla.setValueAt(v2, fil, 1);
                if (v1 > v2) {
                    tabla.setValueAt("Ganador", fil + 1, 0);
                } else {
                    tabla.setValueAt("Ganador", fil + 1, 1);
                }
                dialog.setVisible(true);
            } else {
                dialog.setTitle("Puntuacion");
                jugDN.setVisible(false);
                salida.setVisible(false);
                OK.setVisible(true);
                dialog.setVisible(true);
            }
        }


    }

    public void clicked2(java.awt.event.ActionEvent evt) {
        for (int i = 1; i < tabla.getRowCount(); i++) {
            tabla.setValueAt("", i, 0);
            tabla.setValueAt("", i, 1);
        }
        punt = (Integer) pM.getValue();
        nombreU = nombre.getText();
        parejaSel = (String) pareja.getSelectedItem();
        f.Carga(pareja.getSelectedIndex());
        OcultaConfig t2 = new OcultaConfig();
        t2.start();
        DibujaMesa t4 = new DibujaMesa();
        t4.start();


    }

    public void clicked3(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    public void clicked4(java.awt.event.ActionEvent evt) {
        this.muestraPunt(3, 0, 0, 0);
    }

    private void enterM(java.awt.event.MouseEvent evt) {
        media.PlayAudio(2);
    }

    private void clicked5(ActionEvent evt) {
        
        dialog.setVisible(false);
        
    }

    private void clicked6(ActionEvent evt) {
        KDialog pi = new KDialog();
        pi.setVisible(true);
    }

    class KDialog extends javax.swing.JDialog {

        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int w = (int) (pantalla.getWidth());
        int h = (int) (pantalla.getHeight());
        private javax.swing.JButton OK;
        private KPanel kp;

        public KDialog() {
            diseño();
        }

        public void diseño() {
            OK = new javax.swing.JButton("OK");
            kp = new KPanel();

            this.setTitle("Acerca");
            this.setIconImage(media.cIcon("fichas/wit.png").getImage());
            this.setModal(true);
            this.setSize(300, 150);
            this.setResizable(false);
            this.setLocation((w - 300) / 2, (h - 150) / 2);
            this.setLayout(null);
            this.add(OK);
            OK.setOpaque(false);
            OK.hide();
            OK.setBounds(240, 95, 50, 25);
            this.add(kp);
            kp.setBounds(0, 0, 300, 150);
            OK.addActionListener(new java.awt.event.ActionListener() {

                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    clicked7(evt);
                }
            });


        }

        private void clicked7(ActionEvent evt) {
            this.setVisible(false);
        }

        class KPanel extends JPanel {

            private int x1,  x2,  x3;

            public KPanel() {
                x1 = -130;
                x2 = -130;
                x3 = -130;
                present = media.cIcon("partes/present.jpg").getImage();
                KThread kt = new KThread();
                kt.start();
                repaint();
            }
            Image present;

            public void paint(Graphics g) {
                g.setColor(Color.BLACK);
                g.fillRect(0, 0, 300, 150);
                g.drawImage(present, 0, 0, 150, 130, this);
                g.setColor(Color.WHITE);
                g.drawString("DOMINO (2011)", x1, 20);
                g.drawString("Autor:", x2, 50);
                g.drawString("Jose Carlos Soto", x3, 80);
                
            }

            public void anim() {
                for (int i = 0; i < 160; i += 10) {
                    x1 = i;
                    repaint();
                    try {
                        Thread.sleep(40);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                for (int i = 0; i < 160; i += 10) {
                    x2 = i;
                    repaint();
                    try {
                        Thread.sleep(40);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                for (int i = 0; i < 160; i += 10) {
                    x3 = i;
                    repaint();
                    try {
                        Thread.sleep(40);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                OK.setVisible(true);
            }

            class KThread extends Thread {

                public void run() {
                    anim();
                }
            }
        }
    }

    private void clicked8(ActionEvent evt) {
        media.PlayAudio(2);
        ArrayList<String> sucs = Animadora.getSucs();
        String[] sucss = new String[sucs.size()];
        for (int i = 0; i < sucs.size(); i++) {
            sucss[i] = sucs.get(i) + "\n";
        }
        JOptionPane.showMessageDialog(this, sucss, "Sucesos", JOptionPane.OK_OPTION, media.cIcon("botones/edit-find-replace.png"));

    }


    public static void main(String[] args) {
        try{
            UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
        }catch(Exception e){}
        JFrame.setDefaultLookAndFeelDecorated(false);
       new Main();
    }
}

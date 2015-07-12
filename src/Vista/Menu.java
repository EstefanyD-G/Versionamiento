package Vista;

import javax.swing.*;            // para los botones
import java.awt.*;               //Paquete que contiene imagenes y eventos "awt"
import java.awt.event.*;
import Vista.*;

public class Menu extends JFrame implements ActionListener, MouseListener, MouseMotionListener {

    JLabel jlbSOGA;
    JLabel jlbNombre, jlbCorreo, jlbimage;
    JLabel jlb_x1, jlb_x2;

    JButton jbtnInicio;
    JButton jbtnUsuarios;
    JButton jbtnActividad;
    JButton jbtnCronograma;
    JButton jbtnCerrarSesion;

    JPanel jpMovedor, jpInicio;

    Usuarios jpUsuarios = new Usuarios();
    Actividad jpActividad = new Actividad();
    Cronograma jpCronograma = new Cronograma();

    String Correo, Clave, Nombre, Apellido, Telefono, Celular;

    int x, y;
    Color a = Color.GRAY;
    Color b = Color.DARK_GRAY;
    Color c = Color.DARK_GRAY;
    Color d = Color.DARK_GRAY;

    public Menu() {
        super.setTitle("Menu");
        super.setSize(882, 600);
        super.setLayout(null);
        super.setUndecorated(true);
        super.getContentPane().setBackground(Color.BLACK);
        super.setResizable(true);
        super.setLocationRelativeTo(null);
        super.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/icono.png")).getImage());
        this.setVisible(true);
        
        jlb_x1 = new JLabel("-");
        jlb_x1.setBounds(809, 15, 25, 25);
        jlb_x1.setForeground(Color.WHITE);
        jlb_x1.setFont(new Font("Segoe UI", Font.PLAIN, 40));
        jlb_x1.addMouseListener(this);
        jlb_x1.setToolTipText("Minimizar");
        jlb_x1.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        this.add(jlb_x1);

        jlb_x2 = new JLabel("x");
        jlb_x2.setBounds(839, 10, 20, 30);
        jlb_x2.setForeground(Color.WHITE);
        jlb_x2.setFont(new Font("Segoe UI", Font.PLAIN, 25));
        jlb_x2.addMouseListener(this);
        jlb_x2.setToolTipText("Cerrar");
        jlb_x2.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        this.add(jlb_x2);

        jbtnCerrarSesion = new JButton(" Cerrar Sesión");
        jbtnCerrarSesion.setBounds(480, 0, 120, 61);
        jbtnCerrarSesion.setBorder(null);
        jbtnCerrarSesion.setBackground(Color.DARK_GRAY);
        jbtnCerrarSesion.setForeground(Color.WHITE);
        jbtnCerrarSesion.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        jbtnCerrarSesion.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnCerrarSesion.addMouseListener(this);
        jbtnCerrarSesion.addActionListener(this);
        jbtnCerrarSesion.setFocusPainted(false);
        this.add(jbtnCerrarSesion);

        jbtnCronograma = new JButton(" Cronograma");
        jbtnCronograma.setBounds(360, 0, 120, 61);
        jbtnCronograma.setBorder(null);
        jbtnCronograma.setBackground(d);
        jbtnCronograma.setForeground(Color.WHITE);
        jbtnCronograma.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        jbtnCronograma.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnCronograma.addMouseListener(this);
        jbtnCronograma.setFocusPainted(false);
        this.add(jbtnCronograma);

        jbtnActividad = new JButton(" Actividad");
        jbtnActividad.setBounds(240, 0, 120, 61);
        jbtnActividad.setBorder(null);
        jbtnActividad.setBackground(c);
        jbtnActividad.setForeground(Color.WHITE);
        jbtnActividad.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        jbtnActividad.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnActividad.addMouseListener(this);
        jbtnActividad.setFocusPainted(false);
        this.add(jbtnActividad);

        jbtnUsuarios = new JButton(" Usuarios");
        jbtnUsuarios.setBounds(120, 0, 120, 61);
        jbtnUsuarios.setBorder(null);
        jbtnUsuarios.setBackground(b);
        jbtnUsuarios.setForeground(Color.WHITE);
        jbtnUsuarios.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        jbtnUsuarios.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnUsuarios.addMouseListener(this);
        jbtnUsuarios.setFocusPainted(false);
        this.add(jbtnUsuarios);

        jbtnInicio = new JButton(" Inicio");
        jbtnInicio.setBounds(0, 0, 120, 61);
        jbtnInicio.setBorder(null);
        jbtnInicio.setBackground(a);
        jbtnInicio.setForeground(Color.WHITE);
        jbtnInicio.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        jbtnInicio.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnInicio.addMouseListener(this);
        jbtnInicio.setFocusPainted(false);
        this.add(jbtnInicio);
        //Fin Menu

        JPanel jpBotones = new JPanel();
        jpBotones.setBackground(Color.DARK_GRAY);
        jpBotones.add(jbtnInicio);
        jpBotones.add(jbtnUsuarios);
        jpBotones.add(jbtnActividad);
        jpBotones.add(jbtnCronograma);
        jpBotones.add(jbtnCerrarSesion);
        jpBotones.setLayout(null);
        jpBotones.setBounds(0, 0, 882, 61);
        this.add(jpBotones);

        //Nombre
        jlbNombre = new JLabel("");
        jlbNombre.setBounds(0, 0, 500, 30);
        jlbNombre.setForeground(Color.BLACK);
        jlbNombre.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        this.add(jlbNombre);
        //Correo
        jlbCorreo = new JLabel("");
        jlbCorreo.setBounds(0, 0, 0, 0);
        jlbCorreo.setForeground(Color.BLACK);
        jlbCorreo.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        this.add(jlbCorreo);
        //Imagen
        jlbimage = new JLabel("");
        jlbimage.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jlbimage.setBounds(0, 0, 0, 0);
        this.add(jlbimage);

        JLabel fondoI = new JLabel();
        fondoI.setIcon(new ImageIcon(getClass().getResource("/Imagenes/wallpaper/walker-fondo.png")));
        fondoI.setBounds(0, 0, 700, 538);
        this.add(fondoI);

        jpInicio = new JPanel();
        jpInicio.setOpaque(false);
        jpInicio.setLayout(null);
        jpInicio.add(jlbNombre);
        jpInicio.add(jlbCorreo);
        jpInicio.add(jlbimage);
        jpInicio.add(fondoI);
        jpInicio.setBounds(50, 100, 882, 100);
        this.add(jpInicio);

        Container guardapaneles = getContentPane();
        guardapaneles.add(jpUsuarios);
        guardapaneles.add(jpActividad);
        guardapaneles.add(jpCronograma);
        
        jpMovedor = new JPanel();
        jpMovedor.setOpaque(false);
        jpMovedor.setLayout(null);
        jpMovedor.setBounds(1, 1, 882, 60);
        jpMovedor.addMouseListener(this);
        jpMovedor.addMouseMotionListener(this);
        this.add(jpMovedor);

        JLabel fondo = new JLabel();
        fondo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/wallpaper/walker-fondo.png")));
        fondo.setBounds(0, 0, 882, 600);
        this.add(fondo);

        this.repaint();
    }

    public static void main(String[] args) {
        Menu m = new Menu();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jbtnCerrarSesion) {
            int i = JOptionPane.showConfirmDialog(null, "¿Está seguro de cerrar sesión?", "Cerrar Sesión", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (JOptionPane.YES_OPTION == i) {
                this.setVisible(false);
                Login l = new Login();
                this.dispose();
            }
        }

    }

    @Override
    public void mouseReleased(MouseEvent arg0) {

    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        if (arg0.getSource() == jpMovedor) {
            x = arg0.getX();
            y = arg0.getY();
        }
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        if (arg0.getSource() == jbtnInicio) {
            jbtnInicio.setBackground(a);
        }

        if (arg0.getSource() == jbtnUsuarios) {
            jbtnUsuarios.setBackground(b);
        }

        if (arg0.getSource() == jbtnCerrarSesion) {
            jbtnCerrarSesion.setBackground(Color.DARK_GRAY);
        }

        if (arg0.getSource() == jbtnActividad) {
            jbtnActividad.setBackground(c);
        }

        if (arg0.getSource() == jbtnCronograma) {
            jbtnCronograma.setBackground(d);

        }

        if (arg0.getSource() == jlb_x1) {
            jlb_x1.setForeground(Color.WHITE);
        }

        if (arg0.getSource() == jlb_x2) {
            jlb_x2.setForeground(Color.WHITE);
        }
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        if (arg0.getSource() == jbtnInicio) {
            jbtnInicio.setBackground(new Color(24, 25, 26));
        }

        if (arg0.getSource() == jbtnUsuarios) {
            jbtnUsuarios.setBackground(new Color(24, 25, 26));
        }

        if (arg0.getSource() == jbtnCerrarSesion) {
            jbtnCerrarSesion.setBackground(new Color(24, 25, 26));
        }

        if (arg0.getSource() == jbtnActividad) {
            jbtnActividad.setBackground(new Color(24, 25, 26));
        }

        if (arg0.getSource() == jbtnCronograma) {
            jbtnCronograma.setBackground(new Color(24, 25, 26));
        }

        if (arg0.getSource() == jlb_x1) {
            jlb_x1.setForeground(new Color(255, 0, 0));
        }

        if (arg0.getSource() == jlb_x2) {
            jlb_x2.setForeground(new Color(255, 0, 0));
        }
    }

    @Override
    public void mouseClicked(MouseEvent ev) {
        if (ev.getSource() == jbtnInicio) {
            a = Color.GRAY;
            b = c = d = Color.DARK_GRAY;
            jbtnInicio.setBackground(a);
            jbtnUsuarios.setBackground(b);
            jbtnActividad.setBackground(c);
            jbtnCronograma.setBackground(d);
            jpInicio.setVisible(true);
            jpUsuarios.setVisible(false);
            jpActividad.setVisible(false);
            jpCronograma.setVisible(false);
        }

        if (ev.getSource() == jbtnUsuarios) {
            b = Color.GRAY;
            a = c = d = Color.DARK_GRAY;
            jbtnInicio.setBackground(a);
            jbtnUsuarios.setBackground(b);
            jbtnActividad.setBackground(c);
            jbtnCronograma.setBackground(d);
            jpInicio.setVisible(false);
            jpUsuarios.setVisible(true);
            jpActividad.setVisible(false);
            jpCronograma.setVisible(false);

            jpUsuarios.LimpiarCampos();
            jpUsuarios.pnDatos.setVisible(false);
            jpUsuarios.jpBotones.setVisible(true);
            jpUsuarios.jpError.setVisible(true);

        }

        if (ev.getSource() == jbtnActividad) {
            c = Color.GRAY;
            a = b = d = Color.DARK_GRAY;
            jbtnInicio.setBackground(a);
            jbtnUsuarios.setBackground(b);
            jbtnActividad.setBackground(c);
            jbtnCronograma.setBackground(d);
            jpInicio.setVisible(false);
            jpUsuarios.setVisible(false);
            jpActividad.setVisible(true);
            jpCronograma.setVisible(false);

            jpActividad.LimpiarCampos();
            jpActividad.pnDatos.setVisible(false);
            jpActividad.jpBotones.setVisible(true);
            jpActividad.jpError.setVisible(true);
        }

        if (ev.getSource() == jbtnCronograma) {
            d = Color.GRAY;
            a = b = c = Color.DARK_GRAY;
            jbtnInicio.setBackground(a);
            jbtnUsuarios.setBackground(b);
            jbtnActividad.setBackground(c);
            jbtnCronograma.setBackground(d);
            jpInicio.setVisible(false);
            jpUsuarios.setVisible(false);
            jpActividad.setVisible(false);
            jpCronograma.setVisible(true);

            jpCronograma.LimpiarCampos();
            jpCronograma.pnDatos.setVisible(false);
            jpCronograma.jpBotones.setVisible(true);
            jpCronograma.jpError.setVisible(true);
        }

        if (ev.getSource() == jlb_x1) {
            super.setState(JFrame.ICONIFIED);
        }

        if (ev.getSource() == jlb_x2) {
            int i = JOptionPane.showConfirmDialog(null, "¿Está seguro cerrar la aplicación?", "Cerrar Aplicación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (JOptionPane.YES_OPTION == i) {
                System.exit(0);
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        if (me.getSource() == jpMovedor) {
            Point point = MouseInfo.getPointerInfo().getLocation();
            this.setLocation(point.x - x, point.y - y);
        }
    }

    @Override
    public void mouseMoved(MouseEvent me) {

    }

}

package Vista;

import Entidades.UsuarioEnt;
import Negocio.UsuarioNg;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.table.DefaultTableModel;

public class Usuarios extends JPanel implements ActionListener, MouseListener, KeyListener {

    JLabel jlbCodigo_P;
    JLabel jlbNombre;
    JLabel jlbIdentificacion_R;
    JLabel jlbUsuario;
    JLabel jlbContraseña;
    JLabel jlbPerfil;
    JLabel jlbEstado;
    JLabel jlbValidar;

    JTextField jtxtCodigo_P;
    JTextField jtxtNombre;
    JTextField jtxtIdentificacion_R;
    JTextField jtxtUsuario;
    JTextField jtxtContraseña;

    JComboBox jcbPerfil;
    JComboBox jcbEstado;

    JPanel jpBotones;
    JPanel jpError;

    JButton jbtnListar;
    JButton jbtnGuardar;
    JButton jbtnBuscar;
    JButton jbtnActualizar;
    JButton jbtnEliminar;
    JButton jbtnLimpiar;

    private Object[][] Detalle_Usuario = new Object[0][0];//Creamos La matriz
    private Object[] Columnas_Usuario = {"Codigo Personal", "Nombre", "Identificacion Responsable", "Usuario", "Perfil", "Estado"};//Los nombres de las filas
    private DefaultTableModel dataModel = new DefaultTableModel(Detalle_Usuario, Columnas_Usuario);
    JScrollPane pnDatos;//Barra desplazamiento abajo
    JTable tbDatos;//datos de la tabla DATAMODEL nesecito cargarlo en un objeto pra poderlo visualisa

    public Usuarios() {
        super.setBounds(0, 61, 882, 538);  //(ancho,alto)
        super.setLayout(null);
        super.setOpaque(false);
        super.setVisible(false);

        tbDatos = new JTable(dataModel);
        tbDatos.setEnabled(false);
        tbDatos.setAutoResizeMode(5);
        tbDatos.setCellSelectionEnabled(true);
        tbDatos.setForeground(Color.BLACK);
        pnDatos = new JScrollPane(tbDatos);
        pnDatos.setBounds(0, 0, 882, 538);
        pnDatos.setVisible(false);
        this.add(pnDatos);
        llenarDatos();

        jlbCodigo_P = new JLabel("*Codigo Personal");
        jlbCodigo_P.setBounds(180, 65, 220, 25);
        jlbCodigo_P.setForeground(Color.BLACK);
        jlbCodigo_P.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.add(jlbCodigo_P);

        jtxtCodigo_P = new JTextField("");
        jtxtCodigo_P.setBounds(180, 90, 520, 30);
        jtxtCodigo_P.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jtxtCodigo_P.addKeyListener(this);
        this.add(jtxtCodigo_P);

        jlbNombre = new JLabel("*Nombre");
        jlbNombre.setBounds(180, 145, 120, 25);
        jlbNombre.setForeground(Color.BLACK);
        jlbNombre.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.add(jlbNombre);

        jtxtNombre = new JTextField("");
        jtxtNombre.setBounds(180, 170, 250, 30);
        jtxtNombre.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jtxtNombre.addKeyListener(this);
        this.add(jtxtNombre);

        jlbIdentificacion_R = new JLabel("*Identificacion Responsable");
        jlbIdentificacion_R.setBounds(450, 145, 240, 25);
        jlbIdentificacion_R.setForeground(Color.BLACK);
        jlbIdentificacion_R.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.add(jlbIdentificacion_R);

        jtxtIdentificacion_R = new JTextField("");
        jtxtIdentificacion_R.setBounds(450, 170, 250, 30);
        jtxtIdentificacion_R.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jtxtIdentificacion_R.addKeyListener(this);
        this.add(jtxtIdentificacion_R);

        jlbUsuario = new JLabel("*Nombre de Usuario");
        jlbUsuario.setBounds(180, 225, 170, 25);
        jlbUsuario.setForeground(Color.BLACK);
        jlbUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.add(jlbUsuario);

        jtxtUsuario = new JTextField("");
        jtxtUsuario.setBounds(180, 250, 250, 30);
        jtxtUsuario.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jtxtUsuario.addKeyListener(this);
        this.add(jtxtUsuario);

        jlbContraseña = new JLabel("*Contraseña");
        jlbContraseña.setBounds(450, 225, 150, 25);
        jlbContraseña.setForeground(Color.BLACK);
        jlbContraseña.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.add(jlbContraseña);

        jtxtContraseña = new JPasswordField();
        jtxtContraseña.setBounds(450, 250, 250, 30);
        jtxtContraseña.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jtxtContraseña.addKeyListener(this);
        this.add(jtxtContraseña);

        jlbPerfil = new JLabel("*Perfil");
        jlbPerfil.setBounds(180, 305, 150, 25);
        jlbPerfil.setForeground(Color.BLACK);
        jlbPerfil.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.add(jlbPerfil);

        jcbPerfil = new JComboBox();
        jcbPerfil.setBorder(null);
        jcbPerfil.setBackground(Color.WHITE);
        jcbPerfil.addItem("Pastor");
        jcbPerfil.addItem("Miembro");
        jcbPerfil.setBounds(180, 330, 250, 30);
        this.add(jcbPerfil);

        jlbEstado = new JLabel("*Estado");
        jlbEstado.setBounds(450, 305, 150, 25);
        jlbEstado.setForeground(Color.BLACK);
        jlbEstado.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.add(jlbEstado);

        jcbEstado = new JComboBox();
        jcbEstado.setBorder(null);
        jcbEstado.setBackground(Color.WHITE);
        jcbEstado.addItem("Activo");
        jcbEstado.addItem("Inactivo");
        jcbEstado.setBounds(450, 330, 250, 30);
        this.add(jcbEstado);

        //Botones
        jbtnListar = new JButton("Listar");
        jbtnListar.setBounds(0, 0, 175, 60);
        jbtnListar.setBorder(null);
        jbtnListar.setBackground(Color.BLACK);
        jbtnListar.setForeground(Color.WHITE);
        jbtnListar.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        jbtnListar.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnListar.addMouseListener(this);
        jbtnListar.addActionListener(this);
        jbtnListar.setFocusPainted(false);
        this.add(jbtnListar);

        jbtnGuardar = new JButton("Guardar");
        jbtnGuardar.setBounds(175, 0, 175, 60);
        jbtnGuardar.setBorder(null);
        jbtnGuardar.setBackground(Color.BLACK);
        jbtnGuardar.setForeground(Color.WHITE);
        jbtnGuardar.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        jbtnGuardar.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnGuardar.addMouseListener(this);
        jbtnGuardar.addActionListener(this);
        jbtnGuardar.setFocusPainted(false);
        this.add(jbtnGuardar);

        jbtnBuscar = new JButton("Buscar");
        jbtnBuscar.setBounds(350, 0, 175, 60);
        jbtnBuscar.setBorder(null);
        jbtnBuscar.setBackground(Color.BLACK);
        jbtnBuscar.setForeground(Color.WHITE);
        jbtnBuscar.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        jbtnBuscar.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnBuscar.addMouseListener(this);
        jbtnBuscar.addActionListener(this);
        jbtnBuscar.setFocusPainted(false);
        this.add(jbtnBuscar);

        jbtnActualizar = new JButton("Actualizar");
        jbtnActualizar.setBounds(175, 0, 175, 60);
        jbtnActualizar.setBorder(null);
        jbtnActualizar.setBackground(Color.BLACK);
        jbtnActualizar.setForeground(Color.WHITE);
        jbtnActualizar.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        jbtnActualizar.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnActualizar.addMouseListener(this);
        jbtnActualizar.setVisible(false);
        jbtnActualizar.addActionListener(this);
        jbtnActualizar.setFocusPainted(false);
        this.add(jbtnActualizar);

        jbtnEliminar = new JButton("Eliminar");
        jbtnEliminar.setBounds(350, 0, 175, 60);
        jbtnEliminar.setBorder(null);
        jbtnEliminar.setBackground(Color.BLACK);
        jbtnEliminar.setForeground(Color.WHITE);
        jbtnEliminar.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        jbtnEliminar.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnEliminar.addMouseListener(this);
        jbtnEliminar.setVisible(false);
        jbtnEliminar.addActionListener(this);
        jbtnEliminar.setFocusPainted(false);
        this.add(jbtnEliminar);

        jbtnLimpiar = new JButton("Limpiar");
        jbtnLimpiar.setBounds(525, 0, 175, 60);
        jbtnLimpiar.setBorder(null);
        jbtnLimpiar.setBackground(Color.BLACK);
        jbtnLimpiar.setForeground(Color.WHITE);
        jbtnLimpiar.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        jbtnLimpiar.setCursor(new Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnLimpiar.addMouseListener(this);
        jbtnLimpiar.addActionListener(this);
        jbtnLimpiar.setFocusPainted(false);
        this.add(jbtnLimpiar);
        //Fin Botones

        jpBotones = new JPanel();
        jpBotones.setBackground(new Color(0, 123, 183));
        jpBotones.add(jbtnListar);
        jpBotones.add(jbtnGuardar);
        jpBotones.add(jbtnBuscar);
        jpBotones.add(jbtnActualizar);
        jpBotones.add(jbtnEliminar);
        jpBotones.add(jbtnLimpiar);
        jpBotones.setLayout(null);
        jpBotones.setBounds(90, 478, 700, 60);
        this.add(jpBotones);

        jlbValidar = new JLabel("Los campos con (*) son obligatorios");
        jlbValidar.setForeground(Color.WHITE);
        jlbValidar.setBounds(80, 8, 400, 27);
        jlbValidar.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        this.add(jlbValidar);

        jpError = new JPanel();
        jpError.add(jlbValidar);
        jpError.setLayout(null);
        jpError.setBackground(Color.BLACK);
        jpError.setBounds(0, 0, 882, 45);
        this.add(jpError);

        this.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        UsuarioEnt usuarioE = new UsuarioEnt();
        UsuarioNg usuarioN = new UsuarioNg();
        if (ae.getSource() == jbtnListar) {
            LimpiarCampos();
            pnDatos.setVisible(true);
            jpBotones.setVisible(false);
            jpError.setVisible(false);
            vaciar();
            llenarDatos();
        }
        if (ae.getSource() == jbtnGuardar) {
            if (jtxtCodigo_P.getText().trim().length() == 0 || jtxtNombre.getText().trim().length() == 0 || jtxtIdentificacion_R.getText().trim().length() == 0 || jtxtUsuario.getText().trim().length() == 0 || jtxtContraseña.getText().trim().length() == 0) {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(this, "Ingrese los campos en rojo", "SOGA", JOptionPane.ERROR_MESSAGE);
                if (jtxtCodigo_P.getText().trim().length() == 0) {
                    jtxtCodigo_P.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                } else {
                    jtxtCodigo_P.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                }

                if (jtxtNombre.getText().trim().length() == 0) {
                    jtxtNombre.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                } else {
                    jtxtNombre.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                }

                if (jtxtIdentificacion_R.getText().trim().length() == 0) {
                    jtxtIdentificacion_R.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                } else {
                    jtxtIdentificacion_R.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                }

                if (jtxtNombre.getText().trim().length() == 0) {
                    jtxtNombre.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                } else {
                    jtxtNombre.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                }

                if (jtxtUsuario.getText().trim().length() == 0) {
                    jtxtUsuario.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                } else {
                    jtxtUsuario.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                }

                if (jtxtContraseña.getText().trim().length() == 0) {
                    jtxtContraseña.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                } else {
                    jtxtContraseña.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                }

                return;
            }
            if (jtxtContraseña.getText().length() <= 6) {
                Toolkit.getDefaultToolkit().beep();
                jtxtContraseña.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                return;
            } else {
                jtxtContraseña.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
            }

            int option = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea guardar el usuario?", "SOGA", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (option == JOptionPane.YES_OPTION) {
                if (jtxtCodigo_P.getText().trim().length() > 0) {
                    usuarioE.setCodigo_P(jtxtCodigo_P.getText());
                }

                if (jtxtNombre.getText().trim().length() > 0) {
                    usuarioE.setNombre(jtxtNombre.getText());
                }

                if (jtxtIdentificacion_R.getText().trim().length() > 0) {
                    usuarioE.setIdentificacion_R(jtxtIdentificacion_R.getText());
                }

                if (jtxtUsuario.getText().trim().length() > 0) {
                    usuarioE.setUsuario(jtxtUsuario.getText());
                }

                if (jtxtContraseña.getText().trim().length() > 0) {
                    usuarioE.setContraseña(jtxtContraseña.getText());
                }
                usuarioE.setPerfil((String) jcbPerfil.getSelectedItem());
                usuarioE.setEstado((String) jcbEstado.getSelectedItem());

                boolean guarda = usuarioN.guardarUsuario(usuarioE);
                if (guarda) {
                    VaciarCampos();
                    LimpiarCampos();
                    JOptionPane.showMessageDialog(this, "Se ha guardado el usuario", "SOGA", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(this, "El usuario ya estaba guardado", "SOGA", JOptionPane.ERROR_MESSAGE);

                }
            }
        }

        if (ae.getSource() == jbtnBuscar) {
            LimpiarCampos();
            String Codigo_P;
            Codigo_P = jtxtCodigo_P.getText();
            if (Codigo_P.trim().length() != 0) {
                usuarioE = usuarioN.buscarUsuarioCodigo_P(Codigo_P);
                if (usuarioE != null) {
                    jtxtCodigo_P.setText(usuarioE.getCodigo_P());
                    jtxtNombre.setText(usuarioE.getNombre());
                    jtxtIdentificacion_R.setText(usuarioE.getIdentificacion_R());
                    jtxtUsuario.setText(usuarioE.getUsuario());
                    jtxtContraseña.setText(usuarioE.getContraseña());
                    jcbPerfil.setSelectedItem(usuarioE.getPerfil());
                    jcbEstado.setSelectedItem(usuarioE.getEstado());
                    jtxtCodigo_P.setFocusable(false);
                    jbtnGuardar.setVisible(false);
                    jbtnBuscar.setVisible(false);
                    jbtnActualizar.setVisible(true);
                    jbtnEliminar.setVisible(true);
                    if (jbtnActualizar.getBounds().x == 0) {
                        jbtnListar.setBounds(0, 0, 350, 60);
                        jbtnLimpiar.setBounds(350, 0, 350, 60);
                    }
                } else {
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(this, "El usuario no se ha encontrado", "SOGA", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(this, "Ingrese el Codigo", "SOGA", JOptionPane.ERROR_MESSAGE);
                jtxtCodigo_P.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            }
        }

        if (ae.getSource() == jbtnActualizar) {
            if (jtxtCodigo_P.getText().trim().length() == 0 || jtxtNombre.getText().trim().length() == 0 || jtxtIdentificacion_R.getText().trim().length() == 0 || jtxtUsuario.getText().trim().length() == 0 || jtxtContraseña.getText().trim().length() == 0) {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(this, "Ingrese los campos en rojo", "SOGA", JOptionPane.ERROR_MESSAGE);

                if (jtxtCodigo_P.getText().trim().length() == 0) {
                    jtxtCodigo_P.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                } else {
                    jtxtCodigo_P.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                }

                if (jtxtNombre.getText().trim().length() == 0) {
                    jtxtNombre.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                } else {
                    jtxtNombre.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                }

                if (jtxtIdentificacion_R.getText().trim().length() == 0) {
                    jtxtIdentificacion_R.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                } else {
                    jtxtIdentificacion_R.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                }

                if (jtxtNombre.getText().trim().length() == 0) {
                    jtxtNombre.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                } else {
                    jtxtNombre.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                }

                if (jtxtUsuario.getText().trim().length() == 0) {
                    jtxtUsuario.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                } else {
                    jtxtUsuario.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                }

                if (jtxtContraseña.getText().trim().length() == 0) {
                    jtxtContraseña.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                } else {
                    jtxtContraseña.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                }
                return;
            }

            if (jtxtContraseña.getText().length() <= 6) {
                Toolkit.getDefaultToolkit().beep();
                jtxtContraseña.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                return;
            } else {
                jtxtContraseña.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
            }
            int option = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea actualizar el usuario?", "SOGA", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (option == JOptionPane.YES_OPTION) {
                if (jtxtCodigo_P.getText().trim().length() > 0) {
                    usuarioE.setCodigo_P(jtxtCodigo_P.getText());
                }

                if (jtxtNombre.getText().trim().length() > 0) {
                    usuarioE.setNombre(jtxtNombre.getText());
                }

                if (jtxtIdentificacion_R.getText().trim().length() > 0) {
                    usuarioE.setIdentificacion_R(jtxtIdentificacion_R.getText());
                }

                if (jtxtUsuario.getText().trim().length() > 0) {
                    usuarioE.setUsuario(jtxtUsuario.getText());
                }

                if (jtxtContraseña.getText().trim().length() > 0) {
                    usuarioE.setContraseña(jtxtContraseña.getText());
                }

                usuarioE.setPerfil((String) jcbPerfil.getSelectedItem());
                usuarioE.setEstado((String) jcbEstado.getSelectedItem());

                boolean respuestau = usuarioN.modificarUsuario(usuarioE);
                if (respuestau) {
                    LimpiarCampos();
                    JOptionPane.showMessageDialog(this, "Se ha actualizado el usuario", "SOGA", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }

        if (ae.getSource() == jbtnEliminar) {

            int option = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea eliminar el usuario?", "SOGA", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (option == JOptionPane.YES_OPTION) {
                String codigo = jtxtCodigo_P.getText();
                boolean respuestap;
                if (codigo != null) {
                    respuestap = usuarioN.eliminarUsuario(codigo);
                    if (respuestap) {
                        jtxtCodigo_P.setFocusable(true);
                        jbtnGuardar.setVisible(true);
                        jbtnBuscar.setVisible(true);
                        jbtnActualizar.setVisible(false);
                        jbtnEliminar.setVisible(false);
                        LimpiarCampos();
                        VaciarCampos();
                        JOptionPane.showMessageDialog(this, "El Usuario fue eliminado", "SOGA", JOptionPane.INFORMATION_MESSAGE);
                        if (jbtnActualizar.getBounds().x == 0) {
                            jbtnListar.setBounds(0, 0, 175, 60);
                            jbtnLimpiar.setBounds(525, 0, 175, 60);
                        }
                    }
                }
            }
        }

        if (ae.getSource() == jbtnLimpiar) {
            LimpiarCampos();
            VaciarCampos();
            jtxtCodigo_P.setFocusable(true);
            jbtnGuardar.setVisible(true);
            jbtnBuscar.setVisible(true);
            jbtnActualizar.setVisible(false);
            jbtnEliminar.setVisible(false);
            if (jbtnActualizar.getBounds().x == 0) {
                jbtnListar.setBounds(0, 0, 175, 60);
                jbtnLimpiar.setBounds(525, 0, 175, 60);
            }
        }

    }

    public void setDataModel(DefaultTableModel dataModel) {
        this.dataModel = dataModel;
    }

    public DefaultTableModel getDataModel() {
        return dataModel;
    }

    public void llenarDatos() {
        Negocio.UsuarioNg UsuarioN = new Negocio.UsuarioNg();
        setDataModel(UsuarioN.cargarUsuario(getDataModel()));

    }

    public void vaciar() {
        int i = getDataModel().getRowCount();
        while (i > 0) {
            getDataModel().removeRow(0);
            i--;
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {

    }

    @Override
    public void mousePressed(MouseEvent me) {

    }

    @Override
    public void mouseReleased(MouseEvent me) {

    }

    @Override
    public void mouseEntered(MouseEvent me) {
        if (me.getSource() == jbtnListar) {
            jbtnListar.setBackground(Color.DARK_GRAY);
        }
        if (me.getSource() == jbtnGuardar) {
            jbtnGuardar.setBackground(Color.DARK_GRAY);
        }
        if (me.getSource() == jbtnBuscar) {
            jbtnBuscar.setBackground(Color.DARK_GRAY);
        }
        if (me.getSource() == jbtnActualizar) {
            jbtnActualizar.setBackground(Color.DARK_GRAY);
        }
        if (me.getSource() == jbtnEliminar) {
            jbtnEliminar.setBackground(Color.DARK_GRAY);
        }
        if (me.getSource() == jbtnLimpiar) {
            jbtnLimpiar.setBackground(Color.DARK_GRAY);
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
        if (me.getSource() == jbtnListar) {
            jbtnListar.setBackground(Color.BLACK);
        }
        if (me.getSource() == jbtnGuardar) {
            jbtnGuardar.setBackground(Color.BLACK);
        }
        if (me.getSource() == jbtnBuscar) {
            jbtnBuscar.setBackground(Color.BLACK);
        }
        if (me.getSource() == jbtnActualizar) {
            jbtnActualizar.setBackground(Color.BLACK);
        }
        if (me.getSource() == jbtnEliminar) {
            jbtnEliminar.setBackground(Color.BLACK);
        }
        if (me.getSource() == jbtnLimpiar) {
            jbtnLimpiar.setBackground(Color.BLACK);
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {

        if (ke.getSource() == jtxtContraseña) {
            if (jtxtContraseña.getText().length() <= 6) {
                jtxtContraseña.setBorder(BorderFactory.createLineBorder(Color.red, 1));
            } else {
                jtxtContraseña.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
            }
        }

    }

    @Override
    public void keyPressed(KeyEvent ke) {

        if (ke.getSource() == jtxtContraseña) {
            if (jtxtContraseña.getText().trim().length() < 0) {
                jtxtContraseña.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            } else {
                jtxtContraseña.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {

    }

    public void LimpiarCampos() {
        jtxtNombre.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jtxtCodigo_P.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jtxtIdentificacion_R.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jtxtUsuario.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jtxtContraseña.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
    }

    public void VaciarCampos() {
        jtxtCodigo_P.setText("");
        jtxtNombre.setText("");
        jtxtIdentificacion_R.setText("");
        jtxtUsuario.setText("");
        jtxtContraseña.setText("");
        jcbPerfil.setSelectedItem("Pastor");
        jcbEstado.setSelectedItem("Activo");
    }

}

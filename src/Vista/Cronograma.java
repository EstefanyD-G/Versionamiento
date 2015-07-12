package Vista;

import Entidades.CronogramaEnt;
import Negocio.CronogramaNg;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.table.DefaultTableModel;

public class Cronograma extends JPanel implements ActionListener, MouseListener, KeyListener {

    JLabel jlbCodigo_C;
    JLabel jlbFecha_Inicio;
    JLabel jlbFecha_Finalizacion;
    JLabel jlbValidar;

    JTextField jtxtCodigo_C;
    JTextField jtxtFecha_Inicio;
    JTextField jtxtFecha_Finalizacion;

    JPanel jpBotones;
    JPanel jpError;

    JButton jbtnListar;
    JButton jbtnGuardar;
    JButton jbtnBuscar;
    JButton jbtnActualizar;
    JButton jbtnEliminar;
    JButton jbtnLimpiar;

    private Object[][] Detalle_Cronograma = new Object[0][0];//Creamos La matriz
    private Object[] Columnas_Cronograma = {"Codigo Cronograma", "Fecha_Inicio", "Fecha_Finalizacion"};//Los nombres de las filas
    private DefaultTableModel dataModel = new DefaultTableModel(Detalle_Cronograma, Columnas_Cronograma);
    JScrollPane pnDatos;//Barra desplazamiento abajo
    JTable tbDatos;

    public Cronograma() {
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

        jlbCodigo_C = new JLabel("*Codigo Cronograma");
        jlbCodigo_C.setBounds(180, 65, 220, 25);
        jlbCodigo_C.setForeground(Color.BLACK);
        jlbCodigo_C.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.add(jlbCodigo_C);

        jtxtCodigo_C = new JTextField("");
        jtxtCodigo_C.setBounds(180, 90, 520, 30);
        jtxtCodigo_C.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jtxtCodigo_C.addKeyListener(this);
        this.add(jtxtCodigo_C);

        jlbFecha_Inicio = new JLabel("*Fecha Inicio");
        jlbFecha_Inicio.setBounds(180, 145, 120, 25);
        jlbFecha_Inicio.setForeground(Color.BLACK);
        jlbFecha_Inicio.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.add(jlbFecha_Inicio);

        jtxtFecha_Inicio = new JTextField("");
        jtxtFecha_Inicio.setBounds(180, 170, 250, 30);
        jtxtFecha_Inicio.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jtxtFecha_Inicio.addKeyListener(this);
        this.add(jtxtFecha_Inicio);

        jlbFecha_Finalizacion = new JLabel("*Fecha Finalizacion");
        jlbFecha_Finalizacion.setBounds(450, 145, 240, 25);
        jlbFecha_Finalizacion.setForeground(Color.BLACK);
        jlbFecha_Finalizacion.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        this.add(jlbFecha_Finalizacion);

        jtxtFecha_Finalizacion = new JTextField("");
        jtxtFecha_Finalizacion.setBounds(450, 170, 250, 30);
        jtxtFecha_Finalizacion.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jtxtFecha_Finalizacion.addKeyListener(this);
        this.add(jtxtFecha_Finalizacion);

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
        CronogramaEnt CronogramaE = new CronogramaEnt();
        CronogramaNg CronogramaN = new CronogramaNg();
        if (ae.getSource() == jbtnListar) {
            LimpiarCampos();
            pnDatos.setVisible(true);
            jpBotones.setVisible(false);
            jpError.setVisible(false);
            vaciar();
            llenarDatos();
        }
        if (ae.getSource() == jbtnGuardar) {
            if (jtxtCodigo_C.getText().trim().length() == 0 || jtxtFecha_Inicio.getText().trim().length() == 0 || jtxtFecha_Finalizacion.getText().trim().length() == 0) {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(this, "Ingrese los campos en rojo", "SOGA", JOptionPane.ERROR_MESSAGE);
                if (jtxtCodigo_C.getText().trim().length() == 0) {
                    jtxtCodigo_C.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                } else {
                    jtxtCodigo_C.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                }

                if (jtxtFecha_Inicio.getText().trim().length() == 0) {
                    jtxtFecha_Inicio.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                } else {
                    jtxtFecha_Inicio.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                }

                if (jtxtFecha_Finalizacion.getText().trim().length() == 0) {
                    jtxtFecha_Finalizacion.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                } else {
                    jtxtFecha_Finalizacion.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                }

                return;
            }

            int option = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea guardar el cronograma?", "SOGA", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (option == JOptionPane.YES_OPTION) {
                if (jtxtCodigo_C.getText().trim().length() > 0) {
                    CronogramaE.setCodigo_C(jtxtCodigo_C.getText());
                }

                if (jtxtFecha_Inicio.getText().trim().length() > 0) {
                    CronogramaE.setFecha_Inicio(jtxtFecha_Inicio.getText());
                }

                if (jtxtFecha_Finalizacion.getText().trim().length() > 0) {
                    CronogramaE.setFecha_Finalizacion(jtxtFecha_Finalizacion.getText());
                }

                boolean guarda = CronogramaN.guardarCronograma(CronogramaE);
                if (guarda) {
                    VaciarCampos();
                    LimpiarCampos();
                    JOptionPane.showMessageDialog(this, "Se ha guardado el cronograma", "SOGA", JOptionPane.INFORMATION_MESSAGE);

                } else {
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(this, "El cronograma ya estaba guardado", "SOGA", JOptionPane.ERROR_MESSAGE);

                }
            }
        }

        if (ae.getSource() == jbtnBuscar) {
            LimpiarCampos();
            String Codigo_C;
            Codigo_C = jtxtCodigo_C.getText();
            if (Codigo_C.trim().length() != 0) {
                CronogramaE = CronogramaN.buscarCronogramaCodigo_C(Codigo_C);
                if (CronogramaE != null) {
                    jtxtCodigo_C.setText(CronogramaE.getCodigo_C());
                    jtxtFecha_Inicio.setText(CronogramaE.getFecha_Inicio());
                    jtxtFecha_Finalizacion.setText(CronogramaE.getFecha_Finalizacion());
                    jtxtCodigo_C.setFocusable(false);
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
                    JOptionPane.showMessageDialog(this, "El cronograma no se ha encontrado", "SOGA", JOptionPane.ERROR_MESSAGE);

                }
            } else {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(this, "Ingrese el Codigo Cronograma", "SOGA", JOptionPane.ERROR_MESSAGE);
                jtxtCodigo_C.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            }
        }

        if (ae.getSource() == jbtnActualizar) {
            if (jtxtCodigo_C.getText().trim().length() == 0 || jtxtFecha_Inicio.getText().trim().length() == 0 || jtxtFecha_Finalizacion.getText().trim().length() == 0) {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(this, "Ingrese los campos en rojo", "SOGA", JOptionPane.ERROR_MESSAGE);

                if (jtxtCodigo_C.getText().trim().length() == 0) {
                    jtxtCodigo_C.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                } else {
                    jtxtCodigo_C.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                }

                if (jtxtFecha_Inicio.getText().trim().length() == 0) {
                    jtxtFecha_Inicio.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                } else {
                    jtxtFecha_Inicio.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                }

                if (jtxtFecha_Finalizacion.getText().trim().length() == 0) {
                    jtxtFecha_Finalizacion.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                } else {
                    jtxtFecha_Finalizacion.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                }

                return;
            }

            int option = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea actualizar el cronograma?", "SOGA", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (option == JOptionPane.YES_OPTION) {
                if (jtxtCodigo_C.getText().trim().length() > 0) {
                    CronogramaE.setCodigo_C(jtxtCodigo_C.getText());
                }

                if (jtxtFecha_Inicio.getText().trim().length() > 0) {
                    CronogramaE.setFecha_Inicio(jtxtFecha_Inicio.getText());
                }

                if (jtxtFecha_Finalizacion.getText().trim().length() > 0) {
                    CronogramaE.setFecha_Finalizacion(jtxtFecha_Finalizacion.getText());
                }

                boolean respuestau = CronogramaN.modificarCronograma(CronogramaE);
                if (respuestau) {
                    LimpiarCampos();
                    JOptionPane.showMessageDialog(this, "Se ha actualizado el cronograma", "SOGA", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }

        if (ae.getSource() == jbtnEliminar) {

            int option = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea eliminar el cronograma?", "SOGA", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (option == JOptionPane.YES_OPTION) {
                String codigo = jtxtCodigo_C.getText();
                boolean respuestap;
                if (codigo != null) {
                    respuestap = CronogramaN.eliminarCronograma(codigo);
                    if (respuestap) {
                        jtxtCodigo_C.setFocusable(true);
                        jbtnGuardar.setVisible(true);
                        jbtnBuscar.setVisible(true);
                        jbtnActualizar.setVisible(false);
                        jbtnEliminar.setVisible(false);
                        LimpiarCampos();
                        VaciarCampos();
                        JOptionPane.showMessageDialog(this, "El cronograma fue eliminado", "SOGA", JOptionPane.INFORMATION_MESSAGE);

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
            jtxtCodigo_C.setFocusable(true);
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
        Negocio.CronogramaNg CronogramaN = new Negocio.CronogramaNg();
        setDataModel(CronogramaN.cargarCronograma(getDataModel()));

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
        
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if (ke.getSource() == jtxtCodigo_C) {
            if (jtxtCodigo_C.getText().trim().length() < 0) {
                jtxtCodigo_C.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            } else {
                jtxtCodigo_C.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
            }
        }
        if (ke.getSource() == jtxtFecha_Inicio) {
            if (jtxtFecha_Inicio.getText().trim().length() < 0) {
                jtxtFecha_Inicio.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            } else {
                jtxtFecha_Inicio.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
            }
        }
        if (ke.getSource() == jtxtFecha_Finalizacion) {
            if (jtxtFecha_Finalizacion.getText().trim().length() < 0) {
                jtxtFecha_Finalizacion.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            } else {
                jtxtFecha_Finalizacion.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {

    }

    public void LimpiarCampos() {
        jtxtCodigo_C.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jtxtFecha_Inicio.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        jtxtFecha_Finalizacion.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
    }

    public void VaciarCampos() {
        jtxtCodigo_C.setText("");
        jtxtFecha_Inicio.setText("");
        jtxtFecha_Finalizacion.setText("");

    }

}

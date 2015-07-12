 package Negocio;

import Entidades.UsuarioEnt;
import Persistencia.UsuarioDts;
import javax.swing.table.DefaultTableModel;

public class UsuarioNg {

    UsuarioDts UsuarioD = new UsuarioDts();
    UsuarioEnt UsuarioE = null;

    public String verificarUsuario(String Usuario, String Contraseña) {
        UsuarioEnt UsuarioE = UsuarioD.buscarUsuario(Usuario);

        if (UsuarioE != null) {
            //si encuentra el usuario

            if (Contraseña.equals(UsuarioE.getContraseña())) {
                if (UsuarioE.getEstado() == "Inactivo") {
                    return "Inactivo";
                }
                if (UsuarioE.getPerfil() == "Pastor") {
                    return "Pastor";
                } else if (UsuarioE.getPerfil() == "Miembro") {
                    return "Miembro";
                } else {
                    return "Cliente";
                }
            } else {
                //Lo encuentra pero la clave esta errada
                return "noes";
            }
        } else {
            //no encuentre usuario
            return "noes";
        }

    }

    public boolean guardarUsuario(UsuarioEnt m) {
        boolean resp = false;
        UsuarioE = UsuarioD.buscarUsuarioCodigo_P(m.getCodigo_P());
        if (UsuarioE == null) {
            resp = UsuarioD.guardarUsuario(m);
        }
        return resp;
    }

    public UsuarioEnt buscarUsuarioCodigo_P(String Codigo_P) {
        return UsuarioD.buscarUsuarioCodigo_P(Codigo_P);
    }

    public UsuarioEnt buscarUsuario(String Usuario) {
        return UsuarioD.buscarUsuario(Usuario);
    }

    public boolean modificarUsuario(UsuarioEnt Codigo_P) {
        return UsuarioD.modificarUsuario(Codigo_P);
    }

    public boolean modificarPerfil(UsuarioEnt Codigo_P) {
        return UsuarioD.modificarPerfil(Codigo_P);
    }

    public boolean eliminarUsuario(String Codigo_P) {
        return UsuarioD.eliminarUsuario(Codigo_P);
    }

    public DefaultTableModel cargarUsuario(DefaultTableModel model) {
        String[][] result;

        result = UsuarioD.cargarUsuario();
        for (int i = 0; i < UsuarioDts.cont; i++) {
            Object nuevo[] = {result[i][0], result[i][1], result[i][2], result[i][3], result[i][4], result[i][5]};
            model.addRow(nuevo);
        }
        return model;
    }

}

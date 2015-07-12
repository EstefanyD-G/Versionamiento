package Persistencia;

import Entidades.UsuarioEnt;

public class UsuarioDts {

    public static UsuarioEnt inicio, fin, nodo, nodo1, nodo2, nodoI;
    public static int cont = 0;

    static {
        inicio = new UsuarioEnt(null, null, null, null, null, null, null);
        nodo = inicio.Liga = new UsuarioEnt("0000001", "estefany", "98030925130", "estefany", "estefany123", "Pastor", "Activo");
        nodo1 = nodo.Liga = new UsuarioEnt("0000002", "juan pablo tolosita", "97020655963", "juan", "juan123", "Pastor", "Inactivo");
        nodo2 = nodo1.Liga = new UsuarioEnt("0000003", "laura", "9789564556", "laura", "laura123", "Miembro", "Inactivo");
        fin = nodo2.Liga = new UsuarioEnt("0000004", "alejandro", "97081322221", "alejo", "alejo123", "Miembro", "Activo");
        fin.Liga = null;
    }

    public UsuarioEnt buscarUsuario(String cr) {
        UsuarioEnt respuesta = null;
        UsuarioEnt aux = inicio.Liga;
        while (aux != fin && !cr.equals(aux.Usuario)) {
            aux = aux.Liga;
        }
        if (cr.equals(aux.Usuario)) {
            respuesta = new UsuarioEnt();
            respuesta.setCodigo_P(aux.Codigo_P);
            respuesta.setNombre(aux.Nombre);
            respuesta.setIdentificacion_R(aux.Identificacion_R);
            respuesta.setUsuario(aux.Usuario);
            respuesta.setContraseña(aux.Contraseña);
            respuesta.setPerfil(aux.Perfil);
            respuesta.setEstado(aux.Estado);
            return respuesta;
        }
        return respuesta;
    }

    public UsuarioEnt buscarUsuarioCodigo_P(String cr) {
        UsuarioEnt respuesta = null;
        UsuarioEnt aux = inicio.Liga;
        while (aux != fin && !cr.equals(aux.Codigo_P)) {
            aux = aux.Liga;
        }
        if (cr.equals(aux.Codigo_P)) {
            respuesta = new UsuarioEnt();
            respuesta.setCodigo_P(aux.Codigo_P);
            respuesta.setNombre(aux.Nombre);
            respuesta.setIdentificacion_R(aux.Identificacion_R);
            respuesta.setUsuario(aux.Usuario);
            respuesta.setContraseña(aux.Contraseña);
            respuesta.setPerfil(aux.Perfil);
            respuesta.setEstado(aux.Estado);
            return respuesta;
        }
        return respuesta;
    }

    public boolean guardarUsuario(UsuarioEnt nueva) {
        nodoI = new UsuarioEnt(nueva.Codigo_P, nueva.Nombre, nueva.Identificacion_R, nueva.Usuario, nueva.Contraseña, nueva.Perfil, nueva.Estado);
        nodoI.Liga = null;
        fin.Liga = nodoI;
        fin = nodoI;
        return true;
    }

    public boolean modificarPerfil(UsuarioEnt usuarios) {
        UsuarioEnt aux;
        aux = inicio.Liga;
        while (aux != fin && !aux.Codigo_P.equals(usuarios.getCodigo_P())) {
            aux = aux.Liga;
        }
        aux.Nombre = usuarios.getNombre();
        aux.Identificacion_R = usuarios.getIdentificacion_R();
        aux.Usuario = usuarios.getUsuario();
        aux.Contraseña = usuarios.getContraseña();
        return true;
    }

    public boolean modificarUsuario(UsuarioEnt usuarios) {
        UsuarioEnt aux;
        aux = inicio.Liga;
        while (aux != fin && !aux.Codigo_P.equals(usuarios.getCodigo_P())) {
            aux = aux.Liga;
        }
        aux.Nombre = usuarios.getNombre();
        aux.Identificacion_R = usuarios.getIdentificacion_R();
        aux.Usuario = usuarios.getUsuario();
        aux.Contraseña = usuarios.getContraseña();
        aux.Perfil = usuarios.getPerfil();
        aux.Estado = usuarios.getEstado();
        return true;
    }

    public boolean eliminarUsuario(String usuario) {
        UsuarioEnt aux, con;
        aux = inicio.Liga;
        con = inicio;
        while (aux != fin && !usuario.equals(aux.Codigo_P)) {
            con = aux;
            aux = aux.Liga;
        }
        aux.Nombre = null;
        aux.Identificacion_R = null;
        aux.Usuario = null;
        aux.Contraseña = null;
        aux.Perfil = null;
        aux.Estado = null;
        if (aux.Liga == null && inicio.Liga == aux) {
            inicio.Liga = null;
        } else {
            con.Liga = aux.Liga;
            if (aux.Liga == null) {
                fin = con;
            }
        }

        return true;
    }

    public String[][] cargarUsuario() {
        UsuarioEnt aux;
        cont = 0;
        aux = inicio.Liga;
        while (aux != fin.Liga) {
            cont++;
            aux = aux.Liga;
        }
        String[][] usuarioDatos = new String[cont][8];
        aux = inicio.Liga;
        for (int i = 0; i < cont; i++) {
            usuarioDatos[i][0] = aux.Codigo_P;
            usuarioDatos[i][1] = aux.Nombre;
            usuarioDatos[i][2] = aux.Identificacion_R;
            usuarioDatos[i][3] = aux.Usuario;
            usuarioDatos[i][4] = aux.Perfil;
            usuarioDatos[i][5] = aux.Estado;
            aux = aux.Liga;
        }
        return usuarioDatos;
    }
}

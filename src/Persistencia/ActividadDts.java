package Persistencia;

import Entidades.ActividadEnt;

public class ActividadDts {

    public static ActividadEnt inicio, fin, nodo, nodo1, nodo2, nodoI;
    public static int cont = 0;

    static {
        inicio = new ActividadEnt(null, null, null);
        nodo = inicio.Liga = new ActividadEnt("111", "culto", "2:00");
        nodo1 = nodo.Liga = new ActividadEnt("112", "ayuno", "6:00");
        nodo2 = nodo1.Liga = new ActividadEnt("113", "ayuno", "6:00");
        fin = nodo2.Liga = new ActividadEnt("114", "vigilia", "5:00");
        fin.Liga = null;
    }

    public ActividadEnt buscarActividadCodigo_A(String cr) {
        ActividadEnt respuesta = null;
        ActividadEnt aux = inicio.Liga;
        while (aux != fin && !cr.equals(aux.Codigo_A)) {
            aux = aux.Liga;
        }
        if (cr.equals(aux.Codigo_A)) {
            respuesta = new ActividadEnt();
            respuesta.setCodigo_A(aux.Codigo_A);
            respuesta.setDescripcion(aux.Descripcion);
            respuesta.setDuracion(aux.Duracion);
            return respuesta;
        }
        return respuesta;
    }

    public boolean guardarActividad(ActividadEnt nueva) {
        nodoI = new ActividadEnt(nueva.Codigo_A, nueva.Descripcion, nueva.Duracion);
        nodoI.Liga = null;
        fin.Liga = nodoI;
        fin = nodoI;
        return true;

    }

    public boolean modificarActividad(ActividadEnt Codigo_A) {
        ActividadEnt aux;
        aux = inicio.Liga;
        while (aux != fin && !aux.Codigo_A.equals(Codigo_A.getCodigo_A())) {
            aux = aux.Liga;
        }
        aux.Descripcion = Codigo_A.getDescripcion();
        aux.Duracion = Codigo_A.getDuracion();
        return true;
    }
    
    public boolean eliminarActividad(String Codigo_A) {
        ActividadEnt aux, con;
        aux = inicio.Liga;
        con = inicio;
        while (aux != fin && !Codigo_A.equals(aux.Codigo_A)) {
            con = aux;
            aux = aux.Liga;
        }
        aux.Descripcion = null;
        aux.Duracion = null;
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
    
     public String[][] cargarActividad() {
        ActividadEnt aux;
        cont = 0;
        aux = inicio.Liga;
        while (aux != fin.Liga) {
            cont++;
            aux = aux.Liga;
        }
        String[][] ActividadDatos = new String[cont][8];
        aux = inicio.Liga;
        for (int i = 0; i < cont; i++) {
            ActividadDatos[i][0] = aux.Codigo_A;
            ActividadDatos[i][1] = aux.Descripcion;
            ActividadDatos[i][2] = aux.Duracion;
            aux = aux.Liga;
        }
        return ActividadDatos;
    }
}



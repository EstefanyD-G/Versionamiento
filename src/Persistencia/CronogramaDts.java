package Persistencia;

import Entidades.CronogramaEnt;

public class CronogramaDts {
    
    public static CronogramaEnt inicio, fin, nodo, nodo1, nodo2, nodoI;
    public static int cont = 0;

    static {
        inicio = new CronogramaEnt(null, null, null);
        nodo = inicio.Liga = new CronogramaEnt("0000", "10/07/2015", "11/07/2015");
        nodo1 = nodo.Liga = new CronogramaEnt("1111", "10/07/2015", "11/07/2015");
        nodo2 = nodo1.Liga = new CronogramaEnt("2222", "10/07/2015", "11/07/2015");
        fin = nodo2.Liga = new CronogramaEnt("3333", "10/07/2015", "11/07/2015");
        fin.Liga = null;
    }
    
    
    public CronogramaEnt buscarCronogramaCodigo_C(String cr) {
        CronogramaEnt respuesta = null;
        CronogramaEnt aux = inicio.Liga;
        while (aux != fin && !cr.equals(aux.Codigo_C)) {
            aux = aux.Liga;
        }
        if (cr.equals(aux.Codigo_C)) {
            respuesta = new CronogramaEnt();
            respuesta.setCodigo_C(aux.Codigo_C);
            respuesta.setFecha_Inicio(aux.Fecha_Inicio);
            respuesta.setFecha_Finalizacion(aux.Fecha_Finalizacion);
            return respuesta;
        }
        return respuesta;
    }

    public boolean guardarCronograma(CronogramaEnt nueva) {
        nodoI = new CronogramaEnt(nueva.Codigo_C, nueva.Fecha_Inicio, nueva.Fecha_Finalizacion);
        nodoI.Liga = null;
        fin.Liga = nodoI;
        fin = nodoI;
        return true;

    }

    public boolean modificarCronograma(CronogramaEnt Codigo_C) {
        CronogramaEnt aux;
        aux = inicio.Liga;
        while (aux != fin && !aux.Codigo_C.equals(Codigo_C.getCodigo_C())) {
            aux = aux.Liga;
        }
        aux.Fecha_Inicio = Codigo_C.getFecha_Inicio();
        aux.Fecha_Finalizacion = Codigo_C.getFecha_Finalizacion();
        return true;
    }
    
    public boolean eliminarCronograma(String Codigo_C) {
        CronogramaEnt aux, con;
        aux = inicio.Liga;
        con = inicio;
        while (aux != fin && !Codigo_C.equals(aux.Codigo_C)) {
            con = aux;
            aux = aux.Liga;
        }
        aux.Fecha_Inicio = null;
        aux.Fecha_Finalizacion = null;
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
    
     public String[][] cargarCronograma() {
        CronogramaEnt aux;
        cont = 0;
        aux = inicio.Liga;
        while (aux != fin.Liga) {
            cont++;
            aux = aux.Liga;
        }
        String[][] CronogramaDatos = new String[cont][8];
        aux = inicio.Liga;
        for (int i = 0; i < cont; i++) {
            CronogramaDatos[i][0] = aux.Codigo_C;
            CronogramaDatos[i][1] = aux.Fecha_Inicio;
            CronogramaDatos[i][2] = aux.Fecha_Finalizacion;
            aux = aux.Liga;
        }
        return CronogramaDatos;
    }
}


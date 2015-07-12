package Negocio;

import Entidades.ActividadEnt;
import Persistencia.ActividadDts;
import javax.swing.table.DefaultTableModel;

public class ActividadNg {
    
    ActividadDts ActividadD = new ActividadDts();
    ActividadEnt ActividadE = null;
    
     public boolean guardarActividad(ActividadEnt m) {
        boolean resp = false;
        ActividadE = ActividadD.buscarActividadCodigo_A(m.getCodigo_A());
        if (ActividadE == null) {
            resp = ActividadD.guardarActividad(m);
        }
        return resp;
    }
     
     
    public ActividadEnt buscarActividadCodigo_A(String Codigo_A) {
        return ActividadD.buscarActividadCodigo_A(Codigo_A);
    }

    public boolean modificarActividad(ActividadEnt Codigo_A) {
        return ActividadD.modificarActividad(Codigo_A);
    }

    public boolean eliminarActividad(String Codigo_A) {
        return ActividadD.eliminarActividad(Codigo_A);
    }

    public DefaultTableModel cargarActividad(DefaultTableModel model) {
        String[][] result;

        result = ActividadD.cargarActividad();
        for (int i = 0; i < ActividadDts.cont; i++) {
            Object nuevo[] = {result[i][0], result[i][1], result[i][2]};
            model.addRow(nuevo);
        }
        return model;
    }

}
    


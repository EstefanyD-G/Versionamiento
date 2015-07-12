package Negocio;

import Entidades.CronogramaEnt;
import Persistencia.CronogramaDts;
import javax.swing.table.DefaultTableModel;

public class CronogramaNg {
    
    CronogramaDts CronogramaD = new CronogramaDts();
    CronogramaEnt CronogramaE = null;
    
     public boolean guardarCronograma(CronogramaEnt m) {
        boolean resp = false;
        CronogramaE = CronogramaD.buscarCronogramaCodigo_C(m.getCodigo_C());
        if (CronogramaE == null) {
            resp = CronogramaD.guardarCronograma(m);
        }
        return resp;
    }
     
     
    public CronogramaEnt buscarCronogramaCodigo_C(String Codigo_C) {
        return CronogramaD.buscarCronogramaCodigo_C(Codigo_C);
    }

    public boolean modificarCronograma(CronogramaEnt Codigo_C) {
        return CronogramaD.modificarCronograma(Codigo_C);
    }

    public boolean eliminarCronograma(String Codigo_C) {
        return CronogramaD.eliminarCronograma(Codigo_C);
    }

    public DefaultTableModel cargarCronograma(DefaultTableModel model) {
        String[][] result;

        result = CronogramaD.cargarCronograma();
        for (int i = 0; i < CronogramaDts.cont; i++) {
            Object nuevo[] = {result[i][0], result[i][1], result[i][2]};
            model.addRow(nuevo);
        }
        return model;
    }

}
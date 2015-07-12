package Entidades;

public class CronogramaEnt {

    public String Codigo_C;
    public String Fecha_Inicio;
    public String Fecha_Finalizacion;
    public CronogramaEnt Liga;

    public CronogramaEnt() {
        Codigo_C = null;
        Fecha_Inicio = null;
        Fecha_Finalizacion = null;
        Liga = null;
    }

    public CronogramaEnt(String Codigo_C, String Fecha_Inicio, String Fecha_Finalizacion) {
        this();
        this.Codigo_C = Codigo_C;
        this.Fecha_Inicio = Fecha_Inicio;
        this.Fecha_Finalizacion = Fecha_Finalizacion;
    }

    public String getCodigo_C() {
        return Codigo_C;
    }

    public void setCodigo_C(String Codigo_C) {
        this.Codigo_C = Codigo_C;
    }

    public String getFecha_Inicio() {
        return Fecha_Inicio;
    }

    public void setFecha_Inicio(String Fecha_Inicio) {
        this.Fecha_Inicio = Fecha_Inicio;
    }

    public String getFecha_Finalizacion() {
        return Fecha_Finalizacion;
    }

    public void setFecha_Finalizacion(String Fecha_Finalizacion) {
        this.Fecha_Finalizacion = Fecha_Finalizacion;
    }

    public CronogramaEnt getLiga() {
        return Liga;
    }

    public void setLiga(CronogramaEnt Liga) {
        this.Liga = Liga;
    }

    
}

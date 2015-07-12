package Entidades;

public class ActividadEnt {

    public String Codigo_A;
    public String Descripcion;
    public String Duracion;
    public ActividadEnt Liga;

    public ActividadEnt() {
        Codigo_A = null;
        Descripcion = null;
        Duracion = null;
        Liga = null;
    }

    public ActividadEnt(String Codigo_A, String Descripcion, String Duracion) {
        this();
        this.Codigo_A = Codigo_A;
        this.Descripcion = Descripcion;
        this.Duracion = Duracion;
    }



    public String getCodigo_A() {
        return Codigo_A;
    }

    public void setCodigo_A(String Codigo_A) {
        this.Codigo_A = Codigo_A;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getDuracion() {
        return Duracion;
    }

    public void setDuracion(String Duracion) {
        this.Duracion = Duracion;
    }

    public ActividadEnt getLiga() {
        return Liga;
    }

    public void setLiga(ActividadEnt LS) {
        this.Liga = Liga;
    }
    
    
}

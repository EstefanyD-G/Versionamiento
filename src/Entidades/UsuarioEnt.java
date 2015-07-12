package Entidades;


public class UsuarioEnt {
    
    public String Codigo_P;
    public String Nombre;
    public String Identificacion_R;
    public String Usuario;
    public String Contraseña;
    public String Perfil;
    public String Estado;
    public UsuarioEnt Liga;
    
    public UsuarioEnt() {
        Codigo_P = null;
        Nombre = null;
        Identificacion_R = null;
        Usuario = null;
        Contraseña = null;
        Perfil = null;
        Estado = null;
        Liga = null;
    }

    public UsuarioEnt(String Codigo_P, String Nombre, String Identificacion_R, String Usuario, String Contraseña,
            String Perfil, String Estado) {
        this();
        this.Codigo_P = Codigo_P;
        this.Nombre = Nombre;
        this.Identificacion_R = Identificacion_R;
        this.Usuario = Usuario;
        this.Contraseña = Contraseña;
        this.Perfil = Perfil;
        this.Estado = Estado;
    }

    public String getCodigo_P() {
        return Codigo_P;
    }

    public void setCodigo_P(String Codigo_P) {
        this.Codigo_P = Codigo_P;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getIdentificacion_R() {
        return Identificacion_R;
    }

    public void setIdentificacion_R(String Identificacion_R) {
        this.Identificacion_R = Identificacion_R;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    public String getPerfil() {
        return Perfil;
    }

    public void setPerfil(String Perfil) {
        this.Perfil = Perfil;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public UsuarioEnt getLiga() {
        return Liga;
    }

    public void setLiga(UsuarioEnt Liga) {
        this.Liga = Liga;
    }

    public UsuarioEnt getLS() {
        return Liga;
    }

    public void setLS(UsuarioEnt LS) {
        this.Liga = Liga;
    }

}

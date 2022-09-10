
package Modelo;

public class Personal extends Persona{
    private int perl_id;
    private String perl_usuario;
    private String perl_contraseña;
    private String perl_acceso;

   public Personal(){
       
   }

    public Personal(int perl_id, String perl_usuario, String perl_contraseña, String perl_acceso) {
        this.perl_id = perl_id;
        this.perl_usuario = perl_usuario;
        this.perl_contraseña = perl_contraseña;
        this.perl_acceso = perl_acceso;
    }

    public int getPerl_id() {
        return perl_id;
    }

    public void setPerl_id(int perl_id) {
        this.perl_id = perl_id;
    }

    public String getPerl_usuario() {
        return perl_usuario;
    }

    public void setPerl_usuario(String perl_usuario) {
        this.perl_usuario = perl_usuario;
    }

    public String getPerl_contraseña() {
        return perl_contraseña;
    }

    public void setPerl_contraseña(String perl_contraseña) {
        this.perl_contraseña = perl_contraseña;
    }

    public String getPerl_acceso() {
        return perl_acceso;
    }

    public void setPerl_acceso(String perl_acceso) {
        this.perl_acceso = perl_acceso;
    }

   
    
}

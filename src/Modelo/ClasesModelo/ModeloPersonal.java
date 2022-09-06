
package Modelo.ClasesModelo;

import Modelo.Conexion;
import Modelo.Personal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModeloPersonal extends Personal{
    Conexion con = new Conexion();
    
    public ModeloPersonal(){
        
    }

    public ModeloPersonal(int perl_id, String perl_usuario, String perl_contraseña, String perl_acceso, int per_id, int per_dni, String per_nombre1, String per_nombre2, String per_apellido1, String per_apellido2, boolean per_estado) {
        super(perl_id, perl_usuario, perl_contraseña, perl_acceso, per_id, per_dni, per_nombre1, per_nombre2, per_apellido1, per_apellido2, per_estado);
    }
   
    public boolean iniciarSecion(String user, String pass){
        String sql = "select perl_acceso from personal where perl_usuario ='"+user+"'and perl_contrasena ='"+pass+"';";
        
        ResultSet rs= con.consulta(sql);
        
        try {
            if(rs.next()){
                
                return true;
            }else{
                
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModeloPersonal.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
}

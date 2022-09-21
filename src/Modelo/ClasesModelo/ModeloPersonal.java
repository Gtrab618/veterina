package Modelo.ClasesModelo;

import Modelo.Conexion;
import Modelo.Personal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModeloPersonal extends Personal {

    Conexion con = new Conexion();

    public ModeloPersonal() {

    }

    public ModeloPersonal(int perl_id, String perl_usuario, String perl_contraseña, String perl_acceso) {
        super(perl_id, perl_usuario, perl_contraseña, perl_acceso);
    }

    public boolean iniciarSecion(String user, String pass) {
        String sql = "select perl_acceso from personal where perl_usuario ='" + user + "'and perl_contrasena ='" + pass + "';";

        ResultSet rs = con.consulta(sql);

        try {
            if (rs.next()) {
                rs.close();
                return true;
            } else {
                rs.close();
                return false;

            }

        } catch (SQLException ex) {
            Logger.getLogger(ModeloPersonal.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}

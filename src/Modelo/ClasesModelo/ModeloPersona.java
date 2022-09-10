package Modelo.ClasesModelo;

import Modelo.Conexion;
import Modelo.Persona;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModeloPersona extends Persona {

    Conexion pgcon = new Conexion();

    public ModeloPersona() {
    }

    public ModeloPersona(int per_id, String per_dni, String per_nombre1, String per_apellido1, String per_apellido2, String per_estado) {
        super(per_id, per_dni, per_nombre1, per_apellido1, per_apellido2, per_estado);
    }

    public int guardarPersonaId() {
        ResultSet resultado;
        int id = 0;
        
        String sql = "INSERT INTO persona(\n"
                + "	per_cedula, per_nombre, per_apellido1, per_apellido2, per_estado)\n"
                + "	VALUES ( ?, ?, ?, ?, ?);";

        try {
            //Recuperar primary key creada para ser usadada despues 
            PreparedStatement ps = pgcon.getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, getPer_dni());
            ps.setString(2, getPer_nombre1());
            ps.setString(3, getPer_apellido1());
            ps.setString(4, getPer_apellido2());
            ps.setString(5, "1");
            ps.executeUpdate();
           
            resultado = (ResultSet) ps.getGeneratedKeys();

            if (resultado.next()) {
                id = resultado.getInt(1);
            }
            ps.close();
            return id;
            
        
        } catch (SQLException ex) {
            Logger.getLogger(ModeloPersona.class.getName()).log(Level.SEVERE, null, ex);

            return -1;
            
        }
        
    }

}

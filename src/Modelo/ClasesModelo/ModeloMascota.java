package Modelo.ClasesModelo;

import Modelo.Conexion;
import Modelo.Mascota;
import java.awt.Image;
import java.io.FileInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModeloMascota extends Mascota {

    Conexion pgcon = new Conexion();

    public ModeloMascota() {
    }

    public ModeloMascota(int mas_id, String mas_nombreMas, String mas_sexo, String mas_raza, String mas_especie, Image foto, FileInputStream imageFile, int length, String mas_estado, int cli_idFK) {
        super(mas_id, mas_nombreMas, mas_sexo, mas_raza, mas_especie, foto, imageFile, length, mas_estado, cli_idFK);
    }

   

//    public boolean guardarMascota() {
//    
//
//        String sql = "INSERT INTO public.mascota(\n"
//                + "	 mas_nombremascota, mas_sexo, mas_raza, mas_especie, mas_foto, mas_estado, cli_id)\n"
//                + "	VALUES ( ?, ?, ?, ?, ?, ?, ?);";
//
//        try {
//            PreparedStatement ps = pgcon.getCon().prepareStatement(sql);
//            
//           ps.setString(1, getMas_nombreMas());
//           ps.setString(2, getMas_sexo() );
//           ps.setString(3, getMas_raza());
//           ps.setString(4, getMas_especie());
//           ps.setBinaryStream(5, getImageFile(), getLength());
//
//        } catch (SQLException ex) {
//            Logger.getLogger(ModeloPersona.class.getName()).log(Level.SEVERE, null, ex);
//
//         
//
//        }
//
//    }
}

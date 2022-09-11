package Modelo.ClasesModelo;

import Modelo.Conexion;
import Modelo.Mascota;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModeloMascota extends Mascota {

    Conexion pgcon = new Conexion();

    public ModeloMascota() {
    }

    public ModeloMascota(int mas_id, String mas_nombreMas, String mas_sexo, String mas_raza, String mas_especie, byte[] foto, String mas_estado, int cli_idFK) {
        super(mas_id, mas_nombreMas, mas_sexo, mas_raza, mas_especie, foto, mas_estado, cli_idFK);
    }

    public boolean guardarMascota() {

        String sql = "INSERT INTO public.mascota(\n"
                + "	 mas_nombremascota, mas_sexo, mas_raza, mas_especie, mas_foto, mas_estado, cli_id)\n"
                + "	VALUES ( ?, ?, ?, ?, ?, ?, ?);";

        try {
            PreparedStatement ps = pgcon.getCon().prepareStatement(sql);

            ps.setString(1, getMas_nombreMas());
            ps.setString(2, getMas_sexo());
            ps.setString(3, getMas_raza());
            ps.setString(4, getMas_especie());
            ps.setBytes(5, getFoto());
            ps.setInt(6, 1);
            ps.setInt(7, getCli_idFK());
            ps.execute();
            ps.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloPersona.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public List<Mascota> consultarMascotaCedu(String cedula) {

        List<Mascota> listMasc = new ArrayList<>();
        String sql = " SELECT m.mas_nombremascota ,m.mas_especie\n"
                + "	FROM mascota m join cliente c on (m.cli_id=c.cli_id) \n"
                + "    join persona p on (c.per_id =p.per_id) where m.mas_estado= '1' and p.per_cedula='" + cedula + "';";

        ResultSet rs = pgcon.consulta(sql);
        
        try {
            while(rs.next()){
                Mascota mascota = new Mascota();
                mascota.setMas_nombreMas(rs.getString("mas_nombremascota"));
                mascota.setMas_especie(rs.getString("mas_especie"));
                listMasc.add(mascota);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModeloMascota.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listMasc;
    }

}

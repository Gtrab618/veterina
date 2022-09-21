package Modelo.ClasesModelo;

import Modelo.Conexion;
import Modelo.Mascota;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ModeloMascota extends Mascota {

    Conexion pgcon = new Conexion();

    public ModeloMascota() {
    }

    public ModeloMascota(int mas_id, String mas_nombreMas, String mas_sexo, String mas_raza, boolean mas_esterilizado, String mas_especie, Date mas_fechaNac, byte[] foto, String mas_estado, int cli_idFK) {
        super(mas_id, mas_nombreMas, mas_sexo, mas_raza, mas_esterilizado, mas_especie, mas_fechaNac, foto, mas_estado, cli_idFK);
    }

    

    public boolean guardarMascota() {

        String sql = "INSERT INTO public.mascota(\n"
                + "	 mas_nombremascota, mas_sexo, mas_raza, mas_especie, mas_foto, mas_estado,mas_esterilizado, cli_id,mas_fechaNac)\n"
                + "	VALUES ( ?, ?, ?, ?, ?, ?, ?,?, ?);";

        try {
            PreparedStatement ps = pgcon.getCon().prepareStatement(sql);

            ps.setString(1, getMas_nombreMas());
            ps.setString(2, getMas_sexo());
            ps.setString(3, getMas_raza());
            ps.setString(4, getMas_especie());
            ps.setBytes(5, getFoto());
            ps.setInt(6, 1);
            ps.setBoolean(7, true);
            ps.setInt(8, getCli_idFK());
            ps.setDate(9, new java.sql.Date(((Date) getMas_fechaNac()).getTime()));
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
        String sql = " SELECT m.mas_id,m.mas_nombremascota ,m.mas_especie,m.mas_raza\n"
                + "	FROM mascota m join cliente c on (m.cli_id=c.cli_id) \n"
                + "    join persona p on (c.per_id =p.per_id) where m.mas_estado= '1' and p.per_cedula='" + cedula + "';";

        ResultSet rs = pgcon.consulta(sql);

        try {
            while (rs.next()) {
                Mascota mascota = new Mascota();
                mascota.setMas_id(rs.getInt("mas_id"));
                mascota.setMas_nombreMas(rs.getString("mas_nombremascota"));
                mascota.setMas_especie(rs.getString("mas_especie"));
                mascota.setMas_raza(rs.getString("mas_raza"));
                listMasc.add(mascota);
            }
             rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ModeloMascota.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listMasc;
    }

    public Mascota consultarMascotaId(String id) {
        int id_mas = Integer.parseInt(id);
        byte[] bytea;
        Mascota mas = new Mascota();
        String sql = " SELECT mas_id, mas_nombremascota, mas_sexo, mas_raza, mas_especie, mas_foto, mas_estado, cli_id, mas_fechanac\n"
                + "	FROM mascota where mas_estado= '1' and  mas_id ='" + id_mas + "'";

        ResultSet rs = pgcon.consulta(sql);

        try {
            while (rs.next()) {

                mas.setMas_id(rs.getInt("mas_id"));
                mas.setMas_nombreMas(rs.getString("mas_nombremascota"));
                mas.setMas_sexo(rs.getString("mas_sexo"));
                //recupero la foto y le paso a un array de bit 
                bytea = rs.getBytes("mas_foto");
                //mando el array de bits para se mostrado
                mas.setFoto(bytea);
                mas.setMas_fechaNac(rs.getDate("mas_fechanac"));
                mas.setMas_especie(rs.getString("mas_especie"));
                mas.setMas_raza(rs.getString("mas_raza"));

            }
            
             rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ModeloMascota.class.getName()).log(Level.SEVERE, null, ex);
        }

        return mas;
    }

    public Mascota verFotoMascota(int id) {
        Mascota mas = new Mascota();

        try {

            byte[] bytea;

            String sql = "SELECT mas_nombremascota, mas_foto FROM mascota where mas_estado= '1' and  mas_id='" + id + "';";
            ResultSet rs = pgcon.consulta(sql);

            while (rs.next()) {
                mas.setMas_nombreMas(rs.getString("mas_nombremascota"));
                bytea = rs.getBytes("mas_foto");
                if (bytea != null) {
                    mas.setFoto(bytea);
                }

            }
             rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ModeloMascota.class.getName()).log(Level.SEVERE, null, ex);

        }
        return mas;
    }

    public boolean eliminarMascota(String idMas) {
        try {
            String sql = "UPDATE mascota SET mas_estado=?\n"
                    + "	WHERE mas_id='" + idMas + "';";

            PreparedStatement ps = pgcon.getCon().prepareStatement(sql);
            ps.setString(1, "0");
            ps.execute();
            ps.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloMascota.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public boolean actualizarMascotaFoto(String idMas) {
        try {
            String sql = "UPDATE mascota\n"
                    + "	SET mas_nombremascota=?, mas_sexo=?, mas_raza=?, mas_especie=?, mas_fechanac=?, mas_foto=?\n"
                    + "	WHERE mas_id='" + idMas + "';";

            PreparedStatement ps = pgcon.getCon().prepareStatement(sql);

            ps.setString(1, getMas_nombreMas());
            ps.setString(2, getMas_sexo());
            ps.setString(3, getMas_raza());
            ps.setString(4, getMas_especie());
            ps.setDate(5, new java.sql.Date(((Date) getMas_fechaNac()).getTime()));
            ps.setBytes(6, getFoto());
            ps.execute();
            ps.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloMascota.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean actualizarMascotaSinFoto(String idMas) {
        try {
            String sql = "UPDATE mascota\n"
                    + "	SET mas_nombremascota=?, mas_sexo=?, mas_raza=?, mas_especie=?, mas_fechanac=?\n"
                    + "	WHERE mas_id='" + idMas + "';";

            PreparedStatement ps = pgcon.getCon().prepareStatement(sql);

            ps.setString(1, getMas_nombreMas());
            ps.setString(2, getMas_sexo());
            ps.setString(3, getMas_raza());
            ps.setString(4, getMas_especie());
            ps.setDate(5, new java.sql.Date(((Date) getMas_fechaNac()).getTime()));
            ps.execute();
            ps.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloMascota.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}

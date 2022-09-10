package Modelo.ClasesModelo;

import Modelo.Cliente;
import Modelo.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class ModeloCliente extends Cliente {

    Conexion pgcon = new Conexion();

    public ModeloCliente() {

    }

    public ModeloCliente(int cli_id, String cli_telefono, String cli_direccion, int per_idFk) {
        super(cli_id, cli_telefono, cli_direccion, per_idFk);
    }

    public int guardarClienteRId() {
        ResultSet resultado;
        int id = 0;

        String sql = "INSERT INTO public.cliente(\n"
                + "	 cli_telefono, cli_direccion, per_id)\n"
                + "	VALUES ( ?, ?, ?, ?);";

        try {
            PreparedStatement ps = pgcon.getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, getCli_telefono());
            ps.setString(2, getCli_direccion());
            ps.setString(3, getPer_apellido1());
            ps.setInt(4, getPer_idFk());
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

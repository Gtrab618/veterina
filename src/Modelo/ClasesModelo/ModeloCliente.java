package Modelo.ClasesModelo;

import Modelo.Cliente;
import Modelo.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
                + "	VALUES ( ?, ?, ?);";

        try {
            PreparedStatement ps = pgcon.getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, getCli_telefono());
            ps.setString(2, getCli_direccion());
            ps.setInt(3, getPer_idFk());
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

    public List<Cliente> recuperarCliente() {

        List<Cliente> listaClientes = new ArrayList<Cliente>();
        String sql = "select c.cli_id,p.per_cedula, p.per_nombre, p.per_apellido1 from persona p \n"
                + "JOIN cliente c on(p.per_id = c.per_id);";
        ResultSet rs= pgcon.consulta(sql);
        
        try {
            
            while(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setCli_id(rs.getInt("cli_id"));
                cliente.setPer_dni(rs.getString("per_cedula"));
                cliente.setPer_nombre1(rs.getString("per_nombre"));
                cliente.setPer_apellido1(rs.getString("per_apellido1"));
                
                listaClientes.add(cliente);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaClientes;
    }

}

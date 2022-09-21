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

    public List<Cliente> recuperarClientes() {

        List<Cliente> listaClientes = new ArrayList<Cliente>();
        String sql = "select c.cli_id,p.per_cedula, p.per_nombre, p.per_apellido1,p.per_apellido2 from persona p \n"
                + "JOIN cliente c on(p.per_id = c.per_id) where p.per_estado='1';";
        ResultSet rs = pgcon.consulta(sql);

        try {

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setCli_id(rs.getInt("cli_id"));
                cliente.setPer_dni(rs.getString("per_cedula"));
                cliente.setPer_nombre1(rs.getString("per_nombre"));
                cliente.setPer_apellido1(rs.getString("per_apellido1"));
                cliente.setPer_apellido2(rs.getString("per_apellido2"));
                listaClientes.add(cliente);
               
            }
             rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaClientes;
    }

    public Cliente getClienteEspecifico(String cedula) {

        Cliente cliente = new Cliente();
        String sql = "select c.cli_id,p.per_cedula, p.per_nombre, p.per_apellido1, p.per_apellido2, c.cli_telefono, c.cli_direccion from persona p \n"
                + "JOIN cliente c on(p.per_id = c.per_id) where p.per_estado='1' and p.per_cedula='" + cedula + "';";
        ResultSet rs = pgcon.consulta(sql);

        try {

            while (rs.next()) {

                cliente.setCli_id(rs.getInt("cli_id"));
                cliente.setPer_dni(rs.getString("per_cedula"));
                cliente.setPer_nombre1(rs.getString("per_nombre"));
                cliente.setPer_apellido1(rs.getString("per_apellido1"));
                cliente.setPer_apellido2(rs.getString("per_apellido2"));
                cliente.setCli_direccion(rs.getString("cli_direccion"));
                cliente.setCli_telefono(rs.getString("cli_telefono"));

            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cliente;
    }
    
    public List<Cliente> busquedaIncrementalCliente(String criterio) {

        List<Cliente> listaClientes = new ArrayList<Cliente>();
        String sql = "select c.cli_id,p.per_cedula, p.per_nombre, p.per_apellido1, p.per_apellido2, c.cli_telefono, c.cli_direccion from persona p \n"
                + "JOIN cliente c on(p.per_id = c.per_id) where p.per_estado='1' and p.per_cedula like'%" + criterio + "%' or lower(p.per_nombre) like '%"+criterio+"%' or lower(p.per_apellido1) like '%"+criterio+"%'or lower(p.per_apellido2) like '%"+criterio+"%';";
        ResultSet rs = pgcon.consulta(sql);

        try {

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setCli_id(rs.getInt("cli_id"));
                cliente.setPer_dni(rs.getString("per_cedula"));
                cliente.setPer_nombre1(rs.getString("per_nombre"));
                cliente.setPer_apellido1(rs.getString("per_apellido1"));
                cliente.setPer_apellido2(rs.getString("per_apellido2"));
                listaClientes.add(cliente);
            }
             rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

         return listaClientes;
    }
    
    

    
    public boolean updatePersona(String cedula){
        try {
            String sql = "UPDATE public.persona\n" +
                    "	SET  per_nombre=?, per_apellido1=?, per_apellido2=?\n" +
                    "	WHERE per_cedula='" + cedula + "';";
            
            PreparedStatement ps = pgcon.getCon().prepareStatement(sql);
            ps.setString(1, getPer_nombre1());
            ps.setString(2, getPer_apellido1());
            ps.setString(3, getPer_apellido2());
            ps.execute();
            ps.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
            
        
        
    }
    
    public boolean updateCliente(String cedula){
        try {
            String sql= "UPDATE cliente c set cli_telefono=?,cli_direccion=? from persona p\n" +
                    "where p.per_id= c.per_id and p.per_cedula='" + cedula + "';";
            PreparedStatement ps = pgcon.getCon().prepareStatement(sql);
            
            ps.setString(1, getCli_telefono());
            ps.setString(2, getCli_direccion());
            ps.execute();
            ps.close();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    
    public boolean eliminarCliente(String cedula){
        try {
            String sql= "UPDATE persona SET  per_estado=?\n" +
                    "	WHERE per_cedula='" + cedula + "';";
            PreparedStatement ps = pgcon.getCon().prepareStatement(sql);
            ps.setString(1, "0");
            ps.execute();
            ps.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}

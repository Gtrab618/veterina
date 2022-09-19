/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.ClasesModelo;
import Modelo.Conexion;
import Modelo.Grooming;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
/**
 *
 * @author AIT-DEKTOP
 */
public class ModeloGrooming extends Grooming{
    Conexion conexion = new Conexion();

    public ModeloGrooming() {
    }

    public ModeloGrooming(int gro_id_grooming, String gro_tipo_corte, double gro_precio, Date gro_fecha, String gro_alergia, int mas_id_mascotafk) {
        super(gro_id_grooming, gro_tipo_corte, gro_precio, gro_fecha, gro_alergia, mas_id_mascotafk);
    }

    
    /////////////INICIO DE LOS METODOS//////////////
    public List<Grooming> listaGrooming() {

        String sql = "select * from grooming";

        List<Grooming> listagrooming = new ArrayList<>();
        ResultSet rs = conexion.consulta(sql);
        byte[] bytea;
        try {
            while (rs.next()) {

                Grooming gro = new Grooming();
                gro.setGro_id_grooming(rs.getInt(1));
                gro.setGro_tipo_corte(rs.getString(2));
                gro.setGro_precio(rs.getInt(3));
                gro.setGro_fecha(rs.getDate(4));
                gro.setGro_alergia(rs.getString(5));
                gro.setMas_id_mascotafk(rs.getInt(6));
                listagrooming.add(gro);

            }

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ModeloMascota.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listagrooming;

    }

    /*
    INSERT INTO grooming(gro_id_grooming, gro_tipo_corte, gro_precio, gro_fecha, gro_alergia,mas_id_mascotafk)
    VALUES (?, ?, ?, ?, ?,?);
    */
    public boolean InsertarGrooming() {
        String sql;
        sql = "INSERT INTO grooming( gro_tipocorte, gro_precio, gro_fecha, gro_alergia, mas_id)"
                + " VALUES ('" + getGro_tipo_corte()+ "'"
                + ",'" + getGro_precio()+ "'"
                + ",'" + getGro_fecha()+ "'"
                + ",'" + getGro_alergia()+ "'"
                + ",'" + getMas_id_mascotafk()+ "')";
        return conexion.accion(sql);
        /*EJECUTAMOS CONSOLA*/
    }

    /*
    UPDATE grooming
    SET gro_id_grooming=?, gro_tipo_corte=?, gro_precio=?, gro_fecha=?, gro_alergia=?, mas_id_mascotafk=?
    WHERE <condition>;
    */
    public boolean uptadeGrooming(String id) {
        String sql = "UPDATE grooming SET gro_id_grooming='" + getGro_id_grooming()+ "', gro_tipo_corte='" + getGro_tipo_corte()+ "', "
                + "gro_precio='" + getGro_precio()+ "', gro_fecha='" + getGro_fecha()+ "', gro_alergia='" + getGro_alergia()+ "', "
                + "mas_id_mascotafk='" + getMas_id_mascotafk()+"' WHERE mas_id_mascota='" + id + "'";
        return conexion.accion(sql);
    }

    public boolean deleteGrooming(String identificacion) {
        String sql = "DELETE FROM grooming where gro_id_grooming='" + getGro_id_grooming()+ "'";
        return conexion.accion(sql);
    }

    public List<Grooming> listaGrobuscar(String buscar) {
        List<Grooming> listagroomings = new ArrayList<Grooming>();
        String sql3;
        if (buscar.equals(null)) {
            sql3 = "select gro_id_grooming , gro_tipo_corte ,gro_precio ,gro_fecha, gro_alergia ,mas_id_mascotafk from  grooming";
        } else {
            sql3 = "select  gro_id_grooming , gro_tipo_corte ,gro_precio ,gro_fecha, gro_alergia ,mas_id_mascotafk from  grooming"
                    + " WHERE UPPER(gro_tipo_corte) LIKE UPPER('%" + buscar + "%') OR UPPER(mas_id_mascotafk) LIKE UPPER('%" + buscar + "%') OR ";
            sql3 += " UPPER(gro_id_grooming) LIKE UPPER('%" + buscar + "%')";
            try {
                ResultSet rs = conexion.consulta(sql3);
                while (rs.next()) {
                    Grooming grom = new Grooming();
                    grom.setGro_id_grooming(rs.getInt(1));
                    grom.setGro_tipo_corte(rs.getString(2));
                    grom.setGro_precio(rs.getInt(3));
                    grom.setGro_fecha(rs.getDate(4));
                    grom.setGro_alergia(rs.getString(5));
                    grom.setMas_id_mascotafk(rs.getInt(6));
                    listagroomings.add(grom);
                }
                rs.close();

            } catch (SQLException ex) {
                System.out.println(ex);
                Logger.getLogger(ModeloMascota.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }

        }
        return listagroomings;
    }

    private Image getImage(byte[] bytes) throws IOException {
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        Iterator it = ImageIO.getImageReadersByFormatName("jpeg");
        ImageReader ImageReader = (ImageReader) it.next();
        Object source = bais;
        ImageInputStream iis = ImageIO.createImageInputStream(source);
        ImageReader.setInput(iis, true);
        ImageReadParam param = ImageReader.getDefaultReadParam();
        param.setSourceSubsampling(1, 1, 0, 0);
        return ImageReader.read(0, param);

    }
}




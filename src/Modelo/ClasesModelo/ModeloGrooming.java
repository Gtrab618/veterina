/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.ClasesModelo;
import Modelo.Conexion;
import Modelo.Grooming;
import java.util.Date;

/**
 *
 * @author AIT-DEKTOP
 */
public class ModeloGrooming extends Grooming{
    Conexion conexion = new Conexion();

    public ModeloGrooming() {
    }

    public ModeloGrooming(int gro_id_grooming, String gro_tipo_corte, double gro_precio, Date gro_fecha, String descripcion, int mas_id_mascotafk) {
        super(gro_id_grooming, gro_tipo_corte, gro_precio, gro_fecha, descripcion, mas_id_mascotafk);
    }

    

    
    public boolean InsertarGrooming() {
        String sql;
        sql = "INSERT INTO grooming( gro_tipocorte, gro_precio, gro_fecha,gro_descripcion, mas_id)"
                + " VALUES ('" + getGro_tipo_corte()+ "'"
                + ",'" + getGro_precio()+ "'"
                + ",'" + getGro_fecha()+ "'"
                + ",'" + getDescripcion()+ "'"
                + ",'" + getMas_id_mascotafk()+ "')";
        return conexion.accion(sql);
        /*EJECUTAMOS CONSOLA*/
    }

    /*
    UPDATE grooming
    SET gro_id_grooming=?, gro_tipo_corte=?, gro_precio=?, gro_fecha=?, gro_alergia=?, mas_id_mascotafk=?
    WHERE <condition>;
    */
//    public boolean uptadeGrooming(String id) {
//        String sql = "UPDATE grooming SET gro_id_grooming='" + getGro_id_grooming()+ "', gro_tipo_corte='" + getGro_tipo_corte()+ "', "
//                + "gro_precio='" + getGro_precio()+ "', gro_fecha='" + getGro_fecha()+ "', gro_alergia='" + getGro_alergia()+ "', "
//                + "mas_id_mascotafk='" + getMas_id_mascotafk()+"' WHERE mas_id_mascota='" + id + "'";
//        return conexion.accion(sql);
//    }

  



}




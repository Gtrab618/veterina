/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.ClasesModelo;

import Modelo.Cita;
import Modelo.Conexion;
import java.util.Date;

/**
 *
 * @author Usuario
 */
public class ModeloCita extends Cita {

    Conexion pgcon = new Conexion();

    public ModeloCita() {
    }

    public ModeloCita(int con_id, String con_motivos, String con_observaciones, String con_tratamiento, int con_frecuenciaCardiaca, int con_fercunciaRespiratoria, int con_hidratacion, double con_temperatura, double peso, String con_llenadoCapilar, String con_muscosa, Date con_fecha, int mas_id) {
        super(con_id, con_motivos, con_observaciones, con_tratamiento, con_frecuenciaCardiaca, con_fercunciaRespiratoria, con_hidratacion, con_temperatura, peso, con_llenadoCapilar, con_muscosa, con_fecha, mas_id);
    }

    public boolean guardarCita() {
        String sql = "INSERT INTO consulta(con_motivos, con_observaciones, con_tratamiento, con_frecuenciacardiaca, con_frecuenciarespiratoria, con_hidratacion, con_temperatura, con_peso, con_llenadocapilar, con_muscosa, con_fecha, mas_id)\n"
                + "	VALUES ( '" + getCon_motivos() + "','" + getCon_observaciones() + "','" + getCon_tratamiento()
                + "','" + getCon_frecuenciaCardiaca() + "','" + getCon_fercunciaRespiratoria() + "','" + getCon_hidratacion() + "','" + getCon_temperatura() + "'"
                + ",'" + getPeso() + "','" + getCon_llenadoCapilar() + "','" + getCon_muscosa() + "','" + getCon_fecha() + "','" + getMas_id() + "')";

        return pgcon.accion(sql);
    }

}

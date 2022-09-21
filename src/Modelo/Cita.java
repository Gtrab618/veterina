package Modelo;

import java.util.Date;

/**
 *
 * @author Usuario
 */
public class Cita {

    private int con_id;
    private String con_motivos;
    private String con_observaciones;
    private String con_tratamiento;
    private int con_frecuenciaCardiaca;
    private int con_fercunciaRespiratoria;
    private int con_hidratacion;
    private double con_temperatura;
    private double peso;
    private String con_llenadoCapilar;
    private String con_muscosa;
    private Date con_fecha;
    private int mas_id;

    public Cita() {
    }

    public Cita(int con_id, String con_motivos, String con_observaciones, String con_tratamiento, int con_frecuenciaCardiaca, int con_fercunciaRespiratoria, int con_hidratacion, double con_temperatura, double peso, String con_llenadoCapilar, String con_muscosa, Date con_fecha, int mas_id) {
        this.con_id = con_id;
        this.con_motivos = con_motivos;
        this.con_observaciones = con_observaciones;
        this.con_tratamiento = con_tratamiento;
        this.con_frecuenciaCardiaca = con_frecuenciaCardiaca;
        this.con_fercunciaRespiratoria = con_fercunciaRespiratoria;
        this.con_hidratacion = con_hidratacion;
        this.con_temperatura = con_temperatura;
        this.peso = peso;
        this.con_llenadoCapilar = con_llenadoCapilar;
        this.con_muscosa = con_muscosa;
        this.con_fecha = con_fecha;
        this.mas_id = mas_id;
    }

    public int getCon_id() {
        return con_id;
    }

    public void setCon_id(int con_id) {
        this.con_id = con_id;
    }

    public String getCon_motivos() {
        return con_motivos;
    }

    public void setCon_motivos(String con_motivos) {
        this.con_motivos = con_motivos;
    }

    public String getCon_observaciones() {
        return con_observaciones;
    }

    public void setCon_observaciones(String con_observaciones) {
        this.con_observaciones = con_observaciones;
    }

    public String getCon_tratamiento() {
        return con_tratamiento;
    }

    public void setCon_tratamiento(String con_tratamiento) {
        this.con_tratamiento = con_tratamiento;
    }

    public int getCon_frecuenciaCardiaca() {
        return con_frecuenciaCardiaca;
    }

    public void setCon_frecuenciaCardiaca(int con_frecuenciaCardiaca) {
        this.con_frecuenciaCardiaca = con_frecuenciaCardiaca;
    }

    public int getCon_fercunciaRespiratoria() {
        return con_fercunciaRespiratoria;
    }

    public void setCon_fercunciaRespiratoria(int con_fercunciaRespiratoria) {
        this.con_fercunciaRespiratoria = con_fercunciaRespiratoria;
    }

    public int getCon_hidratacion() {
        return con_hidratacion;
    }

    public void setCon_hidratacion(int con_hidratacion) {
        this.con_hidratacion = con_hidratacion;
    }

    public double getCon_temperatura() {
        return con_temperatura;
    }

    public void setCon_temperatura(double con_temperatura) {
        this.con_temperatura = con_temperatura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getCon_llenadoCapilar() {
        return con_llenadoCapilar;
    }

    public void setCon_llenadoCapilar(String con_llenadoCapilar) {
        this.con_llenadoCapilar = con_llenadoCapilar;
    }

    public String getCon_muscosa() {
        return con_muscosa;
    }

    public void setCon_muscosa(String con_muscosa) {
        this.con_muscosa = con_muscosa;
    }

    public Date getCon_fecha() {
        return con_fecha;
    }

    public void setCon_fecha(Date con_fecha) {
        this.con_fecha = con_fecha;
    }

    public int getMas_id() {
        return mas_id;
    }

    public void setMas_id(int mas_id) {
        this.mas_id = mas_id;
    }

    

}

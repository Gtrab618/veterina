
package Modelo;

import java.sql.Date;

public class Consulta {
    private int con_id;
    private String con_sintomas;
    private double con_peso;
    private Date con_fecha;
    private boolean con_estado;
    private int mas_idFK;
    
    public Consulta(){
        
    }

    public Consulta(int con_id, String con_sintomas, double con_peso, Date con_fecha, boolean con_estado, int mas_idFK) {
        this.con_id = con_id;
        this.con_sintomas = con_sintomas;
        this.con_peso = con_peso;
        this.con_fecha = con_fecha;
        this.con_estado = con_estado;
        this.mas_idFK = mas_idFK;
    }

    public int getCon_id() {
        return con_id;
    }

    public void setCon_id(int con_id) {
        this.con_id = con_id;
    }

    public String getCon_sintomas() {
        return con_sintomas;
    }

    public void setCon_sintomas(String con_sintomas) {
        this.con_sintomas = con_sintomas;
    }

    public double getCon_peso() {
        return con_peso;
    }

    public void setCon_peso(double con_peso) {
        this.con_peso = con_peso;
    }

    public Date getCon_fecha() {
        return con_fecha;
    }

    public void setCon_fecha(Date con_fecha) {
        this.con_fecha = con_fecha;
    }

  

    public boolean isCon_estado() {
        return con_estado;
    }

    public void setCon_estado(boolean con_estado) {
        this.con_estado = con_estado;
    }

    public int getMas_idFK() {
        return mas_idFK;
    }

    public void setMas_idFK(int mas_idFK) {
        this.mas_idFK = mas_idFK;
    }
    
    
}

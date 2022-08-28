
package Modelo;

import java.sql.Date;



public class Medicamentos {
    private int med_id;
    private String med_nombre;
    private Date med_fechaElaboracion;
    private Date med_fechaCaducidad;
    private int med_stock;
    private boolean med_estado;
    
    public Medicamentos(){
        
    }
    
    public Medicamentos(int med_id, String med_nombre, Date med_fechaElaboracion, Date med_fechaCaducidad, int med_stock, boolean med_estado) {
        this.med_id = med_id;
        this.med_nombre = med_nombre;
        this.med_fechaElaboracion = med_fechaElaboracion;
        this.med_fechaCaducidad = med_fechaCaducidad;
        this.med_stock = med_stock;
        this.med_estado = med_estado;
    }

    public int getMed_id() {
        return med_id;
    }

    public void setMed_id(int med_id) {
        this.med_id = med_id;
    }

    public String getMed_nombre() {
        return med_nombre;
    }

    public void setMed_nombre(String med_nombre) {
        this.med_nombre = med_nombre;
    }

    public Date getMed_fechaElaboracion() {
        return med_fechaElaboracion;
    }

    public void setMed_fechaElaboracion(Date med_fechaElaboracion) {
        this.med_fechaElaboracion = med_fechaElaboracion;
    }

    public Date getMed_fechaCaducidad() {
        return med_fechaCaducidad;
    }

    public void setMed_fechaCaducidad(Date med_fechaCaducidad) {
        this.med_fechaCaducidad = med_fechaCaducidad;
    }

    public int getMed_stock() {
        return med_stock;
    }

    public void setMed_stock(int med_stock) {
        this.med_stock = med_stock;
    }

    public boolean isMed_estado() {
        return med_estado;
    }

    public void setMed_estado(boolean med_estado) {
        this.med_estado = med_estado;
    }
    
    
}

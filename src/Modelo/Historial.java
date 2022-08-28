
package Modelo;

public class Historial {
    private int his_id;
    private String his_detalle;
    private boolean his_cirugia;
    private boolean his_estado;
    private int con_idFK;
    
    public Historial(){
        
    }
    public Historial(int his_id, String his_detalle, boolean his_cirugia, boolean his_estado, int con_idFK) {
        this.his_id = his_id;
        this.his_detalle = his_detalle;
        this.his_cirugia = his_cirugia;
        this.his_estado = his_estado;
        this.con_idFK = con_idFK;
    }

    public int getHis_id() {
        return his_id;
    }

    public void setHis_id(int his_id) {
        this.his_id = his_id;
    }

    public String getHis_detalle() {
        return his_detalle;
    }

    public void setHis_detalle(String his_detalle) {
        this.his_detalle = his_detalle;
    }

    public boolean isHis_cirugia() {
        return his_cirugia;
    }

    public void setHis_cirugia(boolean his_cirugia) {
        this.his_cirugia = his_cirugia;
    }

    public boolean isHis_estado() {
        return his_estado;
    }

    public void setHis_estado(boolean his_estado) {
        this.his_estado = his_estado;
    }

    public int getCon_idFK() {
        return con_idFK;
    }

    public void setCon_idFK(int con_idFK) {
        this.con_idFK = con_idFK;
    }
    
    
    
}

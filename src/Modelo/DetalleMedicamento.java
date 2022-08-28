
package Modelo;

public class DetalleMedicamento {
    private int det_id;
    private int med_idFK;
    private int his_id;

    public DetalleMedicamento(int det_id, int med_idFK, int his_id) {
        this.det_id = det_id;
        this.med_idFK = med_idFK;
        this.his_id = his_id;
    }

    public int getDet_id() {
        return det_id;
    }

    public void setDet_id(int det_id) {
        this.det_id = det_id;
    }

    public int getMed_idFK() {
        return med_idFK;
    }

    public void setMed_idFK(int med_idFK) {
        this.med_idFK = med_idFK;
    }

    public int getHis_id() {
        return his_id;
    }

    public void setHis_id(int his_id) {
        this.his_id = his_id;
    }
    
    
}

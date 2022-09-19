
package Modelo;

import java.util.Date;


public class Grooming {
     private int gro_id_grooming;
    private String gro_tipo_corte;
    private double gro_precio;
    private Date gro_fecha;
    private String descripcion;
    private int mas_id_mascotafk;

    public Grooming() {
    }

    public Grooming(int gro_id_grooming, String gro_tipo_corte, double gro_precio, Date gro_fecha, String descripcion, int mas_id_mascotafk) {
        this.gro_id_grooming = gro_id_grooming;
        this.gro_tipo_corte = gro_tipo_corte;
        this.gro_precio = gro_precio;
        this.gro_fecha = gro_fecha;
        this.descripcion = descripcion;
        this.mas_id_mascotafk = mas_id_mascotafk;
    }

    public int getGro_id_grooming() {
        return gro_id_grooming;
    }

    public void setGro_id_grooming(int gro_id_grooming) {
        this.gro_id_grooming = gro_id_grooming;
    }

    public String getGro_tipo_corte() {
        return gro_tipo_corte;
    }

    public void setGro_tipo_corte(String gro_tipo_corte) {
        this.gro_tipo_corte = gro_tipo_corte;
    }

    public double getGro_precio() {
        return gro_precio;
    }

    public void setGro_precio(double gro_precio) {
        this.gro_precio = gro_precio;
    }

    public Date getGro_fecha() {
        return gro_fecha;
    }

    public void setGro_fecha(Date gro_fecha) {
        this.gro_fecha = gro_fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getMas_id_mascotafk() {
        return mas_id_mascotafk;
    }

    public void setMas_id_mascotafk(int mas_id_mascotafk) {
        this.mas_id_mascotafk = mas_id_mascotafk;
    }


}

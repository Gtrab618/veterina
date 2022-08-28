
package Modelo;

public class Persona {
    private int per_id;
    private int per_dni;
    private String per_nombre1;
    private String per_nombre2;
    private String per_apellido1;
    private String per_apellido2;
    private boolean per_estado;
    
    public Persona(){
        
    }
    
    public Persona(int per_id, int per_dni, String per_nombre1, String per_nombre2, String per_apellido1, String per_apellido2, boolean per_estado) {
        this.per_id = per_id;
        this.per_dni = per_dni;
        this.per_nombre1 = per_nombre1;
        this.per_nombre2 = per_nombre2;
        this.per_apellido1 = per_apellido1;
        this.per_apellido2 = per_apellido2;
        this.per_estado = per_estado;
    }

    public int getPer_id() {
        return per_id;
    }

    public void setPer_id(int per_id) {
        this.per_id = per_id;
    }

    public int getPer_dni() {
        return per_dni;
    }

    public void setPer_dni(int per_dni) {
        this.per_dni = per_dni;
    }

    public String getPer_nombre1() {
        return per_nombre1;
    }

    public void setPer_nombre1(String per_nombre1) {
        this.per_nombre1 = per_nombre1;
    }

    public String getPer_nombre2() {
        return per_nombre2;
    }

    public void setPer_nombre2(String per_nombre2) {
        this.per_nombre2 = per_nombre2;
    }

    public String getPer_apellido1() {
        return per_apellido1;
    }

    public void setPer_apellido1(String per_apellido1) {
        this.per_apellido1 = per_apellido1;
    }

    public String getPer_apellido2() {
        return per_apellido2;
    }

    public void setPer_apellido2(String per_apellido2) {
        this.per_apellido2 = per_apellido2;
    }

    public boolean isPer_estado() {
        return per_estado;
    }

    public void setPer_estado(boolean per_estado) {
        this.per_estado = per_estado;
    }
    
    
    
    
    
}

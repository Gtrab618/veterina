
package Modelo;

public class Mascota {
    private int mas_id;
    private String mas_nombreDue;
    private String mas_nombreMas;
    private String mas_sexo;
    private String mas_raza;
    private byte mas_foto;
    private boolean mas_estado;
    private int cli_idFK;
    
    public Mascota(){
        
    }
    public Mascota(int mas_id, String mas_nombreDue, String mas_nombreMas, String mas_sexo, String mas_raza, byte mas_foto, boolean mas_estado, int cli_idFK) {
        this.mas_id = mas_id;
        this.mas_nombreDue = mas_nombreDue;
        this.mas_nombreMas = mas_nombreMas;
        this.mas_sexo = mas_sexo;
        this.mas_raza = mas_raza;
        this.mas_foto = mas_foto;
        this.mas_estado = mas_estado;
        this.cli_idFK = cli_idFK;
    }

    public int getMas_id() {
        return mas_id;
    }

    public void setMas_id(int mas_id) {
        this.mas_id = mas_id;
    }

    public String getMas_nombreDue() {
        return mas_nombreDue;
    }

    public void setMas_nombreDue(String mas_nombreDue) {
        this.mas_nombreDue = mas_nombreDue;
    }

    public String getMas_nombreMas() {
        return mas_nombreMas;
    }

    public void setMas_nombreMas(String mas_nombreMas) {
        this.mas_nombreMas = mas_nombreMas;
    }

    public String getMas_sexo() {
        return mas_sexo;
    }

    public void setMas_sexo(String mas_sexo) {
        this.mas_sexo = mas_sexo;
    }

    public String getMas_raza() {
        return mas_raza;
    }

    public void setMas_raza(String mas_raza) {
        this.mas_raza = mas_raza;
    }

    public byte getMas_foto() {
        return mas_foto;
    }

    public void setMas_foto(byte mas_foto) {
        this.mas_foto = mas_foto;
    }

    public boolean isMas_estado() {
        return mas_estado;
    }

    public void setMas_estado(boolean mas_estado) {
        this.mas_estado = mas_estado;
    }

    public int getCli_idFK() {
        return cli_idFK;
    }

    public void setCli_idFK(int cli_idFK) {
        this.cli_idFK = cli_idFK;
    }
    
    
    
    
}

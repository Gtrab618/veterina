
package Modelo;

public class Mascota {
    private int mas_id;
    private String mas_nombreMas;
    private String mas_sexo;
    private String mas_raza;
    private String mas_especie;
    private byte[] foto;
    private String mas_estado;
    private int cli_idFK;

    public Mascota() {
    }

    public Mascota(int mas_id, String mas_nombreMas, String mas_sexo, String mas_raza, String mas_especie, byte[] foto, String mas_estado, int cli_idFK) {
        this.mas_id = mas_id;
        this.mas_nombreMas = mas_nombreMas;
        this.mas_sexo = mas_sexo;
        this.mas_raza = mas_raza;
        this.mas_especie = mas_especie;
        this.foto = foto;
        this.mas_estado = mas_estado;
        this.cli_idFK = cli_idFK;
    }

    
    
    public int getMas_id() {
        return mas_id;
    }

    public void setMas_id(int mas_id) {
        this.mas_id = mas_id;
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

    public String getMas_especie() {
        return mas_especie;
    }

    public void setMas_especie(String mas_especie) {
        this.mas_especie = mas_especie;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getMas_estado() {
        return mas_estado;
    }

    public void setMas_estado(String mas_estado) {
        this.mas_estado = mas_estado;
    }

    public int getCli_idFK() {
        return cli_idFK;
    }

    public void setCli_idFK(int cli_idFK) {
        this.cli_idFK = cli_idFK;
    }

    
    
}


package Modelo;

public class Cliente extends Persona{
     private int cli_id;
    private String cli_telefono;
    private String cli_direccion;
    private int per_idFk;
    
    public Cliente(){
        
    }

    public Cliente(int cli_id, String cli_telefono, String cli_direccion, int per_idFk) {
        this.cli_id = cli_id;
        this.cli_telefono = cli_telefono;
        this.cli_direccion = cli_direccion;
        this.per_idFk = per_idFk;
    }

    
    
    public int getPer_idFk() {
        return per_idFk;
    }

    public void setPer_idFk(int per_idFk) {
        this.per_idFk = per_idFk;
    }

    
    public int getCli_id() {
        return cli_id;
    }

    public void setCli_id(int cli_id) {
        this.cli_id = cli_id;
    }

    public String getCli_telefono() {
        return cli_telefono;
    }

    public void setCli_telefono(String cli_telefono) {
        this.cli_telefono = cli_telefono;
    }

    public String getCli_direccion() {
        return cli_direccion;
    }

    public void setCli_direccion(String cli_direccion) {
        this.cli_direccion = cli_direccion;
    }


    
            
}

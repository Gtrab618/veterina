
package Modelo;

public class Cliente extends Persona{
    private int cli_id;
    private int cli_dni;
    private int cli_telefono;
    private String cli_direccion;
    private boolean cli_estado;
    
    public Cliente(){
        
    }

    public Cliente(int cli_id, int cli_dni, int cli_telefono, String cli_direccion, boolean cli_estado, int per_id, int per_dni, String per_nombre1, String per_nombre2, String per_apellido1, String per_apellido2, boolean per_estado) {
        super(per_id, per_dni, per_nombre1, per_nombre2, per_apellido1, per_apellido2, per_estado);
        this.cli_id = cli_id;
        this.cli_dni = cli_dni;
        this.cli_telefono = cli_telefono;
        this.cli_direccion = cli_direccion;
        this.cli_estado = cli_estado;       
    }

    public int getCli_id() {
        return cli_id;
    }

    public void setCli_id(int cli_id) {
        this.cli_id = cli_id;
    }

    public int getCli_dni() {
        return cli_dni;
    }

    public void setCli_dni(int cli_dni) {
        this.cli_dni = cli_dni;
    }

    public int getCli_telefono() {
        return cli_telefono;
    }

    public void setCli_telefono(int cli_telefono) {
        this.cli_telefono = cli_telefono;
    }

    public String getCli_direccion() {
        return cli_direccion;
    }

    public void setCli_direccion(String cli_direccion) {
        this.cli_direccion = cli_direccion;
    }

    public boolean isCli_estado() {
        return cli_estado;
    }

    public void setCli_estado(boolean cli_estado) {
        this.cli_estado = cli_estado;
    }
    
    
    
    
    
            
}

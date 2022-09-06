package Control;

public class Validaciones {

    private int valicacion;

    public int valiCedula(String cedula) {
        //si la cedula es una cadena numerica
        if (cedula.matches("[0-9]{10}")) {
            
            int numero = 0, suma = 0, resultado = 0;

            for (int i = 0; i < cedula.length(); i++) {

                numero = Integer.parseInt(String.valueOf(cedula.charAt(i)));

                if (i % 2 == 0) {
                    numero = numero * 2;

                    if (numero > 9) {
                        numero = numero - 9;
                    }
                }

                suma = suma + numero;

            }
            if (suma % 10 != 0) {
                resultado = 10 - (suma % 10);

                if (resultado == numero) {
                    System.out.println("su cedula esta validada" + cedula);
                    //si la cedula es correcta
                    return 0;
                } else {
                    System.out.println("cedula invalida");
                    //si la cedula no es valida
                    return 1;
                }
            } else {
                System.out.println("su cedula esta valida" + cedula);
                return 0;
            }
            //la cedula contiene letras o no cumple con el formato
        }else{
            //si el formato de la cedula es incorrecto
            return 2;
        }

        
    }
    
    public boolean valiNombreApe(String nomAp){
        return nomAp.matches("[a-zA-z]{3,10}");
    }
}

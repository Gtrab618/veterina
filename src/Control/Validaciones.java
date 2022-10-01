package Control;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JOptionPane;

public class Validaciones {

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
                    
                    //si la cedula es correcta
                    return 0;
                } else {
                    
                    //si la cedula no es valida
                    return 1;
                }
            } else {
                
                return 0;
            }
            //la cedula contiene letras o no cumple con el formato
        } else {

            return 2;
        }

    }


    public int valiNombreV2(String cadena2){
        
        
        if (cadena2.matches("[A-Za-zÑñáéíúóÁÉÍÓÚ]{1,50}")) {
            if (cadena2.length()<= 2  || cadena2.length()>15) {
                //logitud corta
                return 1;
            }else{
                
                //correcto
                return 0;
                
            }
        }else{
            
            //error formato
            return 2;
            
        }
        
    }
    
    //validar nombre separado
    public int valiNombreSepV2(String cadena2){
        
        
        if (cadena2.matches("[A-Za-zÑñáéíúóÁÉÍÓÚ]{1,25}[\\s]{0,1}[A-Za-zÑñáéíúóÁÉÍÓÚ]{0,25}")) {
            if (cadena2.length()<= 2  || cadena2.length()>20) {
                //logitud corta
                return 1;
            }else{
                
                //correcto
                return 0;
                
            }
        }else{
            
            //error formato
            return 2;
            
        }
        
    }
    
    public int valiNumTelefono(String tel) {

        if (tel.matches("[+-]?\\d*(\\.\\d+)?")) {

            if (tel.matches("[0-9]{10}") || tel.matches("[0-9]{7}") || tel.matches("[0-9]{9}")) {
                return 0;

            } else {
               
                return 1;
            }
        } else {
            return 2;
        }

    }
    
    public boolean valiDirec(String nomAp) {
        return nomAp.length()>4;
    }
 
    public boolean valiString(String cadena){
        return cadena.matches("[a-zA-z]{3,15}[\\s]{0,1}[a-zA-z]{0,15}");
    }
    
    //---------------------------------------------------------------------------------------
    //validar de la fecha de nacimiento es anterior a la actual para calcular la edad
//    public boolean validarFechaNac(Date fechaNac){
//
//            return fechaNac.before(Date.from(Instant.now()));
//       
//    }
    
    
    //Pasar la edad a años
    public String calcularEdad(Date fechaN){
                String edad;
      
                LocalDate fechaNac =fechaN.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

                Period periodo = Period.between(fechaNac, LocalDate.now());
                
                edad = "Años: "+periodo.getYears()+" Meses: "+ periodo.getMonths()+" Dias: "+ periodo.getDays()+" ";
                //coloca debajo de cada uno el año gracias a %s
//                 System.out.printf("Tu edad es: %s años, %s meses y %s días",
//                        periodo.getYears(), periodo.getMonths(), periodo.getDays());
               
                
           return edad;
    }
}

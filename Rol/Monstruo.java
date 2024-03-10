package Rol;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 * Esta es la clase Monstruo, una clase para representar los mobs y jefes enemigos a los que enfrentaran las clases jugables, definidos en
 * tipos por sus razas, que son las especies.
 * @author Javier Moreno Cuadra
 * @version 1.2.1
 * @see : Hereda de la superclase Personaje que hereda de GammerLogger
 */
public class Monstruo extends Personaje{

    public Monstruo(){
        super();
    }

    public Monstruo(String nombre, String raza, boolean estado){
        super(nombre, raza, estado);
    }
    /**
     * Sobreescrito para el nombre de esta clase
     * @return Retorna el nombre de clase para usarlo en documentacion generada
     */
    public static String classname(){
        return "Monstruo";
    }

    public void setRaza(String raza){
       switch (raza){
           case"Bestia":
               setFuerza(getNivel()*2);
               setAgilidad(getNivel()*2);
               setVidabase((int) (getVidabase() + getVidabase() * 0.1));
               setArmadura(getNivel()/2);
               setMagicresist(getNivel()/2);
               break;
           case"No-muerto":
               setFuerza(getNivel());
               setAgilidad(getNivel()/4);
               setVidabase((int) (getVidabase() + (getVidabase() * 0.1))/2);
               setArmadura(getNivel()/2);
               setMagicresist(getNivel()*4);
               break;
           case"Gigante":
               setFuerza(getNivel()*4);
               setAgilidad(getNivel()/4);
               setVidabase((int) (getVidabase() + getVidabase() * 0.1)*4);
               setArmadura(getNivel());
               setMagicresist(getNivel()/4);
               break;
           default:
               break;
       }
    }
    /**
     * Metodo subirNivel sobreescrito a las necesidades de la clase monstruo.
     */
    public void subirNivel(){
        System.out.println("Los mobs no suben de nivel, tienen uno establecido");
    }
    /**
     * Metodo toString sobreescrito a las necesidades de la clase monstruo.
     */

    public String toString(){
        String resultado;
        resultado = "Ficha del "+classname()+" "+ getNombre()+".\n" +
                "Nombre: " +getNombre()+ ".\n" +
                "Clase: "+classname()+".\n" +
                "Raza: "+getRaza()+".\n" +
                "\n"+
                "Nivel: "+getNivel()+".\n"+
                "Vida: "+getVidabase()+".\n"+
                "Ataque: "+getFuerza()+".\n"+
                "Velocidad: "+getAgilidad()+".\n"+
                "Armadura: "+getArmadura()+".\n"+
                "Resistencia mágica: "+getMagicresist()+".\n"+
                "\n"+
                "Está actualmente: "+comprobarVida();
        return resultado;
    }

}

package Rol;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 * Esta es la clase Ladron, un tipo de personaje con valores estandar de personaje.
 * @author Javier Moreno Cuadra
 * @version 1.2.1
 * @see : Hereda de la superclase Personaje que hereda de GammerLogger
 */
public class Ladron extends Personaje{

    public Ladron(){
        super();
    }

    public Ladron(String nombre, String raza, boolean estado){
        super(nombre, raza, estado);
    }
    /**
     * Sobreescrito para el nombre de esta clase
     * @return Retorna el nombre de clase para usarlo en documentacion generada
     */
    public static String classname(){
        return "Ladron";
    }
    /**
     * Metodo subirNivel sobreescrito a las necesidades de la clase ladron.
     */
    public void subirNivel() {
        setNivel(getNivel() + 1);
        if (Math.random() < 0.85) {
            setAgilidad(getAgilidad() + getNivel() * 2);
        }
        if (Math.random() < 0.6) {
            setFuerza(getFuerza() + getNivel());
        }
        if (Math.random() < 0.4) {
            setMagicresist(getMagicresist() + getNivel());
        }
        if (Math.random() < 0.4) {
            setVidabase((int) (getVidabase() + getVidabase() * 0.1));
        }
        if (Math.random() < 0.4) {
            setArmadura(getArmadura() + getNivel());
        }
    }

    public int robar(Personaje pj){
        int ataque=getAgilidad()-pj.getArmadura();
        pj.setVidabase(pj.getVidabase()-ataque);
        return pj.getVidabase();
    }


    /**
     * Metodo toString sobreescrito a las necesidades de la clase ladron.
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

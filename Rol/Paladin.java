package Rol;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 * Esta es la clase Paladin, un tipo de personaje físico con un valor de fé que usa la esquizofrenia para generar poderes.
 * @author Javier Moreno Cuadra
 * @version 1.2.1
 * @see : Hereda de la superclase Creyente que hereda de la superclase Personaje que hereda de GammerLogger
 */
public class Paladin extends Creyente {
    /**
     * Este metodo constructor por defecto, ha sido sobreescrito para incluir el atributo fe.
     * @see : Heredado de la clase Personaje.
     */
    public Paladin(){
        super();
    }
    /**
     * Este metodo constructor con parematros, usa los siguientes parametros para asignar nombre, raza y estado y esta
     * sobreescrito para incluir la fe.
     * @param nombre Usado para asignar un nombre al personaje. Tipo String.
     * @param raza Usado para asignar una raza al personaje Tipo String.
     * @param estado Usado para comprobar si esta vivo o muerto. Tipo boolean.
     */
    public Paladin(String nombre, String raza, boolean estado){
        super(nombre, raza, estado);
    }
    /**
     * Sobreescrito para el nombre de esta clase
     * @return Retorna el nombre de clase para usarlo en documentacion generada
     */
    public static String classname(){
        return "Paladin";
    }
    /**
     * Metodo subirNivel sobreescrito a las necesidades de la clase paladin.
     */
    public void subirNivel() {
        setNivel(getNivel() + 1);
        if (Math.random() < 0.15) {
            setAgilidad(getAgilidad() + getNivel()/4);
        }
        if (Math.random() < 0.6) {
            setFuerza(getFuerza() + getNivel());
        }
        if (Math.random() < 0.5) {
            setMagicresist(getMagicresist() + getNivel());
        }
        if (Math.random() < 0.5) {
            setVidabase((int) (getVidabase() + getVidabase() * 0.15));
        }
        if (Math.random() < 0.7) {
            setArmadura(getArmadura() + getNivel()*2);
        }
        if (Math.random() < 0.3) {
            setFe(getFe()+getNivel());
        }
    }

    public void plegaria(int spell, Personaje pj) {
        switch (spell) {
            case (1):
                pj.setFuerza((int) (pj.getFuerza() + getFe() * 0.8));
                break;
            case (2):
                setArmadura((int) (getArmadura() + getFe() * 0.3));
                break;
            default:
                break;
        }
    }

    public int apoyar(int spell, Personaje pj){
        switch (spell) {
            case (1):
                pj.setFuerza((int) (pj.getFuerza() + getFe() * 0.8));
                return pj.getFuerza();
            case (2):
                setArmadura((int) (getArmadura() + getFe() * 0.3));
                return getArmadura();
            default:
                break;
        }
        return 0;
    }

    /**
     * Metodo toString sobreescrito a las necesidades de la clase paladin.
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
                "Fe: "+getFe()+".\n"+
                "\n"+
                "Está actualmente: "+comprobarVida();
        return resultado;
    }

}

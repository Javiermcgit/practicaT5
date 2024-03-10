package Rol;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 * Esta es la clase Mago, un tipo de personaje con una estadistica única magica de intelecto, que le permite usar hechizos en base a ella.
 * @author Javier Moreno Cuadra
 * @version 1.2.1
 * @see : Hereda de la superclase Personaje que hereda de GammerLogger
 */
public class Mago extends Personaje {
    private int intelecto;

    /**
     * Este metodo constructor por defecto, ha sido sobreescrito para incluir el atributo intelecto.
     * @see : Heredado de la clase Personaje.
     */
    public Mago() {
        super();
        intelecto = 10;
    }
    /**
     * Este metodo constructor con parematros, usa los siguientes parametros para asignar nombre, raza y estado y esta
     * sobreescrito para incluir el intelecto.
     * @param nombre Usado para asignar un nombre al personaje. Tipo String.
     * @param raza Usado para asignar una raza al personaje Tipo String.
     * @param estado Usado para comprobar si esta vivo o muerto. Tipo boolean.
     */
    public Mago(String nombre, String raza, boolean estado) {
        super(nombre, raza, estado);
        intelecto = 10;

    }
    /**
     * Sobreescrito para el nombre de esta clase
     * @return Retorna el nombre de clase para usarlo en documentacion generada
     */
    public static String classname(){
        return "Mago";
    }
    /**
     * Getter del intelecto tipo int.
     * @return retorna int de intelecto
     */
    public int getIntelecto() {
        return intelecto;
    }
    /**
     * Setter de intelecto tipo int.
     * @param intelecto  para dar un valor al parametro intelecto
     */
    public void setIntelecto(int intelecto) {
        this.intelecto = intelecto;
    }
    /**
     * Metodo subirNivel sobreescrito a las necesidades de la clase mago.
     */
    public void subirNivel() {
        setNivel(getNivel() + 1);
        if (Math.random() < 0.9) {
            setIntelecto(getIntelecto() + getNivel());
        }
        if (Math.random() < 0.65) {
            setAgilidad(getAgilidad() + getNivel());
        }
        if (Math.random() < 0.15) {
            setFuerza(getFuerza() + getNivel() / 4);
        }
        if (Math.random() < 0.8) {
            setMagicresist(getMagicresist() + getNivel());
        }
        if (Math.random() < 0.35) {
            setVidabase((int) (getVidabase() + (getVidabase() * 0.1) / 2));
        }
        if (Math.random() < 0.35) {
            setArmadura(getArmadura() + getNivel() / 2);
        }
    }

    public void lanzarConjuro(int spell, Personaje pj) {
        switch (spell) {
            case (1):
                int fireball = (int) (getIntelecto() * 0.7);
                pj.setVidabase(pj.getVidabase()-fireball);
                break;
            case (2):
                pj.setArmadura((int) (pj.getArmadura() + getArmadura() * 0.5));
                pj.setMagicresist((int) (pj.getMagicresist() + getMagicresist() * 0.5));
                break;
            case (3):
                int arcaneblast = (int) (getIntelecto() * 0.3);
                pj.setVidabase(pj.getVidabase()-arcaneblast);
                break;
            case (4):
                pj.setAgilidad(pj.getAgilidad() + getIntelecto());
                break;
            default:
                break;


        }
    }

    public int luchar(int spell, Personaje pj) {
        switch (spell){
        case(1):
            int fireball = (int) ((getIntelecto() * 0.7)-pj.getMagicresist());
            pj.setVidabase(pj.getVidabase()-fireball);
            return pj.getVidabase();
        case (3):
            int arcaneblast = (int) ((getIntelecto() * 0.3)-pj.getMagicresist());
            pj.setVidabase(pj.getVidabase()-arcaneblast);
            return pj.getVidabase();
        default:
            int daño=pj.getFuerza()-getArmadura();
            pj.setVidabase(pj.getVidabase()-daño);
            return pj.getVidabase();
        }
    }

    public int[] apoyar(int spell, Personaje pj){
        int [] buffs=new int[2];
        switch (spell) {
            case (2):
                pj.setArmadura((int) (pj.getArmadura() + getArmadura() * 0.5));
                pj.setMagicresist((int) (pj.getMagicresist() + getMagicresist() * 0.5));
                buffs[0]=pj.getArmadura();
                buffs[1]=pj.getMagicresist();
                break;
            case (4):
                pj.setAgilidad(pj.getAgilidad() + getIntelecto());
                buffs[0]=pj.getAgilidad();
                break;
            default:
                break;
        }
        return buffs;
    }
    /**
     * Metodo toString sobreescrito a las necesidades de la clase mago.
     */

    public String toString() {
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
                "Intelecto: "+getIntelecto()+".\n"+
                "\n"+
                "Está actualmente: "+comprobarVida();
        return resultado;
    }
}

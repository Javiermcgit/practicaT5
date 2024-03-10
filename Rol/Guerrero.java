package Rol;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 * Esta es la clase Guerrero, un tipo de personaje con estadistica extra de furia que afecta a su capacidad de recibir e infligir daño.
 * @author Javier Moreno Cuadra
 * @version 1.2.1
 * @see : Hereda de la superclase Personaje que hereda de GammerLogger
 */
public class Guerrero extends  Personaje {
    private boolean furia;
    /**
     * Este metodo constructor por defecto, ha sido sobreescrito para incluir el atributo furia.
     * @see : Heredado de la clase Personaje.
     */
    public Guerrero() {
        super();
        furia = false;
    }
    /**
     * Este metodo constructor con parematros, usa los siguientes parametros para asignar nombre, raza y estado y esta
     * sobreescrito para incluir la furia.
     * @param nombre Usado para asignar un nombre al personaje. Tipo String.
     * @param raza Usado para asignar una raza al personaje Tipo String.
     * @param estado Usado para comprobar si esta vivo o muerto. Tipo boolean.
     */
    public Guerrero(String nombre, String raza, boolean estado, boolean furia) {
        super(nombre, raza, estado);
        this.furia = furia;


    }
    /**
     * Sobreescrito para el nombre de esta clase
     * @return Retorna el nombre de clase para usarlo en documentacion generada
     */
    public static String classname(){
        return "Guerrero";
    }
    /**
     * Setter de la furia tipo boolean.
     * @return retorna boolean de furia
     */
    public void getFuria(){
        this.furia=furia;
    }
    /**
     * Setter de la furia tipo boolean
     * @param : furia para dar un valor al parametro furia.
     */
    public boolean setFuria() {
        return furia;
    }

    public String fury(){
        if(furia){
            return "furioso.";
        }else{
            return "calmado";
        }
    }
    /**
     * Metodo subirNivel sobreescrito a las necesidades de la clase guerrero.
     */
    public void subirNivel() {
        setNivel(getNivel() + 1);
        if (Math.random() < 0.5) {
            setAgilidad(getAgilidad() + getNivel());
        }
        if (Math.random() < 0.8) {
            setFuerza(getFuerza() + getNivel()*2);
        }
        if (Math.random() < 0.2) {
            setMagicresist(getMagicresist() + getNivel()/2);
        }
        if (Math.random() < 0.75) {
            setVidabase((int) (getVidabase() + getVidabase() * 0.1));
        }
        if (Math.random() < 0.75) {
            setArmadura(getArmadura() + getNivel());
        }
    }

    public int luchar(Personaje pj) {
        if (furia) {
            int ataque = (getFuerza()-pj.getArmadura()) * 2;
            pj.setVidabase(pj.getVidabase()-ataque);
            return pj.getVidabase();
        } else {
            int ataque = getFuerza()-pj.getArmadura();
            pj.setVidabase(pj.getVidabase()-ataque);
            return pj.getVidabase();
        }
    }

    public void defender(int daño, String tipodaño, Personaje pj){
        tipodaño=tipodaño.toLowerCase();
        switch(tipodaño){
            case"fisico":
                daño=pj.getFuerza()-getArmadura();
                if(furia) {
                    setVidabase(getVidabase() - daño * 2);
                }else{
                    setVidabase(getVidabase()-daño);
                }
                break;
            case"magico":
                daño=pj.getFuerza()-getMagicresist();
                if(furia) {
                    setVidabase(getVidabase() - daño * 2);
                }else{
                    setVidabase(getVidabase()-daño);
                }
                break;
            default:
                break;
        }
    }
    /**
     * Metodo toString sobreescrito a las necesidades de la clase guerrero.
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
                "Su nivel de ira es "+fury()+"\n"+
                "\n"+
                "Está actualmente: "+comprobarVida();
        return resultado;
    }
}


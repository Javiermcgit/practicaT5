package Rol;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 * Esta es la clase Priest, un tipo de personaje mágico con un valor de fé que usa la esquizofrenia para generar poderes.
 * @author Javier Moreno Cuadra
 * @version 1.2.1
 * @see : Hereda de la superclase Creyente que hereda de la superclase Personaje que hereda de GammerLogger
 */
public class Priest extends Creyente{

    public Priest(){
        super();
    }

    public Priest(String nombre, String raza, boolean estado){
        super(nombre, raza, estado);
    }
    /**
     * Sobreescrito para el nombre de esta clase
     * @return Retorna el nombre de clase para usarlo en documentacion generada
     */
    public static String classname(){
        return "Priest";
    }
    /**
     * Metodo subirNivel sobreescrito a las necesidades de la clase priest.
     */

    public void subirNivel() {
        setNivel(getNivel() + 1);
        if (Math.random() < 0.5) {
            setAgilidad(getAgilidad() + getNivel());
        }
        if (Math.random() < 0.1) {
            setFuerza(getFuerza() + getNivel()/4);
        }
        if (Math.random() < 0.8) {
            setMagicresist(getMagicresist() + getNivel()*2);
        }
        if (Math.random() < 0.2) {
            setVidabase((int) (getVidabase() + (getVidabase() * 0.1)/2));
        }
        if (Math.random() < 0.2) {
            setArmadura(getArmadura() + getNivel()/2);
        }
        if (Math.random() < 0.8) {
            setFe(getFe()+getNivel()*2);
        }
    }



    public void plegaria(int spell, Personaje pj){
        switch (spell) {
            case (1):
                pj.setVidabase((int) (pj.getVidabase() + getFe() * 0.7));
                break;
            case (2):
                pj.setVidabase((int) (pj.getVidabase() + getFe() * 0.35));
                break;
            case(3):
                int colerasagrada=(int) ((getFe()*0.55)-pj.getMagicresist());
                pj.setVidabase(pj.getVidabase()-colerasagrada);
                break;
            default:
                break;
        }
    }

    public int luchar(int spell, Personaje pj) {
        switch (spell){
            case (3):
                int colerasagrada=(int) ((getFe()*0.55)-pj.getMagicresist());
                pj.setVidabase(pj.getVidabase()-colerasagrada);
                return pj.getVidabase();
            default:
                int daño=pj.getFuerza()-getArmadura();
                pj.setVidabase(pj.getVidabase()-daño);
                return pj.getVidabase();
        }
    }

    public int apoyar(int spell, Personaje pj) {
        switch (spell) {
            case (1):
                pj.setVidabase((int) (pj.getVidabase() + getFe() * 0.7));
                return pj.getVidabase();
            case (2):
                pj.setVidabase((int) (pj.getVidabase() + getFe() * 0.35));
                return pj.getVidabase();
            default:
                break;
        }
        return 0;
    }
    /**
     * Metodo toString sobreescrito a las necesidades de la clase priest.
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




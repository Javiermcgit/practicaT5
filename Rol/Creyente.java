package Rol;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 * Esta es la clase creyente, una clase abstracta padre de la que heredan las clases paladin y priest peculiaridades y metodos.
 * @author Javier Moreno Cuadra
 * @version 1.2.1
 * @see : Hereda de la superclase Personaje que hereda de GammerLogger
 */
public abstract class Creyente extends Personaje {

    private int fe;
    /**
     * Este metodo constructor por defecto, ha sido sobreescrito para incluir el atributo fe.
     * @see : Heredado de la clase Personaje.
     */
    public Creyente(){
        super();
        fe=10;
    }
    /**
     * Este metodo constructor con parematros, usa los siguientes parametros para asignar nombre, raza y estado y esta
     * sobreescrito para incluir la fe.
     * @param nombre Usado para asignar un nombre al personaje. Tipo String.
     * @param raza Usado para asignar una raza al personaje Tipo String.
     * @param estado Usado para comprobar si esta vivo o muerto. Tipo boolean.
     */
    public Creyente(String nombre, String raza, boolean estado){
        super(nombre, raza, estado);
        fe=10;
    }

    /**
     * Getter de la fe tipo int.
     * @return retorna int de la fe
     */
    public int getFe() {
        return fe;
    }

    /**
     * Setter de la fe tipo int
     * @param fe para dar un valor al parametro fe.
     */
    public void setFe(int fe) {
        this.fe = fe;
    }

    public abstract void plegaria(int spell, Personaje pj);



    /**
     * Metodo toString sobreescrito a las necesidades de la clase creyente.
     */
    public String toString() {
        return "El creyente se llama " + super.toString() +"tiene fe:"+ fe;
    }
}

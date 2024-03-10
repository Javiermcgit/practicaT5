package Rol;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 * Esta es la clase Cazador, un tipo de personaje con valores estandar de personaje que una subclase pet anidada como mascota.
 * @author Javier Moreno Cuadra
 * @version 1.2.1
 * @see : Hereda de la superclase Personaje que hereda de GammerLogger
 */
public class Cazador extends Personaje{

    public Cazador(){
        super();
    }

    public Cazador(String nombre, String raza, boolean estado){
        super(nombre, raza, estado);
    }
    /**
     * Sobreescrito para el nombre de esta clase
     * @return Retorna el nombre de clase para usarlo en documentacion generada
     */
    public static String classname(){
        return "Cazador";
    }

    /**
     * Metodo subirNivel sobreescrito a las necesidades de la clase cazador.
     */
    public void subirNivel() {
        setNivel(getNivel() + 1);
        if (Math.random() < 0.7) {
            setAgilidad(getAgilidad() + getNivel());
        }
        if (Math.random() < 0.5) {
            setFuerza(getFuerza() + getNivel());
        }
        if (Math.random() < 0.5) {
            setMagicresist(getMagicresist() + getNivel());
        }
        if (Math.random() < 0.5) {
            setVidabase((int) (getVidabase() + getVidabase() * 0.1));
        }
        if (Math.random() < 0.5) {
            setArmadura(getArmadura() + getNivel());
        }
    }

    public int luchar(Personaje pj, pet mascota){
        int ataque=getFuerza()+mascota.getFuerza()-pj.getArmadura();
        pj.setVidabase(pj.getVidabase()-ataque);
        return pj.getVidabase();
    }
    /**
     * Metodo toString sobreescrito a las necesidades de la clase cazador.
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
    /**
     * Esta es la subclase de cazador pet, una mascota para el cazador con sus propios escalados propios para ayudar a su amo.
     * @author Javier Moreno Cuadra
     * @version 1.2.1
     * @see : Hereda de la clase a la que está anidada Cazador que hereda de la superclase Personaje que hereda de GammerLogger
     */
    public class pet extends Personaje{
        public pet(){
            super();
        }
        public pet(String nombre, String raza, boolean estado){
            super(nombre, raza, estado);
        }

        /**
         * Sobreescrito para el nombre de esta clase
         * @return Retorna el nombre de clase para usarlo en documentacion generada
         */
        public static String classname(){
            return "Mascota";
        }
        /**
         * Metodo subirNivel sobreescrito a las necesidades de la subclase anidada pet, mascota del cazador.
         */
    public void subirNivel() {
        Cazador pj=new Cazador();
        setNivel(pj.getNivel());
    }

        /**
         * Setter de la raza de la mascota, que ha sido sobreescrito para tener en cuenta las especies animales,
         * que escalan con diferentes estadísticas.
         * @param raza Si el jugador no infringe esta norma, podra establecer el nombre de su raza.
         * @throws : Sino cumple con una de las 3 razas, se le denegara el poder establecerla.
         */
        public void setRaza(String raza){
            Cazador pj=new Cazador();
            switch (raza){
                case"Canido":
                    setFuerza((int) (pj.getFuerza()*0.2));
                    setAgilidad((int) (pj.getAgilidad()*0.2));
                    setVidabase((int) (pj.getVidabase()*0.2));
                    setArmadura((int) (pj.getArmadura()*0.2));
                    setMagicresist((int) (pj.getMagicresist()*0.2));
                    break;
                case"Felino":
                    setFuerza((int) (pj.getFuerza()*0.3));
                    setAgilidad((int) (pj.getAgilidad()*0.3));
                    setVidabase((int) (pj.getVidabase()*0.15));
                    setArmadura((int) (pj.getArmadura()*0.15));
                    setMagicresist((int) (pj.getFuerza()*0.15));
                    break;
                case"Rapaz":
                    setFuerza((int) (pj.getFuerza()*0.15));
                    setAgilidad((int) (pj.getAgilidad()*0.35));
                    setVidabase((int) (pj.getVidabase()*0.05));
                    setArmadura((int) (pj.getArmadura()*0.05));
                    setMagicresist((int) (pj.getMagicresist()*0.25));
                    break;
                default:
                    break;
            }
        }
        /**
         * Metodo toString sobreescrito a las necesidades de la subclase pet, mascota del cazador.
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

}

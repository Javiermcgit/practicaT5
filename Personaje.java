package Rol;
/**
 * Esta es la clase Personaje, y su función es ser la superclase que agrupe los diferentes metodos que usaran sus clases hijas
 * de tipos de personajes.
 * @author Javier Moreno Cuadra
 * @version 1.2.1
 * @see : Hereda de la superclase GammerLogger
 */
public abstract class Personaje extends GameLoggger {
    private String nombre, raza;
    private int nivel;
    private int vidabase;
    private int fuerza;
    private int agilidad;
    private int armadura;
    private int magicresist;
    private boolean estado;

    /**
     * Este metodo constructor por defecto, establece unas variables predeterminadas estandar que servirán para sus clases hijas.
     */
    public Personaje() {
        nombre = "";
        raza = "";
        nivel = 1;
        vidabase = 100;
        fuerza = 10;
        agilidad = 10;
        armadura=10;
        magicresist = 10;
    }
    /**
     * Este metodo constructor con parematros, usa los siguientes parametros para asignar nombre, raza y estado.
     * @param nombre Usado para asignar un nombre al personaje. Tipo String.
     * @param raza Usado para asignar una raza al personaje Tipo String.
     * @param estado Usado para comprobar si esta vivo o muerto. Tipo boolean.
     */
    public Personaje(String nombre, String raza, boolean estado) {
        this.nombre = nombre;
        this.raza = raza;
        this.estado = estado;
        nivel = 1;
        vidabase = 100;
        fuerza = 10;
        agilidad = 10;
        armadura=10;
        magicresist = 10;
    }

    /**
     * Getter del nombre tipo String.
     * @return retorna String del nombre
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Getter de la raza tipo String.
     * @return retorna String de la raza
     */
    public String getRaza() {
        return raza;
    }
    /**
     * Getter del estado tipo Boolean.
     * @return retorna Boolean del estado
     */
    public boolean getEstado() {
        return estado;
    }
    /**
     * Getter del nivel tipo int.
     * @return retorna int del nivel
     */
    public int getNivel() {
        return nivel;
    }
    /**
     * Getter de la vidabase tipo int.
     * @return retorna int del vidabase
     */
    public int getVidabase() {
        return vidabase;
    }
    /**
     * Getter de la fuerza tipo int.
     * @return retorna int del fuerza
     */
    public int getFuerza() {
        return fuerza;
    }
    /**
     * Getter de la agilidad tipo int.
     * @return retorna int del agilidad
     */
    public int getAgilidad() {
        return agilidad;
    }
    /**
     * Getter de la armadura tipo int.
     * @return retorna int del armadura
     */
    public int getArmadura() {
        return armadura;
    }
    /**
     * Getter de la magicresist tipo int.
     * @return retorna int del magicresist
     */
    public int getMagicresist() {
        return magicresist;
    }

    /**
     * Metodo que obliga al jugador a que su nombre sea como minimo de 4 longitud.
     * @param nombre Si el jugador no infringe esta norma, podra establecer un nombre para su personaje.
     */

    public void setNombre(String nombre) {
        nombre = nombre.toLowerCase().trim();
        if (nombre.length() >= 4) {
            this.nombre = nombre;
        } else {
            this.nombre="";
        }

    }

    /**
     * Metodo limitador que limita las mayusculas para una comprobacion en la cual si existe angel o demonio, no se
     * le permite al jugador establecerlo.
     * @param raza Si el jugador no infringe esta norma, podra establecer el nombre de su raza.
     */
    public void setRaza(String raza) {
        raza= raza.toLowerCase();
        if((raza.equals("angel"))||(raza.equals("demonio"))){
            raza="";
        }
        this.raza = raza;
    }

    /**
     * Setter de estado, que usa la variable boolean estado
     * @see : comprobarvida es un metodo relacionado con este, para mayor claridad del estado del personaje.
     */
    public void setEstado() {
        this.estado=estado;

    }
    /**
     * Setter de la nivel tipo int
     * @param nivel para dar un valor al parametro nivel.
     */
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    /**
     * Setter de la vidabase tipo int
     * @param vidabase para dar un valor al parametro vidabase.
     */
    public void setVidabase(int vidabase) {
        this.vidabase = vidabase;
    }
    /**
     * Setter de la fuerza tipo int
     * @param fuerza para dar un valor al parametro fuerza.
     */
    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }
    /**
     * Setter de la agilidad tipo int
     * @param agilidad para dar un valor al parametro agilidad.
     */
    public void setAgilidad(int agilidad) {
        this.agilidad = agilidad;
    }
    /**
     * Setter de la armadura tipo int
     * @param armadura para dar un valor al parametro armadura.
     */
    public void setArmadura(int armadura) {
        this.armadura = armadura;
    }
    /**
     * Setter de la magicresist tipo int
     * @param magicresist para dar un valor al parametro magicresist.
     */
    public void setMagicresist(int magicresist) {
        this.magicresist = magicresist;
    }

    /**
     * Metodo simple para en base a la variable estado, informar con  un String si esta vivo o muerto el personaje.
     * @return Retorna un String que nos dice si esta vivo o muerto el personaje.
     */
    public String comprobarVida(){
        if (estado) {
            return "viv@.";

        } else {
            return "muert@.";
        }
    }
    /**
    * Esta clase es abstracta para usarla en las diferentes clases con sus normas de escalado concretos
    */
    public abstract void subirNivel();

    /**
     * Prototipo de metodo fallido que deberá morir entre terribles sufrimientos.
     * Ignoren las subversiones y sobreescrituras de esta mierda.
     * @param pj Irrelevante
     * @return Irrelevante
     * @deprecated Debe desaparecer
     */
    public int luchar(Personaje pj){
        int ataque=getFuerza()-pj.getArmadura();
        pj.setVidabase(pj.getVidabase()-ataque);
        return pj.getVidabase();
    }
    /**
     * Prototipo de metodo fallido que deberá morir entre terribles sufrimientos.
     * Ignoren las subversiones y sobreescrituras de esta mierda.
     * @param pj Irrelevante
     * @return Irrelevante
     * @deprecated Debe desaparecer
     */
    public void defender(int daño, String tipodaño, Personaje pj){
        tipodaño=tipodaño.toLowerCase();
        switch(tipodaño){
            case"fisico":
                daño=pj.getFuerza()-getArmadura();
                setVidabase(getVidabase()-daño);
                break;
            case"magico":
                daño=pj.getFuerza()-getMagicresist();
                setVidabase(getVidabase()-daño);
                break;
            default:
                break;
        }
    }

    /**
     * Este metodo es usado para poder escribir el nombre concreto de una clase en el documento generado
     * @return Retorna un String con el nombre de la clase, en esta caso no habria clase.
     */
    public static String classname(){
        return "Personaje sin clase";
    }

    /**
     * Es un metodo toString donde usamos una variable también String resultado cuya funcion es la de ayudarnos
     * a escribir el documento de una clase con sus diferentes datos y estadisticas.
     * @return Retorna el resultado con todos los datos tipo String que queremos en el documento con su formato de espaciado.
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





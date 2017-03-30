package pe.gob.mtpe.retorno.bean;

import java.io.Serializable;

/**
 * Bean que almacena todos los atributos del Menu Padre de cada Sistema.
 */
public class MenuPadre implements Serializable {
    
    /**
     * (String)Atributo que almacena el Nivel del menu.(0=Padre)
     */
    public String n_orden;
    /**
     * (String)Atributo que almacena el codigo del Menu.
     */
    public String v_menu;
    /**
     * (String)Atributo que almacena la descripcion(nombre) del Menu.
     */
    public String men_padre;
    /**
     * (String)Atributo que almacena el nombre de la imagen del menu.
     */
    public String v_icono;
    
    
    
    /**
     * @return the men_padre
     */
    public String getMen_padre() {
        return men_padre;
    }
    
    
    
    /**
     * @param men_padre the men_padre to set
     */
    public void setMen_padre(String men_padre) {
        this.men_padre = men_padre;
    }
    
    
    
    /**
     * @return the n_orden
     */
    public String getN_orden() {
        return n_orden;
    }
    
    
    
    /**
     * @param n_orden the n_orden to set
     */
    public void setN_orden(String n_orden) {
        this.n_orden = n_orden;
    }
    
    
    
    /**
     * @return the v_icono
     */
    public String getV_icono() {
        return v_icono;
    }
    
    
    
    /**
     * @param v_icono the v_icono to set
     */
    public void setV_icono(String v_icono) {
        this.v_icono = v_icono;
    }
    
    
    
    /**
     * @return the v_menu
     */
    public String getV_menu() {
        return v_menu;
    }
    
    
    
    /**
     * @param v_menu the v_menu to set
     */
    public void setV_menu(String v_menu) {
        this.v_menu = v_menu;
    }
    
    
    
    /**
     * Metodo que imprime los datos que contiene el Bean.
     */
    public String toString() {
        String cadena = null;
        cadena = "\n";
        cadena += " \tINFO - MenuPadreBean : (String)n_orden => "+n_orden+"\n";
        cadena += " \tINFO - MenuPadreBean : (String)v_menu => "+v_menu+"\n";
        cadena += " \tINFO - MenuPadreBean : (String)men_padre => "+men_padre+"\n";
        cadena += " \tINFO - MenuHijoBean : (String)v_icono => "+v_icono+"\n";  
        return cadena;
    }
    
    
}

package ProjectCode.modelo;


import java.util.Scanner;

import ProjectCode.modelo.C0_Seguro.tipoSeguro;
import ProjectCode.vista.A_MenuInicial;

import java.util.ArrayList;
/**
 *
 * La clase SocioEstandar representa un Socio Estandar que hereda de la clase Padre Socio, con atributos propios nif
 * y tiene una relación de composición con la clase Seguro  *
 *
 *@author ProjectCode
 *@version 1.0
 */
public class B1_SocioEstandar extends B0_Socio {

    private double DES_CUOTA_MENSUAL=1;
    private int cuota=100;
    private String nif;
    private C0_Seguro seguro;
    private static ArrayList<B1_SocioEstandar> SociosEstandar = new ArrayList<>();


    /**
     *
     * @param numSocio El número del Socio Estandar.
     * @param nombre   El nombre del Socio Estandar.
     * @param nif      El nif del Socio Estandar.
     *
     */

    public B1_SocioEstandar(int numSocio, String nombre, String nif, C0_Seguro seguro) {

        super(numSocio, nombre);
        this.nif = nif;
        this.seguro = seguro;
        SociosEstandar.add(this);
    }


    public B1_SocioEstandar() {

    }

    /**
     * Obtiene el nif del Socio Estandar.
     *
     * @return El nif del Socio Estandar.
     */

    public String getNif() {
        return nif;
    }

    /**
     * Establece el nif del Socio Estandar.
     *
     * @param nif El nif del Socio Estandar.
     */

    public void setNif(String nif) {
        this.nif = nif;
    }

    /**
     * Obtiene el seguro del socio Estandar.
     *
     * @return El seguro del socio Estandar.
     */

    public C0_Seguro getSeguro() {
        return seguro;
    }

    /**
     * Muestra por pantalla el Socio Estandar con el seguro.
     *
     * @return Muestra por pantalla el Socio Estandar con el seguro.
     */

    public void setCuota(int cuota){
    this.cuota=cuota;

    }

    public int getCuota(){
        return cuota;   

    }


    public void setDescuento(double DES_CUOTA_MENSUAL){
        this.DES_CUOTA_MENSUAL=DES_CUOTA_MENSUAL;
    
        }
    
        public double getDescuento(){
            return DES_CUOTA_MENSUAL;   
    
        }



    @Override
    public String toString() {
        return " \n  DATOS ESENCIALES:" 
        + "\n       - Numero socio: " +getNumSocio()
        + "\n       - Nombre: " + getNombre()
        + "\n       - Nif: " + getNif()
        + "\n  DATOS SEGURO"
        + getSeguro();
    }
}
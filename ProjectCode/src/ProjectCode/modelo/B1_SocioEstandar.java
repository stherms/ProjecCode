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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
    
        for(int i = 0; i < SociosEstandar.size(); i++) {
            sb.append("SOCIO NUMERO <<").append(i+1).append(">>\n");
            sb.append("    DATOS ESENCIALES\n");
            sb.append("    - Num socio: ").append(SociosEstandar.get(i).getNumSocio()).append("\n");
            sb.append("    - Nombre: ").append(SociosEstandar.get(i).getNombre()).append("\n");
            sb.append("    - Nif: ").append(SociosEstandar.get(i).getNif()).append("\n");
            sb.append("    DATOS SEGURO\n");
            sb.append(SociosEstandar.get(i).getSeguro()).append("\n");
            sb.append("===========================================================\n");
        }
    
        return sb.toString();
    }
}
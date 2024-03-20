package ProjectCode.modelo;

import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * La clase SocioInfantil representa un Socio Infantil que hereda de la clase Padre Socio, con atributos propios
 * numSocioPadre y el descuento que tiene. *
 *
 *@author ProjectCode
 *@version 1.0
 */
public class B3_SocioInfantil extends B0_Socio {

    private int numSocioPadre;
    private final double DESCUENTO = 50.0;

    /**
     *
     * @param numSocio El numero de Socio Infantil
     * @param nombre El nombre del Socio Infantil
     * @param numSocioPadre El numero de Socio de un padre
     */

    public B3_SocioInfantil(int numSocio, String nombre, int numSocioPadre) {
        super(numSocio, nombre);
        this.numSocioPadre = numSocioPadre;
    }
    public B3_SocioInfantil() {
        System.out.println("prueba socio infantil");
    }

    /**
     * Obtiene el numero de Socio del padre.
     *
     * @return El numero de Socio del padre.
     */

    public int getNumSocioPadre() {
        return numSocioPadre;
    }

    /**
     * Establece el numero de Socio del padre.
     *
     * @param numSocioPadre El numero de Socio del padre
     */
    public void setNumSocioPadre(int numSocioPadre) {
        this.numSocioPadre = numSocioPadre;
    }

    /**
     * Obtiene el porcentaje de descuento que tiene el Socio Infantil.
     *
     * @return El porcentaje de descuento que tiene el Socio Infantil.
     */

    public double getDESCUENTO() {
        return DESCUENTO;
    }

    /**
     * Obtiene los datos del Socio infantil
     *
     * @return Los datos del Socio Infantil
     */

    @Override
    public String toString() {
        return "B3_SocioInfantil{" +
                "numSocioPadre=" + numSocioPadre +
                ", DESCUENTO=" + DESCUENTO +
                '}';
    }

    public void crearSocioInfantil(){
        System.out.println("PRUEBA DE CODIGO");
    }
}
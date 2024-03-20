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
    private static ArrayList<B3_SocioInfantil> SociosInfantiles = new ArrayList<>();

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
        StringBuilder mensajeInfantil = new StringBuilder();
        
        for(int i = 0; i < SociosInfantiles.size(); i++) {
            mensajeInfantil.append("SOCIO INFANTIL\n");
            mensajeInfantil.append("    DATOS ESENCIALES\n");
            mensajeInfantil.append("    - Num socio: ").append(SociosInfantiles.get(i).getNumSocio()).append("\n");
            mensajeInfantil.append("    - Nombre: ").append(SociosInfantiles.get(i).getNombre()).append("\n");
            mensajeInfantil.append("    DATOS CODIGO FAMILIAR\n");
            mensajeInfantil.append("    - Num socio familiar: ").append(SociosInfantiles.get(i).getNumSocioPadre()).append("\n");
            mensajeInfantil.append("===========================================================\n");
        }

        return mensajeInfantil.toString();
    }
}
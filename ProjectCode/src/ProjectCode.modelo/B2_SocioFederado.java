/**
 *
 * La clase SocioFederado representa un Socio Federado que hereda de la clase Padre Socio, con atributos propios nif
 * y dos constantes que representan los descuentos que tienen, tiene una relación de composición con la clase Federacion
 *
 *
 *@author ProjectCode
 *@version 1.0
 */
public class B2_SocioFederado extends B0_Socio{

    private String nif;
    private final double DES_CUOTA_MENSUAL  = 5.0;
    private final double DES_PRECIO_EXCURSION = 10.0;
    private D0_Federacion federacion;

    /**
     *
     * @param numSocio El numero de Socio Federado.
     * @param nombre El nombre del Socio Federado.
     * @param nif El nif del Socio Federado.
     * @param codigoFederacion El codigo de la federacion a la que pertenece.
     * @param nomFederacion El nombre de la federacion a la que pertenece.
     */

    public B2_SocioFederado(int numSocio, String nombre, String nif, String codigoFederacion, String nomFederacion) {
        super(numSocio, nombre);
        this.nif = nif;
        this.federacion = new D0_Federacion(codigoFederacion,nomFederacion);
    }

    /**
     * Obtiene el nif del Socio Federado.
     *
     * @return El nif del socio Federado.
     */

    public String getNif() {
        return nif;
    }

    /**
     * Establece el nif del Socio Federado.
     *
     * @param nif El nif del Socio Federado.
     */

    public void setNif(String nif) {
        this.nif = nif;
    }

    /**
     * Obtiene el porcentaje de descuento mensual que tiene el Socio Federado.
     *
     * @return El porcentaje de descuento de cuota mensual que tiene el Socio Federado.
     */

    public double getDES_CUOTA_MENSUAL() {
        return DES_CUOTA_MENSUAL;
    }

    /**
     * Obtiene el porcentaje de descuento por excursion que tiene el Socio Federado.
     * @return El porcentaje de descuento por excursion que tiene el Socio Federado.
     */

    public double getDES_PRECIO_EXCURSION() {
        return DES_PRECIO_EXCURSION;
    }

    /**
     * Obtiene la federación que pertenece el Socio Federado.
     *
     * @return La federacion del Socio Federado
     */

    public D0_Federacion getFederacion() {
        return federacion;
    }

    /**
     * Obtiene Los datos del Socio Federado y la federacion a la que pertenece.
     *
     * @return Obtiene Los datos del Socio Federado y la federacion a la que pertenece.
     */

    @Override
    public String toString() {
        return "B2_SocioFederado{" +
                "nif='" + nif + '\'' +
                ", DES_CUOTA_MENSUAL=" + DES_CUOTA_MENSUAL +
                ", DES_PRECIO_EXCURSION=" + DES_PRECIO_EXCURSION +
                ", federacion=" + federacion +
                '}';
    }
}
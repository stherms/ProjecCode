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

    /**
     *
     * @param numSocio El número del Socio Estandar.
     * @param nombre   El nombre del Socio Estandar.
     * @param nif      El nif del Socio Estandar.
     * @param tipo     El tipo de seguro contratado (BASICO o COMPLETO).
     * @param precio   El precio del seguro contratado.
     */

    public B1_SocioEstandar(int numSocio, String nombre, String nif, C0_Seguro.tipoSeguro tipoSeguro, float precioSeguro) {

        super(numSocio, nombre);
        this.nif = nif;
        this.seguro = new C0_Seguro(tipoSeguro, precioSeguro);
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
        return "B1_SocioEstandar{" +
                "nif='" + nif + '\'' +
                ", seguro=" + seguro +
                '}';
    }
}
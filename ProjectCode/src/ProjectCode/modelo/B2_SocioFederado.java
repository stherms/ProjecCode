package ProjectCode.modelo;
import java.util.ArrayList;
import java.util.Scanner;

public class B2_SocioFederado extends B0_Socio {
    private String nif;
    private final double DES_CUOTA_MENSUAL = 5.0;
    private final double DES_PRECIO_EXCURSION = 10.0;
    private D0_Federacion federacion;
    private static ArrayList<B2_SocioFederado> SociosFederados = new ArrayList<>();

    public B2_SocioFederado(int numSocio, String nombre, String nif, String codigoFederacion, String nomFederacion) {
        super(numSocio, nombre);
        this.nif = nif;
        this.federacion = new D0_Federacion(codigoFederacion, nomFederacion);
        SociosFederados.add(this);
    }

    public B2_SocioFederado() {
        // Constructor vacío
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public double getDES_CUOTA_MENSUAL() {
        return DES_CUOTA_MENSUAL;
    }

    public double getDES_PRECIO_EXCURSION() {
        return DES_PRECIO_EXCURSION;
    }

    public D0_Federacion getFederacion() {
        return federacion;
    }

    @Override
    public String toString() {
        return "\n  DATOS ESENCIALES:"
            + "\n      - Numero socio: " + getNumSocio() 
            + "\n      - Nombre: " + getNombre() 
            + "\n      - Nif: " + nif 
            + "\n  DATOS FEDERACION:"
            + "\n"+getFederacion();

    }
}

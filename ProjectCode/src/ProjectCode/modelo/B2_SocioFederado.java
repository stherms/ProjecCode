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
        return "SOCIO: \n - Numero socio: " + getNumSocio() 
            +"\n - Nombre: " + getNombre() 
            + "\n - Nif: " + nif 
            + "\n"+getFederacion() ;
    }

    public void CrearSocioFederado(){
        Scanner teclado = new Scanner(System.in); 
        System.out.println(" - Numero Socio: ");
        int numSocio = teclado.nextInt();
        teclado.nextLine(); 
        System.out.println("- Nombre: ");
        String nombre = teclado.nextLine();
        System.out.println("- Nif: ");
        String nif = teclado.nextLine();
        System.out.println("- Codigo Federacion: ");
        String codigoFederacion = teclado.nextLine();
        System.out.println("- Nombre Federacion: ");
        String nomFederacion = teclado.nextLine();

        B2_SocioFederado socioFederado = new B2_SocioFederado(numSocio, nombre, nif, codigoFederacion, nomFederacion);
        System.out.println("Se ha creado el Socio Federado:");
        System.out.println(socioFederado.toString());
    }

    public static void mostrarSociosFederados(){
        for(B2_SocioFederado socio : SociosFederados) {
            System.out.println(socio.toString());
        }
    }
}

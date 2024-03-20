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
        return "B1_SocioEstandar{" +
                "nif='" + nif + '\'' +
                ", seguro=" + seguro +
                '}';
    }

    public void crearSocioEstandar() {
        Scanner teclado = new Scanner(System.in); 
    
        System.out.println("- Numero Socio:");
        int numSocio = teclado.nextInt();
        teclado.nextLine();
    
        System.out.println("- Nombre: ");
        String nombre = teclado.nextLine();
    
        System.out.println("- Nif:");
        String nif = teclado.nextLine();
    
        System.out.println("- Tipo Seguro:");
        C0_Seguro.tipoSeguro[] tipos = C0_Seguro.tipoSeguro.values();
        for (int i = 0; i < tipos.length; i++) {
            System.out.println((i + 1) + ") " + tipos[i]);
        }
        int eleccion = teclado.nextInt();
        teclado.nextLine();
    
        while (eleccion < 1 || eleccion > tipos.length) {
            for (int i = 0; i < tipos.length; i++) {
                System.out.println((i + 1) + ") " + tipos[i]);
            }
            eleccion = teclado.nextInt();
            teclado.nextLine();
        }
    
        C0_Seguro.tipoSeguro tipoSeguro = tipos[eleccion - 1];

        System.out.println("- Precio del seguro:");
        double precio =  teclado.nextDouble();

        C0_Seguro seguro = new C0_Seguro(tipoSeguro, precio); 
        B1_SocioEstandar socioEstandar = new B1_SocioEstandar(numSocio, nombre, nif, seguro);

        System.out.println("TIENES UN HIJO AL QUE HACER SOCIO?\n 1)SI\n 2)NO");
        int respuesta = teclado.nextInt();
            teclado.nextLine();

        while(respuesta<=0 || respuesta>2){
            System.out.println("TIENES UN HIJO AL QUE HACER SOCIO?\n 1)SI\n 2)NO");
            respuesta = teclado.nextInt();
                teclado.nextLine();
        }
        switch(respuesta){
            case 1:
                B3_SocioInfantil socioInfantil = new B3_SocioInfantil();
                socioInfantil.crearSocioInfantil();
                break;
            default:
                //A_MenuInicial  menuInicio = new A_MenuInicial();
                //menuInicio.inicio();
            break;
        }

    }
    
    public void mostrarSociosEstandar(){
        for(int i = 0; i<SociosEstandar.size();i++){
            System.out.println("SOCIO NUMERO <<"+(i+1)+">>");
            System.out.println("    DATOS ESENCIALES");
            System.out.println("    - Num socio: " + SociosEstandar.get(i).getNumSocio());
            System.out.println("    - Nombre: " + SociosEstandar.get(i).getNombre());
            System.out.println("    - Nif: " + SociosEstandar.get(i).getNif());
            System.out.println("    DATOS SEGURO");
            System.out.println(SociosEstandar.get(i).getSeguro());
            System.out.println("===========================================================");
        }
    }
}


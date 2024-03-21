package ProjectCode.modelo;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;


public class Datos {

    private ArrayList<D0_Federacion> federaciones;
    private C0_Seguro basico;
    private C0_Seguro completo;
    private ArrayList<E0_Excursiones> excursiones;
    private ArrayList<B1_SocioEstandar> sociosEstandars;
    private ArrayList<B2_SocioFederado> sociosFederados;
    private ArrayList<B3_SocioInfantil> sociosInfantiles;
    private ArrayList<F0_Inscripciones> cargaInscripciones;


    public Datos() {
        this.federaciones = new ArrayList<>();
        this.excursiones = new ArrayList<>();
        this.sociosEstandars = new ArrayList<>();
        this.sociosFederados = new ArrayList<>();
        this.sociosInfantiles = new ArrayList<>();
        this.cargaInscripciones = new ArrayList<>();


    }
    //CARGA INCIAL FEDERACIONES

    /**
     * Realiza una carga inicial de una lista de federaciones
     */
    public void cargarFederaciones() {

        federaciones.add(new D0_Federacion("1", "Federacion española de montañistas"));
        federaciones.add(new D0_Federacion("2", "Asocioación de excursionistas"));
        federaciones.add(new D0_Federacion("3", "El club del senderismo"));
        federaciones.add(new D0_Federacion("4", "Federacion vive la naturaleza"));


    }

    //CARGA DE SEGUROS

    /**
     * Crea los dos Seguros disponibles para los Socios Estandars basico y completo
     */
    public void cargarSeguros() {

        basico = new C0_Seguro(C0_Seguro.tipoSeguro.BASICO, 15);
        completo = new C0_Seguro(C0_Seguro.tipoSeguro.COMPLETO, 30);
    }

    //CARGA INICIAL SOCIOS ESTANDAR

    /**
     * Realiza una carga inicial de una lista de Socios Estandar
     */

    public void cargaInicialSociosEstandar() {

        sociosEstandars.add(new B1_SocioEstandar(1, "Pedro Sanchez", "38456625-T", completo));
        sociosEstandars.add(new B1_SocioEstandar(2, "Antonio López", "30585524-z", completo));
        sociosEstandars.add(new B1_SocioEstandar(3, "Sonia Ruiz ", "35658623-V", basico));


    }
    //CARGA INICIAL DE SOCIOS FEDERADOS

    /**
     * Realiza una carga inicial de una lista de Socios federados
     */

    public void cargaInicialSociosFederados() {

        sociosFederados.add(new B2_SocioFederado(4, "Andrew Skurka", "38525625-T", "1",
                "Federacion española de montañistas"));
        sociosFederados.add(new B2_SocioFederado(5, "Heather Anderson", "40368524-z", "2",
                "Asocioación de excursionistas"));
        sociosFederados.add(new B2_SocioFederado(6, "Jennifer Pharr Davis", "48525623-V", "3",
                "El club del senderismo"));
        sociosFederados.add(new B2_SocioFederado(7, "Earl Shaffer", "38525625-T", "4",
                "Federacion vive la naturaleza"));


    }

    //CARGA INICIAL DE SOCIOS INFANTILES

    /**
     * Realiza una carga inicial de una lista de Socios Infantiles
     */

    public void cargaInicialSociosInfantiles() {

        sociosInfantiles.add(new B3_SocioInfantil(8, "Pedrito Sanchez", 1));
        sociosInfantiles.add(new B3_SocioInfantil(9, "Sandra Lopez", 2));


    }


    //CARGA INICIAL EXCURSIONES

    /**
     * Realiza una carga inicial de Excursiones
     */


    public void cargaInicialExcursiones() {

        excursiones.add(new E0_Excursiones("M1", "Excursión por el Montseny", LocalDate.parse("2024-04-19"), 2, 50.5));
        excursiones.add(new E0_Excursiones("A1", "Excursión por los Alpes", LocalDate.parse("2024-05-26"), 3, 220));
        excursiones.add(new E0_Excursiones("PE1", "Visita a los picos de Europa", LocalDate.parse("2024-08-22"), 5, 250));
        excursiones.add(new E0_Excursiones("E1", "Subida al Everest ", LocalDate.parse("2024-08-11"), 7, 1250));


    }
    //CARGA INICIAL INSCRIPCIONES

    /**
     * Realiza una carga inicial de Inscripciones
     */

    public void cargaInicialInscripciones() {

        cargaInscripciones.add(new F0_Inscripciones(1, sociosFederados.get(1), excursiones.get(1)));
        cargaInscripciones.add(new F0_Inscripciones(2, sociosEstandars.get(1), excursiones.get(0)));


    }
    // METODOS DE EXCURSIONES
    // AÑADIR EXCURSION

    /**
     * Añade nuevas excursiones
     *
     * @param codigo El codigo de la excursion
     * @param descr  Una descripcion
     * @param fecha  La Fecha de la Excursion
     * @param dias   La cantidad de dias que dura la excursion
     * @param precio El precio de la excursión
     */
    public void añadirExcursion(String codigo, String descr, LocalDate fecha, int dias, double precio) {

        excursiones.add(new E0_Excursiones(codigo, descr, fecha, dias, precio));

    }

    // FILTRAR EXCURSION POR INTERVALO DE FECHAS

    /**
     * Filtra las excursiones comprendidas entre dos fechas y las añade al ArrayList excursionesFiltradas
     *
     * @param fechaIni Fecha de inicio que queremos visualizar
     * @param fechafin Fecha de Fin que queremos visualizar
     * @return una lista de Excursiones filtrada por fechas
     */

    public ArrayList<E0_Excursiones> filtrarExcursiones(LocalDate fechaIni, LocalDate fechafin) {

        ArrayList<E0_Excursiones> excusionesFiltradas = new ArrayList<>();

        for (E0_Excursiones excursion : excursiones) {


            if ((excursion.getFecha().isAfter(fechaIni) || excursion.getFecha().isEqual(fechaIni))
                    && (excursion.getFecha().isBefore(fechafin) || excursion.getFecha().isEqual(fechafin))) {
                excusionesFiltradas.add(excursion);
            }

        }
        return excusionesFiltradas;

    }
    //BORRAR EXCURSION

    /**
     * Elimina la excursion con el codigo recivido como parametro.
     *
     * @param codigoExcursion El codigo de la excursion a eliminar
     */

    public void eliminarExcursion(String codigoExcursion) {
        //creamos iterador para la lista de excursiones
        Iterator<E0_Excursiones> iterador = excursiones.iterator();
        //mientras queden elementos..
        while (iterador.hasNext()) {
            E0_Excursiones excursionActual = iterador.next();//Almacenamos el siguiente elemento de la lista

            // si el codigo del elemento actual es igual al codigoExcursion iterator elimina ese elemento.
            if (excursionActual.getCodigo().equals(codigoExcursion)) {
                iterador.remove();// borramos el elemento
                break; // salimos del bucle si el elemento ha sido ya eliminado
            }
        }

    }

//METODO FEDERACIONES
    //Ver federaciones
    public ArrayList<D0_Federacion> mostrarFederaciones(){
        return federaciones;
    }



    //METODOS DE SOCIOS
    //METODOS SOCIO FEDERADO
    /**
     * añade nuevos socios Federados
     *
     * @param numSocio El numero de Socio Federado
     * @param nombre El nombre del socio Federado
     * @param nif El nif del Socio Federado
     * @param codigoFederacion El codigo de la Federacion
     * @param nomFederacion El nombre de la Federación
     */
    public void CrearSocioFederado(int numSocio, String nombre, String nif, String codigoFederacion, String nomFederacion){

        sociosFederados.add(new B2_SocioFederado(numSocio, nombre, nif, codigoFederacion, nomFederacion));
    }
    /**
     * Solicita la lista de Socios Federados
     *
     * @return Una lista de Socios Federados
     */

    public ArrayList<B2_SocioFederado> mostrarsociosFederados(){
        return sociosFederados;
    }

    //METODOS SOCIO ESTANDAR
    /**
     * añade nuevos Socios Estandars
     *
     * @param numSocio El numero de Socio Estandar
     * @param nombre El nombre del socio Estandar
     * @param nif El nif del Socio Estandar
     * @param seguro El seguro obligatorio del Socio Estandar
     */


    public void CrearSocioEstandar(int numSocio, String nombre, String nif, C0_Seguro seguro){

        sociosEstandars.add(new B1_SocioEstandar(numSocio, nombre,  nif, seguro));
    }
    /**
     * solicita la lista de Socios Estandar
     *
     * @return Una lista de Socios Estandar
     */

    public ArrayList<B1_SocioEstandar> mostrarSocioEstandar(){
        return sociosEstandars;
    }

    //METODOS SOCIO INFANTIL
    /**
     * Añade nuevos Socios Infantiles.
     *
     * @param numSocio El numero de Socio Infantil
     * @param nombre El nombre del Socio Infantil
     * @param numSocioPadre En numero del Socio de Padre/Madre del Socio Infantil
     */

    public void CrearSocioInfantil(int numSocio, String nombre, int numSocioPadre){

        sociosInfantiles.add(new B3_SocioInfantil(numSocio, nombre, numSocioPadre));
    }

    /**
     * solicita la lista de Socios Infantiles
     * @return Una lista de Socios Infantiles
     */
    public ArrayList<B3_SocioInfantil> mostrarSocioInfantil(){
        return sociosInfantiles;
    }
}
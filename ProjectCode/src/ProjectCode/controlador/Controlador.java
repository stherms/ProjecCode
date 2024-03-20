/**
 * Clase controlador realizar la interconexion entre la vista y el modelo
 */

package ProjectCode.controlador;

import ProjectCode.modelo.B1_SocioEstandar;
import ProjectCode.modelo.B2_SocioFederado;
import ProjectCode.modelo.B3_SocioInfantil;
import ProjectCode.modelo.C0_Seguro;
import ProjectCode.modelo.Datos;
import ProjectCode.modelo.E0_Excursiones;
import ProjectCode.vista.A_MenuInicial;

import java.time.LocalDate;
import java.util.ArrayList;

public class Controlador {

    private Datos datos;
    private A_MenuInicial vista;

    //CONSTRUCTORES
    //recive/envia de vista y recive/envia a modelo

    /**
     * Constructor de la clase controlador.
     * @param datos instancia de la clase Datos
     * @param vista instancia de la clase Vista
     */
    public Controlador(Datos datos, A_MenuInicial vista) {

        this.datos = datos;
        this.vista = vista;

    }

    /**
     * Constructor de la clase controlador.
     * @param datos instancia de la clase Datos
     */
    public Controlador(Datos datos){

        this.datos = datos;

    }

    //METODOS CARGA DE DATOS

    /**
     * Interactua con el metodo de datos de la clase Datos del modelo para cargar las Federaciones
     * Este método se llama al inicio de la aplicación para cargar las federaciones disponibles por defecto
     *
     */
    public void cargarFederaciones() {

        datos.cargarFederaciones();

    }
    /**
     * Interactua con el metodo de datos de la clase Datos del modelo para cargar los seguros
     * Este método se llama al inicio de la aplicación para cargar los seguros disponibles por defecto
     *
     */
    public void cargarSeguros(){

        datos.cargarSeguros();
    }
    /**
     * Interactua con el metodo de datos de la clase Datos del modelo para cargar los Socios Estandars
     * Este método se llama al inicio de la aplicación para cargar los Socios Estandars disponibles por defecto
     *
     */
    public void cargaInicialSociosEstandar(){

        datos.cargaInicialSociosEstandar();
    }
    /**
     * Interactua con el metodo de datos de la clase Datos del modelo para cargar los Socios Federados
     * Este método se llama al inicio de la aplicación para cargar los Socios Federados disponibles por defecto
     *
     */

    public void cargaInicialSociosFederados(){

        datos.cargaInicialSociosFederados();
    }
    /**
     * Interactua con el metodo de datos de la clase Datos del modelo para cargar los Socios Infantiles
     * Este método se llama al inicio de la aplicación para cargar los Socios Infantiles disponibles por defecto
     *
     */
    public void cargaInicialSociosInfantiles(){

        datos.cargaInicialSociosInfantiles();
    }
    /**
     * Interactua con el metodo de datos de la clase Datos del modelo para cargar las Excursiones
     * Este método se llama al inicio de la aplicación para cargar las Excursiones disponibles por defecto
     *
     */
    public void cargaInicialExcursiones(){
        datos.cargaInicialExcursiones();
    }
    /**
     * Interactua con el metodo de datos de la clase Datos del modelo para cargar las Inscripciones
     * Este método se llama al inicio de la aplicación para cargar las Inscripciones disponibles por defecto
     *
     */
    public void cargaInicialInscripciones(){
        datos.cargaInicialInscripciones();
    }


    //METODOS EXCURSIONES

    /**
     * Interactua con el metodo de datos de la clase Datos del modelo para añadir nuevas excursiones
     *
     * @param codigo El codigo de la excursion
     * @param descr Una descripcion
     * @param fecha La Fecha de la Excursion
     * @param dias La cantidad de dias que dura la excursion
     * @param precio El precio de la excursión
     */
    public void añadirExcursion(String codigo, String descr, LocalDate fecha, int dias, double precio){

        datos.añadirExcursion(codigo,descr,fecha,dias,precio);
    }

    /**
     * Interactua con el metodo de datos de la clase Datos del modelo para solicitar un lista de excursiones
     * comprendidas entre dos fechas.
     *
     * @param fechaIni Fecha de inicio que queremos visualizar
     * @param fechafin Fecha de Fin que queremos visualizar
     * @return una lista de Excursiones filtrada por fechas
     */

    public ArrayList<E0_Excursiones> filtrarExcursiones(LocalDate fechaIni, LocalDate fechafin){

        ArrayList<E0_Excursiones> excursiones= new ArrayList<>();

        excursiones = datos.filtrarExcursiones(fechaIni,fechafin);

        return  excursiones;
    }

    /**
     * Interactua con el metodo de datos de la clase Datos del modelo para eliminar una excursion.
     * @param codigoExcursion El codigo de la excursion a eliminar
     */
    public void eliminarExcursion(String codigoExcursion){

        datos.eliminarExcursion(codigoExcursion);

    }

    //METODOS SOCIOS
    //METODOS SOCIOS FEDERADOS

    /**
     * Interactua con el metodo de datos de la clase Datos del modelo para añadir nuevos socios Federados
     *
     * @param numSocio El numero de Socio Federado
     * @param nombre El nombre del socio Federado
     * @param nif El nif del Socio Federado
     * @param codigoFederacion El codigo de la Federacion
     * @param nomFederacion El nombre de la Federación
     */
    public void CrearSocioFederado(int numSocio, String nombre, String nif, String codigoFederacion, String nomFederacion){

        datos.CrearSocioFederado(numSocio, nombre, nif, codigoFederacion, nomFederacion);
    }

    /**
     * Interactua con el metodo de datos de la clase Datos del modelo para solicitar la lista de Socios Federados
     *
     * @return Una lista de Socios Federados
     */
    public ArrayList<B2_SocioFederado> mostrarSocioFederados(){
        ArrayList<B2_SocioFederado> socioFederados = new ArrayList<>();
        socioFederados = datos.mostrarsociosFederados();
        return socioFederados;
    }

    //METODOS SOCIO ESTANDAR
    /**
     * Interactua con el metodo de datos de la clase Datos del modelo para añadir nuevos Socios Estandars
     *
     * @param numSocio El numero de Socio Estandar
     * @param nombre El nombre del socio Estandar
     * @param nif El nif del Socio Estandar
     * @param seguro El seguro obligatorio del Socio Estandar
     */

    public void CrearSocioEstandar(int numSocio, String nombre, String nif, C0_Seguro seguro){

        datos.CrearSocioEstandar(numSocio,  nombre, nif, seguro);
    }

    /**
     * Interactua con el metodo de datos de la clase Datos del modelo para solicitar la lista de Socios Estandar
     *
     * @return Una lista de Socios Estandar
     */

    public ArrayList<B1_SocioEstandar> mostrarSocioEstandar(){
        ArrayList<B1_SocioEstandar> socioEstandars = new ArrayList<>();
        socioEstandars = datos.mostrarSocioEstandar();
        return socioEstandars;
    }

    //METODOS SOCIOS INFANTILES

    /**
     * Interactua con el metodo de datos de la clase Datos del modelo para añadir nuevos Socios Infantiles.
     *
     * @param numSocio El numero de Socio Infantil
     * @param nombre El nombre del Socio Infantil
     * @param numSocioPadre En numero del Socio de Padre/Madre del Socio Infantil
     */
    public void CrearSocioInfantil(int numSocio, String nombre, int numSocioPadre){

        datos.CrearSocioInfantil(numSocio,  nombre, numSocioPadre);
    }

    /**
     * Interactua con el metodo de datos de la clase Datos del modelo para solicitar la lista de Socios Infantiles
     * @return Una lista de Socios Infantiles
     */
    public ArrayList<B3_SocioInfantil> mostrarSocioInfantil(){
        ArrayList<B3_SocioInfantil> socioInfantil = new ArrayList<>();
        socioInfantil = datos.mostrarSocioInfantil();
        return socioInfantil;
    }
}
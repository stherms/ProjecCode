package ProjectCode.controlador;

import ProjectCode.modelo.B2_SocioFederado;
import ProjectCode.modelo.D0_Federacion;
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
     * @param vista instancia de la clsse Vista
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
    public void cargarFederaciones() {

        datos.cargarFederaciones();

    }

    public void cargarSeguros(){

        datos.cargarSeguros();
    }
    public void cargaInicialSociosEstandar(){

        datos.cargaInicialSociosEstandar();
    }
    public void cargaInicialSociosFederados(){

        datos.cargaInicialSociosFederados();
    }
    public void cargaInicialSociosInfantiles(){

        datos.cargaInicialSociosInfantiles();
    }
    public void cargaInicialExcursiones(){
        datos.cargaInicialExcursiones();
    }
    public void cargaInicialInscripciones(){
        datos.cargaInicialInscripciones();
    }


//METODOS EXCURSIONES
    public void añadirExcursion(String codigo, String descr, LocalDate fecha, int dias, double precio){

        datos.añadirExcursion(codigo,descr,fecha,dias,precio);
    }

    public ArrayList<E0_Excursiones> filtrarExcursiones(LocalDate fechaIni, LocalDate fechaFin){

        ArrayList<E0_Excursiones> excursiones= new ArrayList<>();

        excursiones = datos.filtrarExcursiones(fechaIni,fechaFin);

        return  excursiones;
    }

//METODOS CLIENTES
    //METODOS CLIENTES FEDERADOS
    public void CrearSocioFederado(int numSocio, String nombre, String nif, String codigoFederacion, String nomFederacion){

        datos.CrearSocioFederado(numSocio, nombre, nif, codigoFederacion, nomFederacion);
    }

    public ArrayList<B2_SocioFederado> mostrarSocioFederados(){
        ArrayList<B2_SocioFederado> socioFederados = new ArrayList<>();
        socioFederados = datos.mostrarsociosFederados();
        return socioFederados;
    }

    //METODOS CLIENTES ESTANDAR
    //METODOS CLIENTES INFANTILES
}
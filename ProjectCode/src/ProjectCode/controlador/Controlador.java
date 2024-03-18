package src.ProjectCode.controlador;

import src.ProjectCode.modelo.D0_Federacion;
import src.ProjectCode.modelo.Datos;
import src.ProjectCode.modelo.E0_Excursiones;
import src.ProjectCode.vista.A_MenuInicial;

import java.time.LocalDate;
import java.util.ArrayList;

public class Controlador {

    private Datos datos;
    private A_MenuInicial vista;

    //CONSTRUCTORES
    //recive/envia de vista y recive/envia a modelo
    public Controlador(Datos datos, A_MenuInicial vista) {

        this.datos = datos;
        this.vista = vista;

    }
    public Controlador(Datos datos){

        this.datos = datos;

    }


    public void cargarFederaciones() {

        datos.cargarFederaciones();

    }

    public void cargarSeguros(){

        datos.cargarSeguros();
    }
    public void añadirExcursion(String codigo, String descr, LocalDate fecha, int dias, double precio){

        datos.añadirExcursion(codigo,descr,fecha,dias,precio);
    }

    public ArrayList<E0_Excursiones> filtrarExcursiones(LocalDate fechaIni, LocalDate fechaFin){

        ArrayList<E0_Excursiones> excursiones= new ArrayList<>();

        excursiones = datos.filtrarExcursiones(fechaIni,fechaFin);

        return  excursiones;
    }
}
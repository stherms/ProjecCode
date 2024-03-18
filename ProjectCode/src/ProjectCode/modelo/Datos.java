package ProjectCode.modelo;


import java.time.LocalDate;
import java.util.ArrayList;


public class Datos {

    private ArrayList<D0_Federacion> federaciones;
    private C0_Seguro basico;
    private C0_Seguro completo;
    private ArrayList<E0_Excursiones> excursiones;


    public Datos() {
    this.federaciones = new ArrayList<>();
    this.excursiones = new ArrayList<>();


    }

    public void cargarFederaciones(){

        federaciones.add(new D0_Federacion("1","Federacion española de montañistas" ));
        federaciones.add(new D0_Federacion("2","Asocioación de excursionistas" ));
        federaciones.add(new D0_Federacion("3","El club del senderismo" ));
        federaciones.add(new D0_Federacion("4","Federacion vive la naturaleza" ));


    }

    public void cargarSeguros(){

        basico = new C0_Seguro(C0_Seguro.tipoSeguro.BASICO,15);
        completo = new C0_Seguro(C0_Seguro.tipoSeguro.COMPLETO,30);
    }
    public void añadirExcursion(String codigo, String descr, LocalDate fecha, int dias, double precio){

         excursiones.add(new E0_Excursiones(codigo,descr,fecha,dias,precio));

    }

    public ArrayList<E0_Excursiones> filtrarExcursiones(LocalDate fechaIni, LocalDate fechafin){

        ArrayList<E0_Excursiones> excusionesFiltradas = new ArrayList<>();

        for( E0_Excursiones excursion : excursiones ) {


            if ((excursion.getFecha().equals(fechaIni) || excursion.getFecha().isAfter(fechafin))
                    && (excursion.getFecha().equals(fechafin) || excursion.getFecha().isBefore(fechafin))) {

                    excusionesFiltradas.add(excursion);

            }

        }
        return excusionesFiltradas;

    }



}

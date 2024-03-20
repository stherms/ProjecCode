package ProjectCode.modelo;


import java.time.LocalDate;
import java.util.ArrayList;


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
    public void cargarFederaciones(){

        federaciones.add(new D0_Federacion("1","Federacion española de montañistas" ));
        federaciones.add(new D0_Federacion("2","Asocioación de excursionistas" ));
        federaciones.add(new D0_Federacion("3","El club del senderismo" ));
        federaciones.add(new D0_Federacion("4","Federacion vive la naturaleza" ));


    }

    //CARGA INICIAL SEGUROS
    public void cargarSeguros(){

        basico = new C0_Seguro(C0_Seguro.tipoSeguro.BASICO,15);
        completo = new C0_Seguro(C0_Seguro.tipoSeguro.COMPLETO,30);
    }

    //CARGA INICIAL SOCIOS ESTANDAR

    public void cargaInicialSociosEstandar(){

        sociosEstandars.add(new B1_SocioEstandar(1,"Pedro Sanchez","38456625-T",completo));
        sociosEstandars.add(new B1_SocioEstandar(2,"Antonio López","30585524-z",completo));
        sociosEstandars.add(new B1_SocioEstandar(3,"Sonia Ruiz ","35658623-V",basico));


    }
    //CARGA INICIAL DE SOCIOS FEDERADOS

    public void cargaInicialSociosFederados(){

        sociosFederados.add(new B2_SocioFederado(4,"Andrew Skurka","38525625-T","1",
                "Federacion española de montañistas"));
        sociosFederados.add(new B2_SocioFederado(5,"Heather Anderson","40368524-z","2",
                "Asocioación de excursionistas"));
        sociosFederados.add(new B2_SocioFederado(6,"Jennifer Pharr Davis","48525623-V","3",
                "El club del senderismo"));
        sociosFederados.add(new B2_SocioFederado(7,"Earl Shaffer","38525625-T","4",
                "Federacion vive la naturaleza"));


    }

    //CARGA INICIAL DE SOCIOS INFANTILES

    public void cargaInicialSociosInfantiles(){

        sociosInfantiles.add(new B3_SocioInfantil(8,"Pedrito Sanchez",1));
        sociosInfantiles.add(new B3_SocioInfantil(9,"Sandra Lopez",2));


    }

    //CARGA INICIAL EXCURSIONES

    public void cargaInicialExcursiones(){

    excursiones.add(new E0_Excursiones("M1","Excursión por el Montseny",LocalDate.parse("2024-04-19"),2,50.5));
    excursiones.add(new E0_Excursiones("A1","Excursión por los Alpes",LocalDate.parse("2024-05-26"),3,220));
    excursiones.add(new E0_Excursiones("PE1","Visita a los picos de Europa",LocalDate.parse("2024-08-22"),5,250));
    excursiones.add(new E0_Excursiones("E1","Subida al Everest ",LocalDate.parse("2024-08-11"),7,1250));



    }

    public void cargaInicialInscripciones(){

        cargaInscripciones.add(new F0_Inscripciones(1,sociosFederados.get(1),excursiones.get(1)));
        cargaInscripciones.add(new F0_Inscripciones(2,sociosEstandars.get(1),excursiones.get(0)));



    }
    public void añadirExcursion(String codigo, String descr, LocalDate fecha, int dias, double precio){

        excursiones.add(new E0_Excursiones(codigo,descr,fecha,dias,precio));

    }

    public ArrayList<E0_Excursiones> filtrarExcursiones(LocalDate fechaIni, LocalDate fechafin){

        ArrayList<E0_Excursiones> excusionesFiltradas = new ArrayList<>();

        for( E0_Excursiones excursion : excursiones ) {




            if ((excursion.getFecha().isAfter(fechaIni) || excursion.getFecha().isEqual(fechaIni))
                    && (excursion.getFecha().isBefore(fechafin) || excursion.getFecha().isEqual(fechafin))) {
                excusionesFiltradas.add(excursion);
            }

        }
        return excusionesFiltradas;

    }

//METODOS DE SOCIOS
    //METODOS SOCIO FEDERADO
    public void CrearSocioFederado(int numSocio, String nombre, String nif, String codigoFederacion, String nomFederacion){

        sociosFederados.add(new B2_SocioFederado(numSocio, nombre, nif, codigoFederacion, nomFederacion));
    }

    public ArrayList<B2_SocioFederado> mostrarsociosFederados(){
        return sociosFederados;
    }

    //METODOS SOCIO ESTANDAR
    public void CrearSocioEstandar(int numSocio, String nombre, String nif, C0_Seguro seguro){

        sociosEstandars.add(new B1_SocioEstandar(numSocio, nombre,  nif, seguro));
    }

    public ArrayList<B1_SocioEstandar> mostrarSocioEstandar(){
        return sociosEstandars;
    }

    //METODOS SOCIO INFANTIL
    public void CrearSocioInfantil(int numSocio, String nombre, int numSocioPadre){

        sociosInfantiles.add(new B3_SocioInfantil(numSocio, nombre, numSocioPadre));
    }

    public ArrayList<B3_SocioInfantil> mostrarSocioInfantil(){
        return sociosInfantiles;
    }
}

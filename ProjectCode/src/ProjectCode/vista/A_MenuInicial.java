/**
 *
 * Representa la vista del menu del usuario desde donde se interactua
 * con la clase controlador para añadir y visualizar datos
 *
 *@author ProjectCode
 *@version 1.0
 */
package ProjectCode.vista;

import ProjectCode.controlador.Controlador;
import ProjectCode.modelo.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class A_MenuInicial {
    Scanner teclado;
    private Controlador controlador;
    ArrayList<String> menuInicial = new ArrayList<>();
    ArrayList<String> menuExcursiones = new ArrayList<>();
    ArrayList<String> menuSocios = new ArrayList<>();
    ArrayList<String> submenuSocios = new ArrayList<>();
    ArrayList<String> menuInscripciones = new ArrayList<>();

    /**
     * Constructor de la clase A_MenuIcial
     *
     * @param controlador Una instancia de la clase controlador
     */
    public A_MenuInicial(Controlador controlador) {

        this.controlador = controlador;
        this.teclado = new Scanner(System.in);
    }


    public void inicio() {
        if (menuInicial.size() <= 0) {
            addMenuInicial();
        }
        StringBuilder mensajeInicio = new StringBuilder();

        for (int i = 0; i < menuInicial.size(); i++) {
            mensajeInicio.append((i + 1) + ") " + menuInicial.get(i) + "\n");
        }
        System.out.println("====================\n  MENU INICIAL\n" + mensajeInicio.toString() + "====================");
        int eleccion = teclado.nextInt();
        teclado.nextLine();
        while (eleccion <= 0 || eleccion > menuInicial.size()) {
            System.out.println("====================\n  MENU INICIAL\n" + mensajeInicio.toString() + "====================");
            eleccion = teclado.nextInt();
            teclado.nextLine();
        }
        switch (eleccion) {
            case 1:
                menuExcursiones();
                break;
            case 2:
                menuSocios();
                break;
            case 3:
                menuInscripciones();
                break;
            default:
                System.out.println("Cerrando programa...");
                break;
        }
    }

    public void addMenuInicial() {
        menuInicial.add("Excursiones");
        menuInicial.add("Socios");
        menuInicial.add("Inscripciones");
        menuInicial.add("Salir");
    }

    public void addMenuExcursiones() {
        menuExcursiones.add("Mostrar excursiones");
        menuExcursiones.add("Añadir excursion");
        menuExcursiones.add("Eliminar excursion");
        menuExcursiones.add("Atras");
        menuExcursiones.add("Salir");
    }

    public void addMenuSocios() {
        menuSocios.add("Mostrar Socios");
        menuSocios.add("Añadir socio Federado");
        menuSocios.add("Añadir socio Infantil");
        menuSocios.add("Añadir socio Estandar");
        menuSocios.add("Eliminar socio");
        menuSocios.add("Modificar seguro socio estandar");
        menuSocios.add("Mostrar facturas");
        menuSocios.add("Atras");
        menuSocios.add("Salir");
    }

    public void addSubMenuSocios() {
        submenuSocios.add("Mostrar todos los Socios");
        submenuSocios.add("Mostrar socios estandar");
        submenuSocios.add("Mostrar sociocios Federados");
        submenuSocios.add("Mostrar socios infantiles");
        submenuSocios.add("Inicio");
        submenuSocios.add("Atras");
        submenuSocios.add("Salir");
    }

    public void addMenuInscripciones() {
        menuInscripciones.add("Mostrar Inscripciones");
        menuInscripciones.add("Añadir inscripcion");
        menuInscripciones.add("Eliminar inscripcion");
        menuInscripciones.add("Atras");
        menuInscripciones.add("Salir");
    }

    private void menuExcursiones() {
        if (menuExcursiones.size() <= 0) {
            addMenuExcursiones();
        }
        StringBuilder mensajeExcursiones = new StringBuilder();

        for (int i = 0; i < menuExcursiones.size(); i++) {
            mensajeExcursiones.append((i + 1) + ") " + menuExcursiones.get(i) + "\n");
        }

        System.out.println("====================\n  MENU EXCURSIONES\n" + mensajeExcursiones.toString() + "====================");
        int eleccion = teclado.nextInt();
        teclado.nextLine();

        while (eleccion <= 0 || eleccion > menuExcursiones.size()) {
            System.out.println("====================\n  MENU EXCURSIONES\n" + mensajeExcursiones.toString() + "====================");
            eleccion = teclado.nextInt();
            teclado.nextLine();
        }

        switch (eleccion) {
            //MOSTRAR EXCURSION POR FILTRO DE FECHA
            case 1:
                LocalDate fechaIni = null;
                LocalDate fechaFin = null;

                boolean fechasCorrectas = true;

                do {
                    fechaIni = obtenerFecha(teclado, "FechaIni");
                    fechaFin = obtenerFecha(teclado, "FechaFin");

                    //La fecha de inicio debe ser anterior o igual a la de fin
                    if (fechaIni.isAfter(fechaFin)) {
                        System.out.println("La fecha de inicio no puede ser posterior a la fecha de fin");
                        fechasCorrectas = false;
                    } else {
                        fechasCorrectas = true;
                    }
                } while (!fechasCorrectas);


                ArrayList<E0_Excursiones> excusiones = controlador.filtrarExcursiones(fechaIni, fechaFin);

                mostrar(excusiones);//muestra por pantalla la lista de excursiones filtradas
                menuExcursiones();


                break;
            case 2:
                //AÑADIR EXCURSIÓN
                System.out.println("introduce el codigo");
                String codigo = this.teclado.nextLine();
                System.out.println("introduce la descripción");
                String descr = this.teclado.nextLine();

                //ATRIBUTOS
                boolean controlFecha = true;
                LocalDate fecha;


                //Controla que la fecha de la excursión añadida no sea anterior a la fecha actual
                do{
                    fecha = obtenerFecha(teclado, "");// llama al método validar fecha correcta

                    if(fecha.isBefore(LocalDate.now())){
                      controlFecha = false;
                      System.out.println("La fecha de la excursión no puede ser anterior a la fecha actual");

                    }
                    else{
                        controlFecha = true;
                    }

                }while(!controlFecha);
                //Controla que el valor introducido sea de tipo entero y mayor que 0.
                int dias = obtenerEnteroPositivo(teclado,"introduce el numero de dias");

                teclado.nextLine();// limpia buffer
                //Controla que el valor introducido sea de tipo doble y admite el limitar decimal "." o "," .

                double precio = obtenerDoublePositivo(teclado,"Introduce los dias de duración");

                controlador.añadirExcursion(codigo, descr, fecha, dias, precio);
                menuExcursiones();
                break;
            case 3:
                //ELIMINAR EXCURSION
                System.out.println("Introduce el codigo de la excursión a eliminar");
                String codigoEliminar = this.teclado.nextLine();
                controlador.eliminarExcursion(codigoEliminar);
                menuExcursiones();
                break;
            case 4:
                inicio();
                break;
            default:
                System.out.println("Cerrando programa...");
                break;
        }
    }

    private void menuSocios() {
        if (menuSocios.size() <= 0) {
            addMenuSocios();
        }
        StringBuilder mensajeSocios = new StringBuilder();

        for (int i = 0; i < menuSocios.size(); i++) {
            mensajeSocios.append((i + 1) + ") " + menuSocios.get(i) + "\n");
        }

        System.out.println("====================\n  MENU SOCIOS\n" + mensajeSocios.toString() + "====================");
        int eleccion = teclado.nextInt();
        teclado.nextLine();

        while (eleccion <= 0 || eleccion > menuSocios.size()) {
            System.out.println("====================\n  MENU SOCIOS\n" + mensajeSocios.toString() + "====================");
            eleccion = teclado.nextInt();
            teclado.nextLine();
        }

        switch (eleccion) {
            //MOSTRAR SOCIOS
            case 1:
                menusubSocios();
                break;
            // CREAR SOCIO FEDERADO
            case 2:
                int numFederado = obtenerEnteroPositivo(teclado," - Numero Socio: ");
                    teclado.nextLine();
                System.out.println("- Nombre: ");
                String nombreFederado = teclado.nextLine();
                System.out.println("- Nif: ");
                String nifFederado = teclado.nextLine();
                System.out.println("Del siguiente listado:");
                ArrayList<D0_Federacion> federaciones = controlador.mostrarFederaciones();

                for(int b=0; b<federaciones.size();b++){
                    System.out.println("    "+(b+1)+") "+federaciones.get(b).getNombre());
                }
                int eleccionFederacion = obtenerEnteroPositivo(teclado,"- Selecciona una Federacion:");
                teclado.nextLine();

                while(eleccionFederacion<=0 || eleccionFederacion>federaciones.size()){
                    System.out.println("Opcion no valida");
                    for(int b=0; b<federaciones.size();b++){

                        System.out.println("    "+(b+1)+") "+federaciones.get(b).getNombre());
                    }

    
                    eleccionFederacion = obtenerEnteroPositivo(teclado,"- Selecciona una Federacion:");
                        teclado.nextLine();
                }

                String nomFederacion = federaciones.get(eleccionFederacion-1).getNombre();
                String codigoFederacion = federaciones.get(eleccionFederacion-1).getCodigo();

                controlador.CrearSocioFederado(numFederado, nombreFederado, nifFederado, codigoFederacion, nomFederacion);

                System.out.println("Socio federado " + nombreFederado + " con numero " + numFederado + " ha sido creado");

                inicio();
                break;
            //CREAR SOCIO INFANTIL
            case 3:

                int numInfantil = obtenerEnteroPositivo(teclado,"- Numero socio: ");
                    teclado.nextLine();
                System.out.println("- Nombre: ");
                String nombreInfantil = teclado.nextLine();

                ArrayList<B1_SocioEstandar> socioEstandar = controlador.mostrarSocioEstandar();

                System.out.println("====================================="); 
                System.out.println("Socios Estándar existentes:");
                
                for(int a = 0; a<socioEstandar.size(); a++){
                    System.out.println("    "+ (a+1) + ") "+socioEstandar.get(a).getNombre()+" - " + socioEstandar.get(a).getNumSocio());
                }


                int eleccion_padreInfantil =obtenerEnteroPositivo(teclado,"Cual es el padre o madre del socio infantil?");
                    teclado.nextLine();

                while(eleccion_padreInfantil<=0 || eleccion_padreInfantil>socioEstandar.size()){
                    System.out.println("Opcion no valida");
                    for(int a = 0; a<socioEstandar.size(); a++){
                        System.out.println("    "+ (a+1) + ") "+socioEstandar.get(a).getNombre()+" - " + socioEstandar.get(a).getNumSocio());
                    }

                    eleccion_padreInfantil =obtenerEnteroPositivo(teclado,"Cual es el padre o madre del socio infantil?");
                        teclado.nextLine();
                }

                int numSocioEstandarInfantil = socioEstandar.get(eleccion_padreInfantil-1).getNumSocio();

                controlador.CrearSocioInfantil(numInfantil,nombreInfantil,numSocioEstandarInfantil);

                System.out.println("Socio infantil " + nombreInfantil + " con numero " + numInfantil + " ha sido creado");

                inicio();
                break;
            //CREAR SOCIO ESTANDAR
            case 4:               

                int numEstandar = obtenerEnteroPositivo(teclado,"- Numero Socio:");
                teclado.nextLine();
                
                System.out.println("- Nombre: ");
                String nombreEstandar = teclado.nextLine();
                
                System.out.println("- Nif:");
                String nifEstandar = teclado.nextLine();
                System.out.println("Selecciona el siguiente listado:");

                ArrayList<C0_Seguro> seguros = controlador.mostrarSeguros();

                for(int x = 0; x<seguros.size(); x++){
                    System.out.println("    "+(x +1)+") " + seguros.get(x).getTipoSeguro() + " - " + seguros.get(x).getPrecioSeguro());
                }
                int eleccionSeguro = obtenerEnteroPositivo(teclado,"- Seguros disponibles:");
                    teclado.nextLine();

                while(eleccionSeguro<=0 || eleccionSeguro>seguros.size()){
                    System.out.println("Opcion no valida");
                    System.out.println("- Seguros disponibles:");
                    
                    for(int x = 0; x<seguros.size(); x++){
                        System.out.println("    "+(x +1)+") " + seguros.get(x).getTipoSeguro() + " - " + seguros.get(x).getPrecioSeguro());
                    }
                    eleccionSeguro = obtenerEnteroPositivo(teclado,"- Seguros disponibles:");
                        teclado.nextLine();
                }

                C0_Seguro.tipoSeguro tipoSeguro = seguros.get(eleccionSeguro-1).getTipoSeguro();
                double precios = seguros.get(eleccionSeguro-1).getPrecioSeguro();
                
                System.out.println("elemento escogido " + tipoSeguro + " con precio " + precios);
                C0_Seguro seguro = new C0_Seguro(tipoSeguro, precios);


                
                controlador.CrearSocioEstandar(numEstandar, nombreEstandar, nifEstandar, seguro);
                
                System.out.println("Socio Estandar " + nombreEstandar + " con numero " + numEstandar + " ha sido creado");

                inicio();
                break;
            case 5:
                System.out.println("funcion EliminarSocio()");
                break;
            case 6:
                System.out.println("funcion ModificarSeguroSocioEstandar()");
                break;
            case 7:
                System.out.println("funcion MostrarFacturas()");
                break;
            case 8:
                inicio();
                break;
            default:
                System.out.println("Cerrando programa...");
                break;
        }
    }

    private void menusubSocios() {
        if (submenuSocios.size() <= 0) {
            addSubMenuSocios();
        }
        StringBuilder mensajesubSocios = new StringBuilder();

        for (int i = 0; i < submenuSocios.size(); i++) {
            mensajesubSocios.append((i + 1) + ") " + submenuSocios.get(i) + "\n");
        }

        System.out.println("====================\n MENU SOCIOS\n" + mensajesubSocios.toString() + "====================");
        int eleccion = teclado.nextInt();
        teclado.nextLine();

        while (eleccion <= 0 || eleccion > submenuSocios.size()) {
            System.out.println("====================\n  MENU SOCIOS\n" + mensajesubSocios.toString() + "====================");
            eleccion = teclado.nextInt();
            teclado.nextLine();
        }

        switch (eleccion) {
            case 1:
                System.out.println("funcion MostrarSocios");
                ArrayList<B1_SocioEstandar> socioEstandarX = controlador.mostrarSocioEstandar();
                ArrayList<B2_SocioFederado> socioFederadosX = controlador.mostrarSocioFederados();
                ArrayList<B3_SocioInfantil> socioInfantilX = controlador.mostrarSocioInfantil();
                System.out.println("FUNCIÓN MOSTRAR SOCIOS");
                mostrar(socioEstandarX);
                mostrar(socioFederadosX);
                mostrar(socioInfantilX);
                inicio();
                break;
            //VER SOCIOS ESTANDAR
            case 2:
                ArrayList<B1_SocioEstandar> socioEstandar = controlador.mostrarSocioEstandar();
                System.out.println("LISTADO DE SOCIOS ESTANDAR:");
                mostrar(socioEstandar);
                inicio();
                break;
            //VER SOCIOS FEDERADOS
            case 3:
                ArrayList<B2_SocioFederado> socioFederados = controlador.mostrarSocioFederados();
                System.out.println("LISTADO DE SOCIOS FEDERADOS:");
                mostrar(socioFederados);
                inicio();
                break;
            case 4:
                ArrayList<B3_SocioInfantil> socioInfantil = controlador.mostrarSocioInfantil();
                System.out.println("LISTADO DE SOCIOS INFANTILES:");
                mostrar(socioInfantil);
                inicio();
                break;
            case 5:
                inicio();
                break;
            case 6:
                menuSocios();
                break;
            default:
                System.out.println("Cerrando programa...");
                break;
        }
    }

    private void menuInscripciones() {
        if (menuInscripciones.size() <= 0) {
            addMenuInscripciones();
        }
        StringBuilder mensajeInscripciones = new StringBuilder();

        for (int i = 0; i < menuInscripciones.size(); i++) {
            mensajeInscripciones.append((i + 1) + ") " + menuInscripciones.get(i) + "\n");
        }

        System.out.println("====================\n MENU INSCRIPCIONES\n" + mensajeInscripciones.toString() + "====================");
        int eleccion = teclado.nextInt();
        teclado.nextLine();

        while (eleccion <= 0 || eleccion > menuInscripciones.size()) {
            System.out.println("====================\n  MENU INSCRIPCIONES\n" + mensajeInscripciones.toString() + "====================");
            eleccion = teclado.nextInt();
            teclado.nextLine();
        }

        switch (eleccion) {
             case 1:
                 System.out.println("LISTADO DE INSCRIPCIONES:");
                 System.out.println("1. Filtrar por socio:");
                 System.out.println("2. Filtrar por fecha");
                 int filtrado = teclado.nextInt();

                 if (filtrado == 1){
                     System.out.println("- Numero Socio:");
                     int numSocio = teclado.nextInt();
                     ArrayList<F0_Inscripciones> inscripciones = controlador.mostrarInscripcionesPorSocio(numSocio);
                     mostrar(inscripciones);
                 }
                 else if (filtrado == 2){
                     teclado.nextLine();
                     LocalDate fechaIni = obtenerFecha(teclado, "FechaIni");
                     LocalDate fechaFin = obtenerFecha(teclado, "FechaFin");
                     ArrayList<F0_Inscripciones> inscripciones = controlador.mostrarInscripcionesPorFechas(fechaIni, fechaFin);
                     mostrar(inscripciones);
                 }
                 else {
                     System.out.println("Opción incorrecta");
                 }

                menuInscripciones();
                break;
            case 2:
                //Capturamos posible excepción en caso que el valor introducido por teclado no sea numérico
                try {
                    System.out.println("- Numero Inscripcion:");
                    int numInscripcion = teclado.nextInt();
                    teclado.nextLine();

                    //Nif socio
                    ArrayList<B1_SocioEstandar> socioEstandar = controlador.mostrarSocioEstandar();
                    System.out.println("LISTADO DE SOCIOS ESTANDAR:");
                    mostrarDatosSocioEstandar(socioEstandar);
                    ArrayList<B2_SocioFederado> socioFederados = controlador.mostrarSocioFederados();
                    System.out.println("LISTADO DE SOCIOS FEDERADOS:");
                    mostrarDatosSocioFederado(socioFederados);
                    System.out.println("- Numero Socio:");
                    int numSocio = teclado.nextInt();
                    teclado.nextLine();

                    //Buscar el socio en ambas listas
                    B0_Socio encontrado = controlador.buscarSocio(socioEstandar, socioFederados, numSocio);

                    //Si no se ha encontrado socio
                    if (encontrado == null) {
                        System.out.println("- Nombre: ");
                        String nombre = teclado.nextLine();

                        System.out.println("- Nif:");
                        String nif = teclado.nextLine();

                        System.out.println("Tipo de Socio.");
                        System.out.println("1. Socio federado:");
                        System.out.println("2. Socio estandar");
                        int tipoSocio = teclado.nextInt();

                        if (tipoSocio == 1){
                            System.out.println("- Selecciona una Federacion:");
                            ArrayList<D0_Federacion> federaciones = controlador.mostrarFederaciones();

                            for(int b=0; b<federaciones.size();b++){
                                System.out.println("    "+(b+1)+") "+federaciones.get(b).getNombre());
                            }

                            int eleccionFederacion = teclado.nextInt();
                            teclado.nextLine();

                            while(eleccionFederacion<=0 || eleccionFederacion>federaciones.size()){
                                for(int b=0; b<federaciones.size();b++){
                                    System.out.println("    "+(b+1)+") "+federaciones.get(b).getNombre());
                                }

                                eleccionFederacion = teclado.nextInt();
                                teclado.nextLine();
                            }

                            String nomFederacion = federaciones.get(eleccionFederacion-1).getNombre();
                            String codigoFederacion = federaciones.get(eleccionFederacion-1).getCodigo();

                            controlador.CrearSocioFederado(numSocio, nombre, nif, codigoFederacion, nomFederacion);

                            System.out.println("Socio federado " + nombre + " con numero " + numSocio + " ha sido creado");

                        }
                        else if (tipoSocio == 2){
                            System.out.println("- Seguros disponibles:");

                            ArrayList<C0_Seguro> seguros = controlador.mostrarSeguros();

                            for(int x = 0; x<seguros.size(); x++){
                                System.out.println("    "+(x +1)+") " + seguros.get(x).getTipoSeguro() + " - " + seguros.get(x).getPrecioSeguro());
                            }
                            int eleccionSeguro = teclado.nextInt();
                            teclado.nextLine();

                            while(eleccionSeguro<=0 || eleccionSeguro>seguros.size()){
                                System.out.println("- Seguros disponibles:");

                                for(int x = 0; x<seguros.size(); x++){
                                    System.out.println("    "+(x +1)+") " + seguros.get(x).getTipoSeguro() + " - " + seguros.get(x).getPrecioSeguro());
                                }
                                eleccionSeguro = teclado.nextInt();
                                teclado.nextLine();
                            }

                            C0_Seguro.tipoSeguro tipoSeguro = seguros.get(eleccionSeguro-1).getTipoSeguro();
                            double precios = seguros.get(eleccionSeguro-1).getPrecioSeguro();

                            System.out.println("elemento escogido " + tipoSeguro + " con precio " + precios);
                            C0_Seguro seguro = new C0_Seguro(tipoSeguro, precios);

                            controlador.CrearSocioEstandar(numSocio, nombre, nif, seguro);
                            System.out.println("Socio Estandar " + nombre + " con numero " + numSocio + " ha sido creado");
                        }

                        //Buscar nuevo el socio porque ahora ya se dio de alta
                        encontrado = controlador.buscarSocio(socioEstandar, socioFederados, numSocio);
                    }

                    //Si el socio se ha encontrado
                    ArrayList<E0_Excursiones> excursiones = controlador.mostrarExcursiones();
                    System.out.println("LISTADO DE EXCURSIONES:");
                    mostrarDatosExcursiones(excursiones);

                    System.out.println("- Codigo excursion:");
                    String codigoExcursion = teclado.nextLine();

                    E0_Excursiones excursion = controlador.buscarExcursion(excursiones, codigoExcursion);

                    if (excursion != null) {
                        //Creamos incripcion
                        controlador.CrearInscripcion(numInscripcion, encontrado, excursion);

                        System.out.println("Inscripción insertada correctamente");
                    } else {
                        System.out.println("No existe una excursion con el codigo: " + codigoExcursion);
                    }
                }
                //Tipo de excepción cuando el valor introducido por teclado no cuadra con el tipo de dato que
                //intenta leer el Scanner
                catch (InputMismatchException ex){
                    System.out.println("Error valor no numerico");
                    teclado.nextLine();
                }
                menuInscripciones();
                break;
            case 3:
                //ELIMINAR INSCRIPCION
                try {
                    System.out.println("Introduce el numero de la inscripcion a eliminar");
                    int numeroEliminar = this.teclado.nextInt();
                    boolean borrado = controlador.eliminarInscripcion(numeroEliminar);

                    if (borrado) {
                        System.out.println("Inscripción eliminada correctamente");
                    } else {
                        System.out.println("No se ha podido eliminar la inscripcion con el numero: " + numeroEliminar);
                    }
                }
                catch (InputMismatchException ex){
                    System.out.println("Error valor no numerico");
                    teclado.nextLine();
                }

                menuInscripciones();
                break;
            case 4:
                inicio();
                break;
            default:
                System.out.println("Cerrando programa...");
                break;
        }
    }
    
    //EXCEPCIONES
    /**
     * Devuelve una fecha validada con formato AAA-MM-DD corrrecto.
     *
     * @param teclado La entrada por Teclado
     * @param tipo Un string con el nombre de la fecha ("fecha_inicio" por ejemplo)
     * @return una fecha validada
     */
    public static LocalDate obtenerFecha(Scanner teclado, String tipo) {
        LocalDate fecha = null;
        boolean formatoFecha = false;

        do {
            try {
                System.out.println("Introduce la fecha de " + tipo + " en formato AAAA-MM-DD:");
                fecha = LocalDate.parse(teclado.nextLine());
                formatoFecha = true;
            } catch (DateTimeParseException e) {
                System.out.println("Error: Formato de fecha incorrecto. Debe ser AAAA-MM-DD.");
            }
        } while (!formatoFecha);

        return fecha;
    }

    /**
     * Devuelve un numero validado como entero y mayor que 0
     *
     * @param teclado Un teclado para introducir el valor
     * @param mensaje El mensaje a mostrar como entrada
     * @return Un entero
     */
    public int obtenerEnteroPositivo(Scanner teclado,String mensaje){
        int numero = 0;
        boolean esValido = false;
        while(!esValido) {
            try {
                System.out.println(mensaje);
                numero = this.teclado.nextInt();
                if(numero > 0) {
                    esValido= true;
                }
                else{
                    System.out.println("Error debe ser un valor mayor a 0");
                }
            } catch (InputMismatchException e) {
                System.out.println("El valor debe ser numerico de tipo entero");
                teclado.nextLine();

            }
        }
        return numero;

    }

    /**
     *
     * @param teclado Un teclado para introducir el valor
     * @param mensaje El mensaje a mostrar como entrada
     * @return Un Double
     */
    public double obtenerDoublePositivo(Scanner teclado, String mensaje){
        double numero = 0.0;
        boolean esValido = false;

        while(!esValido) {
            try {
                System.out.println(mensaje);
                String input = teclado.nextLine().replace(',', '.');
                numero = Double.parseDouble(input);
                if(numero > 0) {
                    esValido= true;
                }
                else{
                    System.out.println("Error debe ser un valor mayor a 0");
                }

            } catch (NumberFormatException e) {
                System.out.println("El valor debe ser númerico  ");

            }
        }
        return numero;
    }
    // OTROS METODOS
    /**
     * Este metodo muestra por pantalla el contenido del ArrayList pasado como parametro
     * @param datosMostrar El Arraylist a mostrar
     * @param <T> cualquier elemento
     */
    public <T> void mostrar(ArrayList<T> datosMostrar) {
        for (T elemento : datosMostrar) {

            System.out.println(elemento.toString());
        }
    }

    public void mostrarDatosSocioEstandar(ArrayList<B1_SocioEstandar> datosMostrar) {
        for (B1_SocioEstandar elemento : datosMostrar) {
            System.out.println("-----------------------");
            System.out.println(elemento.getNumSocio() + "-" + elemento.getNombre());
        }
    }

    public void mostrarDatosSocioFederado(ArrayList<B2_SocioFederado> datosMostrar) {
        for (B2_SocioFederado elemento : datosMostrar) {
            System.out.println("-----------------------");
            System.out.println(elemento.getNumSocio() + "-" + elemento.getNombre());
        }
    }

    public void mostrarDatosExcursiones(ArrayList<E0_Excursiones> datosMostrar) {
        for (E0_Excursiones elemento : datosMostrar) {
            System.out.println("-----------------------");
            System.out.println(elemento.getCodigo() + "-" + elemento.getDescripcion());
        }
    }
    
    /**
     * Carga Inicial de datos con valores por defecto.
     */
    public void cargadatos(){
        controlador.cargarFederaciones();
        controlador.cargarSeguros();
        controlador.cargaInicialSociosEstandar();
        controlador.cargaInicialSociosFederados();
        controlador.cargaInicialSociosInfantiles();
        controlador.cargaInicialExcursiones();
        controlador.cargaInicialInscripciones();
        controlador.cargarSegurosArray();
    }
}

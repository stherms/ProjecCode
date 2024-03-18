package ProjectCode.vista;


import ProjectCode.controlador.Controlador;
import ProjectCode.modelo.E0_Excursiones;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class A_MenuInicial {
    Scanner teclado;
    private Controlador controlador;
    ArrayList<String> menuInicial = new ArrayList<>();
    ArrayList<String> menuExcursiones = new ArrayList<>();
    ArrayList<String> menuSocios = new ArrayList<>();
    ArrayList<String> submenuSocios = new ArrayList<>();
    ArrayList<String> menuInscripciones = new ArrayList<>();


    public A_MenuInicial(Controlador controlador) {

        this.controlador = controlador;
        this.teclado = new Scanner(System.in);
    }


    public void inicio() {
        controlador.cargarFederaciones();
        controlador.cargarSeguros();

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
            case 1:
                LocalDate fechaIni = null;
                LocalDate fechaFin = null;
                boolean formatoFecha = false;
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

                mostrar(excusiones);
                menuExcursiones();


                break;
            case 2:

                System.out.println("introduce el codigo");
                String codigo = this.teclado.nextLine();
                System.out.println("introduce la descripción");
                String descr = this.teclado.nextLine();
                LocalDate fecha = obtenerFecha(teclado, "");// llama al método validar fecha correcta
                System.out.println("introduce el numero de dias");
                int dias = this.teclado.nextInt();
                teclado.nextLine();
                System.out.println("introduce el precio");
                double precio = this.teclado.nextDouble();
                teclado.nextLine();

                controlador.añadirExcursion(codigo, descr, fecha, dias, precio);
                menuExcursiones();
                break;
            case 3:
                System.out.println("funcion EliminarExcursion()");
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
            case 1:
                menusubSocios();
                break;
            case 2:
                System.out.println("funcion CrearSocioFederado()");
                break;
            case 3:
                System.out.println("funcion CrearSocioInfantil()");
                break;
            case 4:
                System.out.println("funcion CrearSocioEstandar()");
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
                break;
            case 2:
                System.out.println("funcion MostrarSociosEstandar");
                break;
            case 3:
                System.out.println("funcion MostrarSociosFederados");
                break;
            case 4:
                System.out.println("funcion MostrarSociosInfantiles");
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
                System.out.println("funcion MostrarInscripciones()");
                break;
            case 2:
                System.out.println("funcion CrearInscripciones()");
                break;
            case 3:
                System.out.println("funcion EliminarInscripciones()");
                break;
            case 4:
                inicio();
                break;
            default:
                System.out.println("Cerrando programa...");
                break;
        }
    }

    /**
     * Metodo que comprueba si una fecha cumple con el formato AAA-MM-DD
     *
     * @param teclado
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
     * Este metodo muestra por pantalla el contenido del ArrayList pasado como parametro
     * @param datosMostrar El Array list a mostrar
     * @param <T> cualquier elemento
     */
    public <T> void mostrar(ArrayList<T> datosMostrar) {
        for (T elemento : datosMostrar) {

            System.out.println(elemento.toString());

        }
    }
}


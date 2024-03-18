package src.ProjectCode;


import src.ProjectCode.controlador.Controlador;
import src.ProjectCode.modelo.Datos;
import src.ProjectCode.vista.A_MenuInicial;




public class Main {
    public static void main(String[] args) {


        Datos datos = new Datos();
        Controlador controlador = new Controlador(datos);
        A_MenuInicial prog = new A_MenuInicial(controlador);
        prog.inicio();
    }
}

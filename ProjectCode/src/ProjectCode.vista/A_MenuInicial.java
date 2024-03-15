import javax.swing.JOptionPane;
import java.util.ArrayList;
public class A_MenuInicial {
    ArrayList<String> MenuInicio = new ArrayList<>();
    public static void main(String[] args){
        A_MenuInicial menuInicial = new A_MenuInicial();
        menuInicial.MenuInicial();
    }

    public void addMenuInicio(){
        MenuInicio.add("EXCUSIONES");
        MenuInicio.add("SOCIOS");
        MenuInicio.add("INSCRIPCIONES");
        MenuInicio.add("SALIR");
    }
    

    private void MenuInicial(){
        if(MenuInicio.size()<=0){
            addMenuInicio();
        }
        StringBuilder mensajeInicio = new StringBuilder();
        mensajeInicio.append("MENU DE INICIO:\n");
        for(int i=0; i < MenuInicio.size(); i++){
            mensajeInicio.append((i + 1) + ") " + MenuInicio.get(i) + "\n");
        }
        int eleccion = Integer.parseInt(JOptionPane.showInputDialog(mensajeInicio.toString()));
    }
}

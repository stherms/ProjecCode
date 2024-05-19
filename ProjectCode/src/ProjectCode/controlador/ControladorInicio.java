package ProjectCode.controlador;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ControladorInicio {

    public static String modoEjecucion = "";

    public void mostrarSocios() {
        try {
            //Abrir ventana para mostrar los datos
            modoEjecucion = "mostrar";
            Parent root = FXMLLoader.load(getClass().getResource("/ProjectCode/vista/MostrarSocios.fxml"));
            Scene scene = new Scene(root, 700, 800);
            Stage primaryStage = new Stage();
            primaryStage.initStyle(StageStyle.DECORATED);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void borrarSocios() {
        try {
            modoEjecucion = "borrar";
            Parent root = FXMLLoader.load(getClass().getResource("/ProjectCode/vista/MostrarSocios.fxml"));
            Scene scene = new Scene(root, 700, 800);
            Stage primaryStage = new Stage();
            primaryStage.initStyle(StageStyle.DECORATED);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void abrirInsertarInfantil() {
        try {
            ControladorInicio.modoEjecucion = "insertar";
            Parent root = FXMLLoader.load(getClass().getResource("/ProjectCode/vista/SocioInfantilDetalle.fxml"));
            Scene scene = new Scene(root, 640, 400);
            Stage primaryStage = new Stage();
            primaryStage.initStyle(StageStyle.DECORATED);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void abrirInsertarEstandar() {
        try {
            ControladorInicio.modoEjecucion = "insertar";
            Parent root = FXMLLoader.load(getClass().getResource("/ProjectCode/vista/SocioEstandarDetalle.fxml"));
            Scene scene = new Scene(root, 640, 400);
            Stage primaryStage = new Stage();
            primaryStage.initStyle(StageStyle.DECORATED);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void abrirInsertarFederado() {
        try {
            ControladorInicio.modoEjecucion = "insertar";
            Parent root = FXMLLoader.load(getClass().getResource("/ProjectCode/vista/SocioFederadoDetalle.fxml"));
            Scene scene = new Scene(root, 640, 400);
            Stage primaryStage = new Stage();
            primaryStage.initStyle(StageStyle.DECORATED);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void salir() {
        System.exit(0);
    }
}

package co.edu.uniquindio.parcial1fx.parcial1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class EmpresaTransporteApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(EmpresaTransporteApplication.class.getResource("EmpresaTransporte.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("App Empresa Transporte");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
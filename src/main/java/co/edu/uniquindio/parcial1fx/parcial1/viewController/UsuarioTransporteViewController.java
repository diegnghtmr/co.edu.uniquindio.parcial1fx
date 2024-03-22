package co.edu.uniquindio.parcial1fx.parcial1.viewController;

import co.edu.uniquindio.parcial1fx.parcial1.controller.UsuarioController;
import co.edu.uniquindio.parcial1fx.parcial1.factory.ModelFactory;
import javafx.fxml.FXML;

import java.net.URL;
import java.util.ResourceBundle;

public class UsuarioTransporteViewController {
    UsuarioController usuarioController;

    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void initialize() {
        usuarioController = new UsuarioController();
    }
}

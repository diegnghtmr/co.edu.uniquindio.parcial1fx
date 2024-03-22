package co.edu.uniquindio.parcial1fx.parcial1.viewController;

import co.edu.uniquindio.parcial1fx.parcial1.controller.PropietarioController;
import co.edu.uniquindio.parcial1fx.parcial1.controller.PropietarioVehiculoController;
import javafx.fxml.FXML;

import java.net.URL;
import java.util.ResourceBundle;

public class PropietarioVehiculoViewController {
    PropietarioVehiculoController propietarioVehiculoController;

    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void initialize() {
        propietarioVehiculoController = new PropietarioVehiculoController();
    }
}

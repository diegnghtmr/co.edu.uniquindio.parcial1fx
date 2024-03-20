package co.edu.uniquindio.parcial1fx.parcial1.viewController;

import co.edu.uniquindio.parcial1fx.parcial1.controller.PropietarioController;
import co.edu.uniquindio.parcial1fx.parcial1.factory.ModelFactory;
import co.edu.uniquindio.parcial1fx.parcial1.model.Vehiculo;
import co.edu.uniquindio.parcial1fx.parcial1.util.AssertionUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Collection;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class PropietarioViewController {

    PropietarioController propietarioController;

    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAgregarPropietario;

    @FXML
    private Button btnEditarPropietario;

    @FXML
    private Button btnEliminarPropietario;

    @FXML
    private Button btnCrearPropietario;

    @FXML
    private TextField txtCedulaPropietario;

    @FXML
    private TextField txtCelularPropietario;

    @FXML
    private TextField txtEdadPropietario;

    @FXML
    private TextField txtEmailPropietario;

    @FXML
    private TextField txtNombrePropietario;

    @FXML
    void onAgregarPropietario(ActionEvent event) {
        agregarPropietario();
    }

    @FXML
    void onCrearPropietario(ActionEvent event) {

    }

    @FXML
    void onEditarPropietario(ActionEvent event) {

    }

    @FXML
    void onEliminarPropietario(ActionEvent event) {

    }

    void initialize() {
        propietarioController = new PropietarioController();
    }

    private void agregarPropietario() {
//        AssertionUtil.assertion(txtNombrePropietario.getText() != null &&
//                        !txtNombrePropietario.getText().isBlank(),
//                "El nombre del propietario no puede ser nulo o vacío");
//        AssertionUtil.assertion(txtCedulaPropietario.getText() != null &&
//                        !txtCedulaPropietario.getText().isBlank(),
//                "La cédula del propietario no puede ser nula o vacía");
//        AssertionUtil.assertion(txtEmailPropietario.getText() != null &&
//                        !txtEmailPropietario.getText().isBlank(),
//                "El email del propietario no puede ser nulo o vacío");
//        AssertionUtil.assertion(txtCelularPropietario.getText() != null &&
//                        !txtCelularPropietario.getText().isBlank(),
//                "El celular del propietario no puede ser nulo o vacío");
//        AssertionUtil.assertion(txtEdadPropietario.getText() != null &&
//                        !txtEdadPropietario.getText().isBlank(),
//                "La edad del propietario no puede ser nula o vacía");
//
//        boolean propietarioCreado = modelFactory.crearPropietario
//                (txtNombrePropietario.getText(), txtCedulaPropietario.getText(),
//                        txtEmailPropietario.getText(),
//                        txtCelularPropietario.getText(),
//                        Integer.parseInt(txtEdadPropietario.getText()));
//
//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle("Creación de Propietario");
//
//        if (propietarioCreado) {
//            String mensaje = "Propietario creado exitosamente: "
//                    +txtNombrePropietario.getText() + " "
//                    + txtCedulaPropietario.getText();
//            alert.setHeaderText(null);
//            alert.setContentText(mensaje);
//        } else {
//            alert.setHeaderText(null);
//            alert.setContentText("No se pudo crear el propietario.");
//        }
//
//        alert.showAndWait();
    }
}

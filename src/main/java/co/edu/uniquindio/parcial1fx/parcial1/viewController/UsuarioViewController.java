package co.edu.uniquindio.parcial1fx.parcial1.viewController;

import co.edu.uniquindio.parcial1fx.parcial1.controller.UsuarioController;
import co.edu.uniquindio.parcial1fx.parcial1.factory.ModelFactory;
import co.edu.uniquindio.parcial1fx.parcial1.model.VehiculoTransporte;
import co.edu.uniquindio.parcial1fx.parcial1.util.AssertionUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class UsuarioViewController {

    UsuarioController usuarioController;

    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAgregarUsuario;

    @FXML
    private Button btnCrearUsuario;

    @FXML
    private Button btnEditarUsuario;

    @FXML
    private Button btnEliminarUsuario;

    @FXML
    private TextField txtEdadUsuario;

    @FXML
    private TextField txtIDUsuario;

    @FXML
    private TextField txtNombreUsuario;

    @FXML
    private TextField txtPesoUsuario;

    @FXML
    void onAgregarUsuario(ActionEvent event) {
        agregarUsuario();
    }

    @FXML
    void onCrearUsuario(ActionEvent event) {

    }

    @FXML
    void onEditarUsuario(ActionEvent event) {

    }

    @FXML
    void onEliminarUsuario(ActionEvent event) {

    }

    void initialize() {
        usuarioController = new UsuarioController();
    }


    private void agregarUsuario() {
//        AssertionUtil.assertion(txtNombreUsuario.getText() != null &&
//                        !txtNombreUsuario.getText().isBlank(),
//                "El nombre del usuario no puede ser nulo o vacío");
//        AssertionUtil.assertion(txtIDUsuario.getText() != null &&
//                        !txtIDUsuario.getText().isBlank(),
//                "La ID del usuario no puede ser nula o vacía");
//        AssertionUtil.assertion(txtEdadUsuario.getText() != null &&
//                        !txtEdadUsuario.getText().isBlank(),
//                "La edad del usuario no puede ser nula o vacía");
//        AssertionUtil.assertion(txtPesoUsuario.getText() != null &&
//                        !txtPesoUsuario.getText().isBlank(),
//                "El peso del usuario no puede ser nulo o vacío");
//
//        boolean usuarioCreado = modelFactory.crearUsuario(
//                txtNombreUsuario.getText().trim(),
//                txtIDUsuario.getText().trim(),
//                Integer.parseInt(txtEdadUsuario.getText().trim()),
//                Double.parseDouble(txtPesoUsuario.getText().trim()));
//
//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle("Creación de Usuario");
//
//        if (usuarioCreado) {
//            String mensaje = "Usuario creado exitosamente: "
//                    +txtNombreUsuario.getText() + " "
//                    + txtIDUsuario.getText();
//            alert.setHeaderText(null);
//            alert.setContentText(mensaje);
//        } else {
//            alert.setHeaderText(null);
//            alert.setContentText("No se pudo crear el usuario.");
//        }
//
//        alert.showAndWait();
    }
}

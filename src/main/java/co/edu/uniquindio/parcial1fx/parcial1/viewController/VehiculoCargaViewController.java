package co.edu.uniquindio.parcial1fx.parcial1.viewController;

import co.edu.uniquindio.parcial1fx.parcial1.controller.VehiculoCargaController;
import co.edu.uniquindio.parcial1fx.parcial1.factory.ModelFactory;
import co.edu.uniquindio.parcial1fx.parcial1.model.Propietario;
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

public class VehiculoCargaViewController {
    VehiculoCargaController vehiculoCargaController;

    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAgregarVehiculoCarga;

    @FXML
    private Button btnCrearVehiculoCarga;

    @FXML
    private Button btnEditarVehiculoCarga;

    @FXML
    private Button btnEliminarVehiculoCarga;

    @FXML
    private TextField txtCapacidadCargaVehiculoCarga;

    @FXML
    private TextField txtColorVehiculoCarga;

    @FXML
    private TextField txtMarcaVehiculoCarga;

    @FXML
    private TextField txtModeloVehiculoCarga;

    @FXML
    private TextField txtNumeroChassisVehiculoCarga;

    @FXML
    private TextField txtNumeroEjesVehiculoCarga;

    @FXML
    private TextField txtPlacaVehiculoCarga;

    @FXML
    void onAgregarVehiculoCarga(ActionEvent event) {
        agregarVehiculoCarga();
    }

    @FXML
    void onCrearVehiculoCarga(ActionEvent event) {

    }

    @FXML
    void onEditarVehiculoCarga(ActionEvent event) {

    }

    @FXML
    void onEliminarVehiculoCarga(ActionEvent event) {

    }

    void initialize() {
        vehiculoCargaController = new VehiculoCargaController();
    }

    private void agregarVehiculoCarga() {
//        AssertionUtil.assertion(txtPlacaVehiculoCarga.getText() != null &&
//                        !txtPlacaVehiculoCarga.getText().isBlank(),
//                "La placa del vehículo de carga no puede ser nula o vacía");
//        AssertionUtil.assertion(txtModeloVehiculoCarga.getText() != null &&
//                        !txtModeloVehiculoCarga.getText().isBlank(),
//                "El modelo del vehículo de carga no puede ser nulo o vacío");
//        AssertionUtil.assertion(txtMarcaVehiculoCarga.getText() != null &&
//                        !txtMarcaVehiculoCarga.getText().isBlank(),
//                "La marca del vehículo de carga no puede ser nula o vacía");
//        AssertionUtil.assertion(txtColorVehiculoCarga.getText() != null &&
//                        !txtColorVehiculoCarga.getText().isBlank(),
//                "El color del vehículo de carga no puede ser nulo o vacío");
//        AssertionUtil.assertion(txtCapacidadCargaVehiculoCarga.getText() != null &&
//                        !txtCapacidadCargaVehiculoCarga.getText().isBlank(),
//                "La capacidad de carga del vehículo de carga no puede ser nula o vacía");
//        AssertionUtil.assertion(txtNumeroEjesVehiculoCarga.getText() != null &&
//                        !txtNumeroEjesVehiculoCarga.getText().isBlank(),
//                "El número de ejes del vehículo de carga no puede ser nulo o vacío");
//        AssertionUtil.assertion(txtNumeroChassisVehiculoCarga.getText() != null &&
//                        !txtNumeroChassisVehiculoCarga.getText().isBlank(),
//                "El número de chasis del vehículo de carga no puede ser nulo o vacío");
//
//        boolean vehiculoCargaCreado = modelFactory.crearVehiculoCarga
//                (txtPlacaVehiculoCarga.getText(), txtModeloVehiculoCarga.getText(),
//                        txtMarcaVehiculoCarga.getText(), txtColorVehiculoCarga.getText(),
//                        Double.parseDouble(txtCapacidadCargaVehiculoCarga.getText()),
//                        Integer.parseInt(txtNumeroEjesVehiculoCarga.getText()),
//                        txtNumeroChassisVehiculoCarga.getText());
//
//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle("Creación de Vehículo de Carga");
//
//        if (vehiculoCargaCreado) {
//            String mensaje = "Vehículo de Carga creado exitosamente: "
//                    +txtPlacaVehiculoCarga.getText();
//            alert.setHeaderText(null);
//            alert.setContentText(mensaje);
//        } else {
//            alert.setHeaderText(null);
//            alert.setContentText("No se pudo crear el vehículo de carga.");
//        }
//
//        alert.showAndWait();
    }
}

package co.edu.uniquindio.parcial1fx.parcial1.viewController;

import co.edu.uniquindio.parcial1fx.parcial1.controller.VehiculoTransporteController;
import co.edu.uniquindio.parcial1fx.parcial1.factory.ModelFactory;
import co.edu.uniquindio.parcial1fx.parcial1.model.Propietario;
import co.edu.uniquindio.parcial1fx.parcial1.model.Usuario;
import co.edu.uniquindio.parcial1fx.parcial1.model.VehiculoTransporte;
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

public class VehiculoTransporteViewController {
    VehiculoTransporteController vehiculoTransporteController;

    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAgregarVehiculoTransporte;

    @FXML
    private Button btnCrearVehiculoTransporte;

    @FXML
    private Button btnEditarVehiculoTransporte;

    @FXML
    private Button btnEliminarVehiculoTransporte;

    @FXML
    private TextField txtColorVehiculoTransporte;

    @FXML
    private TextField txtMarcaVehiculoTransporte;

    @FXML
    private TextField txtModeloVehiculoTransporte;

    @FXML
    private TextField txtNumeroChassisVehiculoTransporte;

    @FXML
    private TextField txtNumeroMaxPasajerosVehiculoTransporte;

    @FXML
    private TextField txtPlacaVehiculoTransporte;

    @FXML
    void onAgregarVehiculoTransporte(ActionEvent event) {
        agregarVehiculoTransporte();
    }

    @FXML
    void onCrearVehiculoTransporte(ActionEvent event) {

    }

    @FXML
    void onEditarVehiculoTransporte(ActionEvent event) {

    }
    
    @FXML
    void onEliminarVehiculoTransporte(ActionEvent event) {

    }

    void initialize() {
        vehiculoTransporteController = new VehiculoTransporteController();
    }

    private void agregarVehiculoTransporte() {
//        AssertionUtil.assertion(txtPlacaVehiculoTransporte.getText() != null &&
//                        !txtPlacaVehiculoTransporte.getText().isBlank(),
//                "La placa del vehículo de transporte no puede ser nula o vacía");
//        AssertionUtil.assertion(txtModeloVehiculoTransporte.getText() != null &&
//                        !txtModeloVehiculoTransporte.getText().isBlank(),
//                "El modelo del vehículo de transporte no puede ser nulo o vacío");
//        AssertionUtil.assertion(txtMarcaVehiculoTransporte.getText() != null &&
//                        !txtMarcaVehiculoTransporte.getText().isBlank(),
//                "La marca del vehículo de transporte no puede ser nula o vacía");
//        AssertionUtil.assertion(txtColorVehiculoTransporte.getText() != null &&
//                        !txtColorVehiculoTransporte.getText().isBlank(),
//                "El color del vehículo de transporte no puede ser nulo o vacío");
//        AssertionUtil.assertion(txtNumeroMaxPasajerosVehiculoTransporte.getText() != null &&
//                        !txtNumeroMaxPasajerosVehiculoTransporte.getText().isBlank(),
//                "El número máximo de pasajeros del vehículo de transporte no puede ser nulo o vacío");
//        AssertionUtil.assertion(txtNumeroChassisVehiculoTransporte.getText() != null &&
//                        !txtNumeroChassisVehiculoTransporte.getText().isBlank(),
//                "El número de chasis del vehículo de transporte no puede ser nulo o vacío");
//
//        boolean vehiculoTransporteCreado = modelFactory.crearVehiculoTransporte
//                (txtPlacaVehiculoTransporte.getText(), txtModeloVehiculoTransporte.getText(),
//                        txtMarcaVehiculoTransporte.getText(),
//                        txtColorVehiculoTransporte.getText(),
//                        Integer.parseInt(txtNumeroMaxPasajerosVehiculoTransporte.getText()),
//                        txtNumeroChassisVehiculoTransporte.getText());
//
//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle("Creación de Vehículo de Transporte");
//
//        if (vehiculoTransporteCreado) {
//            String mensaje = "Vehículo de Transporte creado exitosamente: "
//                    +txtPlacaVehiculoTransporte.getText();
//            alert.setHeaderText(null);
//            alert.setContentText(mensaje);
//        } else {
//            alert.setHeaderText(null);
//            alert.setContentText("No se pudo crear el vehículo de transporte.");
//        }
//
//        alert.showAndWait();
    }
}

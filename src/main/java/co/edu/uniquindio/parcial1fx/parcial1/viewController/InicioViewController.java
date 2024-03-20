package co.edu.uniquindio.parcial1fx.parcial1.viewController;

import co.edu.uniquindio.parcial1fx.parcial1.controller.InicioController;
import co.edu.uniquindio.parcial1fx.parcial1.factory.ModelFactory;
import co.edu.uniquindio.parcial1fx.parcial1.util.AssertionUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class InicioViewController {
    InicioController inicioController;

    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCalcularPasajerosTransportados;

    @FXML
    private Button btnObtenerAdultosMayores;

    @FXML
    private Button btnObtenerMayoresEdad;

    @FXML
    private Button btnObtenerNumeroUsuariosPlaca;

    @FXML
    private Button btnObtenerUsuariosSuperioresPeso;

    @FXML
    private TextField txtPesoObtenerNumeroUsuariosPesoInicio;

    @FXML
    private TextField txtPlacaObtenerNumeroUsuariosPlacaInicio;

    @FXML
    private TextArea txtResultadoInicio;


    @FXML
    void onObtenerAdultosMayores(ActionEvent event) {
        obtenerAdultosMayores();
    }

    @FXML
    void onObtenerUsuariosSuperiorPeso(ActionEvent event) {
        obtenerUsuariosSuperioresPeso();
    }


    @FXML
    void onCalcularPasajerosTransportados(ActionEvent event) {
        calcularPasajerosTransportados();
    }

    @FXML
    void onObtenerMayoresEdad(ActionEvent event) {
        obtenerMayoresEdad();
    }

    @FXML
    void onObtenerNumeroUsuariosPlaca(ActionEvent event) {
        obtenerNumeroUsuariosPlaca();
    }

    @FXML
    void initialize() {
        inicioController = new InicioController();
    }


    private void calcularPasajerosTransportados() {
//        int pasajerosTransportados = modelFactory.calcularPasajerosTransportados();
//
//        txtResultadoInicio.setText("Pasajeros transportados: " + pasajerosTransportados);
    }

    private void obtenerMayoresEdad() {
//        long mayoresEdad = modelFactory.obtenerMayoresEdad();
//
//        txtResultadoInicio.setText("Usuarios mayores de edad: " + mayoresEdad);
    }

    private void obtenerNumeroUsuariosPlaca() {
//        AssertionUtil.assertion(txtPlacaObtenerNumeroUsuariosPlacaInicio.getText() != null &&
//                        !txtPlacaObtenerNumeroUsuariosPlacaInicio.getText().isBlank(),
//                "La placa del vehículo no puede ser nula o vacía");
//
//        int numeroUsuarios = modelFactory.obtenerNumeroUsuariosPlaca
//                (txtPlacaObtenerNumeroUsuariosPlacaInicio.getText());
//
//        txtResultadoInicio.setText("El vehiculo identificado con la placa " +
//                txtPlacaObtenerNumeroUsuariosPlacaInicio.getText() +
//                " tiene " +
//                numeroUsuarios +
//                " usuarios.");
    }

    private void obtenerAdultosMayores() {
//        long adultosMayores = modelFactory.obtenerAdultosMayores();
//
//        txtResultadoInicio.setText("Adultos mayores: " + adultosMayores);
    }

    private void obtenerUsuariosSuperioresPeso() {
//        AssertionUtil.assertion(txtPesoObtenerNumeroUsuariosPesoInicio.getText() != null &&
//                        !txtPesoObtenerNumeroUsuariosPesoInicio.getText().isBlank(),
//                "El peso no puede ser nulo o vacío");
//
//        long numeroUsuarios = modelFactory.obtenerUsuariosSuperioresPeso
//                (Double.parseDouble(txtPesoObtenerNumeroUsuariosPesoInicio.getText()));
//
//        txtResultadoInicio.setText("Usuarios con peso superior a " +
//                txtPesoObtenerNumeroUsuariosPesoInicio.getText() + ": " +
//                numeroUsuarios);
    }

}

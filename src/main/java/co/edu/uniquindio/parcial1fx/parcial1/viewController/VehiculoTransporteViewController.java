package co.edu.uniquindio.parcial1fx.parcial1.viewController;

import co.edu.uniquindio.parcial1fx.parcial1.controller.VehiculoTransporteController;
import co.edu.uniquindio.parcial1fx.parcial1.factory.ModelFactory;
import co.edu.uniquindio.parcial1fx.parcial1.model.Propietario;
import co.edu.uniquindio.parcial1fx.parcial1.model.Usuario;
import co.edu.uniquindio.parcial1fx.parcial1.model.VehiculoCarga;
import co.edu.uniquindio.parcial1fx.parcial1.model.VehiculoTransporte;
import co.edu.uniquindio.parcial1fx.parcial1.model.builder.VehiculoTransporteBuilder;
import co.edu.uniquindio.parcial1fx.parcial1.util.AssertionUtil;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Optional;
import java.util.ResourceBundle;

public class VehiculoTransporteViewController {
    VehiculoTransporteController vehiculoTransporteController;
    ObservableList<VehiculoTransporte> listaVehiculosTransporte = FXCollections.observableArrayList();
    VehiculoTransporte vehiculoTransporteSeleccionado;

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
    private TableView<VehiculoTransporte> tableVehiculoTransporte;

    @FXML
    private TableColumn<VehiculoTransporte, String> tcColorVehiculoTransporte;

    @FXML
    private TableColumn<VehiculoTransporte, String> tcMarcaVehiculoTransporte;

    @FXML
    private TableColumn<VehiculoTransporte, String> tcMaxPasajerosVehiculoTransporte;

    @FXML
    private TableColumn<VehiculoTransporte, String> tcModeloVehiculoTransporte;

    @FXML
    private TableColumn<VehiculoTransporte, String> tcNumeroChassisVehiculoTransporte;

    @FXML
    private TableColumn<VehiculoTransporte, String> tcPlacaVehiculoTransporte;

    @FXML
    void onAgregarVehiculoTransporte(ActionEvent event) {
        agregarVehiculoTransporte();
    }

    @FXML
    void onCrearVehiculoTransporte(ActionEvent event) {
        limpiarCampos();
        deseleccionarVehiculoTransporte();
    }

    @FXML
    void onEditarVehiculoTransporte(ActionEvent event) {
        editarVehiculoTransporte();
    }

    @FXML
    void onEliminarVehiculoTransporte(ActionEvent event) {
        eliminarVehiculoTransporte();
    }

    @FXML
    void initialize() {
        vehiculoTransporteController = new VehiculoTransporteController();
        initView();
    }

    private void initView() {
        initDataBinding();
        obtenerVehiculosTransporte();
        tableVehiculoTransporte.getItems().clear();
        tableVehiculoTransporte.setItems(listaVehiculosTransporte);
        listenerSelection();
    }

    private void initDataBinding() {
        tcPlacaVehiculoTransporte.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPlaca()));
        tcModeloVehiculoTransporte.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getModelo()));
        tcMarcaVehiculoTransporte.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMarca()));
        tcColorVehiculoTransporte.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getColor()));
        tcMaxPasajerosVehiculoTransporte.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getNumeroMaxPasajeros())));
        tcNumeroChassisVehiculoTransporte.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNumeroChassis()));


    }

    private void obtenerVehiculosTransporte() {
        listaVehiculosTransporte.addAll(vehiculoTransporteController.obtenerVehiculosTransporte());
    }

    private void listenerSelection() {
        tableVehiculoTransporte.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            vehiculoTransporteSeleccionado = newSelection;
            mostrarInformacionCliente(vehiculoTransporteSeleccionado);
        });
    }

    private void mostrarInformacionCliente(VehiculoTransporte vehiculoTransporteSeleccionado) {
        if (vehiculoTransporteSeleccionado != null) {
            txtPlacaVehiculoTransporte.setText(vehiculoTransporteSeleccionado.getPlaca());
            txtModeloVehiculoTransporte.setText(vehiculoTransporteSeleccionado.getModelo());
            txtMarcaVehiculoTransporte.setText(vehiculoTransporteSeleccionado.getMarca());
            txtColorVehiculoTransporte.setText(vehiculoTransporteSeleccionado.getColor());
            txtNumeroMaxPasajerosVehiculoTransporte.setText(String.valueOf(vehiculoTransporteSeleccionado.getNumeroMaxPasajeros()));
            txtNumeroChassisVehiculoTransporte.setText(vehiculoTransporteSeleccionado.getNumeroChassis());
        }
    }

    private void agregarVehiculoTransporte() {
        if (validarFormulario()) {
            VehiculoTransporte vehiculoTransporte = construirDatosVehiculoTransporte();
            if (vehiculoTransporteController.crearVehiculoTransporte(vehiculoTransporte)) {
                listaVehiculosTransporte.add(vehiculoTransporte);
                mostrarMensaje("Notificación Vehiculo Transporte", "Vehiculo Transporte Creado",
                        "El vehiculo transporte fue creado exitosamente", Alert.AlertType.INFORMATION);
                limpiarCampos();
            } else {
                mostrarMensaje("Notificación Vehiculo Transporte", "Vehiculo Transporte No Creado",
                        "El vehiculo transporte no pudo ser creado", Alert.AlertType.ERROR);
            }
        } else {
            mostrarMensaje("Notificación Vehiculo Transporte", "Vehiculo Transporte No Creado",
                    "Los datos ingresados no son validos", Alert.AlertType.ERROR);
        }
    }




    private boolean validarFormulario() {
        return !txtPlacaVehiculoTransporte.getText().isEmpty()
                && !txtModeloVehiculoTransporte.getText().isEmpty()
                && !txtMarcaVehiculoTransporte.getText().isEmpty()
                && !txtColorVehiculoTransporte.getText().isEmpty()
                && !txtNumeroMaxPasajerosVehiculoTransporte.getText().isEmpty()
                && !txtNumeroChassisVehiculoTransporte.getText().isEmpty();
    }

    private VehiculoTransporte construirDatosVehiculoTransporte() {
        return new VehiculoTransporteBuilder()
                .setPlaca(txtPlacaVehiculoTransporte.getText())
                .setModelo(txtModeloVehiculoTransporte.getText())
                .setMarca(txtMarcaVehiculoTransporte.getText())
                .setColor(txtColorVehiculoTransporte.getText())
                .setNumeroMaxPasajeros(Integer.parseInt(txtNumeroMaxPasajerosVehiculoTransporte.getText()))
                .setNumeroChasis(txtNumeroChassisVehiculoTransporte.getText())
                .build();
    }

    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert aler = new Alert(alertType);
        aler.setTitle(titulo);
        aler.setHeaderText(header);
        aler.setContentText(contenido);
        aler.showAndWait();
    }

    private boolean mostrarMensajeConfirmacion(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Confirmación");
        alert.setContentText(mensaje);
        Optional<ButtonType> action = alert.showAndWait();
        if (action.get() == ButtonType.OK) {
            return true;
        } else {
            return false;
        }
    }

    private void limpiarCampos() {
        txtPlacaVehiculoTransporte.setText("");
        txtModeloVehiculoTransporte.setText("");
        txtMarcaVehiculoTransporte.setText("");
        txtColorVehiculoTransporte.setText("");
        txtNumeroMaxPasajerosVehiculoTransporte.setText("");
        txtNumeroChassisVehiculoTransporte.setText("");
    }

    private void eliminarVehiculoTransporte() {
        if (vehiculoTransporteSeleccionado != null) {
            boolean confirmacion = mostrarMensajeConfirmacion("¿Está seguro de que desea eliminar el vehiculo transporte seleccionado?");
            if (confirmacion) {
                boolean resultado = vehiculoTransporteController.eliminarPropietario(vehiculoTransporteSeleccionado);
                if (resultado) {
                    listaVehiculosTransporte.remove(vehiculoTransporteSeleccionado);
                    mostrarMensaje("Notificación Vehiculo Transporte", "Vehiculo Transporte Eliminado",
                            "El vehiculo transporte fue eliminado exitosamente", Alert.AlertType.INFORMATION);
                    limpiarCampos();
                } else {
                    mostrarMensaje("Notificación Vehiculo Transporte", "Error al eliminar",
                            "No se pudo eliminar el vehiculo transporte", Alert.AlertType.ERROR);
                }
            }
        } else {
            mostrarMensaje("Notificación Vehiculo Transporte", "Ningún Vehiculo Transporte Seleccionado",
                    "Debe seleccionar un vehiculo transporte para eliminar", Alert.AlertType.WARNING);
        }
    }

    private void deseleccionarVehiculoTransporte() {
        tableVehiculoTransporte.getSelectionModel().clearSelection();
        vehiculoTransporteSeleccionado = null;
    }

    private void editarVehiculoTransporte() {
        if (vehiculoTransporteSeleccionado != null) {
            VehiculoTransporte vehiculoTransporteEditado = construirDatosVehiculoTransporte();
            boolean resultado = vehiculoTransporteController.editarVehiculoTransporte(vehiculoTransporteSeleccionado, vehiculoTransporteEditado);
            if (resultado) {
                actualizarListaVehiculoTransporte(vehiculoTransporteSeleccionado, vehiculoTransporteEditado);
                mostrarMensaje("Edición", "Vehiculo Transporte Editado", "El vehiculo transporte ha sido editado correctamente.", Alert.AlertType.INFORMATION);
                limpiarCampos();
            } else {
                mostrarMensaje("Edición", "Error", "No se pudo editar el vehiculo transporte.", Alert.AlertType.ERROR);
            }
        } else {
            mostrarMensaje("Edición", "Selección Requerida", "Debe seleccionar un vehiculo transporte para editarlo.", Alert.AlertType.WARNING);
        }
    }

    private void actualizarListaVehiculoTransporte(VehiculoTransporte vehiculoTransporteSeleccionado, VehiculoTransporte vehiculoTransporteEditado) {
        int indice = listaVehiculosTransporte.indexOf(vehiculoTransporteSeleccionado);
        if (indice != -1) {
            listaVehiculosTransporte.set(indice, vehiculoTransporteEditado);
        }
    }
}

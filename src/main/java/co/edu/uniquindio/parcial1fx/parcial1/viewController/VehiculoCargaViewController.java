package co.edu.uniquindio.parcial1fx.parcial1.viewController;

import co.edu.uniquindio.parcial1fx.parcial1.controller.VehiculoCargaController;
import co.edu.uniquindio.parcial1fx.parcial1.factory.ModelFactory;
import co.edu.uniquindio.parcial1fx.parcial1.model.Propietario;
import co.edu.uniquindio.parcial1fx.parcial1.model.VehiculoCarga;
import co.edu.uniquindio.parcial1fx.parcial1.model.builder.VehiculoCargaBuilder;
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

public class VehiculoCargaViewController {
    VehiculoCargaController vehiculoCargaController;
    ObservableList<VehiculoCarga> listaVehiculosCarga = FXCollections.observableArrayList();
    VehiculoCarga vehiculoCargaSeleccionado;

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
    private TableView<VehiculoCarga> tableVehiculoCarga;

    @FXML
    private TableColumn<VehiculoCarga, String> tcCapacidadCargaVehiculoCarga;

    @FXML
    private TableColumn<VehiculoCarga, String> tcColorVehiculoCarga;

    @FXML
    private TableColumn<VehiculoCarga, String> tcMarcaVehiculoCarga;

    @FXML
    private TableColumn<VehiculoCarga, String> tcModeloVehiculoCarga;

    @FXML
    private TableColumn<VehiculoCarga, String> tcNumeroChassisVehiculoCarga;

    @FXML
    private TableColumn<VehiculoCarga, String> tcNumeroEjesVehiculoCarga;

    @FXML
    private TableColumn<VehiculoCarga, String> tcPlacaVehiculoCarga;

    @FXML
    void onAgregarVehiculoCarga(ActionEvent event) {
        agregarVehiculoCarga();
    }

    @FXML
    void onCrearVehiculoCarga(ActionEvent event) {
        limpiarCampos();
        deseleccionarVehiculoCarga();
    }

    @FXML
    void onEditarVehiculoCarga(ActionEvent event) {
        editarVehiculoCarga();
    }

    @FXML
    void onEliminarVehiculoCarga(ActionEvent event) {
        eliminarVehiculoCarga();
    }

    @FXML
    void initialize() {
        vehiculoCargaController = new VehiculoCargaController();
        initView();
    }

    private void initView() {
        initDataBinding();
        obtenerVehiculosCarga();
        tableVehiculoCarga.getItems().clear();
        tableVehiculoCarga.setItems(listaVehiculosCarga);
        listenerSelection();
    }

    private void initDataBinding() {
        tcPlacaVehiculoCarga.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPlaca()));
        tcModeloVehiculoCarga.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getModelo()));
        tcMarcaVehiculoCarga.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMarca()));
        tcColorVehiculoCarga.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getColor()));
        tcCapacidadCargaVehiculoCarga.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getCapacidadCarga())));
        tcNumeroEjesVehiculoCarga.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getNumeroEjes())));
        tcNumeroChassisVehiculoCarga.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNumeroChasis()));
    }

    private void obtenerVehiculosCarga() {
        listaVehiculosCarga.addAll(vehiculoCargaController.obtenerClientes());
    }

    private void listenerSelection() {
        tableVehiculoCarga.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            vehiculoCargaSeleccionado = newSelection;
            mostrarInformacionCliente(vehiculoCargaSeleccionado);
        });
    }

    private void mostrarInformacionCliente(VehiculoCarga vehiculoCargaSeleccionado) {
        if (vehiculoCargaSeleccionado != null) {
            txtPlacaVehiculoCarga.setText(vehiculoCargaSeleccionado.getPlaca());
            txtModeloVehiculoCarga.setText(vehiculoCargaSeleccionado.getModelo());
            txtMarcaVehiculoCarga.setText(vehiculoCargaSeleccionado.getMarca());
            txtColorVehiculoCarga.setText(vehiculoCargaSeleccionado.getColor());
            txtCapacidadCargaVehiculoCarga.setText(String.valueOf(vehiculoCargaSeleccionado.getCapacidadCarga()));
            txtNumeroEjesVehiculoCarga.setText(String.valueOf(vehiculoCargaSeleccionado.getNumeroEjes()));
            txtNumeroChassisVehiculoCarga.setText(vehiculoCargaSeleccionado.getNumeroChasis());
        }
    }

    private void agregarVehiculoCarga() {
        if (validarFormulario()) {
            VehiculoCarga vehiculoCarga = construirDatosVehiculoCarga();
            if (vehiculoCargaController.crearVehiculoCarga(vehiculoCarga)) {
                listaVehiculosCarga.add(vehiculoCarga);
                mostrarMensaje("Notificación Vehiculo Carga", "Vehiculo Carga Creado",
                        "El vehiculo carga fue creado exitosamente", Alert.AlertType.INFORMATION);
                limpiarCampos();
            } else {
                mostrarMensaje("Notificación Vehiculo Carga", "Vehiculo Carga No Creado",
                        "El vehiculo carga no pudo ser creado", Alert.AlertType.ERROR);
            }
        } else {
            mostrarMensaje("Notificación Vehiculo Carga", "Vehiculo Carga No Creado",
                    "Los datos ingresados no son validos", Alert.AlertType.ERROR);
        }
    }

    private boolean validarFormulario() {
        return !txtPlacaVehiculoCarga.getText().isEmpty()
                && !txtModeloVehiculoCarga.getText().isEmpty()
                && !txtMarcaVehiculoCarga.getText().isEmpty()
                && !txtColorVehiculoCarga.getText().isEmpty()
                && !txtCapacidadCargaVehiculoCarga.getText().isEmpty()
                && !txtNumeroEjesVehiculoCarga.getText().isEmpty()
                && !txtNumeroChassisVehiculoCarga.getText().isEmpty();
    }

    private VehiculoCarga construirDatosVehiculoCarga() {
        return new VehiculoCargaBuilder()
                .setPlaca(txtPlacaVehiculoCarga.getText())
                .setModelo(txtModeloVehiculoCarga.getText())
                .setMarca(txtMarcaVehiculoCarga.getText())
                .setColor(txtColorVehiculoCarga.getText())
                .setCapacidadCarga(Double.parseDouble(txtCapacidadCargaVehiculoCarga.getText()))
                .setNumeroEjes(Integer.parseInt(txtNumeroEjesVehiculoCarga.getText()))
                .setNumeroChasis(txtNumeroChassisVehiculoCarga.getText())
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
        txtPlacaVehiculoCarga.setText("");
        txtModeloVehiculoCarga.setText("");
        txtMarcaVehiculoCarga.setText("");
        txtColorVehiculoCarga.setText("");
        txtCapacidadCargaVehiculoCarga.setText("");
        txtNumeroEjesVehiculoCarga.setText("");
        txtNumeroChassisVehiculoCarga.setText("");
    }

    private void eliminarVehiculoCarga() {
        if (vehiculoCargaSeleccionado != null) {
            boolean confirmacion = mostrarMensajeConfirmacion("¿Está seguro de que desea eliminar el vehiculo carga seleccionado?");
            if (confirmacion) {
                boolean resultado = vehiculoCargaController.eliminarVehiculoCarga(vehiculoCargaSeleccionado);
                if (resultado) {
                    listaVehiculosCarga.remove(vehiculoCargaSeleccionado);
                    mostrarMensaje("Notificación Vehiculo Carga", "Vehiculo Carga Eliminado",
                            "El vehiculo carga fue eliminado exitosamente", Alert.AlertType.INFORMATION);
                    limpiarCampos();
                } else {
                    mostrarMensaje("Notificación Vehiculo Carga", "Error al eliminar",
                            "No se pudo eliminar el vehiculo carga", Alert.AlertType.ERROR);
                }
            }
        } else {
            mostrarMensaje("Notificación Vehiculo Carga", "Ningún Vehiculo Carga Seleccionado",
                    "Debe seleccionar un vehiculo carga para eliminar", Alert.AlertType.WARNING);
        }
    }

    private void deseleccionarVehiculoCarga() {
        tableVehiculoCarga.getSelectionModel().clearSelection();
        vehiculoCargaSeleccionado = null;
    }

    private void editarVehiculoCarga() {
        if (vehiculoCargaSeleccionado != null) {
            VehiculoCarga vehiculoCargaEditado = construirDatosVehiculoCarga();
            boolean resultado = vehiculoCargaController.editarVehiculoCarga(vehiculoCargaSeleccionado, vehiculoCargaEditado);
            if (resultado) {
                actualizarListaVehiculosCarga(vehiculoCargaSeleccionado, vehiculoCargaEditado);
                mostrarMensaje("Edición", "Vehiculo Carga Editado", "El vehiculo carga ha sido editado correctamente.", Alert.AlertType.INFORMATION);
                limpiarCampos();
            } else {
                mostrarMensaje("Edición", "Error", "No se pudo editar el vehiculo carga.", Alert.AlertType.ERROR);
            }
        } else {
            mostrarMensaje("Edición", "Selección Requerida", "Debe seleccionar un vehiculo carga para editarlo.", Alert.AlertType.WARNING);
        }
    }

    private void actualizarListaVehiculosCarga(VehiculoCarga vehiculoCargaSeleccionado, VehiculoCarga vehiculoCargaEditado) {
        int indice = listaVehiculosCarga.indexOf(vehiculoCargaSeleccionado);
        if (indice != -1) {
            listaVehiculosCarga.set(indice, vehiculoCargaEditado);
        }
    }
}

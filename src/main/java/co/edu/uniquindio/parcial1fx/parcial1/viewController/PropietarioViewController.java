package co.edu.uniquindio.parcial1fx.parcial1.viewController;

import co.edu.uniquindio.parcial1fx.parcial1.controller.PropietarioController;
import co.edu.uniquindio.parcial1fx.parcial1.factory.ModelFactory;
import co.edu.uniquindio.parcial1fx.parcial1.model.Propietario;
import co.edu.uniquindio.parcial1fx.parcial1.model.Vehiculo;
import co.edu.uniquindio.parcial1fx.parcial1.model.builder.PropietarioBuilder;
import co.edu.uniquindio.parcial1fx.parcial1.util.AssertionUtil;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.util.*;

public class PropietarioViewController {

    PropietarioController propietarioController;
    ObservableList<Propietario> listaPropietarios = FXCollections.observableArrayList();


    Propietario propietarioSeleccionado;

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
    private TableView<Propietario> tablePropietario;

    @FXML
    private TableColumn<Propietario, String> tcCedulaPropietario;

    @FXML
    private TableColumn<Propietario, String> tcCelularPropietario;

    @FXML
    private TableColumn<Propietario, String> tcEdadPropietario;

    @FXML
    private TableColumn<Propietario, String> tcEmailPropietario;

    @FXML
    private TableColumn<Propietario, String> tcNombrePropietario;

    @FXML
    void onAgregarPropietario(ActionEvent event) {
        agregarPropietario();
    }

    @FXML
    void onCrearPropietario(ActionEvent event) {
        limpiarCampos();
        deseleccionarPropietario();
    }

    @FXML
    void onEditarPropietario(ActionEvent event) {
        editarPropietario();
    }

    @FXML
    void onEliminarPropietario(ActionEvent event) {
        eliminarPropietario();
    }

    @FXML
    void initialize() {
        propietarioController = new PropietarioController();
        initView();
    }

    private void initView() {
        initDataBinding();
        obtenerPropietarios();
        tablePropietario.getItems().clear();
        tablePropietario.setItems(listaPropietarios);
        listenerSelection();
    }

    private void initDataBinding() {
        tcNombrePropietario.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tcCedulaPropietario.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCedula()));
        tcEmailPropietario.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmail()));
        tcCelularPropietario.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCelular()));
        tcEdadPropietario.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getEdad())));
    }

    private void obtenerPropietarios() {
        listaPropietarios.addAll(propietarioController.obtenerPropietarios());
    }

    private void listenerSelection() {
        tablePropietario.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            propietarioSeleccionado = newSelection;
            mostrarInformacionPropietario(propietarioSeleccionado);
        });
    }

    private void mostrarInformacionPropietario(Propietario propietarioSeleccionado) {
        if (propietarioSeleccionado != null) {
            txtNombrePropietario.setText(propietarioSeleccionado.getNombre());
            txtCedulaPropietario.setText(propietarioSeleccionado.getCedula());
            txtEmailPropietario.setText(propietarioSeleccionado.getEmail());
            txtCelularPropietario.setText(propietarioSeleccionado.getCelular());
            txtEdadPropietario.setText(String.valueOf(propietarioSeleccionado.getEdad()));
        }
    }

    private void agregarPropietario() {
        if (validarFormulario()) {
            Propietario propietario = construirDatosPropietario();
            if (propietarioController.crearPropietario(propietario)) {
                listaPropietarios.add(propietario);
                mostrarMensaje("Notificación Propietario", "Propietario Creado",
                        "El propietario fue creado exitosamente", Alert.AlertType.INFORMATION);
                limpiarCampos();
            } else {
                mostrarMensaje("Notificación Propietario", "Propietario No Creado",
                        "El propietario no pudo ser creado", Alert.AlertType.ERROR);
            }
        } else {
            mostrarMensaje("Notificación Propietario", "Propietario No Creado",
                    "Los datos ingresados no son validos", Alert.AlertType.ERROR);
        }
    }

    private boolean validarFormulario() {
        return !txtNombrePropietario.getText().isEmpty()
                && !txtCedulaPropietario.getText().isEmpty()
                && !txtEmailPropietario.getText().isEmpty()
                && !txtCelularPropietario.getText().isEmpty()
                && !txtEdadPropietario.getText().isEmpty();
    }

    private Propietario construirDatosPropietario() {
        return new PropietarioBuilder()
                .setNombre(txtNombrePropietario.getText())
                .setCedula(txtCedulaPropietario.getText())
                .setEmail(txtEmailPropietario.getText())
                .setCelular(txtCelularPropietario.getText())
                .setEdad(Integer.parseInt(txtEdadPropietario.getText()))
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
        txtNombrePropietario.setText("");
        txtCedulaPropietario.setText("");
        txtEmailPropietario.setText("");
        txtCelularPropietario.setText("");
        txtEdadPropietario.setText("");
    }

    private void eliminarPropietario() {
        if (propietarioSeleccionado != null) {
            boolean confirmacion = mostrarMensajeConfirmacion("¿Está seguro de que desea eliminar el propietario seleccionado?");
            if (confirmacion) {
                boolean resultado = propietarioController.eliminarPropietario(propietarioSeleccionado);
                if (resultado) {
                    listaPropietarios.remove(propietarioSeleccionado);
                    mostrarMensaje("Notificación Propietario", "Propietario Eliminado",
                            "El propietario fue eliminado exitosamente", Alert.AlertType.INFORMATION);
                    limpiarCampos();
                } else {
                    mostrarMensaje("Notificación Propietario", "Error al eliminar",
                            "No se pudo eliminar el propietario", Alert.AlertType.ERROR);
                }
            }
        } else {
            mostrarMensaje("Notificación Propietario", "Ningún Propietario Seleccionado",
                    "Debe seleccionar un propietario para eliminar", Alert.AlertType.WARNING);
        }
    }

    private void deseleccionarPropietario() {
        tablePropietario.getSelectionModel().clearSelection();
        propietarioSeleccionado = null;
    }

    private void editarPropietario() {
        if (propietarioSeleccionado != null) {
            Propietario propietarioEditado = construirDatosPropietario();
            boolean resultado = propietarioController.editarPropietario(propietarioSeleccionado, propietarioEditado);
            if (resultado) {
                actualizarListaPropietarios(propietarioSeleccionado, propietarioEditado);
                mostrarMensaje("Edición", "Propietario Editado", "El propietario ha sido editado correctamente.", Alert.AlertType.INFORMATION);
                limpiarCampos();
            } else {
                mostrarMensaje("Edición", "Error", "No se pudo editar el propietario.", Alert.AlertType.ERROR);
            }
        } else {
            mostrarMensaje("Edición", "Selección Requerida", "Debe seleccionar un propietario para editarlo.", Alert.AlertType.WARNING);
        }
    }

    private void actualizarListaPropietarios(Propietario propietarioSeleccionado, Propietario propietarioEditado) {
        int indice = listaPropietarios.indexOf(propietarioSeleccionado);
        if (indice != -1) {
            listaPropietarios.set(indice, propietarioEditado);
        }
    }
}

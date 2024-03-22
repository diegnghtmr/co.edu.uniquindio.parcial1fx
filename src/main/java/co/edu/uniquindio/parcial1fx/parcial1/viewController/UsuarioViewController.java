package co.edu.uniquindio.parcial1fx.parcial1.viewController;

import co.edu.uniquindio.parcial1fx.parcial1.controller.UsuarioController;
import co.edu.uniquindio.parcial1fx.parcial1.factory.ModelFactory;
import co.edu.uniquindio.parcial1fx.parcial1.model.Propietario;
import co.edu.uniquindio.parcial1fx.parcial1.model.Usuario;
import co.edu.uniquindio.parcial1fx.parcial1.model.VehiculoTransporte;
import co.edu.uniquindio.parcial1fx.parcial1.model.builder.UsuarioBuilder;
import co.edu.uniquindio.parcial1fx.parcial1.util.AssertionUtil;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class UsuarioViewController {

    UsuarioController usuarioController;
    ObservableList<Usuario> listaUsuarios = FXCollections.observableArrayList();
    Usuario usuarioSeleccionado;

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
    private TableView<Usuario> tableUsuario;

    @FXML
    private TableColumn<Usuario, String> tcEdadUsuario;

    @FXML
    private TableColumn<Usuario, String> tcIDUsuario;

    @FXML
    private TableColumn<Usuario, String> tcNombreUsuario;

    @FXML
    private TableColumn<Usuario, String> tcPesoUsuario;

    @FXML
    void onAgregarUsuario(ActionEvent event) {
        agregarUsuario();
    }

    @FXML
    void onCrearUsuario(ActionEvent event) {
        limpiarCampos();
        deseleccionarUsuario();
    }

    @FXML
    void onEditarUsuario(ActionEvent event) {
        editarUsuario();
    }

    @FXML
    void onEliminarUsuario(ActionEvent event) {
        eliminarUsuario();
    }
    @FXML
    void initialize() {
        usuarioController = new UsuarioController();
        initViews();
    }

    private void initViews() {
        initDataBinding();
        obtenerUsuarios();
        tableUsuario.getItems().clear();
        tableUsuario.setItems(listaUsuarios);
        listenerSelection();
    }

    private void initDataBinding() {
        tcNombreUsuario.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tcIDUsuario.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getID()));
        tcEdadUsuario.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getEdad())));
        tcPesoUsuario.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getPeso())));
    }

    private void obtenerUsuarios() {
        listaUsuarios.addAll(usuarioController.obtenerUsuarios());
    }

    private void listenerSelection() {
        tableUsuario.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            usuarioSeleccionado = newSelection;
            mostrarInformacionUsuario(usuarioSeleccionado);
        });
    }

    private void mostrarInformacionUsuario(Usuario usuarioSeleccionado) {
        if(usuarioSeleccionado != null){
            txtNombreUsuario.setText(usuarioSeleccionado.getNombre());
            txtIDUsuario.setText(usuarioSeleccionado.getID());
            txtEdadUsuario.setText(String.valueOf(usuarioSeleccionado.getEdad()));
            txtPesoUsuario.setText(String.valueOf(usuarioSeleccionado.getPeso()));
        }
    }

    private void agregarUsuario() {
        if (validarFormulario()) {
            Usuario usuario = construirDatosUsuario();
            if (usuarioController.crearUsuario(usuario)) {
                listaUsuarios.add(usuario);
                mostrarMensaje("Notificación Usuario", "Usuario Creado",
                        "El usuario fue creado exitosamente", Alert.AlertType.INFORMATION);
                limpiarCampos();
            } else {
                mostrarMensaje("Notificación Usuario", "Usuario No Creado",
                        "El usuario no pudo ser creado", Alert.AlertType.ERROR);
            }
        } else {
            mostrarMensaje("Notificación Usuario", "Usuario No Creado",
                    "Los datos ingresados no son validos", Alert.AlertType.ERROR);
        }
    }

    private boolean validarFormulario() {
        return !txtNombreUsuario.getText().isEmpty()
                && !txtIDUsuario.getText().isEmpty()
                && !txtEdadUsuario.getText().isEmpty()
                && !txtPesoUsuario.getText().isEmpty();
    }

    private Usuario construirDatosUsuario() {
        return new UsuarioBuilder()
                .setNombre(txtNombreUsuario.getText())
                .setID(txtIDUsuario.getText())
                .setEdad(Integer.parseInt(txtEdadUsuario.getText()))
                .setPeso(Double.parseDouble(txtPesoUsuario.getText()))
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
        txtNombreUsuario.setText("");
        txtIDUsuario.setText("");
        txtEdadUsuario.setText("");
        txtPesoUsuario.setText("");
    }

    private void eliminarUsuario() {
        if (usuarioSeleccionado != null) {
            boolean confirmacion = mostrarMensajeConfirmacion("¿Está seguro de que desea eliminar el usuario seleccionado?");
            if (confirmacion) {
                boolean resultado = usuarioController.eliminarUsuario(usuarioSeleccionado);
                if (resultado) {
                    listaUsuarios.remove(usuarioSeleccionado);
                    mostrarMensaje("Notificación Usuario", "Usuario Eliminado",
                            "El usuario fue eliminado exitosamente", Alert.AlertType.INFORMATION);
                    limpiarCampos();
                } else {
                    mostrarMensaje("Notificación Usuario", "Error al eliminar",
                            "No se pudo eliminar el usuario", Alert.AlertType.ERROR);
                }
            }
        } else {
            mostrarMensaje("Notificación Usuario", "Ningún Usuario Seleccionado",
                    "Debe seleccionar un usuario para eliminar", Alert.AlertType.WARNING);
        }
    }

    private void deseleccionarUsuario() {
        tableUsuario.getSelectionModel().clearSelection();
        usuarioSeleccionado = null;
    }

    private void editarUsuario() {
        if (usuarioSeleccionado != null) {
            Usuario usuarioEditado = construirDatosUsuario();
            boolean resultado = usuarioController.editarPropietario(usuarioSeleccionado, usuarioEditado);
            if (resultado) {
                actualizarListaUsuarios(usuarioSeleccionado, usuarioEditado);
                mostrarMensaje("Edición", "Usuario Editado", "El usuario ha sido editado correctamente.", Alert.AlertType.INFORMATION);
                limpiarCampos();
            } else {
                mostrarMensaje("Edición", "Error", "No se pudo editar el usuario.", Alert.AlertType.ERROR);
            }
        } else {
            mostrarMensaje("Edición", "Selección Requerida", "Debe seleccionar un usuario para editarlo.", Alert.AlertType.WARNING);
        }
    }

    private void actualizarListaUsuarios(Usuario usuarioSeleccionado, Usuario usuarioEditado) {
        int indice = listaUsuarios.indexOf(usuarioSeleccionado);
        if (indice != -1) {
            listaUsuarios.set(indice, usuarioEditado);
        }
    }
}

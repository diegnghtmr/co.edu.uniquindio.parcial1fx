package co.edu.uniquindio.parcial1fx.parcial1.controller;

import java.net.URL;
import java.util.Collection;
import java.util.LinkedList;
import java.util.ResourceBundle;

import co.edu.uniquindio.parcial1fx.parcial1.factory.ModelFactory;
import co.edu.uniquindio.parcial1fx.parcial1.model.Propietario;
import co.edu.uniquindio.parcial1fx.parcial1.model.Usuario;
import co.edu.uniquindio.parcial1fx.parcial1.model.Vehiculo;
import co.edu.uniquindio.parcial1fx.parcial1.model.VehiculoTransporte;
import co.edu.uniquindio.parcial1fx.parcial1.util.AssertionUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class EmpresaTransporteController {

    ModelFactory modelFactory;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAgregarPropietario;

    @FXML
    private Button btnAgregarUsuario;

    @FXML
    private Button btnAgregarVehiculoCarga;

    @FXML
    private Button btnAgregarVehiculoTransporte;

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
    private TextField txtCapacidadCargaVehiculoCarga;

    @FXML
    private TextField txtCedulaAsociadosVehiculoCarga;

    @FXML
    private TextField txtCedulaAsociadosVehiculoTransporte;

    @FXML
    private TextField txtCedulaPropietario;

    @FXML
    private TextField txtCedulaPropietarioVehiculoCarga;

    @FXML
    private TextField txtCedulaPropietarioVehiculoTransporte;

    @FXML
    private TextField txtCelularPropietario;

    @FXML
    private TextField txtColorVehiculoCarga;

    @FXML
    private TextField txtColorVehiculoTransporte;

    @FXML
    private TextField txtEdadPropietario;

    @FXML
    private TextField txtEdadUsuario;

    @FXML
    private TextField txtEmailPropietario;

    @FXML
    private TextField txtIDUsuario;

    @FXML
    private TextField txtIDUsuariosVehiculoTransporte;

    @FXML
    private TextField txtMarcaVehiculoCarga;

    @FXML
    private TextField txtMarcaVehiculoTransporte;

    @FXML
    private TextField txtModeloVehiculoCarga;

    @FXML
    private TextField txtModeloVehiculoTransporte;

    @FXML
    private TextField txtNombrePropietario;

    @FXML
    private TextField txtNombreUsuario;

    @FXML
    private TextField txtNumeroChassisVehiculoCarga;

    @FXML
    private TextField txtNumeroChassisVehiculoTransporte;

    @FXML
    private TextField txtNumeroEjesVehiculoCarga;

    @FXML
    private TextField txtNumeroMaxPasajerosVehiculoTransporte;

    @FXML
    private TextField txtPesoObtenerNumeroUsuariosPesoInicio;

    @FXML
    private TextField txtPesoUsuario;

    @FXML
    private TextField txtPlacaObtenerNumeroUsuariosPlacaInicio;

    @FXML
    private TextField txtPlacaVehiculoCarga;

    @FXML
    private TextField txtPlacaVehiculoPrincipalPropietario;

    @FXML
    private TextField txtPlacaVehiculoTransporte;

    @FXML
    private TextField txtPlacaVehiculoUsuario;

    @FXML
    private TextField txtPlacaVehiculosAsociadosPropietario;

    @FXML
    private TextArea txtResultadoInicio;

    @FXML
    private TextArea txtResultadoPropietario;

    @FXML
    private TextArea txtResultadoUsuario;

    @FXML
    private TextArea txtResultadoVehiculoCarga;

    @FXML
    private TextArea txtResultadoVehiculoTransporte;

    @FXML
    void onObtenerAdultosMayores(ActionEvent event) {
        obtenerAdultosMayores();
    }

    @FXML
    void onObtenerUsuariosSuperiorPeso(ActionEvent event) {
        obtenerUsuariosSuperioresPeso();
    }

    @FXML
    void onAgregarPropietario(ActionEvent event) {
        agregarPropietario();
    }

    @FXML
    void onAgregarUsuario(ActionEvent event) {
        agregarUsuario();
    }

    @FXML
    void onAgregarVehiculoCarga(ActionEvent event) {
        agregarVehiculoCarga();
    }

    @FXML
    void onAgregarVehiculoTransporte(ActionEvent event) {
        agregarVehiculoTransporte();
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
        modelFactory = ModelFactory.getInstance();
    }

    private String construirMensajeDetallesPropietario(boolean propietarioCreado) {
        String mensaje = "";
        if (propietarioCreado) {
            mensaje = "Propietario creado exitosamente. Detalles:\n" +
                    "Nombre: " + txtNombrePropietario.getText().trim() + "\n" +
                    "Cédula: " + txtCedulaPropietario.getText().trim() + "\n" +
                    "Email: " + txtEmailPropietario.getText().trim() + "\n" +
                    "Celular: " + txtCelularPropietario.getText().trim() + "\n" +
                    "Edad: " + txtEdadPropietario.getText().trim() + "\n" +
                    "Placa Vehículo Principal: " + txtPlacaVehiculoPrincipalPropietario
                    .getText().trim() + "\n" +
                    "Placas de Vehículos Asociados: " + txtPlacaVehiculosAsociadosPropietario
                    .getText().trim();
            return mensaje;
        } else {
            mensaje = "No se pudo crear el propietario. " +
                    "Es posible que ya exista un propietario con la misma cédula.";
        }
        return mensaje;
    }

    private void agregarPropietario() {
        AssertionUtil.assertion(txtNombrePropietario.getText() != null &&
                        !txtNombrePropietario.getText().isBlank(),
                "El nombre del propietario no puede ser nulo o vacío");
        AssertionUtil.assertion(txtCedulaPropietario.getText() != null &&
                        !txtCedulaPropietario.getText().isBlank(),
                "La cédula del propietario no puede ser nula o vacía");
        AssertionUtil.assertion(txtEmailPropietario.getText() != null &&
                        !txtEmailPropietario.getText().isBlank(),
                "El email del propietario no puede ser nulo o vacío");
        AssertionUtil.assertion(txtCelularPropietario.getText() != null &&
                        !txtCelularPropietario.getText().isBlank(),
                "El celular del propietario no puede ser nulo o vacío");
        AssertionUtil.assertion(txtPlacaVehiculoPrincipalPropietario.getText() != null &&
                        !txtPlacaVehiculoPrincipalPropietario.getText().isBlank(),
                "La placa del vehículo principal del propietario no puede ser nula o vacía");
        AssertionUtil.assertion(txtEdadPropietario.getText() != null &&
                        !txtEdadPropietario.getText().isBlank(),
                "La edad del propietario no puede ser nula o vacía");

        Vehiculo vehiculo = modelFactory.buscarVehiculo
                (txtPlacaVehiculoPrincipalPropietario.getText());

        Collection<Vehiculo> vehiculosAsociados = new LinkedList<>();
        vehiculosAsociados.add(modelFactory.buscarVehiculo
                (txtPlacaVehiculosAsociadosPropietario.getText()));


        boolean propietarioCreado = modelFactory.crearPropietario
                (txtNombrePropietario.getText(), txtCedulaPropietario.getText(),
                        txtEmailPropietario.getText(),
                        txtCelularPropietario.getText(),
                        vehiculo, vehiculosAsociados,
                        Integer.parseInt(txtEdadPropietario.getText()));

        txtResultadoPropietario.setText
                (construirMensajeDetallesPropietario(propietarioCreado));

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Creación de Propietario");

        if (propietarioCreado) {
            String mensaje = "Propietario creado exitosamente: "
                    +txtNombrePropietario.getText() + " "
                    + txtCedulaPropietario.getText();
            alert.setHeaderText(null);
            alert.setContentText(mensaje);
        } else {
            alert.setHeaderText(null);
            alert.setContentText("No se pudo crear el propietario.");
        }

        alert.showAndWait();
    }

    private String construirMensajeDetallesUsuario(boolean usuarioCreado) {
        String mensaje = "";
        if (usuarioCreado) {
            mensaje = "Usuario creado exitosamente. Detalles:\n" +
                    "Nombre: " + txtNombreUsuario.getText().trim() + "\n" +
                    "ID: " + txtIDUsuario.getText().trim() + "\n" +
                    "Edad: " + txtEdadUsuario.getText().trim() + "\n" +
                    "Peso: " + txtPesoUsuario.getText().trim() + "\n" +
                    "Placa Vehículo Asociado: " + txtPlacaVehiculoUsuario.getText().trim();
        } else {
            mensaje = "No se pudo crear el usuario. " +
                    "Es posible que ya exista un propietario con la misma ID.";
        }
        return mensaje;
    }

    private void agregarUsuario() {
        AssertionUtil.assertion(txtNombreUsuario.getText() != null &&
                        !txtNombreUsuario.getText().isBlank(),
                "El nombre del usuario no puede ser nulo o vacío");
        AssertionUtil.assertion(txtIDUsuario.getText() != null &&
                        !txtIDUsuario.getText().isBlank(),
                "La ID del usuario no puede ser nula o vacía");
        AssertionUtil.assertion(txtEdadUsuario.getText() != null &&
                        !txtEdadUsuario.getText().isBlank(),
                "La edad del usuario no puede ser nula o vacía");
        AssertionUtil.assertion(txtPlacaVehiculoUsuario.getText() != null &&
                        !txtPlacaVehiculoUsuario.getText().isBlank(),
                "La placa del vehículo asociado del usuario no puede ser nula o vacía");
        AssertionUtil.assertion(txtPesoUsuario.getText() != null &&
                        !txtPesoUsuario.getText().isBlank(),
                "El peso del usuario no puede ser nulo o vacío");

        VehiculoTransporte vehiculoAsociado = modelFactory.buscarVehiculoTransporte
                (txtPlacaVehiculoUsuario.getText());

        boolean usuarioCreado = modelFactory.crearUsuario(
                txtNombreUsuario.getText().trim(),
                txtIDUsuario.getText().trim(),
                Integer.parseInt(txtEdadUsuario.getText().trim()),
                vehiculoAsociado, Double.parseDouble(txtPesoUsuario.getText().trim()));

        txtResultadoUsuario.setText
                (construirMensajeDetallesUsuario(usuarioCreado));

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Creación de Usuario");

        if (usuarioCreado) {
            String mensaje = "Usuario creado exitosamente: "
                    +txtNombreUsuario.getText() + " "
                    + txtIDUsuario.getText();
            alert.setHeaderText(null);
            alert.setContentText(mensaje);
        } else {
            alert.setHeaderText(null);
            alert.setContentText("No se pudo crear el usuario.");
        }

        alert.showAndWait();
    }

    private String construirMensajeDetallesVehiculoCarga(boolean vehiculoCargaCreado) {
        String mensaje = "";
        if (vehiculoCargaCreado) {
            mensaje = "Vehículo de Carga creado exitosamente. Detalles:\n" +
                    "Placa: " + txtPlacaVehiculoCarga.getText().trim() + "\n" +
                    "Modelo: " + txtModeloVehiculoCarga.getText().trim() + "\n" +
                    "Marca: " + txtMarcaVehiculoCarga.getText().trim() + "\n" +
                    "Color: " + txtColorVehiculoCarga.getText().trim() + "\n" +
                    "Capacidad de Carga: " + txtCapacidadCargaVehiculoCarga.getText().trim() + "\n" +
                    "Número de Ejes: " + txtNumeroEjesVehiculoCarga.getText().trim() + "\n" +
                    "Número de Chasis: " + txtNumeroChassisVehiculoCarga.getText().trim() + "\n" +
                    "Cédula Propietario: " + txtCedulaPropietarioVehiculoCarga.getText().trim() + "\n" +
                    "Cédulas de Propietarios Asociados: " + txtCedulaAsociadosVehiculoCarga.getText().trim();
            return mensaje;
        } else {
            mensaje = "No se pudo crear el vehículo de carga. " +
                    "Es posible que ya exista un vehículo con la misma placa.";
        }
        return mensaje;
    }

    private void agregarVehiculoCarga() {
        AssertionUtil.assertion(txtPlacaVehiculoCarga.getText() != null &&
                        !txtPlacaVehiculoCarga.getText().isBlank(),
                "La placa del vehículo de carga no puede ser nula o vacía");
        AssertionUtil.assertion(txtModeloVehiculoCarga.getText() != null &&
                        !txtModeloVehiculoCarga.getText().isBlank(),
                "El modelo del vehículo de carga no puede ser nulo o vacío");
        AssertionUtil.assertion(txtMarcaVehiculoCarga.getText() != null &&
                        !txtMarcaVehiculoCarga.getText().isBlank(),
                "La marca del vehículo de carga no puede ser nula o vacía");
        AssertionUtil.assertion(txtColorVehiculoCarga.getText() != null &&
                        !txtColorVehiculoCarga.getText().isBlank(),
                "El color del vehículo de carga no puede ser nulo o vacío");
        AssertionUtil.assertion(txtCedulaPropietarioVehiculoCarga.getText() != null &&
                        !txtCedulaPropietarioVehiculoCarga.getText().isBlank(),
                "La cédula del propietario del vehículo de carga no puede ser nula o vacía");
        AssertionUtil.assertion(txtCapacidadCargaVehiculoCarga.getText() != null &&
                        !txtCapacidadCargaVehiculoCarga.getText().isBlank(),
                "La capacidad de carga del vehículo de carga no puede ser nula o vacía");
        AssertionUtil.assertion(txtNumeroEjesVehiculoCarga.getText() != null &&
                        !txtNumeroEjesVehiculoCarga.getText().isBlank(),
                "El número de ejes del vehículo de carga no puede ser nulo o vacío");
        AssertionUtil.assertion(txtNumeroChassisVehiculoCarga.getText() != null &&
                        !txtNumeroChassisVehiculoCarga.getText().isBlank(),
                "El número de chasis del vehículo de carga no puede ser nulo o vacío");

        Propietario propietario = modelFactory.buscarPropietario
                (txtCedulaPropietarioVehiculoCarga.getText());

        Collection<Propietario> propietariosAsociados = new LinkedList<>();
        propietariosAsociados.add(modelFactory.buscarPropietario
                (txtCedulaAsociadosVehiculoCarga.getText()));

        boolean vehiculoCargaCreado = modelFactory.crearVehiculoCarga
                (txtPlacaVehiculoCarga.getText(), txtModeloVehiculoCarga.getText(),
                        txtMarcaVehiculoCarga.getText(), txtColorVehiculoCarga.getText(),
                        propietario, propietariosAsociados,
                        Double.parseDouble(txtCapacidadCargaVehiculoCarga.getText()),
                        Integer.parseInt(txtNumeroEjesVehiculoCarga.getText()),
                        txtNumeroChassisVehiculoCarga.getText());

        txtResultadoVehiculoCarga.setText
                (construirMensajeDetallesVehiculoCarga(vehiculoCargaCreado));

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Creación de Vehículo de Carga");

        if (vehiculoCargaCreado) {
            String mensaje = "Vehículo de Carga creado exitosamente: "
                    +txtPlacaVehiculoCarga.getText();
            alert.setHeaderText(null);
            alert.setContentText(mensaje);
        } else {
            alert.setHeaderText(null);
            alert.setContentText("No se pudo crear el vehículo de carga.");
        }

        alert.showAndWait();
    }

    private String construirMensajeDetallesVehiculoTransporte(boolean vehiculoTransporteCreado) {
        String mensaje = "";
        if (vehiculoTransporteCreado) {
            mensaje = "Vehículo de Transporte creado exitosamente. Detalles:\n" +
                    "Placa: " + txtPlacaVehiculoTransporte.getText().trim() + "\n" +
                    "Modelo: " + txtModeloVehiculoTransporte.getText().trim() + "\n" +
                    "Marca: " + txtMarcaVehiculoTransporte.getText().trim() + "\n" +
                    "Color: " + txtColorVehiculoTransporte.getText().trim() + "\n" +
                    "Número Máximo de Pasajeros: " + txtNumeroMaxPasajerosVehiculoTransporte.getText().trim() + "\n" +
                    "Número de Chasis: " + txtNumeroChassisVehiculoTransporte.getText().trim() + "\n" +
                    "Cédula Propietario: " + txtCedulaPropietarioVehiculoTransporte.getText().trim() + "\n" +
                    "Cédulas de Propietarios Asociados: " + txtCedulaAsociadosVehiculoTransporte.getText().trim() + "\n" +
                    "ID Usuarios Asociados: " + txtIDUsuariosVehiculoTransporte.getText().trim();
            return mensaje;
        } else {
            mensaje = "No se pudo crear el vehículo de transporte. " +
                    "Es posible que ya exista un vehículo con la misma placa.";
        }
        return mensaje;
    }

    private void agregarVehiculoTransporte() {
        AssertionUtil.assertion(txtPlacaVehiculoTransporte.getText() != null &&
                        !txtPlacaVehiculoTransporte.getText().isBlank(),
                "La placa del vehículo de transporte no puede ser nula o vacía");
        AssertionUtil.assertion(txtModeloVehiculoTransporte.getText() != null &&
                        !txtModeloVehiculoTransporte.getText().isBlank(),
                "El modelo del vehículo de transporte no puede ser nulo o vacío");
        AssertionUtil.assertion(txtMarcaVehiculoTransporte.getText() != null &&
                        !txtMarcaVehiculoTransporte.getText().isBlank(),
                "La marca del vehículo de transporte no puede ser nula o vacía");
        AssertionUtil.assertion(txtColorVehiculoTransporte.getText() != null &&
                        !txtColorVehiculoTransporte.getText().isBlank(),
                "El color del vehículo de transporte no puede ser nulo o vacío");
        AssertionUtil.assertion(txtCedulaPropietarioVehiculoTransporte.getText() != null &&
                        !txtCedulaPropietarioVehiculoTransporte.getText().isBlank(),
                "La cédula del propietario del vehículo de transporte no puede ser nula o vacía");
        AssertionUtil.assertion(txtNumeroMaxPasajerosVehiculoTransporte.getText() != null &&
                        !txtNumeroMaxPasajerosVehiculoTransporte.getText().isBlank(),
                "El número máximo de pasajeros del vehículo de transporte no puede ser nulo o vacío");
        AssertionUtil.assertion(txtNumeroChassisVehiculoTransporte.getText() != null &&
                        !txtNumeroChassisVehiculoTransporte.getText().isBlank(),
                "El número de chasis del vehículo de transporte no puede ser nulo o vacío");

        Propietario propietario = modelFactory.buscarPropietario
                (txtCedulaPropietarioVehiculoTransporte.getText());

        Collection<Propietario> propietariosAsociados = new LinkedList<>();
        propietariosAsociados.add(modelFactory.buscarPropietario
                (txtCedulaAsociadosVehiculoTransporte.getText()));

        Collection<Usuario> usuariosAsociados = new LinkedList<>();
        usuariosAsociados.add(modelFactory.buscarUsuario
                (txtIDUsuariosVehiculoTransporte.getText()));

        boolean vehiculoTransporteCreado = modelFactory.crearVehiculoTransporte
                (txtPlacaVehiculoTransporte.getText(), txtModeloVehiculoTransporte.getText(),
                        txtMarcaVehiculoTransporte.getText(),
                        txtColorVehiculoTransporte.getText(), propietario,
                        propietariosAsociados,
                        Integer.parseInt(txtNumeroMaxPasajerosVehiculoTransporte.getText()),
                        usuariosAsociados, txtNumeroChassisVehiculoTransporte.getText());

        txtResultadoVehiculoTransporte.setText
                (construirMensajeDetallesVehiculoTransporte(vehiculoTransporteCreado));

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Creación de Vehículo de Transporte");

        if (vehiculoTransporteCreado) {
            String mensaje = "Vehículo de Transporte creado exitosamente: "
                    +txtPlacaVehiculoTransporte.getText();
            alert.setHeaderText(null);
            alert.setContentText(mensaje);
        } else {
            alert.setHeaderText(null);
            alert.setContentText("No se pudo crear el vehículo de transporte.");
        }

        alert.showAndWait();
    }

    private void calcularPasajerosTransportados() {
        int pasajerosTransportados = modelFactory.calcularPasajerosTransportados();

        txtResultadoInicio.setText("Pasajeros transportados: " + pasajerosTransportados);
    }

    private void obtenerMayoresEdad() {
        long mayoresEdad = modelFactory.obtenerMayoresEdad();

        txtResultadoInicio.setText("Usuarios mayores de edad: " + mayoresEdad);
    }

    private void obtenerNumeroUsuariosPlaca() {
        AssertionUtil.assertion(txtPlacaObtenerNumeroUsuariosPlacaInicio.getText() != null &&
                        !txtPlacaObtenerNumeroUsuariosPlacaInicio.getText().isBlank(),
                "La placa del vehículo no puede ser nula o vacía");

        int numeroUsuarios = modelFactory.obtenerNumeroUsuariosPlaca
                (txtPlacaObtenerNumeroUsuariosPlacaInicio.getText());

        txtResultadoInicio.setText("El vehiculo identificado con la placa " +
                txtPlacaObtenerNumeroUsuariosPlacaInicio.getText() +
                " tiene " +
                numeroUsuarios +
                " usuarios.");
    }

    private void obtenerAdultosMayores() {
        long adultosMayores = modelFactory.obtenerAdultosMayores();

        txtResultadoInicio.setText("Adultos mayores: " + adultosMayores);
    }

    private void obtenerUsuariosSuperioresPeso() {
        AssertionUtil.assertion(txtPesoObtenerNumeroUsuariosPesoInicio.getText() != null &&
                        !txtPesoObtenerNumeroUsuariosPesoInicio.getText().isBlank(),
                "El peso no puede ser nulo o vacío");

        long numeroUsuarios = modelFactory.obtenerUsuariosSuperioresPeso
                (Double.parseDouble(txtPesoObtenerNumeroUsuariosPesoInicio.getText()));

        txtResultadoInicio.setText("Usuarios con peso superior a " +
                txtPesoObtenerNumeroUsuariosPesoInicio.getText() + ": " +
                numeroUsuarios);
    }
}

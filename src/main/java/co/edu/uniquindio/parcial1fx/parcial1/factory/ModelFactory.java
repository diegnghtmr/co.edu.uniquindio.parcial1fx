package co.edu.uniquindio.parcial1fx.parcial1.factory;

import co.edu.uniquindio.parcial1fx.parcial1.model.*;
import co.edu.uniquindio.parcial1fx.parcial1.model.builder.*;

import java.util.Collection;

public class ModelFactory {
    private static ModelFactory modelFactory;

    private EmpresaTransporte empresaTransporte;

    private ModelFactory() {
        empresaTransporte = new EmpresaTransporteBuilder().build();
        inicializarDatos();
    }

    public static ModelFactory getInstance() {
        if (modelFactory == null) {
            modelFactory = new ModelFactory();
        }
        return modelFactory;
    }

    private void inicializarDatos() {

        Propietario propietario01 = new PropietarioBuilder()
                .setNombre("Juan")
                .setCedula("123456789")
                .setEmail("juan777@example.com")
                .setCelular("3024567033")
                .setEdad(30)
                .setOwnByEmpresaTransporte(empresaTransporte)
                .build();

        Propietario propietario02 = new PropietarioBuilder()
                .setNombre("Maria")
                .setCedula("987654321")
                .setEmail("maria123@example.com")
                .setCelular("3105678901")
                .setEdad(40)
                .setOwnByEmpresaTransporte(empresaTransporte)
                .build();

        Propietario propietario03 = new PropietarioBuilder()
                .setNombre("Carlos")
                .setCedula("246810121")
                .setEmail("carlos456@example.com")
                .setCelular("3156789012")
                .setEdad(50)
                .setOwnByEmpresaTransporte(empresaTransporte)
                .build();

        Usuario usuario01 = new UsuarioBuilder()
                .setNombre("Alvaro")
                .setID("495543432")
                .setEdad(55)
                .setPeso(80.5)
                .setOwnByEmpresaTransporte(empresaTransporte)
                .build();

        Usuario usuario02 = new UsuarioBuilder()
                .setNombre("Beatriz")
                .setID("876543219")
                .setEdad(45)
                .setPeso(70.5)
                .setOwnByEmpresaTransporte(empresaTransporte)
                .build();

        Usuario usuario03 = new UsuarioBuilder()
                .setNombre("Carlos")
                .setID("123456789")
                .setEdad(60)
                .setPeso(90.5)
                .setOwnByEmpresaTransporte(empresaTransporte)
                .build();

        Usuario usuario04 = new UsuarioBuilder()
                .setNombre("Diana")
                .setID("987654321")
                .setEdad(40)
                .setPeso(60.5)
                .setOwnByEmpresaTransporte(empresaTransporte)
                .build();

        Usuario usuario05 = new UsuarioBuilder()
                .setNombre("Eduardo")
                .setID("246810121")
                .setEdad(15)
                .setPeso(50.5)
                .setOwnByEmpresaTransporte(empresaTransporte)
                .build();

        Usuario usuario06 = new UsuarioBuilder()
                .setNombre("Fernanda")
                .setID("135791357")
                .setEdad(35)
                .setPeso(70.5)
                .setOwnByEmpresaTransporte(empresaTransporte)
                .build();

        Usuario usuario07 = new UsuarioBuilder()
                .setNombre("Gustavo")
                .setID("579135791")
                .setEdad(11)
                .setPeso(40.5)
                .setOwnByEmpresaTransporte(empresaTransporte)
                .build();

        Usuario usuario08 = new UsuarioBuilder()
                .setNombre("Hernando")
                .setID("357913579")
                .setEdad(25)
                .setPeso(60.5)
                .setOwnByEmpresaTransporte(empresaTransporte)
                .build();

        Usuario usuario09 = new UsuarioBuilder()
                .setNombre("Isabel")
                .setID("791357913")
                .setEdad(20)
                .setPeso(50.5)
                .setOwnByEmpresaTransporte(empresaTransporte)
                .build();

        VehiculoCarga vehiculoCarga01 = new VehiculoCargaBuilder()
                .setPlaca("XYZ987")
                .setModelo("2015")
                .setMarca("Tinto")
                .setColor("Rojo")
                .setCapacidadCarga(20.5)
                .setNumeroEjes(4)
                .setNumeroChasis("123456789")
                .setOwnByEmpresaTransporte(empresaTransporte)
                .build();

        VehiculoCarga vehiculoCarga02 = new VehiculoCargaBuilder()
                .setPlaca("LMN654")
                .setModelo("2017")
                .setMarca("CargaExpress")
                .setColor("Verde")
                .setCapacidadCarga(25.0)
                .setNumeroEjes(6)
                .setNumeroChasis("987654321")
                .setOwnByEmpresaTransporte(empresaTransporte)
                .build();

        VehiculoCarga vehiculoCarga03 = new VehiculoCargaBuilder()
                .setPlaca("RST321")
                .setModelo("2018")
                .setMarca("MaxiCarga")
                .setColor("Azul")
                .setCapacidadCarga(30.0)
                .setNumeroEjes(8)
                .setNumeroChasis("246810121")
                .setOwnByEmpresaTransporte(empresaTransporte)
                .build();

        VehiculoTransporte vehiculoTransporte01 = new VehiculoTransporteBuilder()
                .setPlaca("ABC123")
                .setModelo("2019")
                .setMarca("Copetran")
                .setColor("Negro")
                .setNumeroMaxPasajeros(30)
                .setNumeroChasis("8468587521")
                .setOwnByEmpresaTransporte(empresaTransporte)
                .build();

        VehiculoTransporte vehiculoTransporte02 = new VehiculoTransporteBuilder()
                .setPlaca("DEF456")
                .setModelo("2020")
                .setMarca("Berlinas")
                .setColor("Blanco")
                .setNumeroMaxPasajeros(40)
                .setNumeroChasis("7471587529")
                .setOwnByEmpresaTransporte(empresaTransporte)
                .build();

        VehiculoTransporte vehiculoTransporte03 = new VehiculoTransporteBuilder()
                .setPlaca("GHI789")
                .setModelo("2021")
                .setMarca("Flota Magdalena")
                .setColor("Azul")
                .setNumeroMaxPasajeros(50)
                .setNumeroChasis("84775892")
                .setOwnByEmpresaTransporte(empresaTransporte)
                .build();

        vehiculoTransporte01.agregarUsuarioAsociado(usuario01);
        vehiculoTransporte01.agregarUsuarioAsociado(usuario02);
        vehiculoTransporte01.agregarUsuarioAsociado(usuario03);
        vehiculoTransporte02.agregarUsuarioAsociado(usuario04);
        vehiculoTransporte02.agregarUsuarioAsociado(usuario05);
        vehiculoTransporte02.agregarUsuarioAsociado(usuario06);
        vehiculoTransporte03.agregarUsuarioAsociado(usuario07);
        vehiculoTransporte03.agregarUsuarioAsociado(usuario08);
        vehiculoTransporte03.agregarUsuarioAsociado(usuario09);

        empresaTransporte.agregarVehiculoTransporte(vehiculoTransporte01);
        empresaTransporte.agregarVehiculoTransporte(vehiculoTransporte02);
        empresaTransporte.agregarVehiculoTransporte(vehiculoTransporte03);
        empresaTransporte.agregarVehiculoCarga(vehiculoCarga01);
        empresaTransporte.agregarVehiculoCarga(vehiculoCarga02);
        empresaTransporte.agregarVehiculoCarga(vehiculoCarga03);
        empresaTransporte.agregarPropietario(propietario01);
        empresaTransporte.agregarPropietario(propietario02);
        empresaTransporte.agregarPropietario(propietario03);
        empresaTransporte.agregarUsuario(usuario01);
        empresaTransporte.agregarUsuario(usuario02);
        empresaTransporte.agregarUsuario(usuario03);
        empresaTransporte.agregarUsuario(usuario04);
        empresaTransporte.agregarUsuario(usuario05);
        empresaTransporte.agregarUsuario(usuario06);
        empresaTransporte.agregarUsuario(usuario07);
        empresaTransporte.agregarUsuario(usuario08);
        empresaTransporte.agregarUsuario(usuario09);
    }

    public boolean crearPropietario(String nombre, String cedula,
                                    String email, String celular,
                                    Vehiculo vehiculoPrincipal,
                                    Collection<Vehiculo> listaVehiculosAsociados,
                                    int edad) {
        return empresaTransporte.crearPropetario(nombre, cedula, email,
                celular, vehiculoPrincipal, listaVehiculosAsociados, edad);

    }

    public boolean crearUsuario(String nombre, String ID, int edad,
                                VehiculoTransporte vehiculoTransporteAsociado,
                                double peso) {
        return empresaTransporte.crearUsuario(nombre, ID, edad,
                vehiculoTransporteAsociado, peso);
    }

    public boolean crearVehiculoCarga(String placa, String modelo,
                                      String marca, String color,
                                      Propietario propietarioAsociado,
                                      Collection<Propietario> listaPropietariosAsociados,
                                      double capacidadCarga, int numeroEjes,
                                      String numeroChasis) {
        return empresaTransporte.crearVehiculoCarga(placa, modelo, marca, color,
                propietarioAsociado, listaPropietariosAsociados,
                capacidadCarga, numeroEjes, numeroChasis);
    }

    public boolean crearVehiculoTransporte(String placa, String modelo,
                                           String marca, String color,
                                           Propietario propietarioAsociado,
                                           Collection<Propietario> listaPropietariosAsociados,
                                           int numeroMaxPasajeros,
                                           Collection<Usuario> listaUsuariosAsociados,
                                           String numeroChasis) {
        return empresaTransporte.crearVehiculoTransporte(placa, modelo, marca,
                color, propietarioAsociado, listaPropietariosAsociados,
                numeroMaxPasajeros, listaUsuariosAsociados, numeroChasis);
    }

    public Vehiculo buscarVehiculo(String placa) {
        return empresaTransporte.obtenerVehiculo(placa);
    }

    public VehiculoTransporte buscarVehiculoTransporte(String placa) {
        return empresaTransporte.obtenerVehiculoTransporte(placa);
    }

    public Propietario buscarPropietario(String cedula) {
        return empresaTransporte.obtenerPropietario(cedula);
    }

    public Usuario buscarUsuario(String ID) {
        return empresaTransporte.obtenerUsuario(ID);
    }

    public int calcularPasajerosTransportados() {
        return empresaTransporte.calcularPasajerosTransportados();
    }

    public int obtenerNumeroUsuariosPlaca(String placa) {
        return empresaTransporte.obtenerNumeroUsuariosPlaca(placa);
    }

    public long obtenerMayoresEdad() {
        return empresaTransporte.obtenerMayoresEdad();
    }

    public long obtenerAdultosMayores() {
        return empresaTransporte.obtenerUsuariosAdultosMayores();
    }

    public long obtenerUsuariosSuperioresPeso(double peso) {
        return empresaTransporte.obtenerUsuariosPesoMayor(peso);
    }
}

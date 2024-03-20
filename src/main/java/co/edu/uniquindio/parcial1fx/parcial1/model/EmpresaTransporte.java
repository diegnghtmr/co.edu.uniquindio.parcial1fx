package co.edu.uniquindio.parcial1fx.parcial1.model;

import co.edu.uniquindio.parcial1fx.parcial1.model.builder.PropietarioBuilder;
import co.edu.uniquindio.parcial1fx.parcial1.model.builder.UsuarioBuilder;
import co.edu.uniquindio.parcial1fx.parcial1.model.builder.VehiculoCargaBuilder;
import co.edu.uniquindio.parcial1fx.parcial1.model.builder.VehiculoTransporteBuilder;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.stream.Stream;

public class EmpresaTransporte {
    private String nombre;
    private Collection<Propietario> listaPropietarios;
    private Collection<VehiculoCarga> listaVehiculosCarga;
    private Collection<VehiculoTransporte> listaVehiculosTransporte;
    private Collection<Usuario> listaUsuarios;

    public EmpresaTransporte(String nombre,
                             Collection<Propietario> listaPropietarios,
                             Collection<VehiculoCarga> listaVehiculosCarga,
                             Collection<VehiculoTransporte> listaVehiculosTransporte,
                             Collection<Usuario> listaUsuarios) {
        this.nombre = nombre;
        this.listaPropietarios = new LinkedList<>(listaPropietarios);
        this.listaVehiculosCarga = new LinkedList<>(listaVehiculosCarga);
        this.listaVehiculosTransporte = new LinkedList<>(listaVehiculosTransporte);
        this.listaUsuarios = new LinkedList<>(listaUsuarios);
    }

    public String getNombre() {
        return nombre;
    }

    public Collection<Propietario> getListaPropietarios() {
        return Collections.unmodifiableCollection(listaPropietarios);
    }

    public Collection<VehiculoCarga> getListaVehiculosCarga() {
        return Collections.unmodifiableCollection(listaVehiculosCarga);
    }

    public Collection<VehiculoTransporte> getListaVehiculosTransporte() {
        return Collections.unmodifiableCollection(listaVehiculosTransporte);
    }

    public Collection<Usuario> getListaUsuarios() {
        return Collections.unmodifiableCollection(listaUsuarios);
    }

    public void agregarPropietario(Propietario propietario) {
        this.listaPropietarios.add(propietario);
    }

    public void agregarVehiculoCarga(VehiculoCarga vehiculoCarga) {
        this.listaVehiculosCarga.add(vehiculoCarga);
    }

    public void agregarVehiculoTransporte(VehiculoTransporte vehiculoTransporte) {
        this.listaVehiculosTransporte.add(vehiculoTransporte);
    }

    public void agregarUsuario(Usuario usuario) {
        this.listaUsuarios.add(usuario);
    }

    public void eliminarPropietario(Propietario propietario) {
        this.listaPropietarios.remove(propietario);
    }

    public void eliminarVehiculoCarga(VehiculoCarga vehiculoCarga) {
        this.listaVehiculosCarga.remove(vehiculoCarga);
    }

    public void eliminarVehiculoTransporte(VehiculoTransporte vehiculoTransporte) {
        this.listaVehiculosTransporte.remove(vehiculoTransporte);
    }

    public void eliminarUsuario(Usuario usuario) {
        this.listaUsuarios.remove(usuario);
    }

    public Propietario obtenerPropietario(String cedula) {
        return getListaPropietarios().stream()
                .filter(propietario -> propietario.getCedula().equalsIgnoreCase(cedula))
                .findFirst()
                .orElse(null);
    }

    private Propietario getBuildPropietario(String nombre, String cedula,
                                        String email, String celular, int edad) {
        return new PropietarioBuilder()
                .setNombre(nombre)
                .setCedula(cedula)
                .setEmail(email)
                .setCelular(celular)
                .setEdad(edad)
                .setOwnByEmpresaTransporte(this)
                .build();
    }

    public boolean crearPropetario(String nombre, String cedula,
                                String email, String celular, int edad) {
        Propietario propietarioEncontrado = obtenerPropietario(cedula);

        if (propietarioEncontrado == null) {
            Propietario propietario = getBuildPropietario(nombre, cedula,
                    email, celular, edad);
            agregarPropietario(propietario);
            return true;
        }
        else {
            return false;
        }
    }

    public Usuario obtenerUsuario(String ID) {
        return getListaUsuarios().stream()
                .filter(propietario -> propietario.getID()
                        .equalsIgnoreCase(ID))
                .findFirst()
                .orElse(null);
    }

    private Usuario getBuildUsuario(String nombre, String ID, int edad,
                                    double peso) {
        return new UsuarioBuilder()
                .setNombre(nombre)
                .setID(ID)
                .setEdad(edad)
                .setPeso(peso)
                .setOwnByEmpresaTransporte(this)
                .build();
    }

    public boolean crearUsuario(String nombre, String ID, int edad,
                                double peso) {
        Usuario usuarioEncontrado = obtenerUsuario(ID);

        if (usuarioEncontrado == null) {
            Usuario usuario = getBuildUsuario(nombre, ID, edad, peso);
            agregarUsuario(usuario);
            return true;
        }
        else {
            return false;
        }
    }

    public VehiculoCarga obtenerVehiculoCarga(String placa) {
        return getListaVehiculosCarga().stream()
                .filter(vehiculoCarga -> vehiculoCarga.getPlaca()
                        .equalsIgnoreCase(placa))
                .findFirst()
                .orElse(null);
    }

    private VehiculoCarga getBuildVehiculoCarga(String placa, String modelo,
                                          String marca, String color,
                                          double capacidadCarga, int numeroEjes,
                                                String numeroChasis) {
        return new VehiculoCargaBuilder()
                .setPlaca(placa)
                .setModelo(modelo)
                .setMarca(marca)
                .setColor(color)
                .setCapacidadCarga(capacidadCarga)
                .setNumeroEjes(numeroEjes)
                .setNumeroChasis(numeroChasis)
                .setOwnByEmpresaTransporte(this)
                .build();
    }

    public boolean crearVehiculoCarga(String placa, String modelo,
                                      String marca, String color,
                                      double capacidadCarga, int numeroEjes,
                                      String numeroChasis) {
        VehiculoCarga vehiculoCargaEncontrado = obtenerVehiculoCarga(placa);

        if (vehiculoCargaEncontrado == null) {
            VehiculoCarga vehiculoCarga = getBuildVehiculoCarga(placa, modelo,
                    marca, color, capacidadCarga, numeroEjes, numeroChasis);
            agregarVehiculoCarga(vehiculoCarga);
            return true;
        }
        else {
            return false;
        }
    }

    public VehiculoTransporte obtenerVehiculoTransporte(String placa) {
        return getListaVehiculosTransporte().stream()
                .filter(vehiculoTransporte -> vehiculoTransporte.getPlaca()
                        .equalsIgnoreCase(placa))
                .findFirst()
                .orElse(null);
    }

    private VehiculoTransporte getBuildVehiculoTransporte
            (String placa, String modelo, String marca, String color,
             int numeroMaxPasajeros, String numeroChasis) {
        return new VehiculoTransporteBuilder()
                .setPlaca(placa)
                .setModelo(modelo)
                .setMarca(marca)
                .setColor(color)
                .setNumeroMaxPasajeros(numeroMaxPasajeros)
                .setNumeroChasis(numeroChasis)
                .setOwnByEmpresaTransporte(this)
                .build();

    }

    public boolean crearVehiculoTransporte(String placa, String modelo,
                                           String marca, String color,
                                           int numeroMaxPasajeros,
                                           String numeroChasis) {
        VehiculoTransporte vehiculoTransporteEncontrado = obtenerVehiculoTransporte(placa);
        if (vehiculoTransporteEncontrado == null) {
            VehiculoTransporte vehiculoTransporte = getBuildVehiculoTransporte(placa,
                    modelo, marca, color, numeroMaxPasajeros, numeroChasis);
            agregarVehiculoTransporte(vehiculoTransporte);
            return true;
        }
        else {
            return false;
        }
    }

    public Vehiculo obtenerVehiculo(String placa) {
        Stream<Vehiculo> streamVehiculosCarga = listaVehiculosCarga.stream().map(vc -> (Vehiculo) vc);

        Stream<Vehiculo> streamVehiculosTransporte = listaVehiculosTransporte.stream().map(vt -> (Vehiculo) vt);

        Stream<Vehiculo> streamTodosVehiculos = Stream.concat(streamVehiculosCarga, streamVehiculosTransporte);

        return streamTodosVehiculos
                .filter(vehiculo -> vehiculo.getPlaca().equalsIgnoreCase(placa))
                .findFirst()
                .orElse(null);
    }

    public int calcularPasajerosTransportados() {
        return getListaVehiculosTransporte().stream()
                .mapToInt(vehiculoTransporte -> vehiculoTransporte
                        .getListaUsuariosAsociados()
                        .size())
                .sum();
    }

    public int obtenerNumeroUsuariosPlaca(String placa) {
        return getListaVehiculosTransporte().stream()
                .filter(vehiculoTransporte -> vehiculoTransporte
                        .getPlaca().equalsIgnoreCase(placa))
                .mapToInt(vehiculoTransporte -> vehiculoTransporte
                        .getListaUsuariosAsociados().size())
                .sum();
    }

    public long obtenerMayoresEdad() {
        return getListaUsuarios().stream()
                .mapToInt(Usuario::getEdad)
                .filter(edad -> edad >= 18)
                .count();
    }

    // Nuevos metodos parcial

    public long obtenerUsuariosPesoMayor(double peso) {
        return getListaUsuarios().stream()
                .mapToDouble(Usuario::getPeso)
                .filter(pesoUsuario -> pesoUsuario > peso)
                .count();
    }

    public long obtenerUsuariosAdultosMayores() {
        return getListaUsuarios().stream()
                .mapToInt(Usuario::getEdad)
                .filter(edad -> edad >= 40)
                .count();
    }
}

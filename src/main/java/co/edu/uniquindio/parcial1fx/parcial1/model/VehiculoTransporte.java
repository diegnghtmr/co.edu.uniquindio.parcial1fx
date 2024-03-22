package co.edu.uniquindio.parcial1fx.parcial1.model;

import java.util.*;

public class VehiculoTransporte extends Vehiculo {
    private int numeroMaxPasajeros;
    private List<Usuario> listaUsuariosAsociados;

    public VehiculoTransporte(String placa, String modelo,
                              String marca, String color,
                              Propietario propietarioAsociado,
                              List<Propietario> listaPropietariosAsociados,
                              int numeroMaxPasajeros,
                              List<Usuario> listaUsuariosAsociados,
                              EmpresaTransporte ownByEmpresaTransporte,
                              String numeroChasis) {
        super(placa, modelo, marca, color,
                propietarioAsociado, listaPropietariosAsociados,
                ownByEmpresaTransporte, numeroChasis);
        this.numeroMaxPasajeros = numeroMaxPasajeros;
        this.listaUsuariosAsociados = new ArrayList<>(listaUsuariosAsociados);
    }

    public int getNumeroMaxPasajeros() {
        return numeroMaxPasajeros;
    }

    public List<Usuario> getListaUsuariosAsociados() {
        return listaUsuariosAsociados;
    }

    public void agregarUsuarioAsociado(Usuario usuario) {
        this.listaUsuariosAsociados.add(usuario);
    }

    public void eliminarUsuarioAsociado(Usuario usuario) {
        this.listaUsuariosAsociados.remove(usuario);
    }
}

package co.edu.uniquindio.parcial1fx.parcial1.model.builder;

import co.edu.uniquindio.parcial1fx.parcial1.model.Usuario;
import co.edu.uniquindio.parcial1fx.parcial1.model.VehiculoTransporte;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class VehiculoTransporteBuilder extends VehiculoBuilder<VehiculoTransporteBuilder, VehiculoTransporte> {
    private int numeroMaxPasajeros;
    private List<Usuario> listaUsuariosAsociados = new ArrayList<>();

    @Override
    public VehiculoTransporte build() {
        return new VehiculoTransporte(placa, modelo, marca, color, propietarioAsociado,
                listaPropietariosAsociados, numeroMaxPasajeros, listaUsuariosAsociados,
                ownByEmpresaTransporte, numeroChasis);
    }

    public VehiculoTransporteBuilder setNumeroMaxPasajeros(int numeroMaxPasajeros) {
        this.numeroMaxPasajeros = numeroMaxPasajeros;
        return this;
    }

    public VehiculoTransporteBuilder setListaUsuariosAsociados(List<Usuario> listaUsuariosAsociados) {
        this.listaUsuariosAsociados.addAll(listaUsuariosAsociados);
        return this;
    }

    @Override
    protected VehiculoTransporteBuilder self() {
        return this;
    }
}

package co.edu.uniquindio.parcial1fx.parcial1.model.builder;

import co.edu.uniquindio.parcial1fx.parcial1.model.*;
import co.edu.uniquindio.parcial1fx.parcial1.services.IBuilder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class EmpresaTransporteBuilder implements IBuilder {
    private String nombre;
    private List<Propietario> listaPropietarios = new ArrayList<>();
    private List<VehiculoCarga> listaVehiculosCarga = new ArrayList<>();
    private List<VehiculoTransporte> listaVehiculosTransporte = new ArrayList<>();
    private List<Usuario> listaUsuarios = new ArrayList<>();

    public EmpresaTransporteBuilder setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public EmpresaTransporteBuilder setListaPropietarios(Propietario propietario) {
        this.listaPropietarios.add(propietario);
        return this;
    }

    public EmpresaTransporteBuilder setListaPropietarios
            (List<Propietario> listaPropietarios) {
        this.listaPropietarios.addAll(listaPropietarios);
        return this;
    }

    public EmpresaTransporteBuilder setListaVehiculosCarga
            (VehiculoCarga vehiculoCarga) {
        this.listaVehiculosCarga.add(vehiculoCarga);
        return this;
    }

    public EmpresaTransporteBuilder setListaVehiculosCarga
            (List<VehiculoCarga> listaVehiculosCarga) {
        this.listaVehiculosCarga.addAll(listaVehiculosCarga);
        return this;
    }

    public EmpresaTransporteBuilder setListaVehiculosTransporte
            (VehiculoTransporte vehiculoTransporte) {
        this.listaVehiculosTransporte.add(vehiculoTransporte);
        return this;
    }

    public EmpresaTransporteBuilder setListaVehiculosTransporte
            (List<VehiculoTransporte> listaVehiculosTransporte) {
        this.listaVehiculosTransporte.addAll(listaVehiculosTransporte);
        return this;
    }

    public EmpresaTransporteBuilder setListaUsuarios
            (Usuario usuario) {
        this.listaUsuarios.add(usuario);
        return this;
    }

    public EmpresaTransporteBuilder setListaUsuarios
            (List<Usuario> listaUsuarios) {
        this.listaUsuarios.addAll(listaUsuarios);
        return this;
    }

    @Override
    public EmpresaTransporte build() {
        return new EmpresaTransporte(nombre, listaPropietarios,
                listaVehiculosCarga, listaVehiculosTransporte, listaUsuarios);
    }
}

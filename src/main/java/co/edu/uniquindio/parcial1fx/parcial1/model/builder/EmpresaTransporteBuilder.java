package co.edu.uniquindio.parcial1fx.parcial1.model.builder;

import co.edu.uniquindio.parcial1fx.parcial1.model.*;
import co.edu.uniquindio.parcial1fx.parcial1.services.IBuilder;

import java.util.Collection;
import java.util.LinkedList;

public class EmpresaTransporteBuilder implements IBuilder {
    private String nombre;
    private Collection<Propietario> listaPropietarios = new LinkedList<>();
    private Collection<VehiculoCarga> listaVehiculosCarga = new LinkedList<>();
    private Collection<VehiculoTransporte> listaVehiculosTransporte = new LinkedList<>();
    private Collection<Usuario> listaUsuarios = new LinkedList<>();

    public EmpresaTransporteBuilder setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public EmpresaTransporteBuilder setListaPropietarios(Propietario propietario) {
        this.listaPropietarios.add(propietario);
        return this;
    }

    public EmpresaTransporteBuilder setListaPropietarios
            (Collection<Propietario> listaPropietarios) {
        this.listaPropietarios.addAll(listaPropietarios);
        return this;
    }

    public EmpresaTransporteBuilder setListaVehiculosCarga
            (VehiculoCarga vehiculoCarga) {
        this.listaVehiculosCarga.add(vehiculoCarga);
        return this;
    }

    public EmpresaTransporteBuilder setListaVehiculosCarga
            (Collection<VehiculoCarga> listaVehiculosCarga) {
        this.listaVehiculosCarga.addAll(listaVehiculosCarga);
        return this;
    }

    public EmpresaTransporteBuilder setListaVehiculosTransporte
            (VehiculoTransporte vehiculoTransporte) {
        this.listaVehiculosTransporte.add(vehiculoTransporte);
        return this;
    }

    public EmpresaTransporteBuilder setListaVehiculosTransporte
            (Collection<VehiculoTransporte> listaVehiculosTransporte) {
        this.listaVehiculosTransporte.addAll(listaVehiculosTransporte);
        return this;
    }

    public EmpresaTransporteBuilder setListaUsuarios
            (Usuario usuario) {
        this.listaUsuarios.add(usuario);
        return this;
    }

    public EmpresaTransporteBuilder setListaUsuarios
            (Collection<Usuario> listaUsuarios) {
        this.listaUsuarios.addAll(listaUsuarios);
        return this;
    }

    @Override
    public EmpresaTransporte build() {
        return new EmpresaTransporte(nombre, listaPropietarios,
                listaVehiculosCarga, listaVehiculosTransporte, listaUsuarios);
    }
}

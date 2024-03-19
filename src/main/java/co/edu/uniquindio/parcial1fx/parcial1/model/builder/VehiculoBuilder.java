package co.edu.uniquindio.parcial1fx.parcial1.model.builder;

import co.edu.uniquindio.parcial1fx.parcial1.model.EmpresaTransporte;
import co.edu.uniquindio.parcial1fx.parcial1.model.Propietario;
import co.edu.uniquindio.parcial1fx.parcial1.model.Vehiculo;

import java.util.Collection;
import java.util.LinkedList;

public abstract class VehiculoBuilder<B extends VehiculoBuilder<B, V>, V extends Vehiculo> {
    protected String placa;
    protected String modelo;
    protected String marca;
    protected String color;
    protected Propietario propietarioAsociado;
    protected Collection<Propietario> listaPropietariosAsociados = new LinkedList<>();
    protected EmpresaTransporte ownByEmpresaTransporte;
    protected String numeroChasis;

    public abstract V build();

    public B setPlaca(String placa) {
        this.placa = placa;
        return self();
    }

    public B setModelo(String modelo) {
        this.modelo = modelo;
        return self();
    }

    public B setMarca(String marca) {
        this.marca = marca;
        return self();
    }

    public B setColor(String color) {
        this.color = color;
        return self();
    }

    public B setPropietarioAsociado(Propietario propietarioAsociado) {
        this.propietarioAsociado = propietarioAsociado;
        return self();
    }

    public B setListaPropietariosAsociados(Collection<Propietario> listaPropietariosAsociados) {
        this.listaPropietariosAsociados = listaPropietariosAsociados;
        return self();
    }

    public B setOwnByEmpresaTransporte(EmpresaTransporte ownByEmpresaTransporte) {
        this.ownByEmpresaTransporte = ownByEmpresaTransporte;
        return self();
    }

    public B setNumeroChasis(String numeroChasis) {
        this.numeroChasis = numeroChasis;
        return self();
    }

    protected abstract B self();
}

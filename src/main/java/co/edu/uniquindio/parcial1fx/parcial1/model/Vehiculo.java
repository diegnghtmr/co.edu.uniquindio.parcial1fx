package co.edu.uniquindio.parcial1fx.parcial1.model;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public abstract class Vehiculo {
    private String placa;
    private String modelo;
    private String marca;
    private String color;
    private Propietario propietarioAsociado;
    private Collection<Propietario> listaPropietariosAsociados;
    private EmpresaTransporte ownByEmpresaTransporte;
    private String numeroChasis;

    public Vehiculo(String placa, String modelo,
                    String marca, String color,
                    Propietario propietarioAsociado,
                    Collection<Propietario> listaPropietariosAsociados,
                    EmpresaTransporte ownByEmpresaTransporte, String numeroChasis) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.color = color;
        this.propietarioAsociado = propietarioAsociado;
        this.listaPropietariosAsociados = new LinkedList<>(listaPropietariosAsociados);
        this.ownByEmpresaTransporte = ownByEmpresaTransporte;
        this.numeroChasis = numeroChasis;
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public String getColor() {
        return color;
    }

    public Propietario getPropietarioAsociado() {
        return propietarioAsociado;
    }

    public Collection<Propietario> getListaPropietariosAsociados() {
        return Collections.unmodifiableCollection(listaPropietariosAsociados);
    }

    public EmpresaTransporte getOwnByEmpresaTransporte() {
        return ownByEmpresaTransporte;
    }

    public String getNumeroChasis() {
        return numeroChasis;
    }

    public void agregarPropietarioAsociado(Propietario propietario) {
        this.listaPropietariosAsociados.add(propietario);
    }

    public void eliminarPropietarioAsociado(Propietario propietario) {
        this.listaPropietariosAsociados.remove(propietario);
    }
}

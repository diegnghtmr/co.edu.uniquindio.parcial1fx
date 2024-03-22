package co.edu.uniquindio.parcial1fx.parcial1.model;

import java.util.*;

public abstract class Vehiculo {
    private String placa;
    private String modelo;
    private String marca;
    private String color;
    private Propietario propietarioAsociado;
    private List<Propietario> listaPropietariosAsociados;
    private EmpresaTransporte ownByEmpresaTransporte;
    private String numeroChasis;

    public Vehiculo(String placa, String modelo,
                    String marca, String color,
                    Propietario propietarioAsociado,
                    List<Propietario> listaPropietariosAsociados,
                    EmpresaTransporte ownByEmpresaTransporte, String numeroChasis) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.color = color;
        this.propietarioAsociado = propietarioAsociado;
        this.listaPropietariosAsociados = new ArrayList<>(listaPropietariosAsociados);
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

    public String getNumeroChassis() {
        return numeroChasis;
    }

    public Propietario getPropietarioAsociado() {
        return propietarioAsociado;
    }

    public List<Propietario> getListaPropietariosAsociados() {
        return listaPropietariosAsociados;
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

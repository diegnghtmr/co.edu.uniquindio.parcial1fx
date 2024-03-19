package co.edu.uniquindio.parcial1fx.parcial1.model;

import java.util.Collection;

public class VehiculoCarga extends Vehiculo {
    private double capacidadCarga;
    private int numeroEjes;

    public VehiculoCarga(String placa, String modelo,
                         String marca, String color,
                         Propietario propietarioAsociado,
                         Collection<Propietario> listaPropietariosAsociados,
                         double capacidadCarga, int numeroEjes,
                         EmpresaTransporte ownByEmpresaTransporte,
                         String numeroChasis) {
        super(placa, modelo, marca, color,
                propietarioAsociado, listaPropietariosAsociados,
                ownByEmpresaTransporte, numeroChasis);

        this.capacidadCarga = capacidadCarga;
        this.numeroEjes = numeroEjes;
    }

    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    public int getNumeroEjes() {
        return numeroEjes;
    }
}

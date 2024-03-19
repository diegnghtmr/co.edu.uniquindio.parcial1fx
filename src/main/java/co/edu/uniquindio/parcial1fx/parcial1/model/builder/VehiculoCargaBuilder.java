package co.edu.uniquindio.parcial1fx.parcial1.model.builder;

import co.edu.uniquindio.parcial1fx.parcial1.model.VehiculoCarga;

public class VehiculoCargaBuilder extends VehiculoBuilder<VehiculoCargaBuilder, VehiculoCarga> {
    private double capacidadCarga;
    private int numeroEjes;

    @Override
    public VehiculoCarga build() {
        return new VehiculoCarga(placa, modelo, marca, color,
                propietarioAsociado, listaPropietariosAsociados, capacidadCarga,
                numeroEjes, ownByEmpresaTransporte, numeroChasis);
    }

    public VehiculoCargaBuilder setCapacidadCarga(double capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
        return this;
    }

    public VehiculoCargaBuilder setNumeroEjes(int numeroEjes) {
        this.numeroEjes = numeroEjes;
        return this;
    }

    @Override
    protected VehiculoCargaBuilder self() {
        return this;
    }
}

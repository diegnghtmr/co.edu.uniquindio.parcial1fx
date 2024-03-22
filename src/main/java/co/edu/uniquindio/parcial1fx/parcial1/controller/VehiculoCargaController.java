package co.edu.uniquindio.parcial1fx.parcial1.controller;

import co.edu.uniquindio.parcial1fx.parcial1.factory.ModelFactory;
import co.edu.uniquindio.parcial1fx.parcial1.model.VehiculoCarga;

import java.util.List;

public class VehiculoCargaController {
    ModelFactory modelFactory;
    public VehiculoCargaController() {
        modelFactory = ModelFactory.getInstance();
    }

    public List<VehiculoCarga> obtenerClientes() {
        return modelFactory.obtenerVehiculosCarga();
    }

    public boolean crearVehiculoCarga(VehiculoCarga vehiculoCarga) {
        return modelFactory.crearVehiculoCarga(vehiculoCarga);
    }

    public boolean eliminarVehiculoCarga(VehiculoCarga vehiculoCargaSeleccionado) {
        return modelFactory.eliminarVehiculoCargaExistente(vehiculoCargaSeleccionado);
    }

    public boolean editarVehiculoCarga(VehiculoCarga vehiculoCargaSeleccionado, VehiculoCarga vehiculoCargaEditado) {
        return modelFactory.editarVehiculoCarga(vehiculoCargaSeleccionado, vehiculoCargaEditado);
    }
}

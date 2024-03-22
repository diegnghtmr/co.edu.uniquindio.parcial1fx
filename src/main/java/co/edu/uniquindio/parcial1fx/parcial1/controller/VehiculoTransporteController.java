package co.edu.uniquindio.parcial1fx.parcial1.controller;

import co.edu.uniquindio.parcial1fx.parcial1.factory.ModelFactory;
import co.edu.uniquindio.parcial1fx.parcial1.model.VehiculoTransporte;

import java.util.List;

public class VehiculoTransporteController {
    ModelFactory modelFactory;
    public VehiculoTransporteController() {
        modelFactory = ModelFactory.getInstance();
    }

    public List<VehiculoTransporte> obtenerVehiculosTransporte() {
        return modelFactory.obtenerVehiculosTransporte();
    }

    public boolean crearVehiculoTransporte(VehiculoTransporte vehiculoTransporte) {
        return modelFactory.crearVehiculoTransporte(vehiculoTransporte);
    }

    public boolean eliminarPropietario(VehiculoTransporte vehiculoTransporteSeleccionado) {
        return modelFactory.eliminarVehiculoTransporteExistente(vehiculoTransporteSeleccionado);
    }

    public boolean editarVehiculoTransporte(VehiculoTransporte vehiculoTransporteSeleccionado,
                                            VehiculoTransporte vehiculoTransporteEditado) {
        return modelFactory.editarVehiculoTransporte(vehiculoTransporteSeleccionado, vehiculoTransporteEditado);
    }
}

package co.edu.uniquindio.parcial1fx.parcial1.controller;

import co.edu.uniquindio.parcial1fx.parcial1.factory.ModelFactory;
import co.edu.uniquindio.parcial1fx.parcial1.model.Propietario;

import java.util.Collection;
import java.util.List;

public class PropietarioController {
    ModelFactory modelFactory;
    public PropietarioController() {
        modelFactory = ModelFactory.getInstance();
    }

     public List<Propietario> obtenerPropietarios() {
        return modelFactory.obtenerPropietarios();
    }

    public boolean crearPropietario(Propietario propietario) {
        return modelFactory.crearPropietario(propietario);
    }

    public boolean eliminarPropietario(Propietario propietarioSeleccionado) {
        return modelFactory.eliminarPropietario(propietarioSeleccionado);
    }

    public boolean editarPropietario(Propietario propietarioSeleccionado, Propietario propietarioEditado) {
        return modelFactory.editarPropietario(propietarioSeleccionado, propietarioEditado);
    }
}

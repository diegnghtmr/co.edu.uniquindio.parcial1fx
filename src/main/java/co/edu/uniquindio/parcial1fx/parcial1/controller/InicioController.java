package co.edu.uniquindio.parcial1fx.parcial1.controller;

import co.edu.uniquindio.parcial1fx.parcial1.factory.ModelFactory;

public class InicioController {
    ModelFactory modelFactory;
    public InicioController() {
        modelFactory = ModelFactory.getInstance();
    }
}

package co.edu.uniquindio.parcial1fx.parcial1.controller;

import co.edu.uniquindio.parcial1fx.parcial1.factory.ModelFactory;
import co.edu.uniquindio.parcial1fx.parcial1.model.Usuario;

import java.util.Collection;
import java.util.List;

public class UsuarioController {
    ModelFactory modelFactory;
    public UsuarioController() {
        modelFactory = ModelFactory.getInstance();
    }

    public List<Usuario> obtenerUsuarios() {
        return modelFactory.obtenerUsuarios();
    }

    public boolean crearUsuario(Usuario usuario) {
        return modelFactory.crearUsuario(usuario);
    }

    public boolean eliminarUsuario(Usuario usuarioSeleccionado) {
        return modelFactory.eliminarUsuarioExistente(usuarioSeleccionado);
    }

    public boolean editarPropietario(Usuario usuarioSeleccionado, Usuario usuarioEditado) {
        return modelFactory.editarUsuario(usuarioSeleccionado, usuarioEditado);
    }
}

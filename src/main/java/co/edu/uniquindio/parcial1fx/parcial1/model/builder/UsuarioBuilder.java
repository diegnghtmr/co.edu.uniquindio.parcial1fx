package co.edu.uniquindio.parcial1fx.parcial1.model.builder;

import co.edu.uniquindio.parcial1fx.parcial1.model.EmpresaTransporte;
import co.edu.uniquindio.parcial1fx.parcial1.model.Usuario;
import co.edu.uniquindio.parcial1fx.parcial1.model.VehiculoTransporte;
import co.edu.uniquindio.parcial1fx.parcial1.services.IBuilder;

public class UsuarioBuilder implements IBuilder {
    private String nombre;
    private String ID;
    private int edad;
    private VehiculoTransporte vehiculoTransporteAsociado;
    private double peso;
    private EmpresaTransporte ownByEmpresaTransporte;

    public UsuarioBuilder setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public UsuarioBuilder setID(String ID) {
        this.ID = ID;
        return this;
    }

    public UsuarioBuilder setEdad(int edad) {
        this.edad = edad;
        return this;
    }

    public UsuarioBuilder setVehiculoTransporteAsociado(
            VehiculoTransporte vehiculoTransporteAsociado) {
        this.vehiculoTransporteAsociado = vehiculoTransporteAsociado;
        return this;
    }

    public UsuarioBuilder setPeso(double peso) {
        this.peso = peso;
        return this;
    }

    public UsuarioBuilder setOwnByEmpresaTransporte(
            EmpresaTransporte ownByEmpresaTransporte) {
        this.ownByEmpresaTransporte = ownByEmpresaTransporte;
        return this;
    }

    @Override
    public Usuario build() {
        return new Usuario(nombre, ID, edad, vehiculoTransporteAsociado, peso,
                ownByEmpresaTransporte);
    }
}

package co.edu.uniquindio.parcial1fx.parcial1.model.builder;

import co.edu.uniquindio.parcial1fx.parcial1.model.EmpresaTransporte;
import co.edu.uniquindio.parcial1fx.parcial1.model.Propietario;
import co.edu.uniquindio.parcial1fx.parcial1.model.Vehiculo;
import co.edu.uniquindio.parcial1fx.parcial1.services.IBuilder;

import java.util.Collection;
import java.util.LinkedList;

public class PropietarioBuilder implements IBuilder {
    private String nombre;
    private String cedula;
    private String email;
    private String celular;
    private Vehiculo vehiculoPrincipal;
    private Collection<Vehiculo> listaVehiculosAsociados = new LinkedList<>();
    private int edad;
    private EmpresaTransporte ownByEmpresaTransporte;

    public PropietarioBuilder setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public PropietarioBuilder setCedula(String cedula) {
        this.cedula = cedula;
        return this;
    }

    public PropietarioBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public PropietarioBuilder setCelular(String celular) {
        this.celular = celular;
        return this;
    }

    public PropietarioBuilder setVehiculoPrincipal(
            Vehiculo vehiculoPrincipal) {
        this.vehiculoPrincipal = vehiculoPrincipal;
        return this;
    }

    public PropietarioBuilder setListaVehiculosAsociados(
            Vehiculo vehiculoAsociado) {
        this.listaVehiculosAsociados.add(vehiculoAsociado);
        return this;
    }

    public PropietarioBuilder setListaVehiculosAsociados(
            Collection<Vehiculo> listaVehiculosAsociados) {
        this.listaVehiculosAsociados.addAll(listaVehiculosAsociados);
        return this;
    }

    public PropietarioBuilder setEdad(int edad) {
        this.edad = edad;
        return this;
    }

    public PropietarioBuilder setOwnByEmpresaTransporte(
            EmpresaTransporte ownByEmpresaTransporte) {
        this.ownByEmpresaTransporte = ownByEmpresaTransporte;
        return this;
    }

    @Override
    public Propietario build() {
        return new Propietario(nombre, cedula,
                email, celular, vehiculoPrincipal, listaVehiculosAsociados,
                edad, ownByEmpresaTransporte);
    }
}

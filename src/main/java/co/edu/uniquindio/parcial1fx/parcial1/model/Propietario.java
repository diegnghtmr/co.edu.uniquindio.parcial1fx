package co.edu.uniquindio.parcial1fx.parcial1.model;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class Propietario {
    private String nombre;
    private String cedula;
    private String email;
    private String celular;
    private Vehiculo vehiculoPrincipal;
    private Collection<Vehiculo> listaVehiculosAsociados;
    private int edad;
    private EmpresaTransporte ownByEmpresaTransporte;

    public Propietario(String nombre, String cedula,
                       String email, String celular,
                       Vehiculo vehiculoPrincipal,
                       Collection<Vehiculo> listaVehiculosAsociados, int edad,
                       EmpresaTransporte ownByEmpresaTransporte) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.email = email;
        this.celular = celular;
        this.vehiculoPrincipal = vehiculoPrincipal;
        this.listaVehiculosAsociados = new LinkedList<>(listaVehiculosAsociados);
        this.edad = edad;
        this.ownByEmpresaTransporte = ownByEmpresaTransporte;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public String getEmail() {
        return email;
    }

    public String getCelular() {
        return celular;
    }

    public Vehiculo getVehiculoPrincipal() {
        return vehiculoPrincipal;
    }

    public Collection<Vehiculo> getListaVehiculosAsociados() {
        return Collections.unmodifiableCollection(listaVehiculosAsociados);
    }

    public int getEdad() {
        return edad;
    }

    public EmpresaTransporte getOwnByEmpresaTransporte() {
        return ownByEmpresaTransporte;
    }

    public void agregarVehiculoAsociado(Vehiculo vehiculo) {
        this.listaVehiculosAsociados.add(vehiculo);
    }

    public void eliminarVehiculoAsociado(Vehiculo vehiculo) {
        this.listaVehiculosAsociados.remove(vehiculo);
    }
}

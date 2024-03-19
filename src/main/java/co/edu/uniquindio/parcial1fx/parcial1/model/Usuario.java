package co.edu.uniquindio.parcial1fx.parcial1.model;

public class Usuario {
    private String nombre;
    private String ID;
    private int edad;
    private VehiculoTransporte vehiculoTransporteAsociado;
    private double peso;
    private EmpresaTransporte ownByEmpresaTransporte;

    public Usuario(String nombre, String ID, int edad,
                   VehiculoTransporte vehiculoTransporteAsociado,
                   double peso,
                   EmpresaTransporte ownByEmpresaTransporte) {
        this.nombre = nombre;
        this.ID = ID;
        this.edad = edad;
        this.vehiculoTransporteAsociado = vehiculoTransporteAsociado;
        this.peso = peso;
        this.ownByEmpresaTransporte = ownByEmpresaTransporte;
    }

    public String getNombre() {
        return nombre;
    }

    public String getID() {
        return ID;
    }

    public int getEdad() {
        return edad;
    }

    public VehiculoTransporte getVehiculoTransporteAsociado() {
        return vehiculoTransporteAsociado;
    }

    public double getPeso() {
        return peso;
    }

    public EmpresaTransporte getOwnByEmpresaTransporte() {
        return ownByEmpresaTransporte;
    }

}

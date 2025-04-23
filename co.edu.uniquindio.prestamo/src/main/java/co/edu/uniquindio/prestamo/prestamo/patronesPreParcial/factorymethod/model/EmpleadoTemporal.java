package co.edu.uniquindio.prestamo.prestamo.patronesPreParcial.factorymethod.model;

public class EmpleadoTemporal extends Empleado{
    public EmpleadoTemporal(String nombre) {
        super(nombre);
    }

    @Override
    public void mostrarDatos() {
        System.out.println(nombre + "Empleado temporal");
    }


}

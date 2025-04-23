package co.edu.uniquindio.prestamo.prestamo.patronesPreParcial.factorymethod.model;

public class EmpleadoPermanente extends Empleado {
    public EmpleadoPermanente(String nombre){
        super(nombre);
    }

    @Override
    public void mostrarDatos() {
        System.out.println(nombre + "Empleado Permanente");
    }


}

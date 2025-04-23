package co.edu.uniquindio.prestamo.prestamo.patronesPreParcial.factorymethod.model;

public abstract class Empleado {
    protected String nombre;

    public Empleado (String nombre){
        this.nombre = nombre;
    }
    public abstract void mostrarDatos();

}

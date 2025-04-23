package co.edu.uniquindio.prestamo.prestamo.patronesPreParcial.factorymethod.factory;

import co.edu.uniquindio.prestamo.prestamo.patronesPreParcial.factorymethod.model.Empleado;

public abstract class EmpleadoFactory {
    public abstract Empleado crearEmpleado(String nombre);
}

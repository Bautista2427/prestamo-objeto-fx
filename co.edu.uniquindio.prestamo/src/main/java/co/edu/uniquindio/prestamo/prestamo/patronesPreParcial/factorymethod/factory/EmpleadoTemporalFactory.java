package co.edu.uniquindio.prestamo.prestamo.patronesPreParcial.factorymethod.factory;

import co.edu.uniquindio.prestamo.prestamo.patronesPreParcial.factorymethod.model.Empleado;
import co.edu.uniquindio.prestamo.prestamo.patronesPreParcial.factorymethod.model.EmpleadoTemporal;

public class EmpleadoTemporalFactory extends EmpleadoFactory{

    @Override
    public Empleado crearEmpleado(String nombre) {
        return new EmpleadoTemporal(nombre);
    }
}

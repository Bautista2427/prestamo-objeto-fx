package co.edu.uniquindio.prestamo.prestamo.patronesPreParcial.factorymethod.factory;

import co.edu.uniquindio.prestamo.prestamo.patronesPreParcial.factorymethod.model.Empleado;
import co.edu.uniquindio.prestamo.prestamo.patronesPreParcial.factorymethod.model.EmpleadoPermanente;

public class EmpleadoPermanenteFactory extends EmpleadoFactory{

    @Override
    public Empleado crearEmpleado(String nombre) {
        return new EmpleadoPermanente(nombre);
    }
}

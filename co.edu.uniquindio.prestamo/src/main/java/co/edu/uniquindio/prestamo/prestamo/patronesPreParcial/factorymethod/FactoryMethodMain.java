package co.edu.uniquindio.prestamo.prestamo.patronesPreParcial.factorymethod;

import co.edu.uniquindio.prestamo.prestamo.patronesPreParcial.factorymethod.factory.EmpleadoFactory;
import co.edu.uniquindio.prestamo.prestamo.patronesPreParcial.factorymethod.factory.EmpleadoPermanenteFactory;
import co.edu.uniquindio.prestamo.prestamo.patronesPreParcial.factorymethod.factory.EmpleadoTemporalFactory;
import co.edu.uniquindio.prestamo.prestamo.patronesPreParcial.factorymethod.model.Empleado;

public class FactoryMethodMain {

    public static void main(String[] args) {
        EmpleadoFactory permanenteFactory= new EmpleadoPermanenteFactory();
        EmpleadoFactory temporalFactory = new EmpleadoTemporalFactory();

        Empleado empleado1= permanenteFactory.crearEmpleado("Pedro");
        Empleado empleado2= temporalFactory.crearEmpleado("Juan");

        empleado1.mostrarDatos();
        empleado2.mostrarDatos();
    }
}

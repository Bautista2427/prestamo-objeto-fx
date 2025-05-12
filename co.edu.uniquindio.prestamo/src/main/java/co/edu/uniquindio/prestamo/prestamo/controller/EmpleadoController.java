package co.edu.uniquindio.prestamo.prestamo.controller;

import co.edu.uniquindio.prestamo.prestamo.factory.ModelFactory;

import java.util.List;

public class EmpleadoController {
    ModelFactory modelFactory;

    public EmpleadoController() {
        modelFactory=ModelFactory.getInstancia();
    }

    public String obtenerClientesConMasPrestamos(int minimoPrestamos) {
        return modelFactory.obtenerEmpleadoConMasPrestamos(minimoPrestamos);
    }

}

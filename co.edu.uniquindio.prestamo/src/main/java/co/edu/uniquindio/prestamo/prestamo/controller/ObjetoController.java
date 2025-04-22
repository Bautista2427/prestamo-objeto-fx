package co.edu.uniquindio.prestamo.prestamo.controller;

import co.edu.uniquindio.prestamo.prestamo.factory.ModelFactory;

public class ObjetoController {
    ModelFactory modelFactory;

    public ObjetoController() {
        modelFactory=ModelFactory.getInstancia();
    }
    public String buscarObjetoIdenfiticador(String identificador) {
        return modelFactory.buscarObjetoIdenfiticador(identificador);
    }
}

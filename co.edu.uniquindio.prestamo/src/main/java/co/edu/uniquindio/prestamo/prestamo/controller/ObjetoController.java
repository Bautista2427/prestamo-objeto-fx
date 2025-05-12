package co.edu.uniquindio.prestamo.prestamo.controller;

import co.edu.uniquindio.prestamo.prestamo.factory.ModelFactory;
import co.edu.uniquindio.prestamo.prestamo.model.Objeto;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Date;

public class ObjetoController {
    ModelFactory modelFactory;

    public ObjetoController() {
        modelFactory=ModelFactory.getInstancia();
    }

    public String buscarObjetoIdenfiticador(String identificador) {
        return modelFactory.buscarObjetoIdentificador(identificador);
    }

    public List<String> obtenerObjetosMasPrestados(int minimoPrestamos) {
        List<Objeto> todosLosObjetos = modelFactory.obtenerObjetosMasPrestados(minimoPrestamos);

        return todosLosObjetos.stream()
                .map(Objeto::getNombre)
                .collect(Collectors.toList());
    }

    public String obtenerCantidadObjetosDisponibles() {
        return modelFactory.obtenerCantidadDisponibilidad();
    }

    public String obtenerPrestamosPorFechaEspecifica(Date fechaEspecifica) {
        return modelFactory.obtenerPrestamosPorFechaEspecifica(fechaEspecifica);
    }

    public String buscarObjetosDisponibilidad(boolean prestados, boolean noPrestados, boolean todos) {
        return modelFactory.buscarObjetosDisponibilidad(prestados,noPrestados,todos);
    }
}

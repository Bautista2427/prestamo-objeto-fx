package co.edu.uniquindio.prestamo.prestamo.controller;

import co.edu.uniquindio.prestamo.prestamo.factory.ModelFactory;
import co.edu.uniquindio.prestamo.prestamo.mapping.dto.ClienteDto;

import java.util.List;
import java.util.stream.Collectors;

public class ClienteController {
    ModelFactory modelFactory;
    public ClienteController(){
        modelFactory = ModelFactory.getInstancia();
    }

    public List<ClienteDto> obtenerClientes() {
        return modelFactory.obtenerClientes();
    }

    public boolean agregarCliente(ClienteDto clienteDto) {
        return modelFactory.agregarCliente(clienteDto);
    }

    public boolean eliminarCliente(String cedula) {
        return modelFactory.eliminarCliente(cedula);
    }

    public List<String> obtenerClientesConMasPrestamos(int minimoPrestamos) {
        return modelFactory.obtenerClientesConMasPrestamos(minimoPrestamos)
                .stream()
                .map(cliente -> cliente.getNombre() + " " + cliente.getApellido())
                .collect(Collectors.toList());
    }

}

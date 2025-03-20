package co.edu.uniquindio.prestamo.prestamo.service;

import co.edu.uniquindio.prestamo.prestamo.mapping.dto.ClienteDto;

import java.util.List;

public interface IModelFactoryService {
    List<ClienteDto> obtenerClientes();
}

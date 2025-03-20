package co.edu.uniquindio.prestamo.prestamo.service;


import co.edu.uniquindio.prestamo.prestamo.mapping.dto.ClienteDto;
import co.edu.uniquindio.prestamo.prestamo.model.Cliente;

import java.util.List;

public interface IPrestamoMapping {
    List<ClienteDto> getClientesDto(List<Cliente> listaClientes);
    ClienteDto clienteToClienteDto(Cliente cliente);
    Cliente clienteDtoToCliente(ClienteDto clienteDto);
}

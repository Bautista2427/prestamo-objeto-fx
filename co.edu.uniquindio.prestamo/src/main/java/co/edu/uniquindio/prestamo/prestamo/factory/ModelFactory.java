package co.edu.uniquindio.prestamo.prestamo.factory;

import co.edu.uniquindio.prestamo.prestamo.mapping.dto.ClienteDto;
import co.edu.uniquindio.prestamo.prestamo.mapping.mappers.PrestamoMappingImpl;
import co.edu.uniquindio.prestamo.prestamo.model.Cliente;
import co.edu.uniquindio.prestamo.prestamo.model.Objeto;
import co.edu.uniquindio.prestamo.prestamo.model.PrestamoObjeto;
import co.edu.uniquindio.prestamo.prestamo.service.IModelFactoryService;
import co.edu.uniquindio.prestamo.prestamo.service.IPrestamoMapping;
import co.edu.uniquindio.prestamo.prestamo.utils.DataUtil;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ModelFactory implements IModelFactoryService {
    private static ModelFactory modelFactory;
    private PrestamoObjeto prestamoObjeto;
    private IPrestamoMapping mapper;

    public static ModelFactory getInstancia() {
        if(modelFactory == null) {
            modelFactory = new ModelFactory();
        }
        return modelFactory;
    }

    private ModelFactory(){
        mapper = new PrestamoMappingImpl();
        prestamoObjeto = DataUtil.inicializarDatos();
    }


    @Override
    public List<ClienteDto> obtenerClientes() {
        return mapper.getClientesDto(prestamoObjeto.getListaClientes());
    }

    @Override
    public boolean agregarCliente(ClienteDto clienteDto) {
        Cliente cliente = mapper.clienteDtoToCliente(clienteDto);
        return prestamoObjeto.crearCliente(cliente);
        //return prestamoObjeto.crearCliente(mapper.clienteDtoToCliente(clienteDto));
    }

    @Override
    public boolean eliminarCliente(String cedula) {
        return prestamoObjeto.eliminarCliente(cedula);
    }

    public String buscarObjetoIdentificador(String idenfiticador){
        return prestamoObjeto.buscarObjetoIdentificador(idenfiticador);
    }

    public List<Objeto> obtenerObjetosMasPrestados(int minimoPrestamos) {
        return prestamoObjeto.obtenerObjetosMasPrestados(minimoPrestamos);
    }

    public String obtenerCantidadDisponibilidad() {
        return prestamoObjeto.obtenerCantidadDisponibilidad();
    }

    public List<Cliente> obtenerClientesConMasPrestamos(int minimoPrestamos) {
        return prestamoObjeto.obtenerClientesConMasPrestamos(minimoPrestamos);
    }
    public String obtenerEmpleadoConMasPrestamos(int minimoPrestamos){
        return prestamoObjeto.obtenerEmpleadoConMasPrestamo(minimoPrestamos);
    }

    public String obtenerPrestamosPorFechaEspecifica(Date fechaEspecifica) {
        return prestamoObjeto.obtenerPrestamosPorFechaEspecifica(fechaEspecifica);

    }
    public String buscarObjetosDisponibilidad(boolean prestados,boolean noPrestados,boolean todos){
        return prestamoObjeto.buscarObjetosDisponibilidad(prestados,noPrestados,todos);
    }
}

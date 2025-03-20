package co.edu.uniquindio.prestamo.prestamo.factory;

import co.edu.uniquindio.prestamo.prestamo.mapping.dto.ClienteDto;
import co.edu.uniquindio.prestamo.prestamo.mapping.mappers.PrestamoMappingImpl;
import co.edu.uniquindio.prestamo.prestamo.model.Cliente;
import co.edu.uniquindio.prestamo.prestamo.model.PrestamoObjeto;
import co.edu.uniquindio.prestamo.prestamo.service.IModelFactoryService;
import co.edu.uniquindio.prestamo.prestamo.service.IPrestamoMapping;
import co.edu.uniquindio.prestamo.prestamo.utils.DataUtil;

import java.util.List;

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
}

package co.edu.uniquindio.prestamo.prestamo.utils;

import co.edu.uniquindio.prestamo.prestamo.model.Cliente;
import co.edu.uniquindio.prestamo.prestamo.model.Objeto;
import co.edu.uniquindio.prestamo.prestamo.model.PrestamoObjeto;

public class DataUtil {

    public static PrestamoObjeto inicializarDatos() {
        PrestamoObjeto prestamoObjeto = new PrestamoObjeto();
        Objeto objeto1 = new Objeto( "Espada Legendaria","OBJ001");
        Objeto objeto2 = new Objeto( "Escudo Mágico","OBJ002");
        Objeto objeto3 = new Objeto("Hacha Leviatan", "OBJ003");
        Objeto objeto4 = new Objeto("Ballesta Valheim", "OBJ004");
        Cliente cliente1 = Cliente.builder()
                .cedula("1094")
                .nombre("juan")
                .apellido("arias")
                .direccion("armenia")
                .edad(17)
                .email("jsjsj@gmail.com")
                .build();

        Cliente cliente2 = Cliente.builder()
                .cedula("1095")
                .nombre("Ana")
                .apellido("cardenas")
                .direccion("quimbaya")
                .edad(25)
                .email("jsjsj2@gmail.com")
                .build();

        Cliente cliente3 = Cliente.builder()
                .cedula("1096")
                .nombre("Pedro")
                .apellido("perez")
                .direccion("armenia")
                .edad(40)
                .email("jsjsj3@gmail.com")
                .build();
        prestamoObjeto.agregarObjeto(objeto1);
        prestamoObjeto.agregarObjeto(objeto2);
        prestamoObjeto.agregarObjeto(objeto3);
        prestamoObjeto.agregarObjeto(objeto4);
        prestamoObjeto.getListaClientes().add(cliente1);
        prestamoObjeto.getListaClientes().add(cliente2);
        prestamoObjeto.getListaClientes().add(cliente3);

        return prestamoObjeto;
    }
}

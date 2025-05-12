package co.edu.uniquindio.prestamo.prestamo.utils;

import co.edu.uniquindio.prestamo.prestamo.model.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataUtil {

    public static PrestamoObjeto inicializarDatos() {
        PrestamoObjeto prestamoObjeto = new PrestamoObjeto();
        Objeto objeto1 = new Objeto("Espada Legendaria", "OBJ001");
        Objeto objeto2 = new Objeto("Escudo Mágico", "OBJ002");
        Objeto objeto3 = new Objeto("Hacha Leviatan", "OBJ003");
        Objeto objeto4 = new Objeto("Ballesta Valheim", "OBJ004");
        Prestamo prestamo1 = new Prestamo();
        Prestamo prestamo2 = new Prestamo();
        Empleado empleado1=new Empleado("pedro");
        Empleado empleado2=new Empleado("juan");
        //empleado2.asociarPrestamo(prestamo1);
        empleado2.asociarPrestamo(prestamo2);
        empleado1.asociarPrestamo(prestamo1);
        Prestamo prestamo3= new Prestamo();

        prestamoObjeto.getListaEmpleados().add(empleado1);
        prestamoObjeto.getListaEmpleados().add(empleado2);

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

        objeto2.setOwnedByPrestamoUq(prestamoObjeto);

        Prestamo prestamo = new Prestamo();
        prestamo.setClienteAsociado(cliente1);
        List<Objeto> objetosPrestados = new ArrayList<>();
        objetosPrestados.add(objeto1);
        objetosPrestados.add(objeto2);
        prestamo.setListaObjetosAsociados(objetosPrestados);
        prestamoObjeto.getListaPrestamos().add(prestamo);

        prestamo.setClienteAsociado(cliente2);
        List<Objeto> objetosPrestados2 = new ArrayList<>();
        objetosPrestados2.add(objeto1);
        objetosPrestados2.add(objeto2);
        prestamo.setListaObjetosAsociados(objetosPrestados2);
        prestamoObjeto.getListaPrestamos().add(prestamo);


        prestamo.setClienteAsociado(cliente3);
        List<Objeto> objetosPrestados3 = new ArrayList<>();
        objetosPrestados3.add(objeto1);
        objetosPrestados3.add(objeto2);
        prestamo.setListaObjetosAsociados(objetosPrestados3);
        prestamoObjeto.getListaPrestamos().add(prestamo);

        return prestamoObjeto;
    }
}
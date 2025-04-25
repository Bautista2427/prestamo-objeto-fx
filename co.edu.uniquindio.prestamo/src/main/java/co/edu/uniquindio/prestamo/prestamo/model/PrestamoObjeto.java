package co.edu.uniquindio.prestamo.prestamo.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrestamoObjeto {

    List<Cliente> listaClientes = new ArrayList<>();
    List<Empleado> listaEmpleados = new ArrayList<>();
    List<Objeto> listaObjetos = new ArrayList<>();
    List<Prestamo> listaPrestamos = new ArrayList<>();

    private String nombre;


    public PrestamoObjeto() {
    }

    public List<Objeto> getListaObjetos() {
        return listaObjetos;
    }

    public void setListaObjetos(List<Objeto> listaObjetos) {
        this.listaObjetos = listaObjetos;
    }

    public List<Prestamo> getListaPrestamos() {
        return listaPrestamos;
    }

    public void setListaPrestamos(List<Prestamo> listaPrestamos) {
        this.listaPrestamos = listaPrestamos;
    }

    public boolean crearCliente(String cedula,
                                String nombre,
                                String apellido,
                                String email,
                                String telefonoFijo,
                                String telefonoCelular,
                                String direccion){
        Cliente clienteEncontrado = obtenerCliente(cedula);
        if(clienteEncontrado == null){
            Cliente cliente = getBuildCliente(cedula, nombre, apellido, email, telefonoFijo, telefonoCelular, direccion);
            getListaClientes().add(cliente);
            return true;
        }else{
            return  false;
        }
    }

    public boolean crearCliente(Cliente nuevoCliente){
        Cliente clienteEncontrado = obtenerCliente(nuevoCliente.getCedula());
        if(clienteEncontrado == null){
            getListaClientes().add(nuevoCliente);
            return true;
        }else{
            return  false;
        }
    }



    private Cliente getBuildCliente(String cedula, String nombre, String apellido, String email, String telefonoFijo, String telefonoCelular, String direccion) {
        return Cliente.builder()
                .nombre(nombre)
                .apellido(apellido)
                .cedula(cedula)
                .direccion(direccion)
                .email(email)
                .telefonoFijo(telefonoFijo)
                .telefonoCelular(telefonoCelular)
                .build();
    }

    private Cliente obtenerCliente(String cedula) {
        Cliente cliente = null;
        for (Cliente cliente1: getListaClientes()) {
            if(cliente1.getCedula().equalsIgnoreCase(cedula)){
                cliente = cliente1;
                break;
            }
        }

        return cliente;
    }


    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String obtenerClientesPorCiudad(String ciudad) {
        String resultado = "";

        for (Cliente cliente: getListaClientes()) {
            if(cliente.getDireccion().equalsIgnoreCase(ciudad)){
                resultado = resultado + cliente.toString()+ "\n";
            }
        }

        return resultado;
    }

    public boolean eliminarCliente(String cedula) {
        Cliente clienteEncontrado = obtenerCliente(cedula);
        if(clienteEncontrado !=null){
            getListaClientes().remove(clienteEncontrado);
            return true;
        }else{
            return false;
        }
    }
    public boolean agregarObjeto(Objeto objeto){
        Objeto objetoEcontrado=buscarObjeto(objeto);
        if(objetoEcontrado == null){
            getListaObjetos().add(objeto);
            return true;
        }

        return false;
    }

    private Objeto buscarObjeto(Objeto objeto) {
        for(Objeto buscarObjeto: listaObjetos){
            if(buscarObjeto.getIdObjeto().equalsIgnoreCase(objeto.getIdObjeto())){
                return buscarObjeto;
            }
        }
        return null;
    }

    public String buscarObjetoIdentificador(String identificador) {
        String nombreObjeto = null;
        for(Objeto objeto: listaObjetos){
            if(objeto.getIdObjeto().equalsIgnoreCase(identificador)){
                nombreObjeto=objeto.getNombre();
            }
        }
        return nombreObjeto;
    }

    public List<Objeto> obtenerObjetosMasPrestados(int minimoPrestamos) {
        List<Objeto> resultado = new ArrayList<>();
        for (Objeto obj : listaObjetos) {
            int prestamos = obtenerCantidadPrestamosDeObjeto(obj.getIdObjeto());
            if (prestamos > minimoPrestamos) {
                resultado.add(obj);
            }
        }
        return resultado;
    }

    public int obtenerCantidadPrestamosDeObjeto(String idObjeto) {
        int contador = 0;
        for (Prestamo prestamo : listaPrestamos) {
            for (Objeto obj : prestamo.getListaObjetosAsociados()) {
                if (obj.getIdObjeto().equalsIgnoreCase(idObjeto)) {
                    contador++;
                }
            }
        }
        return contador;
    }

    public String  obtenerCantidadDisponibilidad() {
        String disponibilidad = "Objetos disponibles\n";
        String disponibilidad2 = "Objetos no disponibles\n";
        for (Objeto obj : listaObjetos) {
            if (obj.isDisponible()) {
                disponibilidad+=obj.toString()+"\n";
            } else {
                disponibilidad2+=obj.toString()+"\n";
            }
        }
        disponibilidad+= disponibilidad2;
        return disponibilidad;
    }

    public List<Cliente> obtenerClientesConMasPrestamos(int minimoPrestamos) {
        List<Cliente> resultado = new ArrayList<>();
        for (Cliente cliente : listaClientes) {
            int prestamos = (int) listaPrestamos.stream()
                    .filter(prestamo -> prestamo.getClienteAsociado().equals(cliente))
                    .count();
            if (prestamos >= minimoPrestamos) {
                resultado.add(cliente);
            }
        }
        return resultado;
    }
}

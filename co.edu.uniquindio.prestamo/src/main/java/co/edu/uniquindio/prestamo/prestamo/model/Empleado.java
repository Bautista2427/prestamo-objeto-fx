package co.edu.uniquindio.prestamo.prestamo.model;

import java.util.ArrayList;

public class Empleado extends  Persona{
    private String nombre;
    ArrayList<Prestamo> listaPrestamosAsociados;
    PrestamoObjeto ownedByPrestamoUq;

    public Empleado(String nombre) {
        this.nombre = nombre;
        listaPrestamosAsociados=new ArrayList<>();
    }

    public PrestamoObjeto getOwnedByPrestamoUq() {
        return ownedByPrestamoUq;
    }

    public void setOwnedByPrestamoUq(PrestamoObjeto ownedByPrestamoUq) {
        this.ownedByPrestamoUq = ownedByPrestamoUq;
    }

    public ArrayList<Prestamo> getListaPrestamosAsociados() {
        return listaPrestamosAsociados;
    }
    public String toString(){
        return nombre;
    }

    public void asociarPrestamo(Prestamo prestamo){
        listaPrestamosAsociados.add(prestamo);
    }

}

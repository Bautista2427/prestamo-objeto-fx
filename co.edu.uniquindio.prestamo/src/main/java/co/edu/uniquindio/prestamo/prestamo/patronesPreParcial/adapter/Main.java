package co.edu.uniquindio.prestamo.prestamo.patronesPreParcial.adapter;

import co.edu.uniquindio.prestamo.prestamo.patronesPreParcial.adapter.model.AdaptadorPasarelaPago;
import co.edu.uniquindio.prestamo.prestamo.patronesPreParcial.adapter.model.PasarelaModernaPago;
import co.edu.uniquindio.prestamo.prestamo.patronesPreParcial.adapter.model.ProcesoPago;
import co.edu.uniquindio.prestamo.prestamo.patronesPreParcial.adapter.model.SistemaPagosAntiguos;

public class Main {
    public static void main(String[] args) {

        SistemaPagosAntiguos sistemaAntiguo = new SistemaPagosAntiguos();
        sistemaAntiguo.pagar(100.0);

        // Adaptador conectando el sistema antiguo a la pasarela moderna
        PasarelaModernaPago pasarelaNueva = new PasarelaModernaPago();
        ProcesoPago adaptador = new AdaptadorPasarelaPago(pasarelaNueva);

        // Ahora el sistema antiguo puede usar la pasarela moderna a través del adaptador
        adaptador.procesarPago(250.0);
    }
}

package co.edu.uniquindio.prestamo.prestamo.patronesPreParcial.adapter.model;

public class AdaptadorPasarelaPago implements ProcesoPago {
        private PasarelaModernaPago pasarelaModernaPago;

        public AdaptadorPasarelaPago(PasarelaModernaPago pasarelaModernaPago) {
            this.pasarelaModernaPago = pasarelaModernaPago;
        }


    @Override
    public void procesarPago(double cantidad) {
            pasarelaModernaPago.pago(cantidad,"24");
    }
}

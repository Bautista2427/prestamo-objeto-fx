package co.edu.uniquindio.prestamo.prestamo.patronesParcial.model;

public class PaymentFacade {
    PaypalService paypalService = new PaypalService();
    BankTransferService bankTransferService = new BankTransferService();
    StripeService stripeService = new StripeService();

    public String tipoPago(String tipo,Double monto) {
        String tipoPago = "";
        if(tipo.equalsIgnoreCase("paypal")) tipoPago = paypalService.pagar(monto);
        else if (tipo.equalsIgnoreCase("transferencia bancaria")) {tipoPago=bankTransferService.transferir(monto);
        } else if (tipo.equalsIgnoreCase("servicio stripe")) {tipoPago=stripeService.cobrar(monto);
        }else{ tipoPago="El pago fue rechazado debido a no colocar ninguna entidad bancaria";
    }
        return tipoPago;
    }
}

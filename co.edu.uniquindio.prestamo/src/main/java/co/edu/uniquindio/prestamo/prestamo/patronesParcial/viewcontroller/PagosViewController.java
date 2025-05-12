package co.edu.uniquindio.prestamo.prestamo.patronesParcial.viewcontroller;

import co.edu.uniquindio.prestamo.prestamo.patronesParcial.model.PaymentFacade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class PagosViewController {
    PaymentFacade facade=new PaymentFacade();

    @FXML
    private Button btnPagar;

    @FXML
    private ComboBox<String> cmbMetodoPago;

    @FXML
    private TextArea txtMensajes;

    @FXML
    private TextField txtMonto;

    @FXML
    void OnPagar(ActionEvent event) {
        double monto=Double.parseDouble(txtMonto.getText());
        String tipoPago= cmbMetodoPago.getValue();
        String Payment= facade.tipoPago(tipoPago,monto);
        mostrarMensaje("Pago Exitoso","Pago",Payment, Alert.AlertType.CONFIRMATION);



    }
    @FXML
    void initialize() {
        cmbMetodoPago.getItems().addAll("paypal","Transferencia bancaria","Servicio Stripe");
    }

    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();
    }


}
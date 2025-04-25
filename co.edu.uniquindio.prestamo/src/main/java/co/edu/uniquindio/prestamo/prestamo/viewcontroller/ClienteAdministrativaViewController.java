package co.edu.uniquindio.prestamo.prestamo.viewcontroller;

import co.edu.uniquindio.prestamo.prestamo.controller.ClienteController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.List;

public class ClienteAdministrativaViewController {
    @FXML
    private TextArea txtListaClientesMayorPrestamo;

    @FXML
    private TextField txtRangoClientesMayorPrestamo;

    @FXML
    private Button btnClientesMayorPrestamo;

    @FXML
    void onClientesMayorPrestamo(ActionEvent event) {
        try {
            int minimoPrestamos = Integer.parseInt(txtRangoClientesMayorPrestamo.getText().trim());

            ClienteController clienteController = new ClienteController();
            List<String> clientes = clienteController.obtenerClientesConMasPrestamos(minimoPrestamos);

            if (clientes.isEmpty()) {
                txtListaClientesMayorPrestamo.setText("No hay clientes con más de " + minimoPrestamos + " préstamos.");
            } else {
                StringBuilder resultado = new StringBuilder(minimoPrestamos);
                for (String nombre : clientes) {
                    resultado.append("- ").append(nombre).append("\n");
                }
                txtListaClientesMayorPrestamo.setText(resultado.toString());
            }
        } catch (NumberFormatException e) {
            txtListaClientesMayorPrestamo.setText("Por favor, ingresa un número válido.");
        }
    }
}

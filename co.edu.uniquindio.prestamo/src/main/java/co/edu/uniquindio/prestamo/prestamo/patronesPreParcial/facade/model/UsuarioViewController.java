package co.edu.uniquindio.prestamo.prestamo.patronesPreParcial.facade.model;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class UsuarioViewController {
    UsuarioFacade usuarioFacade = new UsuarioFacade();

    @FXML
    private Button btnCrearUsuario;

    @FXML
    private TextField txtContraseña;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtNombre;

    @FXML
    void onCrearUsuario(ActionEvent event) {
        boolean datosValidos= usuarioFacade.login(txtNombre.getText(),txtCorreo.getText(),txtContraseña.getText());
        if(datosValidos)mostrarMensaje("UsuarioAgregado","Notificacion","El usuario fue agregado",
                Alert.AlertType.INFORMATION);
        mostrarMensaje("Usuario no agregado","Notificacion",
                "El usuario no fue agregado, datos invalidos o contraseña insegura",Alert.AlertType.WARNING);
    }
    @FXML
    void initialize() {}
    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();
    }

}


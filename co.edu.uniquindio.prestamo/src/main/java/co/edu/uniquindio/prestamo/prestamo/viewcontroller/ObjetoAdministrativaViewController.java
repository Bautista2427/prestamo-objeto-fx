package co.edu.uniquindio.prestamo.prestamo.viewcontroller;

import co.edu.uniquindio.prestamo.prestamo.controller.ClienteController;
import co.edu.uniquindio.prestamo.prestamo.controller.ObjetoController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ObjetoAdministrativaViewController {
    ObjetoController objetoController=new ObjetoController();

    @FXML
    private Button btnBuscarObjetoIdentificador;

    @FXML
    private Button btnBuscarObjetoRango;

    @FXML
    private TextField txtIdentificaorObjeto;

    @FXML
    private TextArea txtListaObjetosPrestados;

    @FXML
    private TextField txtObjeto;

    @FXML
    private TextField txtRangoObjeto;

    @FXML
    void onBuscarObjetiRango(ActionEvent event) {
    }

    @FXML
    void onBuscarObjetoIdentificador(ActionEvent event) {
        String identificador= txtIdentificaorObjeto.getText();
        if(!identificador.isBlank()){
            String nombreObjeto=objetoController.buscarObjetoIdenfiticador(identificador);
            txtObjeto.setText(nombreObjeto);
        }
    }

    @FXML
    void initialize() {
    }

}

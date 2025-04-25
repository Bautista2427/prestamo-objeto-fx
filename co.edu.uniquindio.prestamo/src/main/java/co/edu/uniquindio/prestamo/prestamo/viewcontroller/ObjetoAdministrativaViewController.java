package co.edu.uniquindio.prestamo.prestamo.viewcontroller;

import co.edu.uniquindio.prestamo.prestamo.controller.ObjetoController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.List;
import java.util.Map;

public class ObjetoAdministrativaViewController {
    ObjetoController objetoController=new ObjetoController();

    @FXML
    private Button btnBuscarObjetoRango;

    @FXML
    private Label lbCantidadDisponible;

    @FXML
    private TextArea txtListaObjetosPrestados;

    @FXML
    private TextField txtRangoObjeto;

    @FXML
    private TextField txtIdentificaorObjeto;

    @FXML
    private Button btnBuscarObjetoIdentificador;

    @FXML
    private Button btnBuscarCantidadObjetos;

    @FXML
    private TextField txtObjeto;

    @FXML
    private TextArea txtDisponibilidadSalida;

    @FXML
    private Label lbCantidadNoDisponible;

    @FXML
    void onBuscarObjetoIdentificador(ActionEvent event) {
        String identificador= txtIdentificaorObjeto.getText();
        if(!identificador.isBlank()){
            String nombreObjeto = objetoController.buscarObjetoIdenfiticador(identificador);
            txtObjeto.setText(nombreObjeto);
        }
    }

    @FXML
    void onBuscarObjetoRango(ActionEvent event) {
        String textoRango = txtRangoObjeto.getText();
        if (!textoRango.isBlank()) {
            try {
                int minimoPrestamos = Integer.parseInt(textoRango.trim());

                List<String> objetos = objetoController.obtenerObjetosMasPrestados(minimoPrestamos);

                if (objetos.isEmpty()) {
                    txtListaObjetosPrestados.setText("No hay objetos que superen ese número de préstamos.");
                } else {
                    StringBuilder resultado = new StringBuilder("\n");
                    for (String obj : objetos) {
                        resultado.append("- ").append(obj).append("\n");
                    }
                    txtListaObjetosPrestados.setText(resultado.toString());
                }
            } catch (NumberFormatException e) {
                txtListaObjetosPrestados.setText("Por favor, ingresa un número válido.");
            }
        } else {
            txtListaObjetosPrestados.setText("El campo de rango no puede estar vacío.");
        }
    }

    @FXML
    void onBuscarCantidadObjetos(ActionEvent event) {
        String disponibilidad = objetoController.obtenerCantidadObjetosDisponibles();

        txtDisponibilidadSalida.setText("Disponibles: " + disponibilidad);
    }

    @FXML
    void initialize() {
    }
}

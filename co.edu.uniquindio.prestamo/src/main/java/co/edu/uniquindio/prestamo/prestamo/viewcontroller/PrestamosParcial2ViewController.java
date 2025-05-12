package co.edu.uniquindio.prestamo.prestamo.viewcontroller;

import co.edu.uniquindio.prestamo.prestamo.controller.ClienteController;
import co.edu.uniquindio.prestamo.prestamo.controller.EmpleadoController;
import co.edu.uniquindio.prestamo.prestamo.controller.ObjetoController;
import co.edu.uniquindio.prestamo.prestamo.model.Objeto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.text.DateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class PrestamosParcial2ViewController {
    ObjetoController objetoController=new ObjetoController();
    private ToggleGroup grupoSeleccionado=new ToggleGroup();

    @FXML
    private Button btnFechaEspecifica;

    @FXML
    private Button btnFechaInicialFinal;

    @FXML
    private Button btnObjetosPrestadosNoPrestados;

    @FXML
    private Button btnValorConsulta;

    @FXML
    private RadioButton rbNoPrestados;

    @FXML
    private RadioButton rbPrestados;

    @FXML
    private RadioButton rbTodos;

    @FXML
    private TextField txtFechaEspecifica;

    @FXML
    private TextField txtFechaFinal;

    @FXML
    private TextField txtFechaInicial;

    @FXML
    private TextArea txtListaFechaEspecifica;

    @FXML
    private TextArea txtListaPrestamoFechaInicialFinal;

    @FXML
    private TextArea txtListadoEmpleados;

    @FXML
    private TextArea txtListadoObjetosPrestadosNoPrestados;

    @FXML
    private TextField txtValorConsulta;

    @FXML
    void initialize() {
        rbNoPrestados.setToggleGroup(grupoSeleccionado);
        rbTodos.setToggleGroup(grupoSeleccionado);
        rbPrestados.setToggleGroup(grupoSeleccionado);
    }

    @FXML
    void OnValorConsulta(ActionEvent event) {
        try {
            int minimoPrestamos = Integer.parseInt(txtValorConsulta.getText().trim());

            EmpleadoController empleadoController = new EmpleadoController();
            String listaEmpleados = empleadoController.obtenerClientesConMasPrestamos(minimoPrestamos);

            if (listaEmpleados.isEmpty()) {
                txtListadoEmpleados.setText("No hay empleados con más de " + minimoPrestamos + " préstamos.");
            } else {
                txtListadoEmpleados.setText(listaEmpleados);
            }
        } catch (NumberFormatException e) {
            txtListadoEmpleados.setText("Por favor, ingresa un número válido.");
        }
    }

    @FXML
    void OnObjetosPrestadosNoPrestados(ActionEvent event) {
        boolean prestados = rbPrestados.isSelected();
        boolean noPrestados = rbNoPrestados.isSelected();
        boolean todos=rbTodos.isSelected();
        String listaPrestamos = objetoController.buscarObjetosDisponibilidad(prestados,noPrestados,todos);
        if (listaPrestamos.isEmpty()) {
            txtListadoObjetosPrestadosNoPrestados.setText("No existe ningun objeto con estas condiciones");

        }else{
            txtListadoObjetosPrestadosNoPrestados.setText(listaPrestamos);
        }
    }

    @FXML
    void OnFechaEspecifica(ActionEvent event) {


    }

    @FXML
    void OnFechaInicialFinal(ActionEvent event) {

    }
}
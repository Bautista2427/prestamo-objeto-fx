module co.edu.uniquindio.prestamo.prestamo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens co.edu.uniquindio.prestamo.prestamo to javafx.fxml;
    exports co.edu.uniquindio.prestamo.prestamo;
    opens co.edu.uniquindio.prestamo.prestamo.viewcontroller;
    exports co.edu.uniquindio.prestamo.prestamo.viewcontroller;
    opens co.edu.uniquindio.prestamo.prestamo.controller;
    exports co.edu.uniquindio.prestamo.prestamo.controller;

    opens co.edu.uniquindio.prestamo.prestamo.patronesPreParcial.facade;
    exports co.edu.uniquindio.prestamo.prestamo.patronesPreParcial.facade;

}
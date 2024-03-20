module co.edu.uniquindio.parcial1fx.parcial1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.parcial1fx.parcial1 to javafx.fxml;
    exports co.edu.uniquindio.parcial1fx.parcial1;

    opens co.edu.uniquindio.parcial1fx.parcial1.viewController to javafx.fxml;
    exports co.edu.uniquindio.parcial1fx.parcial1.viewController;
    opens co.edu.uniquindio.parcial1fx.parcial1.controller to javafx.fxml;
    exports co.edu.uniquindio.parcial1fx.parcial1.controller;
}
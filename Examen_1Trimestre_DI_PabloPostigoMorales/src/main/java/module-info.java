module com.example.examen_1trimestre_di_pablopostigomorales {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;


    opens com.example.examen_1trimestre_di_pablopostigomorales to javafx.fxml;
    exports com.example.examen_1trimestre_di_pablopostigomorales;
}
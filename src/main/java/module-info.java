module com.example.datasecurity {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.datasecurity to javafx.fxml;
    exports com.example.datasecurity;
}
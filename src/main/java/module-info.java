module com.example.datasecurity {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;


    opens com.example.datasecurity to javafx.fxml;
    exports com.example.datasecurity;
    exports app;
    opens controller to javafx.fxml;
}
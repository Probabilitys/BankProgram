module com.example.bank_window {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.bank_window to javafx.fxml;
    exports com.example.bank_window;
}
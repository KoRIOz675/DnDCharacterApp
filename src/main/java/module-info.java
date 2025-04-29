module com.nightbreeze {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.nightbreeze to javafx.fxml;
    exports com.nightbreeze;
}

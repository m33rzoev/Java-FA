module com.mirzoev.demo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.mirzoev.demo to javafx.fxml;
    exports com.mirzoev.demo;
}
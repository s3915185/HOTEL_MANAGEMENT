module com.example.hotelmanagement {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires java.sql;

    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens com.example.hotelmanagement to javafx.fxml;
    exports com.example.hotelmanagement;
    opens com.example.hotelmanagement.actionControllers to javafx.fxml;
    opens com.example.hotelmanagement.reportControllers to javafx.fxml;
    opens com.example.hotelmanagement.reportControllers.reportOverall to javafx.fxml;
    exports com.example.hotelmanagement.reportControllers.reportOverall;
    opens com.example.hotelmanagement.actionControllers.CheckIn to javafx.fxml;
}
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
    opens com.example.hotelmanagement.reportControllers.reportOverall to javafx.fxml;
    exports com.example.hotelmanagement.reportControllers.reportOverall;
    opens com.example.hotelmanagement.actionControllers.CheckIn to javafx.fxml;
    exports com.example.hotelmanagement.Objects;
    opens com.example.hotelmanagement.Objects to javafx.fxml;
    opens com.example.hotelmanagement.actionControllers.CheckOut to javafx.fxml;
    opens com.example.hotelmanagement.actionControllers.HallReservation to javafx.fxml;
    opens com.example.hotelmanagement.actionControllers.RoomReservation to javafx.fxml;
    opens com.example.hotelmanagement.actionControllers.RoomService to javafx.fxml;
    opens com.example.hotelmanagement.actionControllers.Voucher to javafx.fxml;
    opens com.example.hotelmanagement.reportControllers.reportAllTransactions to javafx.fxml;
    opens com.example.hotelmanagement.reportControllers.reportCheckOutDue to javafx.fxml;
    opens com.example.hotelmanagement.reportControllers.reportDayBook to javafx.fxml;
    opens com.example.hotelmanagement.reportControllers.reportDebtors to javafx.fxml;
    opens com.example.hotelmanagement.reportControllers.reportHallReservation to javafx.fxml;
    opens com.example.hotelmanagement.reportControllers.reportRoomOccupancy to javafx.fxml;
    opens com.example.hotelmanagement.reportControllers.reportRoomReservation to javafx.fxml;
}
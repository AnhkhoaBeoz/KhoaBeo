module com.thao.banvexe {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.datatype.jsr310;
    
    opens com.thao.banvexe to javafx.fxml;
    opens com.thao.pojo to javafx.fxml;
    
    exports com.thao.banvexe;
    exports com.thao.pojo;
    exports com.thao.Services;
}

module com.example.dictionarylookup {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires com.google.gson;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    // Allow reflection access for Gson
    opens com.example.dictionarylookup to javafx.fxml, com.google.gson;

    // Export your package
    exports com.example.dictionarylookup;
}

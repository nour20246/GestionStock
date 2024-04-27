
module GestiondeStock {
	requires java.desktop;
	requires org.junit.jupiter.api;
	requires junit;
	requires javafx.controls;
    requires javafx.fxml;

        // Autres directives de votre module
    exports Classes; 
        exports InterfacesGraphiques; // Exportez votre package InterfacesGraphiques
        

}
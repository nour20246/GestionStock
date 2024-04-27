package InterfacesGraphiques;

import Classes.GestMagasin;
import Classes.Magasin;
import Classes.Produit;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.List;

public class ProductRecherUI extends Application {
    private Magasin magasin = GestMagasin.getMagasin(); // Référence au magasin

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Recherche de Produit");
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        Label numLabel = new Label("Numero de Produit:");
        TextField numField = new TextField();
        grid.add(numLabel, 0, 0);
        grid.add(numField, 1, 0);

        Button searchButton = new Button("Rechercher");
        searchButton.setOnAction(e -> {
            try {
                int num = Integer.parseInt(numField.getText().trim());

                boolean rechercheReussie = magasin.findProduct(num);

                if (rechercheReussie) {
                    afficherMessageSucces("Produit trouvé!");
                } else {
                    afficherMessageEchec("Produit non trouvé");
                }
            } catch (NumberFormatException ex) {
                afficherMessageEchec("Veuillez entrer un numéro valide.");
            }
        });

        grid.add(searchButton, 0, 1, 2, 1);

        Scene scene = new Scene(grid, 300, 150);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void afficherMessageSucces(String message) {
        afficherMessage("Succès", message);
    }

    private void afficherMessageEchec(String message) {
        afficherMessage("Échec", message);
    }

    private void afficherMessage(String titre, String contenu) {
        Stage stage = new Stage();
        stage.setTitle(titre);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));

        Label label = new Label(contenu);
        grid.add(label, 0, 0);

        Scene scene = new Scene(grid, 300, 100);
        stage.setScene(scene);
        stage.show();
    }
}

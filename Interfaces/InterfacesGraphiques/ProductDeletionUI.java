package InterfacesGraphiques;

import Classes.GestMagasin;
import Classes.Magasin;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ProductDeletionUI extends Application {

    private 	Magasin magasin=GestMagasin.getMagasin();

    public ProductDeletionUI() {
    	
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Suppression de Produit");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));

        // Numéro de produit à supprimer
        Label numLabel = new Label("Numero de Produit:");
        TextField numField = new TextField();
        grid.add(numLabel, 0, 0);
        grid.add(numField, 1, 0);

        // Bouton Annuler
        Button cancelButton = new Button("Annuler");
        cancelButton.setOnAction(e -> primaryStage.close());
        grid.add(cancelButton, 0, 1);

        // Bouton Supprimer
        Button deleteButton = new Button("Supprimer");
        deleteButton.setOnAction(e -> confirmerSuppression(primaryStage, numField.getText()));
        grid.add(deleteButton, 1, 1);

        Scene scene = new Scene(grid, 300, 150);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void confirmerSuppression(Stage stage, String input) {
        try {
            int numProduit = Integer.parseInt(input);
            
            Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
            confirmation.setTitle("Confirmation de suppression");
            confirmation.setHeaderText("Voulez-vous vraiment supprimer ce produit?");
            confirmation.setContentText("Cette action est irréversible.");

            confirmation.showAndWait().ifPresent(response -> {
                if (response == javafx.scene.control.ButtonType.OK) {
                    boolean suppressionReussie = magasin.removeProduit(numProduit);

                    if (suppressionReussie) {
                        afficherMessageSucces("Produit supprime avec succès!");
                    } else {
                        afficherMessageEchec("Echec de la suppression du produit.");
                    }
                }
            });
        } catch (NumberFormatException e) {
            afficherMessageEchec("Veuillez saisir un numéro valide.");
        }
    }


    private void afficherMessageSucces(String message) {
        afficherMessage("Succès", message);
    }

    private void afficherMessageEchec(String message) {
        afficherMessage("Échec", message);
    }

    private void afficherMessage(String titre, String contenu) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titre);
        alert.setHeaderText(null);
        alert.setContentText(contenu);
        alert.showAndWait();
    }

}




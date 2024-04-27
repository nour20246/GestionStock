package InterfacesGraphiques;
import Classes.GestMagasin;
import Classes.Magasin;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ReservationUI extends Application {

	private	Magasin magasin=GestMagasin.getMagasin(); // Variable pour référencer le magasin

    // Constructeur prenant un magasin en paramètre pour l'initialiser
    public ReservationUI() {
    	
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Interface de Réservation");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));

        // Nom du produit
        Label nomLabel = new Label("Nom du Produit:");
        TextField nomField = new TextField();
        grid.add(nomLabel, 0, 0);
        grid.add(nomField, 1, 0);

        // Quantité à réserver
        Label quantiteLabel = new Label("Quantité à Réserver:");
        TextField quantiteField = new TextField();
        grid.add(quantiteLabel, 0, 1);
        grid.add(quantiteField, 1, 1);

        // Bouton pour réserver
        Button reservationButton = new Button("Réserver");
        reservationButton.setOnAction(e -> {
            // Récupérer les valeurs des champs
            String nom = nomField.getText().trim();
            String quantiteText = quantiteField.getText().trim();

            // Vérifier que tous les champs sont remplis
            if (nom.isEmpty() || quantiteText.isEmpty()) {
                afficherMessage("Champs incomplets", "Veuillez remplir tous les champs.");
                return;  // Arrêter le traitement si un champ est vide
            }

            try {
                // Récupérer les valeurs des champs après la validation
                int quantite = Integer.parseInt(quantiteText);

                // Appeler la méthode de réservation du magasin
                boolean reservationReussie = magasin.reservation(nom, quantite);

                if (reservationReussie) {
                    afficherMessageSucces();
                } else {
                    afficherMessageEchec();
                }
            } catch (NumberFormatException ex) {
                afficherMessage("Erreur de format", "Veuillez entrer une valeur numérique valide pour la quantité à réserver.");
            }
        });

        grid.add(reservationButton, 0, 2, 2, 1);

        Scene scene = new Scene(grid, 300, 150);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void afficherMessageSucces() {
        afficherMessage("Réservation réussie!", "La réservation a été effectuée avec succès.");
    }

    private void afficherMessageEchec() {
        afficherMessage("Échec de la réservation", "Impossible de réserver le produit. Vérifiez la disponibilité.");
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

























package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Classes.Magasin;
import Classes.Produit;

class TestSupprimerProduit {
    @Test
    public void TestDeleteSucces() {
    	 // Configuration initiale du magasin avec un produit
        Magasin magasin = new Magasin("Mon Magasin", "123 Rue de la Ville");
         Produit produit = new Produit();
         produit.setNumProd(1);
         produit.setNomProd("Article 1");
         produit.setquantiteEnStockProd(0);
         // Ajouter le produit au magasin
         magasin.addProduit(produit);
         // Tester la suppression réussie
         boolean suppressionReussie = magasin.removeProduit(1);
         assertTrue(suppressionReussie);
         assertEquals(0, magasin.getProduits().size());    }
}

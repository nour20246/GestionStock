package Tests;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import Classes.Magasin;
import Classes.Produit;
class TestAjoutProduitEchec {
	@Test
	 public void TestAddProduitEchec() {
		  // Créer un magasin avec un stock maximal de 100
	        Magasin magasin = new Magasin("NomMagasin", "AdresseMagasin"); 
	        // Créer un produit avec une quantité qui respecte le stock maximal
	        Produit produit1 = new Produit();
	        produit1.setNumProd(1);
	        produit1.setNomProd("Produit 1");
	        produit1.setquantiteEnStockProd(500); // Quantité qui respecte le stock maximal
	        // Ajouter le produit au magasin
	        assertTrue(magasin.addProduit(produit1));
	       
	 }

}

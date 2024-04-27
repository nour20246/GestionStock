package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Classes.Magasin;
import Classes.Produit;

class TestRechercheProduit {

	  @Test
	    public void testProduitExiste() {
	        Magasin magasin = new Magasin("NomMagasin", "AdresseMagasin");
	        Produit produit = new Produit();
	        produit.setNumProd(1);
	        produit.setNomProd("Article 1");
	        produit.setquantiteEnStockProd(10);
	        magasin.addProduit(produit);
	        assertTrue(magasin.findProduct(1)); // Le produit devrait exister dans le magasin
	    }
}

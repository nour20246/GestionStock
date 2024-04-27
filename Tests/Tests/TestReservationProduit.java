package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Classes.Magasin;
import Classes.Produit;

class TestReservationProduit {
	
	 @Test
	    public void TestReservationSucces() {
		 Magasin magasin = new Magasin("Mon Magasin", "123 Rue de la Ville");
	        Produit produit = new Produit();
	        produit.setNumProd(1);
	        produit.setNomProd("Article 1");
	        produit.setquantiteEnStockProd(10);
	        magasin.addProduit(produit);
	        // Tester la réservation réussie
	        boolean reservationReussie = magasin.reservation("Article 1", 5);
	        assertTrue(reservationReussie);
	        assertEquals(5, produit.getReservations());
	        assertEquals(5, produit.getProdquantiteEnStock());
	        }
}

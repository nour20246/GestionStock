package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Classes.Magasin;
import Classes.Produit;

class TestRechercheProduitEchec {

	@Test
    public void TestRechecheProduitEchec() {
        Magasin magasin = new Magasin("NomMagasin", "AdresseMagasin");
        Produit produit = new Produit();
        produit.setNumProd(1);
        produit.setNomProd("Article 1");
        produit.setquantiteEnStockProd(10);
        magasin.addProduit(produit);
        assertTrue(magasin.findProduct(2));
    }
}

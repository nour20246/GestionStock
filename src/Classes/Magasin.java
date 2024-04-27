package Classes;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Magasin {
	
	    private String nom;
	    private String adresse;
	    private Integer stockMax;
	    private List<Produit> produits;

	    public Magasin(String nom, String adresse) {
	        this.nom = nom;
	        this.adresse = adresse;
	        this.stockMax=100;
	        this.produits = new ArrayList<>();
	    }
	    // Getters et setters
	    public String getNomMag() {
	        return nom;
	    }
	    public void setNomMag(String nom) {
	        this.nom = nom;
	    }
	    public String getAdresse() {
	        return adresse;
	    }
	    public void setAdresse(String adresse) {
	        this.adresse = adresse;
	    }
	    public List<Produit> getProduits() {
	        return this.produits;
	    }
	    public ArrayList<Produit> getProds() {
	        return new ArrayList<>(produits);
	    }
	    public boolean findProduct(int num) {
	        for (Produit produit : produits) {
	            if (produit.getNumProd() == num) {
	            	 System.out.println("Le produit avec le numero " + produit.getNumProd() + " existe dans le magasin.");
	                return true;
	            }
	        }
	        System.out.println("Le produit avec le numero " + num + " n existe pas dans le magasin.");
	        return false;
	    }
	    // Autres méthodes
	    public int stockDisponible() {
	        int stockTotal = 0;
	        for (Produit produit : produits) {
	            stockTotal += produit.getProdquantiteEnStock();
	        }
	        return stockTotal;
	    }
	    public Produit Product(int num) {
	        for (Produit produit : produits) {
	            if (produit.getNumProd() == num) {
	                return produit;
	            }
	        }
	        return null;
	    }
	    
	    public boolean addProduit(Produit produit) {
	        // Vérifier si le produit existe déjà
	        if (findProduct(produit.getNumProd())) {
	            System.out.println("Le produit avec le numero " + produit.getNumProd() + " existe deja dans le magasin.");
	            Produit prod= Product(produit.getNumProd());
	            int som = prod.getProdquantiteEnStock() + produit.getProdquantiteEnStock();
	            int somres = prod.getReservations()+produit.getReservations();
	            if (stockDisponible() + prod.getProdquantiteEnStock() <= stockMax) {
	            	 prod.setquantiteEnStockProd(som);
	 	            prod.setReservations(somres);
		            System.out.println("Produit ajouté avec succès!");
		            return true; // Ajout réussi
		        }
	            System.out.println("Produit non ajouté !");
	            return false; // Ajout échoué, le produit existe déjà
	        }
	        else {if (stockDisponible() + produit.getProdquantiteEnStock() <= stockMax) {
	            produits.add(produit);
	            System.out.println("Produit ajouté avec succès!");
	            return true; // Ajout réussi
	        } else {
	            System.out.println("echec de l'ajout. Stock maximum atteint.");
	            return false; // Stock maximum atteint, ajout échoué
	        }}
	    }
	    

	    public boolean removeProduit(int numProduit) {
	        if (findProduct(numProduit)) {
	        	Produit p=new Produit();
	        	p=Product(numProduit);
	        	if(p.getProdquantiteEnStock()!=0) {
	        		System.out.println("Le stock de ce produit n'a pas encore atteint 0.");
	        		return false;
	        	}else {
	 	            // Supprimer le produit de la liste
	 	            produits.remove(p);
	 	           System.out.println("Produit supprime avec succes.");
	 	            return true; // Retourne true si la suppression réussit
	        	}
	        }
	        else {
	        	System.out.println("Produit n'existe pas dans le magasin.");
	        return false; // Retourne false si le produit n'est pas trouvé
	    }}

			public void afficherprods() {
			    System.out.println("liste des produits");
				for (Produit produit : produits) {
			        System.out.println(produit);
			        }
			}
	    public boolean reservation(String nom, int quantite) {
	        for (Produit produit : produits) {
	            if (produit.getProdnom().equals(nom)) {
	                if (quantite <= produit.getProdquantiteEnStock()) {
	                    produit.setReservations(produit.getReservations() + quantite);
	                    int a = produit.getProdquantiteEnStock() - quantite;
	                    produit.setquantiteEnStockProd(a);
	                    System.out.println("Produit bien reservé");
	                    return true;
	                }else { System.out.println("Produit existe mais la quantité demandée est plus grande que le stockk disponible");}
	            }else {System.out.println("Produit n'existe pas dans le magasin");}
	        }
	        return false;
	    }
	    
	    
	    
	}



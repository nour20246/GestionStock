package Classes;
public class Produit {
	private int num;
	private String description;
	private int quantiteEnStock;
	private double prix;
	private String nom;
	private int reservations;
	
	 // Getters et setters
	public int getNumProd() {
		return num;
	}
	public void setNumProd(int id) {
		this.num = id;
	}
	public String getProdnom() {
		return nom;
	}
	public void setNomProd(String nom) {
		this.nom = nom;
	}
	public int getProdquantiteEnStock() {
		return quantiteEnStock;
	}
	public void setquantiteEnStockProd(int p) {
		this.quantiteEnStock = p  ;
	}
	public double getProdprix() {
		return prix;
	}
	public void setprixProd(double p) {
		this.prix = p;
	}
	public int getReservations() {  return reservations; }
	
	public void setReservations(int reservations) {
	    if(reservations <= quantiteEnStock && reservations >= 0){
	        this.reservations = reservations;
	    }
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
	    return "Produit{" +
	            "num=" + num +
	            ", nom='" + nom + '\'' +
	            ", prix='" + prix + '\'' +
	            ", quantiteEnStock='" + quantiteEnStock + '\''+
	            '}';
	}
	
}

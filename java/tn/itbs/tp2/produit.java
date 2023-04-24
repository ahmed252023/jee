package tn.itbs.tp2;

public class produit {
	private int id;
	private int prix;
	private int quantité;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	public int getQuantité() {
		return quantité;
	}
	public void setQuantité(int quantité) {
		this.quantité = quantité;
	}
	public produit(int id, int prix, int quantité) {
		super();
		this.id = id;
		this.prix = prix;
		this.quantité = quantité;
	}
	public produit() {
		super();
	}
	
	
	
	

}

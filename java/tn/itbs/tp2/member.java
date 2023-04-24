package tn.itbs.tp2;

public class member {
	private int id;
	private String nom;
	private String date_deb;
	private String date_fin;
	private int phone;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDate_deb() {
		return date_deb;
	}
	public void setDate_deb(String date_deb) {
		this.date_deb = date_deb;
	}
	public String getDate_fin() {
		return date_fin;
	}
	public void setDate_fin(String date_fin) {
		this.date_fin = date_fin;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	public member(int id, String nom, String date_deb, String date_fin, int phone) {
		super();
		this.id = id;
		this.nom = nom;
		this.date_deb = date_deb;
		this.date_fin = date_fin;
		this.phone = phone;
	}
	public member() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	

}

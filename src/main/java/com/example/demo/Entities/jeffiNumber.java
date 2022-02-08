package com.example.demo.Entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class jeffiNumber {
    
	@Id @GeneratedValue
	private long id;
	private String Phone;
	private String Client;
	private double Prix;
	private double fourisseurPrix;
	private Date dateCreate;
	private boolean paye;
	private String FournisseurName;
	@ManyToOne
	@JoinColumn(name="ID_FOURN")
	private Fournisseur fournisseur;
	

	public jeffiNumber() {
		super();
	}


	


	public jeffiNumber(String phone, String client, double prix, double fourisseurPrix, Date dateCreate, boolean paye,
			Fournisseur fournisseur) {
		super();
		Phone = phone;
		Client = client;
		Prix = prix;
		this.fourisseurPrix = fourisseurPrix;
		this.dateCreate = dateCreate;
		this.paye = paye;
		this.fournisseur = fournisseur;
	}

	



	public jeffiNumber(String phone, String client, double prix, double fourisseurPrix, Date dateCreate, boolean paye,
			String fournisseurName, Fournisseur fournisseur) {
		super();
		Phone = phone;
		Client = client;
		Prix = prix;
		this.fourisseurPrix = fourisseurPrix;
		this.dateCreate = dateCreate;
		this.paye = paye;
		FournisseurName = fournisseurName;
		this.fournisseur = fournisseur;
	}





	public String getFournisseurName() {
		return FournisseurName;
	}





	public void setFournisseurName(String fournisseurName) {
		FournisseurName = fournisseurName;
	}





	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getClient() {
		return Client;
	}

	public void setClient(String client) {
		Client = client;
	}

	public double getPrix() {
		return Prix;
	}

	public void setPrix(double prix) {
		Prix = prix;
	}

	public double getFourisseurPrix() {
		return fourisseurPrix;
	}

	public void setFourisseurPrix(double fourisseurPrix) {
		this.fourisseurPrix = fourisseurPrix;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}
	public Date getDateCreate() {
		return dateCreate;
	}


	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}


	public boolean isPaye() {
		return paye;
	}


	public void setPaye(boolean paye) {
		this.paye = paye;
	}
	
	
	
}

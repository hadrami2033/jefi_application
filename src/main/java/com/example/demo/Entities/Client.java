package com.example.demo.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Client {
	
	@Id @GeneratedValue
	private long id;
	private String Nom;
	private double Montant;
	private double MontantPaye;
	
	public Client() {
		super();
	}

	public Client(String nom) {
		super();
		Nom = nom;
	}
	
	public Client(String nom, double montant, double montantPaye) {
		super();
		Nom = nom;
		Montant = montant;
		MontantPaye = montantPaye;
	}

	public double getMontant() {
		return Montant;
	}

	public void setMontant(double montant) {
		Montant = montant;
	}

	public double getMontantPaye() {
		return MontantPaye;
	}

	public void setMontantPaye(double montantPaye) {
		MontantPaye = montantPaye;
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	} 
}

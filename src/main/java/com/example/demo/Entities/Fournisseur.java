package com.example.demo.Entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Fournisseur {
	
	@Id @GeneratedValue
	private long id;
	private String Nom;
	private double Montant;
	private double MontantPaye;
	@OneToMany(mappedBy = "fournisseur",fetch = FetchType.EAGER)
	private Collection<jeffiNumber> founisseurNumbers;
	
	public Fournisseur() {
		super();
	}

	public Fournisseur(String nom) {
		super();
		Nom = nom;
	}
	
	public Fournisseur(String nom, double montant, double montantPaye, Collection<jeffiNumber> founisseurNumbers) {
		super();
		Nom = nom;
		Montant = montant;
		MontantPaye = montantPaye;
		this.founisseurNumbers = founisseurNumbers;
	}
	public Fournisseur(String nom, Collection<jeffiNumber> founisseurNumbers) {
		super();
		Nom = nom;
		this.founisseurNumbers = founisseurNumbers;
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

	public Collection<jeffiNumber> getFounisseurNumbers() {
		return founisseurNumbers;
	}

	public void setFounisseurNumbers(Collection<jeffiNumber> founisseurNumbers) {
		this.founisseurNumbers = founisseurNumbers;
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

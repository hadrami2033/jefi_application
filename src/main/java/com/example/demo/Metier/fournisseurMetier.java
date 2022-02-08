package com.example.demo.Metier;

import java.util.List;

import com.example.demo.Entities.Fournisseur;

public interface fournisseurMetier {

	public Fournisseur addFournisseur(Fournisseur f);
	public List<Fournisseur> Fournisseurs();
	public String getFournisseurName(long id);
	public void deleteProvider(long id);
	public List<Fournisseur> chercheFournisseur(String nom);
}

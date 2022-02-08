package com.example.demo.Metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Dao.fournisseurRepository;
import com.example.demo.Entities.Fournisseur;

@Service
@Transactional
public class fournisseurMetierImplemente implements fournisseurMetier{
	
	@Autowired
	private fournisseurRepository fournisseurrepository;

	@Override
	public Fournisseur addFournisseur(Fournisseur f) {
		fournisseurrepository.save(f);
		return f;
	}

	@Override
	public List<Fournisseur> Fournisseurs() {
		List<Fournisseur> all = fournisseurrepository.findAll();
		return all;
	}

	@Override
	public String getFournisseurName(long id) {
		Fournisseur fournisseur=fournisseurrepository.getOne(id);
		String Nom=fournisseur.getNom();
		return Nom;
	}

	@Override
	public void deleteProvider(long id) {
		fournisseurrepository.deleteById(id);
	}

	@Override
	public List<Fournisseur> chercheFournisseur(String nom) {
		List<Fournisseur> lst=fournisseurrepository.findFournisseur(nom);
		return lst;
	}

}

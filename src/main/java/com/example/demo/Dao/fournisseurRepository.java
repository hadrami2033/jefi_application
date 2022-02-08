package com.example.demo.Dao;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.Entities.Fournisseur;

public interface fournisseurRepository extends JpaRepository<Fournisseur, Long>{
	@Query("select f from Fournisseur f where f.Nom like :x")
	public List<Fournisseur> findFournisseur(@Param("x")String fournisseurName);
}

package com.example.demo.Dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Entities.Client;

public interface clientRepository extends JpaRepository<Client, Long>{
	@Query("select c from Client c where c.Nom like :x")
	public List<Client> findClient(@Param("x")String clientName);
	@Query("select c from Client c where c.Nom like :x")
	public Client findClientByName(@Param("x")String clientName);
}

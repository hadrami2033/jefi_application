package com.example.demo.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Entities.jeffiNumber;

public interface jeffiNumberRepository extends JpaRepository<jeffiNumber,Long>{
	@Query("select n from jeffiNumber n where n.paye = true")
	public List<jeffiNumber> jeffiNumbersPayes();
	@Query("select n from jeffiNumber n where n.paye = false")
	public List<jeffiNumber> jeffiNumbersNonPayes();
	@Query("select n from jeffiNumber n where n.FournisseurName like :x")
	public List<jeffiNumber> fournisseurJeffiNumbers(@Param("x")String fournisseurName);
	@Query("select n from jeffiNumber n where n.Phone like :x or n.Client like :x")
	public List<jeffiNumber> findJeffiNumbers(@Param("x")String mc);
	
}

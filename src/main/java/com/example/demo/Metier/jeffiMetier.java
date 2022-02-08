package com.example.demo.Metier;

import java.util.List;

import com.example.demo.Entities.jeffiNumber;

public interface jeffiMetier {

	public jeffiNumber addJeffiNumber(jeffiNumber jeffinumber);
	public List<jeffiNumber> jeffiNumbers();
	public List<jeffiNumber> jeffiNumbersPayes();
	public List<jeffiNumber> jeffiNumbersNonPaye();
	public List<jeffiNumber> fournisseurJeffiNumbers(String fournisseurName);
	public void deleteNumber(long id);
	public jeffiNumber getNumber(long id);
	public List<jeffiNumber> chercheNumber(String mc);
}

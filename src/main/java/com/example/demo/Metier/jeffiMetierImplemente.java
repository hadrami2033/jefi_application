package com.example.demo.Metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Dao.jeffiNumberRepository;
import com.example.demo.Entities.jeffiNumber;

@Service
@Transactional
public class jeffiMetierImplemente implements jeffiMetier{
	
	@Autowired
	private jeffiNumberRepository jeffinumberRepository;
	
	@Override
	public jeffiNumber addJeffiNumber(jeffiNumber jeffinumber) {
		jeffinumberRepository.save(jeffinumber);
		return jeffinumber;
	}

	@Override
	public List<jeffiNumber> jeffiNumbers() {
		List<jeffiNumber> all = jeffinumberRepository.findAll();
		return all;
	}

	@Override
	public List<jeffiNumber> jeffiNumbersPayes() {
		List<jeffiNumber> listPaye = jeffinumberRepository.jeffiNumbersPayes();
		return listPaye;
	}

	@Override
	public List<jeffiNumber> jeffiNumbersNonPaye() {
		List<jeffiNumber> listNonPaye = jeffinumberRepository.jeffiNumbersNonPayes();
		return listNonPaye;
	}

	@Override
	public List<jeffiNumber> fournisseurJeffiNumbers(String fournisseurName) {
		
		List<jeffiNumber> fournisseurNumbers = jeffinumberRepository.fournisseurJeffiNumbers(fournisseurName);
		return fournisseurNumbers;
	}

	@Override
	public void deleteNumber(long id) {
		jeffinumberRepository.deleteById(id);
		
	}

	@Override
	public jeffiNumber getNumber(long id) {
		jeffiNumber number=jeffinumberRepository.getOne(id);
		return number;
	}

	@Override
	public List<jeffiNumber> chercheNumber(String mc) {
		List<jeffiNumber> list=jeffinumberRepository.findJeffiNumbers(mc);
		return list;
	}
	
	
}

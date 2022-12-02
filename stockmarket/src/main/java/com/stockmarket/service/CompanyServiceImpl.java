package com.stockmarket.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockmarket.exceptions.CompanyIdAlreadyPresentException;
import com.stockmarket.model.Company;
import com.stockmarket.repository.CompanyRepository;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepository companyRepository;

	@Override
	public List<Company> getAllCompanys() {
		List<Company> companyList = companyRepository.findAll();
		if (companyList != null && companyList.size() > 0) {
			return companyList;
		} else
			return null;
	}

	@Override
	public Company addCompany(Company company) throws CompanyIdAlreadyPresentException {
		Optional<Company> company1 = companyRepository.findById(company.getCompanyCode());
		if (company1.isPresent()) {
			throw new CompanyIdAlreadyPresentException();
		} else {
			return companyRepository.saveAndFlush(company);
		}

	}

	@Override
	public boolean deleteCompany(int companyCode) {
		companyRepository.deleteById(companyCode);
		return true;
	}

	@Override
	public boolean updateCompany(Company company) {

		Company company1 = companyRepository.getById(company.getCompanyCode());
		if (company1 != null) {
			company1.setCompanyTurnover(company.getCompanyTurnover());
			companyRepository.saveAndFlush(company1);
		}
		return true;
	}

	@Override
	public Company getCompanyById(int companyCode) {
		Optional<Company> company = companyRepository.findById(companyCode);
		if (company.isPresent()) {
			return company.get();
		}
		return null;
	}

}

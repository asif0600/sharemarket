package com.stockmarket.service;

import java.util.List;

import com.stockmarket.exceptions.CompanyIdAlreadyPresentException;
import com.stockmarket.model.Company;

public interface CompanyService {

public List<Company> getAllCompanys();
	
	public Company addCompany(Company company) throws CompanyIdAlreadyPresentException;
	
	public boolean deleteCompany(int companyCode);
	
	public boolean updateCompany(Company company);
	
	public Company getCompanyById(int companyCode);
}

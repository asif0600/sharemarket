package com.sharemarket.service;

import java.util.List;

import com.sharemarket.exception.CompanyIdAlreadyPresentException;
import com.sharemarket.model.Company;

public interface CompanyService {
	
public List<Company> getAllCompanys();
	
	public Company addCompany(Company company) throws CompanyIdAlreadyPresentException;
	
	public boolean deleteCompany(int companyCode);
	
	public boolean updateCompany(Company Company);
	
	public Company getCompanyById(int companyCode);

}

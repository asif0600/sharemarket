package com.sharemarket.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import com.sharemarket.model.Company;

@DataJpaTest
@AutoConfigureMockMvc
public class CompanyRepositoryTest {

	@Autowired
	private CompanyRepository companyRepository;

	Company company = new Company();

	@BeforeEach
	public void initValueOfObject() {
		company.setCompanyCode(101);
		company.setCompanyName("DELL");
		company.setCompanyCEO("Smith");
		company.setCompanyTurnover(1786.22);
		company.setCompanyWebsite("www.dell.com");
		company.setCompanyStockExchange("NSE");
	}

	@Test
	public void saveCompanySuccess() throws Exception {
		Optional<Company> c = null;
		companyRepository.save(company);

		c = companyRepository.findById(company.getCompanyCode());

		assertEquals(company.getCompanyName(), c.get().getCompanyName());

	}

	@Test
	public void saveUserFailure() throws Exception {
		Company cmpny = null;

		if (companyRepository.findAll().toString().isEmpty()) {
			companyRepository.save(company);
			cmpny = companyRepository.getById(company.getCompanyCode());
		}

		assertNull(cmpny);

	}

}

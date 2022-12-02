package com.sharemarket.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.sharemarket.model.Company;
import com.sharemarket.repository.CompanyRepository;

@AutoConfigureMockMvc
@SpringBootTest
public class CompanyServiceTest {

	@Mock
	private CompanyRepository companyRepository;

	@InjectMocks
	private CompanyServiceImpl companyService;;

	@Autowired
	private MockMvc mockmvc;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
		mockmvc = MockMvcBuilders.standaloneSetup(companyService).build();
	}

	private List<Company> companylist = new ArrayList();

	@Test
	public void getAllCompanySuccess() throws Exception {
		Company company = new Company();

		company.setCompanyCode(102);
		company.setCompanyName("TATA");
		company.setCompanyCEO("Ratan Tata");
		company.setCompanyTurnover(3746464.98);
		company.setCompanyWebsite("www.tatagroup.com");
		company.setCompanyStockExchange("NSE");

		companylist.add(company);
		when(companyRepository.findAll()).thenReturn(companylist);

		List<Company> cmpny = companyService.getAllCompanys();

		assertEquals(companylist, cmpny);

	}

	@Test
	public void getAllCompanyFailure() throws Exception {

		when(companyRepository.findAll()).thenReturn(null);

		List<Company> cmpny = companyService.getAllCompanys();

		assertNull(cmpny);

	}

	@Test
	public void addCompanySuccess() throws Exception {
		Company company = new Company();

		company.setCompanyCode(102);
		company.setCompanyName("TATA");
		company.setCompanyCEO("Ratan Tata");
		company.setCompanyTurnover(3746464.98);
		company.setCompanyWebsite("www.tatagroup.com");
		company.setCompanyStockExchange("NSE");

		companylist.add(company);
		when(companyRepository.save(any())).thenReturn(company);

		Company company1 = companyService.addCompany(company);

		assertNotEquals(company, company1);
	}
	
	 @Test
	    public void addCompanyFailure() throws Exception
	    {
	    	Company company  = new Company();
	    	
	    	company.setCompanyCode(102);
			company.setCompanyName("TATA");
			company.setCompanyCEO("Ratan Tata");
			company.setCompanyTurnover(3746464.98);
			company.setCompanyWebsite("www.tatagroup.com");
			company.setCompanyStockExchange("NSE");
			
			companylist.add(company);
	    	when(companyRepository.save(any())).thenReturn(null);
	    	
	    	Company company1  = companyService.addCompany(company);
	    	
	    	assertNull(company1);
	    }

}

package com.sharemarket.controller;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

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
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sharemarket.model.Company;
import com.sharemarket.service.CompanyServiceImpl;

@AutoConfigureMockMvc
@SpringBootTest
public class CompanyControllerTest {

	@Mock
	private CompanyServiceImpl companyService;

	@InjectMocks
	private CompanyController companyController;

	@Autowired
	private MockMvc mockmvc;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
		mockmvc = MockMvcBuilders.standaloneSetup(companyController).build();
	}

	private List<Company> companylist = new ArrayList();

	@Test
	public void getAllcompanySuccess() throws Exception {
		Company company = new Company();

		company.setCompanyCode(102);
		company.setCompanyName("TATA");
		company.setCompanyCEO("Ratan Tata");
		company.setCompanyTurnover(3746464.98);
		company.setCompanyWebsite("www.tatagroup.com");
		company.setCompanyStockExchange("NSE");

		companylist.add(company);
		when(companyService.getAllCompanys()).thenReturn(companylist);

		List<Company> cmpny = companyService.getAllCompanys();

		assertEquals(companylist, cmpny);

		mockmvc.perform(
				MockMvcRequestBuilders.get("/api/v1.0/market/company/getall").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());

	}

	@Test
	public void getAllCompanyFailure() throws Exception {

		companylist.clear();
		when(companyService.getAllCompanys()).thenReturn(companylist);

		assertEquals(0, companylist.size());

		mockmvc.perform(MockMvcRequestBuilders.get("/api/v1.0/market/company/getall").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());

	}
	
	@Test
    public void addCompanySuccess() throws Exception
    {
    	Company company  = new Company();
    	
    	company.setCompanyCode(102);
		company.setCompanyName("TATA");
		company.setCompanyCEO("Ratan Tata");
		company.setCompanyTurnover(3746464.98);
		company.setCompanyWebsite("www.tatagroup.com");
		company.setCompanyStockExchange("NSE");
		
		companylist.add(company);
    	when(companyService.addCompany(any())).thenReturn(company);
    	
    	Company company1  = companyService.addCompany(company);
    	
    	assertEquals(company,company1);
    	
    	
    	mockmvc.perform(MockMvcRequestBuilders.post("/api/v1.0/market/company/register").contentType(MediaType.APPLICATION_JSON)
    			.content(new ObjectMapper().writeValueAsString(company)))
    		.andExpect(MockMvcResultMatchers.status().isCreated());
    	
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
	    	when(companyService.addCompany(any())).thenReturn(null);
	    	
	    	Company company1  = companyService.addCompany(company);
	    	
	    	assertNull(company1);
	    	
	    	
	    	mockmvc.perform(MockMvcRequestBuilders.post("/api/v1.0/market/company/register").contentType(MediaType.APPLICATION_JSON)
	    			.content(new ObjectMapper().writeValueAsString(company)))
	    		.andExpect(MockMvcResultMatchers.status().isConflict());
	    	
	    }

}

package com.sharemarket.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sharemarket.exception.CompanyIdAlreadyPresentException;
import com.sharemarket.model.Company;
import com.sharemarket.model.Stock;
import com.sharemarket.service.CompanyService;
import com.sharemarket.service.StockService;

import io.swagger.v3.oas.annotations.Hidden;

@RestController
@RequestMapping("api/v1.0")
public class CompanyController {

	@Autowired
	private CompanyService companyService;
	@Autowired
	private StockService stockService;

	@PostMapping("/market/company/register")
	public ResponseEntity<?> addCompany(@RequestBody Company company) throws CompanyIdAlreadyPresentException {
		if (companyService.addCompany(company) != null) {

			return new ResponseEntity<Company>(company, HttpStatus.CREATED);
		}

		return new ResponseEntity<String>("Company object could not be created", HttpStatus.CONFLICT);

	}

	@GetMapping("/market/company/info/{companycode}")
	public ResponseEntity<?> getCompanyById(@PathVariable("companycode") int companycode) {
		Company company = companyService.getCompanyById(companycode);
		if (company != null) {
			Set<Stock> stockList = stockService.getAllStock(company.getCompanyCode());
			company.setStockList(stockList);
			return new ResponseEntity<Company>(company, HttpStatus.OK);
			
		}

		return new ResponseEntity<String>("Company id not present", HttpStatus.NO_CONTENT);
	}

	@GetMapping("/market/company/getall")
	public ResponseEntity<?> getAllCompanys() {
		List<Company> companylist = companyService.getAllCompanys();
		if (companylist != null) {
			
			for (Company c:companylist) {
				Set<Stock> stockList = stockService.getAllStock(c.getCompanyCode());
				c.setStockList(stockList);
			}
			
			
			
			return new ResponseEntity<List<Company>>(companylist, HttpStatus.OK);

		}
		return new ResponseEntity<String>("No Company present", HttpStatus.NO_CONTENT);
	}
	
	 @PutMapping("market/market/put/{companyCode}")
	    public ResponseEntity<?> updateCompany(@RequestBody Company company)
	    {
	    	if(companyService.updateCompany(company))
	    	{
	    		 return new ResponseEntity<String>("Company record updated", HttpStatus.OK);
	    	}
	    	 return new ResponseEntity<String>("Company could not updated", HttpStatus.INTERNAL_SERVER_ERROR);
	    }


	@Hidden
	@DeleteMapping("/market/company/delete/{companycode}")
	public ResponseEntity<?> deleteBook(@PathVariable("companycode") int companycode) {
		
		if  (companyService.deleteCompany(companycode))
		{
			return new ResponseEntity<>(HttpStatus.OK);

		}
		return new ResponseEntity<String>("Company could not deleted", HttpStatus.INTERNAL_SERVER_ERROR);
	}

}

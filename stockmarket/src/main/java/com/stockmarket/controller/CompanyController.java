package com.stockmarket.controller;

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

import com.stockmarket.exceptions.CompanyIdAlreadyPresentException;
import com.stockmarket.model.Company;
import com.stockmarket.service.CompanyService;

@RestController
@RequestMapping("api/v1.0")
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	@PostMapping("/market/company/register")
	public ResponseEntity<?> addCompany(@RequestBody Company company) throws CompanyIdAlreadyPresentException {
		if (companyService.addCompany(company) != null) {

			return new ResponseEntity<Company>(company, HttpStatus.CREATED);
		}

		return new ResponseEntity<String>("Company object could not be created", HttpStatus.CONFLICT);

	}

//	@GetMapping("/market/company/getall")
//	public ResponseEntity<?> getAllCompany() {
//		List<Company> companyList = companyService.getAllCompanys();
//		if (companyList != null) {
//
////	    		for(Company c : companyList)
////	    		{
////	    			Set<Reader> readerList = readerService2.getAllReaders(b.getBookId());
////	    			b.setReaderList(readerList);
////	    			
////	    		}
//			return new ResponseEntity<List<Company>>(companyList, HttpStatus.OK);
//
//		}
//
//		return new ResponseEntity<String>("Company List is empty", HttpStatus.NO_CONTENT);
//
//	}

	@DeleteMapping("/market/company/delete/{companyCode}")
	public ResponseEntity<?> deleteCompany(@PathVariable("companyCode") int companyCode) {
		if (companyService.deleteCompany(companyCode)) {
			return new ResponseEntity<>(HttpStatus.OK);

		}
		return new ResponseEntity<String>("Company could not deleted", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@PutMapping("/market/market/put/<companycode>")
	public ResponseEntity<?> updateCompany(@RequestBody Company company) {
		if (companyService.updateCompany(company)) {
			return new ResponseEntity<String>("Company record updated", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Company could not updated", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping("/market/company/info/{companyCode}")
	public ResponseEntity<?> getCompanyById(@PathVariable("companyCode") int companyCode) {
		Company companyexists = companyService.getCompanyById(companyCode);
		if (companyexists != null) {
			return new ResponseEntity<Company>(companyexists, HttpStatus.OK);
		}

		return new ResponseEntity<String>("Company code not present", HttpStatus.NO_CONTENT);
	}

}

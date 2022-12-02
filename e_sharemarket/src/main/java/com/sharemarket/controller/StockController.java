package com.sharemarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sharemarket.model.Company;
import com.sharemarket.model.Stock;
import com.sharemarket.service.CompanyService;
import com.sharemarket.service.StockService;

@RestController
@RequestMapping("api/v1.0/market/stock")
public class StockController {
	
	
	@Autowired
	private StockService stockService;
	
	@Autowired
	private CompanyService companyService;
	
	
	@PostMapping("add/{companycode}")
	public ResponseEntity<?> addstock(@PathVariable("companycode") int companycode, @RequestBody Stock stock)
	{
		Company existCompany = companyService.getCompanyById(companycode);
		
		if(existCompany !=null)
		{
	
			stock.setCompanyCode_fk(stock.getCompanyCode_fk());;
			stock.setTransactionId(stock.getTransactionId());;
			stock.setStockPrice(stock.getStockPrice());
			stock.setTimeStamp(stock.getTimeStamp());
			
			if(stockService.addStock(stock))
			
				return new ResponseEntity<String>("Stock data updated ", HttpStatus.CREATED);
			}
			
			return new ResponseEntity<String>("Stock could not be added or updated", HttpStatus.INTERNAL_SERVER_ERROR);
			
			
		
	}
	
	
	
	

}

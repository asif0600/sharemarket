package com.sharemarket.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Company {
	

	@Id
	private int companyCode;
	private String companyName;
	private String companyCEO;
	private double companyTurnover;
	private String companyWebsite;
	private String companyStockExchange; //NSE or BSE
	
	@OneToOne(targetEntity= Stock.class)
	private Set<Stock> stockList;
	
	
	
	
	public Set<Stock> getStockList() {
		return stockList;
	}
	public void setStockList(Set<Stock> stockList) {
		this.stockList = stockList;
	}
	public int getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(int companyCode) {
		this.companyCode = companyCode;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyCEO() {
		return companyCEO;
	}
	public void setCompanyCEO(String companyCEO) {
		this.companyCEO = companyCEO;
	}
	public double getCompanyTurnover() {
		return (double) companyTurnover;
	}
	public void setCompanyTurnover(double companyTurnover) {
		this.companyTurnover = (double) companyTurnover;
	}
	public String getCompanyWebsite() {
		return companyWebsite;
	}
	public void setCompanyWebsite(String companyWebsite) {
		this.companyWebsite = companyWebsite;
	}
	public String getCompanyStockExchange() {
		return companyStockExchange;
	}
	public void setCompanyStockExchange(String companyStockExchange) {
		this.companyStockExchange = companyStockExchange;
	}
	
	
	
	

}

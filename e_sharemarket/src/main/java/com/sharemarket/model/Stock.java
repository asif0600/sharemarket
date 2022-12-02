package com.sharemarket.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Stock {

	@Id
	@GeneratedValue
	 int transactionId;

	private int companyCode_fk;

	private double stockPrice;

	private LocalDate timeStamp;

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public int getCompanyCode_fk() {
		return companyCode_fk;
	}

	public void setCompanyCode_fk(int companyCode_fk) {
		this.companyCode_fk = companyCode_fk;
	}

	public double getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(double stockPrice) {
		this.stockPrice = stockPrice;
	}

	public LocalDate getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDate timeStamp) {
		this.timeStamp = timeStamp;
	}

}

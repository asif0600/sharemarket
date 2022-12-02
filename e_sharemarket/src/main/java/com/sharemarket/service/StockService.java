package com.sharemarket.service;

import java.util.Set;

import org.springframework.http.ResponseEntity;

import com.sharemarket.model.Stock;

public interface StockService {

	public Set<Stock> getAllStock(int companyCode);

	public boolean addStock(Stock stock);

    public boolean deleteStock(int compamyCode);

}

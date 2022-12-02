package com.sharemarket.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharemarket.model.Stock;
import com.sharemarket.repository.StockRepository;

@Service
public class StockServiceImpl implements StockService {

	@Autowired
	private StockRepository stockRepository;
	
	
	

	@Override
	public Set<Stock> getAllStock(int companyCode) {
		Set<Stock> stockList = stockRepository.getStockList(companyCode);
		if (stockList != null && stockList.size() > 0) {
			return stockList;
		} else
			return null;
	}

	@Override
	public boolean addStock(Stock stock) {
		stock.setTransactionId(stock.getTransactionId());
		stock.setCompanyCode_fk(stock.getCompanyCode_fk());
		stock.setStockPrice(stock.getStockPrice());
		stockRepository.saveAndFlush(stock);
		return true;
	}

	@Override
	public boolean deleteStock(int compamyCode) {
		stockRepository.deleteCompanyData(compamyCode);
		return true;
	}


}

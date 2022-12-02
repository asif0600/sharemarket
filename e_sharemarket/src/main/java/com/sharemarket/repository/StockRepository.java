package com.sharemarket.repository;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sharemarket.model.Stock;

@Repository
@Transactional
public interface StockRepository extends JpaRepository<Stock, Integer> {


	@Query("select s from Stock  s where s.companyCode_fk= :companyCode")
	public Set<Stock> getStockList(int companyCode);

	@Modifying
	@Query(value ="delete from Stock where companyCode_fk= :companyCode")
	public void deleteCompanyData(int companyCode);

}

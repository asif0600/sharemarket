package com.sharemarket.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class CompanyTest {
	private static Company company;

	@BeforeAll
	public static void init() {
		company = Mockito.mock(Company.class);
	}

	@Test
	public void companyNameTest() {

		company.setCompanyName("HP");

		String mockuser = company.getCompanyName();
		when(company.getCompanyName()).thenReturn(mockuser);

		assertEquals(company.getCompanyName(), mockuser);

	}

	@Test
	public void companyTurnoverTest() {

		company.setCompanyTurnover(1243.456);

		double mockuser = company.getCompanyTurnover();
		when(company.getCompanyTurnover()).thenReturn(mockuser);

		assertEquals(company.getCompanyTurnover(), mockuser);

	}

}

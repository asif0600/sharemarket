package com.stockmarket.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.CONFLICT, reason="Company ID already present in Database")
public class CompanyIdAlreadyPresentException extends Exception{

}

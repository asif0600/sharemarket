package com.apicomsumer.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("apiconsumer")
public class APIController {
	
	@GetMapping("/getCompanies")
    public ResponseEntity<?> consumeGetCompany() throws Exception
    {
        RestTemplate restTemplate = new RestTemplate();
        
        String baseUrl = "http://localhost:8081/api/v1.0/market/company/getall";
        
        ResponseEntity<String> response = null;
        
        try
        {
            response = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), String.class);
            return new ResponseEntity<>(response, HttpStatus.OK);
            
            //response = restTemplate.postForEntity(baseUrl, HttpMethod.POST, String.class);
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<String>("Response object is null", HttpStatus.NO_CONTENT);
        
    }
    
    private static HttpEntity<?> getHeaders() throws Exception
    {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        //headers.set("Authorization", jwtToken);
        //headers.set("Access-Controll-Allow-Origin", "*");
        return new HttpEntity<>(headers);
        
    }
	
	
	
	
	
	

}

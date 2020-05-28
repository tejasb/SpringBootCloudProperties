package com.example.demo.restclient;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class TestRestClient {
	private RestTemplate restTemplate;
	
	 public TestRestClient(@Qualifier("stgRestTemplate") RestTemplate restTemplate) {
	        this.restTemplate = restTemplate;
	 }
	
	String formattedURL = "http://localhost:9085/actuator/refresh";
	
    public Object[] refreshConfig() throws JsonProcessingException {
    	
    	HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        headers.add(HttpHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON_VALUE);
    	
    	HttpEntity<String> entity = new HttpEntity<String>(headers);
    	
//    	restTemplate.exchange(formattedURL, HttpMethod.POST, entity, List.class);
    	ResponseEntity<List> response = restTemplate.exchange(formattedURL, HttpMethod.POST, entity, List.class);
		
		List<String> responseList = new ArrayList<String>();
    	
		if (response != null) {
			responseList = response.getBody();
			//String subStr = objectMapper.writeValueAsString(respMap);
			//log.info("Docusign Template Documents API response: {}", subStr);
		}
		else {
			//log.error("Error while calling Docusign Template Documents API");
		}
		return responseList.toArray();    	
    }

}

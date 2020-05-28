package com.example.demo.component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
@ConfigurationProperties(prefix="test")
public class Foo {

    @Value("${stg.client.1}")
    private String value;
    
    @Value("#{${users}}")
    private Map<String,String> users;
    
    private List<String> client = new ArrayList<String>();

    public List<String> getClient() {
        return this.client;
    }
    
    public String giveValue() {
    	//System.out.println("Hello...size of map is: " +  clientInfoMap.size());
    	List<String> clients = getClient();
    	return new String("No of clients:" + clients.size());
    }
}
package com.example.AccountService.AccountService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class AccountController {

	
	 @Autowired
	    private DiscoveryClient discoveryClient;

	    @RequestMapping("/service-instances/{applicationName}")
	    public List<ServiceInstance> serviceInstancesByApplicationName(
	            @PathVariable String applicationName) {
	        return this.discoveryClient.getInstances(applicationName);
	    }

	
	
	@RequestMapping (value="/account/{name}", produces = MediaType.APPLICATION_JSON_VALUE,  method = RequestMethod.GET)
	public String sayHellow(@PathVariable("name") String name ) {
		
		return " Account details for customer ,"+name;
	}
	
}
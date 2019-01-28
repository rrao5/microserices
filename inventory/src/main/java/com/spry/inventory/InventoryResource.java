package com.spry.inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController
public class InventoryResource {

	@Autowired
	private RestTemplate restTemplate;
	
	private EurekaClient discoveryClient;
	
	private String pricingUrl() {
		InstanceInfo instance = discoveryClient.getNextServerFromEureka("pricing-service", false);
		return instance.getHomePageUrl();
	}
	

	
	@GetMapping(value = "/inventory/{name}", produces = "application/json")
	public @ResponseBody CarInventory getInventoryTotal(@PathVariable String name) {
		float price = getPricing(name);
		
		switch (name) {
		case "camry":
			return new CarInventory("camry", 10 , 10*price);
		case "carolla":
			return new CarInventory("carolla", 5, 5* price);
		case "rav4":
			return new CarInventory("rav4", 7, 7* price);
		case "highlander":
			return new CarInventory("highlander",8, 8*price);

		}
		return null;

	}
	
	private float getPricing(String name) {
		float price = restTemplate.exchange("http://pricing-service/price/{name}",HttpMethod.GET,null, new ParameterizedTypeReference<Float>() {}, name).getBody();
		return price;
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
		
	
}

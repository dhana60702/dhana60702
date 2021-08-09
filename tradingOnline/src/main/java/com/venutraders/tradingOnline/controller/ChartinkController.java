package com.venutraders.tradingOnline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.venutraders.tradingOnline.dto.ChartinkDTO;
import com.venutraders.tradingOnline.service.ChartinkServiceImpl;

@RestController
public class ChartinkController {
	
	
	  @Autowired 
	  private ChartinkServiceImpl chartinkServiceImpl;
	
	  @CrossOrigin
	@PostMapping(path = "/report", 
	        consumes = MediaType.APPLICATION_JSON_VALUE, 
	        produces = MediaType.APPLICATION_JSON_VALUE)
	public void getDataFromChartinkWebHook(@RequestBody ChartinkDTO chartinkDTO){
		
		System.out.println(chartinkDTO);
		chartinkServiceImpl.sendMessageToTelegram(chartinkDTO);
		
	}
	
	@CrossOrigin
	@GetMapping(path = "/hello")
	public String getHello(){
		
		return "hello Hi";
	}

}

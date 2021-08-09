package com.venutraders.tradingOnline.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.venutraders.tradingOnline.dto.ChartinkDTO;

@Service
public class ChartinkServiceImpl {
	
	@Autowired
	private RestTemplate restTemplate;
	
	public void sendMessageToTelegram(ChartinkDTO chartinkDTO){
		
		try {
		
			String messageString = requestFormat(chartinkDTO);
		String telegramResponse = 
			      restTemplate.postForObject("https://api.telegram.org/bot1933733763:AAGr8jpBlAnquH8VW6YWYOXGpK_t_4eixhE/sendMessage?chat_id=-514028903&text="+messageString, null, String.class);
	
		System.out.println(telegramResponse);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Format the provided request data to pass it to telegram
	 */
	private String requestFormat(ChartinkDTO chartinkDTO) {
		Map<String,String> requestMap = new HashMap<String, String>();
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Scan Name : ").append(chartinkDTO.getScanName()).append("\n");;
		
		for(int i =0 ; i<chartinkDTO.getStocks().size(); i++) {
			stringBuilder.append(i+1)
			.append("\t")
			.append(chartinkDTO.getStocks().get(i))
			.append("\t")
			.append(chartinkDTO.getTriggerPrices().get(i))
			.append("\t")
			.append(new Date())
			.append("\n");
		}
		return stringBuilder.toString();
		
	}
}

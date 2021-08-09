package com.venutraders.tradingOnline.dto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ChartinkDTO {
	
	private List<String> stocks;
	@JsonProperty("trigger_prices")
	private List<String> triggerPrices;
	@JsonProperty("triggered_at")
	private String triggeredAt;
	@JsonProperty("scan_name")
	private String scanName;
	@JsonProperty("scan_url")
	private String scanUrl;
	@JsonProperty("alert_name")
	private String alertName;
	@JsonProperty("webhook_url")
	private String webhookUrl;
	
	public List<String> getStocks() {
		return stocks;
	}
	public void setStocks(String stocksWithDelimiter) {
		this.stocks = Stream.of(stocksWithDelimiter.split(","))
				  .map(String::trim)
				  .collect(Collectors.toList());
	}
	public List<String> getTriggerPrices() {
		return triggerPrices;
	}
	public void setTriggerPrices(String triggerPricesWithDelimiter) {
		this.triggerPrices = Stream.of(triggerPricesWithDelimiter.split(","))
				  .map(String::trim)
				  .collect(Collectors.toList());
	}
	public String getTriggeredAt() {
		return triggeredAt;
	}
	public void setTriggeredAt(String triggeredAt) {
		this.triggeredAt = triggeredAt;
	}
	public String getScanName() {
		return scanName;
	}
	public void setScanName(String scanName) {
		this.scanName = scanName;
	}
	public String getScanUrl() {
		return scanUrl;
	}
	public void setScanUrl(String scanUrl) {
		this.scanUrl = scanUrl;
	}
	public String getAlertName() {
		return alertName;
	}
	public void setAlertName(String alertName) {
		this.alertName = alertName;
	}
	public String getWebhookUrl() {
		return webhookUrl;
	}
	public void setWebhookUrl(String webhookUrl) {
		this.webhookUrl = webhookUrl;
	}
	@Override
	public String toString() {
		return "ChartinkDTO [stocks=" + stocks + ", triggerPrices=" + triggerPrices + ", triggeredAt=" + triggeredAt
				+ ", scanName=" + scanName + ", scanUrl=" + scanUrl + ", alertName=" + alertName + ", webhookUrl="
				+ webhookUrl + "]";
	}


}

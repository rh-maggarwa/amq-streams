package org.redhat.kafka.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class KafkaProducerResponse {

	@JsonProperty("correlationId")
	private long correlationId;
	
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("message")
	private String message;
	
	
	public long getCorrelationId() {
		return correlationId;
	}
	public void setCorrelationId(long correlationId) {
		this.correlationId = correlationId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "correlationId="+correlationId+";status="+status+";message="+message;
	}
	
}

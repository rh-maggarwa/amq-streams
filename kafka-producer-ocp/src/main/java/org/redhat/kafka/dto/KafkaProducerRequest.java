package org.redhat.kafka.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class KafkaProducerRequest {

	@JsonProperty("bootstrapServers")
	private String bootstrapServers;
	
	@JsonProperty("batchSize")
	private int batchSize;
	
	@JsonProperty("lingerMs")
	private int lingerMs;
	
	@JsonProperty("bufferMemory")
	private int bufferMemory;
	
	@JsonProperty("msgCount")
	private int msgCount;
	

	public String getBootstrapServers() {
		return bootstrapServers;
	}



	public void setBootstrapServers(String bootstrapServers) {
		this.bootstrapServers = bootstrapServers;
	}



	public int getBatchSize() {
		return batchSize;
	}



	public void setBatchSize(int batchSize) {
		this.batchSize = batchSize;
	}



	public int getLingerMs() {
		return lingerMs;
	}



	public void setLingerMs(int lingerMs) {
		this.lingerMs = lingerMs;
	}



	public int getBufferMemory() {
		return bufferMemory;
	}



	public void setBufferMemory(int bufferMemory) {
		this.bufferMemory = bufferMemory;
	}



	public int getMsgCount() {
		return msgCount;
	}



	public void setMsgCount(int msgCount) {
		this.msgCount = msgCount;
	}



	@Override
	public String toString() {
		return "bootstrapServers="+bootstrapServers+";batchSize="+batchSize+";lingerMs="+lingerMs+";bufferMemory="+bufferMemory+";msgCount="+msgCount;
	}
	
}

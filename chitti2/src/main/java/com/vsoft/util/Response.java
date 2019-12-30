package com.vsoft.util;

import org.springframework.stereotype.Component;

@Component
public class Response {
	
	private Integer statusCode;
	private String reason;
	private Object data;
	
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "Response [statusCode=" + statusCode + ", reason=" + reason + ", data=" + data + "]";
	}
	
	

}

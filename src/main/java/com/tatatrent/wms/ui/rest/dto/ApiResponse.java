package com.tatatrent.wms.ui.rest.dto;

import java.util.Objects;

import com.tatatrent.wms.util.AppConstants;

public class ApiResponse {
	
	private Integer code;
	private boolean success;
	private Object message;
	
	
	public ApiResponse() {
		this.code = 201;
		this.success = true;
		this.message = AppConstants.SUCCESS_RESPONSE_MESSAGE;
		
	}


	public ApiResponse(Integer code, boolean success, Object message) {
		this.code = code;
		this.success = success;
		this.message = message;
	}


	public Integer getCode() {
		return code;
	}


	public void setCode(Integer code) {
		this.code = code;
	}


	public boolean isSuccess() {
		return success;
	}


	public void setSuccess(boolean success) {
		this.success = success;
	}


	public Object getMessage() {
		return message;
	}


	public void setMessage(Object message) {
		this.message = message;
	}


	@Override
	public int hashCode() {
		return Objects.hash(code, message, success);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ApiResponse other = (ApiResponse) obj;
		return Objects.equals(code, other.code) && Objects.equals(message, other.message) && success == other.success;
	}


	@Override
	public String toString() {
		return "ApiResponse [code=" + code + ", success=" + success + ", message=" + message + "]";
	}	

}

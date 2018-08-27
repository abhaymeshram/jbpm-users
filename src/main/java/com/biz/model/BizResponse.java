package com.biz.model;

import java.io.Serializable;

public class BizResponse implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String status;
	private Object data;
	private String error;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public BizResponse(String status, Object data, String error) {
		super();
		this.status = status;
		this.data = data;
		this.error = error;
	}

	public BizResponse() {
		super();
	}

	@Override
	public String toString() {
		return "BizResponse [status=" + status + ", data=" + data + ", error=" + error + "]";
	}

}

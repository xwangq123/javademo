package com.mr.wang.utils;

public class Response {
	enum Status {
		SUCCESS, FAILURE
	}
	
	private String code;
	private Status status;
	private String message;
	private Object payload;
	private boolean capital = false;
	private long total;

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getPayload() {
		return payload;
	}

	public void setPayload(Object payload) {
		this.payload = payload;
	}

	public static Response ok() {
		return ok(null, null);
	}

	public static Response ok(String message) {
		return ok(message, null);
	}

	public static Response ok(Object payload) {
		return ok(null, payload);
	}

	public static Response ok(Object payload, long total) {
		return ok(null, payload, total);
	}

	public static Response ok(String message, Object payload) {
		return ok(message, payload, 0);
	}

	public static Response ok(String message, Object payload, long total) {
		Response response = new Response();
		response.setStatus(Status.SUCCESS);
		response.setPayload(payload);
		response.setMessage(message);
		response.setTotal(total);
		return response;
	}

	public static Response fail(String message) {
		return fail(null, message);
	}

	public static Response fail(String code, String message) {
		Response response = new Response();
		response.setStatus(Status.FAILURE);
		response.setMessage(message);
		response.setCode(code);
		return response;
	}

	public Response capitalize() {
		capital = true;
		return this;
	}

	public boolean capital() {
		return capital;
	}

}

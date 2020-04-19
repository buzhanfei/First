package com.example.demo.utils;

public class ResultJson {
	private int status;
	private String msg;
	private Object data;
	
	public ResultJson() {}
	public ResultJson(Object obj) {
		this.status=200;
		this.msg="OK";
		this.data=obj;
	}
	public ResultJson(int status,String msg,Object obj) {
		this.status=status;
		this.msg=msg;
		this.data=obj;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	
}

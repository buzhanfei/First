package com.example.demo.aspect;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.utils.ResultJson;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(RuntimeException.class)
	public ResultJson getException(RuntimeException e) {
		ResultJson rj = new ResultJson();
		rj.setStatus(500);
		rj.setMsg("业务繁忙");
		rj.setData("");
		return rj;		
	}
}

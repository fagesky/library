package org.fogsky.library.Controller;

import org.fogsky.library.service.BadParamException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class AppExceptionHandler {
	
	/*
	 * 异常处理方法的返回类型可以为ResponseBody,
	 * 但不能 添加@ResponseStatus注解， 否则方法工作
	 */
	
	@ExceptionHandler(DuplicateKeyException.class)
	@ResponseBody
	public String  duplicateBookHandler() {
		System.out.println("重复");
		return "已注册数据库，不要重复录入";
	}
	@ExceptionHandler(BadParamException.class)
	@ResponseBody
	public String BadParamExceptionHandler(Exception e) {
		return "参数非法:"+e.getMessage();
	}
	@ExceptionHandler(NullPointerException.class)
	@ResponseBody
	public String NullPointerHandler(Exception e) {
		e.printStackTrace();
		return "服务器内部错误";

	}
}

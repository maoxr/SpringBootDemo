/**
 * /**   
 * Copyright © 2018 maowei. All rights reserved.
 *
 * @Package: com.momo.springboot.exception 
 * @author: ibadboy   
 * @date: 2018年6月27日 上午11:08:53 
 */
package com.momo.springboot.exception;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.momo.springboot.dto.CustomErrorAttribute;
import com.momo.springboot.dto.ErrorInfo;

/**
 * @ClassName: com.momo.springboot.exception.GlobalExceptionHandler
 * @Description: 创建全局异常处理类：通过使用@ControllerAdvice定义统一的异常处理类，
 *               而不是在每个Controller中逐个定义。@ExceptionHandler用来定义函数针对的异常类型，
 *               最后将Exception对象和请求URL映射到error.html中.
 *               实现error.html页面展示：在templates目录下创建error.html，
 *               将请求的URL和Exception对象的message输出。
 * @author ibadboy
 * @date: 2018年6月27日 上午11:08:53
 */
@ControllerAdvice
public class GlobalExceptionHandlerin extends ResponseEntityExceptionHandler {
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
	 //这个注解是指当controller中抛出这个指定的异常类的时候，都会转到这个方法中来处理异常
	@ExceptionHandler(value = Exception.class)
	public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("error");
		System.out.println("Url---->  " + req.getRequestURI());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("errorMsg", "自定义的：错误信息");
		map.put("errorSystem", "errorSystem");
		req.setAttribute(CustomErrorAttribute.CUSTOM_ERROR_MAP_NAME, map);
		return mav;
	}

	/**
	 * 
	 * @Description:创建统一的JSON返回对象，code：消息类型，message：消息内容，url：请求的url，data：请求返回的数据
	 * @Author:ibadboy
	 * @Date: 2018年6月27日上午11:12:50
	 * @param req
	 * @param e
	 * @return
	 * @throws Exception
	 */
	@ExceptionHandler(MyException.class)
	@ResponseBody
	ResponseEntity<?> handleControllerJSONException(HttpServletRequest request, Throwable ex) {
		HttpStatus status = getStatus(request);
		ErrorInfo<String> r = new ErrorInfo<>();
		r.setMessage(ex.getMessage());
		r.setCode(status.value());
		r.setData(dateFormat.format(new Date()));
		r.setUrl(request.getRequestURL().toString());
		return new ResponseEntity<>(r, status);
	}

	private HttpStatus getStatus(HttpServletRequest request) {
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		if (statusCode == null) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return HttpStatus.valueOf(statusCode);
	}
}

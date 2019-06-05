package com.momo.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.momo.springboot.common.PropertiesBean;
import com.momo.springboot.exception.MyException;

/**
 * @ClassName: com.momo.springboot.controller.Example
 * @Description: TODO 
 * @author ibadboy
 * @date: 2018年6月27日 上午11:15:35
 */
@Controller
public class Example {

	@Autowired
	PropertiesBean properties;

	@RequestMapping("/hello")
	String home() {
		return "Hello World!" + properties.getName();
	}

	@RequestMapping("/")
	public String index(ModelMap map) {
		map.addAttribute("host", "http://www.momo.com");
		return "index";
	}

	@RequestMapping("/exception")
	public String exception() throws Exception {
		throw new Exception("发生错误");
	}

	/**
	 * @Description:TODO
	 * @Author:ibadboy
	 * @Date: 2018年6月27日上午11:15:28	
	 * @return
	 * @throws MyException
	 */
	@RequestMapping("/json")
	public String exceptionByJson() throws MyException {
		throw new MyException("发生错误2");
	}
}

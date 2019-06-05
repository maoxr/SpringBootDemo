/**
 * /**   
 * Copyright © 2018 maowei. All rights reserved.
 *
 * @Package: com.momo.springboot.dto 
 * @author: ibadboy   
 * @date: 2018年7月2日 下午1:55:36 
 */
package com.momo.springboot.dto;

import java.util.Map;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

/**
 * @ClassName: com.momo.springboot.dto.CustomErrorAttribute
 * @Description: 自定义错误信息属性
 * @author ibadboy
 * @date: 2018年7月2日 下午1:55:36
 */
@Component 
public class CustomErrorAttribute extends DefaultErrorAttributes {
	public static final String CUSTOM_ERROR_MAP_NAME = "customErrorMap";

	@Override
	public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {

		Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);

		// 设置传递自己定义的错误信息
		map.put(CUSTOM_ERROR_MAP_NAME, webRequest.getAttribute(CUSTOM_ERROR_MAP_NAME, webRequest.SCOPE_REQUEST));
		return map;
	}
}

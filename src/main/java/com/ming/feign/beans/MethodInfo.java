package com.ming.feign.beans;


import lombok.Data;
import org.springframework.http.HttpMethod;

import java.util.Map;


/**
 * 方法调用信息类
 */
@Data
public class MethodInfo {

	/**
	 * 请求url
	 */
	private String url;

	/**
	 * 请求方法
	 */
	private HttpMethod method;

	/**
	 * 请求参数(url)
	 */
	private Map<String, Object> params;

	/**
	 * 请求body
	 */
	private Object body;
	
	/**
	 * 请求body的类型
	 */
	private Class<?> bodyElementType;
	
	/**
	 * 返回是flux还是mono
	 */
	private boolean returnFlux;
	
	/**
	 * 返回对象的类型
	 */
	private Class<?> returnElementType;

}

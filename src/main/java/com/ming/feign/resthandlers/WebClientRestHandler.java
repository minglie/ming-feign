package com.ming.feign.resthandlers;

import com.alibaba.fastjson.JSON;

import com.ming.feign.beans.MethodInfo;
import com.ming.feign.beans.ServerInfo;
import com.ming.feign.interfaces.RestHandler;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

public class WebClientRestHandler implements RestHandler {
    private String url;

    /**
     * 初始化webclient
     */
    @Override
    public void init(ServerInfo serverInfo) {
        this.url = serverInfo.getUrl();
    }

    RestTemplate restTemplate = new RestTemplate();

    /**
     * 处理rest请求
     */
    @Override
    public Object invokeRest(MethodInfo methodInfo) {
        String url = this.url + methodInfo.getUrl();
        if (methodInfo.getMethod().matches("GET")) {
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
            methodInfo.getParams().entrySet().stream().forEach(o -> builder.queryParam(o.getKey(), o.getValue()));
            url = builder.build().encode().toString();
            if (methodInfo.isReturnFlux()) {
                String forObject = restTemplate.getForObject(url, String.class, methodInfo.getParams());
                List<?> objects = JSON.parseArray(forObject, methodInfo.getReturnElementType());
                return objects;
            } else {
                Object forObject = restTemplate.getForObject(url, methodInfo.getReturnElementType(), String.class, methodInfo.getParams());
                return forObject;
            }
        } else {
            if (methodInfo.isReturnFlux()) {
                String forObject = restTemplate.postForObject(url, methodInfo.getBody(), String.class);
                List<?> objects = JSON.parseArray(forObject, methodInfo.getReturnElementType());
                return objects;
            } else {
                Object forObject = restTemplate.postForObject(url, methodInfo.getBody(), methodInfo.getReturnElementType());
                return forObject;
            }
        }
    }
}
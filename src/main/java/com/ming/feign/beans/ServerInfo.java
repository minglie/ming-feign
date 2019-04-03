package com.ming.feign.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 服务器信息类
 *
 */
@Data
public class ServerInfo {

	/**
	 * 服务器url
	 */
	private String url;

}

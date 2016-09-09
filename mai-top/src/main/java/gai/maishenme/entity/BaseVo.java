/*******************************************************************************
 * Copyright (c) 2015 by dennis Corporation all right reserved.
 * 2015年5月11日 
 * 
 *******************************************************************************/ 
package gai.maishenme.entity;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonSetter;

import java.io.Serializable;
 
/**
 * <pre>
 *
 */
public class BaseVo implements Serializable{ 
	private static final long serialVersionUID = -1629011640663014271L;
	// 响应时间
//	private String time;
	// 是否成功 true false
	private String success;
	// 错误编码  
	private String code;
	// 错误信息
	private String info;
	
	private String reLoginStat;//登录状态

//	@JsonProperty(value = "time")
//	public String getTime() {
//		return time;
//	}
//
//	@JsonSetter(value = "time")
//	public void setTime(String time) {
//		this.time = time;
//	}
   
	  
	@JsonProperty(value = "reLoginStat")
	public String getCode() {
		return code;
	}
	
	@JsonSetter(value = "reLoginStat")
	public void setCode(String code) {
		this.code = code;
	}

	@JsonProperty(value = "message")
	public String getInfo() {
		return info;
	}
 	@JsonSetter(value = "message")
	public void setInfo(String info) {
		this.info = info;
	}
	
	@JsonProperty(value = "code") 

	public String getSuccess() {
		return success;
	}
	@JsonSetter(value = "code") 

	public void setSuccess(String success) {
		this.success = success;
	}
// 	@JsonProperty(value = "reLoginStat")  
// 	public String getReLoginStat() {
//		return reLoginStat;
//	}
//	@JsonSetter(value = "reLoginStat") 
// 	public void setReLoginStat(String reLoginStat) {
//		this.reLoginStat = reLoginStat;
//	}
 
  }

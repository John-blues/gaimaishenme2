/*******************************************************************************
 * Copyright (c) 2015 by dennis Corporation all right reserved.
 * 2015年5月8日 
 * 
 *******************************************************************************/ 
package gai.maishenme.config;

import android.content.Context;
import android.os.Handler;

/**
 * <pre>
 * 业务名:
 * 功能说明: 
 * 编写日期:	2015年5月8日
 * 作者:	zgz
 * 
 * 历史记录
 * 1、修改日期：
 *    修改人：
 *    修改内容：
 * </pre>
 */
public class Command {
	/**
	 * 命令标识
	 */
	public int commandID;
	
	/**
	 * 句柄
	 */
	public Handler handler;
	
	/**
	 * 是否成功
	 */
	public boolean isSuccess;
	
	/**
	 * 请求参数
	 */
	public Object param = null;
	
	/**
	 * 返回数据
	 */
	public Object resData = null;
	
	/**
	 * 加载显示内容
	 */
	public String waitingMsg = null;
	
	/**
	 * 是否显示等待框
	 */
	public boolean showDialog = true;
	
	/**
	 * 是否会话超时
	 */
	public boolean outSession = false;
	
	/**
	 * 在请求结束后，是否隐藏等待框
	 */
	public boolean hidenDialog = true;
	
	/**
	 * 上下文
	 */
	public Context context;
	
	/**
	 * 请求状态码
	 */
	public String stateCode;
	
	/**
	 * 请求方法名
	 */
	public String method;
	
	/**
	 * 是否能够取消请求
	 */
	public boolean canCancelRequest = true;

	public Command(int commandID, Handler handler) {
		super();
		this.commandID = commandID;
		this.handler = handler;
	}
	
}

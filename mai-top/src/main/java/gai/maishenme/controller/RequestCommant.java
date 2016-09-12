/*******************************************************************************
 * Copyright (c) 2015 by dennis Corporation all right reserved.
 * 2015年5月8日 
 * 
 *******************************************************************************/ 
package gai.maishenme.controller;

import android.content.Context;

import gai.maishenme.config.Command;
import gai.maishenme.config.Constants;

import java.util.HashMap;
/**
 * <pre>
 * 业务名:
 * 功能说明: 
 * 需求命令：网络
 */
public class RequestCommant {

	public void requestQueryShopList(BaseHandler handler,Context context,HashMap<String, String> paramHashMap){
		Command command = new Command(Constants.SHOPLISTTEST, handler); 
		command.param = paramHashMap;
		command.method = "";  
		command.waitingMsg = "加载中，请稍候...";
		command.showDialog = true;
		command.context = context;
		PostAsynTask mPostAsynTask = new PostAsynTask(context, command);
		mPostAsynTask.execute();    	     	 
	}
}

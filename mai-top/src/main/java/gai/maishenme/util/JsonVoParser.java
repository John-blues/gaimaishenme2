/*******************************************************************************
 * Copyright (c) 2015 by dennis Corporation all right reserved.
 * 2015��5��11�� 
 * 
 *******************************************************************************/ 
package gai.maishenme.util;

import gai.maishenme.entity.BaseVo;
import gai.maishenme.entity.ShopBriefDataVo;



public class JsonVoParser {
	private static JsonVoParser _jsonVoParser;

	public static JsonVoParser getInstance() {
		if (null == _jsonVoParser) {
			_jsonVoParser = new JsonVoParser();
		}
		return _jsonVoParser;
	} 
	private static JsonBinder jsonBinder = JsonBinder.buildNonNullBinder();

	public BaseVo getBasevo(String jsonvo){
		return jsonBinder.fromJson(jsonvo, BaseVo.class);
	}

	public ShopBriefDataVo getLfTestBuyVo(String json){
		return jsonBinder.fromJson(json, ShopBriefDataVo.class);
		
	}
}
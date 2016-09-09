/*******************************************************************************
 * Copyright (c) 2015 by dennis Corporation all right reserved.
 * 2015��5��8�� 
 * 
 *******************************************************************************/ 
package gai.maishenme.util;

import android.util.Log;

 
 
/**
 * <pre>
 * ҵ����:
 * ����˵��: 
 * ��д����:	2015��5��8��
 * ����:	zgz
 * 
 * ��ʷ��¼
 * 1���޸����ڣ�
 *    �޸��ˣ�
 *    �޸����ݣ�
 * </pre>
 */
public class Logge {
	public static Logge sutUtileLog;
 public final int DEBUG=0;
 public final int ERROR=1;
 public final int NOTHING =2;
 public final int INFO=3;
 //����ʱ  ������Ϊ��Сֵ����-1����ӡ��Ӱ���ڴ�
 private int leaver=3;
 private String tag="DekuTree";
   public static Logge getinctance(){
	   if(sutUtileLog==null){
		   synchronized (Logge.class) {
			if(sutUtileLog==null){
				   sutUtileLog =new Logge(); 
 			}
		}
	   }
 	return sutUtileLog;
    }
    public void debug(String msg){
    	if(leaver>=DEBUG){
    		Log.d(tag+"---DEBUG", msg);
      	}
    }
    public void error(String msg){
    	if(leaver>=ERROR){
    		Log.e(tag+"---ERROR", msg);
    	}
    }
    public void infor(String msg){
    	if(leaver>=INFO){
    		Log.i(tag+"---INFO", msg);
    	}
    }}

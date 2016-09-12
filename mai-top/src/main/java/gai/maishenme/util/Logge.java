package gai.maishenme.util;

import android.util.Log;

public class Logge {
	public static Logge sutUtileLog;
 public final int DEBUG=0;
 public final int ERROR=1;
 public final int NOTHING =2;
 public final int INFO=3;
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

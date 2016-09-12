package gai.maishenme.util;

import java.io.IOException;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
public class SerialUtils {
	static long startTime = 0l;
	static long endTime = 0l;


	public void saveObject(String strObject,Context context) {
		SharedPreferences sp = context.getSharedPreferences("person", 0);
		Editor edit = sp.edit();
		edit.putString("person", strObject);
		edit.commit();
	}
 	public String getObject(Context context) {
		SharedPreferences sp = context.getSharedPreferences("person", 0);
		return sp.getString("person", null);
	}
	
}

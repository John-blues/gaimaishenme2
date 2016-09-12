
package gai.maishenme.application;



import java.io.File;

import gai.maishenme.config.Constants;
import gai.maishenme.service.MyService;

//import com.sumavision.sdk.SumaPaySDK;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;

public class ValueShopApplication extends Application{
	public static Context appContext;

	public final String PREF_USERNAME = "username";

	public static String  userName;

	public static String password;

	private static ValueShopApplication instance;

	public static ValueShopApplication isshopapplication;

	private static final String PREF_PWD = "pwd";

	public static boolean isShowingDialog = false;
	private boolean sdCardExist;
	private String sessionId;

	private String uuid;

	public static boolean timeOutOrLoginCrowdOut = false;

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		isshopapplication=this;
		instance=this;
		DisplayMetrics metric = getApplicationContext().getResources().getDisplayMetrics();

		Constants.SCREEN_WIDTH = metric.widthPixels;

		Constants.SCREEN_HEIGHT = metric.heightPixels;
		 startService(new Intent(this, MyService.class));

		PackageManager mPckManager = this.getPackageManager();

		try {
			PackageInfo info = mPckManager.getPackageInfo(
					this.getPackageName(), 0);
			Constants.VERSIONCODE = info.versionCode;
			Constants.VERSIONNAME = info.versionName;

		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}

		Constants.SYSTEM_VERSION = android.os.Build.VERSION.SDK_INT;
		getSIMInfo();
		
	}
	public static ValueShopApplication getInstance() {
		return instance;
	}

	public File getImgDir() {

		return Environment.getDataDirectory();
	}

	private void getSIMInfo() {
		TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
		String operator = tm.getSimOperator();

		if (null != operator) {
			if (operator.equals("46000") || operator.equals("46002")) {
				Constants.OPERATOR = 0;

			} else if (operator.equals("46001")) {
				Constants.OPERATOR = 1;
			} else if (operator.equals("46003")) {
				Constants.OPERATOR = 2;
			}
		}
	}





	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	



	public boolean modifyPassWSuccess = false;

	public String getUserName() {
		if (userName == null) {
			SharedPreferences preferences = PreferenceManager
					.getDefaultSharedPreferences(appContext);
			userName = preferences.getString(PREF_USERNAME, null);
		}
		return userName;
	}	
	public String getPassword() {
		if (password == null) {
			SharedPreferences preferences = PreferenceManager
					.getDefaultSharedPreferences(appContext);
			password = preferences.getString(PREF_PWD, null);
		}
		return password;
	}

	public static void setTimeOutOrLoginCrowdOut(boolean timeOutOrLoginCrowdOut) {
		ValueShopApplication.timeOutOrLoginCrowdOut = timeOutOrLoginCrowdOut;
	}

	public void setUserName(String username) {
		if (username != null) {
			SharedPreferences preferences = PreferenceManager
					.getDefaultSharedPreferences(appContext);
			SharedPreferences.Editor editor = preferences.edit();
			if (editor.putString(PREF_USERNAME, username).commit()) {
				userName = username;
			}
		}
	}
	public void setPassword(String pwd) {
		SharedPreferences preferences = PreferenceManager
				.getDefaultSharedPreferences(appContext);
		SharedPreferences.Editor editor = preferences.edit();
		if (editor.putString(PREF_PWD, pwd).commit()) {
			password = pwd;
		}
	}
}

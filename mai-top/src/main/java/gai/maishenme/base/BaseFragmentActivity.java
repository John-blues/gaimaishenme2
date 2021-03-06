package gai.maishenme.base;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import gai.maishenme.R;
import gai.maishenme.application.ValueShopApplication;
import gai.maishenme.config.Constants;
import gai.maishenme.util.ActivityTaskManager;
import gai.maishenme.util.CustomTitleBar;
import gai.maishenme.util.SerialUtils;
import gai.maishenme.util.ShowErrorDialogUtil;

public class BaseFragmentActivity extends FragmentActivity implements
		OnClickListener {

	protected FragmentManager mFragmentManager;
	protected FragmentTransaction mFragmentTransaction;

	protected ValueShopApplication mApplication;
	protected CustomTitleBar customTitleBar;
	protected SharedPreferences userInfo;
	private SerialUtils serialutols;
	public static boolean insideTopUpWebView = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		mFragmentManager = getSupportFragmentManager();
		mApplication = (ValueShopApplication) getApplication();
		userInfo = getSharedPreferences(Constants.INIT_USER_INFO,
				Context.MODE_PRIVATE);
		serialutols = new SerialUtils();
		if (null != savedInstanceState) {
			mApplication = (ValueShopApplication) getApplication();

		}
		ActivityTaskManager.getInstance().putActivity(
				getClass().getSimpleName(), this);

	}


	public void setContentViewWithActionBar(int layoutId, String str) {

		LayoutInflater inflater = getLayoutInflater();
		// viewGroup
		ViewGroup contentV = (ViewGroup) inflater.inflate(
				R.layout.activity_base, null);
		inflater.inflate(layoutId, contentV);
		setContentView(contentV);
		// customTitleBar
		customTitleBar = (CustomTitleBar) findViewById(R.id.title_bar);
		customTitleBar.initViewBar(contentV);
		customTitleBar.setMiddleBar(str);
		customTitleBar.getLeftBar().setOnClickListener(this);
	}

	protected Button.OnClickListener backListener = new Button.OnClickListener() {
		@Override
		public void onClick(View view) {
			// TODO Auto-generated method stub
			finish();
		}

	};

	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);

	
		outState.putBoolean("timeOutOrLoginCrowdOut",
				ValueShopApplication.timeOutOrLoginCrowdOut);
		if (null != mApplication.getSessionId()) {
			outState.putString("sessionId", mApplication.getSessionId());
		}
		
	};

	protected void showError(int errResource) {
		ShowErrorDialogUtil.showErrorDialog(this, getString(errResource));
	}

	protected void showError(String errStr) {
		ShowErrorDialogUtil.showErrorDialog(this, errStr);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v.getId() == R.id.left_bar) {
			finish();
		}
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		ActivityTaskManager.getInstance().removeActivity(
				getClass().getSimpleName());

	}

	public void startActivity(Class<? extends Activity> cls) {
		Intent intent = new Intent(this, cls);
		startActivity(intent);

	}
}

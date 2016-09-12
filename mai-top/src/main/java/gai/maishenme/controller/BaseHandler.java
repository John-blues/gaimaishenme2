package gai.maishenme.controller;

import java.lang.ref.WeakReference;

import gai.maishenme.application.ValueShopApplication;
import gai.maishenme.config.Command;
import gai.maishenme.config.Constants;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.widget.Toast;
//myBasehandler
@SuppressLint("NewApi")
public class BaseHandler extends Handler{

		public static final int SESSION_TIMEOUT_RESULT_CODE = 800000;
		public static final int LOGIN_CROWD_OUT_RESULT_CODE = 800001;
		
		//是否被拦截
		protected boolean isIntercepted = false;
	  
		// 超时
		public static final String SESSION_TIMEOUT_CODE = "800000";
		protected static final String LOGIN_CROWD_OUT_CODE = "2";

		protected Command command;
		protected WeakReference<Activity> mActivity;
		protected WeakReference<Fragment> mFragment;
		protected Context context;

		public BaseHandler(Activity activity) {
			mActivity = new WeakReference<Activity>(activity);
			context = activity;
		}

		public BaseHandler(Fragment fragment) {
			mFragment = new WeakReference<Fragment>(fragment);
			context = fragment.getActivity();
		}
	     
		@Override
		public void handleMessage(Message msg) {
			command = (Command) msg.obj;
			if (Constants.CANCEL_POST_IDENTIFIER == msg.what) {
				// 取消请求，则返回上个界面
				if (null != mActivity) {
					mActivity.get().finish();
				} else if (null != mFragment) {
					int count = mFragment.get().getFragmentManager()
							.getBackStackEntryCount();   
					if (count > 1){
						mFragment.get().getFragmentManager().popBackStack();
					}
				}

				return;
			}
			
			if (null != mActivity) {
				if (null == mActivity.get() || null == context) {
					isIntercepted = true;
					return;
				}
			}

			if (null != mFragment) {
				if (null == mFragment.get() || null == context) {
					isIntercepted = true;
					return;
				}
			}

			if ((null != mActivity) && (null != mActivity.get())
					&& mActivity.get().isFinishing()) {
				isIntercepted = true;
				return;
			}
			
			if (null != command) {
				if (!command.isSuccess) {
					if (null != command.stateCode
							&& (command.stateCode.equals(SESSION_TIMEOUT_CODE) || command.stateCode
									.equals(LOGIN_CROWD_OUT_CODE))) {
						ValueShopApplication.timeOutOrLoginCrowdOut = true;
						whenSessionTimeout(command);
//						whenSessionTimeoutT(command);
						return;
					}
				}
			}
		}
		protected void whenSessionTimeout(Command cmd) {
			if (!cmd.isSuccess) {
				if (cmd.stateCode.equals(SESSION_TIMEOUT_CODE)
						|| cmd.stateCode.equals(LOGIN_CROWD_OUT_CODE)) {
					ValueShopApplication application = ValueShopApplication.isshopapplication;
					application.setSessionId(null);
					context.getSharedPreferences("person",context.MODE_PRIVATE).edit().clear().commit();

 					if (null != mFragment) {
						if (mFragment.get() != null && mFragment.get().getActivity() != null) {
							Toast.makeText(context, "ҳ", Toast.LENGTH_LONG).show();
 						}
						
	 				}  
					if(mActivity!=null){
						if (mActivity!= null && mActivity.get() != null) {
							Toast.makeText(context, "ҳ", Toast.LENGTH_LONG).show();
                           }
 					}
 				}
                 
				isIntercepted = true;
				ValueShopApplication.timeOutOrLoginCrowdOut = false;
				return;
			}
		} 
		

}

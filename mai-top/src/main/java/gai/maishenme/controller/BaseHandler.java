/*******************************************************************************
 * Copyright (c) 2015 by dennis Corporation all right reserved.
 * 2015��5��8�� 
 * 
 *******************************************************************************/ 
package gai.maishenme.controller;

import java.lang.ref.WeakReference;

import gai.maishenme.application.ValueShopApplication;
import gai.maishenme.config.Command;
import gai.maishenme.config.Constants;
import gai.maishenme.util.SPUtils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.widget.Toast;

/**

 */
@SuppressLint("NewApi")
public class BaseHandler extends Handler{
	 
	//implements ETongDaiDialogListener {
		public static final int SESSION_TIMEOUT_RESULT_CODE = 800000;
		public static final int LOGIN_CROWD_OUT_RESULT_CODE = 800001;
		
		/**
		 * �Ƿ�����
		 */
		protected boolean isIntercepted = false;
	  
		// �Ự��ʱ
		public static final String SESSION_TIMEOUT_CODE = "800000";

		// �û�������
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
				// ȡ�������򷵻��ϸ�����
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
					// ���Activity��Fragment�Ѿ������գ�����ʾ������Ϣ
					isIntercepted = true;
					return;
				}
			}

			if (null != mFragment) {
				if (null == mFragment.get() || null == context) {
					// ���Activity��Fragment�Ѿ������գ�����ʾ������Ϣ
					isIntercepted = true;
					return;
				}
			}

			if ((null != mActivity) && (null != mActivity.get())
					&& mActivity.get().isFinishing()) {
				// ���Activity��ǰ�Ѿ��������ģ���ô˵����Acitvity�Ѿ������ǻ����٣�����ʾ������ʾ
				isIntercepted = true;
				return;
			}
			
			if (null != command) {
				if (!command.isSuccess) {
					if (null != command.stateCode
							&& (command.stateCode.equals(SESSION_TIMEOUT_CODE) || command.stateCode
									.equals(LOGIN_CROWD_OUT_CODE))) {
						// ����ǵ�¼��ʱ���߱��߳������֪
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
				// �������ʧ�ܲ��һỰ��ʱ�����û�������
				if (cmd.stateCode.equals(SESSION_TIMEOUT_CODE)
						|| cmd.stateCode.equals(LOGIN_CROWD_OUT_CODE)) {
					ValueShopApplication application = ValueShopApplication.isshopapplication;
//					application.setUserloginbodyvo(null);
					application.setSessionId(null);
					context.getSharedPreferences("person",context.MODE_PRIVATE).edit().clear().commit();

					SPUtils.clear(application);
 					if (null != mFragment) {
						if (mFragment.get() != null && mFragment.get().getActivity() != null) {
            /*      ShowErrorDialogUtil.showAlertDialog(mFragment.get().getActivity(),(String)command.resData, "������ҳ", new ValueShopApplication() {
 					@Override
					public void OnPreviousButtonClicked(EdingTouDialog dialog) {
						// TODO Auto-generated method stub
						Intent lIntent = new Intent(mFragment.get().getActivity(), HomeActivity.class);
						HomeActivity.type = "finish";
						mFragment.get().getActivity().startActivity(lIntent);
						dialog.dismiss();
						ValueShopApplication.isShowingDialog = false;

 					}
					
					@Override
					public void OnNextButtonClicked(ValueShopTouDialog dialog) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void OnMiddleButtonClicked(EdingTouDialog dialog) {
						// TODO Auto-generated method stub
						
					}
				});*/
							Toast.makeText(context, "������ҳ", Toast.LENGTH_LONG).show();
 						}
						
	 				}  
					if(mActivity!=null){
						if (mActivity!= null && mActivity.get() != null) {
                  /*         ShowErrorDialogUtil.showAlertDialog(mActivity.get(),(String)command.resData, "������ҳ", new DeKuShuDialogListener() {
							
							@Override
							public void OnPreviousButtonClicked(EdingTouDialog dialog) {
								// TODO Auto-generated method stub
								Intent lIntent = new Intent(mActivity.get(), HomeActivity.class);
								HomeActivity.type = "finish";
								mActivity.get().startActivity(lIntent);
								dialog.dismiss();
								ValueShopApplication.isShowingDialog = false;

							}
							
							@Override
							public void OnNextButtonClicked(EdingTouDialog dialog) {
								// TODO Auto-generated method stub
								
							}
 							@Override
							public void OnMiddleButtonClicked(EdingTouDialog dialog) {
								// TODO Auto-generated method stub
								
							}
						});*/
							Toast.makeText(context, "������ҳ", Toast.LENGTH_LONG).show();
                           }
 					}
 				}
                 
				isIntercepted = true;
				ValueShopApplication.timeOutOrLoginCrowdOut = false;
				return;
			}
		} 
		

}

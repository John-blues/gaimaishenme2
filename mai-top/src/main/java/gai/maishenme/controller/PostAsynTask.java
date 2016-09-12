/*******************************************************************************
 * Copyright (c) 2015 by dennis Corporation all right reserved.
 * 2015年5月8日 
 * 
 *******************************************************************************/
package gai.maishenme.controller;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.AsyncTask;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import gai.maishenme.R;
import gai.maishenme.config.Command;
import gai.maishenme.config.Constants;
import gai.maishenme.net.Operation;
import gai.maishenme.util.CommonUtils;

import java.util.HashMap;

/**
 
 */
public class PostAsynTask extends AsyncTask<Command, Integer, Message> {
	private Dialog dialog;
	private Command cmd;
	private Boolean isok;

	public void setCmd(Command cmd) {
		this.cmd = cmd;
	}

	@SuppressWarnings("unchecked")
	public PostAsynTask(Context context, Command command) {
		HashMap<String, String> paramHashMap = (HashMap<String, String>) command.param;
	/*	if(ValueShopApplication.isdekushuapplication.getUserloginbodyvo() != null){

			paramHashMap.put("randomCode",ValueShopApplication.isdekushuapplication.getUserloginbodyvo()
					.getBody().getRandomCode());

		}*/
		command.param = paramHashMap;
		isok = CommonUtils.isNetWorkConnected(context);

		this.cmd = command;

		if (cmd.showDialog) {
			// 如果现实等待框
			dialog = createLoadingDialog(context, cmd.waitingMsg);
			dialog.setCanceledOnTouchOutside(false);
			dialog.setCancelable(cmd.canCancelRequest);
			if (cmd.canCancelRequest) {
				dialog.setOnCancelListener(new OnCancelListener() {
					@Override
					public void onCancel(DialogInterface arg0) {
						Message msg = Message.obtain();
						msg.what = Constants.CANCEL_POST_IDENTIFIER;
						cmd.handler.sendMessage(msg);
						cancel(true);
					}
				});
			}
		}
		// if(isok==false||isok.equals(false)){
		// ShowErrorDialogUtil.showErrorDialog(context, "请检查网络");
		// }
	}

	/**
	 * 此方法工作在UI线程
	 */
	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		if (cmd.showDialog) {
			dialog.show();
		}
	}

	/**
	 * doInBackground方法里面不可以直接对UI元素进行操作
	 */
	@Override
	protected Message doInBackground(Command... params) {
		Message msg = execute(this.cmd);
		if (isCancelled()) {
			return null;
		}
		return msg;
	}

	/**
	 * doInBackground执行完后执行此方法
	 */
	@Override
	protected void onPostExecute(Message result) {
		if (this.cmd.hidenDialog) {
			if (null != dialog && dialog.isShowing()) {
				dialog.dismiss();
				dialog = null;
			}
		}

		this.cmd.handler.sendMessage(result);
	}

	@Override
	protected void onCancelled() {
		super.onCancelled();
	}

	/**
	 * 自定义加载框
	 * 
	 * @param context
	 * @param msg
	 * @return
	 */
	public Dialog createLoadingDialog(Context context, String msg) {
		LayoutInflater inflater = LayoutInflater.from(context);
		View view = inflater.inflate(R.layout.wait_progress_dialog, null);
		LinearLayout layout = (LinearLayout) view
				.findViewById(R.id.dialog_view);// 加载布局

		TextView tipTextView = (TextView) view.findViewById(R.id.waiting_text);// 提示文字

		if (null != cmd.waitingMsg && !"".equals(cmd.waitingMsg)) {
			tipTextView.setText(this.cmd.waitingMsg);
		} else {
			if ("".equals(msg))
				tipTextView.setText("加载中,请稍侯...");
			else {
				tipTextView.setText(msg);
			}
		}

		Dialog dialog = new Dialog(context, R.style.customDialogTheme);
		dialog.setContentView(layout, new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.WRAP_CONTENT,
				LinearLayout.LayoutParams.WRAP_CONTENT));
		return dialog;
	}
	private Message execute(Command command) {
		Operation operation = new Operation();
		// ------------------------------------------------
		if(Constants.SHOPLISTTEST==command.commandID){
			return operation.executeLfTest(command);
			
		}
		return null;

	}
}

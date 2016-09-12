package gai.maishenme.util;
import gai.maishenme.R;
import gai.maishenme.application.ValueShopApplication;
import gai.maishenme.dialog.ValueShopDialog;
import gai.maishenme.dialog.ValueShopDialog.ShopDialogListener;

import android.annotation.SuppressLint;
import android.content.Context;

@SuppressLint("ResourceAsColor")
public class ShowErrorDialogUtil {

	public static void showErrorDialog(Context context, String errString) {
		if (ValueShopApplication.isShowingDialog)
			return;
		ValueShopDialog dialog= new ValueShopDialog(context,listener);
		dialog.show();
		dialog.getDialogContentTxt().setText(errString);
		dialog.getPreviousBtn().setText("ȷ��");
		dialog.getDialogImage().setBackgroundResource(
				R.drawable.alert_dialog_right);

	}

	public static void showErrorDialog(Context context, String errString,
			ShopDialogListener listener) {
		if (ValueShopApplication.isShowingDialog)
			return;
		ValueShopDialog dialog = null;
		dialog = new ValueShopDialog(context, listener);
		dialog.show();
		dialog.getDialogContentTxt().setText(errString);
		dialog.getPreviousBtn().setText("ȷ��");
		dialog.getDialogImage().setBackgroundResource(
				R.drawable.alert_dialog_right);
	}
	public static void showSuccesDialog(Context context, String errString,
			ShopDialogListener listener) {
		if (ValueShopApplication.isShowingDialog)
			return;
		ValueShopDialog dialog = null;
		dialog = new ValueShopDialog(context, listener);
		dialog.show();
		dialog.getDialogContentTxt().setText(errString);
		dialog.getPreviousBtn().setText("ȷ��");
		dialog.getDialogImage().setBackgroundResource(
				R.drawable.alert_dialog_right);
	}
	public static void showAlertDialog(Context context, String errString, String buttonString,
			ShopDialogListener listener) {
		if (ValueShopApplication.isShowingDialog)
			return;
		ValueShopApplication.isShowingDialog = true;
		ValueShopDialog dialog = new ValueShopDialog(context, listener);
		dialog.show();
		dialog.getDialogContentTxt().setText(errString);
		dialog.getPreviousBtn().setText(buttonString);
		dialog.getDialogImage().setBackgroundResource(R.drawable.dialog_error_icon);

	}
	public static void showSuccesDialogg(Context context, String errString,
			ShopDialogListener listener) {
		ValueShopDialog dialogs = null;
		dialogs = new ValueShopDialog(context, listener);
		dialogs.show();
		dialogs.getDialogContentTxt().setText(errString );	
		dialogs.getPreviousBtn().setText("ȷ��");
	}
	
	
	
	@SuppressLint("ResourceAsColor")
	private static ShopDialogListener listener = new ShopDialogListener() {

		@Override
		public void OnPreviousButtonClicked(ValueShopDialog dialog) {
			// TODO Auto-generated method stub 
			if (null != dialog && dialog.isShowing()) {
				dialog.dismiss();
				dialog=null;
			}
		}

		@Override
		public void OnNextButtonClicked(ValueShopDialog dialog) {
			// TODO Auto-generated method stub

		}

		@Override
		public void OnMiddleButtonClicked(ValueShopDialog dialog) {

		}
	};
}

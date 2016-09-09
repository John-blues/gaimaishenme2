package gai.maishenme.service;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ScheduledExecutorService;


import gai.maishenme.R;

import android.app.Dialog;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.view.WindowManager;

public class MyService extends Service implements Observer {

    private Dialog mDialog;
    private ScheduledExecutorService mScheduledExecutorService;

    private Handler mHandler = new Handler() {
        public void dispatchMessage(android.os.Message msg) {
            if (mDialog != null && !mDialog.isShowing()) {
                mDialog.show();
            }
        };
    };

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        return super.onStartCommand(intent, flags, startId);

    }
    @Override
    public void update(Observable observable, Object data) {
        if (mDialog == null) {
            mDialog = new Dialog((Context) data);
            mDialog.setContentView(R.layout.show_dialog);
            mDialog.getWindow().setType(
                    (WindowManager.LayoutParams.TYPE_SYSTEM_ALERT));
        }
        if (mDialog != null && !mDialog.isShowing()) {
            mDialog.show();
        }
    }
}

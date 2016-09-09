package gai.maishenme.util;

import java.util.HashMap;
import java.util.Set;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;

public class ActivityTaskManager {
     public static ActivityTaskManager activitytaskmanager=null;
     HashMap<String, Activity>  activitymap;
     
    private ActivityTaskManager(){
    	activitymap=new HashMap<String, Activity>();
    }
     public static ActivityTaskManager getInstance(){
    	 if(activitytaskmanager==null){
    		 synchronized (ActivityTaskManager.class) {
				if(activitytaskmanager==null){
			    activitytaskmanager=new ActivityTaskManager();		
				}
			}
    	 }
		return activitytaskmanager;
      }
     public Activity putActivity(String name,Activity activity){
 
    	 return activitymap.put(name,activity) ;
    			 }
     public Activity getActivity(String name){
    	 return activitymap.get(name);
     }
     public  Boolean isEmpty(){
    	 return activitymap.isEmpty();
     }
     public int Size(){
    	 return activitymap.size();
     }
     public Boolean containsName(String name){
    	 return activitymap.containsKey(name);
     }
      public void CloseAllActivity(){
      Set<String>  activitynames=activitymap.keySet();
       for (String string : activitynames) {
     	   finisActivity(activitymap.get(string));
	}
     }
      private final void finisActivity(Activity activity){
    	  if(activity!=null){
    		  if(activity.isFinishing()){
    			  activity.finish();
    		  }
    	  }
      }
      public void closeAllActivityExceptOne(String name){
    	  Set<String> activityNames=activitymap.keySet();
    	  Activity activitySpecified=activitymap.get(name);
    	  for (String string : activityNames) {
			if(activityNames.equals(name)){
				continue;
			}
		   finisActivity(activitymap.get(name));	
		}
    	  activitymap.clear();
    	  activitymap.put(name, activitySpecified);
      }

      public  void removeActivity(String removeName) {
		// TODO Auto-generated method stub
        Activity activityRemove=activitymap.get(removeName);
        finisActivity(activityRemove);
	}
      
     public void AppExit(Context context,Boolean isBackground){
    	 try {
        	 CloseAllActivity();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (!isBackground) {
				int currentVersion = android.os.Build.VERSION.SDK_INT;
				if (currentVersion > android.os.Build.VERSION_CODES.ECLAIR_MR1) {
					Intent startMain = new Intent(Intent.ACTION_MAIN);
					startMain.addCategory(Intent.CATEGORY_HOME);
					startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					context.startActivity(startMain);
					System.exit(0);
				} else {// android2.1
					ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
					am.restartPackage(context.getPackageName());
				}
			}}
     }
}

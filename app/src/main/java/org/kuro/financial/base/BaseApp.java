package org.kuro.financial.base;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;

public class BaseApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // 只在主进程中初始化
        if (getApplicationInfo().packageName.equals(getCurProcessName(getApplicationContext()))) {
            // SpUtils.getInstance().initSp(this);
        }
    }


    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
    }


    /**
     * 获取当前进程名
     *
     * @param context
     * @return
     */
    public static String getCurProcessName(Context context) {
        int pid = android.os.Process.myPid();
        ActivityManager activityManager = (ActivityManager)
                context.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo appProcess :
                activityManager.getRunningAppProcesses()) {
            if (appProcess.pid == pid) {
                return appProcess.processName;
            }
        }
        return null;
    }
}

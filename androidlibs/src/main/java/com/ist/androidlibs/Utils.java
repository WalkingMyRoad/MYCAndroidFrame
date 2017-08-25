package com.ist.androidlibs;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.support.annotation.NonNull;

import java.util.LinkedList;
import java.util.List;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 16/12/08
 *     desc  : Utils初始化相关
 * </pre>
 */
public final class Utils {
    /**
     *  全局的Application
     */
    @SuppressLint("StaticFieldLeak")
    private static Application sApplication;
    /**
     * 全局的所有 Activity 集合
     */
    protected static List<Activity> sActivityList = new LinkedList<>();

    /**
     * 最上层的Activity
     */
    @SuppressLint("StaticFieldLeak")
    protected static Activity sTopActivity;
    /**
     * activity 生命周期的回调
     */
    private static Application.ActivityLifecycleCallbacks mCallbacks = new Application.ActivityLifecycleCallbacks() {
        @Override
        public void onActivityCreated(Activity activity, Bundle bundle) {
            sActivityList.add(activity);
        }

        @Override
        public void onActivityStarted(Activity activity) {

        }

        @Override
        public void onActivityResumed(Activity activity) {
            sTopActivity = activity;
        }

        @Override
        public void onActivityPaused(Activity activity) {

        }

        @Override
        public void onActivityStopped(Activity activity) {

        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

        }

        @Override
        public void onActivityDestroyed(Activity activity) {
            sActivityList.remove(activity);
        }
    };

    /**
     * 实例化类 返回异常不允许实例化
     */
    private Utils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 初始化工具类
     *
     * @param app 应用
     */
    public static void init(@NonNull final Application app) {
        Utils.sApplication = app;
        app.registerActivityLifecycleCallbacks(mCallbacks);
    }

    /**
     * 获取Application
     *
     * @return Application
     */
    public static Application getApp() {
        if (sApplication != null) return sApplication;
        throw new NullPointerException("u should init first");
    }

    /**
     * 获取当前最顶层的 activity的名字
     * @return
     */
    public static Activity getTopActivity() {
        if(sActivityList!=null && sActivityList.size()>0)
            return sTopActivity;
        else
            return null;
    }

    /**
     * 获取当前所有的Activity
     * @return
     */
    public static List<Activity> getActivityList() {
        return sActivityList;
    }
}

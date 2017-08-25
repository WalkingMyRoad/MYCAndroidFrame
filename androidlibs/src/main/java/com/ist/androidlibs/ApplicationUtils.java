package com.ist.androidlibs;

import android.app.Application;
import android.content.res.Configuration;
import android.util.Log;

/**
 * Created by minyuchun on 2017/8/24.
 * 基础的 Application 类库 封装一些基本的 Application类
 *
 * 使用时 需要程序自定义 Application 继承 ApplicationUtils
 */

public class ApplicationUtils extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        // 程序创建的时候执行
        Utils.init(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        //当终止应用程序对象时调用，不保证一定被调用，当程序是被内核终止以便为其他应用程序释放资源，那么将不会提醒，并且不调用应用程序的对象的onTerminate方法而直接终止进程
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        //低内存的时候执行
        //当后台程序已经终止资源还匮乏时会调用这个方法。好的应用程序一般会在这个方法里面释放一些不必要的资源来应付当后台程序已经终止，前台应用程序内存还不够时的情况。
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        // HOME键退出应用程序、长按MENU键，打开Recent TASK都会执行
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        //配置改变时触发这个方法 如翻转屏幕
    }


    /**
     * 备注:application 被杀死的情况分析：

     为了决定在内存较低的时候杀掉哪个进程, Android会根据运行在这些进程内的组件及他们的状态把进程划分成一个”重要程度层次”. 其重要的程度按以下规则排序:

     1：前端进程可以是一个持有运行在屏幕最前端并与用户交互的Activity的进程(onResume方法被调用时)，也可以是持有一个正在运行的IntentReceiver(也就是说他正在执行自己的onReceiveIntent方法)的进程. 在系统中, 只会有少数这样的进程, 并且除非内存已经低到不够这些进程运行, 否则系统不会主动杀掉这些进程. 这时, 设备通常已经达到了需要内存整理的状态, 所以杀掉这些进程是为了不让用户界面停止响应.

     2：可视进程是持有一个被用户可见, 但没有显示在最前端 (onPause方法被调用时) 的Activity的进程. 举例来说, 这种进程通常出现在一个前端Activity以一个对话框出现并保持前一个Activity可见时. 这种进程被系统认为是极其重要的, 并且通常不会被杀掉, 除非为了保持所有前端进程正常运行不得不杀掉这些可见进程.

     3：服务进程是持有一个Service的进程, 该Service是由startService()方法启动的, 尽管这些进程用户不能直接看到, 但是通常他们做的工作用户是十分关注的(例如, 在后台播放mp3或是在后台下载 上传文件), 所以, 除非为了保持所有的前端进程和可视进程正常运行外, 系统是不会杀掉服务进程的.

     4：后台进程是持有一个不再被用户可见的Activity(onStop()方法被调用时)的进程. 这些进程不会直接影响用户体验. 加入这些进程已经完整的,正确的完成了自己的生命周期(访问Activity查看更多细节), 系统会在为前三种进程释放内存时随时杀掉这些后台进程. 通常会有很多的后台进程在运行, 所以这些进程被存放在一个LRU列表中, 以保证在低内存的时候, 最近一个被用户看到的进程会被最后杀掉.

     5：空进程是没有持有任何活动应用组件的进程. 保留这种进程的唯一理由是为了提供一种缓存机制, 缩短他的应用下次运行时的启动时间. 就其本身而言, 系统杀掉这些进程的目的是为了在这些空进程和底层的核心缓存之间平衡整个系统的资源. www.2cto.com

     当需要给一个进程分类的时候, 系统会在该进程中处于活动状态的所有组件里掉选一个重要等级最高作为分类依据. 查看Activity, Service,和IntentReceiver的文档, 了解每个组件在进程整个生命周期中的贡献. 每一个classes的文档详细描述他们在各自应用的生命周期中所起得作用.
     */
}

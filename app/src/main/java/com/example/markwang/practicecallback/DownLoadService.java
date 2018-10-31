package com.example.markwang.practicecallback;

import android.os.Looper;

public class DownLoadService {
    private OnDownLoadListener onDownLoadListener;

    public DownLoadService() {

    }

    public void setOnDownLoadListener(OnDownLoadListener onDownLoadListener) {
        this.onDownLoadListener = onDownLoadListener;
    }

    /**
     * why add Looper, look https://blog.csdn.net/sunhuaqiang1/article/details/46839045
     * and https://www.jianshu.com/p/36a978b6cacc
     */
    public void startDownLoad() {
        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                 Looper.prepare();
                try {
                    Thread.sleep(4000);
                    onDownLoadListener.onComplete("finish");
                } catch (Exception e) {
                    onDownLoadListener.onFail("fail");
                }
                Looper.loop();
            }
        });
        thread.start();
    }
}

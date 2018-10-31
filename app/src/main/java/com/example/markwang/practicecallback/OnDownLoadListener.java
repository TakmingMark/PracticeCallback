package com.example.markwang.practicecallback;

public interface OnDownLoadListener {
    void onComplete(String message);
    void onFail(String message);
}

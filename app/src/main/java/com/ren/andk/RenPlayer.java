package com.ren.andk;

import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class RenPlayer implements SurfaceHolder.Callback {

    static {
        System.load("native-lib");
    }


    private String dataSource;
    private SurfaceHolder holder;
    private OnPrepareListener listener;

    /**
     * 让使用 设置播放的文件 或者 直播地址
     */
    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public void setSurfaceView(SurfaceView surfaceView){
        this.holder = surfaceView.getHolder();
        holder.addCallback(this);
    }

    public void setOnPrepareListener(OnPrepareListener listener){
        this.listener = listener;
    }

    public void onPrepare(){
        if (null != listener){
            listener.onPrepare();
        }
    }

    public void onError(int errorCode){
        System.out.println("Java接到回调:"+errorCode);
    }


    public void release() {
        holder.removeCallback(this);
    }


    /**
     * 准备好 要播放的视频
     */
    public void prepare() {
        native_prepare(dataSource);
    }

    /**
     * 开始播放
     */
    public void start() {

    }

    /**
     * 停止播放
     */
    public void stop() {

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }


    public interface OnPrepareListener{
        void onPrepare();
    }
    native void native_prepare(String dataSource);
}

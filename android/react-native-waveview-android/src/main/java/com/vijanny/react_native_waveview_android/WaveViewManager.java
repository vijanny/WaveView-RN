package com.vijanny.react_native_waveview_android;

/**
 * Created by vijanny <jiajick@gmail.com>  on 2017-08-22.
 */

import com.facebook.react.uimanager.SimpleViewManager;
import android.content.Context;

import android.graphics.Color;


import android.util.Log;

import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

import com.gelitenight.waveview.library.WaveView;

import java.util.Map;
import com.facebook.react.common.MapBuilder;
import javax.annotation.Nullable;
import com.facebook.react.bridge.ReadableArray;

/**
 * Created by vijanny jiajick@gmail.com  on 2017-08-15.
 */



public class WaveViewManager extends SimpleViewManager<WaveView> {

    private Context mContext;
    private WaveHelper mWaveHelper;
    private int mBorderColor = Color.parseColor("#44FFFFFF");
    private int mBorderWidth = 10;
    private int mBehindWaveColor =Color.parseColor("#44FFFFFF");
    private int mFrontWaveColor =Color.parseColor("#44FFFFFF");
    private WaveView mWaveView;
    private float mProgress;
    private static final int PROGRESS_CHANG = 0;
    @Override
    public String getName() {
        return "WaveView";
    }

    @Override
    protected WaveView createViewInstance(final ThemedReactContext reactContext) {
        mContext = reactContext;
        final WaveView waveview = new WaveView(reactContext);
        mWaveHelper = new WaveHelper(waveview);
        waveview.setWaterLevelRatio(30/100);
        waveview.setShapeType(WaveView.ShapeType.CIRCLE);
        waveview.setWaveColor(
                Color.parseColor("#28f16d7a"),
                Color.parseColor("#3cf16d7a"));
        waveview.setBorder(mBorderWidth, mBorderColor);
        mWaveHelper.start();

        return waveview;
    }

    @ReactProp(name = "behindWaveColor")
    public void setBehindWaveColor(WaveView waveview, String behindWaveColor)
    {
        mBehindWaveColor= Color.parseColor(behindWaveColor);
        mWaveHelper.cancel();
        waveview.setWaveColor(
                mBehindWaveColor,
                mFrontWaveColor);
        mWaveHelper.start();
    }

    @ReactProp(name = "frontWaveColor")
    public void setFrontWaveColor(WaveView waveview, String frontWaveColor)
    {
        mFrontWaveColor= Color.parseColor(frontWaveColor);
        mWaveHelper.cancel();
        waveview.setWaveColor(
                mBehindWaveColor,
                mFrontWaveColor);
        mWaveHelper.start();

    }
    @ReactProp(name = "progress")
    public void setProgress(WaveView Wave_View, int progress)
    {
//        mWaveHelper.cancel();
//        Wave_View.setWaterLevelRatio(progress/100);
//
//        mWaveHelper.start();
        mWaveView = Wave_View;
        mProgress = progress/100;
    }
    @ReactProp(name = "borderColor")
    public void setBorderColor(WaveView waveview, String borderColor)
    {
        mBorderColor= Color.parseColor(borderColor);
        waveview.setBorder(mBorderWidth, mBorderColor);

    }
    @ReactProp(name = "borderWidth")
    public void setBorderColor(WaveView waveview, int borderWidth)
    {
        mBorderWidth= borderWidth;
        waveview.setBorder(mBorderWidth, mBorderColor);

    }

    protected void onPause() {
        mWaveHelper.cancel();
    }


    protected void onResume() {
        mWaveHelper.start();
    }


    @Override
    public Map<String, Integer> getCommandsMap() {
        return MapBuilder.of("changeProgress", PROGRESS_CHANG);
    }

    @Override
    public void receiveCommand(WaveView root, int commandId, @Nullable ReadableArray args) {
        Log.i("WaveManager", "receiveCommand: "+commandId+" args:"+args);
        switch (commandId) {
            case PROGRESS_CHANG:
                root.setWaterLevelRatio((float) args.getInt(0)/100);
                break;
            default:
                break;
        }
    }
}
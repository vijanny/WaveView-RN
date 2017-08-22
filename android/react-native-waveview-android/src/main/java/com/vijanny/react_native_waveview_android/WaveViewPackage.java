package com.vijanny.react_native_waveview_android;

/**
 * Created by Administrator on 2017-08-22.
 */


import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author  vijanny<jiajick@gmail.com>
 *
 */
public class WaveViewPackage implements ReactPackage {
    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
        return Collections.emptyList();
    }


    public List<Class<? extends JavaScriptModule>> createJSModules() {
        return Collections.emptyList();
    }

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        // 注册AppViewManager
        List<ViewManager> viewManagers = new ArrayList<>();
        viewManagers.add(new WaveViewManager());
        return viewManagers;
    }
}
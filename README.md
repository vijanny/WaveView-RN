# react-native-waveview-android
WaveView UI Component for react native 

## Install

```shell
npm i react-native-waveview-android --save
```
### Android

- in `android/app/build.gradle`:
```diff
android {
    ...
    compileSdkVersion 25
    buildToolsVersion '25.0.0'
    ...
    defaultConfig {
      ...
        minSdkVersion 23
        targetSdkVersion 25
      ...
    }
    
    
}

dependencies {
    ...
-   compile "com.android.support:appcompat-v7:23.0.1"
+   compile 'com.android.support:appcompat-v7:25.3.0'
    compile "com.facebook.react:react-native:+"  // From node_modules
+   compile project(':react-native-waveview-android')

}
```

- in `android/settings.gradle`:

```diff
...
include ':app'
+  include ':react-native-waveview-android'
+  project(':react-native-waveview-android').projectDir = new File(rootProject.projectDir, '../node_modules/react-native-waveview-android')
```

#### With React Native 0.29+

- in `MainApplication.java`:

```diff
+ import com.vijanny.react_native_waveview_android.WaveViewPackage;

  public class MainApplication extends Application implements ReactApplication {
    //......

    @Override
    protected List<ReactPackage> getPackages() {
      return Arrays.<ReactPackage>asList(
+         new WaveViewPackage(),
          new MainReactPackage()
      );
    }

    ......
  }
```

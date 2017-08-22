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

## Example

```js
/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, { Component } from 'react';
import {
  AppRegistry,
  StyleSheet,
  Text,
  View
} from 'react-native';

import WaveViewComponent from 'react-native-waveview-android'



export default class TsWaveView extends Component {
  render() {
    return (
      <View style={styles.container}>
        <WaveViewComponent 
          ref='wave'
          style={styles.wave} 
          frontWaveColor="red"
          behindWaveColor='#FF9E80'
          borderColor='#FF6E40'          
          borderColor='#FF6E40'
          borderWidth={20}
          progress={30}
        />
        <Text style={styles.welcome}>
          Welcome to React Native!
        </Text>
        <Text style={styles.instructions}>
          To get started, edit index.android.js
        </Text>
        <Text style={styles.instructions}>
          Double tap R on your keyboard to reload,{'\n'}
          Shake or press menu button for dev menu
        </Text>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  wave:{
    width:300,
    height:300,
  },
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
  instructions: {
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5,
  },
});

AppRegistry.registerComponent('TsWaveView', () => TsWaveView);
```


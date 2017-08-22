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
  View,
  Dimensions,
  ToastAndroid,
  UIManager
} from 'react-native';


// 数据展示和事件交互

import WaveViewComponent from './WaveViewComponent'
UIManager.setLayoutAnimationEnabledExperimental && UIManager.setLayoutAnimationEnabledExperimental(true);
class waveView extends Component {
  constructor(props) {
    super(props);
  
    this.state = {progress:80};
    var that = this;

  }
  changeProgress(){
    
  }


  componentDidMount(){
    let that = this;
    setTimeout(()=>{
      that.setState({progress:30});
    },3*1000);
  }
  render() {
    return (
      <View style={styles.container}>
        <WaveViewComponent 
          ref='wave'
          style={styles.wave} 
          frontWaveColor="red"
          behindWaveColor='#FF9E80'
          borderColor='#FF6E40'
          borderWidth={20}
          progress={this.state.progress}
        />
      </View>
    );
  }
}


const styles = StyleSheet.create({
  wave:{
    width:200,
    height:200,
  },
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: 'white',
  },
  listView: {
    width: Dimensions.get('window').width,
    height: Dimensions.get('window').height,
  },
});


AppRegistry.registerComponent('waveView', () => waveView);

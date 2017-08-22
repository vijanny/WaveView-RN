
'use strict';
import React, {Component, PropTypes } from 'react';
import {requireNativeComponent,View,UIManager} from 'react-native';


var WaveView = requireNativeComponent('WaveView', WaveViewComponent);
const ReactNative = require('ReactNative');
const REF_WAVE='ref_wave';
const PROGRESS_CHANG = 0;
class WaveViewComponent extends Component {
  componentDidUpdate(){
  	let self = this;
     UIManager.dispatchViewManagerCommand(
        ReactNative.findNodeHandle(self.refs[REF_WAVE]),
        UIManager.WaveView.Commands.changeProgress,
        [this.props.progress]
    );
  }
  componentDidMount(){
    let self = this;
    setTimeout(()=>{
        UIManager.dispatchViewManagerCommand(
            ReactNative.findNodeHandle(self.refs[REF_WAVE]),
            UIManager.WaveView.Commands.changeProgress,
            [this.props.progress]
        );
    },2*1000);
  }
  render() {
    return <WaveView ref={REF_WAVE} {...this.props} />;
  }
}

WaveViewComponent.propTypes = {
      behindWaveColor:PropTypes.string,
      frontWaveColor:PropTypes.string,
      borderColor:PropTypes.string,
      borderWidth:PropTypes.number,
      progress:PropTypes.number,
      ...View.propTypes, // 包含默认的View的属性
};

module.exports = WaveViewComponent;
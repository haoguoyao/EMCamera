//index.js
//获取应用实例
var app = getApp()

Page({
  data: {
    userInfo: {},
    hasUserInfo: false,
    canIUse: wx.canIUse('button.open-type.getUserInfo')
  },
  studentNumberInput:function(e){
    wx.setStorageSync('studentNumber', e.detail.value)
    
  },
  login: function(){
    wx.request({
      url: 'https://www.ercamera.top/RCCamera/wechat/studentAccountHandler/checkIdExist',
      method: 'post',
      data: "id=" + wx.getStorageSync("studentNumber"),
      header: {
        "content-type": "application/x-www-form-urlencoded;charset=utf-8"
      },
      success: function (res) {//服务器应返回是否成功
        wx.hideToast();
        console.log("id=" + wx.getStorageSync("studentNumber"))
        console.log(res)
        if (res.statusCode != 200) {
          wx.showToast({
            title: '! no connection !',//提示文字
            duration: 1500,//显示时长
            mask: false,//是否显示透明蒙层，防止触摸穿透，默认：false  
            icon: 'none', //图标，支持"success"、"loading"  
            success: function () { console.log("1") },//接口调用成功
            fail: function () { console.log("2") },  //接口调用失败的回调函数  
            complete: function () { console.log("3") } //接口调用结束的回调函数  
          })

          return;
        }
        else {
          if (res.data == false) {
            console.log("student not exist")
            wx.showToast({
              title: '! user not exist !',//提示文字
              duration: 1500,//显示时长
              mask: false,//是否显示透明蒙层，防止触摸穿透，默认：false  
              icon: 'none', //图标，支持"success"、"loading"  
              success: function () { console.log("1") },//接口调用成功
              fail: function () { console.log("2") },  //接口调用失败的回调函数  
              complete: function () { console.log("3") } //接口调用结束的回调函数  
            })
          }
          if (res.data == true) {
            console.log("success")
            wx.navigateTo({
              url: '../upload/upload',
            })
          }

        }
      },
      fail: function (e) {
        wx.showToast({
          title: '! no connection !',//提示文字
          duration: 2000,//显示时长
          mask: false,//是否显示透明蒙层，防止触摸穿透，默认：false  
          icon: 'none', //图标，支持"success"、"loading"  
          success: function () { console.log("1") },//接口调用成功
          fail: function () { console.log("2") },  //接口调用失败的回调函数  
          complete: function () { console.log("3") } //接口调用结束的回调函数  
        })
        //网络出错，请用户重试
      }
    })
  },
  //事件处理函数
  bindViewTap: function () {
    wx.navigateTo({
      url: '../logs/logs'
    })
  },
  onLoad: function () {
    console.log('Page index onLoad')
    wx.setStorageSync('serverLocation',"https://www.ercamera.top/RCCamera")
    var that = this
    //调用应用实例的方法获取全局数据  
    app.getUserInfo(function (userInfo) {
      //更新数据  
      that.setData({
        userInfo: userInfo
      })
    })
    this.login()
  },
  enterbutton: function () {
    wx.navigateTo({
      url: '../logs/logs',
    })
  },

  formSubmit: function (e) {
    var that = this
    wx.showToast({
      icon: "loading",
      title: "loading"
    }),
      wx.request({
      url: 'https://www.ercamera.top/RCCamera/wechat/studentAccountHandler/checkIdExist',
        method: 'post',
        data: "id="+wx.getStorageSync("studentNumber"),
        header: {
          "content-type": "application/x-www-form-urlencoded;charset=utf-8"
        },
        success: function (res) {//服务器应返回是否成功
          wx.hideToast();
          console.log("id=" + wx.getStorageSync("studentNumber"))
          console.log(res)
          if (res.statusCode != 200) {
            wx.showToast({
              title: '! no connection !',//提示文字
              duration: 1500,//显示时长
              mask: false,//是否显示透明蒙层，防止触摸穿透，默认：false  
              icon: 'none', //图标，支持"success"、"loading"  
              success: function () { console.log("1") },//接口调用成功
              fail: function () { console.log("2") },  //接口调用失败的回调函数  
              complete: function () { console.log("3") } //接口调用结束的回调函数  
            })
            
            return;
          }
          else {
            if (res.data == false) {
              console.log("student not exist")
              wx.showToast({
                title: '! user not exist !',//提示文字
                duration: 1500,//显示时长
                mask: false,//是否显示透明蒙层，防止触摸穿透，默认：false  
                icon: 'none', //图标，支持"success"、"loading"  
                success: function () { console.log("1") },//接口调用成功
                fail: function () { console.log("2") },  //接口调用失败的回调函数  
                complete: function () { console.log("3") } //接口调用结束的回调函数  
              })
            }
            if (res.data == true) {
              console.log("success")
              wx.navigateTo({
                url: '../upload/upload',
              })
            }
            
          }
        },
        fail: function (e) {
          wx.showToast({
            title: '! no connection !',//提示文字
            duration: 2000,//显示时长
            mask: false,//是否显示透明蒙层，防止触摸穿透，默认：false  
            icon: 'none', //图标，支持"success"、"loading"  
            success: function () { console.log("1")},//接口调用成功
            fail: function () { console.log("2") },  //接口调用失败的回调函数  
            complete: function () { console.log("3") } //接口调用结束的回调函数  
          })
          //网络出错，请用户重试
        }
      })
  }
  
  
})

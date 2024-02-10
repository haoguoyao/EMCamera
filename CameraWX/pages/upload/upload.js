// upload/upload.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
      textButton:"upload",
      image_url:"../image/test.jpg",
      source:[]
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log("Page upload onload")
    var that = this
    wx.request({
      url: 'https://www.ercamera.top/RCCamera/student/PhotoHandler_get',
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
          console.log("get personal photo wrong")
          return;
        }
        else {
          console.log("get personal photo finish")
          if (res.data !='') {
            that.setData({image_url:wx.getStorageSync('serverLocation')+'/'+res.data})
            
          }

        }
      },
      fail: function (e) {
        console.log(e)
      
      }

      
    })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
    this.setData({
      textButton : getApp().globalData.uploadButtonText
    }) 
    
  },
  firstPage: function () {
    wx.navigateBack({
      
    })

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {
  
  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {
  
  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {
  
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
  
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {
  
  },


listenerButtonChooseImage: function () {
  var that=this
  wx.chooseImage({
    count: 1, // 1张图片
    sizeType: 'original',
    success: function (res) {
      console.log(res.tempFilePaths[0])
      that.setData({ source: res.tempFilePaths})
      console.log(that.data.source)
      that.setData({ image_url: res.tempFilePaths[0]})
    },
    fail:function(e){}
  })
},



previewPhoto:function(){
  console.log("preview photo")
  wx.previewImage({
    current: this.data.source[0],
    urls : this.data.source,
    
  })
},




// 点击submit按钮时
upLoadPhoto:function(){
  var that = this
  if(that.data.source.length==0){
    wx.showToast({
      duration: 1500,
      icon: "none",
      title: "! no photo seleted !"
    })
    return
  }
  wx.showToast({
    icon: "loading",
    title: "正在上传"
  })
  console.log(that.source)
  var postfix = that.data.source[0].substring(that.data.source[0].lastIndexOf(".") + 1, that.data.source[0].length);
  wx.uploadFile({
    url: "https://www.ercamera.top/RCCamera/student/PhotoHandler_upload",
    filePath: that.data.source[0],
    name: "multipartFile",
    formData:{
      'fileName': wx.getStorageSync('studentNumber')+".png",
      'id': wx.getStorageSync('studentNumber')
    },
    success: function (res) {
      console.log(wx.getStorageSync('userId'))
      wx.hideToast();
      if (res.statusCode != 200) {
        wx.showModal({
          title: '提示',
          content: '上传失败',
          showCancel: false
        })
        return;
      }
      else if (res.statusCode == 200) {
        console.log(res)
        if (res.data == 1) {
          wx.showModal({
            title: '提示',
            content: 'the photo is OK',
            showCancel: false
          })}
        if (res.data != 1) {
          wx.showModal({
            title: '提示',
            content: 'the photo is not OK',
            showCancel: false
          })
        }
        
        return;
      }
    },
    fail: function (e) {
      wx.hideToast();//错误，重试}
    }
  })
}
})
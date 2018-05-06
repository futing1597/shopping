<template>
  <div>
    <div class="head">
        <div class="headinner">
            <div class="headtitleleft">咨询热线：<b>13061960526</b></div>
            <div @click="login" class="headtitleright">退出登陆</div>
        </div>
    </div>
    <div class="clear"></div>
    <div class="content">
        <div class="contentinner">
            <div class="logo">
                <div @click="goIndex"><img src="/static/images/index/logoSmall.jpg"></div>
            </div>
            <div class="SreachBox">
                <div @click="search" class="sreach_btn"></div>
                <input name="" type="text" class="sreach_ipu">
            </div>
            <div class="clear"></div>
            <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" router>
              <template v-for="item in topMenu">
                <el-submenu v-if="item.childMenuList.length > 0" :index="item.name_zh_CN" :key="item.name_zh_CN" style="margin:0 30px;">
                  <template slot="title">{{item.name_zh_CN}}</template>
                  <el-menu-item v-for="itemChild in item.childMenuList" :index="itemChild.name_zh_CN" :key="itemChild.name_zh_CN">{{itemChild.name_zh_CN}}</el-menu-item>
                </el-submenu>
                <el-menu-item v-else :index="item.name_zh_CN" :key="item.name_zh_CN" style="margin:0 30px;">{{item.name_zh_CN}}</el-menu-item>
              </template>
            </el-menu>
        </div>
    </div>
    <div class="clear"></div>
  </div>
</template>

<script>
export default {
  name: 'hello',
  data () {
    return {
      activeIndex: '1',
      topMenu: []
    }
  },
  created () {
    this.getData()
  },
  methods: {
    getData () {
      this.$http.get(this.library.urlHead + '/menu/searchSecondMenu').then(response => {
        this.topMenu = response.data
      })
    },
    show () {
      this.visible = true
    },
    search () {
      this.$message({
        message: '正在查询',
        type: 'info'
      })
    },
    login () {
      this.$router.push('/')
    },
    goIndex () {
      this.$router.push('/index')
    }
  }
}
</script>

<style scoped>
  textarea, input, select {
    background: none;
    border: none;
    margin: 0;
    padding: 0;
  }
  .clear {
    clear: both;
  }
  .head {
    border-top: 4px solid #1c808a;
    border-bottom:1px solid #e4e4e4;
    min-height: 36px;
  }
  .headinner {
    width:70%;
    margin:0 auto;
  }
  .headtitleleft {
    float: left;
    line-height: 41px;
    font-size: 20px;
    color: #1fc5d6;
  }
  .headtitleright {
    float: right;
    margin-right: 20px;
    line-height: 41px;
    font-size: 14px;
    color: #1fc5d6;
    cursor: pointer;
  }

  .content {
    height: 131px;
    width:70%;
    margin:0 auto;
  }
  .contentinner {
      width:100%;
  }
  .content .logo{
    float: left;
    padding: 18px 0;
    cursor: pointer;
  }
  .content .SreachBox {
    float: right;
    border: 1px solid #e4e4e4;
    margin-top: 20px;
  }
  .content .SreachBox .sreach_btn {
    float: right;
    width: 34px;
    height: 34px;
    background: url(/static/images/index/TOP_06.png) no-repeat;
  }
  .content .SreachBox .sreach_ipu {
    height: 34px;
    width: 330px;
    padding-left: 12px;
    color: #999;
    font-size: 14px;
    line-height: 34px;
  }
</style>
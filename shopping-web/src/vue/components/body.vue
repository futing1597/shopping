<template>
  <div class="body">
    <el-row class="tac">
      <el-col :span="4">
        <el-menu :default-active="activeIndex" router class="el-menu-vertical-demo">
            <template v-for="item in leftMenu">
            <el-submenu v-if="item.childMenuList.length > 0" :index="item.name_zh_CN" :key="item.name_zh_CN">
                <template slot="title"><i class="el-icon-menu"></i>{{item.name_zh_CN}}</template>
                <el-menu-item v-for="itemChild in item.childMenuList" :index="itemChild.name_zh_CN" :key="itemChild.name_zh_CN">{{itemChild.name_zh_CN}}</el-menu-item>
            </el-submenu>
            <el-menu-item v-else :index="item.name_zh_CN" :key="item.name_zh_CN" style="margin:0 30px;"><i class="el-icon-menu"></i>{{item.name_zh_CN}}</el-menu-item>
            </template>
        </el-menu>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  data () {
    return {
      activeIndex: '1',
      leftMenu: []
    }
  },
  created () {
    this.getData()
  },
  methods: {
    getData () {
      this.$http.get(this.library.urlHead + '/menu/search23MenuByFirstMenuId?firstMenuId=3').then(response => {
        this.leftMenu = response.data
        console.log(this.topMenu)
      }).then(blob => {
      })
      console.log('body')
    }
  }
}
</script>
<style scoped>
.body {
  margin-top: 50px; 
  width:70%;
  margin:0 auto;
}
.tac {
  margin-top: 20px;
}
</style>

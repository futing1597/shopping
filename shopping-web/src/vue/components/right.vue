<template>
  <div class="rightCom">
      <el-menu :default-active="activeIndex" router class="el-menu-vertical-demo" >
          <template v-for="item in leftMenu">
          <el-submenu v-if="item.childMenuList.length > 0" :index="item.name_zh_CN" :key="item.name_zh_CN">
              <template slot="title"><i class="el-icon-menu" style="float:left;line-height:56px;"></i>{{item.name_zh_CN}}</template>
              <el-menu-item v-for="itemChild in item.childMenuList" :index="itemChild.name_zh_CN" :key="itemChild.name_zh_CN">{{itemChild.name_zh_CN}}</el-menu-item>
          </el-submenu>
          <el-menu-item v-else :index="item.name_zh_CN" :key="item.name_zh_CN" style="margin:0 10px;"><i class="el-icon-menu" style="float:left;line-height:56px;"></i>{{item.name_zh_CN}}</el-menu-item>
          </template>
      </el-menu>
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
  watch: {
    '$route': 'getData'
  },
  methods: {
    getData () {
      var menuId = this.$route.name.substring(0, 1)
      this.$http.get(this.library.urlHead + '/menu/search23MenuByFirstMenuId?firstMenuId=' + menuId).then(response => {
        this.leftMenu = response.data
      })
    }
  }
}
</script>
<style scoped>
</style>

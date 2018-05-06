<template>
  <div>
    <div style="text-align:left;">
        <div class="wrapper" style="margin-top:30px;">
          <el-button :plain="true" type="info" @click="chooce(1)">服务介绍</el-button>
          <el-button :plain="true" type="info" @click="chooce(2)">AMT的研究</el-button>
          <el-button :plain="true" type="info" @click="chooce(3)">客户方案</el-button>
        </div>
        <div v-if="number === 1" v-html="content" style="margin-top:30px;"></div>
        <div v-else-if="number === 2" v-html="content" style="margin-top:30px;"></div>
        <div v-else-if="number === 3" v-html="content" style="margin-top:30px;"></div>
    </div>
  </div>
</template>
<script>
export default {
  name: '',
  data () {
    return {
      name: '显示文章',
      menuId: '1',
      content: '',
      number: 1
    }
  },
  created () {
    if (this.$route.name) {
      this.menuId = this.$route.name
    }
    this.getData()
  },
  methods: {
    chooce (data) {
      if (data === 1) {
        this.number = 1
        this.getData()
      } else if (data === 2) {
        this.number = 2
        this.getData()
      } else if (data === 3) {
        this.number = 3
        this.getData()
      }
    },
    getData () {
      this.$http.get(this.library.urlHead + '/article/searchArticleByLeafMenuId?leafMenuId=' + this.menuId + '&index=' + (this.number - 1)).then(reply => {
        this.content = reply.data.article_content
      })
    }
  }
}
</script>
<style scoped>
  .title{
    text-align: left;
  }
</style>

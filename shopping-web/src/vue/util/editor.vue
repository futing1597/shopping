<template>
  <div class="hello">
    <el-form :inline="true" style="text-align:left;">
      <el-form-item label="标题">
        <el-input v-model="title" placeholder="标题"></el-input>
      </el-form-item>
    </el-form>
    <vue-html5-editor :content="content" :height="300" @change="updateData"></vue-html5-editor>
    <div  style="margin: 40px 0;">
      <el-button type="info" @click="reset()">重置</el-button>
      <el-button type="info" @click="submit()">提交</el-button>
    </div>
  </div>
</template>
<script>
export default {
  data () {
    return {
      leafMenuId: '30101',
      index: '1',
      title: '',
      content: ''
    }
  },
  methods: {
    updateData (data) {
      this.content = data
    },
    submit () {
      this.$http.post(this.library.urlHead + '/article/insertArticle', {leafMenuId: this.leafMenuId, index: this.index, title: this.title, articleContent: this.content}).then(reply => {
        this.$message('添加成功')
      })
    },
    reset () {
      this.content = ''
    }
  }
}
</script>

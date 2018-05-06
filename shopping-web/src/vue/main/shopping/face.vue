<template>
  <div class="content">
    <div class="first">
        <el-carousel :interval="3000" arrow="always">
        <el-carousel-item v-for="item in items" :key="item.label" :style="'background: url(' + item.img + ') no-repeat left center'">
        </el-carousel-item>
        </el-carousel>
    </div>
    <div class="second">
        <el-row>
          <el-col :span="4" v-for="(o, index) in 5" :key="o" :offset="index > 0 ? 1 : 0">
            <el-tooltip content="时效新闻" placement="top">
              <el-card :body-style="{ padding: '0px' }">
                <img src="/static/images/index/hamburger.png" class="image">
                <div style="padding: 14px;">
                  <span>新闻标题</span>
                  <div class="bottom clearfix">
                    <time class="time">{{ currentDate }}</time>
                    <el-button type="text" class="button">查看新闻</el-button>
                  </div>
                </div>
              </el-card>
            </el-tooltip>
          </el-col>
        </el-row>
    </div>
    <div class="third">
        <el-collapse v-model="activeNames" @change="handleChange">
          <el-collapse-item title="社会温情" name="1">
              <div>控制反馈：通过界面样式和交互动效让用户可以清晰的感知自己的操作；</div>
              <div>页面反馈：操作后，通过页面元素的变化清晰地展现当前状态。</div>
          </el-collapse-item>
          <el-collapse-item title="国家大事" name="2">
              <div>简化流程：设计简洁直观的操作流程；</div>
              <div>清晰明确：语言表达清晰且表意明确，让用户快速理解进而作出决策；</div>
              <div>帮助用户识别：界面简单直白，让用户快速识别而非回忆，减少用户记忆负担。</div>
          </el-collapse-item>
          <el-collapse-item title="经济快线" name="3">
              <div>简化流程：设计简洁直观的操作流程；</div>
              <div>清晰明确：语言表达清晰且表意明确，让用户快速理解进而作出决策；</div>
              <div>帮助用户识别：界面简单直白，让用户快速识别而非回忆，减少用户记忆负担。</div>
          </el-collapse-item>
          <el-collapse-item title="国家政策" name="4">
              <el-row>
                <el-col :span="4" v-for="(o, index) in 5" :key="o" :offset="index > 0 ? 1 : 0">
                  <el-tooltip content="政策标题" placement="top">
                    <el-card :body-style="{ padding: '0px' }">
                      <img src="/static/images/index/hamburger.png" class="image">
                      <div style="padding: 14px;">
                        <span>政策标题</span>
                        <div class="bottom clearfix">
                          <time class="time">{{ currentDate }}</time>
                          <el-button type="text" class="button">查看政策</el-button>
                        </div>
                      </div>
                    </el-card>
                  </el-tooltip>
                </el-col>
              </el-row>
          </el-collapse-item>
        </el-collapse>
    </div>
  </div>
</template>
<script>
export default {
  data () {
    return {
      msg: '',
      currentDate: this.formatDate(new Date(), 'yyyy-MM-dd hh:mm'),
      items: [
        {
          img: '/static/images/index/1.jpg',
          label: 'first'
        }, {
          img: '/static/images/index/2.png',
          label: 'second'
        }, {
          img: '/static/images/index/3.png',
          label: 'third'
        }, {
          img: '/static/images/index/4.jpg',
          label: 'four'
        }, {
          img: '/static/images/index/5.png',
          label: 'five'
        }
      ],
      activeNames: ['1', '2', '3']
    }
  },
  created () {
    let that = this
    document.addEventListener('keydown', function (e) {
      that.$message('fdsa' + e.keyCode)
    })
  },
  filters: {
    formatDate (time) {
      var date = new Date()
      return this.formatDate(date, 'yyyy-MM-dd hh:mm')
    }
  },
  methods: {
    handleChange () {
      console.log('切换')
    }
  }
}
</script>
<style scoped>
.content{
  width:70%;
  margin: 0 auto;
}
.first{
  width:100%;
}
.second{
  width:100%;
  margin-top: 30px;
}
.third{
  text-align: left;
  margin-top: 30px;
}
</style>

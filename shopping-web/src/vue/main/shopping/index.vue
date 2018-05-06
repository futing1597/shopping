<template>
  <div class="contentIndex">
    <el-row>
        <el-col :span="4">
            <rightComponent></rightComponent>
        </el-col>
        <el-col :span="20">
            <div style="margin-left:40px;">
                <router-view></router-view>
            </div>
        </el-col>
    </el-row>
  </div>
</template>

<script>
import rightComponent from '@/vue/components/right.vue'
export default {
  name: '',
  components: {
    rightComponent
  }
}
</script>
<style scoped>
.contentIndex {
  padding-top: 30px; 
  width:70%;
  margin:0 auto;
}
</style>

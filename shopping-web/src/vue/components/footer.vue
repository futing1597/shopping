<template>
  <div class="footer">
    <div class="footerHead">
      <a href="/index">联系我们</a> | <a href="/index">网站声明</a> | <a href="/index">广告合作</a>
    </div>
    <h4>中国网站制作  版权所有</h4>
    <h5>技术支持：网站制作网络有限公司</h5>
    <h6>京ICP证060535号</h6>
  </div>
</template>
<script>
export default {
  data () {
    return {
      name: ''
    }
  }
}
</script>
<style scoped>
.footer{
  margin-top: 50px;
}
.footerHead{
  width:100%;
  height: 40px;
  background-color: rgb(48, 75, 94);
  font-size: 12px;
  color: #fff;
  line-height: 40px;
}
.footerHead a{
  font-size: 12px;
  color: #fff;
}
</style>

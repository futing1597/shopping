<template>
  <div id="app">
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: 'app'
}
</script>

<style>
body {
  height: 100%;
  width: 100%;
  padding: 0px;
  margin: 0px;
}
a {
  text-decoration: none;
  color: #414446;
}
ul {
  padding: 0px;
  margin: 0px;
}
#app {
  height: 100%;
  width: 100%;
  font-family: "微软雅黑",Arial,"宋体";
  -webkit-font-smoothing: antialiased;
  text-align: center;
  color: #2c3e50;
  margin-top: 0px;
}
</style>

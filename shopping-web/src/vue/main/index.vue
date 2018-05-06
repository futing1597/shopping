<template>
  <div>
    <headComponent></headComponent>
    <router-view></router-view>
    <footerComponent></footerComponent>
  </div>
</template>

<script>
import headComponent from '../components/head.vue'
import footerComponent from '../components/footer.vue'
export default {
  name: '',
  components: {
    headComponent,
    footerComponent
  }
}
</script>

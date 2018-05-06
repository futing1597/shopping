// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import VueHtml5Editor from './util/editerhtml5'
import VueResource from 'vue-resource'
import globalProperty from './util/globalProperty.js'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-default/index.css'

/* Vue.config.productionTip = false */
Vue.use(ElementUI)
Vue.use(VueResource)
Vue.use(globalProperty)

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  VueHtml5Editor,
  template: '<App/>',
  components: { App }
})

import Vue from 'vue'
import Router from 'vue-router'
import login from '@/vue/main/login'
import index from '@/vue/main/index'
import face from '@/vue/main/shopping/face'
import shoppingIndex from '@/vue/main/shopping/index'
import ywlcwb from '@/vue/main/shopping/cloudserver/ywlcwb'
import waiter from '@/vue/main/shopping/cloudserver/waiter'

Vue.use(Router)

export default new Router({
  // base: '/Shopping/',
  routes: [
    { path: '/', redirect: '/login' },
    { path: '/login', name: 'login', component: login },
    {
      path: '/index',
      name: 'index',
      component: index,
      redirect: '/face',
      children: [
        // 首页
        { path: '/face', name: 'face', component: face },
        // 关于AMT
        {
          path: '/关于AMT',
          name: '1',
          component: shoppingIndex,
          redirect: '/公司介绍',
          children: [
            { path: '/公司介绍', name: '101', component: waiter },
            { path: '/新闻动态', name: '102', component: waiter },
            { path: '/荣誉资质', name: '103', component: waiter },
            { path: '/AMT团队', name: '104', component: waiter },
            { path: '/AMT大学', name: '105', component: waiter },
            { path: '/投资者关系', name: '106', component: waiter }
          ]
        },
        // 管理信息化咨询
        {
          path: '/综合咨询服务',
          name: '201',
          component: shoppingIndex,
          redirect: '/传统企业互联网转型',
          children: [
            { path: '/传统企业互联网转型', name: '20101', component: waiter },
            { path: '/国企改革', name: '20102', component: waiter },
            { path: '/集团型企业战略落地', name: '20103', component: waiter },
            { path: '/成长型企业战略落地', name: '20104', component: waiter }
          ]
        },
        {
          path: '/管理提升',
          name: '202',
          component: shoppingIndex,
          redirect: '/战略规划及执行保障',
          children: [
            { path: '/战略规划及执行保障', name: '20201', component: waiter },
            { path: '/组织与人力资源优化', name: '20202', component: waiter },
            { path: '/阿米巴经营模式导入', name: '20203', component: waiter },
            { path: '/流程管理', name: '20204', component: waiter },
            { path: '/知识管理', name: '20205', component: waiter },
            { path: '/风险内控管理', name: '20206', component: waiter },
            { path: '/企业文化建设', name: '20207', component: waiter }
          ]
        },
        {
          path: '/信息化咨询',
          name: '203',
          component: shoppingIndex,
          redirect: '/信息化战略规划',
          children: [
            { path: '/信息化战略规划', name: '20301', component: waiter },
            { path: '/大数据战略规划', name: '20302', component: waiter },
            { path: '/IT项目监理', name: '20303', component: waiter },
            { path: '/两化融合贯标', name: '20304', component: waiter }
          ]
        },
        {
          path: '/运营改善',
          name: '204',
          component: shoppingIndex,
          redirect: '/研发与产品规划管理',
          children: [
            { path: '/研发与产品规划管理', name: '20401', component: waiter },
            { path: '/供应链优化', name: '20402', component: waiter },
            { path: '/战略采购管理', name: '20403', component: waiter },
            { path: '/品牌与营销咨询服务', name: '20404', component: waiter },
            { path: '/财务共享中心', name: '20405', component: waiter }
          ]
        },
        {
          path: '/管理培训',
          name: '205',
          component: shoppingIndex,
          redirect: '/企业培训',
          children: [
            { path: '/企业培训', name: '20501', component: waiter },
            { path: '/公开课', name: '20502', component: waiter }
          ]
        },
        // 云服务
        {
          path: '/服务外包',
          name: '301',
          component: shoppingIndex,
          redirect: '/业务流程外包',
          children: [
            { path: '/业务流程外包', name: '30101', component: ywlcwb },
            { path: '/人力资源外包', name: '30102', component: waiter },
            { path: '/IT外包', name: '30103', component: waiter }
          ]
        },
        {
          path: '/云解决方案',
          name: '302',
          component: shoppingIndex,
          redirect: '/云系统规划',
          children: [
            { path: '/云系统规划', name: '30201', component: waiter },
            { path: '/云ERP解决方案', name: '30202', component: waiter }
          ]
        },
        {
          path: '/行业解决方案',
          name: '303',
          component: shoppingIndex,
          redirect: '/创投行业解决方案',
          children: [
            { path: '/创投行业解决方案', name: '30301', component: waiter },
            { path: '/项目型组织综合解决方案', name: '30302', component: waiter }
          ]
        }
      ]
    }
  ]
})

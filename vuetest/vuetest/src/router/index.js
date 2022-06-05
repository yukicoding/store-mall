import Vue from 'vue'
import Router from 'vue-router'
import PageTwo from '../views/PageTwo'
import Find from '../views/Find'
import Update from '../views/Update'
import PageFour from '../views/PageFour'
import Index from '../views/Index'
import Login from '../views/Login'
import Home from '../views/Home'
import Register from "../views/Register";
import Userinfo from '../components/Userinfo'
import aaa from "../views/aaa"
import Order from "../views/Order"
import UpdateOrder from "../views/UpdateOrder"
import  BuyOrder from "../views/order/BuyOrder.vue"
import  PayOrder from "../views/order/PayOrder.vue"

Vue.use(Router)

const routes = [
  {
    path: '/',
    name: '书库管理',
    component: Index,
    redirect: '/Login',
    meta: {
      showNavMenu: true
    },
    children: [
      {
        path: '/Find',
        name: '展示书库',
        component: Find,
        meta: {
          showNavMenu: true
        }
      },
      {
        path: '/PageTwo',
        name: '添加书本',
        component: PageTwo,
        meta: {
          showNavMenu: true
        }
      },
      {
        path: '/Update',
        name: '修改书本',
        component: Update,
        meta: {
          showNavMenu: true
        }
      }
    ]
  },
  {
    path: '/',
    name: '订单管理',
    component: Index,
    meta: {
      showNavMenu: true
    },
    children: [
      {
        path: '/Order',
        name: '订单信息',
        component: Order,
        meta: {
          showNavMenu: true
        }
      },
      {
        path: '/UpdateOrder',
        name: '修改订单',
        component: UpdateOrder,
        meta: {
          showNavMenu: true
        }
      }
    ]
  },
  {
    path: '/',
    name: '个人管理',
    component: Index,
    meta: {
      showNavMenu: true
    },
    children: [
      {
        path: '/PageFour',
        name: '个人信息',
        component: PageFour,
        meta: {
          showNavMenu: true
        }
      }
    ]
  },
  {
    path: '/Login',
    name: '登录',
    component: Login,
    meta: {
      showNavMenu: false
    }
  },
  {
    path: '/Home',
    name: '主页面',
    component: Home,
    meta: {
      showNavMenu: false
    }
  },
  {
    path: '/Register',
    name: '注册页面',
    component: Register,
    meta: {
      showNavMenu: false
    }
  },
  {
    path: '/Userinfo',
    name: '测试',
    component: Userinfo,
    meta: {
      showNavMenu: false
    }
  },
  {
    path: '/aaa',
    name: '登录页面',
    component: aaa,
    meta: {
      showNavMenu: false
    }
  },
  {
    path: '/buyorder',
    name: '购买',
    component: BuyOrder,
    meta: {
      showNavMenu: false
    }
  },
  {
    path: '/payorder',
    name: '支付',
    component: PayOrder,
    meta: {
      showNavMenu: false
    }
  }

]

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes,

})

export default router

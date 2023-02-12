import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import {showToast} from 'vant'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/toregist',
    name: 'toregist',
    component: () => import('../views/RegistView.vue')
  },
  {
    path: '/tologin',
    name: 'tologin',
    component: () => import('../views/LoginView.vue')
  },
  {
    path: '/usercenter',
    name: 'usercenter',
    component: () => import('../views/UserCenterView.vue')
  },
  {
    path: '/details',
    name: 'details',
    component: () => import('../views/DetailsView.vue')
  },
  {
    path: '/attestation',
    name: 'attestation',
    component: () => import('../views/AttestationView.vue')
  }
  
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

router.beforeEach((to,from,next)=>{
  console.log(from);
  let token = localStorage.getItem("token");
  let idCard = localStorage.getItem("idCard");
  let name = localStorage.getItem("name");
  if(token || to.path === '/tologin' || to.path === '/' || to.path === '/toregist') {
    if(to.path === '/usercenter'){
      if(idCard == 'null' || name ==='null'){
        showToast('请先进行实名认证');
        router.push('/attestation');
      }
    }else{
      next();
    }
    
  }else{
    showToast('尚未登录，请登录！');
    next("/tologin");
  }
})

export default router

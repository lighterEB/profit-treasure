import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

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
  }
  
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router

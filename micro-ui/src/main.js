import { createApp } from 'vue'
import App from './App.vue'
import router from './router'

//导入全局CSS
import '@/assets/css/'

createApp(App).use(router).mount('#app')

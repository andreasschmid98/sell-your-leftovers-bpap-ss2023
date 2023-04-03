import HomeView from '../views/HomeView.vue'
import BuyView from "@/views/BuyView.vue"
import ProductView from "@/views/ProductView.vue"
import LoginView from "@/views/LoginView.vue"
import CartView from "@/views/CartView.vue"
import UploadView from "@/views/UploadView.vue"
import MyUploadsView from "@/views/MyUploadsView.vue"
import RegisterView from "@/views/RegisterView.vue"
import {useAuthStore} from "@/stores/auth"
import {createRouter, createWebHistory} from "vue-router"

/**
 * This manages all routes.
 */

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/buy',
    name: 'buy',
    component: BuyView
  },
  {
    path: '/upload',
    name: 'upload',
    component: UploadView
  },
  {
    path: '/product/:id',
    name: 'product',
    component: ProductView
  },
  {
    path: '/login',
    name: 'login',
    component: LoginView
  },
  {
    path: '/register',
    name: 'register',
    component: RegisterView
  },
  {
    path: '/cart',
    name: 'cart',
    component: CartView
  },
  {
    path: '/uploads',
    name: 'uploads',
    component: MyUploadsView
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

router.beforeEach(async (to) => {

  const publicPages = ['/login', '/register']
  const authRequired = !publicPages.includes(to.path)
  const auth = useAuthStore()

  if (authRequired && !auth.user) {
    auth.returnUrl = to.fullPath
    return '/login'
  }
})

export default router

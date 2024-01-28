import { createRouter, createWebHistory } from 'vue-router'
import LoginPage from '../views/LoginPage.vue'
import AppVue from '@/App.vue'
import NewUserVue from '@/views/NewUser.vue'
import WorkSpaceVue from '@/views/WorkSpace.vue'

const User = {
  template: '<div>TEST User {{ $route.params.username }}</div>'
}

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: LoginPage
    },
    {
      path: '/workspace/:user/:role',
      props: true,
      name: 'workspace',
      component: WorkSpaceVue
    },
    {
      path: '/login',
      name: 'login',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('../views/LoginPage.vue')
    },
    {
      path: '/newuser',
      name: 'newuser',
      component: () => import('../views/NewUser.vue')
    },
    {
      path: '/resetpassword',
      name: 'resetpassword',
      component: () => import('../views/PasswordReset.vue')
    },
    {
      path: '/resettedpasswordt',
      name: 'resettedpasswordt',
      component: () => import('../views/PasswordResettedt.vue')
    }
  ]
})

export default router

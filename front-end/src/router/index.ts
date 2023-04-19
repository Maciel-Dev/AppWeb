import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import LoginForm from "@/views/LoginForm.vue";
import RegisterView from "@/views/RegisterView.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView,
      meta:{
        authRequired: 'true',
      },
    },
    {
      path: '/login',
      name: 'login',
      component: LoginForm
    },
    {
      path: '/register',
      name: 'register',
      component: RegisterView
    },
    {
      path: "/:catchAll(.*)", redirect: '/'
    }
  ]
})

// router.beforeEach((to, from, next) => {
//   const publicPages = ['/login', '/register'];
//   const authRequired = !publicPages.includes(to.path);
//   const loggedIn = localStorage.getItem('user');
//
//   if(authRequired && !loggedIn){
//     return next('/login');
//   }
// })

//Criação BeforeEach

export default router

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
        requiresAuth: 'true',
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
});

router.beforeEach(async (to,from, next) => {
  const isAuthenticated = localStorage.getItem("user");
  if(to.meta.requiresAuth && !isAuthenticated){
    next("/login");
  }
  else{
    next();
  }
})

//Criação BeforeEach

export default router

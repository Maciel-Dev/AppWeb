<template>
  <section class="flex flex-col md:flex-row h-screen items-center">

    <div class="bg-indigo-600 hidden lg:block w-full md:w-1/2 xl:w-2/3 h-screen">
      <img src="https://source.unsplash.com/random" alt="" class="w-full h-full object-cover">
    </div>

    <div class="bg-white w-full md:max-w-md lg:max-w-full md:mx-auto md:mx-0 md:w-1/2 xl:w-1/3 h-screen px-6 lg:px-16 xl:px-12
        flex items-center justify-center">

      <div  class="w-full h-100">

        <div v-if="this.error.condition" role="alert">
          <div class="bg-red-500 text-white font-bold rounded-t px-4 py-2">
            Erro de Login
          </div>
          <div class="border border-t-0 border-red-400 rounded-b bg-red-100 px-4 py-3 text-red-700">
            <p>{{this.error.message}}</p>
          </div>
        </div>


        <h1 class="text-xl md:text-2xl font-bold leading-tight mt-12">Log in to your account</h1>

        <form class="mt-6" @submit.prevent="handleLogin">
          <div>
            <label class="block text-gray-700">Username</label>
            <input v-model="user.email" type="text" name="username" id="" placeholder="Enter Username" class="w-full px-4 py-3 rounded-lg bg-gray-200 mt-2 border focus:border-blue-500 focus:bg-white focus:outline-none" autofocus autocomplete required>
          </div>

          <div class="mt-4">
            <label class="block text-gray-700">Password</label>
            <input v-model="user.password" type="password" name="password" id="" placeholder="Enter Password" minlength="1" class="w-full px-4 py-3 rounded-lg bg-gray-200 mt-2 border focus:border-blue-500
                focus:bg-white focus:outline-none" required>
          </div>

          <div class="text-right mt-2">
            <a href="#" class="text-sm font-semibold text-gray-700 hover:text-blue-700 focus:text-blue-700">Forgot Password?</a>
          </div>

          <button type="submit" class="w-full block bg-indigo-500 hover:bg-indigo-400 focus:bg-indigo-400 text-white font-semibold rounded-lg
              px-4 py-3 mt-6">Log In</button>
        </form>

        <hr class="my-6 border-gray-300 w-full">

        <button type="button" class="w-full block bg-white hover:bg-gray-100 focus:bg-gray-100 text-gray-900 font-semibold rounded-lg px-4 py-3 border border-gray-300">
          <div class="flex items-center justify-center">
            <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" class="w-6 h-6" viewBox="0 0 48 48"><defs><path id="a" d="M44.5 20H24v8.5h11.8C34.7 33.9 30.1 37 24 37c-7.2 0-13-5.8-13-13s5.8-13 13-13c3.1 0 5.9 1.1 8.1 2.9l6.4-6.4C34.6 4.1 29.6 2 24 2 11.8 2 2 11.8 2 24s9.8 22 22 22c11 0 21-8 21-22 0-1.3-.2-2.7-.5-4z"/></defs><clipPath id="b"><use xlink:href="#a" overflow="visible"/></clipPath><path clip-path="url(#b)" fill="#FBBC05" d="M0 37V11l17 13z"/><path clip-path="url(#b)" fill="#EA4335" d="M0 11l17 13 7-6.1L48 14V0H0z"/><path clip-path="url(#b)" fill="#34A853" d="M0 37l30-23 7.9 1L48 0v48H0z"/><path clip-path="url(#b)" fill="#4285F4" d="M48 48L17 24l-4-3 35-10z"/></svg>
            <span class="ml-4">
            Log in
            with
            Google</span>
          </div>
        </button>
        <p class="mt-8">Need an account? <a class="text-blue-500 hover:text-blue-700 font-semibold"><router-link :to="{path: `/register`}">Create an
          account</router-link></a></p>
      </div>
    </div>
  </section>
</template>

<script>
import axios from "axios";
import RegisterComponent from "@/components/RegisterComponent.vue";
import User from "@/model/user";
import { login } from "@/service/AuthService";
import { mapMutations } from "vuex";
import {setAuthHeader} from "@/service/AxiosService";


export default {
  name: "Login",
  components: {RegisterComponent},
  data() {
    return {
      user: new User("", "", "", "", "", "", "",),
      loading: false,
      message: '',
      error: {
        condition: false,
        message: ""
      }
    }
  },
  created: function() {
    // Método já faz o redirecionamento ao registrar
    // Reimplementar verificação de login
    // Ao sair de registro, pedir confirmação de login
    if(this.$cookies.get("user")){
      //Todo: Create method on API to only receive token to authenticate user
      this.$router.push({path: "/", props: true});
    }
  },

  methods: {
    ...mapMutations(["setUser"]),
    handleLogin() {
      if(localStorage.getItem("user") != null){
        // Criar funcionalidade de chamada da API para verificação do TOKEN
        // Retornar os dados do usuário
        // Pular carregamento da tela de login
        this.$router.push({path: "/", props: true});
      }
      else{
        login(this.user)
            .then((response) => {
              console.log(response.status)
              if(response.status === 200){
                // localStorage.setItem("user", response.data.token);
                this.$cookies.set("user", response.data.token, 3600);
                this.$cookies.set("user_id", response.data.id_user);
                this.$cookies.set("id_perfil", response.data.id_perfil);
                setAuthHeader(response.data.token) // Determina um cabeçalho padrão para toda requisição
                // Atribuição do TOKEN da API ao usuário
                this.user.token = response.data.token;
                // Construção do Usuário
                this.user.id = response.data.id_user;
                this.setUser(this.user);
                this.user.first_login = response.data.first_login;
                if(this.user.first_login === true){
                  this.$router.push({name: "edit_perfil", params:{id: this.$cookies.get("user_id")}})
                }
                else{
                  this.$router.push({path: "/", props: true});
                }
              }
              else{
                this.error.condition = true;
                this.error.message = "User not Found";
              }
            })
      }
    }
  }
}
</script>

<style scoped>

</style>
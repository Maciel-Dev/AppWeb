<template>

  <!--  <h1>Welcome, {{ userStore.user }}</h1>-->
  asdasdkasf
  <nav class="fixed top-0 z-50 w-full bg-white border-b border-gray-200 dark:bg-gray-800 dark:border-gray-700">
    <div class="px-3 py-3 lg:px-5 lg:pl-3">
      <div class="flex items-center justify-between">
        <div class="flex items-center justify-start">
          <button aria-controls="logo-sidebar"
                  class="inline-flex items-center p-2 text-sm text-gray-500 rounded-lg md:hidden hover:bg-gray-100 focus:outline-none focus:ring-2 focus:ring-gray-200 dark:text-gray-400 dark:hover:bg-gray-700 dark:focus:ring-gray-600"
                  data-drawer-target="logo-sidebar"
                  data-drawer-toggle="logo-sidebar"
                  type="button">
            <span class="sr-only">Open sidebar</span>
            <svg aria-hidden="true" class="w-6 h-6" fill="currentColor" viewBox="0 0 20 20"
                 xmlns="http://www.w3.org/2000/svg">
              <path clip-rule="evenodd"
                    d="M2 4.75A.75.75 0 012.75 4h14.5a.75.75 0 010 1.5H2.75A.75.75 0 012 4.75zm0 10.5a.75.75 0 01.75-.75h7.5a.75.75 0 010 1.5h-7.5a.75.75 0 01-.75-.75zM2 10a.75.75 0 01.75-.75h14.5a.75.75 0 010 1.5H2.75A.75.75 0 012 10z"
                    fill-rule="evenodd"></path>
            </svg>
          </button>
          <a class="flex ml-2 md:mr-24" href="https://flowbite.com">
            <span class="self-center text-xl font-semibold sm:text-2xl whitespace-nowrap dark:text-white">Bem vindo, {{
                userGetter.name
              }}</span>
          </a>
        </div>
        <div class="flex items-center">
          <div class="flex items-center ml-3">
            <new-publication></new-publication>
            <div>
              <Profile>

              </Profile>
            </div>
            <div
                id="dropdown-user"
                class="z-50 hidden my-4 text-base list-none bg-white divide-y divide-gray-100 rounded shadow dark:bg-gray-700 dark:divide-gray-600">
              <div class="px-4 py-3" role="none">
                <p class="text-sm text-gray-900 dark:text-white" role="none">
                  Neil Sims
                </p>
                <p class="text-sm font-medium text-gray-900 truncate dark:text-gray-300" role="none">
                  neil.sims@flowbite.com
                </p>
              </div>
              <ul class="py-1" role="none">
                <li>
                  <a class="block px-4 py-2 text-sm text-gray-700 hover:bg-gray-100 dark:text-gray-300 dark:hover:bg-gray-600 dark:hover:text-white"
                     href="#"
                     role="menuitem">Dashboard</a>
                </li>
                <li>
                  <a class="block px-4 py-2 text-sm text-gray-700 hover:bg-gray-100 dark:text-gray-300 dark:hover:bg-gray-600 dark:hover:text-white"
                     href="#"
                     role="menuitem">Settings</a>
                </li>
                <li>
                  <a class="block px-4 py-2 text-sm text-gray-700 hover:bg-gray-100 dark:text-gray-300 dark:hover:bg-gray-600 dark:hover:text-white"
                     href="#"
                     role="menuitem">Earnings</a>
                </li>
                <li>
                  <a class="block px-4 py-2 text-sm text-gray-700 hover:bg-gray-100 dark:text-gray-300 dark:hover:bg-gray-600 dark:hover:text-white"
                     href="#"
                     role="menuitem">Sign out</a>
                </li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
  </nav>

  <aside id="logo-sidebar"
         aria-label="Sidebar"
         class="fixed top-0 left-0 z-40 w-64 h-screen pt-20 transition-transform -translate-x-full bg-white border-r border-gray-200 sm:translate-x-0 dark:bg-gray-800 dark:border-gray-700">
    <div class="h-full px-3 pb-4 overflow-y-auto bg-white dark:bg-gray-800">
      <ul class="space-y-2">
        <li>
          <a class="flex items-center p-2 text-base font-normal text-gray-900 rounded-lg dark:text-white hover:bg-gray-100 dark:hover:bg-gray-700"
             href="#">
            <svg aria-hidden="true"
                 class="w-6 h-6 text-gray-500 transition duration-75 dark:text-gray-400 group-hover:text-gray-900 dark:group-hover:text-white"
                 fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
              <path d="M2 10a8 8 0 018-8v8h8a8 8 0 11-16 0z"></path>
              <path d="M12 2.252A8.014 8.014 0 0117.748 8H12V2.252z"></path>
            </svg>
            <span class="ml-3">Dashboard</span>
          </a>
        </li>
        <li>
          <a class="flex items-center p-2 text-base font-normal text-gray-900 rounded-lg dark:text-white hover:bg-gray-100 dark:hover:bg-gray-700"
             href="#">
            <svg aria-hidden="true"
                 class="flex-shrink-0 w-6 h-6 text-gray-500 transition duration-75 dark:text-gray-400 group-hover:text-gray-900 dark:group-hover:text-white"
                 fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
              <path
                  d="M5 3a2 2 0 00-2 2v2a2 2 0 002 2h2a2 2 0 002-2V5a2 2 0 00-2-2H5zM5 11a2 2 0 00-2 2v2a2 2 0 002 2h2a2 2 0 002-2v-2a2 2 0 00-2-2H5zM11 5a2 2 0 012-2h2a2 2 0 012 2v2a2 2 0 01-2 2h-2a2 2 0 01-2-2V5zM11 13a2 2 0 012-2h2a2 2 0 012 2v2a2 2 0 01-2 2h-2a2 2 0 01-2-2v-2z"></path>
            </svg>
            <span class="flex-1 ml-3 whitespace-nowrap">Publicações</span>
          </a>
        </li>
        <li>
          <a class="flex items-center p-2 text-base font-normal text-gray-900 rounded-lg dark:text-white hover:bg-gray-100 dark:hover:bg-gray-700"
             href="#">
            <svg aria-hidden="true"
                 class="flex-shrink-0 w-6 h-6 text-gray-500 transition duration-75 dark:text-gray-400 group-hover:text-gray-900 dark:group-hover:text-white"
                 fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
              <path
                  d="M8.707 7.293a1 1 0 00-1.414 1.414l2 2a1 1 0 001.414 0l2-2a1 1 0 00-1.414-1.414L11 7.586V3a1 1 0 10-2 0v4.586l-.293-.293z"></path>
              <path
                  d="M3 5a2 2 0 012-2h1a1 1 0 010 2H5v7h2l1 2h4l1-2h2V5h-1a1 1 0 110-2h1a2 2 0 012 2v10a2 2 0 01-2 2H5a2 2 0 01-2-2V5z"></path>
            </svg>
            <span class="flex-1 ml-3 whitespace-nowrap">Inbox</span>
            <span
                class="inline-flex items-center justify-center w-3 h-3 p-3 ml-3 text-sm font-medium text-blue-800 bg-blue-100 rounded-full dark:bg-blue-900 dark:text-blue-300">3</span>
          </a>
        </li>
        <li>
          <a class="flex items-center p-2 text-base font-normal text-gray-900 rounded-lg dark:text-white hover:bg-gray-100 dark:hover:bg-gray-700"
             href="#">
            <svg aria-hidden="true"
                 class="flex-shrink-0 w-6 h-6 text-gray-500 transition duration-75 dark:text-gray-400 group-hover:text-gray-900 dark:group-hover:text-white"
                 fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
              <path clip-rule="evenodd" d="M10 9a3 3 0 100-6 3 3 0 000 6zm-7 9a7 7 0 1114 0H3z"
                    fill-rule="evenodd"></path>
            </svg>
            <span class="flex-1 ml-3 whitespace-nowrap">Users</span>
          </a>
        </li>
        <li>
          <a class="flex items-center p-2 text-base font-normal text-gray-900 rounded-lg dark:text-white hover:bg-gray-100 dark:hover:bg-gray-700"
             href="#">
            <svg aria-hidden="true"
                 class="flex-shrink-0 w-6 h-6 text-gray-500 transition duration-75 dark:text-gray-400 group-hover:text-gray-900 dark:group-hover:text-white"
                 fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
              <path clip-rule="evenodd"
                    d="M10 2a4 4 0 00-4 4v1H5a1 1 0 00-.994.89l-1 9A1 1 0 004 18h12a1 1 0 00.994-1.11l-1-9A1 1 0 0015 7h-1V6a4 4 0 00-4-4zm2 5V6a2 2 0 10-4 0v1h4zm-6 3a1 1 0 112 0 1 1 0 01-2 0zm7-1a1 1 0 100 2 1 1 0 000-2z"
                    fill-rule="evenodd"></path>
            </svg>
            <span class="flex-1 ml-3 whitespace-nowrap">Products</span>
          </a>
        </li>
        <li>
          <a class="flex items-center p-2 text-base font-normal text-gray-900 rounded-lg dark:text-white hover:bg-gray-100 dark:hover:bg-gray-700"
             href="#">
            <svg aria-hidden="true"
                 class="flex-shrink-0 w-6 h-6 text-gray-500 transition duration-75 dark:text-gray-400 group-hover:text-gray-900 dark:group-hover:text-white"
                 fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
              <path clip-rule="evenodd"
                    d="M3 3a1 1 0 00-1 1v12a1 1 0 102 0V4a1 1 0 00-1-1zm10.293 9.293a1 1 0 001.414 1.414l3-3a1 1 0 000-1.414l-3-3a1 1 0 10-1.414 1.414L14.586 9H7a1 1 0 100 2h7.586l-1.293 1.293z"
                    fill-rule="evenodd"></path>
            </svg>
            <span class="flex-1 ml-3 whitespace-nowrap">Sign In</span>
          </a>
        </li>
        <li>
          <a class="flex items-center p-2 text-base font-normal text-gray-900 rounded-lg dark:text-white hover:bg-gray-100 dark:hover:bg-gray-700"
             href="#">
            <svg aria-hidden="true"
                 class="flex-shrink-0 w-6 h-6 text-gray-500 transition duration-75 dark:text-gray-400 group-hover:text-gray-900 dark:group-hover:text-white"
                 fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
              <path clip-rule="evenodd"
                    d="M5 4a3 3 0 00-3 3v6a3 3 0 003 3h10a3 3 0 003-3V7a3 3 0 00-3-3H5zm-1 9v-1h5v2H5a1 1 0 01-1-1zm7 1h4a1 1 0 001-1v-1h-5v2zm0-4h5V8h-5v2zM9 8H4v2h5V8z"
                    fill-rule="evenodd"></path>
            </svg>
            <span class="flex-1 ml-3 whitespace-nowrap">Sign Up</span>
          </a>
        </li>
        <li>
          <button
              class="flex items-center p-2 text-base font-normal text-gray-900 rounded-lg dark:text-white hover:bg-gray-100 dark:hover:bg-gray-700"
              @click="getPublications">
            <svg aria-hidden="true"
                 class="flex-shrink-0 w-6 h-6 text-gray-500 transition duration-75 dark:text-gray-400 group-hover:text-gray-900 dark:group-hover:text-white"
                 fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
              <path clip-rule="evenodd"
                    d="M5 4a3 3 0 00-3 3v6a3 3 0 003 3h10a3 3 0 003-3V7a3 3 0 00-3-3H5zm-1 9v-1h5v2H5a1 1 0 01-1-1zm7 1h4a1 1 0 001-1v-1h-5v2zm0-4h5V8h-5v2zM9 8H4v2h5V8z"
                    fill-rule="evenodd"></path>
            </svg>
            <span class="flex-1 ml-3 whitespace-nowrap">Update</span>
          </button>
        </li>
      </ul>
    </div>
  </aside>

  <div class="grid h-screen place-items-center ml-30">
    <div class="p-4 mt-14">
      <!-- Put Here -->
      <div class="container">
        <ul>
          <li v-for="item in this.getPublications" :key="item.id">
            <div v-if="item.title != '' ">
              <Card :publication-item="item"/>
            </div>
          </li>
        </ul>
      </div>

    </div>
  </div>


</template>

<script>

import {mapGetters, mapMutations} from "vuex";
// import {getAllProjects} from "@/service/PublicationService";
import {loadUser, logout} from "@/service/AuthService";
import Card from "@/components/Card.vue";
import Profile from "@/components/header/Profile.vue";
import NewPublication from "@/components/back-drop/newPublication.vue";
import {getPublications} from "@/service/PublicationService";
import axios from "axios";
import {setAuthHeader} from "@/service/AxiosService";
// import CardPopup from "@/components/CardPopup/CardPopup.vue";

export default {
  components: {NewPublication, Profile, Card},
  setup() {
    // const userStore = useUserStore;
    // return { userStore };
  },
  data() {
    return {
      user: null,
      info: null,
      publications: {}
    }
  },
  created() {
    // Método para carregar Publicações
    getPublications("evento").then((response) => (this.publications = response.data))
        .then((response) =>
            this.publications = this.publications.map((d) => {
              let publication = {
                id: d.id,
                title: d.title,
                description: d.description,
                data: d.data,
                datetime: d.datetime,
                type: d.type
              };
              this.setPublication(publication);
              return publication;
            }));

    //Verificação de Token
  },
  computed: {
    ...mapGetters([
      'getUser',
      'getPublications'
    ]),

    now() {
      return this.info?.Object;
    },
  },
  methods: {
    ...mapMutations(["setUser", "setPublication"]),
    logout() {
      // Alterar verificação para a Store com o armazenamento do cookie
      if (this.$cookies.get("user")) {
        this.$cookies.remove("user");
        this.setUser("");
        logout();
        // this.$router.push("/login");
      }
    },
    retrievePublications() {
      getPublications("evento").then((response) => (this.publications = response.data))
          .then((response) =>
              this.publications = this.publications.map((d) => {
                let publication = {
                  id: d.id,
                  title: d.title,
                  description: d.description,
                  data: d.data,
                  datetime: d.datetime,
                  type: d.type
                };
                this.setPublication(publication);
                return publication;
              }))
    },
    verifyUser(codeCondition){
      if(codeCondition === 1){
        if (this.$cookies.get("user") != null) {
            setAuthHeader(this.$cookies.get("user")) // Determina o cabeçalho de requisição dos Requests
        }
      }
    },
    userGetter() {
      this.user = this.getUser;
      return this.user;
    },
  },
  mounted() {
    this.verifyUser(1);
  }
};
</script>

<style scoped>

</style>
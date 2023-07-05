<template>

  <div class="w-screen h-14 grid grid-cols-3 bg-blue-500 flex place-items-center">
    <div class="mr-full col-">
      Teste
    </div>
    <button class="text-center justify-center bg-amber-500 rounded-lg w-40 h-10 text-white font-bold hover:bg-amber-700">
      Publicar
    </button>
    <div class="text-center bg-amber-500 rounded-lg w-40">
      Teste
    </div>

  </div>

  <div class="grid h-screen place-items-center ml-30">
    <div class="mt-5">
      <!-- Put Here -->
      <div class="container">
        <ul>
          <li v-for="item in this.getPublications" :key="item.id">
            <div v-if="item.title != '' ">
              <Card class="" :publication-item="item"/>
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
import {logout} from "@/service/AuthService";
import Card from "@/components/Card.vue";
import Profile from "@/components/header/Profile.vue";
import NewPublication from "@/components/back-drop/newPublication.vue";
import {getPublications} from "@/service/PublicationService";
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
    verifyUser(codeCondition) {
      if (codeCondition === 1) {
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
    if (!this.$cookies.get("user")) {
      this.$router.push("/login");
    }
  }
};
</script>

<style scoped>

</style>
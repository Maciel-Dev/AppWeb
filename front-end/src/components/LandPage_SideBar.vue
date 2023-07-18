<template>

  <div class="bg-emerald-700 p-3 grid grid-cols-3 w-screen place-items-center">
    <new-publication class="col-start-2"></new-publication>
    <Profile class="col-start-3 ml-auto mr-6"></Profile>
  </div>

  <div class="grid h-screen place-items-center ml-30">
    <div class="mt-5">
      <!-- Put Here -->
      <div class="container">
        <ul>
          <li v-for="item in this.getPublications" :key="item.id">
            <div v-if="item.title != '' ">
              <Card :publication-item="item" class=""/>
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
    if (this.$cookies.get("user") != null) {
      setAuthHeader(this.$cookies.get("user")) // Determina o cabeçalho de requisição dos Requests
    }
    // Método para carregar Publicações
    getPublications().then((response) => (this.publications = response.data.publication))
        .then((response) =>
            this.publications = this.publications.map((d) => {
              let publication = {
                id: d.id,
                title: d.title,
                description: d.description,
                data: d.data,
                datetime: d.datetime,
                type: d.type,
                like: d.likes
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
      }
    },
    userGetter() {
      this.user = this.getUser;
      return this.user;
    },
  },
  mounted() {
    if (!this.$cookies.get("user")) {
      this.$router.push("/login");
    }
  }
};
</script>

<style scoped>

</style>
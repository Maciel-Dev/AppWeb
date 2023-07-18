<template>

  <div class="bg-emerald-700 p-3 grid grid-cols-3 w-screen place-items-center">
    <new-publication class="col-start-2"></new-publication>
    <Profile class="col-start-3 ml-auto mr-6"></Profile>
  </div>

  <div class="grid-cols-3 grid-rows-3 grid h-screen">
    <div class="rounded-full bg-black w-24 h-24">
      <div class="">
        <p>
          {{ this.profile_id }}
        </p>
      </div>
    </div>
  </div>
</template>

<script>
import Profile from "@/components/header/Profile.vue";
import NewPublication from "@/components/back-drop/newPublication.vue";
import {getPerfil} from "@/service/PerfilService";
import {setAuthHeader} from "@/service/AxiosService";

export default {
  name: "Perfil",
  components: {NewPublication, Profile},
  data() {
    return {
      profile_id: "",
      biography: "",
      birth_date: "",
      gender: "",
    }
  },
  created() {
    if (this.$cookies.get("user") != null) {
      setAuthHeader(this.$cookies.get("user")) // Determina o cabeçalho de requisição dos Requests
    }
    getPerfil(this.$cookies.get("user_id")).then((response) => {
      this.profile_id = response.data.id;
      this.biography = response.data.biography;
      this.birth_date = response.data.birth_date;
      this.gender = response.data.gender;
    })
  }
}
</script>

<style scoped>

</style>
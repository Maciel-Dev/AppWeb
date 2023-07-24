<template>
  <div class="col-span-full perfTitleFont text-blue-500 text-3xl text-center">
    <p> Edição de Perfil </p>
  </div>
  <div class="grid grid-cols-3 grid-rows-3">
    <div class="bg-gray-600 rounded-full w-72 h-72 flex justify-center items-center">
      <img alt="Imagem" class="rounded-full object-scale-down w-48" v-bind:src="img_file"/>
    </div>
    <form @submit.prevent="createProfile">
      <div class="text-center">
        <p>Descreva uma biografia</p>
        <textarea class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                  placeholder="Digite "
                  type="text" v-model="profile.bio"></textarea>
        <div class="mt-10">
          <label class="block mb-2 text-sm font-medium text-gray-900" for="countries">Select an option</label>
          <select id="countries"
                  class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
            <option selected>Escolha o Seu Gênero</option>
            <option value="M">Masculino</option>
            <option value="F">Feminino</option>
            <option value="N">Não quero Informar</option>
          </select>
        </div>
      </div>
      <div class="">
        <button class="float-right text-white bg-blue-500 rounded font-bold w-20 h-10 mt-10" type="submit">Enviar</button>
      </div>
    </form>
  </div>
</template>

<script>
import axios from "axios";
import {setAuthHeader} from "@/service/AxiosService";
import {createPerfil} from "@/service/PerfilService";

export default {
  name: "PerfilForm",
  data() {
    return {
      img_file: '',
      profile: {
        bio: '',
        gen: '',
        id: this.$cookies.get("user_id")
      }
    }
  },
  created() {
    if (this.$cookies.get("user") != null) {
      setAuthHeader(this.$cookies.get("user")) // Determina o cabeçalho de requisição dos Requests
    }
  },

  methods: {
    carregarImagem() {
      axios.get("http://localhost:8082/api/auth/fileUpload/image/" + this.$cookies.get("user_id"), {
        responseType: 'arraybuffer'
      })
          .then(response => {
            this.img_file = URL.createObjectURL(new Blob([response.data], {type: 'image/jpg'}));
          })
          .catch(error => {
            console.error(error);
          });
    },
    createProfile(){
      createPerfil(this.profile).then((response) => {
        if(response.status === 200 || response.status === 201){
          this.$router.push({path: "/", props: true});
        }
      })
    }
  },
  mounted() {
    this.carregarImagem();
  }
}
</script>

<style scoped>

</style>
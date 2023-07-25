<template>
  <div>
    <button
        class="bg-pink-500 text-white active:bg-pink-600 font-bold uppercase text-sm px-6 py-3 rounded-md shadow hover:shadow-lg outline-none focus:outline-none mr-1 mb-1 ease-linear transition-all duration-150"
        type="button" v-on:click="toggleModal()">
      Nova Publicação
    </button>
    <div v-if="showModal"
         class="overflow-x-hidden overflow-y-auto fixed inset-0 z-50 outline-none focus:outline-none justify-center items-center flex">
      <div class="relative w-auto my-6 mx-auto max-w-3xl">
        <!--content-->
        <div
            class="border-0 rounded-lg shadow-lg relative flex flex-col w-full bg-white outline-none focus:outline-none">
          <!--header-->
          <div class="grid flex items-start justify-between p-5 border-b border-solid border-slate-200 rounded-t">
            <h3 class="text-3xl font-semibold">
              Escreva sua nova Publicação, Trocar para VUEX
            </h3>
            <div v-if="pSend" class="bg-red-500 rounded text-white text-center font-bold">
              Aconteceu um erro X (Variável do erro)
            </div>
          </div>
          <!--body-->
          <div class="relative p-6 flex-auto">
            <form @submit.prevent="sendPublication" ref="form">
              <div class="grid grid-cols-2 gap-4">
                <div>
<!--                  <form class="mt-6" @submit.prevent="sendPublication">-->
                    <p class="text-red-500 italic">Título da sua publicação</p>
                    <input
                        id="titulo"
                        v-model="publication.title" class="shadow appearance-none border border-blue-500 rounded w-full py-2 px-3 text-gray-700 mb-3 leading-tight focus:outline-none focus:shadow-outline" placeholder="Minha Publicação" type="text">
                    <p class="text-red-500 italic">Tipo de Publicação</p>
                    <select
                        id="titulo"
                        v-model="publication.type" class="shadow appearance-none border border-blue-500 rounded w-full py-2 px-3 text-gray-700 mb-3 leading-tight focus:outline-none focus:shadow-outline">
                      <option selected>Projeto</option>
                      <option>Evento</option>
                      <option>Mentoria</option>
                    </select>
                    <p class="text-red-500 italic">Descrição da sua publicação</p>
                    <textarea id="descricao" v-model="publication.description" class="block resize-none p-2.5 w-full text-sm text-gray-900 rounded-lg border border-gray-300 focus:ring-blue-500 focus:border-blue-500 dark:border-gray-600 dark:placeholder-gray-400 dark:focus:ring-blue-500 dark:focus:border-blue-500"
                              form="newPubForm"
                              placeholder="Write your thoughts here..." rows="4"></textarea>
<!--                  </form>-->
                </div>
                <div>
                  <label class="block mb-2 text-sm font-medium text-gray-900 dark:text-white" for="file_input">Upload file</label>
                  <input class="block w-full text-sm text-gray-900 border border-gray-300 rounded-lg cursor-pointer bg-gray-50 dark:text-gray-400 focus:outline-none dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400" aria-describedby="file_input_help"  id="files" type="file" ref="uploadImage" @change="onImageUpload()">
                  <p class="mt-1 text-sm text-gray-500 dark:text-gray-300" id="file_input_help">SVG, PNG, JPG or GIF (MAX. 800x400px).</p>
                </div>
              </div>
            </form>
          </div>
          <!--footer-->
          <div class="flex items-center justify-end p-6 border-t border-solid border-slate-200 rounded-b">
            <button
                class="text-red-500 bg-transparent border border-solid border-red-500 hover:bg-red-500 hover:text-white active:bg-red-600 font-bold uppercase text-sm px-6 py-3 rounded outline-none focus:outline-none mr-1 mb-1 ease-linear transition-all duration-150"
                type="button" v-on:click="toggleModal()">
              Sair
            </button>

            <button
                class="text-purple-500 bg-transparent border border-solid border-blue-500 hover:bg-blue-500 hover:text-white active:bg-blue-600 font-bold uppercase text-sm px-6 py-3 rounded outline-none focus:outline-none mr-1 mb-1 ease-linear transition-all duration-150"
                type="submit" v-on:click="sendPublication">
              Publicar
            </button>
          </div>
        </div>
      </div>
    </div>
    <div v-if="showModal" class="opacity-80 fixed inset-0 z-40 bg-black"></div>
  </div>
</template>

<script>
import FileImageButton from "@/components/buttons/fileImageButton.vue";
import {postPublication} from "@/service/PublicationService";
import Publication from "@/model/Publication";
import {mapGetters, mapMutations} from "vuex";

export default {
  name: "newPublication",
  components: {FileImageButton},
  data() {
    return {
      showModal: false,
      publication: new Publication("", "", "", "", "", "", this.$cookies.get("user_id")),
      img_file: null,
      pSend: false,
      user_id: this.$cookies.get("user_id")
    }
  },
  methods: {
    ...mapMutations(["setPublication","setPubSend"]),
    ...mapGetters(["getUser", "getEmailUser", "getPubSend"]),
    toggleModal: function () {
      this.showModal = !this.showModal;
    },
    sendPublication() {
      // Create function to Send data Via FormData
      let PublicationForm = new FormData();
      PublicationForm.append("description", this.publication.description);
      PublicationForm.append("title", this.publication.title);
      PublicationForm.append("data", new Date().getDate().toString());
      PublicationForm.append("type", this.publication.type);
      PublicationForm.append("author", this.publication.author);
      PublicationForm.append("id_perfil", this.$cookies.get("user_id"));
      PublicationForm.append("file_image", this.publication.image_file)
      postPublication(PublicationForm)
          .then((response) => {
            if (response.status === 200 || response.status === 201) {
              this.setPublication(this.publication)
              this.toggleModal();
              this.setPubSend(true);
            }
          });
    },
    onImageUpload(){
      this.publication.image_file = this.$refs.uploadImage.files[0];
    }
  }
}
</script>
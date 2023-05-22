<template>
  <div>
    <button class="bg-pink-500 text-white active:bg-pink-600 font-bold uppercase text-sm px-6 py-3 rounded-md shadow hover:shadow-lg outline-none focus:outline-none mr-1 mb-1 ease-linear transition-all duration-150" type="button" v-on:click="toggleModal()">
      Nova Publicação
    </button>
    <div v-if="showModal" class="overflow-x-hidden overflow-y-auto fixed inset-0 z-50 outline-none focus:outline-none justify-center items-center flex">
      <div class="relative w-auto my-6 mx-auto max-w-3xl">
        <!--content-->
        <div class="border-0 rounded-lg shadow-lg relative flex flex-col w-full bg-white outline-none focus:outline-none">
          <!--header-->
          <div class="flex items-start justify-between p-5 border-b border-solid border-slate-200 rounded-t">
            <h3 class="text-3xl font-semibold">
              Escreva sua nova Publicação, %Adicionar o nome do usuário%
            </h3>
          </div>
          <!--body-->
          <div class="relative p-6 flex-auto">
            <form id="newPubForm">
              <div class="grid grid-cols-2 gap-4">
                <div>
                  <form class="mt-6" @submit.prevent="">
                    <p class="text-red-500 italic">Título da sua publicação</p>
                    <input
                        class="shadow appearance-none border border-blue-500 rounded w-full py-2 px-3 text-gray-700 mb-3 leading-tight focus:outline-none focus:shadow-outline"
                        id="titulo" type="text" placeholder="Minha Publicação">
                    <p class="text-red-500 italic">Tipo de Publicação</p>
                    <select
                        class="shadow appearance-none border border-blue-500 rounded w-full py-2 px-3 text-gray-700 mb-3 leading-tight focus:outline-none focus:shadow-outline"
                        id="titulo">
                      <option selected>Projeto</option>
                      <option>Evento</option>
                      <option>Mentoria</option>
                    </select>
                    <p class="text-red-500 italic">Descrição da sua publicação</p>
                    <textarea id="descricao" form="newPubForm" rows="4"
                              class="block resize-none p-2.5 w-full text-sm text-gray-900 rounded-lg border border-gray-300 focus:ring-blue-500 focus:border-blue-500 dark:border-gray-600 dark:placeholder-gray-400 dark:focus:ring-blue-500 dark:focus:border-blue-500"
                              placeholder="Write your thoughts here..."></textarea>
                  </form>
                </div>
                <div>
                  <img src="https://blog.emania.com.br/wp-content/webp-express/webp-images/doc-root/wp-content/uploads/2016/02/direitos-autorais-e-de-imagem-1024x683.jpg.webp" alt="" class="rounded-3xl">
                  <file-image-button></file-image-button>
                </div>
              </div>
            </form>
          </div>
          <!--footer-->
          <div class="flex items-center justify-end p-6 border-t border-solid border-slate-200 rounded-b">
            <button class="text-red-500 bg-transparent border border-solid border-red-500 hover:bg-red-500 hover:text-white active:bg-red-600 font-bold uppercase text-sm px-6 py-3 rounded outline-none focus:outline-none mr-1 mb-1 ease-linear transition-all duration-150" type="button" v-on:click="toggleModal()">
              Sair
            </button>

            <button class="text-purple-500 bg-transparent border border-solid border-blue-500 hover:bg-blue-500 hover:text-white active:bg-blue-600 font-bold uppercase text-sm px-6 py-3 rounded outline-none focus:outline-none mr-1 mb-1 ease-linear transition-all duration-150" type="button" v-on:click="toggleModal()">
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

export default {
  name: "newPublication",
  components: {FileImageButton},
  data() {
    return {
      showModal: false
    }
  },
  methods: {
    toggleModal: function(){
      this.showModal = !this.showModal;
    },
    sendPublication: function(){

    }
  }
}
</script>
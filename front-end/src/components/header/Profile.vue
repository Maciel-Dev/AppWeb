<template>
  <div class="flex flex-wrap">
    <div class="w-full sm:w-12/12 md:w-12/12 px-4">
      <div class="relative inline-flex align-middle w-full">
        <button class="text-white font-bold uppercase text-sm px-6 py-3 rounded shadow hover:shadow-lg outline-none focus:outline-none mr-1 mb-1 bg-slate-700 ease-linear transition-all duration-150 font-normal px-6 py-2 rounded outline-none focus:outline-none mr-1 mb-1 capitalize w-full" type="button" v-on:click="toggleDropdown()" ref="btnDropdownRef">
          <img v-bind:src="img_file" alt="Imagem" width="50" height="60"/>
        </button>
        <div v-bind:class="{'hidden': !dropdownPopoverShow, 'block': dropdownPopoverShow}" class="bg-white text-base z-50 float-left py-2 list-none text-left rounded shadow-lg mt-1" style="min-width:12rem" ref="popoverDropdownRef">
          <a href="#pablo" class="text-sm py-2 px-4 rounded font-bold block w-full whitespace-nowrap bg-transparent hover:bg-cyan-900 hover:text-neutral-100 text-slate-700">
            Meu Perfil
          </a>
          <a href="#pablo" class="hover:bg-cyan-900 rounded hover:text-neutral-100 text-sm py-2 px-4 font-normal block w-full whitespace-nowrap bg-transparent  text-slate-700">
            Another action
          </a>
          <a class="hover:bg-red-600 rounded hover:text-neutral-100 text-sm py-2 px-4 font-normal block w-full whitespace-nowrap bg-transparent  text-slate-700" @click="userLogout">
            Logout
          </a>
          <div class="h-0 my-2 border border-solid border-t-0 border-slate-800 opacity-25"></div>
          <a href="#pablo" class="text-sm py-2 px-4 font-normal block w-full whitespace-nowrap bg-transparent  text-slate-700">
            Você está logado como <b>{{ retUser }}</b>
          </a>
        </div>
      </div>
    </div>
  </div>
</template>

<script>

import { createPopper } from "@popperjs/core";
import {mapGetters} from "vuex";
import {logout} from "@/service/AuthService";
import axios from "axios";

export default {
  name: "Profile",
  data() {
    return {
      dropdownPopoverShow: false,
      username: "Anonimo",
      img_file: ''
    }
  },
  computed:{
    ...mapGetters(["getUser", "getImg"]),
    retUser(){
      this.username = this.getUser.name;
      return this.username;
    },
    retImage(){
      this.img_file = this.getImg;
      return this.img_file;
    }
  },
  mounted() {
    this.carregarImagem();
  },
  methods: {
    carregarImagem(){
      axios.get("http://localhost:8082/api/auth/fileUpload/image/" + this.getUser.id, {
        responseType: 'arraybuffer'
      })
          .then(response => {
        this.img_file = URL.createObjectURL(new Blob([response.data], { type: 'image/jpg' }));
      })
          .catch(error => {
            console.error(error);
          });
    },
    toggleDropdown: function(){
      if(this.dropdownPopoverShow){
        this.dropdownPopoverShow = false;
      } else {
        this.dropdownPopoverShow = true;
        createPopper(this.$refs.btnDropdownRef, this.$refs.popoverDropdownRef, {
          placement: "bottom-start"
        });
      }
    },
    userLogout() {
      logout();
      this.$router.push({path:"/login"});
    }
  }
}
</script>

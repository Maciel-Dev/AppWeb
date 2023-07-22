<template>
  <div class="fixed grid grid-cols-3 w-screen place-items-end ">
    <div id="popup" class="w-80 h-20 bg-black col-start-3 mr-8 opacity-popup animate-twice animate-duration-[3000ms] animate-ease-out animate-alternate">
      <div class="text-white font-bold text-left">
        Sua Publicação foi realizada com sucesso!
      </div>
    </div>
  </div>
</template>

<script>
import {mapGetters} from "vuex";

export default {
  name: "pubConfirmation",
  computed() {
    if(this.getPubSend()){
      document.querySelector("#popup").classList.add("animate-fade-left");
    }
  },
  methods: {
    ...mapGetters(["getPubSend"]),
    cardShow(){

    }
  }
}
</script>

<style scoped>

</style>
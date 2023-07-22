<template>


  <div class="">
    <a class="grid grid-cols-3 grid-rows-2 mt-2 flex flex-col items-center bg-white border border-gray-200 rounded-lg shadow md:flex-row md:max-w-xl hover:bg-gray-100 dark:border-gray-700 dark:bg-gray-800 dark:hover:bg-gray-700"
       href="#">
<!--      <div class="">-->
<!--        <p class="text-white font-semibold">{{ publicationItem.type }}</p>-->
<!--      </div>-->
      <img alt=""
           class="rounded-t-lg col-span-full row-span-full"
           src="https://blog.unis.edu.br/hubfs/carteirinha-nacional-do-estudante-o-que-e-importante-saber.jpg">
      <div class="flex flex-col justify-between p-4 leading-normal col-span-full">
        <div class="bg-blue-500 w-auto text-center h-auto rounded text-white font-bold">{{publicationItem.type}}</div>
        <h5 class="dis mb-2 text-2xl font-bold tracking-tight text-gray-900 dark:text-white">{{
            publicationItem.title
          }}</h5>

        <p class="mb-3 font-normal text-gray-700 dark:text-gray-400">{{ publicationItem.description }}

        </p>
        <p class="text-white">Likes: {{ publicationItem.like }}</p>
        <p class="text-white">Author: {{  }}</p>
      </div>
    </a>
    <div
        class="grid grid-cols-3 place-items-center bg-white border border-gray-200 rounded-lg shadow dark:border-gray-700 dark:bg-gray-800 dark:hover:bg-gray-700">
      <div class="">
        <heart :publication-item="publicationItem"></heart>
      </div>
      <div class="">
        <donate-button class=""></donate-button>
      </div>
      <div v-if="this.user_id == this.card_id" class="text-red-500">
        <font-awesome-icon :icon="['fas', 'trash']" class="heart" size="2xl" id="animateButton" />
      </div>

    </div>
    <div class="mb-10"></div>
  </div>

</template>

<script>
import {FontAwesomeIcon} from "@fortawesome/vue-fontawesome";
import DonateButton from "@/components/buttons/donateButton.vue";
import Heart from "@/components/icons/heart.vue";

export default {
  name: "Card",
  components: {Heart, DonateButton, FontAwesomeIcon},
  props: ["publicationItem"],
  computed: {
  },
  data() {
    return {
      user_id: this.$cookies.get("user_id"),
      card_id: this.publicationItem.fk_perfil
    }
  },
  mounted() {
  }

}
</script>

<style scoped>

</style>
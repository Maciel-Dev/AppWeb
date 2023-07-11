<template>
  <button class="flex-col rounded text-white" @click="likeClick(publicationItem.id)">
    <font-awesome-icon :icon="['fas', 'heart']" @click="animate" class="heart" size="2xl" id="animateButton" />
  </button>
</template>

<script>
import {FontAwesomeIcon} from "@fortawesome/vue-fontawesome";
import DonateButton from "@/components/buttons/donateButton.vue";
import {likePublication} from "@/service/PublicationService";


export default {
  name: "heart",
  components: {FontAwesomeIcon},
  props: ['publicationItem'],
  methods: {
    animate() {
      this.$el.querySelector("#animateButton").classList.add("animate-jump")
      this.$el.querySelector("#animateButton").classList.add("animate-once")
      this.$el.querySelector("#animateButton").style.color = "red";
      setTimeout(function () {
            document.querySelector("#animateButton").classList.remove("animate-jump")
            document.querySelector("#animateButton").classList.remove("animate-once")
          }, 400
      )
    },
    likeClick(id){
      likePublication(id, "evento");
    }
  }
}
</script>

<style scoped>

</style>
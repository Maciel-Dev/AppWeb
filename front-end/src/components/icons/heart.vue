<template>
  <a class="flex-col" href="#">
    <div id="animateButton" @click="animate">
      <font-awesome-icon :icon="['fas', 'heart']" class="" size="2xl" style="color: #ffffff;"/>
    </div>
  </a>
</template>

<script>
import {FontAwesomeIcon} from "@fortawesome/vue-fontawesome";
import DonateButton from "@/components/buttons/donateButton.vue";
export default {
  name: "heart",
  components: {FontAwesomeIcon},
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
    }
  }
}
</script>

<style scoped>

</style>
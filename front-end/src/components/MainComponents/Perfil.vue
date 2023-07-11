<template>

  <div class="bg-emerald-700 p-3 grid grid-cols-3 w-screen place-items-center">
    <new-publication class="col-start-2"></new-publication>
    <Profile class="col-start-3 ml-auto mr-6"></Profile>
  </div>

  <div class="grid-cols-3 grid-rows-3 grid h-screen">
    <div class="rounded-full bg-black w-24 h-24">
      <div class="text-white">
        <p>
          Teste
        </p>
      </div>
    </div>
  </div>
</template>

<script>
import Profile from "@/components/header/Profile.vue";
import NewPublication from "@/components/back-drop/newPublication.vue";

export default {
  name: "Perfil",
  components: {NewPublication, Profile}
}
</script>

<style scoped>

</style>
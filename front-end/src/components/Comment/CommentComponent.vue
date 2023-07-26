<template>
  <div class="bg-indigo-950 w-72 rounded mt-2 ml-3 grid grid-cols-3 grid-rows-3">
    <div class="row-start-3 col-span-full text-center mt-10">
      <form @submit.prevent="">
        <div class="">
          <input class="rounded mt-10" type="text">
        </div>
        <button type="submit" class="bg-blue-400 rounded w-20 h-8 float float-right mr-14 font-bold text-white mt-3">Comentar</button>
      </form>
    </div>
  </div>
</template>

<script>
export default {
  name: "CommentComponent"
}
</script>

<style scoped>

</style>
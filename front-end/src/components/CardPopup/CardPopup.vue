<template>
  <div class="fixed inset-0 flex items-center justify-center">
    <div class="bg-white p-4 shadow-md rounded-lg">
      <div class="text-lg font-bold">
        <slot name="title"></slot>
      </div>
      <div>
        <slot name="body"></slot>
      </div>
      <div class="mt-4">
        <slot name="footer"></slot>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'CardPopup',
}
</script>
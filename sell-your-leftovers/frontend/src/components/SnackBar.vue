<template>
  <v-snackbar
      v-model="config.show"
      rounded="pill"
      color="orange-darken-1"
  >
    {{ config.description }}
    <template v-slot:actions>
      <v-btn
          color="white"
          icon="mdi-close-circle"
          variant="text"
          @click="config.show = false"
      >
      </v-btn>
    </template>
  </v-snackbar>
</template>

<script>
export default {
  name: "SnackBar",
  props: ['config']
}

</script>

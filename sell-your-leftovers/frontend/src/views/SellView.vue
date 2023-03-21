<template>
  <div class="container my-5">
    <vue-tabs>
      <v-tab title="First tab">
        First tab content
      </v-tab>

      <v-tab title="Second tab">
        Second tab content
      </v-tab>

      <v-tab title="Third tab">
        Third tab content
      </v-tab>
    </vue-tabs>
  </div>

</template>

<script>

import {VueTabs, VTab} from 'vue-nav-tabs'
export default {
  name: 'BuyView',
  components: {
    VueTabs,
    VTab
  }

}
</script>

<style scoped>

</style>
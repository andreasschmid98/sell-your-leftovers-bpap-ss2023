<template>
    <v-app-bar class="bg-orange-darken-1">
      <v-container class="fill-height d-flex align-center">
        <v-btn :to="{ name: 'home'}"  style="text-decoration: none; color: inherit;">Startseite</v-btn>
        <v-btn :to="{ name: 'buy'}" style="text-decoration: none; color: inherit;">Einkaufen</v-btn>
        <v-btn :to="{ name: 'sell'}" style="text-decoration: none; color: inherit;">Verkaufen</v-btn>
        <v-btn :to="{ name: 'faq'}" style="text-decoration: none; color: inherit;">FAQ</v-btn>
      </v-container>
    </v-app-bar>
</template>

<script>
export default {
  name: "NavBar.vue"
}
</script>


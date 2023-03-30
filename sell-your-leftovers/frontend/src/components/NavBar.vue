<template>
    <v-app-bar class="bg-orange-darken-1">
      <v-container class="fill-height d-flex align-center">
        <v-btn :to="{ name: 'home'}"  style="text-decoration: none; color: inherit;">Startseite</v-btn>
        <v-btn :to="{ name: 'buy'}" style="text-decoration: none; color: inherit;">Einkaufen</v-btn>
        <v-btn :to="{ name: 'sell'}" style="text-decoration: none; color: inherit;">Verkaufen</v-btn>
        <v-btn :to="{ name: 'faq'}" style="text-decoration: none; color: inherit;">FAQ</v-btn>
        <v-btn :to="{ name: 'cart'}" style="text-decoration: none; color: inherit;">Einkaufswagen</v-btn>
        <v-btn @click="logout" style="text-decoration: none; color: inherit;">Logout</v-btn>
      </v-container>
    </v-app-bar>
</template>

<script>
import {useAuthStore} from "@/stores/auth";

export default {
  name: "NavBar.vue",
  methods:  {
    logout(){
      useAuthStore().logout()
    }
  }
}
</script>


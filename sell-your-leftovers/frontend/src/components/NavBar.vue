<template>

  <v-app-bar class="bg-orange-darken-1">
    <v-container>
      <v-row>
        <v-btn :to="{ name: 'home'}" style="text-decoration: none; color: inherit;">Startseite</v-btn>
        <v-spacer></v-spacer>
        <v-btn :to="{ name: 'buy'}" style="text-decoration: none; color: inherit;">Einkaufen</v-btn>
        <v-btn :to="{ name: 'upload'}" style="text-decoration: none; color: inherit;">Verkaufen</v-btn>
        <v-spacer></v-spacer>
        <v-btn :to="{ name: 'cart'}" style="text-decoration: none; color: inherit;">
          <v-icon icon="mdi-cart"></v-icon>
        </v-btn>
        <v-menu
            open-on-hover
        >
          <template v-slot:activator="{ props }">
            <v-btn style="text-decoration: none; color: inherit;"
                   v-bind="props"
            >
              <v-icon icon="mdi-account-circle" size="x-large"></v-icon>
            </v-btn>
          </template>
          <v-list>
            <v-list-item>
              <v-list-item-title>
                <router-link :to="{ name: 'uploads'}" style="text-decoration: none; color: inherit;">Meine Produkte
                </router-link>
              </v-list-item-title>
            </v-list-item>
            <v-list-item>
              <v-list-item-title>
                <a type="button" @click="logout" style="text-decoration: none; color: inherit;">Logout</a>
              </v-list-item-title>
            </v-list-item>
          </v-list>
        </v-menu>
      </v-row>
    </v-container>
  </v-app-bar>

</template>

<script>

import {useAuthStore} from "@/stores/auth"

export default {
  name: "NavBar.vue",
  methods: {
    logout() {
      useAuthStore().logout()
    }
  }
}

</script>


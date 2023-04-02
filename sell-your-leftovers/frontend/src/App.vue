<template>

  <v-app>
    <header v-show="!hideNavAndFooter">
      <v-container class="align-center">
        <NavBar/>
      </v-container>
    </header>
    <v-main>
      <v-container>
        <router-view/>
      </v-container>
    </v-main>
    <div class="my-6" v-show="!hideNavAndFooter">
      <FooterBar/>
    </div>
  </v-app>

</template>

<script>

import FooterBar from '@/components/FooterBar.vue'
import NavBar from "@/components/NavBar.vue"

export default {
  name: "App",
  components: {
    FooterBar,
    NavBar
  },
  computed: {
    hideNavAndFooter () {
      return this.$route.path === '/login' || this.$route.path === '/register';
    }
  }
}

</script>



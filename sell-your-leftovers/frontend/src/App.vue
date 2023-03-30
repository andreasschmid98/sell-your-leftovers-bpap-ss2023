<template>
  <v-app>
    <header v-show="!hide">
      <v-container class="align-center">
        <NavBar/>
      </v-container>
    </header>
    <v-main>
      <v-container>
        <router-view/>
      </v-container>
    </v-main>
    <div class="my-6" v-show="!hide">
      <Footer/>
    </div>
  </v-app>

</template>

<script>
import Footer from '@/components/Footer.vue';
import NavBar from "@/components/NavBar.vue";
export default {
  name: "App",
  components: {
    Footer,
    NavBar
  },
  computed: {
    hide () {
      return this.$route.path === '/login' || this.$route.path === '/register';
    }
  }
}
</script>



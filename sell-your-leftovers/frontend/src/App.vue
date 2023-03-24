<template>
  <v-app>
    <v-container class="align-center">
      <NavBar/>
    </v-container>
    <v-main>
      <v-container>
        <router-view/>
      </v-container>
    </v-main>
    <div class="my-6">
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
  }
}
</script>



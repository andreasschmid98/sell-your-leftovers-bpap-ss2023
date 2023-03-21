<template>

  <header>
    <NavBar/>
  </header>
  <main>
    <router-view/>
    <Footer/>
  </main>

</template>

<script>

import Footer from '@/components/Footer.vue';
import NavBar from "@/components/NavBar.vue";

export default {
  name: "App", // Renaming the app so it won't conflict with the child component
  components: {
    Footer,
    NavBar
  }
}

</script>

<style>
html {
  height: 100%;
  box-sizing: border-box;
}

body {
  min-height: 100%;
  position: relative;
  margin: 0;
  padding-bottom: 6rem;
}

</style>

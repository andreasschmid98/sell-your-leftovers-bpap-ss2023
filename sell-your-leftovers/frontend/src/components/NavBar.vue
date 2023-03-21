<template>
  <nav class="navbar navbar-expand px-2 py-3">
    <router-link :to="{ name: 'home'}" class="navbar-brand text-white">Sell Your Leftovers</router-link>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample02" aria-controls="navbarsExample02" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item active">
          <router-link :to="{ name: 'buy'}" class="nav-link text-white" >Einkaufen</router-link>
        </li>
        <li class="nav-item active">
          <router-link :to="{ name: 'sell'}" class="nav-link text-white" >Verkaufen</router-link>
        </li>
        <li class="nav-item">
          <router-link :to="{ name: 'faq'}" class="nav-link text-white">FAQ</router-link>
        </li>
      </ul>
    </div>
  </nav>
</template>

<script>
export default {
  name: "NavBar.vue"
}
</script>

<style scoped>

.navbar{
  background: #5C6BC0;
}

</style>
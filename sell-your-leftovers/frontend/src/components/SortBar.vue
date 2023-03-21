<template>
  <div class="row">
    <div class="col d-flex justify-content-start">
      <div class="dropdown">
        <a id="btn-sort" class="btn btn-outline-dark dropdown-toggle" href="#" role="button"
           data-bs-toggle="dropdown" aria-expanded="false">
          Sortieren nach:
        </a>
        <ul class="dropdown-menu" aria-labelledby="btn-sort">
          <li><a class="dropdown-item"
                 href="#">Preis
            aufsteigend</a></li>
          <li><a class="dropdown-item"
                 href="#">Preis
            absteigend</a></li>
        </ul>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "SortBar"
}
</script>

<style scoped>

</style>
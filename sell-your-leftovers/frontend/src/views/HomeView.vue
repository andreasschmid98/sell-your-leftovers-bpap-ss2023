<template>

  <v-carousel
      cycle
      height="400"
      hide-delimiter-background
      show-arrows="hover"
  >
    <v-carousel-item
        v-for="(slide, i) in slides"
        :key="i"
    >
      <v-sheet
          color="orange-darken-1"
          height="100%"
      >
        <div class="d-flex fill-height justify-center align-center">
          <router-link class="text-h2 text-decoration-none text-white" :to="{ name: links[i] }">
            {{ slide }}
          </router-link>
        </div>
      </v-sheet>
    </v-carousel-item>
  </v-carousel>
  <div class="container marketing">
    <div class="row mt-6">
      <div class="col-lg-4">
        <h2>Sell Your Leftovers.</h2>
        <p>Hast Du wieder einmal zu viele Getränke von der letzten Party übrig und weißt nicht, was Du damit machen
          sollst? Wir von Sell Your Leftovers hätten da eine Idee...</p>
      </div>
      <div class="col-lg-4">
        <h2>Verkaufen statt Vergessen.</h2>
        <p>Bevor Du wieder große Mengen an Leftover-Getränken in Deinem Keller lagerst, um sie zu vergessen, kannst Du
          noch heute damit anfangen, diese zu verkaufen. Egal ob Coca Cola, Jim Beam oder eine Palette Dosenbier.</p>
      </div>
      <div class="col-lg-4">
        <h2>Faire Preise.</h2>
        <p>Auch als Käufer:in bist Du bei uns goldrichtig. Kaufe Deine Lieblingsgetränke für Deinen nächsten Geburtstag
          oder die anstehende Hochzeit zu einem fairen Preis. Damit sparst Du viel Geld und erhältst dennoch die
          gewohnte Qualität.</p>
      </div>
    </div>
  </div>

</template>

<script>

export default {
  name: 'HomeView',
  data() {
    return {
      slides: [
        'Zu viel eingekauft? Jetzt verkaufen.',
        'Günstig einkaufen.',
        'Alle Uploads auf einen Blick.'
      ],
      links: [
        'upload',
        'buy',
        'uploads'
      ]
    }
  }
}

</script>

<style scoped>

.carousel-item > img {
  position: absolute;
  top: 0;
  left: 0;
  min-width: 100%;
  height: 32rem;
}

.marketing .col-lg-4 {
  margin-bottom: 1.5rem;
  text-align: center;
}

.marketing h2 {
  font-weight: 400;
}

.marketing .col-lg-4 p {
  margin-right: .75rem;
  margin-left: .75rem;
}

</style>

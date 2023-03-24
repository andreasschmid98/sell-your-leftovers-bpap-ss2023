<template>
  <v-card>
    <v-tabs
        v-model="tab"
        color="deep-purple-accent-4"
        align-tabs="center"
    >
      <v-tab  v-for="category in categories"
              :key="category"> {{ category.name }}</v-tab>
      <v-tab :value="2">Bestehendes Pro</v-tab>
    </v-tabs>
  </v-card>
</template>

<script>


export default {
  name: 'SellView',
}
</script>

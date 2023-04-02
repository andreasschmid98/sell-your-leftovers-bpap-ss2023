<template>
  <v-menu>
    <template v-slot:activator="{ props }">
      <v-btn
          class="bg-orange-darken-1"
          v-bind="props"
      >
        Sortieren
      </v-btn>
    </template>
    <v-list>
      <v-list-item
          v-for="(item, index) in items"
          :key="index"
          :value="index"
          @click="onSort(item.event)"
      >
        <v-list-item-title>{{ item.order }}</v-list-item-title>
      </v-list-item>
    </v-list>
  </v-menu>
</template>

<script>
export default {
  name: "SortBar",
  data() {
    return {
      items: [
        {order: 'Preis aufsteigend', event: 'price-ascending'},
        {order: 'Preis absteigend', event: 'price-descending'}
      ]
    }
  },
  methods: {
    onSort(event) {
      this.$emit('on-sort', event)
    }
  }
}
</script>


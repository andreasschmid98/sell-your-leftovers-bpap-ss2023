<template>

  <v-card
      class="mx-auto"
      max-width="300"
  >
    <v-list class="bg-orange-darken-1">
      <v-list-item-group>
        <v-list-item @click="onCategory()">
          <v-list-item-title>
            Alle
          </v-list-item-title>
        </v-list-item>
        <v-list-item
            v-for="(category, i) in categories"
            :key="i"
            @click="onCategory(category.categoryType)"
        >
          <v-list-item-title>
            {{ category.name }}
          </v-list-item-title>
        </v-list-item>
      </v-list-item-group>
    </v-list>
  </v-card>

</template>

<script>

import CategoryService from "@/services/CategoryService"

export default {
  name: 'FilterBarView',
  data() {
    return {
      categories: []
    }
  },
  methods: {
    getAllCategories() {
      CategoryService.getAllCategories().then(response => {
        this.categories = response.data
      })
    },
    onCategory(categoryType) {
      this.$emit('on-category', categoryType)
    }
  },
  beforeMount() {
    this.getAllCategories()
  }
}

</script>


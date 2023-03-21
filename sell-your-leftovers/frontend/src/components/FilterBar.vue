<template>
  <ul class="list-group">
    <button type="button" @click="onCategory()" class="btn-category list-group-item list-group-item-action" aria-current="true">Alle</button>
    <button type="button" @click="onCategory(category.categoryType)" class= "btn-category list-group-item list-group-item-action" v-for="category in categories" v-bind:key="category.id">{{ category.name }}</button>
  </ul>
</template>

<script>
import CategoryService from "@/services/CategoryService";

export default {
  name: 'FilterBarView',
  data(){
    return {
      categories: []
    }
  },
  methods: {
    getAllCategories(){
      CategoryService.getAllCategories().then((response) => {
        this.categories = response.data;
      });
    },
    onCategory(categoryType){
      this.$parent.onCategory(categoryType);
    }
  },
  beforeMount() {
    this.getAllCategories()
  }
}
</script>

<style scoped>

</style>
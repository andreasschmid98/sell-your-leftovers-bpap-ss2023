<template>
  <div class="row">
    <div class="col-md-5 col-sm-5 col-xs-12">
      <v-img
          :width="400"
          aspect-ratio="1/1"
          cover
          :src="product.imageUrl"
      ></v-img>
    </div>
    <div class="col-md-7 col-sm-7 col-xs-12">
      <div class="pl-6">
        <p class="display-5 mb-0">{{ product.name }}</p>
        <v-card-actions class="pa-0">
          <p class="h5">{{ product.price }} €</p>
        </v-card-actions>
        <p class="subtitle-1 font-weight-thin">
          {{ product.description }}
        </p>
        <v-select
            v-model="quantity"
            label="Anzahl"
            :items="items"
            variant="solo"
        >
        </v-select>
        <v-btn class="primary white--text" outlined tile dense><v-icon>mdi-cart</v-icon> ADD TO CART</v-btn>
        <v-btn class="ml-4" outlined tile>ADD TO WISHLIST</v-btn>

      </div>
    </div>
  </div>
</template>

<script>

import ProductService from "@/services/ProductService";


export default {
  name: 'ProductView',
  data(){
    return {
      id: null,
      product: null,
      quantity: 1,
      items: []
    }
  },
  methods: {
    initialize(id) {
      ProductService.getProductById(id).then((response) => {
        this.product = response.data;
        this.items = Array.from({length: this.product.quantity}, (x, i) => i + 1)
      });
    },
  },
  beforeMount() {
    this.id = this.$route.params.id,
    this.initialize(this.id)
  }
}

</script>


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
        <div v-if="inCart(product.id)">
        <v-btn
            @click="removeCartItem(product.id)"
            class="bg-grey-lighten-3"
            size="small"
        >
          <v-icon icon="mdi-cart"></v-icon>
          Entfernen
        </v-btn>
      </div>
      <div v-else>
        <v-btn
            @click="addCartItem(product.id)"
            class="bg-orange-darken-1"
            size="small"
        >
          <v-icon icon="mdi-cart"></v-icon>
          Hinzufügen
        </v-btn>
      </div>
      </div>
    </div>
  </div>
</template>

<script>

import ProductService from "@/services/ProductService";
import CartService from "@/services/CartService";


export default {
  name: 'ProductView',
  data(){
    return {
      id: null,
      product: null,
      cartRequest: null,
      cartItems: [],
    }
  },
  methods: {
    getAllCartItems() {
      CartService.getAllCartItems().then((response) => {
        this.cartItems = response.data;
      })
    },
    initialize(id) {
      ProductService.getProductById(id).then((response) => {
        this.product = response.data;
      });
      this.getAllCartItems()
    },addCartItem(productId){

      this.cartRequest= JSON.parse(JSON.stringify({
        productId: productId
      }))

      CartService.addCartItem(this.cartRequest).then(
          this.getAllCartItems
      )

    },
    removeCartItem(productId){

      this.cartRequest= JSON.parse(JSON.stringify({
        productId: productId
      }))


      CartService.removeCartItem(this.cartRequest).then(
          this.getAllCartItems
      )
    },
    inCart(productId){
      return this.cartItems.some(item => item.id === productId);
    },
  },
  beforeMount() {
    this.id = this.$route.params.id
    this.initialize(this.id)
  }
}

</script>


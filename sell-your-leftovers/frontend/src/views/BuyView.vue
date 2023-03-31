<template>
  <v-con>
    <div class="row">
      <div class="col-3 justify-content-end">
        <v-text-field size="small" color="bg-orange-darken-1" class="fill-width" label="Suche" variant="outlined" v-model="searchQuery"></v-text-field>
      </div>
      <div class="col d-flex justify-content-end mt-2">
        <SortBar @on-sort="onSort"/>
      </div>
    </div>
    <v-row>
      <p class="text-muted mx-3" v-if="filteredProducts.length > 0"> {{filteredProducts.length}} Produkte gefunden</p>
      <p class="text-muted mx-3" v-else-if="filteredProducts === 1"> {{filteredProducts.length}} Produkt gefunden</p>
      <p class="text-muted mx-3" v-else>Kein Produkt gefunden</p>
    </v-row>
    <div class="row row-cols-2 mt-4">
      <div class="col-2">
        <FilterBar @on-category="onCategory"/>
      </div>
      <div class="col-10">
        <div class="row gy-4 justify-content-start">
          <div class="col-3" v-for="product in filteredProducts" v-bind:key="product.id">
            <div class="card-home card h-100  text-center ">
              <router-link :to="{ name: 'product', params: { id: product.id }}"><img alt="Card image cap"
                                                                                     id="img-top"
                                                                                     class="card-img-top mt-1"
                                                                                     :src="product.imageUrl"></router-link>
              <div class="card-body">
                <h6 class="card-title text-center text-truncate m-b2"
                >{{ product.name}}</h6>
                <hr>
                <div class="d-flex justify-content-between">
                  <span><small>Preis:</small></span>
                  <span><small class="text-muted">{{ product.price }}</small>
                                            <small class="text-muted"> €</small></span>
                </div>
                <hr>
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
        </div>
      </div>
    </div>
  </v-con>
</template>

<script>

import ProductService from "@/services/ProductService";
import FilterBar from "@/components/FilterBar.vue";
import SortBar from "@/components/SortBar.vue";
import CartService from "@/services/CartService";



export default {
  name: 'BuyView',
  components: {
    FilterBar,
    SortBar
  },
  data() {
    return {
      products: [],
      cartItems: [],
      cartRequest: null,
      searchQuery: ""
    }
  },
  methods: {
    getAllProducts() {
      ProductService.getAllProducts().then((response) => {
        this.products = response.data;
      });
    },
    getAllCartItems() {
      CartService.getAllCartItems().then((response) => {
        this.cartItems = response.data;
      })
    },
    addCartItem(productId){

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
    onSort(event){
      switch (event) {
        case 'price-ascending':
          this.onPriceAscending()
          break
        case 'price-descending':
          this.onPriceDescending()
          break
        default:
          break
      }
    },
    onPriceAscending() {
      this.products = this.products.sort((a, b) => (a.price > b.price) ? 1 : -1)
    },
    onPriceDescending() {
      this.products = this.products.sort((a, b) => (a.price < b.price) ? 1 : -1)
    },
    onCategory(categoryType) {
      this.searchQuery=""
      if (categoryType === undefined) {
        this.getAllProducts();
      } else {
        ProductService.getAllProducts().then((response) => {
          this.products = response.data.filter(product => product.categoryType === categoryType)
        });
      }
    },
  },
  computed:{
    filteredProducts() {
      return this.products.filter( product => product.name.toLowerCase().includes(this.searchQuery.toLowerCase()))
    }
  },
  beforeMount() {
    this.getAllProducts()
    this.getAllCartItems()
  }
}

</script>

<style scoped>

.card-img-top {
  width: 100%;
  height: 15vw;
  object-fit: cover;
}

.card-home:hover {
  -webkit-transform: scale(1.05);
  -moz-transform: scale(1.05);
  -ms-transform: scale(1.05);
  -o-transform: scale(1.05);
  transform: scale(1.05);
  transition: 0.5s all ease 0s;
  -webkit-transition: 0.5s all ease 0s;
  -moz-transition: 0.5s all ease 0s;
  -ms-transition: 0.5s all ease 0s;
}

</style>
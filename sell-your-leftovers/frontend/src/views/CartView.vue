<template>
  <div v-if="cartItems.length === 0">
    <div class="row gy-4 justify-content-center">
      <div class="alert pt-2 w-75" role="alert">
        <h4 class="alert-heading text-center">Dein Warenkorb ist aktuell noch leer!</h4>
        <p class="text-center">In Deinem Einkaufwagen befinden sich aktuell noch keine Produkte. Das kann
          sich aber schon bald ändern!</p>
      </div>
    </div>
  </div>
  <div v-else>
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="card">
        <div class="card-body pt-4">
          <div class="row">
            <div class="col">
              <div class="card mb-3 border-0" v-for="cartItem in cartItems" v-bind:key="cartItem.id">
                <div class="card-body">
                  <div class="d-flex justify-content-between">
                    <div class="d-flex flex-row align-items-center">
                      <div>
                        <img
                            :src="cartItem.imageUrl"
                            class="img-fluid rounded-3" alt="Shopping item"
                            style="height: 65px; width:65px">
                      </div>
                      <div class="ms-3">
                        <h5> {{ cartItem.name}}</h5>
                      </div>
                    </div>
                    <div class="d-flex flex-row align-items-center">
                      <div style="width: 80px;">
                                                <span><span class="text-muted"> {{ cartItem.price }}</span>
                                            <span class="text-muted"> €</span></span>
                      </div>
                      <v-btn
                          @click="removeCartItem(cartItem.id)"
                          class="bg-grey-lighten-3"
                          size="small"
                      >
                        <v-icon icon="mdi-cart"></v-icon>
                        Entfernen
                      </v-btn>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="row d-flex justify-content-center">
            <div class="col text-end">
              <hr>
              <span><strong>Summe: </strong><strong>{{ sum }}</strong>
                                            <strong class="text-muted"> €</strong></span>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="text-center my-4">
      <v-dialog
          v-model="dialog"
          width="auto"
      >
        <template v-slot:activator="{ props }">
          <v-btn
              class="bg-orange-darken-1 mb-3"
              v-bind="props"
              @click="placeOrder"
          >
            Jetzt verbindlich kaufen
          </v-btn>
        </template>

        <v-card>
          <v-card-title>Bestellung erfolgreich</v-card-title>
          <v-card-text>
            Du erhältst eine Email mit allen Details zu Deiner Bestellung!
          </v-card-text>
          <v-card-actions>
            <v-btn color="orange-darken-1" block @click="onBuyMoreProducts">Weiter Einkaufen</v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>
    </div>
  </div>
</template>

<script>

import CartService from "@/services/CartService";
import OrderService from "@/services/OrderService";
import router from "@/router";

export default {
  name: "CartView",
  data() {
    return {
      cartItems: [],
      orderRequest: null,
      sum: 0,
      dialog: false
    }
  },
  methods: {
    getAllCartItems() {
      CartService.getAllCartItems().then((response) => {
        this.cartItems = response.data;
        this.getSum()
      });
    },
    placeOrder() {

      this.orderRequest = JSON.parse(JSON.stringify({
        productIds: this.cartItems.map(({ id }) => id)
      }))

      OrderService.placeOrder(this.orderRequest).then( (response) => {
      })
    },
    removeCartItem(productId){

      this.cartRequest= JSON.parse(JSON.stringify({
        productId: productId
      }))


      CartService.removeCartItem(this.cartRequest).then(
          this.getAllCartItems
      )
    },
    getSum(){
      this.sum = Math.round(this.cartItems.reduce((sum, item) => sum + item.price, 0) * 100) / 100
    },
    onBuyMoreProducts(){
      this.showOrderSuccess = false;
      router.push('buy')
    }
  },
    beforeMount() {
      this.getAllCartItems()
    }

}

</script>

<style scoped>

</style>
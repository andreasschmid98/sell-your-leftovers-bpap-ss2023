<template>
  <div class="row">
    <p class="center display-4">Mein Einkaufswagen</p>
    <p class="center display-6 text-muted pb-4">Alle Einkäufe auf einen Blick:</p>
  </div>
  <div v-if="cartItems.isEmpty">
    <div class="row gy-4 justify-content-center">
      <div class="alert alert-warning pt-2 w-75" role="alert">
        <h4 class="alert-heading text-center">Dein Warenkorb ist aktuell noch leer!</h4>
        <p class="text-center">In Deinem Einkaufwagen befinden sich aktuell noch keine Gemälde. Das kann
          sich aber schon bald ändern!</p>
      </div>
    </div>
  </div>
  <div v-else>
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="card bg-light">
        <div class="card-body pt-4">
          <div class="row">
            <div class="col">
              <div class="card mb-3" v-for="cartItem in cartItems" v-bind:key="cartItem.id">
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
                      <a id="btn-remove-from-cart-cart" class="btn btn-sm btn-danger mx-3">Entfernen
                        <i class="bi bi-trash-fill"></i>
                      </a>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="row d-flex justify-content-center">
            <div class="col text-end">
              <hr>
              <span><strong>Summe: </strong><strong>100</strong>
                                            <strong class="text-muted"> €</strong></span>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="text-center my-4">
      <v-btn
          @click="placeOrder"
          class="bg-orange-darken-1 mb-3"
      >
        Jetzt verbindlich kaufen
      </v-btn>
    </div>
    <p class="text-muted text-center">Deine Rechnung erhältst Du in einer gesonderten E-Mail.</p>
  </div>
</template>

<script>

import CartService from "@/services/CartService";
import OrderService from "@/services/OrderService";

export default {
  name: "CartView",
  data() {
    return {
      cartItems: [],
      orderRequest: null
    }
  },
  methods: {
    getAllCartItems() {
      CartService.getAllCartItems().then((response) => {
        this.cartItems = response.data;
      });
    },
    placeOrder() {

      this.orderRequest = JSON.parse(JSON.stringify({
        productIds: this.cartItems.map(({ id }) => id)
      }))

      OrderService.placeOrder(this.orderRequest)
    }
  },
    beforeMount() {
      this.getAllCartItems()
    }

}

</script>

<style scoped>

</style>
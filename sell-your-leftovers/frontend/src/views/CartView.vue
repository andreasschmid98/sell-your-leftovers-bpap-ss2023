<template>

  <div v-if="cartItems.length === 0">
    <div class="row gy-4 justify-content-center">
      <div class="alert pt-2 w-75" role="alert">
        <h4 class="alert-heading text-center">Dein Warenkorb ist aktuell noch leer!</h4>
        <p class="text-center">In Deinem Einkaufswagen befinden sich aktuell noch keine Produkte. Das kann
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
                    <router-link class="text-decoration-none text-black"
                                 :to="{ name: 'product', params: { id: cartItem.id }}">
                      <div class="d-flex flex-row align-items-center">
                        <img
                            :src="cartItem.imageUrl"
                            class="img-fluid rounded-3" alt="Shopping item"
                            style="height: 65px; width:65px">
                        <div class="ms-3">
                          <h5> {{ cartItem.name }}</h5>
                        </div>
                      </div>
                    </router-link>
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
              <span><strong>Summe: </strong><strong>{{ cartSum }}</strong>
                                            <strong class="text-muted"> €</strong></span>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="text-center my-4">
      <div class="row justify-content-center">
        <div class="col col-3">
          <v-dialog
              v-model="showDialog"
              width="auto"
          >
            <template v-slot:activator="{ props }">
              <v-btn
                  class="bg-orange-darken-1 mb-3"
                  block
                  v-bind="props"
                  @click="order"
              >
                <v-progress-circular
                    v-show="showProgressCircular"
                    indeterminate
                    color="white"
                ></v-progress-circular>
                <span v-show="!showProgressCircular">Jetzt verbindlich kaufen</span>
              </v-btn>
            </template>

            <v-card>
              <v-card-title>{{ dialog.title }}</v-card-title>
              <v-card-text>
                {{ dialog.description }}
              </v-card-text>
              <v-card-actions>
                <v-btn color="orange-darken-1" block @click="onDialogButton"> {{ dialog.buttonDescription }}</v-btn>
              </v-card-actions>
            </v-card>
          </v-dialog>
        </div>
      </div>
    </div>
  </div>

</template>

<script>

import CartService from "@/services/CartService"
import OrderService from "@/services/OrderService"
import router from "@/router"

export default {
  name: "CartView",
  data() {
    return {
      orderFailed: true,
      showDialog: false,
      showProgressCircular: false,
      dialog: {
        title: 'Bestellung fehlgeschlagen',
        description: 'Leider ist etwas schief gelaufen. Du findest Deine Artikel weiterhin in Deinem Einkaufswagen.',
        buttonDescription: 'Verstanden'
      },
      cartItems: [],
      cartRequest: {
        productId: ''
      },
      orderRequest: {
        productIds: []
      },
      cartSum: 0,
    }
  },
  methods: {
    getAllCartItems() {
      CartService.getAllCartItems().then((response) => {
        this.cartItems = response.data
        this.setCartSum()
      })
    },
    async order() {
      this.showDialog = false
      this.showProgressCircular = true

      this.orderRequest.productIds = this.cartItems.map(({id}) => id)

      this.orderFailed = await OrderService.order(this.orderRequest).then(response => {
            if (response.status === 200) {
              console.log("success")
              return false
            }
          }
      ).catch(function (error) {
        if (error.response) {
          return true
        }
      })
      if (!this.orderFailed) {
        this.dialog.title = 'Bestellung erfolgreich'
        this.dialog.description = 'Du erhältst eine Email mit allen Details zu Deiner Bestellung!'
        this.dialog.buttonDescription = 'Weiter einkaufen'
      }
      this.showDialog = true
    },
    removeCartItem(productId) {
      this.cartRequest.productId = productId
      CartService.removeCartItem(this.cartRequest).then(
          this.getAllCartItems
      )
    },
    setCartSum() {
      this.cartSum = Math.round(this.cartItems.reduce((sum, item) => sum + item.price, 0) * 100) / 100
    },
    onDialogButton() {
      if (this.orderFailed) {
        this.showDialog = false
      } else {
        router.push('buy')
      }
    }
  },
  beforeMount() {
    this.getAllCartItems()
  }
}

</script>

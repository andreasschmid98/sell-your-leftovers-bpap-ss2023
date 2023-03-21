<template>
  <div class="container px-4 px-lg-5 my-5">
    <div class="row gx-4 gx-lg-5 justify-content-center">
      <div class="col-md-4"><img class="card-img-top mb-5 px-4" :src="product.imageUrl" width="150" height="300"/></div>
      <div class="col-md-6">
        <h1 class="display-5 fw-bolder">{{ product.name }}</h1>
        <div class="fs-5 mb-4">
          <span>{{ product.price }} € </span>
          <span class="small text-muted">inkl. MwSt.</span>
        </div>
        <p class="lead">{{ product.description }}</p>
        <div class="row">
          <div class="col-2">
            <select class="form-select me-3" v-model="quantity">
              <option v-for="index in product.quantity" :value="index">{{ index }}</option>
            </select>
          </div>
          <div class="col">
            <button class="btn btn-outline-dark flex-shrink-0" type="button">
              <i class="bi-cart-fill me-1"></i>
              In den Einkaufswagen
            </button>
          </div>
        </div>
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
      quantity: 1
    }
  },
  methods: {
    getProductById(id) {
      ProductService.getProductById(id).then((response) => {
        this.product = response.data;
      });
    }
  },
  beforeMount() {
    this.id = this.$route.params.id,
    this.getProductById(this.id)
  }
}

</script>

<style scoped>

</style>
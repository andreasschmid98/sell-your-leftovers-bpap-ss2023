
<template>
  <div class="row justify-content-center">
    <div class="card" style="width: 30rem;">
      <div class="card-body">
        <v-form
            ref="form"
            v-model="valid"
        >
          <v-select
              v-model="category"
              :items="categoryItems"
              :rules="[v => !!v || 'Anzahl ist ein Pflichtfeld']"
              label="Kategorie"
              required
          ></v-select>
          <v-text-field
              v-model="name"
              :rules="nameRules"
              label="Name"
              required
          ></v-text-field>

          <v-text-field
              v-model="description"
              :rules="descriptionRules"
              label="Beschreibung"
              required
          ></v-text-field>

          <v-text-field
              v-model="imageUrl"
              label="Bild-URL"
              required
          ></v-text-field>

          <v-text-field
              v-model="price"
              type="number"
              label="Preis in Euro"
              required
          ></v-text-field>

          <v-select
              v-model="quantity"
              :items="quantityItems"
              :rules="[v => !!v || 'Anzahl ist ein Pflichtfeld']"
              label="Anzahl"
              required
          ></v-select>

          <v-checkbox
              v-model="checkbox"
              :rules="[v => !!v || 'Du musst dem Verkauf zustimmen!']"
              label="Willst Du das Produkt wirklich verkaufen?"
              required
          ></v-checkbox>

          <v-btn
              :disabled="!valid"
              color="success"
              class="mr-4"
              @click="validate"
          >
            Jetzt verkaufen
          </v-btn>

          <v-btn
              color="error"
              class="mr-4"
              @click="reset"
          >
            Zurücksetzen
          </v-btn>
        </v-form>
      </div>
    </div>
  </div>

</template>

<script>

import ProductService from "@/services/ProductService";
import CategoryService from "@/services/CategoryService";


export default {

  name: 'SellView',
  data: () => ({
    valid: true,
    productRequest: null,
    categories: null,
    category: null,
    price: 0,
    quantity: null,
    imageUrl:'',
    name: '',
    nameRules: [
      v => !!v || 'Name ist ein Pflichtfeld',
      v => (v && v.length >= 5) || 'Der Name muss mindestens 5 Zeichen lang sein!',
    ],
    description: '',
    descriptionRules: [
      v => !!v || 'Beschreibung ist ein Pflichtfeld',
      v => (v && v.length >= 30) || 'Die Beschreibung muss mindestes 30 Zeichen lang sein',
    ],
    quantityItems: Array.from({length: 50}, (x, i) => i + 1),
    categoryItems: null,
    checkbox: false
  }),

  methods: {
    initialize(){
      CategoryService.getAllCategories().then((response) => {
        this.categories = response.data;
        this.categoryItems = this.categories.map(({ name }) => name)
      })
    },
    validate () {
      if (this.$refs.form.validate()) {
        console.log("post")
        this.post()
      }
    },
    reset () {
      this.$refs.form.reset()
    },
    post(){
      this.productRequest = JSON.stringify({
        name: this.name,
        skuCode: '121121',
        description: this.description,
        imageUrl: this.imageUrl,
        price: this.price,
        quantity: this.quantity,
        categoryType: this.categories.find( cat => cat.name === this.category).categoryType
      })
      ProductService.createProduct(JSON.parse(this.productRequest))
    }
  },
  beforeMount() {
    this.initialize()
  }
}
</script>

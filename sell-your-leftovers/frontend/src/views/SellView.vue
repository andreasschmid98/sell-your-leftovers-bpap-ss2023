
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
              class="mb-1"
              :items="categoryItems"
              :rules="[v => !!v || 'Anzahl ist ein Pflichtfeld']"
              label="Kategorie"
              required
          ></v-select>
          <v-text-field
              v-model="name"
              :rules="nameRules"
              label="Name"
              class="mb-1"
              required
          ></v-text-field>

          <v-text-field
              v-model="description"
              :rules="descriptionRules"
              class="mb-1"
              label="Beschreibung"
              required
          ></v-text-field>

          <v-text-field
              v-model="imageUrl"
              label="Bild-URL"
              :rules="imageRules"
              class="mb-1"
              required
          ></v-text-field>

          <v-text-field
              v-model="price"
              type="number"
              label="Preis in Euro"
              required
          ></v-text-field>

          <v-checkbox
              v-model="checkbox"
              :rules="[v => !!v || 'Du musst dem Verkauf zustimmen!']"
              label="Willst Du das Produkt wirklich verkaufen?"
              class="mb-2"
              required
          ></v-checkbox>

          <v-dialog
              v-model="dialog.active"
              width="auto"
          >
            <template v-slot:activator="{ props }">
              <v-btn
                  :disabled="!valid"
                  v-bind="props"
                  class="bg-orange-darken-1 mr-4"
                  @click="validate"
              >
                Jetzt verkaufen
              </v-btn>
            </template>

            <v-card>
              <v-card-title>{{ dialog.title }}</v-card-title>
              <v-card-text>
                {{ dialog.description }}
              </v-card-text>
              <v-card-actions>
                <v-btn color="orange-darken-1" block @click="reset">Weiter verkaufen</v-btn>
              </v-card-actions>
            </v-card>
          </v-dialog>

          <v-btn
              @click="reset"
              class="bg-grey-lighten-3"
          >
            Zurücksetzen
          </v-btn>
        </v-form>
      </div>
    </div>
  </div>

</template>

<script>

import CategoryService from "@/services/CategoryService";
import UploadService from "@/services/UploadService";


export default {

  name: 'SellView',
  data: () => ({
    dialog: {
      active: false,
      title: 'Upload fehlgeschlagen',
      description: 'Upload nicht erfolgreich. Bitte versuche es erneut!'
    },
    valid: true,
    productRequest: null,
    categories: null,
    category: null,
    price: 0,
    imageUrl:'',
    imageRules: [
      v => !!v,
      v => /^http[^ \!@\$\^&\(\)\+\=]+(\.png|\.jpeg|\.gif|\.jpg)$/.test(v) || 'Es musss eine gültige Bild-URL angegeben werden!',
    ],
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
        this.post()
      }
    },
    reset () {
      this.dialog.active = false
      this.$refs.form.reset()
    },
    post(){
      this.productRequest = JSON.stringify({
        name: this.name,
        description: this.description,
        imageUrl: this.imageUrl,
        price: this.price,
        categoryType: this.categories.find( cat => cat.name === this.category).categoryType
      })
      UploadService.uploadProduct(JSON.parse(this.productRequest)).then((response) => {
        if (response.status === 201){
          this.dialog.title = 'Upload erfolgreich'
          this.dialog.description = 'Über den Verkauf wirst Du per Email informiert!'
        }
      } )
    }
  },
  beforeMount() {
    this.initialize()
  }
}
</script>

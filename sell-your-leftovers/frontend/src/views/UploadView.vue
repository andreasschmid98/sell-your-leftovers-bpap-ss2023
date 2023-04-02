<template>

  <div class="row justify-content-center">
    <div class="card" style="width: 30rem;">
      <div class="card-body">
        <v-form
            ref="form"
            v-model="validUpload"
        >
          <v-select
              v-model="productRequest.categoryType"
              class="mb-1"
              :items="categoryItems"
              :rules="[v => !!v || 'Anzahl ist ein Pflichtfeld']"
              label="Kategorie"
              required
          ></v-select>
          <v-text-field
              v-model="productRequest.name"
              :rules="[ v => !!v || 'Name ist ein Pflichtfeld']"
              label="Name"
              class="mb-1"
              required
          ></v-text-field>
          <v-text-field
              v-model="productRequest.description"
              :rules="[v => !!v || 'Beschreibung ist ein Pflichtfeld']"
              class="mb-1"
              label="Beschreibung"
              required
          ></v-text-field>
          <v-text-field
              v-model="productRequest.imageUrl"
              label="Bild-URL"
              :rules="imageRules"
              class="mb-1"
              required
          ></v-text-field>
          <v-text-field
              v-model="productRequest.price"
              type="number"
              min="0"
              label="Preis in Euro"
              required
          ></v-text-field>
          <v-checkbox
              v-model="acceptUpload"
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
                  :disabled="!validUpload"
                  v-bind="props"
                  class="bg-orange-darken-1 mr-4"
                  @click="validateUploadForm"
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
                <v-btn color="orange-darken-1" block @click="resetUploadForm">Weiter verkaufen</v-btn>
              </v-card-actions>
            </v-card>
          </v-dialog>
          <v-btn
              @click="resetUploadForm"
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

import CategoryService from "@/services/CategoryService"
import UploadService from "@/services/UploadService"

export default {
  name: 'SellView',
  data() {
    return {
      validUpload: false,
      acceptUpload: false,
      imageRules: [
        v => !!v,
        v => /^http[^ \!@\$\^&\(\)\+\=]+(\.png|\.jpeg|\.gif|\.jpg)$/.test(v) || 'Es musss eine gültige Bild-URL angegeben werden!',
      ],
      categories: [],
      categoryItems: [],
      dialog: {
        active: false,
        title: 'Upload fehlgeschlagen',
        description: 'Es ist ein Fehler unterlaufen. Bitte versuche es erneut!'
      },
      productRequest: {
        name: '',
        description: '',
        imageUrl: '',
        price: 0,
        categoryType: ''
      }
    }
  },
  methods: {
    getAllCategories() {
      CategoryService.getAllCategories().then((response) => {
        this.categories = response.data;
        this.categoryItems = this.categories.map(({name}) => name)
      })
    },
    validateUploadForm() {
      if (this.$refs.form.validate()) {
        this.uploadProduct()
      }
    },
    resetUploadForm() {
      this.dialog.active = false
      this.acceptUpload = false
      this.$refs.form.reset()
    },
    uploadProduct() {
      this.productRequest.categoryType = this.categories
          .find(cat => cat.name === this.productRequest.categoryType)
          .categoryType

      UploadService.uploadProduct(this.productRequest).then((response) => {
        if (response.status === 201) {
          this.dialog.title = 'Upload erfolgreich'
          this.dialog.description = 'Über den Verkauf wirst Du per Email informiert!'
        }
      })
    }
  },
  beforeMount() {
    this.getAllCategories()
  }
}

</script>

<template>
  <div class="row justify-content-center">
    <div class="col col-7">
        <v-table
            fixed-header
            height="600px"
        >
          <thead>
          <tr>
            <th class="text-center">
            </th>
            <th class="text-left">
              Produkt
            </th>
            <th class="text-center">
              Preis
            </th>
            <th class="text-center">
              Verkauft
            </th>
          </tr>
          </thead>
          <tbody>
          <tr
              v-for="upload in uploads"
              :key="upload.id"
          >
            <td class="justify-content-center">
              <v-img
                  :width="100"
                  aspect-ratio="1/1"
                  cover
                  :src="upload.imageUrl"
              ></v-img>
            </td>
            <td class="text-left text-muted mb-1">{{ upload.name }}</td>
            <td class="text-center text-muted mb-1">{{ upload.price }} €</td>
            <td class="text-center mb-1" v-if="upload.available === false"><v-icon icon="mdi-check"></v-icon></td>
            <td class="text-center mb-1" v-else></td>
          </tr>
          </tbody>
        </v-table>
    </div>
  </div>
</template>
<script>
import UploadService from "@/services/UploadService";

export default {
  name: "UploadsView",
  data() {
    return {
      uploads: [],
    }
  },
  methods: {
    getAllUploads() {
      UploadService.getAllUploads().then((response) => {
        this.uploads = response.data;
      });
    }
  },
  beforeMount() {
    this.getAllUploads()
  }
}
</script>

<style scoped>

</style>
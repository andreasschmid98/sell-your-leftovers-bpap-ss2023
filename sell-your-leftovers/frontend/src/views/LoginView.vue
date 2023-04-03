<template>

  <div class="align-center">
    <v-card
        class="mx-auto"
        max-width="500"
    >
      <v-img
          class="align-end"
          height="300"
          width="500"
          src="@/assets/login.jpg"
          cover
      >
      </v-img>
      <v-form
          ref="form"
          class="my-9"
      >
        <v-row class="mx-6">
          <v-text-field
              v-model="user.email"
              label="E-Mail"
              required
          ></v-text-field>
        </v-row>
        <v-row class="mx-6">
          <v-text-field
              v-model="user.password"
              label="Passwort"
              type="password"
              required
          ></v-text-field>
        </v-row>
        <v-row align="center" justify="center">
          <v-btn
              @click="login"
              class="bg-orange-darken-1"
          >
            Login
          </v-btn>
        </v-row>
        <v-row align="center" justify="center" class="mt-7">
              <span class="text-center">Noch kein Account?
                 <router-link class="text-black" :to="{ name: 'register'}"> Hier registrieren! </router-link>
                        </span>
        </v-row>
      </v-form>
    </v-card>
    <SnackBar v-bind:config="snackBarConfig"/>
  </div>

</template>

<script>

import {useAuthStore} from "@/stores/auth"
import SnackBar from "@/components/SnackBar.vue"

export default {
  name: "LoginView",
  components: {SnackBar},
  data() {
    return {
      snackBarConfig: {
        show: false,
        description: 'Email oder Passwort falsch'
      },
      user: {
        email: '',
        password: ''
      },
    }
  },
  methods: {
    login() {

      useAuthStore().login(this.user.email, this.user.password)

      if (!useAuthStore().token) {
        this.snackBarConfig.show = true
      }
    }
  }
}

</script>

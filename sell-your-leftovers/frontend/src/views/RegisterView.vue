<template>
  <div class="row justify-content-center">
    <div class="card" style="width: 30rem;">
      <div class="card-body">
        <v-form
            ref="form"
        >
          <v-text-field
              v-model="registerRequest.firstName"
              label="Vorname"
              required
          ></v-text-field>

          <v-text-field
              v-model="registerRequest.lastName"
              label="Nachname"
              required
          ></v-text-field>

          <v-text-field
              v-model="registerRequest.email"
              label="Email"
              required
          ></v-text-field>

          <v-text-field
              v-model="registerRequest.password"
              label="Passwort"
              required
          ></v-text-field>

          <v-row align="center" justify="center">
            <v-col cols="auto">
              <v-btn
                  @click="register"
                  class="bg-orange-darken-1 mb-3"
              >
                Registrieren
              </v-btn>
            </v-col>
          </v-row>
          <div class="row justify-content-center">
             <span class="text-center">Bereits registriert?
                            <router-link class="text-black" to="{ name: 'register'}"> Hier einloggen! </router-link>
                        </span>
          </div>

        </v-form>
      </div>
    </div>
  </div>
</template>

<script>
import AuthService from "@/services/AuthService";

export default {
  name: "RegisterView",
  data() {
    return {
      registerRequest: {
        firstName: '',
        lastName: '',
        email: '',
        password: ''
      }
    }
  },
  methods: {
    register() {
      AuthService.register(JSON.parse(JSON.stringify({
        firstName: this.registerRequest.firstName,
        lastName: this.registerRequest.lastName,
        email: this.registerRequest.email,
        password: this.registerRequest.password
      }))).then((response) => {
            console.log(response.status)
          }
      )
    }
  }
}

</script>

<style scoped>

</style>
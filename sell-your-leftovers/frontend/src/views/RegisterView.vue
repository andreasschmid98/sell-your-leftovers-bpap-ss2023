<template>
  <div class="align-center" >

    <v-card
        class="mx-auto"
        max-width="500"
    >
      <v-img
          class="align-end"
          height="250"
          width="500"
          src="@/assets/register.jpg"
          cover
      >
      </v-img>
      <v-form
          ref="form"
          class="my-9"
          lazy-validation
      >
        <v-row class="mx-6">
          <v-text-field
              v-model="registerRequest.firstName"
              label="Vorname"
              :rules="[v => !!v || '']"
              required
          ></v-text-field>
        </v-row>

        <v-row class="mx-6">
          <v-text-field
              v-model="registerRequest.lastName"
              label="Nachname"
              :rules="[v => !!v || '']"
              required
          ></v-text-field>
        </v-row>
        <v-row class="mx-6">
          <v-text-field
              v-model="registerRequest.email"
              :rules="emailRules"
              label="Email"
              type="email"
              required
          ></v-text-field>
        </v-row>
        <v-row class="mx-6">
          <v-text-field
              v-model="registerRequest.password"
              :rules="[v => !!v || '']"
              label="Passwort"
              type="password"
              required
          ></v-text-field>
        </v-row>
        <v-row align="center" justify="center">
          <v-btn
              @click="register"
              class="bg-orange-darken-1"
          >
            Registrieren
          </v-btn>
        </v-row>
        <v-row align="center" justify="center" class="mt-7">
              <span class="text-center">Bereits registriert?
                 <router-link class="text-black" :to="{ name: 'login'}"> Hier einloggen! </router-link>
                        </span>
        </v-row>
      </v-form>
    </v-card>
    <v-snackbar
        v-model="showRegisterSuccess"
        rounded="pill"
        color="orange-darken-1"
    >
      Deine Registrierung war erfolgreich! <router-link class="text-white" :to="{ name: 'login'}"> Hier einloggen! </router-link>

      <template v-slot:actions>
        <v-btn
            color="white"
            icon="mdi-close-circle"
            variant="text"
            @click="showRegisterSuccess = false"
        >
        </v-btn>
      </template>
    </v-snackbar>
    <v-snackbar
        v-model="showRegisterFailed"
        rounded="pill"
        color="orange-darken-1"
    >
      Registrierung fehlgeschlagen. Bitte erneut versuchen!
      <template v-slot:actions>
        <v-btn
            color="white"
            icon="mdi-close-circle"
            variant="text"
            @click="showRegisterFailed = false"
        >
        </v-btn>
      </template>
    </v-snackbar>
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
      },
      passwordRules: [v => !!v || ''],
      emailRules: [
        v => !!v,
        v => /^(([^<>()[\]\\.,;:\s@']+(\.[^<>()\\[\]\\.,;:\s@']+)*)|('.+'))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test(v) || '',
      ],
      showRegisterSuccess: false,
      showRegisterFailed: false,
      valid: false
    }
  },
  methods: {
    register() {

      this.$refs.form.validate().then( response => {

        if (response.valid) {
          AuthService.register(JSON.parse(JSON.stringify({
            firstName: this.registerRequest.firstName,
            lastName: this.registerRequest.lastName,
            email: this.registerRequest.email,
            password: this.registerRequest.password
          }))).then((response) => {
                if(response.status === 201) {
                  this.showRegisterSuccess = true
                } else {
                  this.showRegisterFailed = true
                }
              }
          )
        } else {
          this.showRegisterFailed = true
        }
      })

    }
  }
}

</script>

<style scoped>

</style>
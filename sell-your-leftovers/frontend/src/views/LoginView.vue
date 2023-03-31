<template>
  <div class="align-center" >

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
    <v-snackbar
        v-model="showLoginFailed"
        rounded="pill"
        color="orange-darken-1"
    >
      E-Mail oder Passwort falsch. Bitte erneut versuchen
      <template v-slot:actions>
        <v-btn
            color="white"
            icon="mdi-close-circle"
            variant="text"
            @click="showLoginFailed = false"
        >
        </v-btn>
      </template>
    </v-snackbar>
    </div>
</template>

<script>
import {useAuthStore} from "@/stores/auth";
export default {
  name: "LoginView",
  data() {
    return {
      user: {
        email: '',
        password: ''
      },
      showLoginFailed: false
    }
  },
  methods: {
    login(){
      if (this.user.email !== '' && this.user.password !== '') {
        useAuthStore().login(this.user.email, this.user.password)
      }
      console.log(useAuthStore().token)
      if (!useAuthStore().token){
        this.showLoginFailed = true
      }
    }
  }
}
</script>

<style scoped>
</style>
import {createApp} from 'vue'
import App from './App.vue'
import router from './router'
import {createPinia} from "pinia";
import vuetify from './plugins/vuetify'
import {loadFonts} from './plugins/webfontloader'
import 'bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css'
import piniaPluginPersistedstate from 'pinia-plugin-persistedstate'

loadFonts()

const pinia = createPinia()
pinia.use(piniaPluginPersistedstate)

createApp(App)
    .use(router)
    .use(vuetify)
    .use(pinia)
    .mount('#app')

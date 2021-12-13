import Vue from 'vue'
import App from './App.vue'
import router from './router/index'
import store from './store/index'
import axios from 'axios'
import * as VueGoogleMaps from "vue2-google-maps"
import Geocoder from "@pderas/vue2-geocoder";

Vue.config.productionTip = false

axios.defaults.baseURL = process.env.VUE_APP_REMOTE_API;

Vue.use(VueGoogleMaps, {
  load: {
    key: "AIzaSyASVTWiCp6rjLMiqh6az1jpvtW3iYGMPT8",
    libraries: "places"
  }
}),

Vue.use(Geocoder, {
  defaultCountryCode: null, // e.g. 'CA'
  defaultLanguage:    null, // e.g. 'en'
  defaultMode:        'address', // or 'lat-lng'
  googleMapsApiKey: "AIzaSyASVTWiCp6rjLMiqh6az1jpvtW3iYGMPT8"
})

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')

import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import './assets/tailwind.css'
import store from "@/store";
import VueCookies from "vue-cookies";
/* import font awesome icon component */
import { library } from '@fortawesome/fontawesome-svg-core'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
import { faUserSecret, faDoorOpen, faHeart } from '@fortawesome/free-solid-svg-icons'

const app = createApp(App);

library.add(faUserSecret);
library.add(faDoorOpen);
library.add(faHeart);

app.use(router);
app.use(store);
app.use(VueCookies);
app.component("font-awesome-icon", FontAwesomeIcon);
app.mount('#app')

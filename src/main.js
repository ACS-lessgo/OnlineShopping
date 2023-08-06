import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import HomeView from './views/HomeView.vue'
import LoginView from './views/LoginView.vue'
import CartView from './views/CartView.vue'
const app = createApp(App)

app.use(router)
app.mount('#app')
app.component('home-view', HomeView)
app.component('login-view', LoginView)
app.component('cart-view', CartView)

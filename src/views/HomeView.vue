<template>
  <div>
    <div class="row">
      <CardComponent
        v-for="product in products"
        :key="product.id"
        :product="product"
        :cart="cart"
        @add-to-cart="addToCart"
      ></CardComponent>
    </div>
  </div>
</template>

<script>
import products from '../products.json'
import CardComponent from '@/components/CardComponent.vue'

export default {
  name: 'HomeView',
  components: {
    CardComponent
  },
  data () {
    return {
      products: [],
      cart: []
    }
  },
  async mounted () {
    this.products = products
    this.loadCartFromLocalStorage()
  },
  methods: {
    addToCart (product) {
      this.cart.push(product)
      this.updateCartInLocalStorage()
    },
    removeFromCart (index) {
      this.cart.splice(index, 1)
      this.updateCartInLocalStorage()
    },
    updateCartInLocalStorage () {
      localStorage.setItem('cart', JSON.stringify(this.cart))
    },
    loadCartFromLocalStorage () {
      const cartData = localStorage.getItem('cart')
      if (cartData) {
        try {
          this.cart = JSON.parse(cartData)
        } catch (error) {
          console.error('Error parsing cart data from Local Storage:', error)
        }
      }
    }
  }
}
</script>

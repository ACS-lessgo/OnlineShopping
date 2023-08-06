<template>
  <div class="mycart">
    <h1 id="title">Cart</h1>
    <table class="cart-table" v-if="cartData.length > 0">
      <thead>
        <tr>
          <th>Product</th>
          <th>Price</th>
          <th></th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(item, index) in cartData" :key="index">
          <td>{{ item.product_name }}</td>
          <td>{{ item.price }}$</td>
          <td>
            <button @click="removeFromCart(index)">Remove</button>
          </td>
        </tr>
      </tbody>
      <tfoot>
        <tr>
          <td colspan="2">Total:</td>
          <td>{{ total.toFixed(2) }}$</td>
        </tr>
      </tfoot>
    </table>
    <div v-else>
      <p>Your cart is empty.</p>
    </div>
    <div class="checkout-container">
      <button class="checkout-button" @click="checkOut()">Check Out</button>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    cart: {
      type: Array,
      default: () => []
    }
  },
  data () {
    return {
      cartData: []
    }
  },
  computed: {
    total () {
      return this.cartData.reduce((acc, item) => acc + item.price, 0)
    }
  },
  created () {
    this.loadCartFromLocalStorage()
  },
  methods: {
    removeFromCart (index) {
      this.cartData.splice(index, 1)
      this.updateCartInLocalStorage()
      this.$emit('remove-from-cart', index)
    },
    updateCartInLocalStorage () {
      localStorage.setItem('cart', JSON.stringify(this.cartData))
    },
    logReceivedCart () {
      console.log('Received Cart:', this.cartData)
    },
    loadCartFromLocalStorage () {
      const cartData = localStorage.getItem('cart')
      if (cartData) {
        try {
          this.cartData = JSON.parse(cartData)
        } catch (error) {
          console.error('Error parsing cart data from Local Storage:', error)
        }
      }
    },
    checkOut () {
      this.cartData = []
      localStorage.removeItem('cart')
      alert('Thank you purchasing here ....')
    }
  }
}
</script>

<style>
.mycart{
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 70%;
  margin: 8% auto;
  padding: 20px;
  border-radius: 10px;
  box-shadow: 0 0 5px rgba(0, 0, 0, 0.2);
  background-color: #f3e5f5;
}
#title{
  color: purple;
}
.cart-table {
  border-collapse: collapse;
  width: 100%;
}

.cart-table th,
.cart-table td {
  border: 1px solid #916dd5;
  padding: 8px;
  text-align: left;
}

.cart-table th {
  background-color: purple;
  color: #fff;
}

.cart-table tfoot td {
  font-weight: bold;
}

.checkout-container {
  display: flex;
  justify-content: center;
  margin-top: 20px;
}

.checkout-button {
  background-color:purple;
  color: #fff;
  border: none;
  padding: 10px 20px;
  font-size: 16px;
  cursor: pointer;
}

.checkout-button:hover {
  background-color:  rgb(44, 7, 44);
}

.checkout-button:focus {
  outline: none;
}

h1 {
  color: #673ab7;
}

p {
  color: #673ab7;
}
</style>

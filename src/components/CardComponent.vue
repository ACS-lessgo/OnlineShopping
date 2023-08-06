<template>
  <div class="card">
    <img class="card-img-top" :src="product.image_url" alt="Card image cap" />
    <div class="card-body">
      <h5 class="card-title">{{ product.product_name }}</h5>
      <h5 class="card-price">{{ product.price }}$</h5>
      <p class="card-text">{{ product.description }}</p>
      <a class="btn btn-primary" @click="addToCart">Add to cart</a>
    </div>
  </div>
</template>

<script>
export default {
  props: ['product', 'cart'],
  methods: {
    addToCart () {
      this.$emit('add-to-cart', this.product)
    }
  }
}
</script>

<style>
        .card {
            width: 18rem;
            margin-top: 5%;
            margin-left: 15%;
            margin-bottom: 10%;
        }
        .card-price{
            color:darkorchid
        }
</style>

<template>
    <nav class="navbar navbar-expand-lg navbar-dark" id="indexnav">
      <router-link class="navbar-brand" to="/">Emart</router-link>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup"
            aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
              <router-link class="nav-item nav-link" to="/login">Login</router-link>
              <router-link  class="nav-item nav-link" to="/products">Products</router-link>
              <router-link  class="nav-item nav-link" to="/cart">Cart</router-link>
            </div>
        </div>
    </nav>
  <router-view/>
</template>

<style lang="scss">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  background-color:purple;
  padding: 10px;
  text-align: center;
}
navbar-nav{
  margin-left: 50%;
}
router-link {
  color: #fff;
  text-decoration: none;
  padding: 5px;
}
</style>

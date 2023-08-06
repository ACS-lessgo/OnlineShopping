<template>
  <div id="apps">
    <div class="loginbody">
      <h1 :style="{ color: 'Purple'}">Sign Up Here ....</h1><br>
    <form class="form1">
      <div class="form-group ">
        Enter your name here: <input v-model="name" placeholder="Enter your name here"><br>
        <span v-if="name.length < 8" class="ss">Username should be at least 8 characters.</span><br><br>
      </div>

      <div class="form-group ">
        Enter your age here: <br><input v-model="number"><br>
        <span v-if="number < 18" class="ss">Age should be at least 18.</span><br><br>
      </div>

      <div class="form-group ">
        Enter your email here: <input v-model="email" placeholder="Enter your email here" type="email"><br>
        <span v-if="!isValidEmail" class="ss">Enter a valid mail</span><br><br>
      </div>

      <button @click.prevent="validate" class="btn btn-primary">Create Account</button>
    </form>
    </div>

  </div>
</template>

<script>
import { ref, computed } from 'vue'

export default {
  setup () {
    const myDetails = ref([])
    const name = ref('')
    const number = ref(0)
    const email = ref('')
    const isValidEmail = computed(() => {
      const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/
      return emailRegex.test(email.value)
    })

    const validate = () => {
      if (number.value > 18 && name.value.length && isValidEmail.value) {
        alert('Created an account successfully')
      }
    }

    return {
      myDetails,
      name,
      number,
      email,
      isValidEmail,
      validate
    }
  }
}
</script>

<style>
#apps{
  font-family: Arial, sans-serif;
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
}
.loginbody {
  background-color: #f0f0f0;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  max-width: 400px;
  padding: 20px;
  background-color: #fff;
  border-radius: 5px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
}

.form-group {
  margin-bottom: 20px;
}

.form-group span {
  color: purple;
}

.btn {
  padding: 10px 20px;
  background-color: purple;
  color: #fff;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.ss {
  font-size: 0.8rem;
}
</style>

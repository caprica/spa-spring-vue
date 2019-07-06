<template>
  <div>
    <h1>VueJS Client Routing and SpringMVC Server Routing.</h1>
    <span><router-link class="App-link" to="/users">Users</router-link> | <router-link class="App-link" to="/no/such/route">No Such Route</router-link></span>
  </div>
</template>

<script>
// @ is an alias to /src
//import HelloWorld from '@/components/HelloWorld.vue'

export default {
  name: 'home',
  components: {
  }
}
</script>

<style>
</style>
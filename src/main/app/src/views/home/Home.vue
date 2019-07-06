<template>
  <div class="home">
    <img alt="Vue logo" class="App-logo" src="../../assets/logo.png">
    <HelloWorld msg="VueJS Client Routing and SpringMVC Server Routing."/>
    <span><router-link to="/users">Users</router-link> | <router-link to="/no/such/route">No Such Route</router-link></span>
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'

export default {
  name: 'home',
  components: {
    HelloWorld
  }
}
</script>

<style>
.App-logo {
  animation: App-logo-spin infinite 20s linear;
  height: 40vmin;
  pointer-events: none;
}
@keyframes App-logo-spin {
  from {
    transform: rotate(0deg);
  }
  to {
    transform: rotate(360deg);
  }
}
</style>
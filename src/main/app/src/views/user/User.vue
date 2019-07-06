<template>
  <div>
    <h1>User {{ $route.params.username }}</h1>
    <table>
      <thead>
        <tr>
          <th>Username</th>
          <th>Name</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>{{ user.username }}</td>
          <td>{{ user.name }}</td>
        </tr>
      </tbody>
    </table>
    <p v-show="loading" key="loading">Fetching user {{ $route.params.username }}...</p>
    <p v-show="error" key="error">Failed to load user: {{ error.message }}</p>
    <br>
    <span><router-link class="App-link" to="/">Home</router-link> | <router-link class="App-link" to="/users">Users</router-link></span>
  </div>
</template>

<script>
const serviceUrl = '/api/users'

export default {
  name: "",
  components: {
  },
  mounted() {
    this.getUser(this, this.$route.params.username)
  },
  data: function() {
    return {
      loading: false,
      error: '',
      user: []
    }
  },
  methods: {
    getUser: async(component, username) => {
      component.error = ''
      component.loading = true
      try {
        const response = await fetch(`${serviceUrl}/${username}`)
        switch (response.status) {
          case 200: {
            const data = await response.json()
             component.user = data
             component.loading = false
             break;
          }
          case 404:
            throw new Error('Not found')
          default:
            throw new Error(`Unexpected response ${response.status}`)
        }
      } catch (error) {
        component.loading = false
        component.error = error
      }
    }
  }
}
</script>

<style scoped>
</style>

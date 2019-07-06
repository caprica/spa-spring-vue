<template>
  <div>
    <h1>Users</h1>
      <table>
        <thead>
          <tr>
            <th>Username</th>
            <th>Name</th>
          </tr>
        </thead>
      <tbody>
        <tr v-for="user in users" :key="user.username">
          <td><router-link :to="{path: `/users/${user.username}`}">{{ user.username }}</router-link></td>
          <td>{{ user.name }}</td>
        </tr>
      </tbody>
    </table>
    <p v-show="loading" key="loading">Fetching users...</p>
    <br>
    <span><router-link to="/">Home</router-link></span>
  </div>
</template>

<script>
const serviceUrl = '/api/users'

export default {
  name: "",
  components: {
  },
  mounted() {
    this.getUsers(this)
  },
  data: function() {
    return {
      loading: false,
      users: []
    }
  },
  methods: {
    getUsers: async(component) => {
      component.loading = true
      try {
        const response = await fetch(serviceUrl)
        switch (response.status) {
          case 200: {
            const data = await response.json()
            component.users = data
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

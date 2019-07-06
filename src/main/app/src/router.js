import Vue      from 'vue'
import Router   from 'vue-router'

import Home     from './views/home/Home.vue'
import NotFound from './views/not-found/NotFound.vue'
import User     from './views/user/User.vue'
import Users    from './views/users/Users.vue'

Vue.use(Router)

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home
    },
    {
      path: '/index.html',
      redirect: '/'
    },
    {
      path: '/users',
      name: 'users',
      component: Users
    },
    {
      path: '/users/:username',
      name: 'user',
      component: User
    },
    {
      path: '*',
      name: 'not-found',
      component: NotFound
    }
  ]
})

import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Logout from '../views/Logout.vue'
import Register from '../views/Register.vue'
import store from '../store/index'
import Welcome from '../views/Welcome.vue'
import Contact from '../views/Contact.vue'
import About from '../views/About.vue'
import Properties from '../views/Properties.vue'
import PayRent from '../components/PayRent.vue'
import Application from '../components/Application.vue'
import PropertyDetail from '../views/PropertyDetail'
import Email from '../components/Email.vue'
import Units from '../views/Units.vue'

Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/login",
      name: "login",
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/logout",
      name: "logout",
      component: Logout,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register",
      name: "register",
      component: Register,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/welcome",
      name: "welcome",
      component: Welcome,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/contact",
      name: "contact",
      component: Contact,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/about",
      name: "about",
      component: About,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/properties",
      name: "properties",
      component: Properties,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/properties/:unitID", // /properties/propertyId/units
      name: "propertyDetail",
      component: PropertyDetail,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/payment",
      name: "payment",
      component: PayRent,
      // false for now, but might need to change
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/application/:unitID?",
      name: "application",
      component: Application,
      meta: {
        requiresAuth: false
      }
    }, 
    {
    path: "/email",
    name: "email",
    component: Email,
    meta: {
      requiresAuth: false
    }
    },
    {

    path: "/properties/:propertyId/units",
      name: "units",
      component: Units,
      meta: {
        requiresAuth: false
      }
    }
  ]
})

router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    next("/login");
  } else {
    // Else let them go to their next destination
    next();
  }
});

export default router;

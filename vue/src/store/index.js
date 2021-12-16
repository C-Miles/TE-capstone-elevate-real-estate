import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));
let userRole = '';

if (currentToken == null) {
  userRole = '';
} else {
  userRole = currentUser.authorities[0].name; //ROLE_USER or ROLE_ADMIN
}

if(currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
    properties: [],
    role: userRole,
    activeUnitID: 0,
    filter: 0
  },
  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user',JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    },
    SET_PROPERTIES(state, properties) {
      state.properties = properties;
    },
    SET_ACTIVE_PROPERTY (state, unitID) {
      state.activeUnitID = unitID;
    }
   // ADD_PROPERTY(state, property) {
   //   state.properties.push(property);
  //  }
    
  }
})

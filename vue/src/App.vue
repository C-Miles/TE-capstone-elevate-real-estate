<template>
  <div id="app">
    <div id="nav">
      <router-link class="router-link" v-bind:to="{ name: 'home' }"
        >Home</router-link
      >&nbsp;|&nbsp;
      <router-link class="router-link" v-bind:to="{ name: 'properties' }"
        >Properties</router-link
      >|&nbsp;
      <router-link class="router-link" v-bind:to="{ name: 'login' }"
        >Login</router-link
      >&nbsp;|&nbsp;
      <router-link class="router-link" v-bind:to="{ name: 'register' }"
        >Register</router-link
      >&nbsp;|&nbsp;
      <!-- <router-link class="router-link" v-bind:to="{ name: 'contact'}">Contact</router-link>&nbsp;|&nbsp;
      <router-link class="router-link" v-bind:to="{ name: 'about'}">About</router-link>&nbsp;|&nbsp; -->

      <router-link
        class="router-link"
        v-bind:to="{ name: 'logout' }"
        v-if="$store.state.token != ''"
        >Logout</router-link
      >&nbsp;
    </div>
    <router-view />
  </div>
</template>
<style>
#nav {
  display: flex;
  justify-content: space-between;
  background-color: rgba(255, 255, 255, 0.774);
  margin: auto;
  padding: 5% auto 5% auto;
  width: 100%;
}

.router-link {
  text-decoration: none;
  color: #101411;
  margin: auto;
  width: 100%;
}

.router-link:hover {
  text-decoration: underline;
  color: blue;
}
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  max-width: 1000px;
  margin: 0 auto 0 auto;

}
</style>

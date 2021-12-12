<template>

  <div id="app">

    <nav id="nav">
      <router-link class="router-link-idk" v-bind:to="{ name: 'home' }">Home</router-link>
      <router-link class="router-link-idk" v-bind:to="{ name: 'login' }">Login</router-link>
      <router-link class="router-link-idk" v-bind:to="{ name: 'register' }">Register</router-link>
      <router-link class="router-link-idk" v-bind:to="{ name: 'about'}">About</router-link>
      <router-link class="router-link-idk" v-bind:to="{ name: 'payment'}">Pay Rent</router-link>      
      <router-link class="router-link-idk" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </nav>
    <router-view />
    
  </div>
</template>
<style>

.router-link-idk {
  background-color: whitesmoke;
  text-decoration: none;
  color:black;
	display: inline-block; 
	font-size: 1.1rem;
	padding: 0.5rem;
  margin: 18px;
  height: 1rem;
  width: 8rem;
  text-decoration: none;
  border-radius: 5px; 
	text-align: center;
	text-transform: uppercase;
}

.router-link-idk:hover {
  background: rgb(61,64,53);
  color: white;
}

#app {
  font-family: "Montserrat", Helvetica, Arial, sans-serif;
  text-align: center;
}

</style>

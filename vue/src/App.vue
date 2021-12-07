<template>

  <div class="wrapper" id="app">
    <section id="top=panel">
    <nav id="nav">
      <router-link class="router-link" v-bind:to="{ name: 'home' }"
        >Home</router-link
      >
      <router-link class="router-link" v-bind:to="{ name: 'login' }"
        >Login</router-link
      >
      <router-link class="router-link" v-bind:to="{ name: 'register' }"
        >Register</router-link
      >
      <!-- <router-link class="router-link" v-bind:to="{ name: 'contact'}">Contact</router-link>&nbsp;|&nbsp;
      <router-link class="router-link" v-bind:to="{ name: 'about'}">About</router-link>&nbsp;|&nbsp; -->

      <router-link
        class="router-link"
        v-bind:to="{ name: 'logout' }"
        v-if="$store.state.token != ''"
        >Logout</router-link
      >&nbsp;
    </nav>
    </section>
    <section id="bottom-panel">
        
    </section>
    <router-view />
  </div>
</template>
<style>

.wrapper {
	display: grid;
	grid-gap: 20px;

}

	#top-panel {
    display: flex;
    flex-basis: 35%;
    
  }

  #bottom-panel {
    display: flex;
    flex-grow: 1;
    justify-content: center;
    justify-items: center;
  }
  

.router-link {
  justify-content: space-between;
  background-color: rgba(255, 255, 255, 0.774);
  text-decoration: none;
  color:black;
	display: inline-block; 
	font-size: 1.1rem;
	padding: 0.8rem;
  margin: 20px;
  height: 1rem;
  width: 8rem;
  text-decoration: none;
  border-radius: 5px; 
	text-align: center;
	text-decoration: none;
	text-transform: uppercase;
}

.router-link:hover {
  background: rgb(73, 73, 73);
  color: white
}
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  text-align: center;
  color: #2c3e50;
  max-width: 1000px;
  margin: 0 auto 0 auto;
}

</style>

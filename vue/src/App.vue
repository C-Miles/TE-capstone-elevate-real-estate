<template>
  <div id="app">
    <nav id="nav-menu">
      <div id="logo">Elevate Real Estate</div>
      <div id="menu">
        <ul>
          <li>
            <router-link class="router-link-idk" v-bind:to="{ name: 'home' }"
              >Home</router-link
            >
          </li>
          <li>
            <router-link class="router-link-idk" v-bind:to="{ name: 'login' }"
              >Login</router-link
            >
          </li>
          <li>
            <router-link
              class="router-link-idk"
              v-bind:to="{ name: 'register' }"
              >Register</router-link
            >
          </li>
          <li>
            <router-link class="router-link-idk" v-bind:to="{ name: 'about' }"
              >About</router-link
            >
          </li>
          <li>
            <router-link class="router-link-idk" v-bind:to="{ name: 'payment' }"
              >Pay Rent</router-link
            >
          </li>
          <li>
            <router-link
              class="router-link-idk"
              v-bind:to="{ name: 'logout' }"
              v-if="$store.state.token != ''"
              >Logout</router-link
            >
          </li>
        </ul>
      </div>
    </nav>
    <router-view />
    <footer class="footer">
      <router-link id="contact" v-bind:to="{ name: 'contact' }"
        >Contact Elevate Real Estate</router-link
      >
      <p>(614) 781-1560</p>
      <p class="address">4055 Maple Drive<br />Columbus, OH 43054<br /></p>
      <p class="copyright">
        Copyright © 2021 Elevate Real Estate - All Rights Reserved.
      </p>
    </footer>
  </div>
</template>

<style>
* {
  margin: 0;
  box-sizing: border-box;
}

#app {
  border: 1px solid black;
  width: 100%;
  height: auto;
  background-position: center;
  background-size: cover;
  background-image: linear-gradient(rgb(2, 1, 14), rgba(0, 0, 0, 0.1)),
    url(../public/backgroundapartmentimage.jpg);
  color: rgba(255, 255, 255, 1);
  font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
}

#nav-menu #logo {
  font-size: 40px;
  font-weight: 600;
  padding-left: 20px;
}

#nav-menu {
  width: 95%;
  height: 50px;
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  justify-content: space-between;
  align-items: center;
  margin-top: 6%;
  margin-left: 50px;
}

#nav-menu #menu ul {
  list-style: none;
  display: flex;
  height: 100%;
}

#nav-menu #menu li a {
  text-decoration: none;
  color: rgba(255, 255, 255, 1);
  padding: 1em 1.5em;
  line-height: 1px;
  font-size: 15px;
  text-transform: uppercase;
}

#nav-menu #menu li a:hover,
#nav-menu #menu li a.active {
  border: 2px solid white;
  border-radius: 5px;
}

footer {
  padding: 2rem;
  left: 0;
  bottom: 0;
  width: 100%;
  background-color: rgba(2, 1, 14, 0.9);
  color: rgba(255, 255, 255, 0.555);
  text-align: center;
  font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif
}

h1, p {
  text-align: center;
}

form {
	margin:10% auto 0 auto;
	padding:30px;
	width:400px;
	height:auto;
	overflow:hidden;
	background:white;
	border-radius:10px;
}

form label {
	font-size:14px;
	color:darkgray;
}

#contact {
  text-decoration: none;
  color: white;
}
</style>
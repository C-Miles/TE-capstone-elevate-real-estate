<template>
  <div class="home">
    <body class="gradient">
      <h1>Welcome to Elevate Real Estate</h1>
      <span></span>
      <p>Find your perfect home to elevate your quality of home with us</p>

      <div id="home-image">
          <h2 class="property-search">Find your dream rental</h2>
          <p class="property-search">View your possibilities today that fit your desires</p>
          <router-link id="properties-link" class="router-link-prop" v-bind:to="{ name: 'properties' }">Search Properties</router-link>
      </div>

    </body>
    <footer class="footer">
      <router-link class="router-link " v-bind:to="{ name: 'contact'}">Contact Elevate Real Estate</router-link>
      <p>(614) 781-1560</p><p class="address">4055 Maple Drive<br>Columbus, OH 43054<br></p>
      <p class="copyright">Copyright © 2021 Elevate Real Estate - All Rights Reserved.</p>
    </footer>
  </div>
</template>

<script>
export default {
  name: "home",
};
</script>

<style>
.gradient h1 {
  font-weight: bold;
  font-size: 40px;
  text-shadow: 2px 2px black;
  padding: -9rem .5rem .5rem .5rem;
}

body.gradient {
  color: whitesmoke;
  text-align: center;
}

body {
  background-color: rgb(17, 27, 61);
}

#home-image {
  display: block;
  background: linear-gradient(
      rgba(0, 0, 0, 0.25),
      rgba(0, 0, 0, 0.25)
    ), url(../assets/paradaypark.png) center / cover no-repeat;
  text-align: center;
  padding: 10rem;
  margin: auto 0 50px;
  max-width: 100%;
  height: auto;
}

.router-link-prop {
  background-color: whitesmoke;
  text-decoration: none;
  color:black;
	display: inline-block; 
	font-size: 1.2rem;
	padding: 1.0rem 0.8rem 0.3rem 0.8rem;
  margin: 20px;
  height: 2rem;
  width: 15rem;
  text-decoration: none;
  border-radius: 5px; 
	text-align: center;
	text-transform: uppercase;
}

.router-link-prop:hover {
  background: rgb(61,64,53);
  color: white;
}

span {
   display: block;
   width: 100%; 
   border-top: 1px solid whitesmoke;
}

.footer {
  color: whitesmoke;
  margin: 100px;
}

.router-link {
  color: whitesmoke;
  text-decoration: underline;
}

.router-link:hover {
  font-size: 20px;
  padding: 20px 20px 20px 20px;
}

</style>

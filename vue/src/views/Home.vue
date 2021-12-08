<template>
  <div class="home">
    <body class="gradient">
      <h1>Welcome to Elevate Real Estate</h1>
      <span></span>
      <p class="description">
        Find your perfect home to elevate your quality of home with us
      </p>

      <div class="apt-pics">
          <h2 class="background-image">Find your dream rental</h2>
          <p class="background-image">View your possibilities today that fit your desires</p>
          <router-link
            id="properties-link"
            class="router-link-prop"
            v-bind:to="{ name: 'properties' }"
            >Search Properties</router-link
          >
        <!-- <img src="../assets/FL.jpg" alt="apartment complex pic" /> -->
      </div>
    </body>
  </div>
</template>

<script>
export default {
  name: "home",
};
</script>
<style>
h1 {
  font-family: "Montserrat", Helvetica, Arial, sans-serif;
  font-weight: bold;
  font-size: 40px;
  text-shadow: 2px 2px black;
  padding: -9rem .5rem .5rem .5rem;
 
}

.description {
  font-family: "Montserrat", sans-serif;
}


body.gradient {
  color: whitesmoke;
  text-align: center;
  
  /* background-image: linear-gradient(black, grey); */
}

.background-image {
  /*background-color: black;
  width: 30rem;
  height: 1.5rem; */
  color: whitesmoke;
  text-align: center;
}

body {
    background-color: rgb(29,41,81);
}

.apt-pics {
display: block;
text-align: center;
  background: linear-gradient(
      rgba(0, 0, 0, 0.25),
      rgba(0, 0, 0, 0.25)
    ),
 url(../assets/paradaypark.png) center / cover no-repeat;
  padding: 10rem;
  margin: auto;
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
   border-top: 1px solid #ccc;
}
</style>

<template>
  <div class="home">
    <body class="gradient">
      <h1>Welcome to Elevate Real Estate</h1>
      <p class="description">
        Find your perfect home to elevate your quality of home with us
      </p>

      <div class="apt-pics">
        <section class="testing">
          <h2>Find your dream rental</h2>
          <p>View your possibilities today that fit your desires</p>
           <router-link
            id="properties-link"
            class="router-link"
            v-bind:to="{ name: 'properties' }"
            >Properties</router-link
          >
        </section>
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
  font-family: "Baloo Bhaijaan 2", Avenir, Helvetica, Arial, sans-serif;
  font-weight: bold;
  font-size: 40px;
  text-shadow: 2px 2px #00d9ff;
}

.description {
  font-family: "Montserrat", sans-serif;
}

body.gradient {
  /*
box-sizing: border-box;
line-height: 1.4; 
	margin: 30px 50px;
  */

  color: rgb(237, 218, 214);
  text-align: center;
  /* background-image: linear-gradient(black, grey); */
}

.testing {
  display: block;
  background: url(../assets/FL.jpg) right / cover no-repeat;
  padding: 10rem;
  width: 100%;
  position: fixed;
  top: 25rem;
  left: 0;
 /* opacity: 80%; */
}

img {
  /*
  display: block;
  margin-left: auto;
  margin-right: auto;
  width: 100%;
  border: 1rem thin pink;
  border-style: solid;
  border-radius: 5px;
*/
}
</style>

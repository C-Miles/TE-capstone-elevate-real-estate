<template>
  <div class="home">
    <body>
      <h1>Welcome to Elevate Real Estate</h1>
      <p>Find your perfect home to elevate your quality of home with us.</p>
      <div class="apt-pics">
        <img src="../assets/FL.jpg" alt="apartment complex pic" />
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
body {

  color: rgb(237, 218, 214);
  text-align: center;
  background-image: linear-gradient(black, grey);
  background-repeat: no-repeat;
}

img {

  display: block;
  margin-left: auto;
  margin-right: auto;
  width: 100%;
  border: 1rem thin pink;
  border-style: solid;
  border-radius: 5px;

}
</style>

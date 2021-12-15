<template>
  <div class="home">
    <body class="banner">
      <h1>Welcome to Elevate Real Estate</h1>
      <p class="property-search">
        View your possibilities today that fit your desires
      </p>
      <router-link
        id="properties-link"
        class="router-link-prop"
        v-bind:to="{ name: 'properties' }"
        >Search Properties</router-link
      >
    </body>
  </div>
</template>

<script>
export default {
  name: "home",
};
</script>

<style>
.banner {
  text-align: center;
  margin: 10% auto;
}

h1 {
  padding: 1rem;
  font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
  font-size: 3rem;
}

banner p {
  padding: 1rem;
  font-size: large
}

#properties-link {
  text-decoration: none;
    font-size:18px;
    color: rgba(255,255,255,1);
    margin: 90px auto;
    display: block;
    font-weight: bold;
    border: 2px solid rgba(255,255,255,1);
    width: 18%;
    height: 75px;
    line-height: 75px;
    text-align: center;
    border-radius: 7px;
}
</style>

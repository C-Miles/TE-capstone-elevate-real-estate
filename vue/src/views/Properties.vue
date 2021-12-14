<template>
  <div>
    <h1>Properties</h1>
    <span></span>
    <!-- v-if="firebaseLoaded" v-bind:property="property" -->
    <add-google-map id="googleMap" />
    <properties-list></properties-list>
  </div>
</template>

<script>
import PropertiesList from "@/components/PropertiesList";
import AddGoogleMap from "@/components/AddGoogleMap";

export default {
  name: "properties",
  //firebaseLoaded: false,
  components: {
    PropertiesList,
    AddGoogleMap
  },
};
</script>

<style>
h1 {
  color: whitesmoke;
}

#googleMap {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #000000;
  margin-top: 50px;
}
</style>
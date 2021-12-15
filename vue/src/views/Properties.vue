<template>
  <div>
    <h1>Properties</h1>
    <span></span>
    <add-google-map id="googleMap" v-if="$store.state.properties.length > 0"/>
    <properties-list></properties-list>
  </div>
</template>

<script>
import PropertiesList from "@/components/PropertiesList";
import AddGoogleMap from "@/components/AddGoogleMap";

export default {
  name: "properties",
  components: {
    PropertiesList,
    AddGoogleMap
  },
};
</script>

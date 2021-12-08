<template>
  <div>
    <h1>Properties</h1>
    <properties-list></properties-list>
  </div>
</template>

<script>
import PropertiesList from "@/components/PropertiesList";

export default {
  name: "properties",
  components: {
    PropertiesList,
  },
};
</script>

<style>
h1 {
  font-family: "Montserrat", Helvetica, Arial, sans-serif;
  color: whitesmoke;
}
</style>
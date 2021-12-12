<template>
  <div>
    <h1>Properties</h1>
    <span></span>
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
  color: whitesmoke;
}


</style>
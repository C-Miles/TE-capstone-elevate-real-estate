<template>
  <div>
    <div id="property-container">
      <h2 id="header">{{ property.propertyName }}</h2>
      <img id="image" v-bind:src="property.imageName" />

      <div id="content">
        <p>
          Address: <br />
          {{ property.address }} <br />
          {{ property.city }}, {{ property.state }} {{ property.zipcode }}
        </p>

        <router-link
          class="router-link-property-details"
          :to="{ name: 'units', params: { propertyId: property.propertyId } }"
          >View More Details</router-link
        >
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "property-list-item",
  props: ["property"],
};
</script>

<style>
#property-container {
  border: solid 1px;
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-template-areas:
    "header  header  header"
    "image image content";
  background-color: rgba(13, 25, 37, 0.7);
  color: whitesmoke;
  max-width: 100%;
  max-height: 100%;
  margin: auto;
}

#header {
  grid-area: header;
  text-align: center;
  padding: 1rem;
}

#image {
  grid-area: image;
  width: 400px;
  height: 250px;
  padding: 1rem;
  height: 250px;
  filter: drop-shadow(5px 5px 5px #131111);
}

#content {
  grid-area: content;
  margin: auto;
}

.router-link-property-details {
  grid-area: content;
  background-color: whitesmoke;
  text-decoration: none;
  color: black;
  display: inline-block;
  padding: 0.5rem;
  width: 200px;
  text-decoration: none;
  border-radius: 5px;
  text-align: center;
  margin: 2rem;
}
</style>
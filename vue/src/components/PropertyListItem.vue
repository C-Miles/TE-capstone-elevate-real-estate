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
        <p>Apartment: {{ property.apartmentNumber }}</p>
        <p>Number of Bedrooms: {{ property.numberOfRooms }}</p>
        <p>Monthly Rent: ${{ property.monthlyRent }}</p>
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
  align-items: center;
  max-width: 100%
}

#header {
  grid-area: header;
  text-align: center;
  padding-top: 20px;
}

#image {
  grid-area: image;
  width: 400px;
  padding-left: 10%;
  height: 250px;
  filter: drop-shadow(5px 5px 5px #131111);
}

#content {
  grid-area: content;
  margin: 2rem;
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
<template>

  <div id="property-container">

    <h2 id="header">{{property.propertyName}}</h2>
    <img id="image" v-bind:src="require('../assets/property-images/' + property.imageName)" />

    <div id="content">
      <!--<img src= require(../assets/${filename}) alt="highgrand apt">-->
      <p>Address: <br/> {{property.address}} <br/> {{property.city}}, {{property.state}} {{property.zipcode}}</p>
      <p>Apartment: {{property.apartmentNumber}}</p>
      <p>Number of Bedrooms: {{property.numberOfRooms}}</p>
      <p>Monthly Rent: ${{property.monthlyRent}}</p>
      <router-link class="router-link-property-details" :to="{name: 'propertyDetail', params: { unitID: property.unitID}}">View More Details</router-link>
    </div>

  </div>
 
</template>

<script>
export default {
    name: 'property-list-item',
    props: ['property']
}
</script>

<style>

#property-container {
  border: solid 1px;
  margin: 2rem 15rem 2rem 15rem;
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-template-areas:
  "header  header  header"
  "image image content";
  background-color: rgba(44, 68, 95, 0.7);
  color: whitesmoke;
  align-items: center;
}

#header {
  grid-area: header;
}

#image {
  grid-area: image;
  max-width: 100%;
  margin: 2rem;
  filter: drop-shadow(5px 5px 5px #131111);
}

#content {
  grid-area: content;
  margin: 2rem;
}

.router-link-property-details {
  grid-area: router-link-property-details;
  background-color: whitesmoke;
  text-decoration: none;
  color:black;
	display: inline-block; 
	padding: 0.5rem;
  height: 1rem;
  text-decoration: none;
  border-radius: 5px; 
	text-align: center;
  margin: 2rem
}

</style>
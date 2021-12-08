<template>

  <div class="container">
    <h2>{{property.propertyName}}</h2>
    <div>
      <!--<img src= require(../assets/${filename}) alt="highgrand apt">-->
      <img v-bind:src="require('../assets/property-images/' + property.imageName)" />

    </div>
    
    <p>Address: {{property.address}}, {{property.city}}, {{property.state}} {{property.zipcode}}</p>
    <p>Unit: {{property.apartmentNumber}}</p>
    <p>Number of Rooms: {{property.numberOfRooms}}</p>
    <p>Monthly Rent: {{property.monthlyRent}}</p>

  </div>
 
</template>

<script>
export default {
    name: 'property-list-item',
    props: ['property']
}
</script>

<style>
.container {
  font-family: "Montserrat", Helvetica, Arial, sans-serif;
  color: whitesmoke;
}
</style>
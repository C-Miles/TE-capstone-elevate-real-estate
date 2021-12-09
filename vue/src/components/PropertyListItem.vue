<template>

  <div id="propertydetails">

      <h2>{{property.propertyName}}</h2>
      <p>Unit ID: {{property.unitID}}</p>

    <div>
      <!--<img src= require(../assets/${filename}) alt="highgrand apt">-->
      <img class="property-images" v-bind:src="require('../assets/property-images/' + property.imageName)" />
      <div>
        <p>Address: {{property.address}}, {{property.city}}, {{property.state}} {{property.zipcode}}</p>
        <p>Apartment: {{property.apartmentNumber}}</p>
        <p>Number of Rooms: {{property.numberOfRooms}}</p>
        <p>Monthly Rent: {{property.monthlyRent}}</p>
      </div>
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

#propertydetails {
  font-family: "Montserrat", Helvetica, Arial, sans-serif;
  color: whitesmoke;
  border: solid 1px;
  margin: 2rem 15rem 2rem 15rem;
  background:rgba(44, 68, 95, 0.7)
}

.property-images {
  width: 60%;
}

</style>
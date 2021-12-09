<template>

  <div class="container">
    <h2>{{property.propertyName}}</h2>
    <div>
      <!--<img src= require(../assets/${filename}) alt="highgrand apt">-->
       <p>Unit ID: {{property.unitID}}</p>
       <img class="img-thing" v-bind:src="require('../assets/property-images/' + property.imageName)" />

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
div.container {
  font-family: "Montserrat", Helvetica, Arial, sans-serif;
  color: whitesmoke;
  margin: 20px;
  background-color: ;
}

.img-thing {
  max-width: 70%;
  
  border: 5px solid #555;
}


</style>
<template>

  <div class="container">
    <h2>{{property.propertyName}}</h2>
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

</style>
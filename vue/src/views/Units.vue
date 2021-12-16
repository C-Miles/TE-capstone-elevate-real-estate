<template>
  <div>
      <h2>{{Units[0].propertyName}}</h2>
      <p>{{Units[0].address}}</p>
      <img :src="Units[0].imageName" class="pic" >
      <div v-for="test in Units" v-bind:key="test.id" class="deets">
          <br>
          <h3>Apartment: {{test.apartmentNumber}}</h3>
          <br>
          <p>Number Of Bedrooms: {{test.numberOfRooms}}</p>
          <br>
          <p>Monthly Rent: ${{test.monthlyRent}}</p>
          <br>
           <router-link
      id="applybtn"
      :to="{ name: 'application', params: { unitID: test.unitID } }"
      >Apply</router-link
    >
      </div>
      
  </div>
</template>

<script>
import propertyService from "../services/PropertyService";
export default {
    data() {
        return {
            
            Units: [],
        }
    },


    created() {
            propertyService.getUnitsByPropertyId(this.$route.params.propertyId)
           .then((response) => {
               this.Units = response.data
           }).catch((error) => {
               console.error(error);
           })
        

    }

}
</script>

<style>

.pic {
    display: block;
    margin-left: auto;
    margin-right: auto;
    width: 50%;
    
}

/* .deets {
    display: grid;
    grid-row-gap: 50%;
    justify-content: space-around;
    text-align: center;
    margin: auto;
} */



</style>
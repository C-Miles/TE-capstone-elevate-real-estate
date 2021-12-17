<template>
  <div class="container">
    <h2 id="property-name">{{ Units[0].propertyName }}</h2>
    <img :src="Units[0].imageName" class="pic" />
    <div id="unit-details">
      <div v-for="test in Units" v-bind:key="test.id" >
          <div class="content">
        <h3>Apartment: {{ test.apartmentNumber }}</h3>
        <p>Number Of Bedrooms: {{ test.numberOfRooms }}</p>
        <p>Monthly Rent: ${{ test.monthlyRent }}</p>
        </div>
        <router-link
          id="applybtn"
          :to="{ name: 'application', params: { unitID: test.unitID } }"
          >Apply</router-link
        >
      </div>
    </div>
  </div>
</template>

<script>
import propertyService from "../services/PropertyService";
export default {
  data() {
    return {
      Units: [],
    };
  },

  created() {
    propertyService
      .getUnitsByPropertyId(this.$route.params.propertyId)
      .then((response) => {
        this.Units = response.data;
      })
      .catch((error) => {
        console.error(error);
      });
  },
};
</script>

<style>

#unit-details {
    display: flex;
    justify-content: space-evenly;
    margin: 5%
}

.pic {
    display: block;
    /* text-align: center; */
    margin-left: auto;
    margin-right: auto;
    margin-top: 5%;
    width: 500px;
    height: 350px;
    
}

#applybtn {
  text-transform: uppercase;
  text-decoration: none;
  background: #ca4745;
  border-radius: 5px;
  border: none;
  transition: all 0.4s ease 0s;
  padding: 10px;
  display: block;
  text-align: center;
  color: whitesmoke;
  margin: 5%;
}

#property-name {
    font-size: 250%;
}

.content {
    font-size: 120%;
}



</style>
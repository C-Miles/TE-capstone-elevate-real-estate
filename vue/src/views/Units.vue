<template>
  <div class="deets">
    <h2 id="property-name">{{ Units[0].propertyName }}</h2>
    <img :src="Units[0].imageName" class="pic" />
    <div id="unit-details">
      <div v-for="test in Units" v-bind:key="test.id" >
        <h3>Apartment: {{ test.apartmentNumber }}</h3>
        <p>Number Of Bedrooms: {{ test.numberOfRooms }}</p>
        <p>Monthly Rent: ${{ test.monthlyRent }}</p>
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
.pic {
  display: block;
  margin-left: auto;
  margin-right: auto;
  padding-bottom: 10px;
  width: 500px;
  grid-area: pic;
}

#property-name {
  font-size: 30px;
  margin: 10px;
  grid-area: name;
}

#applybtn {
  text-transform: uppercase;
  text-decoration: none;
  background: #ca4745;
  border-radius: 5px;
  border: none;
  transition: all 0.4s ease 0s;
  padding: 10px;
}

.deets {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-template-areas:
    "name  name  name"
    "pic content content";
  color: whitesmoke;
  max-width: 70%;
  margin: auto;
}

#unit-details {
  grid-area: content;
  padding: auto;
  margin: auto;
}
</style>
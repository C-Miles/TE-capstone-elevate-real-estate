<template>
  <div class="properties">
    <p class="filter-boxes">
      <input type="text" v-model="filter.propertyName" placeholder="Property Name"/>
      <input type="text" v-model="filter.numberOfRooms" placeholder="Number of Rooms"/>
      <input type="text" v-model="filter.monthlyRent" placeholder="Max Monthly Rent"/>
      <input type="text" v-model="filter.zipcode" placeholder="Zipcode" />
    </p>
    <add-property></add-property>

    <property-list-item
      v-for="currentProperty in filteredList"
      v-bind:key="currentProperty.id"
      v-bind:property="currentProperty"
    >
    </property-list-item>
  </div>
</template>
<script>
import PropertyListItem from "../components/PropertyListItem";
import propertyService from "../services/PropertyService";
import AddProperty from './AddProperty.vue';

export default {
  name: "properties-list",
  data() {
    return {
      filter: {
        propertyName: "",
        numberOfRooms: "",
        monthlyRent: "",
        zipcode: "",
      },
    };
  },
  components: {
    PropertyListItem,
    AddProperty
  },
  computed: {
    properties() {
      return this.$store.state.properties;
    },

    filteredList() {
      let filteredProperties = this.$store.state.properties;
      if (this.filter.propertyName != "") {
        filteredProperties = filteredProperties.filter((property) => {
          return property.propertyName
            .toLowerCase()
            .includes(this.filter.propertyName.toLowerCase());
        });
      }
      if (this.filter.numberOfRooms > 0) {
        filteredProperties = filteredProperties.filter((property) => {
          return property.numberOfRooms == this.filter.numberOfRooms;
        });
      }
      if (this.filter.monthlyRent > 0) {
        filteredProperties = filteredProperties.filter((property) => {
          return property.monthlyRent <= this.filter.monthlyRent;
        });
      }
      if (this.filter.zipcode > 0) {
        filteredProperties = filteredProperties.filter((property) => {
          return property.zipcode == this.filter.zipcode;
        });
      }

      return filteredProperties;
    },

  },

  created() {
    propertyService
      .getAllProperties()
      .then((response) => {
        this.$store.commit("SET_PROPERTIES", response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  },
};
</script>

<style>
input {
  min-width: 20px;
  padding: 8px;
  border-radius: 5px;
  height: 30px;  
}

::placeholder {
  color: whitesmoke;
  text-align: center;
}

.filter-boxes input {
  margin: 10px;
  height: 1.5rem;
  width: 10rem;
  display: inline;
  border-radius: 5px;
  background-color: rgb(139, 121, 121);
}

</style>
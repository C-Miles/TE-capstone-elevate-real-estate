<template>
  <div class="properties">

    <!-- input search field to filter -->
   <!-- <select name="propertyName" id="propertyName">
      <input type="text" v-model="filter.propertyName" />
      <option value="test">Test</option>
    </select> -->
   <p><input type="text" v-model="filter.propertyName" /></p> 
    <property-list-item
      v-for="currentProperty in filteredList"
      v-bind:key="currentProperty.godzilla"
      v-bind:property="currentProperty"
    >
    </property-list-item>
  </div>
</template>
<script>
import PropertyListItem from "../components/PropertyListItem";
import propertyService from "../services/PropertyService";
export default {
  name: "properties-list",
  data() {
    return {
      filterText: "",
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
  },
  computed: {
    properties() {
      return this.$store.state.properties;
    },
    filteredProperties() {
      return this.$store.state.properties.filter((property) => {
        return property.propertyName.includes(this.filterText);
      });
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
      if (this.filter.numberOfRooms != "") {
        filteredProperties = filteredProperties.filter((property) => {
          return property.numberOfRooms.toLowerCase().includes(this.filter.numberOfRooms.toLowerCase());
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
</style>
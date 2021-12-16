<template>
  <div>
    <p class="filter-boxes">
      <input
        type="text"
        v-model="filter.propertyName"
        placeholder="Property Name"
      />
      <input
        type="text"
        v-model="filter.numberOfRooms"
        placeholder="Number of Rooms"
      />
      <input
        type="text"
        v-model="filter.monthlyRent"
        placeholder="Max Monthly Rent"
      />
      <input type="text" v-model="filter.zipcode" placeholder="Zipcode" />
    </p>
    <add-property v-if="($store.state.role == 'ROLE_ADMIN')"></add-property>
    <div class="properties">
      <property-list-item
        v-for="currentProperty in filteredList"
        v-bind:key="currentProperty.id"
        v-bind:property="currentProperty"
      >
      </property-list-item>
    </div>
  </div>
</template>
<script>
import PropertyListItem from "../components/PropertyListItem";
import propertyService from "../services/PropertyService";
import AddProperty from "./AddProperty.vue";

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
    AddProperty,
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
.properties {
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-gap: 20px;
  max-width: 100%
}
</style>
<template>
  <div>
    <p class="filter-boxes">
      <input id="filter"
        type="text"
        v-model="filter.propertyName"
        placeholder="Property Name"
      />
      <!-- <input id="filter"
        type="text"
        v-model="filter.numberOfRooms"
        placeholder="Number of Rooms"
      />
      <input id="filter"
        type="text"
        v-model="filter.monthlyRent"
        placeholder="Max Monthly Rent"
      /> -->
      <input id="filter" type="text" v-model="filter.zipcode" placeholder="Zipcode" />
    </p>
    <add-property></add-property>
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
      // if (this.filter.numberOfRooms > 0) {
      //   filteredProperties = filteredProperties.filter((property) => {
      //     return property.numberOfRooms == this.filter.numberOfRooms;
      //   });
      // }
      // if (this.filter.monthlyRent > 0) {
      //   filteredProperties = filteredProperties.filter((property) => {
      //     return property.monthlyRent <= this.filter.monthlyRent;
      //   });
      // }
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

#filter {
  transition: all ease 0.1s;
  border: none;
  border-bottom: 1px solid hsla(0, 0%, 0%, 0.2);
  padding: 1rem;
  margin: 1rem;
  outline: none;
  font-size: 14px;
  background: hsla(0, 100%, 100%, 1);
  color: #333;
  font-family: inherit;
  font-weight: bold;
  width: 160px;
  box-sizing: border-box;
}

</style>
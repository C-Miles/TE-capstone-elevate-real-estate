<template>
  <div>
    <div>
      <h2>Find Your Ideal Spot</h2>
      <label>
        <gmap-autocomplete @place_changed="initMarker"></gmap-autocomplete>
        <button @click="addLocationMarker">Find</button>
      </label>
      <br />
    </div>
    <br />
    <gmap-map :zoom="10" :center="center" style="width: 100%; height: 600px">
      <gmap-marker
        :key="index"
        v-for="(m, index) in locationMarkers"
        :position="m.position"
        @click="center = m.position"
      ></gmap-marker>
    </gmap-map>
  </div>
</template>
<script>
import propertyService from "../services/PropertyService";
export default {
  name: "add-google-map",
  data() {
    return {
      //properties: [],
      //loaded: false,
      center: {
        lat: 39.96987,
        lng: -82.96812,
      },
      locationMarkers: [],
      locPlaces: [],
      existingPlace: null,
      addressObj: {
        address_line_1: "",
        address_line_2: "",
        city: "",
        state: "",
        zip_code: "",
        country: "United States",
      },
    };
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
  mounted() {
    this.activePropertiesList();
    this.createApartmentMarkers();
  },
  computed: {
    properties() {
      return this.$store.state.properties;
    },
  },
  methods: {
    initMarker(loc) {
      this.existingPlace = loc;
    },
    addLocationMarker() {
      if (this.existingPlace) {
        const marker = {
          lat: this.existingPlace.geometry.location.lat(),
          lng: this.existingPlace.geometry.location.lng(),
        };
        this.locationMarkers.push({ position: marker });
        this.locPlaces.push(this.existingPlace);
        this.center = marker;
        this.existingPlace = null;
      }
    },
    locateGeoLocation: function () {
      navigator.geolocation.getCurrentPosition((res) => {
        this.center = {
          lat: res.coords.latitude,
          lng: res.coords.longitude,
        };
      });
    },
    createApartmentMarkers: function () {
      this.$geocoder.send(this.addressObj, (response) => {
        const marker = response.results[0].geometry.location;
        this.locationMarkers.push({ position: marker });
        this.locPlaces.push(this.marker);
        this.loaded = true;
      });
    },
    activePropertiesList: function () {
      this.properties = this.$store.state.properties;
      let test = this.properties.length;
      console.log(test);
      for (let i = 0; i < this.properties.length; i++) {
        //this.loaded = false;
        this.addressObj.address_line_1 = this.properties[i].address;
        this.addressObj.address_line_2 = this.properties[i].apartmentNumber;
        this.addressObj.city = this.properties[i].city;
        this.addressObj.state = this.properties[i].state;
        this.addressObj.zip_code = this.properties[i].zipcode;
        this.$geocoder.send(this.addressObj, (response) => {
          const marker = response.results[0].geometry.location;
          this.locationMarkers.push({ position: marker });
          this.locPlaces.push(this.marker);
          this.loaded = true;
          console.log("Hiiii");
        });
      }
    },
  },
};
</script>
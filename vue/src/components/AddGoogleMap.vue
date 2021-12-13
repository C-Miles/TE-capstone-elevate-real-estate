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
    <gmap-map :zoom="14" :center="center" style="width: 100%; height: 600px">
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
export default {
  name: "AddGoogleMap",
  props: ["properties"],
  data() {
    return {
      loaded: false,
      center: {
        lat: 39.96987,
        lng: -82.96812,
      },
      locationMarkers: [],
      locPlaces: [],
      existingPlace: null,
      addressObj: 
        {
          address: "",
          apartmentNumber: "",
          city: "",
          state: "",
          zipcode: "",
          country: "United States",
        },
    };
  },

  mounted() {
    // this.locateGeoLocation();
    this.createApartmentMarkers();
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
    // filter and return properties list address in array
    // loop through array to insert each address in properties list
    createApartmentMarkers: function () {
      this.$geocoder.send(this.addressObj, (response) => {
        const marker = response.results[0].geometry.location;
        this.locationMarkers.push({ position: marker });
        this.locPlaces.push(this.marker);
        this.loaded = true;
      });
    },
    created() {
      this.addressObj.address = this.properties.address;
      this.addressObj.apartmentNumber = this.properties.apartmentNumber;
      this.addressObj.city = this.properties.city;
      this.addressObj.state = this.properties.state;
      this.addressObj.zipcode = this.properties.zipcode;
      // filteredProperties() {
        // const properties = this.$store.state.properties;
        // return properties.filter( (property) => {
          // this.addressObjArray.address = property.address;
          // this.addressObjArray.apartmentNumber = property.apartmentNumber;
          // this.addressObjArray.city = property.city;
          // this.addressObjArray.state = property.state;
          // this.addressObjArray.zipcode = property.zipcode;
        // });
      // },
    },
  },
};
</script>
<template>
  <div>
    <div>
      <h2>Add A Pin</h2>
      <label>
        <gmap-autocomplete @place_changed="initMarker"></gmap-autocomplete>
        <button @click="addLocationMarker">Search</button>
      </label>
      <br />
    </div>
    <br />
    <gmap-map
      :zoom="10"
      :center="center"
      style="width: 100%; height: 600px"
      class="google-map"
    >
      <gmap-marker
        :key="index"
        v-for="(m, index) in locationMarkers"
        :position="m.position"
        :draggable="true"
        :clickable="true"
        :title="locationDetails[index]"
        @click="center = m.position"
        id="Marker"
      ></gmap-marker>
    </gmap-map>
  </div>
</template>

<script>
export default {
  name: "add-google-map",
  data() {
    return {
      properties: [],
      //loaded: false,          @mouseover="'test'"
      
      center: {
        lat: 39.96987,
        lng: -82.96812,
      },
      customInfo: "",
      Marker: null,
      locationMarkers: [],
      locPlaces: [],
      locationDetails: [],
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

  mounted() {
    //this.createApartmentMarkers();
  },

  methods: {
    //code adding
    //document.getElementById("Marker").addEventListener("click", ),

    initMarker(loc) {
      this.existingPlace = loc;
    },
    addLocationMarker() {
      if (this.existingPlace) {
        const marker = {
          lat: this.existingPlace.geometry.location.lat(),
          lng: this.existingPlace.geometry.location.lng(),
        };
        console.log(marker);
        //adding code
        // marker = new google.maps.Marker({
        //   map,
        //   animation: google.maps.Animation.DROP,
        // });
        // marker.addListener("click", toggleBounce);
        // this.locationMarkers.push({ position: marker });
        // this.locPlaces.push(this.existingPlace);
        // this.center = marker;
        // this.existingPlace = null;
      }
    },
    // toggleBounce: function () {
    //   if(marker.getAnimation() !== null) {
    //     marker.setAnimation(null);
    //   } else {
    //     marker.setAnimation(google.maps.Animation.BOUNCE);
    //   }
    // },
    eGeoLocation: function () {
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
       // console.log(this.locationMarkers[0]);
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
       // this.addressObj.customInfo = this.addressObj.address_line_1 + this.addressObj.address_line_2 + this.addressObj.city + this.addressObj.state + this.addressObj.zip_code;
        //this.locationDetails.push(this.customInfo);
        // let getMarker = this.maps.Marker.getDraggable();
        // console.log(getMarker);
        // let setMarker = this.maps.Marker.setDraggable(true);
        // console.log(setMarker);
  
        this.$geocoder.send(this.addressObj, (response) => {
          const marker = response.results[0].geometry.location;
        console.log(response.results[0].formatted_address);
         this.locationMarkers.push({ position: marker });
          console.log(this.locationMarkers);
          this.locPlaces.push(this.marker);
          this.customInfo = response.results[0].formatted_address;
          this.locationDetails.push(this.customInfo);
          this.loaded = true;
          console.log("Hiiii");
        });
        console.log(this.customInfo);
      }
    },
  },
  created() {
    this.activePropertiesList();
  },
};
</script>

<style>
#Marker {
  font: black;
}
</style>
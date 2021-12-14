<template>
  <div>
    <button v-on:click.prevent="showForm = true" id="propertybtn">
      Add Property
    </button>
    <form class="propertyForm" v-show="showForm">
      <div>
        <label>Property Name</label>
        <input type="text" v-model="property.propertyName" />

        <div class="wholeAddress">
          <label>Street Address</label>
          <input type="text" v-model="property.address" />
          <label>Apartment Number</label>
          <input type="text" v-model="property.apartmentNumber" />
          <label>City</label>
          <input type="text" v-model="property.city" />
          <label>State</label>
          <input type="text" v-model="property.state" />
          <label>Zipcode</label>
          <input type="text" v-model="property.zipcode" />
        </div>

        <label>Number of Bedrooms</label>
        <input type="text" v-model="property.numberOfRooms" />

        <label>Monthly Rent</label>
        <input type="text" v-model="property.monthlyRent" />

        <label>Add an Image</label>
        <input type="file" @change="uploadImage" id="photo" />
      </div>
      <div>
        <button id="propertybtn" type="submit" @click="saveProperty()">
          Submit Property Details
        </button>
      </div>
    </form>
  </div>
</template>

<script>
import propertyService from "../services/PropertyService";

import { initializeApp } from "firebase/app";
import { getStorage, ref, uploadBytes, getDownloadURL } from "firebase/storage";

const firebaseConfig = {
  apiKey: "AIzaSyBZdSkDPIviP49g0eHpfEupMjLKziw57-s",
  authDomain: "delta-elevate.firebaseapp.com",
  projectId: "delta-elevate",
  storageBucket: "delta-elevate.appspot.com",
  messagingSenderId: "663161152067",
  appId: "1:663161152067:web:76a10d278e84afc528aaf6",
  measurementId: "${config.measurementId}",
};

const app = initializeApp(firebaseConfig);

const storage = getStorage(app);

export default {
  name: "add-property",
  // props: ['property'],
  data() {
    return {
      property: {
        address: "",
        propertyId: 0,
        propertyName: "",
        imageName: "",
        numberOfRooms: null,
        monthlyRent: null,
        apartmentNumber: null,
        city: "",
        state: "",
        zipcode: null,
        addressID: 0,
        unitID: 0,
      },

      showForm: false,
    };
  },

  methods: {
    uploadImage(e) {
      const file = e.target.files[0];

      const storageRef = ref(storage, file.name);

      uploadBytes(storageRef, file)
        .then((snapshot) => {
          console.log(snapshot);

          getDownloadURL(ref(storage, file.name))
            .then((url) => {
              this.property.imageName = url;

              console.log(url);
            })
            .catch((error) => {
              console.log(error);
            });
        })
        .catch((error) => {
          console.log(error);
        });
    },
    // v-on:click.prevent="addProperty"
   // addProperty() {
//this.$store.commit("ADD_PROPERTY", this.property );
   // },
    saveProperty() {
      propertyService
        .addProperty(this.property)
        .then((response) => {
          if (response.status === 200) {
            alert("Boom added");
            this.showForm = false;
          }
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
};
</script>

<style>
.propertyForm {
  margin: 0;
  padding: 3rem;
  max-width: 100%;
}

.propertyForm input[type="text"]:focus {
  background-color: rgb(211, 206, 175);
}

.propertyForm input {
  height: 10px;
  margin: 0.5rem;
}

label {
  color: whitesmoke;
  display: block;
}

#propertybtn {
  background-color: #803833;
  color: whitesmoke;
  width: 20%;
  display: inline-block;
  font-size: 1.1rem;
  padding: 0.8rem;
  margin: 20px;
  height: 3rem;
  text-decoration: none;
  border-radius: 5px;
  text-align: center;
  text-transform: uppercase;
  border-radius: 15px;
}

#propertybtn:hover {
  background-color: whitesmoke;
  color: black;
}
</style>
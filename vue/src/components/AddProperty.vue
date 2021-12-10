<template>
<div>
    <button v-on:click.prevent="showForm = true" id="propertybtn">Add Property</button>
    <form class="propertyForm" v-show="showForm">
        <div>
            <label>Property Name</label>
            <input type="text" v-model="property.propertyName">

            <div class="wholeAddress">
                <label>Street Address</label>
                <input type="text" v-model="property.address">
                <label>Apartment Number</label>
                <input type="text" v-model="property.apartmentNumber">
                <label>City</label>    
                <input type="text" v-model="property.city">
                <label>State</label>
                <input type="text" v-model="property.state">
                <label>Zipcode</label>
                <input type="text" v-model="property.zipcode">
           </div>

           <label>Number of Bedrooms</label>
           <input type="text" v-model="property.numberOfRooms">

           <label>Monthly Rent</label>
           <input type="text" v-model="property.monthlyRent">

           <label>Add an Image</label>
           <input type="text" v-model="property.imageName">
           <!-- <input type="file" name="myImage" accept="image/png, image/gif, image/jpeg" /> -->

        </div>
        <div>
            <button id="propertybtn" type="submit" @click="saveProperty()">Submit Property Details</button>
        </div>
    </form>
</div>
  
</template>

<script>

import propertyService from "../services/PropertyService"

export default {
    name: "add-property",
    data() {
        return{
            property: {
                address: '',
                propertyId: 0,
                propertyName: '',
                imageName: '',
                numberOfRooms: null,
                monthlyRent: null,
                apartmentNumber: null,
                city: '',
                state: '',
                zipcode: null,
                addressID: 0,
                unitID: 0
            },

            showForm: false
        }
    },
   
    methods:  {
        saveProperty() {
            propertyService.addProperty(this.property)
            .then(response => {
                if(response.status === 200) {
                        alert("Boom added")
                            this.showForm = false
                }
            })
        }
    }
}
</script>

<style>
 .propertyForm {
     margin: 0;
     padding: 3rem;
     max-width: 100%;
 }

.propertyForm input[type=text]:focus {
  background-color: rgb(211, 206, 175);
}

.propertyForm input {
    height: 10px;
    margin: .5rem;
}

label {
    color: whitesmoke;
    display: block;
}

#propertybtn {
    background-color:#803833;
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
    color: black
}

</style>
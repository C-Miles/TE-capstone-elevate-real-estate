<template>
<div>
    <form class="propertyForm" >
        <div>
           <input type="text" v-model="property.propertyName">
           <div>
           <input type="text" v-model="property.address">
           <input type="text" v-model="property.apartmentNumber">
           <input type="text" v-model="property.city">
           <input type="text" v-model="property.state">
           <input type="text" v-model="property.zipcode">
           </div>
           <input type="text" v-model="property.numberOfRooms">
           <input type="text" v-model="property.monthlyRent">
           <input type="text" v-model="property.imageName">
        </div>
        <div>
            <button type="submit" @click.prevent="saveProperty()">Add Property</button>
        </div>
    </form>
</div>
  
</template>

<script>

import propertyService from "../services/PropertyService"

export default {
    name: "add-apartment-form",
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
            }
        }
    },

    methods:  {
        saveProperty() {
            propertyService.addProperty(this.property)
            .then(response => {
                if(response.status === 201) {
                        alert("Boom added")
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

 .propertyForm input {
     
 }
</style>
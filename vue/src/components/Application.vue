<template>
  <div id="container">
      
      <h1>Apply for an Apartment</h1>
      <form class="appForm">
          <div class="form-fields">
          <label>First Name:</label>
          <input type="text" v-model="application.firstName">
          <label>Last Name:</label>
          <input type="text" v-model="application.lastName">
          <label>Email:</label>
          <input type="text" v-model="application.emailAddress">
          <label>Phone Number:</label>
          <input type="text" v-model="application.phoneNumber">
          
          <input type="hidden" v-model="application.unitId"> 
          </div>
          <div>
              <button id="appbtn" type="submit" @click.prevent="submitApplication">Submit Application</button>
          </div>
      </form>
  </div>
</template>
<script>
import propertyService from "../services/PropertyService"
export default {
    name: "application",
    data() {
        return {
            application: {
                rentAppId: 0,
                firstName: '',
                lastName: '',
                emailAddress: '',
                phoneNumber: '',
                appStatus: '',
                unitId: Number(this.$route.params.unitID)
            },
            showForm: false
        }
    },
    methods: {
        submitApplication() {
            propertyService.applyForApartment(this.application)
            .then(response => {
                if(response.status === 200) {
                    alert("Your application has been submitted")
                    this.showForm = false
                    this.$router.push(`/`)
                }
            })
        }
    }
}
</script>

<style>

#container {
    background-color: rgb(139, 121, 121);
    padding: 5px 20px 15px 20px;
    margin: 0% 20% 0% 20%;
    border-radius: 10px;
}

.form-fields {
    display: flex;
    flex-direction: column;
    margin: 20px;
}

.form-fields input {
    margin: 10px;
    background-color: whitesmoke;
}

#appbtn {
    background-color: #803833;
    width: 60%;
    color: white;
    padding: 12px;
    font-size: large;
    border: none;
    border-radius: 4px;
}

</style>
<template>
  <div id="container">
    <h1>Apply for an Apartment</h1>
    <form>
      <div class="form-fields">
        <label>First Name:</label>
        <input type="text" v-model="application.firstName" />
        <label>Last Name:</label>
        <input type="text" v-model="application.lastName" />
        <label>Email:</label>
        <input type="text" v-model="application.emailAddress" />
        <label>Phone Number:</label>
        <input type="text" v-model="application.phoneNumber" />

        <input type="hidden" v-model="application.unitId" />
        <button id="appbtn" type="submit" @click.prevent="submitApplication">
        Submit Application
      </button>
      </div>
    </form>
  </div>
</template>
<script>
import propertyService from "../services/PropertyService";
export default {
  name: "application",
  data() {
    return {
      application: {
        rentAppId: 0,
        firstName: "",
        lastName: "",
        emailAddress: "",
        phoneNumber: "",
        appStatus: "",
        unitId: Number(this.$route.params.unitID),
      },
      showForm: false,
    };
  },
  methods: {
    submitApplication() {
      propertyService.applyForApartment(this.application).then((response) => {
        if (response.status === 200) {
          alert("Your application has been submitted");
          this.showForm = false;
          this.$router.push(`/`);
        }
      });
    },
  },
};
</script>
<style>
#container {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-bottom: 100px;
  padding: 60px;
}

.form-fields {
    margin: auto;
    padding: 20px;
}
#appbtn {
    margin-top: 20px;
    margin-left: 25%;
    color: whitesmoke;
}
</style>

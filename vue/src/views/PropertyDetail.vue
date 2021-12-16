<template>
  <div>
    <h1>Details for {{ currentProperty.propertyName }}</h1>
    <p>{{ currentProperty.address }}</p>
    <p><img v-bind:src="currentProperty.imageName" /></p>
    <router-link
      id="applybtn"
      :to="{ name: 'application', params: { unitID: currentProperty.unitID } }"
      >Apply</router-link
    >
    <div id="property-details">
    <p>
      Important: Don’t miss out on this apartment through lengthy email
      exchanges and phone calls - apply for a lease now, by selecting your
      preferred floor plan and clicking the button below RENTCafé is the only
      rental search website where you can apply for a lease online in just a few
      steps. Application fee: $50. Other fees may apply, please contact the
      property for details.
    </p>
    <p>
      Amenities<br> Comfort and easy living are things we find vital to making a
      house a home. Explore all of our amenities that will create a relaxing and
      enjoyable environment for you and your family.
    </p>
    </div>
  </div>
</template>

<script>
export default {
  name: "property-detail",

  created() {
    const activeUnitID = this.$route.params.unitID;
    this.$store.commit("SET_ACTIVE_PROPERTY", activeUnitID);
  },

  computed: {
    currentProperty() {
      return this.$store.state.properties.find((cproperty) => {
        return cproperty.unitID == this.$store.state.activeUnitID;
      });
    },
  },
};
</script>
<style>
div {
  text-align: center
}

#property-details {
  width: 60%;
  margin: 40px auto;
}

#applybtn {
  text-decoration: none;
  font-size: 18px;
  color: rgba(255, 255, 255, 1);
  margin: 90px auto;
  display: block;
  font-weight: bold;
  border: 2px solid rgba(255, 255, 255, 1);
  width: 18%;
  height: 75px;
  line-height: 75px;
  text-align: center;
  border-radius: 7px;
}

#applybtn:hover {
  background-color: rgb(14, 14, 41);
}

</style>
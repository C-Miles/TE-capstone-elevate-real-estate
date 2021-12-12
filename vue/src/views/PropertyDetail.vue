<template>
  <div>
    <h1>Details {{ currentProperty.propertyName }}</h1>
    <p>{{ currentProperty.address }}</p>
    <p><img v-bind:src="currentProperty.imageName" /></p>
    <router-link
      class="router-link-idk"
      :to="{ name: 'application', params: { unitID: unitID } }"
      >Apply</router-link
    >
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
    >
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

p {
    color: white
}
</style>
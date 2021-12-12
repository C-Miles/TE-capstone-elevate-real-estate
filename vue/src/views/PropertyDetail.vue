<template>
  <div>
      <h1>Test Details for Apartment</h1>
      <router-link class="router-link-idk" :to="{name: 'application', params: { unitID: unitID}}">Apply</router-link>
  </div>
</template>

<script>
export default {
    name: 'property-detail',
    data() {
        return {
            unitID: 0
        }
    },
    computed: {
        currentProperty() {
            const unitID = this.$route.params.unitID;
            return this.$store.state.properties.filter( (property) => {
                return unitID === property.unitID
            })
        }
    },
    created() {
        this.unitID = this.$route.params.unitID
    }
}
</script>

<style>

</style>
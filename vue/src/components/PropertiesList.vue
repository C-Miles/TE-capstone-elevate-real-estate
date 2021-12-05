<template>
<div class="properties">
<property-list-item v-for="property in properties" v-bind:key="property.id" v-bind:property="property" ></property-list-item>
</div>
  
</template>

<script>
import PropertyListItem from '../components/PropertyListItem'
import propertyService from '../services/PropertyService'

export default {
    name: 'properties-list',
    components: {
        PropertyListItem
    },
    computed: {
        properties() {
            const propList = this.$store.state.properties;
            return propList;
        }
    },

    created() {
            propertyService.getAllProperties()
            .then( response => {
                this.$store.commit("SET_PROPERTIES", response.data)
            })
            .catch( error => {
                console.error(error);
            })
    }

}
</script>

<style>

</style>
<template>
<div class="properties">
    <div >  
       <property-list-item v-for="currentProperty in properties" v-bind:key="currentProperty.godzilla" v-bind:property="currentProperty"> 
       </property-list-item> 
        <!--<h1> {{property.zip}}</h1> -->
    </div>

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
            return propList.filter(prop=>{
                return prop;
            });
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
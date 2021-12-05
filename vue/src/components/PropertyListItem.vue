<template>
  <div>
      <p>{{$store.state.properties}}</p>
  </div>
</template>

<script>
export default {
    name: 'property-list-item',
    props: ['property']

}
</script>

<style>

</style>
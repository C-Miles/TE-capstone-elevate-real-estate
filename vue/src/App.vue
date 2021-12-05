<template>
  <div id="app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'login'}">Login</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'register'}">Register</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'contact'}">Contact</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'about'}">About</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'properties'}">Properties</router-link>
    </div>
    <router-view />
  </div>
</template>

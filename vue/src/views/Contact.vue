<template>
  <div id="contact">
    <h1>Contact Us</h1>
    <p>Send us a note and we'll get back to you soon.</p>
    <email></email>

    <div></div>
  </div>
</template>

<script>
import Email from "../components/Email.vue";
export default {
  name: "contact",
  components: {
    Email,
  },
};
</script>

<style>
.contact {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-bottom: 50px;
  padding: 60px;
}
</style>
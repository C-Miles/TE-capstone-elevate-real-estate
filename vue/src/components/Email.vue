<template>
  <form ref="form" @submit.prevent="sendEmail">
    <label>To:</label>
    <input type="text" name="to_name">
    <label>From:</label>
    <input type="text" name="from_name">
    <label>Message</label>
    <textarea name="message"></textarea>
    <input type="submit" value="Send">
  </form>
</template>

<script>
import emailjs from 'emailjs-com';

export default {
  methods: {
    sendEmail() {
      emailjs.sendForm('service_7gxh6y8', 'template_akc20hr', this.$refs.form, 'user_HGJ7Sm3RDQwmkNAIHPS4o')
        .then((result) => {
            console.log('SUCCESS!', result.text);
        }, (error) => {
            console.log('FAILED...', error.text);
        });
        alert("Email Sent")
        this.$router.push(`/`)
    }
  }
}
</script>

<style>

</style>
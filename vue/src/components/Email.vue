<template>
  <form ref="form" @submit.prevent="sendEmail" id='email'>
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
      emailjs.sendForm('service_91wksx9', 'template_8hrlzkw', this.$refs.form, 'user_HGJ7Sm3RDQwmkNAIHPS4o')
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
#email {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-top: 50px;
  margin-bottom: 50px;
  padding: 60px;
}
textarea {
  width: 100%;
  height: 100px;
}
</style>
<template>
  <div id="container">
    <h1 v-show="showForm">Make a Payment</h1>
    <form v-show="showForm" id="payment-form">
      <div class="form-fields">
        <label>Username:</label>
        <input type="text" v-model="payment.userName" />
        <label>Unit Id:</label>
        <input type="text" v-model="payment.unitId" />
        <label>Credit Card No.:</label>
        <input
          type="text"
          v-model="payment.cardNumber"
          placeholder="123456789"
        />
        <label>Expiration Date:</label>
        <input
          type="text"
          v-model="payment.expirationDate"
          placeholder="04/23"
        />
        <label>CVC:</label>
        <input type="password" v-model="payment.cvc" placeholder="123" />
        <label>Amount:</label>
        <input type="text" v-model="payment.amountPaid" placeholder="$" />
        <button id="paymentbtn" type="submit" @click.prevent="savePayment()">
          Complete Payment
        </button>
      </div>
    </form>
    <div v-show="showReciept" class="receipt">
      <h2>Payment Successful</h2>
      <br />
      <div>
        <p>Thank you for your payment: {{ payment.userName }}</p>
        <br />
        <p>Recieved On: {{ new Date().toLocaleString() }}</p>
        <br />
        <p>Amount Paid: ${{ payment.amountPaid }}</p>
        <br />
        <p>Confirmation Code: {{ codeGenerator() }}</p>
        <br />
        <button id="paymentbtn" @click.prevent="goHome">Return Home</button>
      </div>
    </div>
  </div>
</template>

<script>
import paymentService from "../services/PaymentService";

export default {
  name: "payment",
  data() {
    return {
      payment: {
        paymentId: null,
        userName: "",
        unitId: null,
        cardNumber: null,
        expirationDate: "",
        cvc: null,
        amountPaid: null,
        paymentApproved: false,
      },
      showForm: true,
      showReciept: false,
    };
  },

  methods: {
    savePayment() {
      paymentService.addPayment(this.payment).then((response) => {
        if (response.status === 200) {
          // alert("Payment Successful")
          // this.$router.push(`/`)
          this.showForm = false;
          this.showReciept = true;
        }
      });
    },
    codeGenerator() {
      const randomstring = Math.random().toString(36).slice(-8);
      return randomstring;
    },
    goHome() {
      this.$router.push("/");
    },
  },
};
</script>
<style>
#paymentbtn {
  width: auto;
  background: #1abc9c;
  border: none;
  color: white;
  border-radius: 10px;
  margin-top: 10px;
  margin-left: 20%;
  color: whitesmoke;
}

.receipt {
  display: flex;
  flex-direction: column;
  margin: 20px;
  margin: 10px;
  background-color: rgba(255, 255, 255, 0.8);
  color: black;
  padding: 10px;
  border-radius: 20px;
}

#payment-form {
  margin-bottom: 5%;
  padding: 60px;
}

label {
  margin-top: 10px;
}

input {
  margin: auto;
}
</style>
<template>
<div id="container">
    <h1>Make a Payment</h1>
    <form>
        <div class="form-fields">
            <label>Username:</label>
            <input type="text" v-model="payment.userName">
            <label>Unit Id:</label>
            <input type="text" v-model="payment.unitId">
            <label>Credit Card No.:</label>
            <input type="text" v-model="payment.cardNumber" placeholder="123 456 789 101">
            <label>Expiration Date:</label>
            <input type="text" v-model="payment.expirationDate" placeholder="04/23">
            <label>CVC:</label>
            <input type="password" v-model="payment.cvc" placeholder="123">
            <label>Amount:</label>
            <input type="text" v-model="payment.amountPaid" placeholder="$">
            <button id="paymentbtn" type="submit" @click.prevent="savePayment()">Complete Payment</button>
        </div>
    </form>
</div>
</template>

<script>

import paymentService from "../services/PaymentService"

export default {
    name: "payment",
    data() {
        return{
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
        }
    },

    methods:  {
        savePayment() {
            paymentService.addPayment(this.payment).then( (response) => {
                if(response.status === 200) {
                    alert("Payment Successful")
                    this.$router.push(`/`)
                }
            })
        }
    }
}
</script>
<style>

.form-fields {
    display: flex;
    flex-direction: column;
    margin: 20px;
}

input {
    margin: 10px;
    background-color: whitesmoke;
}

#paymentbtn {
	padding:15px 50px;
	width:auto;
	background:#1abc9c;
	border:none;
	color:white;
    border-radius:10px;
}

</style>
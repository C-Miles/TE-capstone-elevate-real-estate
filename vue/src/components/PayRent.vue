<template>
<div class="container">
    <h1>Make a Payment</h1>
    <form>
        <div class="form-fields">
            <label>Username</label>
            <input type="text" v-model="payment.userName">
            <label>Unit Id</label>
            <input type="text" v-model="payment.unitId">
            <label>Credit Card No.</label>
            <input type="text" v-model="payment.cardNumber" placeholder="123 456 789 101">
            <label>Expiration Date</label>
            <input type="text" v-model="payment.expirationDate" placeholder="04/23">
            <label>CVC</label>
            <input type="password" v-model="payment.cvc" placeholder="123">
            <label>Amount</label>
            <input type="text" v-model="payment.amountPaid" placeholder="$">
        </div>
        <div>
            <button type="submit" @click.prevent="savePayment()">Complete Payment</button>
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
                }
            })
        }
    }
}
</script>

<style>

.container {
    background-color: #585757;
    padding: 5px 20px 15px 20px;
    margin: 0% 20% 0% 20%;
    border-radius: 10px;
}

.form-fields {
    display: flex;
    flex-direction: column;
    margin: 20px;
}

.form-fields input {
    margin: 10px;
    background-color: whitesmoke;
}

button {
    background-color: #0fa84a;
    width: 60%;
    color: white;
    padding: 12px;
    font-size: large;
    border: none;
    border-radius: 4px;
}

</style>
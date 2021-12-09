import axios from 'axios';

export default {

    addPayment(payment) {
        return axios.post("/payment", payment);
    }

}
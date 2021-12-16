import axios from 'axios';

export default {

getAllProperties() {
    return axios.get("/properties");
},

addProperty(property) {
  return axios.post("/properties", property)
},

applyForApartment(application) {
  return axios.post("/application", application)
},

getUnitsByPropertyId(id) {
  return axios.get("properties/" + id + "/units")
}

}


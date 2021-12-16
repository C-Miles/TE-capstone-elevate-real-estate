package com.techelevator.controller;

import com.techelevator.dao.ApplicationDAO;
import com.techelevator.dao.PaymentDAO;
import com.techelevator.dao.PropertyDAO;
import com.techelevator.dao.UnitDAO;
import com.techelevator.model.Application;
import com.techelevator.model.Payment;
import com.techelevator.model.Property;

// import org.springframework.security.access.prepost.PreAuthorize;
import com.techelevator.model.Unit;

//import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.web.bind.annotation.*;

import javax.el.PropertyNotFoundException;
import java.security.Principal;
import java.util.List;

@RestController
//@PreAuthorize("isAuthenticated()")
@CrossOrigin
public class PropertyController {

    private PropertyDAO propertyDAO;
    private ApplicationDAO applicationDAO;
    private PaymentDAO paymentDAO;
    private UnitDAO unitDAO;

    public PropertyController(PropertyDAO propertyDAO, ApplicationDAO applicationDAO, PaymentDAO paymentDAO, UnitDAO unitDAO) {
        this.propertyDAO = propertyDAO;
        this.applicationDAO = applicationDAO;
        this.paymentDAO = paymentDAO;
        this.unitDAO = unitDAO;
    }

    @RequestMapping(path="/properties", method= RequestMethod.GET)
    public List<Property> getAllProperties() {
        return propertyDAO.getAllProperties();
    }

    @RequestMapping(path="/properties", method=RequestMethod.POST)
    public Property createProperty(@RequestBody Property requestBody) {
        Property property = propertyDAO.addProperty(requestBody);
        return property;
    }

    @RequestMapping(path="/application", method=RequestMethod.POST)
    public Application createApplication(@RequestBody Application requestBody) {
        Application application = applicationDAO.addApplication(requestBody);
        return application;
    }

    @RequestMapping(path="/payment", method=RequestMethod.POST)
    public Payment createPayment(@RequestBody Payment requestBody) {
        Payment payment = paymentDAO.addPayment(requestBody);
        return payment;
    }
    @RequestMapping(path = "/properties/{id}", method=RequestMethod.GET)
    public Property getProperty(@PathVariable long id) {
        return propertyDAO.getProperties(id);
    }

    @RequestMapping(path="/properties/{id}/units", method=RequestMethod.GET)
    public List<Unit> getAllUnitsById(@PathVariable("id") long propertyId) throws PropertyNotFoundException {
        return unitDAO.getAllUnitsByPropertyId(propertyId);
    }

//    @RequestMapping(path="/reservations/{id}", method=RequestMethod.GET)
//    public Reservation getReservation(@PathVariable int id) {
//        return reservationDAO.get(id);
//    }
//    @RequestMapping(path = "/hotels/{id}", method = RequestMethod.GET)
//    public Hotel get(@PathVariable int id) {
//        return hotelDAO.get(id);
//    }
//    @RequestMapping(path="/hotels/{id}/reservations", method=RequestMethod.GET)
//    public List<Reservation> listReservationsByHotel(@PathVariable("id") int hotelId) {
//        return reservationDAO.findByHotel(hotelId);
//    }
}

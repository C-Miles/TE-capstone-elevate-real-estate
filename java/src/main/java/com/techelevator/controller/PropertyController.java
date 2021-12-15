package com.techelevator.controller;

import com.techelevator.dao.ApplicationDAO;
import com.techelevator.dao.PaymentDAO;
import com.techelevator.dao.PropertyDAO;
import com.techelevator.model.Application;
import com.techelevator.model.Payment;
import com.techelevator.model.Property;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
//@PreAuthorize("isAuthenticated()")
@CrossOrigin
public class PropertyController {

    private PropertyDAO propertyDAO;
    private ApplicationDAO applicationDAO;
    private PaymentDAO paymentDAO;

    public PropertyController(PropertyDAO propertyDAO, ApplicationDAO applicationDAO, PaymentDAO paymentDAO) {
        this.propertyDAO = propertyDAO;
        this.applicationDAO = applicationDAO;
        this.paymentDAO = paymentDAO;
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
}

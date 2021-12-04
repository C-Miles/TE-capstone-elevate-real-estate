package com.techelevator.controller;

import com.techelevator.dao.PropertyDAO;
import com.techelevator.model.Property;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@PreAuthorize("isAuthenticated()")
public class PropertyController {

    private PropertyDAO propertyDAO;

    public PropertyController(PropertyDAO propertyDAO) {
        this.propertyDAO = propertyDAO;
    }

    @RequestMapping(path="/properties", method= RequestMethod.GET)
    public List<Property> getAllProperties() {
        return propertyDAO.getAllProperties();
    }
}

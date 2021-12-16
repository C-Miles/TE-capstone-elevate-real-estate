package com.techelevator.dao;

import com.techelevator.model.Property;

import java.security.Principal;
import java.util.List;

public interface PropertyDAO {

    List<Property> getAllProperties();

    Property addProperty(Property property);

    Property get(long id);
}

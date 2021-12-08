package com.techelevator.dao;




import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.techelevator.model.Property;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.access.method.P;

import java.util.List;


public class DAOPropertyTest extends DAOIntegrationTest{
    private JdbcPropertyDAO jdbcPropertyDAO;
    private JdbcTemplate jdbcTemplate;

    @Before
    public void setUp() {
        jdbcTemplate = new JdbcTemplate(getDataSource());
        jdbcPropertyDAO = new JdbcPropertyDAO(jdbcTemplate);

    }

    @Test
    public void get_list() {
        //arrange
        int originalRowCount = jdbcPropertyDAO.getAllProperties().size();
        insertProperty("testName", "testImage", 2);
        //assert
        List<Property> propertyList = jdbcPropertyDAO.getAllProperties();

        //assert
        Assert.assertEquals(originalRowCount + 1, propertyList.size());
    }
     private Property insertProperty(String propertyName, String imageName, long addressID) {
        Property property = new Property();
        property.setPropertyName(propertyName);
        property.setImageName(imageName);
        property.setAddressID(addressID);

        String sql = "INSERT INTO property (property_id, property_name, image_name, address_id) VALUES (DEFAULT, ?, ?, ?) RETURNING property_id";
        Long propertyID = jdbcTemplate.queryForObject(sql, Long.class, propertyName, imageName, addressID);
        property.setPropertyId(propertyID);
        return property;

     }

}

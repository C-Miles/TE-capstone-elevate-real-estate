package com.techelevator.dao;


import com.techelevator.model.Property;
import org.junit.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;


import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;


public class DAOPropertyTest extends DAOIntegrationTest {
    private JdbcPropertyDAO jdbcPropertyDAO;
    private JdbcTemplate jdbcTemplate;
    //private static SingleConnectionDataSource dataSource;



    @Before
    public void setUp() {

        jdbcTemplate = new JdbcTemplate(getDataSource());
        jdbcPropertyDAO = new JdbcPropertyDAO(getDataSource());
    }
    @Test
    public void get_list() {
        //arrange
        int originalRowCount = jdbcPropertyDAO.getAllProperties().size();
        insertProperty(2, "te", 2.0, 1, 2);
        //assert
        List<Property> propertyList = jdbcPropertyDAO.getAllProperties();

        //assert
        Assert.assertEquals(originalRowCount + 1, propertyList.size());
    }
     private Property insertProperty(int rooms, String apartmentNumber, double monthlyRent, long addressID, long propertyID) {
        Property property = new Property();
        property.setNumberOfRooms(rooms);
        property.setApartmentNumber(apartmentNumber);
        property.setMonthlyRent(monthlyRent);
        property.setAddressID(addressID);
        property.setPropertyId(propertyID);

        String sql = "INSERT INTO unit (unit_id, rooms, apartment_number, monthly_rent, address_id, property_id) VALUES (DEFAULT, ?, ?, ?, ?, ?) RETURNING unit_id";
        Long unitID = jdbcTemplate.queryForObject(sql, Long.class, rooms, apartmentNumber, monthlyRent, addressID, propertyID);
        property.setUnitID(unitID);
        return property;

     }
}

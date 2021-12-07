package com.techelevator.dao;

import com.techelevator.model.Property;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPropertyDAO implements PropertyDAO {

    private JdbcTemplate jdbcTemplate;

    public JdbcPropertyDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Property> getAllProperties() {

        List<Property> properties = new ArrayList<Property>();

        String sql = "SELECT property_name, rooms, monthly_rent, address, apartment_number, property.property_id AS property_id, city, state, zip FROM property " +
                "JOIN unit ON property.property_id = unit.property_id " +
                "JOIN address ON property.address_id = address.address_id";

        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql);
        while(rows.next()) {

            properties.add(mapRowToProperty(rows));
        }

        return properties;
    }

    private Property mapRowToProperty(SqlRowSet rows) {
        Property property = new Property();

        property.setPropertyId(rows.getLong("property_id"));
        property.setPropertyName(rows.getString("property_name"));
        property.setApartmentNumber(rows.getString("apartment_number"));
        property.setMonthlyRent(rows.getDouble("monthly_rent"));
        property.setNumberOfRooms(rows.getInt("rooms"));
        property.setCity(rows.getString("city"));
        property.setState(rows.getString("state"));
        property.setZipcode(rows.getInt("zip"));

        return property;
    }
}

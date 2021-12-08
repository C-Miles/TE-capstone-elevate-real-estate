package com.techelevator.dao;

import com.techelevator.model.Property;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPropertyDAO implements PropertyDAO {

    private JdbcTemplate jdbcTemplate;

    public JdbcPropertyDAO(DataSource datasource) {
        this.jdbcTemplate = new JdbcTemplate(datasource);
    }

    @Override
    public List<Property> getAllProperties() {

        List<Property> properties = new ArrayList<Property>();

        String sql = "SELECT property_name, image_name, rooms, monthly_rent, address, apartment_number, property.property_id AS property_id, city, state, zip FROM property " +
                "JOIN unit ON property.property_id = unit.property_id " +
                "JOIN address ON property.address_id = address.address_id";

        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql);
        while(rows.next()) {
            properties.add(mapRowToProperty(rows));
        }
        return properties;
    }

    @Override
    public Property addProperty(Property property) {
        property.setPropertyId(getMaxIdPlusOne());

//        // might need a propertyId?
//        String sqlForProperty = "INSERT INTO property (property_name, image_name, address_id) VALUES (?, ?, ?)";
//        jdbcTemplate.update(sqlForProperty, property.getPropertyId(),
//
////        String sqlForAddress = "";
//        String sqlForUnit = "";

        return property;
    }

    private Property mapRowToProperty(SqlRowSet rows) {
        Property property = new Property();

        property.setAddress(rows.getString("address"));
        property.setPropertyId(rows.getLong("property_id"));
        property.setPropertyName(rows.getString("property_name"));
        property.setImageName(rows.getString("image_name"));
        property.setApartmentNumber(rows.getString("apartment_number"));
        property.setMonthlyRent(rows.getDouble("monthly_rent"));
        property.setNumberOfRooms(rows.getInt("rooms"));
        property.setCity(rows.getString("city"));
        property.setState(rows.getString("state"));
        property.setZipcode(rows.getInt("zip"));

        return property;
    }

    private long getMaxID() {
        long maxID = 0;
        List<Property> properties = getAllProperties();
        for (Property property : properties) {
            if (property.getPropertyId() > maxID) {
                maxID = property.getPropertyId();
            }
        }
        return maxID;
    }

    /**
     * Adds 1 to the max id and returns it
     *
     * @return
     */
    private long getMaxIdPlusOne() {
        return getMaxID() + 1;
    }
}

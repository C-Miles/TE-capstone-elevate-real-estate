package com.techelevator.dao;

import com.techelevator.model.Property;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPropertyDAO implements PropertyDAO {

    private final JdbcTemplate jdbcTemplate;

    public JdbcPropertyDAO(DataSource datasource) {
        this.jdbcTemplate = new JdbcTemplate(datasource);
    }

    @Override
    public List<Property> getAllProperties() {

        List<Property> properties = new ArrayList<Property>();

        String sql = "SELECT property_name, unit_id, image_name, rooms, monthly_rent, address, apartment_number, property.property_id AS property_id, city, state, zip FROM property " +
                "JOIN unit ON property.property_id = unit.property_id " +
                "JOIN address ON property.address_id = address.address_id";

        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql);
        while (rows.next()) {
            properties.add(mapRowToProperty(rows));
        }
        return properties;
    }

    @Transactional
    @Override
    public Property addProperty(Property property) {
        // property.setPropertyId(getMaxIdPlusOne());

        Property forInsertProperty = insertAddress(property);
        Property forInsertUnit = insertProperty(forInsertProperty);
        Property completeProperty = insertUnit(forInsertUnit);

        return completeProperty;
    }

    public Property insertAddress(Property property) {

        String sqlAddress = "INSERT INTO address (address_id, address, city, state, zip) VALUES (default, ?, ?, ?, ?) RETURNING address_id";

        long addressId = jdbcTemplate.queryForObject(sqlAddress, long.class, property.getAddress(), property.getCity(), property.getState(), property.getZipcode());
        property.setAddressID(addressId);
        return property;
    }

    //insert into property
    public Property insertProperty(Property property) {
        String sqlProperty = "INSERT INTO property (property_id, property_name, image_name, address_id) VALUES (default, ?, ?, ?) RETURNING property_id";

        long addressId = getMaxID();
        long propertyId = jdbcTemplate.queryForObject(sqlProperty, long.class, property.getPropertyName(), property.getImageName(), property.getAddressID());
        property.setPropertyId(propertyId);
        return property;
    }

    // insert into unit
    public Property insertUnit(Property property) {

        String sqlUnit = "INSERT INTO unit (unit_id, rooms, apartment_number, monthly_rent, address_id, property_id) VALUES (DEFAULT, ?, ?, ?, ?, ?) RETURNING unit_id";

        long unitId = jdbcTemplate.queryForObject(sqlUnit, long.class, property.getNumberOfRooms(), property.getApartmentNumber(), property.getMonthlyRent(), property.getAddressID(), property.getPropertyId());
        property.setUnitID(unitId);
        return property;
    }

    private Property mapRowToProperty(SqlRowSet rows) {
        Property property = new Property();

        property.setAddress(rows.getString("address"));
        property.setPropertyId(rows.getLong("property_id"));
        property.setPropertyName(rows.getString("property_name"));
        property.setUnitID(rows.getLong("unit_id"));
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
                maxID = property.getAddressID();
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

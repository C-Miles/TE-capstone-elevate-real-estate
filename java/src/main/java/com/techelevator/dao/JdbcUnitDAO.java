package com.techelevator.dao;

import com.techelevator.model.Property;
import com.techelevator.model.Unit;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcUnitDAO implements UnitDAO{

    private final JdbcTemplate jdbcTemplate;

    public JdbcUnitDAO(DataSource datasource) {

        this.jdbcTemplate = new JdbcTemplate(datasource);
    }

    @Override
    public List<Unit> getAllUnitsByPropertyId(long propertyId) {
        List<Unit> units = new ArrayList<Unit>();

        String sql = "SELECT property_name, unit_id, image_name, rooms, monthly_rent, apartment_number, unit.address_id, unit.property_id AS property_id FROM unit " +
                     "JOIN property ON property.property_id = unit.property_id WHERE property.property_id = ?";

        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql);
        while(rows.next()) {
            units.add(mapRowToProperty(rows));
        }
        return units;
    }
    private Unit mapRowToProperty(SqlRowSet rows) {
        Unit unit = new Unit();

        unit.setPropertyName(rows.getString("property_name"));
        unit.setUnitID(rows.getLong("unit_id"));
        unit.setImageName(rows.getString("image_name"));
        unit.setNumberOfRooms(rows.getInt("rooms"));
        unit.setMonthlyRent(rows.getDouble("monthly_rent"));
        unit.setApartmentNumber(rows.getString("apartment_number"));
        unit.setPropertyID(rows.getLong("property_id"));

        return unit;
    }
}

package com.techelevator.dao;


import com.techelevator.model.Property;
import org.junit.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;


import java.sql.SQLException;
import java.util.List;


public class DAOPropertyTest{
    private JdbcPropertyDAO jdbcPropertyDAO;
    private JdbcTemplate jdbcTemplate;
    private static SingleConnectionDataSource dataSource;

    @Before
    public void setUp() {
        jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcPropertyDAO = new JdbcPropertyDAO(dataSource);

    }
    @BeforeClass
    public static void setupDataSource() {

        dataSource = new SingleConnectionDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/final_capstone");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");
        dataSource.setAutoCommit(false);
    }
    @AfterClass
    public static void closeDataSource() throws SQLException {
        dataSource.destroy();
    }
    @After
    public void rollback() throws SQLException {
        dataSource.getConnection().rollback();
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

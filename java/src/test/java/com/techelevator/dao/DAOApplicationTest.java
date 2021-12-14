package com.techelevator.dao;

import com.techelevator.model.Application;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

public class DAOApplicationTest extends DAOIntegrationTest{

        private JdbcApplicationDAO jdbcApplicationDAO;
        private JdbcTemplate jdbcTemplate;

    @Before
    public void setUp() {

        jdbcTemplate = new JdbcTemplate(getDataSource());
        jdbcApplicationDAO = new JdbcApplicationDAO(getDataSource());
    }
    @Test
    public void get_application() {
        
    }

    private Application insertApplication(long rentAppId, String firstName, String lastName, String emailAddress, String phoneNumber) {
     Application application = new Application();
     application.setRentAppId(rentAppId);
     application.setFirstName(firstName);
     application.setLastName(lastName);
     application.setEmailAddress(emailAddress);
     application.setPhoneNumber(phoneNumber);

     String sql = "INSERT INTO application(rent_app_id, first_name, last_name, email_address, phone_number) VALUES (DEFAULT, 'sonam', 'miles', 'johndoe@aol.com', 1234567890) RETURNING rent_app_id";
    rentAppId = jdbcTemplate.queryForObject(sql, Long.class, firstName, lastName, emailAddress, phoneNumber);
    application.setRentAppId(rentAppId);
    return application;

    }




    }


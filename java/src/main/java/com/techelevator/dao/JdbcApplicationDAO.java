package com.techelevator.dao;

import com.techelevator.model.Application;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class JdbcApplicationDAO implements ApplicationDAO {

    private final JdbcTemplate jdbcTemplate;

    public JdbcApplicationDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Application addApplication(Application application) {

        String sqlApplication = "INSERT INTO application (rent_app_id, first_name, " +
        "last_name, email_address, phone_number, application_status, unit_id) " +
                "VALUES (default, ?, ?, ?, ?, 'APPROVED', ?) " +
                "RETURNING rent_app_id";

        long applicationId = jdbcTemplate.queryForObject(sqlApplication, long.class, application.getFirstName(), application.getLastName(), application.getEmailAddress(), application.getPhoneNumber(), application.getUnitId());
        application.setRentAppId(applicationId);

        return application;
    }

}

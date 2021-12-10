package com.techelevator.dao;

import org.junit.Before;
import org.springframework.jdbc.core.JdbcTemplate;

public class DAOApplicationTest extends DAOIntegrationTest{

        private JdbcApplicationDAO jdbcApplicationDAO;
        private JdbcTemplate jdbcTemplate;

        @Before
    public void setUp() {

        jdbcTemplate = new JdbcTemplate(getDataSource());
        jdbcApplicationDAO = new JdbcApplicationDAO(getDataSource());
    }





    }


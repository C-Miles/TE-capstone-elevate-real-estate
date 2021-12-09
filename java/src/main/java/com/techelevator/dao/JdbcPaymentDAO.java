package com.techelevator.dao;

import com.techelevator.model.Payment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.security.Principal;

@Component
public class JdbcPaymentDAO implements PaymentDAO {

    private final JdbcTemplate jdbcTemplate;

    public JdbcPaymentDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Payment addPayment(Payment payment) {

        String sql = "INSERT INTO payment_details (payment_details_id, username, unit_id, " +
        "credit_card, expiration_date, cvc, amount, payment_approved) VALUES (default, ?, ?, ?, ?, ?, ?, 'true') RETURNING payment_details_id";

        long paymentId = jdbcTemplate.queryForObject(sql, Long.class, payment.getUserName(), payment.getUnitId(),
                payment.getCardNumber(), payment.getExpirationDate(), payment.getCvc(), payment.getAmountPaid());

        payment.setPaymentId(paymentId);

        return payment;
    }
}

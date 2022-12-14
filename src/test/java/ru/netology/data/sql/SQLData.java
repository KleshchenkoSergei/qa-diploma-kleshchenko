package ru.netology.data.sql;

import lombok.val;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLData {

    private static final String url = System.getProperty("db.url");
    private static final String user = System.getProperty("db.user");
    private static final String password = System.getProperty("db.password");
    private static Connection connection;

    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(url, user, password);

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return connection;
    }

    public static void dropDataBase() {
        val runner = new QueryRunner();
        val order = "DELETE FROM app.order_entity";
        val payment = "DELETE FROM app.payment_entity";
        val creditRequest = "DELETE FROM app.credit_request_entity";

        try (val connection = getConnection()) {
            runner.update(connection, order);
            runner.update(connection, payment);
            runner.update(connection, creditRequest);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public static String getCardStatusForPayment() {
        String statusQuery = "SELECT * FROM app.payment_entity";
        val runner = new QueryRunner();
        try (Connection connection = getConnection()) {
            val cardStatus = runner.query(connection, statusQuery, new BeanHandler<>(SQLPaymentData.class));
            return cardStatus.getStatus();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }

    public static String getCardStatusForCredit() {
        String statusQuery = "SELECT * FROM app.credit_request_entity";
        val runner = new QueryRunner();
        try (Connection connection = getConnection()) {
            val cardStatus = runner.query(connection, statusQuery, new BeanHandler<>(SQLCreditData.class));
            return cardStatus.getStatus();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }

    public static String getPaymentIdForPay() {
        val idQueryForCardPay = "SELECT * FROM app.order_entity";
        val runner = new QueryRunner();
        try (val connection = getConnection()) {
            val paymentId = runner.query(connection, idQueryForCardPay, new BeanHandler<>(SQLOrderData.class));
            return paymentId.getPayment_id();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getPaymentIdForCredit() {
        val idQueryForCreditRequest = "SELECT * FROM app.order_entity";
        val runner = new QueryRunner();
        try (val connection = getConnection()) {
            val paymentId = runner.query(connection, idQueryForCreditRequest, new BeanHandler<>(SQLOrderData.class));
            return paymentId.getPayment_id();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getTransactionId() {
        val runner = new QueryRunner();
        String idTransactionQuery = "SELECT * FROM app.payment_entity";
        try (Connection connection = getConnection()) {
            val transactionId = runner.query(connection, idTransactionQuery, new BeanHandler<>(SQLPaymentData.class));
            return transactionId.getTransaction_id();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }

    public static String getAmountPayment() {
        val runner = new QueryRunner();
        String amountQuery = "SELECT * FROM app.payment_entity";
        try (Connection connection = getConnection()) {
            val transactionId = runner.query(connection, amountQuery, new BeanHandler<>(SQLPaymentData.class));
            return transactionId.getAmount();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }

    public static String getBankId() {
        String bankIdQuery = "SELECT * FROM app.credit_request_entity";
        val runner = new QueryRunner();
        try (Connection connection = getConnection()) {
            val bankId = runner.query(connection, bankIdQuery, new BeanHandler<>(SQLCreditData.class));
            return bankId.getBank_id();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }
}

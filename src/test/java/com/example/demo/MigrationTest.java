package com.example.demo;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.Rollback;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static com.example.demo.IntegrationEnvironment.DB_CONTAINER;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MigrationTest {
    @Test
    @Transactional
    @Rollback
    void migrationsAreRunningSuccessfully() throws Exception {
        try (var connection = DB_CONTAINER.createConnection("")) {
            PreparedStatement preparedStatementForUpdate = connection.prepareStatement
                    ("INSERT INTO _user(id, email, firstname, lastname, password, role) VALUES " +
                            "(1, 'email@mail.com', 'Ivan', 'Ivanov', '123', 'ADMIN')"
                    );

            PreparedStatement preparedStatementForQuery = connection.prepareStatement("SELECT * FROM _user");

            int resultUpdate = preparedStatementForUpdate.executeUpdate();

            ResultSet resultQuery = preparedStatementForQuery.executeQuery();
            resultQuery.next();

            assertAll(
                    () -> assertEquals(1, resultUpdate),
                    () -> assertEquals(1, resultQuery.getLong("id"))
            );
        }
    }
}

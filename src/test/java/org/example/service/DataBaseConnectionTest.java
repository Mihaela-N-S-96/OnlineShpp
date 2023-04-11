package org.example.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

import static junit.framework.TestCase.assertNotNull;

@SpringBootTest
public class DataBaseConnectionTest {

    @Autowired
    private DataSource dataSource;

    @Test
    public void testDatabaseConnection() throws Exception {
        assertNotNull(dataSource.getConnection());
    }
}

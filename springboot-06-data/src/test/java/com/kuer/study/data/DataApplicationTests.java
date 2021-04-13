package com.kuer.study.data;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class DataApplicationTests {

    @Autowired
    private DataSource dataSource;

    @Test
    void contextLoads() throws SQLException {
        Connection connection = dataSource.getConnection();
        // 默认数据源com.zaxxer.hikari.HikariDataSource
        System.out.println(dataSource.getClass());

        System.out.println(connection);
        connection.close();
    }

}

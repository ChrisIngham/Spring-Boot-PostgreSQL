package com.ChristopherIngham.Spring_Boot_PostgreSQL;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = "spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration")
class SpringBootPostgreSqlApplicationTests {
    @Test
    void contextLoads() {}
}


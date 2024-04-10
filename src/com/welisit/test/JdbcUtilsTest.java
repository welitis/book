package com.welisit.test;

import com.welisit.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

 public class JdbcUtilsTest {

    @Test
    public void testJdbcUtils() throws SQLException {
        for (int i = 0; i < 100; i++) {

            Connection conn = JdbcUtils.getConnection();
            System.out.println(conn + "  ----" +i);
            JdbcUtils.close(conn);
        }
    }
}

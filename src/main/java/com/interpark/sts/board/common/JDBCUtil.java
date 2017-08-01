package com.interpark.sts.board.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by 최지혜 on 2017-07-28.
 */
public class JDBCUtil {

    public static Connection getConnection() {
        try {
            Class.forName("org.h2.Driver");
            return DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test;FILE_LOCK=NO;AUTO_SERVER=TRUE", "sa", "");
//            return DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE;AUTO_SERVER=TRUE", "sa", "");
//            return DriverManager.getConnection("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE", "sa", "");
//            return DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void close(PreparedStatement stmt, Connection conn) {
        if(stmt != null ) {
            try {
                if(!stmt.isClosed()) {
                    stmt.close();
                }
            } catch (Exception e) {
                e.printStackTrace();;
            } finally {
                stmt = null;
            }
        }

        if(conn != null) {
            try {
                if(!conn.isClosed()) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                conn = null;
            }
        }
    }

    public static void close(ResultSet rs, PreparedStatement stmt, Connection conn) {
        try {
            if(rs != null && !rs.isClosed()) {
                rs.close();
            }
            if(stmt != null && !stmt.isClosed()) {
                stmt.close();
            }
            if(conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rs = null;
            stmt = null;
            conn = null;
        }
    }

}

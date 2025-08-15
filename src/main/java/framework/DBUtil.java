
package framework;

import java.sql.*;

public class DBUtil {
    public static boolean sampleHealthCheck() {
        try (Connection conn = DriverManager.getConnection(
                Config.load().getProperty("db.url"),
                Config.load().getProperty("db.user"),
                Config.load().getProperty("db.pass"))) {
            try (PreparedStatement ps = conn.prepareStatement("SELECT 1")) {
                try (ResultSet rs = ps.executeQuery()) {
                    return rs.next();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

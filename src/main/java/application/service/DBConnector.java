package application.service;

import java.sql.*;

public class DBConnector {
    private static final String url = "jdbc:mysql://localhost:3306/distance_calculator";
    private static final String user = "D";
    private static final String password = "1";


    private DBConnector() {
    }

    public static Connection getConnection() throws Exception {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("ERROR: Connection Failed " + e.getMessage());
        }
        return connection;

    }


    public static void closeConnection(Connection con) throws Exception {
        if (con != null)
            con.close();
    }

    public static void closeConnectionAll(Connection con, Statement st, ResultSet rs) throws Exception {
        if (con != null)
            con.close();
        if (st != null)
            st.close();
        if (rs != null)
            rs.close();
    }
}

package dz2;

import java.sql.*;

public class Products {
    Connection conn;
    Statement stmt;

    public Products(Connection conn, Statement stmt) throws SQLException {
        this.conn = conn;
        this.stmt = stmt;
        stmt.executeUpdate("DELETE FROM Products;");
        stmt.executeUpdate("DELETE FROM sqlite_sequence WHERE name='Products';");
        fillDB(10000);
    }

    private void fillDB (int num) throws SQLException {
        conn.setAutoCommit(false);
        String sql;
        for (int i=1; i<=num; i++) {
            sql = "INSERT INTO Products (prodid, title, cost) VALUES (" + i + ", 'товар" + i + "', " + (int)(Math.random()*10000) + ");";
            stmt.executeUpdate(sql);
        }
        conn.commit();
    }

    public int cost (String tovar) throws SQLException {
        int cost = -1;
        String sql = "SELECT cost FROM Products WHERE title='" + tovar + "';";
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            cost = rs.getInt(1);
        }
        return cost;
    }

    public void updateCost (String tovar, int cost) throws SQLException {
        String sql = "UPDATE Products SET cost= " + cost + " WHERE title ='" + tovar + "';";
        stmt.executeUpdate(sql);
    }

    public void rangeCostTovars (int start, int finish) throws SQLException {
        String sql = "SELECT title, cost FROM Products WHERE cost > " + start + " AND cost < " + finish + ";";
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getString(1) + " стоит " + rs.getInt(2));
        }
    }


}

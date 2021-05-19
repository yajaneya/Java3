package dz6;

import java.sql.*;

public class Z3 {
    private Connection conn;
    private Statement stmt;

    public Z3() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:Education.db");
        stmt = conn.createStatement();
        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Students (id integer primary key autoincrement not null, surname text not null, mark integer);");
    }

    public void endSessions() throws SQLException {
        conn.close();
    }

    // возвращает id вставленной записи
    public int add (String fam, int mark) throws SQLException {
        String sql = "INSERT INTO Students (surname, mark) VALUES ('" + fam + "', " + mark + ");";
        stmt.executeUpdate(sql);
        return stmt.executeQuery("SELECT max(id) From Students").getInt(1);
    }

    //возвращает true, если запись найдена
    public boolean find (int id, String surname, int mark) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM Students WHERE id ="+id+" AND surname='"+surname+"' AND mark="+mark+";");
        ResultSet rs = ps.executeQuery();
        return (rs.getInt(1)==id) & (rs.getString(2).equals(surname)) & (rs.getInt(3)==mark);
    }

    public String read (int id) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM Students WHERE id ="+id+";");
        ResultSet rs = ps.executeQuery();
        return rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3);
    }


    public void update (int id, String surname, int mark) throws SQLException {
        stmt.executeUpdate("UPDATE Students SET id=" + id + ", surname='" + surname + "', mark=" + mark + " WHERE id=" + id + ";");
    }

    public void delete (int id) throws SQLException {
        stmt.executeUpdate("DELETE FROM Students WHERE id="+id+";");
        stmt.executeUpdate("DELETE FROM sqlite_sequence WHERE name='Students';");
    }

}

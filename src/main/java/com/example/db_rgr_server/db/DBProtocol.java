package com.example.db_rgr_server.db;

import com.example.db_rgr_server.model.Good;

import java.sql.*;

public class DBProtocol {

    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String user = "postgres";
    private final String password = "admin";

    private Connection connection;

    private final String sqlCreateTable = "CREATE TABLE IF NOT EXISTS goods ( \n "
            + "    id INTEGER PRIMARY KEY,\n"
            + "    good_name TEXT NOT NULL,\n"
            + "    price INTEGER NOT NULL\n"
            + ");";

    public void connect() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
            Statement initStatement = connection.createStatement();
            initStatement.execute(sqlCreateTable);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveGood(Good good){
        try{
            Statement st = connection.createStatement();
            System.out.println("INSERT INTO goods (id, good_name, price) VALUES ("+good.getId()+",'" + good.getName()+"',"+good.getPrice()+")");
            st.execute("INSERT INTO goods (id, good_name, price) VALUES ("+good.getId()+",'" + good.getName()+"',"+good.getPrice()+")");
            System.out.println("data inserted");
            /*ResultSet rs = st.executeQuery(query);

            if (rs.next()) {
                // 5. Close all connections
                rs.close();
                st.close();
                con.close();
                return true;
            }

            // 5. Close all connections
            rs.close();
            st.close();
            con.close();
            return false;*/
        }
        catch (SQLException e) {
            System.out.println(e.toString());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}

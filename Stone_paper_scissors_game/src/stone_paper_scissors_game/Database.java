/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stone_paper_scissors_game;

import javafx.collections.ObservableList;
import java.sql.*;
import javafx.collections.FXCollections;
/**
 *
 * @author HP
 */
public class Database {
    
        public Connection getConnnection() {
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "");
            System.out.println("db connected");
            return conn;
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            System.out.println("unsuccessful connection");
            return null;
        }
    }
    public ObservableList<Users> getStudents() {
        ObservableList<Users> studentList = FXCollections.observableArrayList();
        Connection conn = getConnnection();
        String query = "SELECT * FROM score";
        
        Statement st;
        ResultSet rs;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Users students = null;
            while (rs.next()) {
                students = new Users(rs.getString("name"), rs.getString("email"), rs.getInt("max"));
                studentList.add(students);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentList;
    }
    
}

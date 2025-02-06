

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
    public ObservableList<LoginUser> getUsers() {
        ObservableList<LoginUser> studentList = FXCollections.observableArrayList();
        Connection conn = getConnnection();
//        String query = "SELECT * FROM login ORDER BY max DESC";
        String query = "SELECT *, (SELECT COUNT(*) FROM login AS l2 WHERE l2.max > l1.max) AS rows_after " +
                       "FROM login AS l1 ORDER BY max DESC";
        
        Statement st;
        ResultSet rs;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            
            while (rs.next()) {
                LoginUser u = new LoginUser();
                           u.setName(rs.getString("name"));
            u.setEmail(rs.getString("email"));
            u.setPassword(rs.getString("password"));
            u.setMax(rs.getInt("max"));
            
            u.setRank(rs.getInt("rows_after")+1);
            
            u.setDate(rs.getString("date"));
                studentList.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentList;
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

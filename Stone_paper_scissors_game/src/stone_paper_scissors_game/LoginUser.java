/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stone_paper_scissors_game;

/**
 *
 * @author HP
 */
public class LoginUser {
    private String name,email,password,date;
    private int max,rank;

//    public LoginUser(String name, String email, String password, String date, int max, int rank) {
//        this.name = name;
//        this.email = email;
//        this.password = password;
//        this.date = date;
//        this.max = max;
//        this.rank = rank;
//    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getDate() {
        return date;
    }

    public int getMax() {
        return max;
    }

    public int getRank() {
        return rank;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stone_paper_scissors_game;

/**
 *
 * @author HP
 */
public class Users {
    
    private String name;
    private String email;
    private Integer max;

    public Users(String name, String email, int max) {
        this.name = name;
        this.email = email;
        this.max = new Integer(max);
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getMax() {
        return max.intValue();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMax(int max) {
        this.max = max;
    }
   
    
    
}

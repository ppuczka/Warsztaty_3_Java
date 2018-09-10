package pl.coderslab.model;

import pl.coderslab.org.mindrot.BCrypt;

public class User extends Group {

    public int id;
    public String username;
    public String password;
    public String email;


    public User() {
        }

    public User(int id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    public User(String name, int groupId, int id, String username, String password, String email) {
        super(groupId, name);
        this.id = id;
        this.username = username;
        this.email = email;
        setPassword(password);
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return this.username + " " + this.email + " " + this.password + " " +
                this.email + " " + this.name + " " + this.groupId;
    }
}




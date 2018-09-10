package pl.coderslab.model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Exercise extends User {

    public int id;
    public String title;
    public String description;

    public  Exercise() {

    }

    public Exercise(String title, String description, int id) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Exercise(String name, int groupId, int id, String username, String password, String email, int id1, String title, String description) {
        super(name, groupId, id, username, password, email);
        this.id = id1;
        this.title = title;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return this.id + " " + this.title + " " + this.description;
    }


}

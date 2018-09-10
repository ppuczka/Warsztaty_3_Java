package pl.coderslab.model;

import java.sql.*;
import java.util.ArrayList;

public class Solution extends Exercise {

    public int id;
    public java.sql.Date created;
    public java.sql.Date updated;
    public String description;
    public int exercise_id;
    public int users_id;
    public int limit;

    public Solution() {

    }

    public Solution(String name, int groupId, int id, String username, String password, String email, int id1,
                    String title, String description, Date created, Date updated, String solDescription,
                    int exercise_id, int users_id) {
        super(name, groupId, id, username, password, email, id1, title, description);
        this.created = created;
        this.updated = updated;
        this.description = solDescription;
        this.exercise_id = exercise_id;
        this.users_id = users_id;
    }

    public Solution(String name, int groupId, int id, String username, String password, String email, int id1, String title,
                    String description, int id2, Date created, Date updated, String solDescription, int exercise_id,
                    int users_id, int limit) {

        super(name, groupId, id, username, password, email, id1, title, description);
        this.id = id2;
        this.created = created;
        this.updated = updated;
        this.description = solDescription;
        this.exercise_id = exercise_id;
        this.users_id = users_id;
        this.limit = limit;
    }

    public int getId() {
        return id;
    }

    public java.sql.Date getCreated() {
        return created;
    }

    public java.sql.Date getUpdated() {
        return updated;
    }

    public String getDescription() {
        return description;
    }

    public int getExercise_id() {
        return exercise_id;
    }

    public int getUsers_id() {
        return users_id;
    }

    public void setCreated(java.sql.Date created) {
        this.created = created;
    }

    public void setUpdated(java.sql.Date updated) {
        this.updated = updated;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setExercise_id(int exercise_id) {
        this.exercise_id = exercise_id;
    }

    public void setUsers_id(int users_id) {
        this.users_id = users_id;
    }


    @Override
    public String toString() {
        return this.id + " " + this.username + " " + this.email + "  " + this.created + " " + this.updated +
                " " + this.description + " " + this.exercise_id + " " + this.users_id + " " +  this.title +
                " " + this.description;
    }

}







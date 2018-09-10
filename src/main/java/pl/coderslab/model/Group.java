package pl.coderslab.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Group {

    public int groupId;
    public String name;


    public Group() {
    }

    public Group(int groupId, String name) {
        this.groupId = groupId;
        this.name = name;
    }

    public Group(String name) {
        this.name = name;
    }

    public int getGroupId() {
        return groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }


    @Override
    public String toString() {
        return this.groupId + this.name;
    }
}



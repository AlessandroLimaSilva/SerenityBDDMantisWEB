package org.ale.types;

import org.ale.utils.Utils;

import java.util.Map;

public class Tag {

    private int userID;
    private String name;
    private int dateCreated;
    private int dateUpdate;

    public Tag(Map<String,Object> map){
        setUserID((Integer) map.get("userID"));
        setName(map.get("name").toString());
        setDateCreated(Utils.getDataEpochTime());
        setDateUpdate(Utils.getDataEpochTime());
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateCreated(int dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setDateUpdate(int dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public int getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public int getDateCreated() {
        return dateCreated;
    }

    public int getDateUpdate() {
        return dateUpdate;
    }
}

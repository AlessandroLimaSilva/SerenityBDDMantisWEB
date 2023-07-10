package org.ale.types;

import java.util.Map;

public class BugHistoryTable {

    private int userID;
    private int bugID;
    private String fieldName;
    private String oldValue;
    private String newValue;
    private int type;
    private int dateModified;

    public BugHistoryTable(Map<String,Object> map){
        setUserID((Integer) map.get("description"));
        setBugID((Integer) map.get("description"));
        setFieldName(map.get("description").toString());
        setOldValue(map.get("description").toString());
        setType((Integer) map.get("description"));
        setDateModified((Integer) map.get("description"));
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setBugID(int bugID) {
        this.bugID = bugID;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setDateModified(int dateModified) {
        this.dateModified = dateModified;
    }

    public int getUserID() {
        return userID;
    }

    public int getBugID() {
        return bugID;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getOldValue() {
        return oldValue;
    }

    public String getNewValue() {
        return newValue;
    }

    public int getType() {
        return type;
    }

    public int getDateModified() {
        return dateModified;
    }
}

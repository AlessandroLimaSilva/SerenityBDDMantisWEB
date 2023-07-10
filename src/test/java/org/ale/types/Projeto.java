package org.ale.types;

import java.util.Map;

public class Projeto {

    private String name;
    private int status;
    private int enabled;
    private int viewState;
    private int accessMin;
    private String description;
    private int categoryID;
    private int inheritGlobal;

    public Projeto(Map<String,Object> map){
        setName(map.get("name").toString());
        setStatus((Integer) map.get("status"));
        setEnabled((Integer) map.get("enabled"));
        setViewState((Integer) map.get("viewState"));
        setAccessMin((Integer) map.get("accessMin"));
        setDescription(map.get("description").toString());
        setCategoryID((Integer) map.get("categoryID"));
        setInheritGlobal((Integer) map.get("inheritGlobal"));
    }

    public void setName(String name){
        this.name = name;
    }

    public void setStatus(int status){
        this.status = status;
    }

    public void setEnabled(int enabled){
        this.enabled = enabled;
    }

    public void setViewState(int viewState){
        this.viewState = viewState;
    }

    public void setAccessMin(int accessMin){
        this.accessMin = accessMin;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setCategoryID(int categoryID){
        this.categoryID = categoryID;
    }

    public void setInheritGlobal(int inheritGlobal){
        this.inheritGlobal = inheritGlobal;
    }

    public String getName(){
        return name;
    }

    public int getStatus() {
        return status;
    }

    public int getEnabled() {
        return enabled;
    }

    public int getViewState() {
        return viewState;
    }

    public int getAccessMin() {
        return accessMin;
    }

    public String getDescription() {
        return description;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public int getInheritGlobal() {
        return inheritGlobal;
    }
}

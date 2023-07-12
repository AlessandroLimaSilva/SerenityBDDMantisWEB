package org.ale.types;

import java.util.Map;

public class Tarefa {

    private int projectID;
    private int reporterID;
    private int handlerID;
    private int duplicateID;
    private int priority;
    private int severity;
    private int reproducibility;
    private int status;
    private int resolution;
    private int projection;
    private int eta;
    private int profileID;
    private int viewState;
    private String summary;
    private int spondorshipTotal;
    private int sticky;
    private int categoryID;
    private int dateSubmitted;
    private int dueDate;
    private int lastUpdate;

    public Tarefa(Map<String,Object> map){
        setProjectID((Integer) map.get("projectID"));
        setReporterID((Integer) map.get("reporterID"));
        setHandlerID((Integer) map.get("handlerID"));
        setDuplicateID((Integer) map.get("duplicateID"));
        setPriority((Integer) map.get("priority"));
        setSeverity((Integer) map.get("severity"));
        setReproducibility((Integer) map.get("reproducibility"));
        setStatus((Integer) map.get("status"));
        setResolution((Integer) map.get("resolution"));
        setProjection((Integer) map.get("projection"));
        setEta((Integer) map.get("eta"));
        setProfileID((Integer) map.get("profileID"));
        setViewState((Integer) map.get("viewState"));
        setSummary(map.get("summary").toString());
        setSpondorshipTotal((Integer) map.get("spondorshipTotal"));
        setSticky((Integer) map.get("sticky"));
        setCategoryID((Integer) map.get("categoryID"));
        setDateSubmitted((Integer) map.get("dateSubmitted"));
        setDueDate((Integer) map.get("dueDate"));
        setLastUpdate((Integer) map.get("lastUpdate"));
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public void setReporterID(int reporterID) {
        this.reporterID = reporterID;
    }

    public void setHandlerID(int handlerID) {
        this.handlerID = handlerID;
    }

    public void setDuplicateID(int duplicateID) {
        this.duplicateID = duplicateID;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setSeverity(int severity) {
        this.severity = severity;
    }

    public void setReproducibility(int reproducibility) {
        this.reproducibility = reproducibility;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setResolution(int resolution) {
        this.resolution = resolution;
    }

    public void setProjection(int projection) {
        this.projection = projection;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public void setProfileID(int profileID) {
        this.profileID = profileID;
    }

    public void setViewState(int viewState) {
        this.viewState = viewState;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setSpondorshipTotal(int spondorshipTotal) {
        this.spondorshipTotal = spondorshipTotal;
    }

    public void setSticky(int sticky) {
        this.sticky = sticky;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public void setDateSubmitted(int dateSubmitted) {
        this.dateSubmitted = dateSubmitted;
    }

    public void setDueDate(int dueDate) {
        this.dueDate = dueDate;
    }

    public void setLastUpdate(int lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public int getProjectID() {
        return projectID;
    }

    public int getReporterID() {
        return reporterID;
    }

    public int getHandlerID() {
        return handlerID;
    }

    public int getDuplicateID() {
        return duplicateID;
    }

    public int getPriority() {
        return priority;
    }

    public int getSeverity() {
        return severity;
    }

    public int getReproducibility() {
        return reproducibility;
    }

    public int getStatus() {
        return status;
    }

    public int getResolution() {
        return resolution;
    }

    public int getProjection() {
        return projection;
    }

    public int getEta() {
        return eta;
    }

    public int getProfileID() {
        return profileID;
    }

    public int getViewState() {
        return viewState;
    }

    public String getSummary() {
        return summary;
    }

    public int getSpondorshipTotal() {
        return spondorshipTotal;
    }

    public int getSticky() {
        return sticky;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public int getDateSubmitted() {
        return dateSubmitted;
    }

    public int getDueDate() {
        return dueDate;
    }

    public int getLastUpdate() {
        return lastUpdate;
    }
}

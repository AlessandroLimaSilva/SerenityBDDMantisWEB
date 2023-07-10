package org.ale.types;

import java.util.Map;

public class BugTextTable {

    private String description;
    private String stepsToReproduce;
    private String additionalInformation;

    public BugTextTable(Map<String,Object> map){
        setDescription(map.get("description").toString());
        setStepsToReproduce(map.get("stepsToReproduce").toString());
        setAdditionalInformation(map.get("additionalInformation").toString());
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStepsToReproduce(String stepsToReproduce) {
        this.stepsToReproduce = stepsToReproduce;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public String getDescription() {
        return description;
    }

    public String getStepsToReproduce() {
        return stepsToReproduce;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }
}

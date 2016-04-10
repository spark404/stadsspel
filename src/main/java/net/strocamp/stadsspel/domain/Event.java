package net.strocamp.stadsspel.domain;

public class Event {
    private String groupName;
    private String event;
    private String locationCode;
    private String otherGroupName;
    private String amount;

    public Event() {
    }

    public Event(String groupName, String event, String locationCode, String otherGroupName, String amount) {
        this.groupName = groupName;
        this.event = event;
        this.locationCode = locationCode;
        this.otherGroupName = otherGroupName;
        this.amount = amount;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    public String getOtherGroupName() {
        return otherGroupName;
    }

    public void setOtherGroupName(String otherGroupName) {
        this.otherGroupName = otherGroupName;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}

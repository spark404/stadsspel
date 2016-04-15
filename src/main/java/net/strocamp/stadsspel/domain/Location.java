package net.strocamp.stadsspel.domain;

public class Location {
    private String code;
    private String reference;
    private String name;
    private int value;
    private int rentValue;
    private String ownerGroupName;

    public Location() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getOwnerGroupName() {
        return ownerGroupName;
    }

    public void setOwnerGroupName(String ownerGroupName) {
        this.ownerGroupName = ownerGroupName;
    }

    public int getRentValue() {
        return rentValue;
    }

    public void setRentValue(int rentValue) {
        this.rentValue = rentValue;
    }
}

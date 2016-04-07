package net.strocamp.stadsspel.domain;

public class Group {
    private String groupname;
    private String groupcode;

    public Group() {
    }

    public Group(String groupname, String groupcode) {
        this.groupname = groupname;
        this.groupcode = groupcode;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public String getGroupcode() {
        return groupcode;
    }

    public void setGroupcode(String groupcode) {
        this.groupcode = groupcode;
    }
}

package net.strocamp.stadsspel.domain;

public class Ranking {
    private int rank;
    private String groupName;
    private int money;

    public Ranking() {
    }

    public Ranking(int rank, String groupName, int money) {
        this.rank = rank;
        this.groupName = groupName;
        this.money = money;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}

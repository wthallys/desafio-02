package model;

public class DistributionCenter {
    private String name;
    private int capacity;

    public DistributionCenter(String name) {
        this.name = name;
        this.capacity = 1000;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}

package model;

public class Donation {
    private int id;
    private String itemType;
    private String itemDescription;
    private String itemExpirationDate;
    private int quantity;
    private int distributionCenter;

    public Donation(String itemType, String itemDescription, String itemExpirationDate, int quantity, int distributionCenter) {
        this.itemType = itemType;
        this.itemDescription = itemDescription;
        this.itemExpirationDate = itemExpirationDate;
        this.quantity = quantity;
        this.distributionCenter = distributionCenter;
    }

    public Donation(int id, String itemType, String itemDescription, String itemExpirationDate, int quantity, int distributionCenter) {
        this.id = id;
        this.itemType = itemType;
        this.itemDescription = itemDescription;
        this.itemExpirationDate = itemExpirationDate;
        this.quantity = quantity;
        this.distributionCenter = distributionCenter;
    }

    public int getId() {
        return id;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getItemExpirationDate() {
        return itemExpirationDate;
    }

    public void setItemExpirationDate(String itemExpirationDate) {
        this.itemExpirationDate = itemExpirationDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getDistributionCenter() {
        return distributionCenter;
    }

    public void setDistributionCenter(int distributionCenter) {
        this.distributionCenter = distributionCenter;
    }

    @Override
    public String toString() {
        return "Donation{id= " + id +
                ", itemType= " + itemType +
                ", itemDescription= " + itemDescription +
                ", itemExpirationDate= " + itemExpirationDate +
                ", quantity= " + quantity +
                ", distributionCenter= " + distributionCenter +
                "}";
    }
}

package model;

public class Donation {
    private int id;
    private String itemType;
    private String itemCategory;
    private String itemSize;
    private int quantity;
    private String distributionCenter;

    public Donation(String itemType, String itemCategory, String itemSize, int quantity, String distributionCenter) {
        this.itemType = itemType;
        this.itemCategory = itemCategory;
        this.itemSize = itemSize;
        this.quantity = quantity;
        this.distributionCenter = distributionCenter;
    }

    public Donation(int id, String itemType, String itemCategory, String itemSize, int quantity, String distributionCenter) {
        this.id = id;
        this.itemType = itemType;
        this.itemCategory = itemCategory;
        this.itemSize = itemSize;
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

    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    public String getItemSize() {
        return itemSize;
    }

    public void setItemSize(String itemSize) {
        this.itemSize = itemSize;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDistributionCenter() {
        return distributionCenter;
    }

    public void setDistributionCenter(String distributionCenter) {
        this.distributionCenter = distributionCenter;
    }

    @Override
    public String toString() {
        return "Donation{id= " + id +
                ", itemType= " + itemType +
                ", itemCategory= " + itemCategory +
                ", itemSize= " + itemSize +
                ", quantity= " + quantity +
                ", distributionCenter= " + distributionCenter +
                "}";
    }
}

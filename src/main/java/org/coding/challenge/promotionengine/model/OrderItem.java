package org.coding.challenge.promotionengine.model;

public class OrderItem {

    private String id;

    private String skuId;

    private int quantity;

    public OrderItem(String id, String skuId, int quantity) {
        this.id = id;
        this.skuId = skuId;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

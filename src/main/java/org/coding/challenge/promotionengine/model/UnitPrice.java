package org.coding.challenge.promotionengine.model;

public class UnitPrice {

    private String skuId;

    private double price;

    public UnitPrice(String skuId, double price) {
        this.skuId = skuId;
        this.price = price;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}

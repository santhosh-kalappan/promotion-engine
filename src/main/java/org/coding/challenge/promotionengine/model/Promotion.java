package org.coding.challenge.promotionengine.model;

import java.util.List;

public class Promotion {

    private String id;

    private List<String> skuIds;

    PromotionCategory category;

    private String description;

    private int percentage;

    private int quantity;

    private double price;

    public Promotion(String id, List<String> skuIds, PromotionCategory category, String description, int percentage, int quantity, double price) {
        this.id = id;
        this.skuIds = skuIds;
        this.category = category;
        this.description = description;
        this.percentage = percentage;
        this.quantity = quantity;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getSkuIds() {
        return skuIds;
    }

    public void setSkuIds(List<String> skuIds) {
        this.skuIds = skuIds;
    }

    public PromotionCategory getCategory() {
        return category;
    }

    public void setCategory(PromotionCategory category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}

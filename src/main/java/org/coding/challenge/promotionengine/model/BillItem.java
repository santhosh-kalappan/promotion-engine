package org.coding.challenge.promotionengine.model;

import java.util.ArrayList;
import java.util.List;

public class BillItem {

    private OrderItem orderItem;

    private double unitPrice;

    private List<Promotion> promotionsApplied;

    private double amount;

    public OrderItem getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public List<Promotion> getPromotionsApplied() {
        return promotionsApplied;
    }

    public void setPromotionsApplied(List<Promotion> promotionsApplied) {
        this.promotionsApplied = promotionsApplied;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void addPromotion(Promotion promotion) {
        if (promotionsApplied == null)
            promotionsApplied = new ArrayList<Promotion>();
        promotionsApplied.add(promotion);
    }

    public void calculateAmount() {

        if (promotionsApplied == null || promotionsApplied.size() == 0) {
            System.out.println("No promotion applied for order Item: " + orderItem.getId());
            amount = orderItem.getQuantity() * unitPrice;
        }

    }

}

package org.coding.challenge.promotionengine.model;

import java.util.ArrayList;
import java.util.List;

public class BillItem {

    private OrderItem orderItem;

    private double unitPrice;

    private List<Promotion> promotionsApplied;

    private double amount;

    private int units = 0;

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
            units += orderItem.getQuantity();
            amount = orderItem.getQuantity() * unitPrice;
        } else {
            promotionsApplied.stream().forEach(promotion -> {
                if (PromotionCategory.QUANTITY.equals(promotion.getCategory()) || PromotionCategory.COMBO.equals(promotion.getCategory())) {
                    System.out.println("Applying promotion " + promotion.getDescription());
                    amount += promotion.getPrice();
                    units += promotion.getQuantity();
                }
            });

            if (orderItem.getQuantity() > 0) {
                amount += orderItem.getQuantity() * unitPrice;
                units += orderItem.getQuantity();
            }
        }

        System.out.println(orderItem.getSkuId() + " x " + units + ": " + amount);

    }

}

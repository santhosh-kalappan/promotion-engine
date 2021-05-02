package org.coding.challenge.promotionengine.service;

import org.coding.challenge.promotionengine.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderAmountCalculatorImpl implements OrderAmountCalculator {

    private List<UnitPrice> unitPriceList;

    private List<Promotion> promotions;

    public OrderAmountCalculatorImpl(List<UnitPrice> unitPriceList, List<Promotion> promotions) {
        this.unitPriceList = unitPriceList;
        this.promotions = promotions;
    }

    @Override
    public double calculateOrderAmount(Order order) {

        List<BillItem> billItems = new ArrayList<BillItem>();

        List<OrderItem> orderItems = order.getItems();

        orderItems.stream().forEach(orderItem -> {

            BillItem billItem = new BillItem();
            billItem.setOrderItem(orderItem);

            unitPriceList.stream().forEach(unitPrice -> {
                if (orderItem.getSkuId() == unitPrice.getSkuId())
                    billItem.setUnitPrice(unitPrice.getPrice());
            });

            promotions.stream().forEach(promotion -> {
                if (PromotionCategory.QUANTITY.equals(promotion.getCategory())) {
                    int quantity = promotion.getQuantity();
                    int orderQuantity = orderItem.getQuantity();
                    while(quantity < orderQuantity) {
                        orderQuantity -= quantity;
                        billItem.addPromotion(promotion);
                    }
                }
            });

            billItem.calculateAmount();
            billItems.add(billItem);
        });

        double orderAmount = billItems.stream().mapToDouble(billItem ->  billItem.getAmount()).sum();

        return orderAmount;

    }

}

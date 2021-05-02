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
                    if (promotion.getSkuIds().contains(orderItem.getSkuId())) {
                        while (promotion.getQuantity() <= orderItem.getQuantity()) {
                            billItem.addPromotion(promotion);
                            orderItem.setQuantity(orderItem.getQuantity() - promotion.getQuantity());
                        }
                    }
                }
                if (PromotionCategory.COMBO.equals(promotion.getCategory())) {
                    if (promotion.getSkuIds().contains(orderItem.getSkuId())) {
                        while (orderItem.getQuantity() >= promotion.getQuantity()) {
                            if (checkAndApplyComboPromotion(order, promotion)) {
                                billItem.addPromotion(promotion);
                            } else {
                                return;
                            }
                        }
                    }
                }
            });

            billItem.calculateAmount();
            billItems.add(billItem);
        });

        double orderAmount = billItems.stream().mapToDouble(billItem -> billItem.getAmount()).sum();

        return orderAmount;

    }

    private boolean checkAndApplyComboPromotion(Order order, Promotion promotion) {
        boolean comboApplicable = false;
        List<String> orderSkuIds = new ArrayList<>();
        promotion.getSkuIds().stream().forEach(skuId -> {
            order.getItems().stream().forEach(orderItem -> {
                if (orderItem.getSkuId().equals(skuId) && orderItem.getQuantity() >= promotion.getQuantity()) {
                    orderSkuIds.add(skuId);
                }
            });
        });

        if (orderSkuIds.equals(promotion.getSkuIds())) {
            order.getItems().stream().forEach(orderItem -> {
                if (promotion.getSkuIds().contains(orderItem.getSkuId())) {
                    orderItem.setQuantity(orderItem.getQuantity() - promotion.getQuantity());
                }
            });
            return true;
        }

        return false;

    }

}

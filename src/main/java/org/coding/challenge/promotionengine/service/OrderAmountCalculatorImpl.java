package org.coding.challenge.promotionengine.service;

import org.coding.challenge.promotionengine.model.Order;
import org.coding.challenge.promotionengine.model.Promotion;
import org.coding.challenge.promotionengine.model.UnitPrice;

import java.util.List;

public class OrderAmountCalculatorImpl implements OrderAmountCalculator {

    private List<UnitPrice> unitPriceList;

    private List<Promotion> promotions;

    public OrderAmountCalculatorImpl(List<UnitPrice> unitPriceList, List<Promotion> promotions) {
        this.unitPriceList = unitPriceList;
        this.promotions = promotions;
    }

    @Override
    public double calculateOrderAmount(Order order) {
        return 0;
    }

}

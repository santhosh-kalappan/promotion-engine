package org.coding.challenge.promotionengine.service;

import org.coding.challenge.promotionengine.model.Order;

public interface OrderAmountCalculator {

    public double calculateOrderAmount(Order order);

}

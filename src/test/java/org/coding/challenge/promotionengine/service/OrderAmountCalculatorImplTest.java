package org.coding.challenge.promotionengine.service;

import org.coding.challenge.promotionengine.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class OrderAmountCalculatorImplTest {

    @Test
    public void testScenarioA() {
        OrderAmountCalculatorImpl orderAmountCalculator = new OrderAmountCalculatorImpl(getUnitPriceList(), getPromotions());
        double amount = orderAmountCalculator.calculateOrderAmount(createScenarioAOrder());
        System.out.println("Expected: 100, Actual: " + amount);
        Assert.assertTrue(100 == amount);
    }

    @Test
    public void testScenarioB() {
        OrderAmountCalculatorImpl orderAmountCalculator = new OrderAmountCalculatorImpl(getUnitPriceList(), getPromotions());
        double amount = orderAmountCalculator.calculateOrderAmount(createScenarioBOrder());
        System.out.println("Expected: 370, Actual: " + amount);
        Assert.assertTrue(370 == amount);
    }

    @Test
    public void testScenarioC() {
        OrderAmountCalculatorImpl orderAmountCalculator = new OrderAmountCalculatorImpl(getUnitPriceList(), getPromotions());
        double amount = orderAmountCalculator.calculateOrderAmount(createScenarioCOrder());
        System.out.println("Expected: 280, Actual: " + amount);
        Assert.assertTrue(280 == amount);
    }

    private Order createScenarioAOrder() {
        List<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(new OrderItem("OI1", "A", 1));
        orderItems.add(new OrderItem("OI2", "B", 1));
        orderItems.add(new OrderItem("OI3", "C", 1));
        Order order = new Order("O1", orderItems);
        return order;
    }

    private Order createScenarioBOrder() {
        List<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(new OrderItem("OI1", "A", 5));
        orderItems.add(new OrderItem("OI2", "B", 5));
        orderItems.add(new OrderItem("OI3", "C", 1));
        Order order = new Order("O2", orderItems);
        return order;
    }

    private Order createScenarioCOrder() {
        List<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(new OrderItem("OI1", "A", 3));
        orderItems.add(new OrderItem("OI2", "B", 5));
        orderItems.add(new OrderItem("OI3", "C", 1));
        orderItems.add(new OrderItem("OI4", "D", 1));
        Order order = new Order("O3", orderItems);
        return order;
    }

    private List<UnitPrice> getUnitPriceList() {
        List<UnitPrice> unitPriceList = new ArrayList<>();
        unitPriceList.add(new UnitPrice("A", 50));
        unitPriceList.add(new UnitPrice("B", 30));
        unitPriceList.add(new UnitPrice("C", 20));
        unitPriceList.add(new UnitPrice("D", 15));
        return unitPriceList;
    }

    private List<Promotion> getPromotions() {
        List<Promotion> promotions = new ArrayList<>();
        Arrays.asList("A");
        promotions.add(new Promotion("P1", Arrays.asList("A"), PromotionCategory.QUANTITY, "3 of A", 0, 3, 130));
        promotions.add(new Promotion("P2", Arrays.asList("B"), PromotionCategory.QUANTITY, "2 of B", 0, 2, 45));
        promotions.add(new Promotion("P3", Arrays.asList("C", "D"), PromotionCategory.COMBO, "C & D", 0, 3, 30));
        return promotions;
    }

}

package com.example.myapplication1109;

// 食材列表元素的类
public class Ingredients {
    private String name;
    private String amount;

    public String getName() {
        return name;
    }

    public String getAmount() {
        return amount;
    }

    public Ingredients(String name, String amount) {
        this.name = name;
        this.amount = amount;
    }
}

package com.example.expensetracker.model;

import java.time.LocalDate;

public class Expense {
    private Long id;
    private Long userId;         // kisko belong karta hai (simple)
    private String description;
    private String category;
    private double amount;
    private LocalDate date;

    public Expense() {}

    public Expense(Long id, Long userId, String description, String category, double amount, LocalDate date) {
        this.id = id;
        this.userId = userId;
        this.description = description;
        this.category = category;
        this.amount = amount;
        this.date = date;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
}

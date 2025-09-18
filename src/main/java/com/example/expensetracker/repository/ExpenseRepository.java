package com.example.expensetracker.repository;

import com.example.expensetracker.model.Expense;

import java.util.List;
import java.util.Optional;

public interface ExpenseRepository {
    Expense save(Expense expense);
    List<Expense> findAll();
    Optional<Expense> findById(Long id);
    void deleteById(Long id);
    List<Expense> findByUserId(Long userId);
    Expense update(Long id, Expense expense);
}

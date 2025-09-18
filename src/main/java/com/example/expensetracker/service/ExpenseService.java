package com.example.expensetracker.service;

import com.example.expensetracker.model.Expense;

import java.util.List;

public interface ExpenseService {
    Expense createExpense(Expense expense);
    List<Expense> getAllExpenses();
    Expense getExpenseById(Long id);
    Expense updateExpense(Long id, Expense expense);
    void deleteExpense(Long id);
    List<Expense> getExpensesByUser(Long userId);
}

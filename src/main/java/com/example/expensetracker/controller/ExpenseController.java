package com.example.expensetracker.controller;

import com.example.expensetracker.model.Expense;
import com.example.expensetracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    // CREATE
    @PostMapping
    public ResponseEntity<Expense> create(@RequestBody Expense expense) {
        Expense created = expenseService.createExpense(expense);
        return ResponseEntity.status(201).body(created);
    }

    // READ all
    @GetMapping
    public List<Expense> getAll() {
        return expenseService.getAllExpenses();
    }

    // READ by id
    @GetMapping("/{id}")
    public Expense getById(@PathVariable Long id) {
        return expenseService.getExpenseById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Expense update(@PathVariable Long id, @RequestBody Expense expense) {
        return expenseService.updateExpense(id, expense);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        expenseService.deleteExpense(id);
        return ResponseEntity.ok("Expense deleted with id: " + id);
    }

    // GET by user
    @GetMapping("/user/{userId}")
    public List<Expense> getByUser(@PathVariable Long userId) {
        return expenseService.getExpensesByUser(userId);
    }
}

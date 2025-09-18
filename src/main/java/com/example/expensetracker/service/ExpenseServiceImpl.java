package com.example.expensetracker.service;

import com.example.expensetracker.exception.ResourceNotFoundException;
import com.example.expensetracker.model.Expense;
import com.example.expensetracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository repository;

    @Autowired
    public ExpenseServiceImpl(ExpenseRepository repository) {
        this.repository = repository;
    }

    @Override
    public Expense createExpense(Expense expense) {
        return repository.save(expense);
    }

    @Override
    public List<Expense> getAllExpenses() {
        return repository.findAll();
    }

    @Override
    public Expense getExpenseById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Expense not found with id " + id));
    }

    @Override
    public Expense updateExpense(Long id, Expense expense) {
        return repository.update(id, expense);
    }

    @Override
    public void deleteExpense(Long id) {
        // throw if not exists
        if (repository.findById(id).isEmpty()) {
            throw new ResourceNotFoundException("Expense not found with id " + id);
        }
        repository.deleteById(id);
    }

    @Override
    public List<Expense> getExpensesByUser(Long userId) {
        return repository.findByUserId(userId);
    }
}

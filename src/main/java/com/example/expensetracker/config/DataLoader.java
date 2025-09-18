package com.example.expensetracker.config;

import com.example.expensetracker.model.Expense;
import com.example.expensetracker.repository.ExpenseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final ExpenseRepository repository;

    public DataLoader(ExpenseRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        // add sample expenses
        repository.save(new Expense(null, 1L, "Lunch at Cafe", "Food", 150.0, LocalDate.now()));
        repository.save(new Expense(null, 1L, "Uber Ride", "Transport", 320.0, LocalDate.now()));
        repository.save(new Expense(null, 2L, "Office Supplies", "Work", 560.0, LocalDate.now()));
    }
}

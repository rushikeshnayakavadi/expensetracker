package com.example.expensetracker.repository;

import com.example.expensetracker.exception.ResourceNotFoundException;
import com.example.expensetracker.model.Expense;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class InMemoryExpenseRepository implements ExpenseRepository {

    private final Map<Long, Expense> store = new ConcurrentHashMap<>();
    private final AtomicLong idCounter = new AtomicLong(0);

    @Override
    public Expense save(Expense expense) {
        Long id = idCounter.incrementAndGet();
        expense.setId(id);
        store.put(id, expense);
        return expense;
    }

    @Override
    public List<Expense> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Optional<Expense> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public void deleteById(Long id) {
        store.remove(id);
    }

    @Override
    public List<Expense> findByUserId(Long userId) {
        return store.values().stream()
                .filter(e -> Objects.equals(e.getUserId(), userId))
                .collect(Collectors.toList());
    }

    @Override
    public Expense update(Long id, Expense expense) {
        Expense existing = store.get(id);
        if (existing == null) {
            throw new ResourceNotFoundException("Expense not found with id " + id);
        }
        // update fields (keep id same)
        existing.setAmount(expense.getAmount());
        existing.setCategory(expense.getCategory());
        existing.setDescription(expense.getDescription());
        existing.setDate(expense.getDate());
        existing.setUserId(expense.getUserId());
        store.put(id, existing);
        return existing;
    }
}

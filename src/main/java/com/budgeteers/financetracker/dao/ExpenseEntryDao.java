package com.budgeteers.financetracker.dao;

import com.budgeteers.financetracker.model.ExpenseEntry;

import java.util.List;

public interface ExpenseEntryDao {
    void save(ExpenseEntry entry);

    List<ExpenseEntry> findAll();

    void delete(String id);
}

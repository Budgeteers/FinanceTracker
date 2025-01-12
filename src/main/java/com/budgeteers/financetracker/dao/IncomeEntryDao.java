package com.budgeteers.financetracker.dao;

import com.budgeteers.financetracker.model.IncomeEntry;

import java.util.List;

public interface IncomeEntryDao {
    void save(IncomeEntry entry);

    List<IncomeEntry> findAll();

    void delete(String id);
}

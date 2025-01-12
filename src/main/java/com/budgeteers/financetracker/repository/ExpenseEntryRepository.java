package com.budgeteers.financetracker.repository;

import com.budgeteers.financetracker.repository.model.ExpenseEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseEntryRepository extends JpaRepository<ExpenseEntry, String> {
}

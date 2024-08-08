package com.budgeteers.financetracker.database.repository;

import com.budgeteers.financetracker.database.models.ExpenseEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseEntryRepository extends JpaRepository<ExpenseEntry, String> {
}

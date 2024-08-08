package com.budgeteers.financetracker.database.repository;

import com.budgeteers.financetracker.database.models.IncomeEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeEntryRepository extends JpaRepository<IncomeEntry, String> {
}

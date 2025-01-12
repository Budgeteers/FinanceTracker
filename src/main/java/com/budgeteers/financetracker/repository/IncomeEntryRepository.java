package com.budgeteers.financetracker.repository;

import com.budgeteers.financetracker.repository.model.IncomeEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeEntryRepository extends JpaRepository<IncomeEntry, String> {
}

package com.budgeteers.financetracker.database.repository;

import com.budgeteers.financetracker.services.entry.models.Entry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntryRepository extends JpaRepository<Entry, String> {
}

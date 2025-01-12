package com.budgeteers.financetracker.dao;

import com.budgeteers.financetracker.model.ExpenseEntry;
import com.budgeteers.financetracker.repository.ExpenseEntryRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExpenseEntryJpaDao implements ExpenseEntryDao {
    private final ExpenseEntryRepository expenseEntryRepository;
    public ExpenseEntryJpaDao(ExpenseEntryRepository expenseEntryRepository) {
        this.expenseEntryRepository = expenseEntryRepository;
    }

    @Override
    public void save(ExpenseEntry entry) {
        expenseEntryRepository.save(fromDomain(entry));
    }

    @Override
    public List<ExpenseEntry> findAll() {
        return expenseEntryRepository.findAll().stream().map(ExpenseEntryJpaDao::toDomain).toList();
    }

    @Override
    public void delete(String id) {
        expenseEntryRepository.deleteById(id);
    }

    private static com.budgeteers.financetracker.repository.model.ExpenseEntry fromDomain(ExpenseEntry expenseEntry) {
        return new com.budgeteers.financetracker.repository.model.ExpenseEntry(
                expenseEntry.getAmount(),
                com.budgeteers.financetracker.repository.model.ExpenseEntry.ExpenseCategory.valueOf(expenseEntry.getCategory().toString()),
                expenseEntry.getNotes()
        );
    }

    private static ExpenseEntry toDomain(com.budgeteers.financetracker.repository.model.ExpenseEntry expenseEntry) {
        return new ExpenseEntry(
                String.valueOf(expenseEntry.getId()),
                expenseEntry.getAmount(),
                ExpenseEntry.ExpenseCategory.valueOf(expenseEntry.getCategory().toString()),
                expenseEntry.getNotes()
        );
    }
}

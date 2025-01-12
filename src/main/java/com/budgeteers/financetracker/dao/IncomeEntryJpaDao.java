package com.budgeteers.financetracker.dao;

import com.budgeteers.financetracker.model.IncomeEntry;
import com.budgeteers.financetracker.repository.IncomeEntryRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class IncomeEntryJpaDao implements IncomeEntryDao{
    private final IncomeEntryRepository incomeEntryRepository;
    public IncomeEntryJpaDao(IncomeEntryRepository incomeEntryRepository) {
        this.incomeEntryRepository = incomeEntryRepository;
    }

    @Override
    public void save(IncomeEntry entry) {
        incomeEntryRepository.save(fromDomain(entry));
    }

    @Override
    public List<IncomeEntry> findAll() {
        return incomeEntryRepository.findAll().stream().map(IncomeEntryJpaDao::toDomain).toList();
    }

    @Override
    public void delete(String id) {
        incomeEntryRepository.deleteById(id);
    }

    private static com.budgeteers.financetracker.repository.model.IncomeEntry fromDomain(IncomeEntry incomeEntry) {
        return new com.budgeteers.financetracker.repository.model.IncomeEntry(
                incomeEntry.getAmount(),
                com.budgeteers.financetracker.repository.model.IncomeEntry.IncomeCategory.valueOf(incomeEntry.getCategory().toString()),
                incomeEntry.getNotes()
        );
    }

    private static IncomeEntry toDomain(com.budgeteers.financetracker.repository.model.IncomeEntry incomeEntry) {
        return new IncomeEntry(
                String.valueOf(incomeEntry.getId()),
                incomeEntry.getAmount(),
                IncomeEntry.IncomeCategory.valueOf(incomeEntry.getCategory().toString()),
                incomeEntry.getNotes()
        );
    }
}

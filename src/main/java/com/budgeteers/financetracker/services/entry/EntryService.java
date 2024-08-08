package com.budgeteers.financetracker.services.entry;

import com.budgeteers.financetracker.database.models.ExpenseEntry;
import com.budgeteers.financetracker.database.models.IncomeEntry;
import com.budgeteers.financetracker.database.repository.ExpenseEntryRepository;
import com.budgeteers.financetracker.database.repository.IncomeEntryRepository;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Getter
@Service
public class EntryService {
    private final IncomeEntryRepository incomeEntryRepository;
    private final ExpenseEntryRepository expenseEntryRepository;

    public EntryService(IncomeEntryRepository incomeEntryRepository, ExpenseEntryRepository expenseEntryRepository) {
        this.incomeEntryRepository = incomeEntryRepository;
        this.expenseEntryRepository = expenseEntryRepository;
    }

    public void addIncomeEntry(int amount, IncomeEntry.IncomeCategory incomeCategory, String notes) {
        IncomeEntry entry = new IncomeEntry(amount, incomeCategory, notes);
        incomeEntryRepository.save(entry);
    }

    public void addExpenseEntry(int amount, ExpenseEntry.ExpenseCategory expenseCategory, String notes) {
        ExpenseEntry entry = new ExpenseEntry(amount, expenseCategory, notes);
        expenseEntryRepository.save(entry);
    }

    public int getProfit() {
        int profit = 0;

        for (IncomeEntry incomeEntry : incomeEntryRepository.findAll()) {
            profit += incomeEntry.getAmount();
        }

        for (ExpenseEntry expenseEntry : expenseEntryRepository.findAll()) {
            profit -= expenseEntry.getAmount();
        }

        return profit;
    }
}

package com.budgeteers.financetracker.services.entry;

import com.budgeteers.financetracker.services.entry.models.Entry;
import com.budgeteers.financetracker.services.entry.models.ExpenseEntry;
import com.budgeteers.financetracker.services.entry.models.IncomeEntry;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EntryService {
    private final List<IncomeEntry> incomeEntries = new ArrayList<>();  // TODO: Migrate to database for persistence
    private final List<ExpenseEntry> expenseEntries = new ArrayList<>();  // TODO: Migrate to database for persistence

    public void addIncomeEntry(int amount, String incomeCategory) {
        IncomeEntry entry = new IncomeEntry(amount, IncomeEntry.IncomeCategory.valueOf(incomeCategory));
        incomeEntries.add(entry);
    }

    public void addExpenseEntry(int amount, String expenseCategory) {
        ExpenseEntry entry = new ExpenseEntry(amount, ExpenseEntry.ExpenseCategory.valueOf(expenseCategory));
        expenseEntries.add(entry);
    }

    public int getProfit() {
        int profit = 0;

        for (IncomeEntry incomeEntry : incomeEntries) {
            profit += incomeEntry.getAmount();
        }

        for (ExpenseEntry expenseEntry : expenseEntries) {
            profit -= expenseEntry.getAmount();
        }

        return profit;
    }
}

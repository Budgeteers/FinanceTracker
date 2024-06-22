package com.budgeteers.financetracker.services.entry;

import com.budgeteers.financetracker.services.entry.models.ExpenseEntry;
import com.budgeteers.financetracker.services.entry.models.IncomeEntry;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Getter
@Service
public class EntryService {
    private final List<IncomeEntry> incomeEntries = new ArrayList<>();  // TODO: Migrate to database for persistence
    private final List<ExpenseEntry> expenseEntries = new ArrayList<>();  // TODO: Migrate to database for persistence

    public void addIncomeEntry(int amount, String incomeCategory, String notes) {
        IncomeEntry entry = new IncomeEntry(amount, IncomeEntry.IncomeCategory.valueOf(incomeCategory), notes);
        incomeEntries.add(entry);
    }

    public void addExpenseEntry(int amount, String expenseCategory, String notes) {
        ExpenseEntry entry = new ExpenseEntry(amount, ExpenseEntry.ExpenseCategory.valueOf(expenseCategory), notes);
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
